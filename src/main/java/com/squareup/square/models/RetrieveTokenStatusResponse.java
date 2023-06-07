
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
 * This is a model class for RetrieveTokenStatusResponse type.
 */
public class RetrieveTokenStatusResponse {
    private HttpContext httpContext;
    private final List<String> scopes;
    private final String expiresAt;
    private final String clientId;
    private final String merchantId;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  scopes  List of String value for scopes.
     * @param  expiresAt  String value for expiresAt.
     * @param  clientId  String value for clientId.
     * @param  merchantId  String value for merchantId.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RetrieveTokenStatusResponse(
            @JsonProperty("scopes") List<String> scopes,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("client_id") String clientId,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("errors") List<Error> errors) {
        this.scopes = scopes;
        this.expiresAt = expiresAt;
        this.clientId = clientId;
        this.merchantId = merchantId;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Scopes.
     * The list of scopes associated with an access token.
     * @return Returns the List of String
     */
    @JsonGetter("scopes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * Getter for ExpiresAt.
     * The date and time when the `access_token` expires, in RFC 3339 format. Empty if the token
     * never expires.
     * @return Returns the String
     */
    @JsonGetter("expires_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     * Getter for ClientId.
     * The Square-issued application ID associated with the access token. This is the same
     * application ID used to obtain the token.
     * @return Returns the String
     */
    @JsonGetter("client_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getClientId() {
        return clientId;
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
        return Objects.hash(scopes, expiresAt, clientId, merchantId, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveTokenStatusResponse)) {
            return false;
        }
        RetrieveTokenStatusResponse other = (RetrieveTokenStatusResponse) obj;
        return Objects.equals(scopes, other.scopes)
            && Objects.equals(expiresAt, other.expiresAt)
            && Objects.equals(clientId, other.clientId)
            && Objects.equals(merchantId, other.merchantId)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveTokenStatusResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveTokenStatusResponse [" + "scopes=" + scopes + ", expiresAt=" + expiresAt
                + ", clientId=" + clientId + ", merchantId=" + merchantId + ", errors=" + errors
                + "]";
    }

    /**
     * Builds a new {@link RetrieveTokenStatusResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveTokenStatusResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .scopes(getScopes())
                .expiresAt(getExpiresAt())
                .clientId(getClientId())
                .merchantId(getMerchantId())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveTokenStatusResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<String> scopes;
        private String expiresAt;
        private String clientId;
        private String merchantId;
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
         * Setter for scopes.
         * @param  scopes  List of String value for scopes.
         * @return Builder
         */
        public Builder scopes(List<String> scopes) {
            this.scopes = scopes;
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
         * Setter for clientId.
         * @param  clientId  String value for clientId.
         * @return Builder
         */
        public Builder clientId(String clientId) {
            this.clientId = clientId;
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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link RetrieveTokenStatusResponse} object using the set fields.
         * @return {@link RetrieveTokenStatusResponse}
         */
        public RetrieveTokenStatusResponse build() {
            RetrieveTokenStatusResponse model =
                    new RetrieveTokenStatusResponse(scopes, expiresAt, clientId, merchantId,
                            errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
