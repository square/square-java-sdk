package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreateCustomerResponse {

    @JsonCreator
    public CreateCustomerResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("customer") Customer customer) {
        this.errors = errors;
        this.customer = customer;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Customer customer;

    @Override
    public int hashCode() {
        return Objects.hash(errors, customer);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateCustomerResponse)) {
            return false;
        }
        CreateCustomerResponse createCustomerResponse = (CreateCustomerResponse) o;
        return Objects.equals(errors, createCustomerResponse.errors) &&
            Objects.equals(customer, createCustomerResponse.customer);
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
     * Getter for Customer.
     * Represents a Square customer profile, which can have one or more
     * cards on file associated with it.
     */
    @JsonGetter("customer")
    public Customer getCustomer() { 
        return this.customer;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .customer(getCustomer());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Customer customer;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder customer(Customer value) {
            customer = value;
            return this;
        }

        public CreateCustomerResponse build() {
            CreateCustomerResponse model = new CreateCustomerResponse(errors,
                customer);
            model.httpContext = httpContext;
            return model;
        }
    }
}
