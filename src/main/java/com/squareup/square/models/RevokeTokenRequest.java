
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RevokeTokenRequest type.
 */
public class RevokeTokenRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String clientId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String accessToken;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String merchantId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean revokeOnlyAccessToken;

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
        this.clientId = clientId;
        this.accessToken = accessToken;
        this.merchantId = merchantId;
        this.revokeOnlyAccessToken = revokeOnlyAccessToken;
    }

    /**
     * Getter for ClientId.
     * The Square issued ID for your application, available from the [developer
     * dashboard](https://developer.squareup.com/apps).
     * @return Returns the String
     */
    @JsonGetter("client_id")
    public String getClientId() {
        return clientId;
    }

    /**
     * Getter for AccessToken.
     * The access token of the merchant whose token you want to revoke. Do not provide a value for
     * merchant_id if you provide this parameter.
     * @return Returns the String
     */
    @JsonGetter("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Getter for MerchantId.
     * The ID of the merchant whose token you want to revoke. Do not provide a value for
     * access_token if you provide this parameter.
     * @return Returns the String
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Getter for RevokeOnlyAccessToken.
     * If `true`, terminate the given single access token, but do not terminate the entire
     * authorization. Default: `false`
     * @return Returns the Boolean
     */
    @JsonGetter("revoke_only_access_token")
    public Boolean getRevokeOnlyAccessToken() {
        return revokeOnlyAccessToken;
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
        Builder builder = new Builder()
                .clientId(getClientId())
                .accessToken(getAccessToken())
                .merchantId(getMerchantId())
                .revokeOnlyAccessToken(getRevokeOnlyAccessToken());
        return builder;
    }

    /**
     * Class to build instances of {@link RevokeTokenRequest}.
     */
    public static class Builder {
        private String clientId;
        private String accessToken;
        private String merchantId;
        private Boolean revokeOnlyAccessToken;



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
         * Setter for accessToken.
         * @param  accessToken  String value for accessToken.
         * @return Builder
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
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
         * Setter for revokeOnlyAccessToken.
         * @param  revokeOnlyAccessToken  Boolean value for revokeOnlyAccessToken.
         * @return Builder
         */
        public Builder revokeOnlyAccessToken(Boolean revokeOnlyAccessToken) {
            this.revokeOnlyAccessToken = revokeOnlyAccessToken;
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
