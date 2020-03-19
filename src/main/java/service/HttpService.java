package service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

import config.HttpClient;

public class HttpService {
  private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
  Logger logger = Logger.getLogger(HttpService.class.getName());

  String post(Request request) {
    try {
      Response response = HttpClient.getHttpClient().newCall(request).execute();
      return response.body().string();
    } catch (IOException ex) {
      logger.log(Level.WARNING, ex.getMessage());
    }

    return null;
  }
}
