
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ObtainTokenRequest type.
 */
public class ObtainTokenRequest {
    private final String clientId;
    private final String clientSecret;
    private final String code;
    private final String redirectUri;
    private final String grantType;
    private final String refreshToken;
    private final String migrationToken;

    /**
     * Initialization constructor.
     * @param clientId String value for clientId.
     * @param clientSecret String value for clientSecret.
     * @param grantType String value for grantType.
     * @param code String value for code.
     * @param redirectUri String value for redirectUri.
     * @param refreshToken String value for refreshToken.
     * @param migrationToken String value for migrationToken.
     */
    @JsonCreator
    public ObtainTokenRequest(
            @JsonProperty("client_id") String clientId,
            @JsonProperty("client_secret") String clientSecret,
            @JsonProperty("grant_type") String grantType,
            @JsonProperty("code") String code,
            @JsonProperty("redirect_uri") String redirectUri,
            @JsonProperty("refresh_token") String refreshToken,
            @JsonProperty("migration_token") String migrationToken) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.redirectUri = redirectUri;
        this.grantType = grantType;
        this.refreshToken = refreshToken;
        this.migrationToken = migrationToken;
    }

    /**
     * Getter for ClientId.
     * The Square-issued ID of your application, available from the [application
     * dashboard](https://connect.squareup.com/apps).
     * @return Returns the String
     */
    @JsonGetter("client_id")
    public String getClientId() {
        return this.clientId;
    }

    /**
     * Getter for ClientSecret.
     * The Square-issued application secret for your application, available from the [application
     * dashboard](https://connect.squareup.com/apps).
     * @return Returns the String
     */
    @JsonGetter("client_secret")
    public String getClientSecret() {
        return this.clientSecret;
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
        return this.code;
    }

    /**
     * Getter for RedirectUri.
     * The redirect URL assigned in the [application dashboard](https://connect.squareup.com/apps).
     * @return Returns the String
     */
    @JsonGetter("redirect_uri")
    public String getRedirectUri() {
        return this.redirectUri;
    }

    /**
     * Getter for GrantType.
     * Specifies the method to request an OAuth access token. Valid values are:
     * `authorization_code`, `refresh_token`, and `migration_token`
     * @return Returns the String
     */
    @JsonGetter("grant_type")
    public String getGrantType() {
        return this.grantType;
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
        return this.refreshToken;
    }

    /**
     * Getter for MigrationToken.
     * Legacy OAuth access token obtained using a Connect API version prior to 2019-03-13. This
     * parameter is required if `grant_type` is set to `migration_token` to indicate that the
     * application wants to get a replacement OAuth access token. The response also returns a
     * refresh token. For more information, see [Migrate to Using Refresh
     * Tokens](https://developer.squareup.com/docs/authz/oauth/migration).
     * @return Returns the String
     */
    @JsonGetter("migration_token")
    public String getMigrationToken() {
        return this.migrationToken;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientSecret, code, redirectUri, grantType, refreshToken,
                migrationToken);
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
            && Objects.equals(migrationToken, other.migrationToken);
    }

    /**
     * Builds a new {@link ObtainTokenRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ObtainTokenRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(clientId,
            clientSecret,
            grantType)
            .code(getCode())
            .redirectUri(getRedirectUri())
            .refreshToken(getRefreshToken())
            .migrationToken(getMigrationToken());
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

        /**
         * Initialization constructor.
         * @param clientId String value for clientId.
         * @param clientSecret String value for clientSecret.
         * @param grantType String value for grantType.
         */
        public Builder(String clientId,
                String clientSecret,
                String grantType) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.grantType = grantType;
        }

        /**
         * Setter for clientId.
         * @param clientId String value for clientId.
         * @return Builder
         */
        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /**
         * Setter for clientSecret.
         * @param clientSecret String value for clientSecret.
         * @return Builder
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        /**
         * Setter for grantType.
         * @param grantType String value for grantType.
         * @return Builder
         */
        public Builder grantType(String grantType) {
            this.grantType = grantType;
            return this;
        }

        /**
         * Setter for code.
         * @param code String value for code.
         * @return Builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Setter for redirectUri.
         * @param redirectUri String value for redirectUri.
         * @return Builder
         */
        public Builder redirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }

        /**
         * Setter for refreshToken.
         * @param refreshToken String value for refreshToken.
         * @return Builder
         */
        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        /**
         * Setter for migrationToken.
         * @param migrationToken String value for migrationToken.
         * @return Builder
         */
        public Builder migrationToken(String migrationToken) {
            this.migrationToken = migrationToken;
            return this;
        }

        /**
         * Builds a new {@link ObtainTokenRequest} object using the set fields.
         * @return {@link ObtainTokenRequest}
         */
        public ObtainTokenRequest build() {
            return new ObtainTokenRequest(clientId,
                clientSecret,
                grantType,
                code,
                redirectUri,
                refreshToken,
                migrationToken);
        }
    }
}
