package config;

public class HttpClient {

  private static okhttp3.OkHttpClient okHttpClient = null;


  public static okhttp3.OkHttpClient getHttpClient() {
    if (okHttpClient == null) {
      okHttpClient = new okhttp3.OkHttpClient()
          .newBuilder()
          .build();
    }
    return okHttpClient;
  }


}
