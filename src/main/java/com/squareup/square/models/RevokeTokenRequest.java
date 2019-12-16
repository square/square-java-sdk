package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class RevokeTokenRequest {

    @JsonCreator
    public RevokeTokenRequest(
            @JsonProperty("client_id") String clientId,
            @JsonProperty("access_token") String accessToken,
            @JsonProperty("merchant_id") String merchantId) {
        this.clientId = clientId;
        this.accessToken = accessToken;
        this.merchantId = merchantId;
    }

    private final String clientId;
    private final String accessToken;
    private final String merchantId;

    @Override
    public int hashCode() {
        return Objects.hash(clientId, accessToken, merchantId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RevokeTokenRequest)) {
            return false;
        }
        RevokeTokenRequest revokeTokenRequest = (RevokeTokenRequest) o;
        return Objects.equals(clientId, revokeTokenRequest.clientId) &&
            Objects.equals(accessToken, revokeTokenRequest.accessToken) &&
            Objects.equals(merchantId, revokeTokenRequest.merchantId);
    }

    /**
     * Getter for ClientId.
     * The Square issued ID for your application, available from the
     * [application dashboard](https://connect.squareup.com/apps).
     */
    @JsonGetter("client_id")
    public String getClientId() { 
        return this.clientId;
    }

    /**
     * Getter for AccessToken.
     * The access token of the merchant whose token you want to revoke.
     * Do not provide a value for merchant_id if you provide this parameter.
     */
    @JsonGetter("access_token")
    public String getAccessToken() { 
        return this.accessToken;
    }

    /**
     * Getter for MerchantId.
     * The ID of the merchant whose token you want to revoke.
     * Do not provide a value for access_token if you provide this parameter.
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() { 
        return this.merchantId;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .clientId(getClientId())
            .accessToken(getAccessToken())
            .merchantId(getMerchantId());
            return builder;
    }

    public static class Builder {
        private String clientId;
        private String accessToken;
        private String merchantId;

        public Builder() { }

        public Builder clientId(String value) {
            clientId = value;
            return this;
        }
        public Builder accessToken(String value) {
            accessToken = value;
            return this;
        }
        public Builder merchantId(String value) {
            merchantId = value;
            return this;
        }

        public RevokeTokenRequest build() {
            return new RevokeTokenRequest(clientId,
                accessToken,
                merchantId);
        }
    }
}
