
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveWageSettingResponse type.
 */
public class RetrieveWageSettingResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final WageSetting wageSetting;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  wageSetting  WageSetting value for wageSetting.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RetrieveWageSettingResponse(
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
        return wageSetting;
    }

    /**
     * Getter for Errors.
     * The errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
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
        if (!(obj instanceof RetrieveWageSettingResponse)) {
            return false;
        }
        RetrieveWageSettingResponse other = (RetrieveWageSettingResponse) obj;
        return Objects.equals(wageSetting, other.wageSetting)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveWageSettingResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveWageSettingResponse [" + "wageSetting=" + wageSetting + ", errors=" + errors
                + "]";
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
     * Class to build instances of {@link RetrieveWageSettingResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private WageSetting wageSetting;
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
         * Setter for wageSetting.
         * @param  wageSetting  WageSetting value for wageSetting.
         * @return Builder
         */
        public Builder wageSetting(WageSetting wageSetting) {
            this.wageSetting = wageSetting;
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
         * Builds a new {@link RetrieveWageSettingResponse} object using the set fields.
         * @return {@link RetrieveWageSettingResponse}
         */
        public RetrieveWageSettingResponse build() {
            RetrieveWageSettingResponse model =
                    new RetrieveWageSettingResponse(wageSetting, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
