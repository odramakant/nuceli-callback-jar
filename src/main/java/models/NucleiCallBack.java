package models;

public class NucleiCallBack {
  private RequestBodyModel requestBodyModel;
  private String url;
  private String partnerKey;
  private String providerKey;
  private String partnerSecret;


  public RequestBodyModel getRequestBodyModel() {
    return requestBodyModel;
  }

  public void setRequestBodyModel(final RequestBodyModel requestBodyModel) {
    this.requestBodyModel = requestBodyModel;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public String getPartnerKey() {
    return partnerKey;
  }

  public void setPartnerKey(final String partnerKey) {
    this.partnerKey = partnerKey;
  }

  public String getProviderKey() {
    return providerKey;
  }

  public void setProviderKey(final String providerKey) {
    this.providerKey = providerKey;
  }

  public String getPartnerSecret() {
    return partnerSecret;
  }

  public void setPartnerSecret(final String partnerSecret) {
    this.partnerSecret = partnerSecret;
  }


  public static final class NucleiCallBackBuilder {
    private RequestBodyModel requestBodyModel;
    private String url;
    private String partnerKey;
    private String providerKey;
    private String partnerSecret;

    private NucleiCallBackBuilder() {
    }

    public static NucleiCallBackBuilder newBuilder() {
      return new NucleiCallBackBuilder();
    }

    public NucleiCallBackBuilder withRequestBodyModel(RequestBodyModel requestBodyModel) {
      this.requestBodyModel = requestBodyModel;
      return this;
    }

    public NucleiCallBackBuilder withUrl(String url) {
      this.url = url;
      return this;
    }

    public NucleiCallBackBuilder withPartnerKey(String partnerKey) {
      this.partnerKey = partnerKey;
      return this;
    }

    public NucleiCallBackBuilder withProviderKey(String providerKey) {
      this.providerKey = providerKey;
      return this;
    }

    public NucleiCallBackBuilder withPartnerSecret(String partnerSecret) {
      this.partnerSecret = partnerSecret;
      return this;
    }

    public NucleiCallBack build() {
      NucleiCallBack nucleiCallBack = new NucleiCallBack();
      nucleiCallBack.setRequestBodyModel(requestBodyModel);
      nucleiCallBack.setUrl(url);
      nucleiCallBack.setPartnerKey(partnerKey);
      nucleiCallBack.setProviderKey(providerKey);
      nucleiCallBack.setPartnerSecret(partnerSecret);
      return nucleiCallBack;
    }
  }
}
