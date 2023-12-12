
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
 * This is a model class for UpdateLocationSettingsResponse type.
 */
public class UpdateLocationSettingsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final CheckoutLocationSettings locationSettings;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  locationSettings  CheckoutLocationSettings value for locationSettings.
     */
    @JsonCreator
    public UpdateLocationSettingsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("location_settings") CheckoutLocationSettings locationSettings) {
        this.errors = errors;
        this.locationSettings = locationSettings;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred when updating the location settings.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for LocationSettings.
     * @return Returns the CheckoutLocationSettings
     */
    @JsonGetter("location_settings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutLocationSettings getLocationSettings() {
        return locationSettings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, locationSettings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateLocationSettingsResponse)) {
            return false;
        }
        UpdateLocationSettingsResponse other = (UpdateLocationSettingsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(locationSettings, other.locationSettings);
    }

    /**
     * Converts this UpdateLocationSettingsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateLocationSettingsResponse [" + "errors=" + errors + ", locationSettings="
                + locationSettings + "]";
    }

    /**
     * Builds a new {@link UpdateLocationSettingsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateLocationSettingsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .locationSettings(getLocationSettings());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateLocationSettingsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CheckoutLocationSettings locationSettings;



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
         * Setter for locationSettings.
         * @param  locationSettings  CheckoutLocationSettings value for locationSettings.
         * @return Builder
         */
        public Builder locationSettings(CheckoutLocationSettings locationSettings) {
            this.locationSettings = locationSettings;
            return this;
        }

        /**
         * Builds a new {@link UpdateLocationSettingsResponse} object using the set fields.
         * @return {@link UpdateLocationSettingsResponse}
         */
        public UpdateLocationSettingsResponse build() {
            UpdateLocationSettingsResponse model =
                    new UpdateLocationSettingsResponse(errors, locationSettings);
            model.httpContext = httpContext;
            return model;
        }
    }
}
