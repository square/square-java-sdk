package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for RevokeTokenRequest type.
 */
public class RevokeTokenRequest {

    /**
     * Initialization constructor.
     * @param clientId
     * @param accessToken
     * @param merchantId
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(clientId, accessToken, merchantId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RevokeTokenRequest)) {
            return false;
        }
        RevokeTokenRequest revokeTokenRequest = (RevokeTokenRequest) obj;
        return Objects.equals(clientId, revokeTokenRequest.clientId) &&
            Objects.equals(accessToken, revokeTokenRequest.accessToken) &&
            Objects.equals(merchantId, revokeTokenRequest.merchantId);
    }

    /**
     * Builds a new {@link RevokeTokenRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RevokeTokenRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .clientId(getClientId())
            .accessToken(getAccessToken())
            .merchantId(getMerchantId());
            return builder;
    }

    /**
     * Class to build instances of {@link RevokeTokenRequest}
     */
    public static class Builder {
        private String clientId;
        private String accessToken;
        private String merchantId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for clientId
         * @param clientId
         * @return Builder
         */
        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        /**
         * Setter for accessToken
         * @param accessToken
         * @return Builder
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }
        /**
         * Setter for merchantId
         * @param merchantId
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        /**
         * Builds a new {@link RevokeTokenRequest} object using the set fields.
         * @return {@link RevokeTokenRequest}
         */
        public RevokeTokenRequest build() {
            return new RevokeTokenRequest(clientId,
                accessToken,
                merchantId);
        }
    }
}
