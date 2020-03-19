package utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import exception.NucliCallbackExeption;

/**
 * The type Signature utils.
 */
public class SignatureUtils {
  /**
   * The constant HMAC_SHA256_ALGORITHM.
   */
  private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

  /**
   * Calculate rfc 2104 hmac string.
   *
   * @param data   the data
   * @param secret the secret
   * @return the string
   */
  public static String calculateRFC2104HMAC(String data, String secret)
      throws java.security.SignatureException {
    String result;
    try {

      // get an hmac_sha256 key from the raw secret bytes
      SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(), HMAC_SHA256_ALGORITHM);

      // get an hmac_sha256 Mac instance and initialize with the signing key
      Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
      mac.init(signingKey);

      // compute the hmac on input data bytes
      byte[] rawHmac = mac.doFinal(data.getBytes());

      // base64-encode the hmac
      result = DatatypeConverter.printHexBinary(rawHmac).toLowerCase();

    } catch (Exception e) {
      throw new NucliCallbackExeption("Failed to generate HMAC : " + e.getMessage());
    }
    return result;
  }
}

