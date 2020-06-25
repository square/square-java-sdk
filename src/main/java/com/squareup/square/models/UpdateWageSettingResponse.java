package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpdateWageSettingResponse type.
 */
public class UpdateWageSettingResponse {

    /**
     * Initialization constructor.
     * @param wageSetting
     * @param errors
     */
    @JsonCreator
    public UpdateWageSettingResponse(
            @JsonProperty("wage_setting") WageSetting wageSetting,
            @JsonProperty("errors") List<Error> errors) {
        this.wageSetting = wageSetting;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final WageSetting wageSetting;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for WageSetting.
     * An object representing a team member's wage information.
     */
    @JsonGetter("wage_setting")
    public WageSetting getWageSetting() {
        return this.wageSetting;
    }

    /**
     * Getter for Errors.
     * The errors that occurred during the request.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateWageSettingResponse)) {
            return false;
        }
        UpdateWageSettingResponse updateWageSettingResponse = (UpdateWageSettingResponse) obj;
        return Objects.equals(wageSetting, updateWageSettingResponse.wageSetting) &&
            Objects.equals(errors, updateWageSettingResponse.errors);
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
     * Class to build instances of {@link UpdateWageSettingResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private WageSetting wageSetting;
        private List<Error> errors;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for wageSetting
         * @param wageSetting
         * @return Builder
         */
        public Builder wageSetting(WageSetting wageSetting) {
            this.wageSetting = wageSetting;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
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
            UpdateWageSettingResponse model = new UpdateWageSettingResponse(wageSetting,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
