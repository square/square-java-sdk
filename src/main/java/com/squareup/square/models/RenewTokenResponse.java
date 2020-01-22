package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RenewTokenResponse type.
 */
public class RenewTokenResponse {

    /**
     * Initialization constructor.
     * @param accessToken
     * @param tokenType
     * @param expiresAt
     * @param merchantId
     * @param subscriptionId
     * @param planId
     */
    @JsonCreator
    public RenewTokenResponse(
            @JsonProperty("access_token") String accessToken,
            @JsonProperty("token_type") String tokenType,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("subscription_id") String subscriptionId,
            @JsonProperty("plan_id") String planId) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresAt = expiresAt;
        this.merchantId = merchantId;
        this.subscriptionId = subscriptionId;
        this.planId = planId;
    }

    private HttpContext httpContext;
    private final String accessToken;
    private final String tokenType;
    private final String expiresAt;
    private final String merchantId;
    private final String subscriptionId;
    private final String planId;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for AccessToken.
     * The renewed access token.
     * This value might be different from the `access_token` you provided in your request.
     * You provide this token in a header with every request to Connect API endpoints.
     * See [Request and response headers](https://developer.squareup.com/docs/api/connect/v2/#requestandresponseheaders) for the format of this header.
     */
    @JsonGetter("access_token")
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Getter for TokenType.
     * This value is always _bearer_.
     */
    @JsonGetter("token_type")
    public String getTokenType() {
        return this.tokenType;
    }

    /**
     * Getter for ExpiresAt.
     * The date when access_token expires, in [ISO 8601](http://www.iso.org/iso/home/standards/iso8601.htm) format.
     */
    @JsonGetter("expires_at")
    public String getExpiresAt() {
        return this.expiresAt;
    }

    /**
     * Getter for MerchantId.
     * The ID of the authorizing merchant's business.
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() {
        return this.merchantId;
    }

    /**
     * Getter for SubscriptionId.
     * __LEGACY FIELD__. The ID of the merchant subscription associated with
     * the authorization. Only present if the merchant signed up for a subscription
     * during authorization..
     */
    @JsonGetter("subscription_id")
    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Getter for PlanId.
     * __LEGACY FIELD__. The ID of the subscription plan the merchant signed
     * up for. Only present if the merchant signed up for a subscription during
     * authorization.
     */
    @JsonGetter("plan_id")
    public String getPlanId() {
        return this.planId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType, expiresAt, merchantId, subscriptionId, planId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RenewTokenResponse)) {
            return false;
        }
        RenewTokenResponse renewTokenResponse = (RenewTokenResponse) obj;
        return Objects.equals(accessToken, renewTokenResponse.accessToken) &&
            Objects.equals(tokenType, renewTokenResponse.tokenType) &&
            Objects.equals(expiresAt, renewTokenResponse.expiresAt) &&
            Objects.equals(merchantId, renewTokenResponse.merchantId) &&
            Objects.equals(subscriptionId, renewTokenResponse.subscriptionId) &&
            Objects.equals(planId, renewTokenResponse.planId);
    }

    /**
     * Builds a new {@link RenewTokenResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RenewTokenResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .accessToken(getAccessToken())
            .tokenType(getTokenType())
            .expiresAt(getExpiresAt())
            .merchantId(getMerchantId())
            .subscriptionId(getSubscriptionId())
            .planId(getPlanId());
            return builder;
    }

    /**
     * Class to build instances of {@link RenewTokenResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String accessToken;
        private String tokenType;
        private String expiresAt;
        private String merchantId;
        private String subscriptionId;
        private String planId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
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
         * Setter for tokenType
         * @param tokenType
         * @return Builder
         */
        public Builder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }
        /**
         * Setter for expiresAt
         * @param expiresAt
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
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
         * Setter for subscriptionId
         * @param subscriptionId
         * @return Builder
         */
        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }
        /**
         * Setter for planId
         * @param planId
         * @return Builder
         */
        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        /**
         * Builds a new {@link RenewTokenResponse} object using the set fields.
         * @return {@link RenewTokenResponse}
         */
        public RenewTokenResponse build() {
            RenewTokenResponse model = new RenewTokenResponse(accessToken,
                tokenType,
                expiresAt,
                merchantId,
                subscriptionId,
                planId);
            model.httpContext = httpContext;
            return model;
        }
    }
}
