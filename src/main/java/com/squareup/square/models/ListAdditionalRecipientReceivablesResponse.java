package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListAdditionalRecipientReceivablesResponse {

    @JsonCreator
    public ListAdditionalRecipientReceivablesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("receivables") List<AdditionalRecipientReceivable> receivables,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.receivables = receivables;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<AdditionalRecipientReceivable> receivables;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(errors, receivables, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListAdditionalRecipientReceivablesResponse)) {
            return false;
        }
        ListAdditionalRecipientReceivablesResponse listAdditionalRecipientReceivablesResponse = (ListAdditionalRecipientReceivablesResponse) o;
        return Objects.equals(errors, listAdditionalRecipientReceivablesResponse.errors) &&
            Objects.equals(receivables, listAdditionalRecipientReceivablesResponse.receivables) &&
            Objects.equals(cursor, listAdditionalRecipientReceivablesResponse.cursor);
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
     * Getter for Receivables.
     * An array of AdditionalRecipientReceivables that match your query.
     */
    @JsonGetter("receivables")
    public List<AdditionalRecipientReceivable> getReceivables() { 
        return this.receivables;
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
            .receivables(getReceivables())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<AdditionalRecipientReceivable> receivables;
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
        public Builder receivables(List<AdditionalRecipientReceivable> value) {
            receivables = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListAdditionalRecipientReceivablesResponse build() {
            ListAdditionalRecipientReceivablesResponse model = new ListAdditionalRecipientReceivablesResponse(errors,
                receivables,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
