
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
 * This is a model class for ListPayoutEntriesResponse type.
 */
public class ListPayoutEntriesResponse {
    private HttpContext httpContext;
    private final List<PayoutEntry> payoutEntries;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  payoutEntries  List of PayoutEntry value for payoutEntries.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListPayoutEntriesResponse(
            @JsonProperty("payout_entries") List<PayoutEntry> payoutEntries,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.payoutEntries = payoutEntries;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for PayoutEntries.
     * The requested list of payout entries, ordered with the given or default sort order.
     * @return Returns the List of PayoutEntry
     */
    @JsonGetter("payout_entries")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<PayoutEntry> getPayoutEntries() {
        return payoutEntries;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payoutEntries, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListPayoutEntriesResponse)) {
            return false;
        }
        ListPayoutEntriesResponse other = (ListPayoutEntriesResponse) obj;
        return Objects.equals(payoutEntries, other.payoutEntries)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListPayoutEntriesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPayoutEntriesResponse [" + "payoutEntries=" + payoutEntries + ", cursor="
                + cursor + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListPayoutEntriesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPayoutEntriesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .payoutEntries(getPayoutEntries())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListPayoutEntriesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<PayoutEntry> payoutEntries;
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
         * Setter for payoutEntries.
         * @param  payoutEntries  List of PayoutEntry value for payoutEntries.
         * @return Builder
         */
        public Builder payoutEntries(List<PayoutEntry> payoutEntries) {
            this.payoutEntries = payoutEntries;
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
         * Builds a new {@link ListPayoutEntriesResponse} object using the set fields.
         * @return {@link ListPayoutEntriesResponse}
         */
        public ListPayoutEntriesResponse build() {
            ListPayoutEntriesResponse model =
                    new ListPayoutEntriesResponse(payoutEntries, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
