package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListCustomersResponse type.
 */
public class ListCustomersResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param customers
     * @param cursor
     */
    @JsonCreator
    public ListCustomersResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("customers") List<Customer> customers,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.customers = customers;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Customer> customers;
    private final String cursor;

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
     * Getter for Customers.
     * An array of `Customer` objects that match the provided query.
     */
    @JsonGetter("customers")
    public List<Customer> getCustomers() {
        return this.customers;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor to retrieve the next set of results for the
     * original query. Only present if the request succeeded and additional results
     * are available.
     * See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, customers, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCustomersResponse)) {
            return false;
        }
        ListCustomersResponse listCustomersResponse = (ListCustomersResponse) obj;
        return Objects.equals(errors, listCustomersResponse.errors) &&
            Objects.equals(customers, listCustomersResponse.customers) &&
            Objects.equals(cursor, listCustomersResponse.cursor);
    }

    /**
     * Builds a new {@link ListCustomersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .customers(getCustomers())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListCustomersResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Customer> customers;
        private String cursor;

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
         * Setter for customers
         * @param customers
         * @return Builder
         */
        public Builder customers(List<Customer> customers) {
            this.customers = customers;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListCustomersResponse} object using the set fields.
         * @return {@link ListCustomersResponse}
         */
        public ListCustomersResponse build() {
            ListCustomersResponse model = new ListCustomersResponse(errors,
                customers,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
