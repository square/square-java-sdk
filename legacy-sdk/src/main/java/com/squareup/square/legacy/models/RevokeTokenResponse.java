package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RevokeTokenResponse type.
 */
public class RevokeTokenResponse {
    private HttpContext httpContext;
    private final Boolean success;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  success  Boolean value for success.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RevokeTokenResponse(@JsonProperty("success") Boolean success, @JsonProperty("errors") List<Error> errors) {
        this.success = success;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Success.
     * If the request is successful, this is `true`.
     * @return Returns the Boolean
     */
    @JsonGetter("success")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getSuccess() {
        return success;
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
        return Objects.hash(success, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RevokeTokenResponse)) {
            return false;
        }
        RevokeTokenResponse other = (RevokeTokenResponse) obj;
        return Objects.equals(success, other.success) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RevokeTokenResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RevokeTokenResponse [" + "success=" + success + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link RevokeTokenResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RevokeTokenResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().success(getSuccess()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link RevokeTokenResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Boolean success;
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
         * Setter for success.
         * @param  success  Boolean value for success.
         * @return Builder
         */
        public Builder success(Boolean success) {
            this.success = success;
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
         * Builds a new {@link RevokeTokenResponse} object using the set fields.
         * @return {@link RevokeTokenResponse}
         */
        public RevokeTokenResponse build() {
            RevokeTokenResponse model = new RevokeTokenResponse(success, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
