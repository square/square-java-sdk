package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RenewTokenResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType, expiresAt, merchantId, subscriptionId, planId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RenewTokenResponse)) {
            return false;
        }
        RenewTokenResponse renewTokenResponse = (RenewTokenResponse) o;
        return Objects.equals(accessToken, renewTokenResponse.accessToken) &&
            Objects.equals(tokenType, renewTokenResponse.tokenType) &&
            Objects.equals(expiresAt, renewTokenResponse.expiresAt) &&
            Objects.equals(merchantId, renewTokenResponse.merchantId) &&
            Objects.equals(subscriptionId, renewTokenResponse.subscriptionId) &&
            Objects.equals(planId, renewTokenResponse.planId);
    }


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

    public static class Builder {
        private HttpContext httpContext;
        private String accessToken;
        private String tokenType;
        private String expiresAt;
        private String merchantId;
        private String subscriptionId;
        private String planId;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder accessToken(String value) {
            accessToken = value;
            return this;
        }
        public Builder tokenType(String value) {
            tokenType = value;
            return this;
        }
        public Builder expiresAt(String value) {
            expiresAt = value;
            return this;
        }
        public Builder merchantId(String value) {
            merchantId = value;
            return this;
        }
        public Builder subscriptionId(String value) {
            subscriptionId = value;
            return this;
        }
        public Builder planId(String value) {
            planId = value;
            return this;
        }

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
