package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListRefundsResponse {

    @JsonCreator
    public ListRefundsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refunds") List<Refund> refunds,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.refunds = refunds;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Refund> refunds;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(errors, refunds, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListRefundsResponse)) {
            return false;
        }
        ListRefundsResponse listRefundsResponse = (ListRefundsResponse) o;
        return Objects.equals(errors, listRefundsResponse.errors) &&
            Objects.equals(refunds, listRefundsResponse.refunds) &&
            Objects.equals(cursor, listRefundsResponse.cursor);
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
     * Getter for Refunds.
     * An array of refunds that match your query.
     */
    @JsonGetter("refunds")
    public List<Refund> getRefunds() { 
        return this.refunds;
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
            .refunds(getRefunds())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Refund> refunds;
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
        public Builder refunds(List<Refund> value) {
            refunds = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListRefundsResponse build() {
            ListRefundsResponse model = new ListRefundsResponse(errors,
                refunds,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
