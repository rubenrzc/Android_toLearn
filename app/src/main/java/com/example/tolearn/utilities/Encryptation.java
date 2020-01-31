package com.example.tolearn.utilities;

import android.util.Log;

import com.example.tolearn.interfaces.UserInterface;
import com.example.tolearn.retrofit.UserAPIClient;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 *
 * @author Andoni
 */
public class Encryptation {

    /**
     * Cipher proporciona la funcionalidad de cifrado y descifrado
     */
    private static Cipher cipher;

    private final static String CRYPTO_METHOD = "RSA";
    private final static String OPCION_RSA = "RSA/ECB/OAEPWithSHA1AndMGF1Padding";
    private static String publicKey ="";

    public static String encrypt(String messageToEncrypt) throws Exception {
        UserInterface userInterface = new UserAPIClient().getClientText();

        Call<String> call = userInterface.getPublicKey();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("encryptation","publickey lograda");
                setKey(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("encryptation","algo fue mal "+t.getMessage());
            }
        });

        KeyFactory keyFactory = KeyFactory.getInstance(CRYPTO_METHOD);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(hexStringToByteArray(publicKey));
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        cipher = Cipher.getInstance(OPCION_RSA);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypted = cipher.doFinal(messageToEncrypt.getBytes());
        return toHexadecimal(encrypted);
    }

    public static void setKey(String body) {
        Encryptation.publicKey = body;
    }
    public static String getKey(){
        return publicKey;

    }

    public static String toHexadecimal(byte[] resumen) {
        String HEX = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1) {
                HEX += "0";
            }
            HEX += h;
        }
        return HEX.toUpperCase();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}