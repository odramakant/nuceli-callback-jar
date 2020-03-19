package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayloadModel {
  @JsonProperty("payload")
  private String payload;


  public static final class RequestBodyModelBuilder {
    private String payload;

    private RequestBodyModelBuilder() {
    }

    public static RequestBodyModelBuilder newBuilder() {
      return new RequestBodyModelBuilder();
    }

    public RequestBodyModelBuilder withPayload(String payload) {
      this.payload = payload;
      return this;
    }

    public PayloadModel build() {
      PayloadModel payloadModel = new PayloadModel();
      payloadModel.payload = this.payload;
      return payloadModel;
    }
  }
}
