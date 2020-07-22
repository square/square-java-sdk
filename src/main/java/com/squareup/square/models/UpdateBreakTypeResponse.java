package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpdateBreakTypeResponse type.
 */
public class UpdateBreakTypeResponse {

    /**
     * Initialization constructor.
     * @param breakType
     * @param errors
     */
    @JsonCreator
    public UpdateBreakTypeResponse(
            @JsonProperty("break_type") BreakType breakType,
            @JsonProperty("errors") List<Error> errors) {
        this.breakType = breakType;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final BreakType breakType;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for BreakType.
     * A defined break template that sets an expectation for possible `Break`
     * instances on a `Shift`.
     */
    @JsonGetter("break_type")
    public BreakType getBreakType() {
        return this.breakType;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(breakType, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateBreakTypeResponse)) {
            return false;
        }
        UpdateBreakTypeResponse updateBreakTypeResponse = (UpdateBreakTypeResponse) obj;
        return Objects.equals(breakType, updateBreakTypeResponse.breakType) &&
            Objects.equals(errors, updateBreakTypeResponse.errors);
    }

    /**
     * Builds a new {@link UpdateBreakTypeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateBreakTypeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .breakType(getBreakType())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateBreakTypeResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private BreakType breakType;
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
         * Setter for breakType
         * @param breakType
         * @return Builder
         */
        public Builder breakType(BreakType breakType) {
            this.breakType = breakType;
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
         * Builds a new {@link UpdateBreakTypeResponse} object using the set fields.
         * @return {@link UpdateBreakTypeResponse}
         */
        public UpdateBreakTypeResponse build() {
            UpdateBreakTypeResponse model = new UpdateBreakTypeResponse(breakType,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
