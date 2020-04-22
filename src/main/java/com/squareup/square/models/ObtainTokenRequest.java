package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ObtainTokenRequest type.
 */
public class ObtainTokenRequest {

    /**
     * Initialization constructor.
     * @param clientId
     * @param clientSecret
     * @param grantType
     * @param code
     * @param redirectUri
     * @param refreshToken
     * @param migrationToken
     * @param scopes
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
            @JsonProperty("scopes") List<String> scopes) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.redirectUri = redirectUri;
        this.grantType = grantType;
        this.refreshToken = refreshToken;
        this.migrationToken = migrationToken;
        this.scopes = scopes;
    }

    private final String clientId;
    private final String clientSecret;
    private final String code;
    private final String redirectUri;
    private final String grantType;
    private final String refreshToken;
    private final String migrationToken;
    private final List<String> scopes;
    /**
     * Getter for ClientId.
     * The Square-issued ID of your application, available from the
     * [application dashboard](https://connect.squareup.com/apps).
     */
    @JsonGetter("client_id")
    public String getClientId() {
        return this.clientId;
    }

    /**
     * Getter for ClientSecret.
     * The Square-issued application secret for your application, available
     * from the [application dashboard](https://connect.squareup.com/apps).
     */
    @JsonGetter("client_secret")
    public String getClientSecret() {
        return this.clientSecret;
    }

    /**
     * Getter for Code.
     * The authorization code to exchange.
     * This is required if `grant_type` is set to `authorization_code`, to indicate that
     * the application wants to exchange an authorization code for an OAuth access token.
     */
    @JsonGetter("code")
    public String getCode() {
        return this.code;
    }

    /**
     * Getter for RedirectUri.
     * The redirect URL assigned in the [application dashboard](https://connect.squareup.com/apps).
     */
    @JsonGetter("redirect_uri")
    public String getRedirectUri() {
        return this.redirectUri;
    }

    /**
     * Getter for GrantType.
     * Specifies the method to request an OAuth access token.
     * Valid values are: `authorization_code`, `refresh_token`, and `migration_token`
     */
    @JsonGetter("grant_type")
    public String getGrantType() {
        return this.grantType;
    }

    /**
     * Getter for RefreshToken.
     * A valid refresh token for generating a new OAuth access token.
     * A valid refresh token is required if `grant_type` is set to `refresh_token` ,
     * to indicate the application wants a replacement for an expired OAuth access token.
     */
    @JsonGetter("refresh_token")
    public String getRefreshToken() {
        return this.refreshToken;
    }

    /**
     * Getter for MigrationToken.
     * Legacy OAuth access token obtained using a Connect API version prior
     * to 2019-03-13. This parameter is required if `grant_type` is set to
     * `migration_token` to indicate that the application wants to get a replacement
     * OAuth access token. The response also returns a refresh token.
     * For more information, see [Migrate to Using Refresh Tokens](https://developer.squareup.com/docs/authz/oauth/migration).
     */
    @JsonGetter("migration_token")
    public String getMigrationToken() {
        return this.migrationToken;
    }

    /**
     * Getter for Scopes.
     * __OPTIONAL__
     * A JSON list of strings that are the permissions the application is requesting.
     * For example: "`["MERCHANT_PROFILE_READ","PAYMENTS_READ","BANK_ACCOUNTS_READ"]`"
     * The access token returned in the response will be granted the permissions
     * that comprise the intersection between the given list of permissions, and those
     * that belong to the provided refresh token.
     */
    @JsonGetter("scopes")
    public List<String> getScopes() {
        return this.scopes;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientSecret, code, redirectUri, grantType, refreshToken,
            migrationToken, scopes);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ObtainTokenRequest)) {
            return false;
        }
        ObtainTokenRequest obtainTokenRequest = (ObtainTokenRequest) obj;
        return Objects.equals(clientId, obtainTokenRequest.clientId) &&
            Objects.equals(clientSecret, obtainTokenRequest.clientSecret) &&
            Objects.equals(code, obtainTokenRequest.code) &&
            Objects.equals(redirectUri, obtainTokenRequest.redirectUri) &&
            Objects.equals(grantType, obtainTokenRequest.grantType) &&
            Objects.equals(refreshToken, obtainTokenRequest.refreshToken) &&
            Objects.equals(migrationToken, obtainTokenRequest.migrationToken) &&
            Objects.equals(scopes, obtainTokenRequest.scopes);
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
            .migrationToken(getMigrationToken())
            .scopes(getScopes());
            return builder;
    }

    /**
     * Class to build instances of {@link ObtainTokenRequest}
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

        /**
         * Initialization constructor
         */
        public Builder(String clientId,
                String clientSecret,
                String grantType) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.grantType = grantType;
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
         * Setter for clientSecret
         * @param clientSecret
         * @return Builder
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }
        /**
         * Setter for grantType
         * @param grantType
         * @return Builder
         */
        public Builder grantType(String grantType) {
            this.grantType = grantType;
            return this;
        }
        /**
         * Setter for code
         * @param code
         * @return Builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }
        /**
         * Setter for redirectUri
         * @param redirectUri
         * @return Builder
         */
        public Builder redirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }
        /**
         * Setter for refreshToken
         * @param refreshToken
         * @return Builder
         */
        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }
        /**
         * Setter for migrationToken
         * @param migrationToken
         * @return Builder
         */
        public Builder migrationToken(String migrationToken) {
            this.migrationToken = migrationToken;
            return this;
        }
        /**
         * Setter for scopes
         * @param scopes
         * @return Builder
         */
        public Builder scopes(List<String> scopes) {
            this.scopes = scopes;
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
                migrationToken,
                scopes);
        }
    }
}
