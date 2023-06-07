
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for RevokeTokenRequest type.
 */
public class RevokeTokenRequest {
    private final OptionalNullable<String> clientId;
    private final OptionalNullable<String> accessToken;
    private final OptionalNullable<String> merchantId;
    private final OptionalNullable<Boolean> revokeOnlyAccessToken;

    /**
     * Initialization constructor.
     * @param  clientId  String value for clientId.
     * @param  accessToken  String value for accessToken.
     * @param  merchantId  String value for merchantId.
     * @param  revokeOnlyAccessToken  Boolean value for revokeOnlyAccessToken.
     */
    @JsonCreator
    public RevokeTokenRequest(
            @JsonProperty("client_id") String clientId,
            @JsonProperty("access_token") String accessToken,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("revoke_only_access_token") Boolean revokeOnlyAccessToken) {
        this.clientId = OptionalNullable.of(clientId);
        this.accessToken = OptionalNullable.of(accessToken);
        this.merchantId = OptionalNullable.of(merchantId);
        this.revokeOnlyAccessToken = OptionalNullable.of(revokeOnlyAccessToken);
    }

    /**
     * Internal initialization constructor.
     */
    protected RevokeTokenRequest(OptionalNullable<String> clientId,
            OptionalNullable<String> accessToken, OptionalNullable<String> merchantId,
            OptionalNullable<Boolean> revokeOnlyAccessToken) {
        this.clientId = clientId;
        this.accessToken = accessToken;
        this.merchantId = merchantId;
        this.revokeOnlyAccessToken = revokeOnlyAccessToken;
    }

    /**
     * Internal Getter for ClientId.
     * The Square-issued ID for your application, which is available on the **OAuth** page in the
     * [Developer Dashboard](https://developer.squareup.com/apps).
     * @return Returns the Internal String
     */
    @JsonGetter("client_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetClientId() {
        return this.clientId;
    }

    /**
     * Getter for ClientId.
     * The Square-issued ID for your application, which is available on the **OAuth** page in the
     * [Developer Dashboard](https://developer.squareup.com/apps).
     * @return Returns the String
     */
    @JsonIgnore
    public String getClientId() {
        return OptionalNullable.getFrom(clientId);
    }

    /**
     * Internal Getter for AccessToken.
     * The access token of the merchant whose token you want to revoke. Do not provide a value for
     * `merchant_id` if you provide this parameter.
     * @return Returns the Internal String
     */
    @JsonGetter("access_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAccessToken() {
        return this.accessToken;
    }

    /**
     * Getter for AccessToken.
     * The access token of the merchant whose token you want to revoke. Do not provide a value for
     * `merchant_id` if you provide this parameter.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAccessToken() {
        return OptionalNullable.getFrom(accessToken);
    }

    /**
     * Internal Getter for MerchantId.
     * The ID of the merchant whose token you want to revoke. Do not provide a value for
     * `access_token` if you provide this parameter.
     * @return Returns the Internal String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMerchantId() {
        return this.merchantId;
    }

    /**
     * Getter for MerchantId.
     * The ID of the merchant whose token you want to revoke. Do not provide a value for
     * `access_token` if you provide this parameter.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMerchantId() {
        return OptionalNullable.getFrom(merchantId);
    }

    /**
     * Internal Getter for RevokeOnlyAccessToken.
     * If `true`, terminate the given single access token, but do not terminate the entire
     * authorization. Default: `false`
     * @return Returns the Internal Boolean
     */
    @JsonGetter("revoke_only_access_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetRevokeOnlyAccessToken() {
        return this.revokeOnlyAccessToken;
    }

    /**
     * Getter for RevokeOnlyAccessToken.
     * If `true`, terminate the given single access token, but do not terminate the entire
     * authorization. Default: `false`
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getRevokeOnlyAccessToken() {
        return OptionalNullable.getFrom(revokeOnlyAccessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, accessToken, merchantId, revokeOnlyAccessToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RevokeTokenRequest)) {
            return false;
        }
        RevokeTokenRequest other = (RevokeTokenRequest) obj;
        return Objects.equals(clientId, other.clientId)
            && Objects.equals(accessToken, other.accessToken)
            && Objects.equals(merchantId, other.merchantId)
            && Objects.equals(revokeOnlyAccessToken, other.revokeOnlyAccessToken);
    }

    /**
     * Converts this RevokeTokenRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RevokeTokenRequest [" + "clientId=" + clientId + ", accessToken=" + accessToken
                + ", merchantId=" + merchantId + ", revokeOnlyAccessToken=" + revokeOnlyAccessToken
                + "]";
    }

    /**
     * Builds a new {@link RevokeTokenRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RevokeTokenRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.clientId = internalGetClientId();
        builder.accessToken = internalGetAccessToken();
        builder.merchantId = internalGetMerchantId();
        builder.revokeOnlyAccessToken = internalGetRevokeOnlyAccessToken();
        return builder;
    }

    /**
     * Class to build instances of {@link RevokeTokenRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> clientId;
        private OptionalNullable<String> accessToken;
        private OptionalNullable<String> merchantId;
        private OptionalNullable<Boolean> revokeOnlyAccessToken;



        /**
         * Setter for clientId.
         * @param  clientId  String value for clientId.
         * @return Builder
         */
        public Builder clientId(String clientId) {
            this.clientId = OptionalNullable.of(clientId);
            return this;
        }

        /**
         * UnSetter for clientId.
         * @return Builder
         */
        public Builder unsetClientId() {
            clientId = null;
            return this;
        }

        /**
         * Setter for accessToken.
         * @param  accessToken  String value for accessToken.
         * @return Builder
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = OptionalNullable.of(accessToken);
            return this;
        }

        /**
         * UnSetter for accessToken.
         * @return Builder
         */
        public Builder unsetAccessToken() {
            accessToken = null;
            return this;
        }

        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = OptionalNullable.of(merchantId);
            return this;
        }

        /**
         * UnSetter for merchantId.
         * @return Builder
         */
        public Builder unsetMerchantId() {
            merchantId = null;
            return this;
        }

        /**
         * Setter for revokeOnlyAccessToken.
         * @param  revokeOnlyAccessToken  Boolean value for revokeOnlyAccessToken.
         * @return Builder
         */
        public Builder revokeOnlyAccessToken(Boolean revokeOnlyAccessToken) {
            this.revokeOnlyAccessToken = OptionalNullable.of(revokeOnlyAccessToken);
            return this;
        }

        /**
         * UnSetter for revokeOnlyAccessToken.
         * @return Builder
         */
        public Builder unsetRevokeOnlyAccessToken() {
            revokeOnlyAccessToken = null;
            return this;
        }

        /**
         * Builds a new {@link RevokeTokenRequest} object using the set fields.
         * @return {@link RevokeTokenRequest}
         */
        public RevokeTokenRequest build() {
            return new RevokeTokenRequest(clientId, accessToken, merchantId, revokeOnlyAccessToken);
        }
    }
}
