
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ObtainTokenRequest type.
 */
public class ObtainTokenRequest {
    private final String clientId;
    private final OptionalNullable<String> clientSecret;
    private final OptionalNullable<String> code;
    private final OptionalNullable<String> redirectUri;
    private final String grantType;
    private final OptionalNullable<String> refreshToken;
    private final OptionalNullable<String> migrationToken;
    private final OptionalNullable<List<String>> scopes;
    private final OptionalNullable<Boolean> shortLived;
    private final OptionalNullable<String> codeVerifier;

    /**
     * Initialization constructor.
     * @param  clientId  String value for clientId.
     * @param  grantType  String value for grantType.
     * @param  clientSecret  String value for clientSecret.
     * @param  code  String value for code.
     * @param  redirectUri  String value for redirectUri.
     * @param  refreshToken  String value for refreshToken.
     * @param  migrationToken  String value for migrationToken.
     * @param  scopes  List of String value for scopes.
     * @param  shortLived  Boolean value for shortLived.
     * @param  codeVerifier  String value for codeVerifier.
     */
    @JsonCreator
    public ObtainTokenRequest(
            @JsonProperty("client_id") String clientId,
            @JsonProperty("grant_type") String grantType,
            @JsonProperty("client_secret") String clientSecret,
            @JsonProperty("code") String code,
            @JsonProperty("redirect_uri") String redirectUri,
            @JsonProperty("refresh_token") String refreshToken,
            @JsonProperty("migration_token") String migrationToken,
            @JsonProperty("scopes") List<String> scopes,
            @JsonProperty("short_lived") Boolean shortLived,
            @JsonProperty("code_verifier") String codeVerifier) {
        this.clientId = clientId;
        this.clientSecret = OptionalNullable.of(clientSecret);
        this.code = OptionalNullable.of(code);
        this.redirectUri = OptionalNullable.of(redirectUri);
        this.grantType = grantType;
        this.refreshToken = OptionalNullable.of(refreshToken);
        this.migrationToken = OptionalNullable.of(migrationToken);
        this.scopes = OptionalNullable.of(scopes);
        this.shortLived = OptionalNullable.of(shortLived);
        this.codeVerifier = OptionalNullable.of(codeVerifier);
    }

    /**
     * Initialization constructor.
     * @param  clientId  String value for clientId.
     * @param  grantType  String value for grantType.
     * @param  clientSecret  String value for clientSecret.
     * @param  code  String value for code.
     * @param  redirectUri  String value for redirectUri.
     * @param  refreshToken  String value for refreshToken.
     * @param  migrationToken  String value for migrationToken.
     * @param  scopes  List of String value for scopes.
     * @param  shortLived  Boolean value for shortLived.
     * @param  codeVerifier  String value for codeVerifier.
     */

