package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpdateCustomerResponse type.
 */
public class UpdateCustomerResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param customer
     */
    @JsonCreator
    public UpdateCustomerResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("customer") Customer customer) {
        this.errors = errors;
        this.customer = customer;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Customer customer;

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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, customer);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateCustomerResponse)) {
            return false;
        }
        UpdateCustomerResponse updateCustomerResponse = (UpdateCustomerResponse) obj;
        return Objects.equals(errors, updateCustomerResponse.errors) &&
            Objects.equals(customer, updateCustomerResponse.customer);
    }

    /**
     * Builds a new {@link UpdateCustomerResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateCustomerResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .customer(getCustomer());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateCustomerResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Customer customer;

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
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for customer
         * @param customer
         * @return Builder
         */
        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        /**
         * Builds a new {@link UpdateCustomerResponse} object using the set fields.
         * @return {@link UpdateCustomerResponse}
         */
        public UpdateCustomerResponse build() {
            UpdateCustomerResponse model = new UpdateCustomerResponse(errors,
                customer);
            model.httpContext = httpContext;
            return model;
        }
    }
}
