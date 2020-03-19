package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class RequestBodyModel implements Serializable {

  @JsonProperty("status")
  private String status;
  @JsonProperty("amount")
  private long amount;
  @JsonProperty("transaction_id")
  private String transactionId;
  @JsonProperty("partner_transaction_id")
  private String partnerTransactionId;
  @JsonProperty("created_at")
  private long createdAt;
  @JsonProperty("error_message")
  private String errorMessage;
  @JsonProperty("payment_mode")
  private String paymentMode;


  public static final class CallBackModelBuilder {
    private String status;
    private long amount;
    private String transactionId;
    private String partnerTransactionId;
    private long createdAt;
    private String errorMessage;
    private String paymentMode;

    private CallBackModelBuilder() {
    }

    public static CallBackModelBuilder newCallBackModelBuilder() {
      return new CallBackModelBuilder();
    }

    public CallBackModelBuilder withStatus(String status) {
      this.status = status;
      return this;
    }

    public CallBackModelBuilder withAmount(long amount) {
      this.amount = amount;
      return this;
    }

    public CallBackModelBuilder withTransactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    public CallBackModelBuilder withPartnerTransactionId(String partnerTransactionId) {
      this.partnerTransactionId = partnerTransactionId;
      return this;
    }

    public CallBackModelBuilder withCreatedAt(long createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public CallBackModelBuilder withErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
    }

    public CallBackModelBuilder withPaymentMode(String paymentMode) {
      this.paymentMode = paymentMode;
      return this;
    }

    public RequestBodyModel build() {
      RequestBodyModel requestBodyModel = new RequestBodyModel();
      requestBodyModel.partnerTransactionId = this.partnerTransactionId;
      requestBodyModel.errorMessage = this.errorMessage;
      requestBodyModel.status = this.status;
      requestBodyModel.transactionId = this.transactionId;
      requestBodyModel.paymentMode = this.paymentMode;
      requestBodyModel.amount = this.amount;
      requestBodyModel.createdAt = this.createdAt;
      return requestBodyModel;
    }
  }
}


