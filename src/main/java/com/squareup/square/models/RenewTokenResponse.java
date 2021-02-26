
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.Objects;

/**
 * This is a model class for RenewTokenResponse type.
 */
public class RenewTokenResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String accessToken;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String tokenType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String expiresAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String merchantId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String subscriptionId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String planId;

    /**
     * Initialization constructor.
     * @param  accessToken  String value for accessToken.
     * @param  tokenType  String value for tokenType.
     * @param  expiresAt  String value for expiresAt.
     * @param  merchantId  String value for merchantId.
     * @param  subscriptionId  String value for subscriptionId.
     * @param  planId  String value for planId.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for AccessToken.
     * The renewed access token. This value might be different from the `access_token` you provided
     * in your request. You provide this token in a header with every request to Connect API
     * endpoints. See [Request and response
     * headers](https://developer.squareup.com/docs/api/connect/v2/#requestandresponseheaders) for
     * the format of this header.
     * @return Returns the String
     */
    @JsonGetter("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Getter for TokenType.
     * This value is always _bearer_.
     * @return Returns the String
     */
    @JsonGetter("token_type")
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Getter for ExpiresAt.
     * The date when access_token expires, in [ISO
     * 8601](http://www.iso.org/iso/home/standards/iso8601.htm) format.
     * @return Returns the String
     */
    @JsonGetter("expires_at")
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     * Getter for MerchantId.
     * The ID of the authorizing merchant's business.
     * @return Returns the String
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Getter for SubscriptionId.
     * __LEGACY FIELD__. The ID of the merchant subscription associated with the authorization. Only
     * present if the merchant signed up for a subscription during authorization..
     * @return Returns the String
     */
    @JsonGetter("subscription_id")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Getter for PlanId.
     * __LEGACY FIELD__. The ID of the subscription plan the merchant signed up for. Only present if
     * the merchant signed up for a subscription during authorization.
     * @return Returns the String
     */
    @JsonGetter("plan_id")
    public String getPlanId() {
        return planId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType, expiresAt, merchantId, subscriptionId,
                planId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RenewTokenResponse)) {
            return false;
        }
        RenewTokenResponse other = (RenewTokenResponse) obj;
        return Objects.equals(accessToken, other.accessToken)
            && Objects.equals(tokenType, other.tokenType)
            && Objects.equals(expiresAt, other.expiresAt)
            && Objects.equals(merchantId, other.merchantId)
            && Objects.equals(subscriptionId, other.subscriptionId)
            && Objects.equals(planId, other.planId);
    }

    /**
     * Converts this RenewTokenResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RenewTokenResponse [" + "accessToken=" + accessToken + ", tokenType=" + tokenType
                + ", expiresAt=" + expiresAt + ", merchantId=" + merchantId + ", subscriptionId="
                + subscriptionId + ", planId=" + planId + "]";
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
     * Class to build instances of {@link RenewTokenResponse}.
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
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for accessToken.
         * @param  accessToken  String value for accessToken.
         * @return Builder
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * Setter for tokenType.
         * @param  tokenType  String value for tokenType.
         * @return Builder
         */
        public Builder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        /**
         * Setter for expiresAt.
         * @param  expiresAt  String value for expiresAt.
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        /**
         * Setter for subscriptionId.
         * @param  subscriptionId  String value for subscriptionId.
         * @return Builder
         */
        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        /**
         * Setter for planId.
         * @param  planId  String value for planId.
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
            RenewTokenResponse model =
                    new RenewTokenResponse(accessToken, tokenType, expiresAt, merchantId,
                            subscriptionId, planId);
            model.httpContext = httpContext;
            return model;
        }
    }
}
