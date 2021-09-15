
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
 * This is a model class for CreateBreakTypeResponse type.
 */
public class CreateBreakTypeResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final BreakType breakType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  breakType  BreakType value for breakType.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CreateBreakTypeResponse(
            @JsonProperty("break_type") BreakType breakType,
            @JsonProperty("errors") List<Error> errors) {
        this.breakType = breakType;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for BreakType.
     * A defined break template that sets an expectation for possible `Break` instances on a
     * `Shift`.
     * @return Returns the BreakType
     */
    @JsonGetter("break_type")
    public BreakType getBreakType() {
        return breakType;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breakType, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateBreakTypeResponse)) {
            return false;
        }
        CreateBreakTypeResponse other = (CreateBreakTypeResponse) obj;
        return Objects.equals(breakType, other.breakType)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CreateBreakTypeResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateBreakTypeResponse [" + "breakType=" + breakType + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link CreateBreakTypeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateBreakTypeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .breakType(getBreakType())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateBreakTypeResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private BreakType breakType;
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
         * Setter for breakType.
         * @param  breakType  BreakType value for breakType.
         * @return Builder
         */
        public Builder breakType(BreakType breakType) {
            this.breakType = breakType;
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
         * Builds a new {@link CreateBreakTypeResponse} object using the set fields.
         * @return {@link CreateBreakTypeResponse}
         */
        public CreateBreakTypeResponse build() {
            CreateBreakTypeResponse model =
                    new CreateBreakTypeResponse(breakType, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
