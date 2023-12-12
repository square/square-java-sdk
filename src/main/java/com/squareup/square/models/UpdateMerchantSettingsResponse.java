
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
 * This is a model class for UpdateMerchantSettingsResponse type.
 */
public class UpdateMerchantSettingsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final CheckoutMerchantSettings merchantSettings;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  merchantSettings  CheckoutMerchantSettings value for merchantSettings.
     */
    @JsonCreator
    public UpdateMerchantSettingsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("merchant_settings") CheckoutMerchantSettings merchantSettings) {
        this.errors = errors;
        this.merchantSettings = merchantSettings;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred when updating the merchant settings.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for MerchantSettings.
     * @return Returns the CheckoutMerchantSettings
     */
    @JsonGetter("merchant_settings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutMerchantSettings getMerchantSettings() {
        return merchantSettings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, merchantSettings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateMerchantSettingsResponse)) {
            return false;
        }
        UpdateMerchantSettingsResponse other = (UpdateMerchantSettingsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(merchantSettings, other.merchantSettings);
    }

    /**
     * Converts this UpdateMerchantSettingsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateMerchantSettingsResponse [" + "errors=" + errors + ", merchantSettings="
                + merchantSettings + "]";
    }

    /**
     * Builds a new {@link UpdateMerchantSettingsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateMerchantSettingsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .merchantSettings(getMerchantSettings());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateMerchantSettingsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CheckoutMerchantSettings merchantSettings;



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
         * Setter for merchantSettings.
         * @param  merchantSettings  CheckoutMerchantSettings value for merchantSettings.
         * @return Builder
         */
        public Builder merchantSettings(CheckoutMerchantSettings merchantSettings) {
            this.merchantSettings = merchantSettings;
            return this;
        }

        /**
         * Builds a new {@link UpdateMerchantSettingsResponse} object using the set fields.
         * @return {@link UpdateMerchantSettingsResponse}
         */
        public UpdateMerchantSettingsResponse build() {
            UpdateMerchantSettingsResponse model =
                    new UpdateMerchantSettingsResponse(errors, merchantSettings);
            model.httpContext = httpContext;
            return model;
        }
    }
}
