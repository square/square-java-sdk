package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListAdditionalRecipientReceivableRefundsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, receivableRefunds, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListAdditionalRecipientReceivableRefundsResponse)) {
            return false;
        }
        ListAdditionalRecipientReceivableRefundsResponse listAdditionalRecipientReceivableRefundsResponse = (ListAdditionalRecipientReceivableRefundsResponse) o;
        return Objects.equals(errors, listAdditionalRecipientReceivableRefundsResponse.errors) &&
            Objects.equals(receivableRefunds, listAdditionalRecipientReceivableRefundsResponse.receivableRefunds) &&
            Objects.equals(cursor, listAdditionalRecipientReceivableRefundsResponse.cursor);
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .receivableRefunds(getReceivableRefunds())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<AdditionalRecipientReceivableRefund> receivableRefunds;
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
        public Builder receivableRefunds(List<AdditionalRecipientReceivableRefund> value) {
            receivableRefunds = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListAdditionalRecipientReceivableRefundsResponse build() {
            ListAdditionalRecipientReceivableRefundsResponse model = new ListAdditionalRecipientReceivableRefundsResponse(errors,
                receivableRefunds,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
