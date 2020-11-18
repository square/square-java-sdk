
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateWageSettingResponse type.
 */
public class UpdateWageSettingResponse {
    private HttpContext httpContext;
    private final WageSetting wageSetting;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param wageSetting WageSetting value for wageSetting.
     * @param errors List of Error value for errors.
     */
    @JsonCreator
    public UpdateWageSettingResponse(
            @JsonProperty("wage_setting") WageSetting wageSetting,
            @JsonProperty("errors") List<Error> errors) {
        this.wageSetting = wageSetting;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for WageSetting.
     * An object representing a team member's wage information.
     * @return Returns the WageSetting
     */
    @JsonGetter("wage_setting")
    public WageSetting getWageSetting() {
        return this.wageSetting;
    }

    /**
     * Getter for Errors.
     * The errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wageSetting, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateWageSettingResponse)) {
            return false;
        }
        UpdateWageSettingResponse other = (UpdateWageSettingResponse) obj;
        return Objects.equals(wageSetting, other.wageSetting)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this UpdateWageSettingResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateWageSettingResponse [" + "wageSetting=" + wageSetting + ", errors=" + errors
                + "]";
    }

    /**
     * Builds a new {@link UpdateWageSettingResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateWageSettingResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .wageSetting(getWageSetting())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateWageSettingResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private WageSetting wageSetting;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for wageSetting.
         * @param wageSetting WageSetting value for wageSetting.
         * @return Builder
         */
        public Builder wageSetting(WageSetting wageSetting) {
            this.wageSetting = wageSetting;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link UpdateWageSettingResponse} object using the set fields.
         * @return {@link UpdateWageSettingResponse}
         */
        public UpdateWageSettingResponse build() {
            UpdateWageSettingResponse model =
                    new UpdateWageSettingResponse(wageSetting, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
