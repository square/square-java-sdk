
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListInvoicesResponse type.
 */
public class ListInvoicesResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Invoice> invoices;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  invoices  List of Invoice value for invoices.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListInvoicesResponse(
            @JsonProperty("invoices") List<Invoice> invoices,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.invoices = invoices;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Invoices.
     * The invoices retrieved.
     * @return Returns the List of Invoice
     */
    @JsonGetter("invoices")
    public List<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can use in a subsequent request
     * to retrieve the next set of invoices. If empty, this is the final response. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoices, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListInvoicesResponse)) {
            return false;
        }
        ListInvoicesResponse other = (ListInvoicesResponse) obj;
        return Objects.equals(invoices, other.invoices)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListInvoicesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListInvoicesResponse [" + "invoices=" + invoices + ", cursor=" + cursor
                + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListInvoicesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListInvoicesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .invoices(getInvoices())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListInvoicesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Invoice> invoices;
        private String cursor;
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
         * Setter for invoices.
         * @param  invoices  List of Invoice value for invoices.
         * @return Builder
         */
        public Builder invoices(List<Invoice> invoices) {
            this.invoices = invoices;
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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link ListInvoicesResponse} object using the set fields.
         * @return {@link ListInvoicesResponse}
         */
        public ListInvoicesResponse build() {
            ListInvoicesResponse model =
                    new ListInvoicesResponse(invoices, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
