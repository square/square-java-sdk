package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveWageSettingResponse type.
 */
public class RetrieveWageSettingResponse {

    /**
     * Initialization constructor.
     * @param wageSetting
     * @param errors
     */
    @JsonCreator
    public RetrieveWageSettingResponse(
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
        if(!(obj instanceof RetrieveWageSettingResponse)) {
            return false;
        }
        RetrieveWageSettingResponse retrieveWageSettingResponse = (RetrieveWageSettingResponse) obj;
        return Objects.equals(wageSetting, retrieveWageSettingResponse.wageSetting) &&
            Objects.equals(errors, retrieveWageSettingResponse.errors);
    }

    /**
     * Builds a new {@link RetrieveWageSettingResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveWageSettingResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .wageSetting(getWageSetting())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveWageSettingResponse}
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
         * Builds a new {@link RetrieveWageSettingResponse} object using the set fields.
         * @return {@link RetrieveWageSettingResponse}
         */
        public RetrieveWageSettingResponse build() {
            RetrieveWageSettingResponse model = new RetrieveWageSettingResponse(wageSetting,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
