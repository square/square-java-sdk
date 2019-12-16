package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class SearchCustomersResponse {

    @JsonCreator
    public SearchCustomersResponse(
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

    @Override
    public int hashCode() {
        return Objects.hash(errors, customers, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchCustomersResponse)) {
            return false;
        }
        SearchCustomersResponse searchCustomersResponse = (SearchCustomersResponse) o;
        return Objects.equals(errors, searchCustomersResponse.errors) &&
            Objects.equals(customers, searchCustomersResponse.customers) &&
            Objects.equals(cursor, searchCustomersResponse.cursor);
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
     * Getter for Customers.
     * An array of `Customer` objects that match a query.
     */
    @JsonGetter("customers")
    public List<Customer> getCustomers() { 
        return this.customers;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor that can be used during subsequent calls
     * to SearchCustomers to retrieve the next set of results associated
     * with the original query. Pagination cursors are only present when
     * a request succeeds and additional results are available.
     * See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .customers(getCustomers())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Customer> customers;
        private String cursor;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder customers(List<Customer> value) {
            customers = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public SearchCustomersResponse build() {
            SearchCustomersResponse model = new SearchCustomersResponse(errors,
                customers,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
