package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchInvoicesResponse type.
 */
public class SearchInvoicesResponse {

    /**
     * Initialization constructor.
     * @param invoices
     * @param cursor
     * @param errors
     */
    @JsonCreator
    public SearchInvoicesResponse(
            @JsonProperty("invoices") List<Invoice> invoices,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.invoices = invoices;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<Invoice> invoices;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Invoices.
     * The list of invoices returned by the search.
     */
    @JsonGetter("invoices")
    public List<Invoice> getInvoices() {
        return this.invoices;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can use in a 
     * subsequent request to fetch the next set of invoices. If empty, this is the final 
     * response. 
     * For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(invoices, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchInvoicesResponse)) {
            return false;
        }
        SearchInvoicesResponse searchInvoicesResponse = (SearchInvoicesResponse) obj;
        return Objects.equals(invoices, searchInvoicesResponse.invoices) &&
            Objects.equals(cursor, searchInvoicesResponse.cursor) &&
            Objects.equals(errors, searchInvoicesResponse.errors);
    }

    /**
     * Builds a new {@link SearchInvoicesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchInvoicesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .invoices(getInvoices())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchInvoicesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Invoice> invoices;
        private String cursor;
        private List<Error> errors;

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
         * Setter for invoices
         * @param invoices
         * @return Builder
         */
        public Builder invoices(List<Invoice> invoices) {
            this.invoices = invoices;
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
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link SearchInvoicesResponse} object using the set fields.
         * @return {@link SearchInvoicesResponse}
         */
        public SearchInvoicesResponse build() {
            SearchInvoicesResponse model = new SearchInvoicesResponse(invoices,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
