
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for RegisterDomainResponse type.
 */
public class RegisterDomainResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final String status;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param status String value for status.
     */
    @JsonCreator
    public RegisterDomainResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("status") String status) {
        this.errors = errors;
        this.status = status;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Status.
     * The status of domain registration.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegisterDomainResponse)) {
            return false;
        }
        RegisterDomainResponse other = (RegisterDomainResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(status, other.status);
    }

    /**
     * Builds a new {@link RegisterDomainResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RegisterDomainResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link RegisterDomainResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String status;



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
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for status.
         * @param status String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link RegisterDomainResponse} object using the set fields.
         * @return {@link RegisterDomainResponse}
         */
        public RegisterDomainResponse build() {
            RegisterDomainResponse model =
                    new RegisterDomainResponse(errors,
                            status);
            model.httpContext = httpContext;
            return model;
        }
    }
}
