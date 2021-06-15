
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ObtainTokenRequest type.
 */
public class ObtainTokenRequest {
    private final String clientId;
    private final String clientSecret;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String redirectUri;
    private final String grantType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String refreshToken;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String migrationToken;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> scopes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean shortLived;

    /**
     * Initialization constructor.
     * @param  clientId  String value for clientId.
     * @param  clientSecret  String value for clientSecret.
     * @param  grantType  String value for grantType.
     * @param  code  String value for code.
     * @param  redirectUri  String value for redirectUri.
     * @param  refreshToken  String value for refreshToken.
     * @param  migrationToken  String value for migrationToken.
     * @param  scopes  List of String value for scopes.
     * @param  shortLived  Boolean value for shortLived.
     */
    @JsonCreator
    public ObtainTokenRequest(
            @JsonProperty("client_id") String clientId,
            @JsonProperty("client_secret") String clientSecret,
            @JsonProperty("grant_type") String grantType,
            @JsonProperty("code") String code,
            @JsonProperty("redirect_uri") String redirectUri,
            @JsonProperty("refresh_token") String refreshToken,
            @JsonProperty("migration_token") String migrationToken,
            @JsonProperty("scopes") List<String> scopes,
            @JsonProperty("short_lived") Boolean shortLived) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.redirectUri = redirectUri;
        this.grantType = grantType;
        this.refreshToken = refreshToken;
        this.migrationToken = migrationToken;
        this.scopes = scopes;
        this.shortLived = shortLived;
    }

    /**
     * Getter for ClientId.
     * The Square-issued ID of your application, available from the [developer
     * dashboard](https://developer.squareup.com/apps).
     * @return Returns the String
     */
    @JsonGetter("client_id")
    public String getClientId() {
        return clientId;
    }

    /**
     * Getter for ClientSecret.
     * The Square-issued application secret for your application, available from the [developer
     * dashboard](https://developer.squareup.com/apps).
     * @return Returns the String
     */
    @JsonGetter("client_secret")
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Getter for Code.
     * The authorization code to exchange. This is required if `grant_type` is set to
     * `authorization_code`, to indicate that the application wants to exchange an authorization
     * code for an OAuth access token.
     * @return Returns the String
     */
    @JsonGetter("code")
    public String getCode() {
        return code;
    }

    /**
     * Getter for RedirectUri.
     * The redirect URL assigned in the [developer dashboard](https://developer.squareup.com/apps).
     * @return Returns the String
     */
    @JsonGetter("redirect_uri")
    public String getRedirectUri() {
        return redirectUri;
    }

    /**
     * Getter for GrantType.
     * Specifies the method to request an OAuth access token. Valid values are:
     * `authorization_code`, `refresh_token`, and `migration_token`
     * @return Returns the String
     */
    @JsonGetter("grant_type")
    public String getGrantType() {
        return grantType;
    }

    /**
     * Getter for RefreshToken.
     * A valid refresh token for generating a new OAuth access token. A valid refresh token is
     * required if `grant_type` is set to `refresh_token` , to indicate the application wants a
     * replacement for an expired OAuth access token.
     * @return Returns the String
     */
    @JsonGetter("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Getter for MigrationToken.
     * Legacy OAuth access token obtained using a Connect API version prior to 2019-03-13. This
     * parameter is required if `grant_type` is set to `migration_token` to indicate that the
     * application wants to get a replacement OAuth access token. The response also returns a
     * refresh token. For more information, see [Migrate to Using Refresh
     * Tokens](https://developer.squareup.com/docs/oauth-api/migrate-to-refresh-tokens).
     * @return Returns the String
     */
    @JsonGetter("migration_token")
    public String getMigrationToken() {
        return migrationToken;
    }

    /**
     * Getter for Scopes.
     * A JSON list of strings representing the permissions the application is requesting. For
     * example: "`["MERCHANT_PROFILE_READ","PAYMENTS_READ","BANK_ACCOUNTS_READ"]`" The access token
     * returned in the response is granted the permissions that comprise the intersection between
     * the requested list of permissions, and those that belong to the provided refresh token.
     * @return Returns the List of String
     */
    @JsonGetter("scopes")
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * Getter for ShortLived.
     * A boolean indicating a request for a short-lived access token. The short-lived access token
     * returned in the response will expire in 24 hours.
     * @return Returns the Boolean
     */
    @JsonGetter("short_lived")
    public Boolean getShortLived() {
        return shortLived;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientSecret, code, redirectUri, grantType, refreshToken,
                migrationToken, scopes, shortLived);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObtainTokenRequest)) {
            return false;
        }
        ObtainTokenRequest other = (ObtainTokenRequest) obj;
        return Objects.equals(clientId, other.clientId)
            && Objects.equals(clientSecret, other.clientSecret)
            && Objects.equals(code, other.code)
            && Objects.equals(redirectUri, other.redirectUri)
            && Objects.equals(grantType, other.grantType)
            && Objects.equals(refreshToken, other.refreshToken)
            && Objects.equals(migrationToken, other.migrationToken)
            && Objects.equals(scopes, other.scopes)
            && Objects.equals(shortLived, other.shortLived);
    }

    /**
     * Converts this ObtainTokenRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ObtainTokenRequest [" + "clientId=" + clientId + ", clientSecret=" + clientSecret
                + ", grantType=" + grantType + ", code=" + code + ", redirectUri=" + redirectUri
                + ", refreshToken=" + refreshToken + ", migrationToken=" + migrationToken
                + ", scopes=" + scopes + ", shortLived=" + shortLived + "]";
    }

    /**
     * Builds a new {@link ObtainTokenRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ObtainTokenRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(clientId, clientSecret, grantType)
                .code(getCode())
                .redirectUri(getRedirectUri())
                .refreshToken(getRefreshToken())
                .migrationToken(getMigrationToken())
                .scopes(getScopes())
                .shortLived(getShortLived());
        return builder;
    }

    /**
     * Class to build instances of {@link ObtainTokenRequest}.
     */
    public static class Builder {
        private String clientId;
        private String clientSecret;
        private String grantType;
        private String code;
        private String redirectUri;
        private String refreshToken;
        private String migrationToken;
        private List<String> scopes;
        private Boolean shortLived;

        /**
         * Initialization constructor.
         * @param  clientId  String value for clientId.
         * @param  clientSecret  String value for clientSecret.
         * @param  grantType  String value for grantType.
         */
        public Builder(String clientId, String clientSecret, String grantType) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.grantType = grantType;
        }

        /**
         * Setter for clientId.
         * @param  clientId  String value for clientId.
         * @return Builder
         */
        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /**
         * Setter for clientSecret.
         * @param  clientSecret  String value for clientSecret.
         * @return Builder
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        /**
         * Setter for grantType.
         * @param  grantType  String value for grantType.
         * @return Builder
         */
        public Builder grantType(String grantType) {
            this.grantType = grantType;
            return this;
        }

        /**
         * Setter for code.
         * @param  code  String value for code.
         * @return Builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Setter for redirectUri.
         * @param  redirectUri  String value for redirectUri.
         * @return Builder
         */
        public Builder redirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
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
         * Setter for migrationToken.
         * @param  migrationToken  String value for migrationToken.
         * @return Builder
         */
        public Builder migrationToken(String migrationToken) {
            this.migrationToken = migrationToken;
            return this;
        }

        /**
         * Setter for scopes.
         * @param  scopes  List of String value for scopes.
         * @return Builder
         */
        public Builder scopes(List<String> scopes) {
            this.scopes = scopes;
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
         * Builds a new {@link ObtainTokenRequest} object using the set fields.
         * @return {@link ObtainTokenRequest}
         */
        public ObtainTokenRequest build() {
            return new ObtainTokenRequest(clientId, clientSecret, grantType, code, redirectUri,
                    refreshToken, migrationToken, scopes, shortLived);
        }
    }
}
