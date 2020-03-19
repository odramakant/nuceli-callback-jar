package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.NucliCallbackExeption;

/**
 * The type Json utils.
 */
public final class JsonUtils {

  /**
   * The constant OBJECT_MAPPER.
   */
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  /**
   * To string from object string.
   *
   * @param object the object
   * @return the string
   */
  public static String toStringFromObject(final Object object) {
    try {
      return OBJECT_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new NucliCallbackExeption("Error in converting object to string ");
    }
  }

  private JsonUtils() {
    //empty
  }
}
