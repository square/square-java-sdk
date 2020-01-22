package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListAdditionalRecipientReceivableRefundsResponse type.
 */
public class ListAdditionalRecipientReceivableRefundsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param receivableRefunds
     * @param cursor
     */
    @JsonCreator
    public ListAdditionalRecipientReceivableRefundsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("receivable_refunds") List<AdditionalRecipientReceivableRefund> receivableRefunds,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.receivableRefunds = receivableRefunds;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<AdditionalRecipientReceivableRefund> receivableRefunds;
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
     * Getter for ReceivableRefunds.
     * An array of AdditionalRecipientReceivableRefunds that match your query.
     */
    @JsonGetter("receivable_refunds")
    public List<AdditionalRecipientReceivableRefund> getReceivableRefunds() {
        return this.receivableRefunds;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor for retrieving the next set of results,
     * if any remain. Provide this value as the `cursor` parameter in a subsequent
     * request to this endpoint.
     * See [Paginating results](#paginatingresults) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, receivableRefunds, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListAdditionalRecipientReceivableRefundsResponse)) {
            return false;
        }
        ListAdditionalRecipientReceivableRefundsResponse listAdditionalRecipientReceivableRefundsResponse = (ListAdditionalRecipientReceivableRefundsResponse) obj;
        return Objects.equals(errors, listAdditionalRecipientReceivableRefundsResponse.errors) &&
            Objects.equals(receivableRefunds, listAdditionalRecipientReceivableRefundsResponse.receivableRefunds) &&
            Objects.equals(cursor, listAdditionalRecipientReceivableRefundsResponse.cursor);
    }

    /**
     * Builds a new {@link ListAdditionalRecipientReceivableRefundsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListAdditionalRecipientReceivableRefundsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .receivableRefunds(getReceivableRefunds())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListAdditionalRecipientReceivableRefundsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<AdditionalRecipientReceivableRefund> receivableRefunds;
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
         * Setter for receivableRefunds
         * @param receivableRefunds
         * @return Builder
         */
        public Builder receivableRefunds(List<AdditionalRecipientReceivableRefund> receivableRefunds) {
            this.receivableRefunds = receivableRefunds;
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
         * Builds a new {@link ListAdditionalRecipientReceivableRefundsResponse} object using the set fields.
         * @return {@link ListAdditionalRecipientReceivableRefundsResponse}
         */
        public ListAdditionalRecipientReceivableRefundsResponse build() {
            ListAdditionalRecipientReceivableRefundsResponse model = new ListAdditionalRecipientReceivableRefundsResponse(errors,
                receivableRefunds,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
