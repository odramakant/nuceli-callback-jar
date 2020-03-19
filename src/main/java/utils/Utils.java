package utils;

import java.security.SignatureException;

import exception.NucliCallbackExeption;


public class Utils {

  public static String getCheckSum(final String requestBody, final String secretKey) {

    try {
      return SignatureUtils.calculateRFC2104HMAC(requestBody, secretKey);
    } catch (SignatureException e) {
      throw new NucliCallbackExeption("Error in making signature");
    }
  }


  public static String getPayload(final String jsonBody, final String secretKey) {
    return EncryptionUtils.encrypt(secretKey, "AES", jsonBody);
  }

}
