
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for RetrieveCustomerResponse type.
 */
public class RetrieveCustomerResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Customer customer;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param customer Customer value for customer.
     */
    @JsonCreator
    public RetrieveCustomerResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("customer") Customer customer) {
        this.errors = errors;
        this.customer = customer;
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
     * Getter for Customer.
     * Represents a Square customer profile, which can have one or more cards on file associated
     * with it.
     * @return Returns the Customer
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCustomerResponse)) {
            return false;
        }
        RetrieveCustomerResponse other = (RetrieveCustomerResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(customer, other.customer);
    }

    /**
     * Builds a new {@link RetrieveCustomerResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCustomerResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .customer(getCustomer());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCustomerResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Customer customer;



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
         * Setter for customer.
         * @param customer Customer value for customer.
         * @return Builder
         */
        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCustomerResponse} object using the set fields.
         * @return {@link RetrieveCustomerResponse}
         */
        public RetrieveCustomerResponse build() {
            RetrieveCustomerResponse model =
                    new RetrieveCustomerResponse(errors,
                            customer);
            model.httpContext = httpContext;
            return model;
        }
    }
}
