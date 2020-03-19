package utils;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import exception.NucliCallbackExeption;

public final class EncryptionUtils {
  /**
   * Encrypt string.
   *
   * @param secret    the secret
   * @param algorithm the algorithm
   * @param data      the data
   * @return the string
   */
  public static String encrypt(final String secret, final String algorithm, final String data) {
    try {
      final Cipher cipher = getCipher(secret, algorithm, Cipher.ENCRYPT_MODE);
      return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    } catch (final Exception exception) {
      throw new NucliCallbackExeption("Error in encrypting data: ", exception);
    }
  }

  /**
   * Decrypt string.
   *
   * @param secret    the secret
   * @param algorithm the algorithm
   * @param data      the data
   * @return the string
   */
  public static String decrypt(final String secret, final String algorithm, final String data) {
    try {
      final byte[] decodedValue = Base64.getDecoder().decode(data.getBytes());
      final Cipher cipher = getCipher(secret, algorithm, Cipher.DECRYPT_MODE);
      return new String(cipher.doFinal(decodedValue));
    } catch (final Exception exception) {
      throw new NucliCallbackExeption("Error in decrypting data: ", exception);
    }
  }

  /**
   * Gets cipher.
   *
   * @param secret     the secret
   * @param algorithm  the algorithm
   * @param cipherMode the cipher mode
   * @return the cipher
   */
  private static Cipher getCipher(final String secret, final String algorithm, final int cipherMode) {
    try {
      final Cipher cipher = Cipher.getInstance(algorithm);
      final Key key = new SecretKeySpec(secret.getBytes(), algorithm);
      cipher.init(cipherMode, key);
      return cipher;
    } catch (final Exception exception) {
      throw new NucliCallbackExeption("Error in encryption cipher", exception);
    }
  }
}