    protected ObtainTokenRequest(String clientId, String grantType,
            OptionalNullable<String> clientSecret, OptionalNullable<String> code,
            OptionalNullable<String> redirectUri, OptionalNullable<String> refreshToken,
            OptionalNullable<String> migrationToken, OptionalNullable<List<String>> scopes,
            OptionalNullable<Boolean> shortLived, OptionalNullable<String> codeVerifier) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.redirectUri = redirectUri;
        this.grantType = grantType;
        this.refreshToken = refreshToken;
        this.migrationToken = migrationToken;
        this.scopes = scopes;
        this.shortLived = shortLived;
        this.codeVerifier = codeVerifier;
    }

    /**
     * Getter for ClientId.
     * The Square-issued ID of your application, which is available on the **OAuth** page in the
     * [Developer Dashboard](https://developer.squareup.com/apps).
     * @return Returns the String
     */
    @JsonGetter("client_id")
    public String getClientId() {
        return clientId;
    }

    /**
     * Internal Getter for ClientSecret.
     * The Square-issued application secret for your application, which is available on the
     * **OAuth** page in the [Developer Dashboard](https://developer.squareup.com/apps). This
     * parameter is only required when you're not using the [OAuth PKCE (Proof Key for Code
     * Exchange) flow](https://developer.squareup.com/docs/oauth-api/overview#pkce-flow). The PKCE
     * flow requires a `code_verifier` instead of a `client_secret` when `grant_type` is set to
     * `authorization_code`. If `grant_type` is set to `refresh_token` and the `refresh_token` is
     * obtained uaing PKCE, the PKCE flow only requires `client_id`,  `grant_type`,
     * and `refresh_token`.
     * @return Returns the Internal String
     */
    @JsonGetter("client_secret")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetClientSecret() {
        return this.clientSecret;
    }

    /**
     * Getter for ClientSecret.
     * The Square-issued application secret for your application, which is available on the
     * **OAuth** page in the [Developer Dashboard](https://developer.squareup.com/apps). This
     * parameter is only required when you're not using the [OAuth PKCE (Proof Key for Code
     * Exchange) flow](https://developer.squareup.com/docs/oauth-api/overview#pkce-flow). The PKCE
     * flow requires a `code_verifier` instead of a `client_secret` when `grant_type` is set to
     * `authorization_code`. If `grant_type` is set to `refresh_token` and the `refresh_token` is
     * obtained uaing PKCE, the PKCE flow only requires `client_id`,  `grant_type`,
     * and `refresh_token`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getClientSecret() {
        return OptionalNullable.getFrom(clientSecret);
    }

    /**
     * Internal Getter for Code.
     * The authorization code to exchange. This code is required if `grant_type` is set to
     * `authorization_code` to indicate that the application wants to exchange an authorization code
     * for an OAuth access token.
     * @return Returns the Internal String
     */
    @JsonGetter("code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCode() {
        return this.code;
    }

    /**
     * Getter for Code.
     * The authorization code to exchange. This code is required if `grant_type` is set to
     * `authorization_code` to indicate that the application wants to exchange an authorization code
     * for an OAuth access token.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCode() {
        return OptionalNullable.getFrom(code);
    }

    /**
     * Internal Getter for RedirectUri.
     * The redirect URL assigned on the **OAuth** page for your application in the [Developer
     * Dashboard](https://developer.squareup.com/apps).
     * @return Returns the Internal String
     */
    @JsonGetter("redirect_uri")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetRedirectUri() {
        return this.redirectUri;
    }

    /**
     * Getter for RedirectUri.
     * The redirect URL assigned on the **OAuth** page for your application in the [Developer
     * Dashboard](https://developer.squareup.com/apps).
     * @return Returns the String
     */
    @JsonIgnore
    public String getRedirectUri() {
        return OptionalNullable.getFrom(redirectUri);
    }

    /**
     * Getter for GrantType.
     * Specifies the method to request an OAuth access token. Valid values are `authorization_code`,
     * `refresh_token`, and `migration_token`.
     * @return Returns the String
     */
    @JsonGetter("grant_type")
    public String getGrantType() {
        return grantType;
    }

    /**
     * Internal Getter for RefreshToken.
     * A valid refresh token for generating a new OAuth access token. A valid refresh token is
     * required if `grant_type` is set to `refresh_token` to indicate that the application wants a
     * replacement for an expired OAuth access token.
     * @return Returns the Internal String
     */
    @JsonGetter("refresh_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetRefreshToken() {
        return this.refreshToken;
    }

    /**
     * Getter for RefreshToken.
     * A valid refresh token for generating a new OAuth access token. A valid refresh token is
     * required if `grant_type` is set to `refresh_token` to indicate that the application wants a
     * replacement for an expired OAuth access token.
     * @return Returns the String
     */
    @JsonIgnore
    public String getRefreshToken() {
        return OptionalNullable.getFrom(refreshToken);
    }

    /**
     * Internal Getter for MigrationToken.
     * A legacy OAuth access token obtained using a Connect API version prior to 2019-03-13. This
     * parameter is required if `grant_type` is set to `migration_token` to indicate that the
     * application wants to get a replacement OAuth access token. The response also returns a
     * refresh token. For more information, see [Migrate to Using Refresh
     * Tokens](https://developer.squareup.com/docs/oauth-api/migrate-to-refresh-tokens).
     * @return Returns the Internal String
     */
    @JsonGetter("migration_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMigrationToken() {
        return this.migrationToken;
    }

    /**
     * Getter for MigrationToken.
     * A legacy OAuth access token obtained using a Connect API version prior to 2019-03-13. This
     * parameter is required if `grant_type` is set to `migration_token` to indicate that the
     * application wants to get a replacement OAuth access token. The response also returns a
     * refresh token. For more information, see [Migrate to Using Refresh
     * Tokens](https://developer.squareup.com/docs/oauth-api/migrate-to-refresh-tokens).
     * @return Returns the String
     */
    @JsonIgnore
    public String getMigrationToken() {
        return OptionalNullable.getFrom(migrationToken);
    }

    /**
     * Internal Getter for Scopes.
     * A JSON list of strings representing the permissions that the application is requesting. For
     * example, "`["MERCHANT_PROFILE_READ","PAYMENTS_READ","BANK_ACCOUNTS_READ"]`". The access token
     * returned in the response is granted the permissions that comprise the intersection between
     * the requested list of permissions and those that belong to the provided refresh token.
     * @return Returns the Internal List of String
     */
    @JsonGetter("scopes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetScopes() {
        return this.scopes;
    }

    /**
     * Getter for Scopes.
     * A JSON list of strings representing the permissions that the application is requesting. For
     * example, "`["MERCHANT_PROFILE_READ","PAYMENTS_READ","BANK_ACCOUNTS_READ"]`". The access token
     * returned in the response is granted the permissions that comprise the intersection between
     * the requested list of permissions and those that belong to the provided refresh token.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getScopes() {
        return OptionalNullable.getFrom(scopes);
    }

    /**
     * Internal Getter for ShortLived.
     * A Boolean indicating a request for a short-lived access token. The short-lived access token
     * returned in the response expires in 24 hours.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("short_lived")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetShortLived() {
        return this.shortLived;
    }

    /**
     * Getter for ShortLived.
     * A Boolean indicating a request for a short-lived access token. The short-lived access token
     * returned in the response expires in 24 hours.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getShortLived() {
        return OptionalNullable.getFrom(shortLived);
    }

    /**
     * Internal Getter for CodeVerifier.
     * Must be provided when using the PKCE OAuth flow if `grant_type` is set
     * to `authorization_code`. The `code_verifier` is used to verify against the `code_challenge`
     * associated with the `authorization_code`.
     * @return Returns the Internal String
     */
    @JsonGetter("code_verifier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCodeVerifier() {
        return this.codeVerifier;
    }

    /**
     * Getter for CodeVerifier.
     * Must be provided when using the PKCE OAuth flow if `grant_type` is set
     * to `authorization_code`. The `code_verifier` is used to verify against the `code_challenge`
     * associated with the `authorization_code`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCodeVerifier() {
        return OptionalNullable.getFrom(codeVerifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientSecret, code, redirectUri, grantType, refreshToken,
                migrationToken, scopes, shortLived, codeVerifier);
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
            && Objects.equals(shortLived, other.shortLived)
            && Objects.equals(codeVerifier, other.codeVerifier);
    }

    /**
     * Converts this ObtainTokenRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ObtainTokenRequest [" + "clientId=" + clientId + ", grantType=" + grantType
                + ", clientSecret=" + clientSecret + ", code=" + code + ", redirectUri="
                + redirectUri + ", refreshToken=" + refreshToken + ", migrationToken="
                + migrationToken + ", scopes=" + scopes + ", shortLived=" + shortLived
                + ", codeVerifier=" + codeVerifier + "]";
    }

    /**
     * Builds a new {@link ObtainTokenRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ObtainTokenRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(clientId, grantType);
        builder.clientSecret = internalGetClientSecret();
        builder.code = internalGetCode();
        builder.redirectUri = internalGetRedirectUri();
        builder.refreshToken = internalGetRefreshToken();
        builder.migrationToken = internalGetMigrationToken();
        builder.scopes = internalGetScopes();
        builder.shortLived = internalGetShortLived();
        builder.codeVerifier = internalGetCodeVerifier();
        return builder;
    }

    /**
     * Class to build instances of {@link ObtainTokenRequest}.
     */
    public static class Builder {
        private String clientId;
        private String grantType;
        private OptionalNullable<String> clientSecret;
        private OptionalNullable<String> code;
        private OptionalNullable<String> redirectUri;
        private OptionalNullable<String> refreshToken;
        private OptionalNullable<String> migrationToken;
        private OptionalNullable<List<String>> scopes;
        private OptionalNullable<Boolean> shortLived;
        private OptionalNullable<String> codeVerifier;

        /**
         * Initialization constructor.
         * @param  clientId  String value for clientId.
         * @param  grantType  String value for grantType.
         */
        public Builder(String clientId, String grantType) {
            this.clientId = clientId;
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
         * Setter for grantType.
         * @param  grantType  String value for grantType.
         * @return Builder
         */
        public Builder grantType(String grantType) {
            this.grantType = grantType;
            return this;
        }

        /**
         * Setter for clientSecret.
         * @param  clientSecret  String value for clientSecret.
         * @return Builder
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = OptionalNullable.of(clientSecret);
            return this;
        }

        /**
         * UnSetter for clientSecret.
         * @return Builder
         */
        public Builder unsetClientSecret() {
            clientSecret = null;
            return this;
        }

        /**
         * Setter for code.
         * @param  code  String value for code.
         * @return Builder
         */
        public Builder code(String code) {
            this.code = OptionalNullable.of(code);
            return this;
        }

        /**
         * UnSetter for code.
         * @return Builder
         */
        public Builder unsetCode() {
            code = null;
            return this;
        }

        /**
         * Setter for redirectUri.
         * @param  redirectUri  String value for redirectUri.
         * @return Builder
         */
        public Builder redirectUri(String redirectUri) {
            this.redirectUri = OptionalNullable.of(redirectUri);
            return this;
        }

        /**
         * UnSetter for redirectUri.
         * @return Builder
         */
        public Builder unsetRedirectUri() {
            redirectUri = null;
            return this;
        }

        /**
         * Setter for refreshToken.
         * @param  refreshToken  String value for refreshToken.
         * @return Builder
         */
        public Builder refreshToken(String refreshToken) {
            this.refreshToken = OptionalNullable.of(refreshToken);
            return this;
        }

        /**
         * UnSetter for refreshToken.
         * @return Builder
         */
        public Builder unsetRefreshToken() {
            refreshToken = null;
            return this;
        }

        /**
         * Setter for migrationToken.
         * @param  migrationToken  String value for migrationToken.
         * @return Builder
         */
        public Builder migrationToken(String migrationToken) {
            this.migrationToken = OptionalNullable.of(migrationToken);
            return this;
        }

        /**
         * UnSetter for migrationToken.
         * @return Builder
         */
        public Builder unsetMigrationToken() {
            migrationToken = null;
            return this;
        }

        /**
         * Setter for scopes.
         * @param  scopes  List of String value for scopes.
         * @return Builder
         */
        public Builder scopes(List<String> scopes) {
            this.scopes = OptionalNullable.of(scopes);
            return this;
        }

        /**
         * UnSetter for scopes.
         * @return Builder
         */
        public Builder unsetScopes() {
            scopes = null;
            return this;
        }

        /**
         * Setter for shortLived.
         * @param  shortLived  Boolean value for shortLived.
         * @return Builder
         */
        public Builder shortLived(Boolean shortLived) {
            this.shortLived = OptionalNullable.of(shortLived);
            return this;
        }

        /**
         * UnSetter for shortLived.
         * @return Builder
         */
        public Builder unsetShortLived() {
            shortLived = null;
            return this;
        }

        /**
         * Setter for codeVerifier.
         * @param  codeVerifier  String value for codeVerifier.
         * @return Builder
         */
        public Builder codeVerifier(String codeVerifier) {
            this.codeVerifier = OptionalNullable.of(codeVerifier);
            return this;
        }

        /**
         * UnSetter for codeVerifier.
         * @return Builder
         */
        public Builder unsetCodeVerifier() {
            codeVerifier = null;
            return this;
        }

        /**
         * Builds a new {@link ObtainTokenRequest} object using the set fields.
         * @return {@link ObtainTokenRequest}
         */
        public ObtainTokenRequest build() {
            return new ObtainTokenRequest(clientId, grantType, clientSecret, code, redirectUri,
                    refreshToken, migrationToken, scopes, shortLived, codeVerifier);
        }
    }
}
