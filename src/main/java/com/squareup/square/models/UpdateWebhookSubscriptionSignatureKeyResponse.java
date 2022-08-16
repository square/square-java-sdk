
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
 * This is a model class for UpdateWebhookSubscriptionSignatureKeyResponse type.
 */
public class UpdateWebhookSubscriptionSignatureKeyResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final String signatureKey;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  signatureKey  String value for signatureKey.
     */
    @JsonCreator
    public UpdateWebhookSubscriptionSignatureKeyResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("signature_key") String signatureKey) {
        this.errors = errors;
        this.signatureKey = signatureKey;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for SignatureKey.
     * The new Square-generated signature key used to validate the origin of the webhook event.
     * @return Returns the String
     */
    @JsonGetter("signature_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSignatureKey() {
        return signatureKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, signatureKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateWebhookSubscriptionSignatureKeyResponse)) {
            return false;
        }
        UpdateWebhookSubscriptionSignatureKeyResponse other =
                (UpdateWebhookSubscriptionSignatureKeyResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(signatureKey, other.signatureKey);
    }

    /**
     * Converts this UpdateWebhookSubscriptionSignatureKeyResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateWebhookSubscriptionSignatureKeyResponse [" + "errors=" + errors
                + ", signatureKey=" + signatureKey + "]";
    }

    /**
     * Builds a new {@link UpdateWebhookSubscriptionSignatureKeyResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateWebhookSubscriptionSignatureKeyResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .signatureKey(getSignatureKey());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateWebhookSubscriptionSignatureKeyResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String signatureKey;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for signatureKey.
         * @param  signatureKey  String value for signatureKey.
         * @return Builder
         */
        public Builder signatureKey(String signatureKey) {
            this.signatureKey = signatureKey;
            return this;
        }

        /**
         * Builds a new {@link UpdateWebhookSubscriptionSignatureKeyResponse} object using the set
         * fields.
         * @return {@link UpdateWebhookSubscriptionSignatureKeyResponse}
         */
        public UpdateWebhookSubscriptionSignatureKeyResponse build() {
            UpdateWebhookSubscriptionSignatureKeyResponse model =
                    new UpdateWebhookSubscriptionSignatureKeyResponse(errors, signatureKey);
            model.httpContext = httpContext;
            return model;
        }
    }
}
