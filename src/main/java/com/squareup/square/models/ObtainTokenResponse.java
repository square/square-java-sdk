package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ObtainTokenResponse {

    @JsonCreator
    public ObtainTokenResponse(
            @JsonProperty("access_token") String accessToken,
            @JsonProperty("token_type") String tokenType,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("subscription_id") String subscriptionId,
            @JsonProperty("plan_id") String planId,
            @JsonProperty("id_token") String idToken,
            @JsonProperty("refresh_token") String refreshToken) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresAt = expiresAt;
        this.merchantId = merchantId;
        this.subscriptionId = subscriptionId;
        this.planId = planId;
        this.idToken = idToken;
        this.refreshToken = refreshToken;
    }

    private HttpContext httpContext;
    private final String accessToken;
    private final String tokenType;
    private final String expiresAt;
    private final String merchantId;
    private final String subscriptionId;
    private final String planId;
    private final String idToken;
    private final String refreshToken;

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType, expiresAt, merchantId, subscriptionId, planId, idToken, refreshToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ObtainTokenResponse)) {
            return false;
        }
        ObtainTokenResponse obtainTokenResponse = (ObtainTokenResponse) o;
        return Objects.equals(accessToken, obtainTokenResponse.accessToken) &&
            Objects.equals(tokenType, obtainTokenResponse.tokenType) &&
            Objects.equals(expiresAt, obtainTokenResponse.expiresAt) &&
            Objects.equals(merchantId, obtainTokenResponse.merchantId) &&
            Objects.equals(subscriptionId, obtainTokenResponse.subscriptionId) &&
            Objects.equals(planId, obtainTokenResponse.planId) &&
            Objects.equals(idToken, obtainTokenResponse.idToken) &&
            Objects.equals(refreshToken, obtainTokenResponse.refreshToken);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for AccessToken.
     * A valid OAuth access token. OAuth access tokens are 64 bytes long.
     * Provide the access token in a header with every request to Connect API
     * endpoints. See the [Build with OAuth](https://developer.squareup.com/docs/authz/oauth/build-with-the-api) guide
     * for more information.
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
     * __LEGACY FIELD__. The ID of a subscription plan the merchant signed up
     * for. Only present if the merchant signed up for a subscription during authorization.
     */
    @JsonGetter("subscription_id")
    public String getSubscriptionId() { 
        return this.subscriptionId;
    }

    /**
     * Getter for PlanId.
     * T__LEGACY FIELD__. The ID of the subscription plan the merchant signed
     * up for. Only present if the merchant signed up for a subscription during
     * authorization.
     */
    @JsonGetter("plan_id")
    public String getPlanId() { 
        return this.planId;
    }

    /**
     * Getter for IdToken.
     * Then OpenID token belonging to this this person. Only present if the
     * OPENID scope is included in the authorize request.
     */
    @JsonGetter("id_token")
    public String getIdToken() { 
        return this.idToken;
    }

    /**
     * Getter for RefreshToken.
     * A refresh token.
     * For more information, see [OAuth access token management](https://developer.squareup.com/docs/authz/oauth/how-it-works#oauth-access-token-management).
     */
    @JsonGetter("refresh_token")
    public String getRefreshToken() { 
        return this.refreshToken;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .accessToken(getAccessToken())
            .tokenType(getTokenType())
            .expiresAt(getExpiresAt())
            .merchantId(getMerchantId())
            .subscriptionId(getSubscriptionId())
            .planId(getPlanId())
            .idToken(getIdToken())
            .refreshToken(getRefreshToken());
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
        private String idToken;
        private String refreshToken;

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
        public Builder idToken(String value) {
            idToken = value;
            return this;
        }
        public Builder refreshToken(String value) {
            refreshToken = value;
            return this;
        }

        public ObtainTokenResponse build() {
            ObtainTokenResponse model = new ObtainTokenResponse(accessToken,
                tokenType,
                expiresAt,
                merchantId,
                subscriptionId,
                planId,
                idToken,
                refreshToken);
            model.httpContext = httpContext;
            return model;
        }
    }
}
