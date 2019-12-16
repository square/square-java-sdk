package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ObtainTokenRequest {

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

    private final String clientId;
    private final String clientSecret;
    private final String code;
    private final String redirectUri;
    private final String grantType;
    private final String refreshToken;
    private final String migrationToken;

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientSecret, grantType, code, redirectUri, refreshToken, migrationToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ObtainTokenRequest)) {
            return false;
        }
        ObtainTokenRequest obtainTokenRequest = (ObtainTokenRequest) o;
        return Objects.equals(clientId, obtainTokenRequest.clientId) &&
            Objects.equals(clientSecret, obtainTokenRequest.clientSecret) &&
            Objects.equals(grantType, obtainTokenRequest.grantType) &&
            Objects.equals(code, obtainTokenRequest.code) &&
            Objects.equals(redirectUri, obtainTokenRequest.redirectUri) &&
            Objects.equals(refreshToken, obtainTokenRequest.refreshToken) &&
            Objects.equals(migrationToken, obtainTokenRequest.migrationToken);
    }

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

    public static class Builder {
        private String clientId;
        private String clientSecret;
        private String grantType;
        private String code;
        private String redirectUri;
        private String refreshToken;
        private String migrationToken;

        public Builder(String clientId,
                String clientSecret,
                String grantType) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.grantType = grantType;
        }

        public Builder clientId(String value) {
            clientId = value;
            return this;
        }
        public Builder clientSecret(String value) {
            clientSecret = value;
            return this;
        }
        public Builder grantType(String value) {
            grantType = value;
            return this;
        }
        public Builder code(String value) {
            code = value;
            return this;
        }
        public Builder redirectUri(String value) {
            redirectUri = value;
            return this;
        }
        public Builder refreshToken(String value) {
            refreshToken = value;
            return this;
        }
        public Builder migrationToken(String value) {
            migrationToken = value;
            return this;
        }

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
