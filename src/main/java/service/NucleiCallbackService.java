package service;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import models.NucleiCallBack;
import models.PayloadModel;
import utils.JsonUtils;
import utils.Utils;

public class NucleiCallbackService {

  private String xBodySignature;
  private String partnerKey;
  private String providerKey;
  private String requestBody;
  private String url;
  private MediaType mediaType;


  public String initiateCallback(final NucleiCallBack nucleiCallBack) {

    final String payload = Utils.getPayload(JsonUtils
            .toStringFromObject(nucleiCallBack.getRequestBodyModel()),
        nucleiCallBack.getPartnerSecret());

    PayloadModel payloadModel =
        PayloadModel.RequestBodyModelBuilder
            .newBuilder()
            .withPayload(payload)
            .build();

    final String requestBody = JsonUtils.toStringFromObject(payloadModel);

    final String checkSum = Utils.getCheckSum(requestBody, nucleiCallBack.getPartnerSecret());

    return NucleiCallbackService
        .NucleiCallbackServiceBuilder
        .newBuilder()
        .withPartnerKey(nucleiCallBack.getPartnerKey())
        .withProviderKey(nucleiCallBack.getProviderKey())
        .withRequestBody(requestBody)
        .withXBodySignature(checkSum)
        .withUrl(nucleiCallBack.getUrl())
        .withMediaType(MediaType.get("application/json; charset=utf-8"))
        .build()
        .execute();
  }

  private String execute() {
    RequestBody body = RequestBody.create(this.mediaType, this.requestBody);
    Request request = new Request.Builder()
        .url(this.url)
        .post(body)
        .addHeader("X-Body-Signature", this.xBodySignature)
        .addHeader("partner-key", this.partnerKey)
        .addHeader("provider-key", this.providerKey)
        .build();

    return new HttpService().post(request);
  }

  private static final class NucleiCallbackServiceBuilder {
    private String xBodySignature;
    private String partnerKey;
    private String providerKey;
    private String requestBody;
    private String url;
    private MediaType mediaType;

    private NucleiCallbackServiceBuilder() {
    }

    private static NucleiCallbackServiceBuilder newBuilder() {
      return new NucleiCallbackServiceBuilder();
    }

    private NucleiCallbackServiceBuilder withXBodySignature(String xBodySignature) {
      this.xBodySignature = xBodySignature;
      return this;
    }

    private NucleiCallbackServiceBuilder withPartnerKey(String partnerKey) {
      this.partnerKey = partnerKey;
      return this;
    }

    private NucleiCallbackServiceBuilder withProviderKey(String providerKey) {
      this.providerKey = providerKey;
      return this;
    }

    private NucleiCallbackServiceBuilder withRequestBody(String requestBody) {
      this.requestBody = requestBody;
      return this;
    }

    private NucleiCallbackServiceBuilder withUrl(String url) {
      this.url = url;
      return this;
    }

    private NucleiCallbackServiceBuilder withMediaType(MediaType mediaType) {
      this.mediaType = mediaType;
      return this;
    }

    private NucleiCallbackService build() {
      NucleiCallbackService nucleiCallbackService = new NucleiCallbackService();
      nucleiCallbackService.partnerKey = this.partnerKey;
      nucleiCallbackService.providerKey = this.providerKey;
      nucleiCallbackService.url = this.url;
      nucleiCallbackService.xBodySignature = this.xBodySignature;
      nucleiCallbackService.mediaType = this.mediaType;
      nucleiCallbackService.requestBody = this.requestBody;
      return nucleiCallbackService;
    }
  }


  /**
   *
   * How to use it , please refer below code.
   *
   *
   */


  /*    String URL = "https://callbackpreprod.gonuclei.com/api/payment-async/v1/callback";

      RequestBodyModel requestBodyModel = RequestBodyModel
          .CallBackModelBuilder
          .newCallBackModelBuilder()
          .withAmount(10)
          .withCreatedAt(System.currentTimeMillis())
          .withErrorMessage("NO ERROR")
          .withPartnerTransactionId("Bank reference id")
          .withTransactionId("Nuclei Transaction Id")
          .withStatus("SUCCESS")
          .withPaymentMode("PAYMENT MODE")
          .build();

      NucleiCallBack nucleiCallBack = NucleiCallBack.NucleiCallBackBuilder
          .newBuilder()
          .withPartnerKey("Partner Key")
          .withPartnerSecret("Partner Secret")
          .withProviderKey("NUCLEI")
          .withRequestBodyModel(requestBodyModel)
          .withUrl(URL)
          .build();

        return new NucleiCallbackService().initiateCallback(nucleiCallBack);*/

}
