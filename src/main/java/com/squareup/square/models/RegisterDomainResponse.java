package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RegisterDomainResponse {

    @JsonCreator
    public RegisterDomainResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("status") String status) {
        this.errors = errors;
        this.status = status;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final String status;

    @Override
    public int hashCode() {
        return Objects.hash(errors, status);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RegisterDomainResponse)) {
            return false;
        }
        RegisterDomainResponse registerDomainResponse = (RegisterDomainResponse) o;
        return Objects.equals(errors, registerDomainResponse.errors) &&
            Objects.equals(status, registerDomainResponse.status);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for Status.
     * The status of domain registration.
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .status(getStatus());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String status;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }

        public RegisterDomainResponse build() {
            RegisterDomainResponse model = new RegisterDomainResponse(errors,
                status);
            model.httpContext = httpContext;
            return model;
        }
    }
}
