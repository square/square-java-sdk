
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ObtainTokenResponse type.
 */
public class ObtainTokenResponse {
    private HttpContext httpContext;
    private final String accessToken;
    private final String tokenType;
    private final String expiresAt;
    private final String merchantId;
    private final String subscriptionId;
    private final String planId;
    private final String idToken;
    private final String refreshToken;
    private final Boolean shortLived;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  accessToken  String value for accessToken.
     * @param  tokenType  String value for tokenType.
     * @param  expiresAt  String value for expiresAt.
     * @param  merchantId  String value for merchantId.
     * @param  subscriptionId  String value for subscriptionId.
     * @param  planId  String value for planId.
     * @param  idToken  String value for idToken.
     * @param  refreshToken  String value for refreshToken.
     * @param  shortLived  Boolean value for shortLived.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ObtainTokenResponse(
            @JsonProperty("access_token") String accessToken,
            @JsonProperty("token_type") String tokenType,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("subscription_id") String subscriptionId,
            @JsonProperty("plan_id") String planId,
            @JsonProperty("id_token") String idToken,
            @JsonProperty("refresh_token") String refreshToken,
            @JsonProperty("short_lived") Boolean shortLived,
            @JsonProperty("errors") List<Error> errors) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresAt = expiresAt;
        this.merchantId = merchantId;
        this.subscriptionId = subscriptionId;
        this.planId = planId;
        this.idToken = idToken;
        this.refreshToken = refreshToken;
        this.shortLived = shortLived;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for AccessToken.
     * A valid OAuth access token. OAuth access tokens are 64 bytes long. Provide the access token
     * in a header with every request to Connect API endpoints. For more information, see [OAuth
     * API: Walkthrough](https://developer.squareup.com/docs/oauth-api/walkthrough).
     * @return Returns the String
     */
    @JsonGetter("access_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Getter for TokenType.
     * This value is always _bearer_.
     * @return Returns the String
     */
    @JsonGetter("token_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Getter for ExpiresAt.
     * The date when the `access_token` expires, in [ISO
     * 8601](http://www.iso.org/iso/home/standards/iso8601.htm) format.
     * @return Returns the String
     */
    @JsonGetter("expires_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     * Getter for MerchantId.
     * The ID of the authorizing merchant's business.
     * @return Returns the String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Getter for SubscriptionId.
     * __LEGACY FIELD__. The ID of a subscription plan the merchant signed up for. The ID is only
     * present if the merchant signed up for a subscription plan during authorization.
     * @return Returns the String
     */
    @JsonGetter("subscription_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Getter for PlanId.
     * __LEGACY FIELD__. The ID of the subscription plan the merchant signed up for. The ID is only
     * present if the merchant signed up for a subscription plan during authorization.
     * @return Returns the String
     */
    @JsonGetter("plan_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlanId() {
        return planId;
    }

    /**
     * Getter for IdToken.
     * The OpenID token belonging to this person. This token is only present if the OPENID scope is
     * included in the authorization request.
     * @return Returns the String
     */
    @JsonGetter("id_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdToken() {
        return idToken;
    }

    /**
     * Getter for RefreshToken.
     * A refresh token. OAuth refresh tokens are 64 bytes long. For more information, see [Refresh,
     * Revoke, and Limit the Scope of OAuth
     * Tokens](https://developer.squareup.com/docs/oauth-api/refresh-revoke-limit-scope).
     * @return Returns the String
     */
    @JsonGetter("refresh_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Getter for ShortLived.
     * A Boolean indicating that the access token is a short-lived access token. The short-lived
     * access token returned in the response expires in 24 hours.
     * @return Returns the Boolean
     */
    @JsonGetter("short_lived")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getShortLived() {
        return shortLived;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType, expiresAt, merchantId, subscriptionId, planId,
                idToken, refreshToken, shortLived, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObtainTokenResponse)) {
            return false;
        }
        ObtainTokenResponse other = (ObtainTokenResponse) obj;
        return Objects.equals(accessToken, other.accessToken)
            && Objects.equals(tokenType, other.tokenType)
            && Objects.equals(expiresAt, other.expiresAt)
            && Objects.equals(merchantId, other.merchantId)
            && Objects.equals(subscriptionId, other.subscriptionId)
            && Objects.equals(planId, other.planId)
            && Objects.equals(idToken, other.idToken)
            && Objects.equals(refreshToken, other.refreshToken)
            && Objects.equals(shortLived, other.shortLived)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ObtainTokenResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ObtainTokenResponse [" + "accessToken=" + accessToken + ", tokenType=" + tokenType
                + ", expiresAt=" + expiresAt + ", merchantId=" + merchantId + ", subscriptionId="
                + subscriptionId + ", planId=" + planId + ", idToken=" + idToken + ", refreshToken="
                + refreshToken + ", shortLived=" + shortLived + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ObtainTokenResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ObtainTokenResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .accessToken(getAccessToken())
                .tokenType(getTokenType())
                .expiresAt(getExpiresAt())
                .merchantId(getMerchantId())
                .subscriptionId(getSubscriptionId())
                .planId(getPlanId())
                .idToken(getIdToken())
                .refreshToken(getRefreshToken())
                .shortLived(getShortLived())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ObtainTokenResponse}.
     */
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
        private Boolean shortLived;
        private List<Error> errors;



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
         * Setter for idToken.
         * @param  idToken  String value for idToken.
         * @return Builder
         */
        public Builder idToken(String idToken) {
            this.idToken = idToken;
            return this;
        }

        /**
         * Setter for refreshToken.
         * @param  refreshToken  String value for refreshToken.
         * @return Builder
         */
        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        /**
         * Setter for shortLived.
         * @param  shortLived  Boolean value for shortLived.
         * @return Builder
         */
        public Builder shortLived(Boolean shortLived) {
            this.shortLived = shortLived;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link ObtainTokenResponse} object using the set fields.
         * @return {@link ObtainTokenResponse}
         */
        public ObtainTokenResponse build() {
            ObtainTokenResponse model =
                    new ObtainTokenResponse(accessToken, tokenType, expiresAt, merchantId,
                            subscriptionId, planId, idToken, refreshToken, shortLived, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
