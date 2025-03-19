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
 * This is a model class for SearchCustomersResponse type.
 */
public class SearchCustomersResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Customer> customers;
    private final String cursor;
    private final Long count;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  customers  List of Customer value for customers.
     * @param  cursor  String value for cursor.
     * @param  count  Long value for count.
     */
    @JsonCreator
    public SearchCustomersResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("customers") List<Customer> customers,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("count") Long count) {
        this.errors = errors;
        this.customers = customers;
        this.cursor = cursor;
        this.count = count;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
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

    /**
     * Getter for Customers.
     * The customer profiles that match the search query. If any search condition is not met, the
     * result is an empty object (`{}`). Only customer profiles with public information
     * (`given_name`, `family_name`, `company_name`, `email_address`, or `phone_number`) are
     * included in the response.
     * @return Returns the List of Customer
     */
    @JsonGetter("customers")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor that can be used during subsequent calls to `SearchCustomers` to retrieve
     * the next set of results associated with the original query. Pagination cursors are only
     * present when a request succeeds and additional results are available. For more information,
     * see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Count.
     * The total count of customers associated with the Square account that match the search query.
     * Only customer profiles with public information (`given_name`, `family_name`, `company_name`,
     * `email_address`, or `phone_number`) are counted. This field is present only if `count` is set
     * to `true` in the request.
     * @return Returns the Long
     */
    @JsonGetter("count")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getCount() {
        return count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, customers, cursor, count);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCustomersResponse)) {
            return false;
        }
        SearchCustomersResponse other = (SearchCustomersResponse) obj;
        return Objects.equals(errors, other.errors)
                && Objects.equals(customers, other.customers)
                && Objects.equals(cursor, other.cursor)
                && Objects.equals(count, other.count);
    }

    /**
     * Converts this SearchCustomersResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchCustomersResponse [" + "errors=" + errors + ", customers=" + customers + ", cursor=" + cursor
                + ", count=" + count + "]";
    }

    /**
     * Builds a new {@link SearchCustomersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchCustomersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .customers(getCustomers())
                .cursor(getCursor())
                .count(getCount());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchCustomersResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Customer> customers;
        private String cursor;
        private Long count;

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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for customers.
         * @param  customers  List of Customer value for customers.
         * @return Builder
         */
        public Builder customers(List<Customer> customers) {
            this.customers = customers;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for count.
         * @param  count  Long value for count.
         * @return Builder
         */
        public Builder count(Long count) {
            this.count = count;
            return this;
        }

        /**
         * Builds a new {@link SearchCustomersResponse} object using the set fields.
         * @return {@link SearchCustomersResponse}
         */
        public SearchCustomersResponse build() {
            SearchCustomersResponse model = new SearchCustomersResponse(errors, customers, cursor, count);
            model.httpContext = httpContext;
            return model;
        }
    }
}
