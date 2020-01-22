package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListAdditionalRecipientReceivablesResponse type.
 */
public class ListAdditionalRecipientReceivablesResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param receivables
     * @param cursor
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, receivables, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListAdditionalRecipientReceivablesResponse)) {
            return false;
        }
        ListAdditionalRecipientReceivablesResponse listAdditionalRecipientReceivablesResponse = (ListAdditionalRecipientReceivablesResponse) obj;
        return Objects.equals(errors, listAdditionalRecipientReceivablesResponse.errors) &&
            Objects.equals(receivables, listAdditionalRecipientReceivablesResponse.receivables) &&
            Objects.equals(cursor, listAdditionalRecipientReceivablesResponse.cursor);
    }

    /**
     * Builds a new {@link ListAdditionalRecipientReceivablesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListAdditionalRecipientReceivablesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .receivables(getReceivables())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListAdditionalRecipientReceivablesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<AdditionalRecipientReceivable> receivables;
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
         * Setter for receivables
         * @param receivables
         * @return Builder
         */
        public Builder receivables(List<AdditionalRecipientReceivable> receivables) {
            this.receivables = receivables;
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
         * Builds a new {@link ListAdditionalRecipientReceivablesResponse} object using the set fields.
         * @return {@link ListAdditionalRecipientReceivablesResponse}
         */
        public ListAdditionalRecipientReceivablesResponse build() {
            ListAdditionalRecipientReceivablesResponse model = new ListAdditionalRecipientReceivablesResponse(errors,
                receivables,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
