package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListDisputesResponse type.
 */
public class ListDisputesResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param disputes
     * @param cursor
     */
    @JsonCreator
    public ListDisputesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("disputes") List<Dispute> disputes,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.disputes = disputes;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Dispute> disputes;
    private final String cursor;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Disputes.
     * The list of Disputes.
     */
    @JsonGetter("disputes")
    public List<Dispute> getDisputes() {
        return this.disputes;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request.
     * If unset, this is the final response.
     * For more information, see [Paginating](https://developer.squareup.com/docs/basics/api101/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, disputes, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListDisputesResponse)) {
            return false;
        }
        ListDisputesResponse listDisputesResponse = (ListDisputesResponse) obj;
        return Objects.equals(errors, listDisputesResponse.errors) &&
            Objects.equals(disputes, listDisputesResponse.disputes) &&
            Objects.equals(cursor, listDisputesResponse.cursor);
    }

    /**
     * Builds a new {@link ListDisputesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDisputesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .disputes(getDisputes())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListDisputesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Dispute> disputes;
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
         * Setter for disputes
         * @param disputes
         * @return Builder
         */
        public Builder disputes(List<Dispute> disputes) {
            this.disputes = disputes;
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
         * Builds a new {@link ListDisputesResponse} object using the set fields.
         * @return {@link ListDisputesResponse}
         */
        public ListDisputesResponse build() {
            ListDisputesResponse model = new ListDisputesResponse(errors,
                disputes,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
