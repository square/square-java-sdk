package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListCustomerSegmentsResponse type.
 */
public class ListCustomerSegmentsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param segments
     * @param cursor
     */
    @JsonCreator
    public ListCustomerSegmentsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("segments") List<CustomerSegment> segments,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.segments = segments;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<CustomerSegment> segments;
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
     * Getter for Segments.
     * The list of customer segments belonging to the associated Square account.
     */
    @JsonGetter("segments")
    public List<CustomerSegment> getSegments() {
        return this.segments;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor to be used in subsequent calls to __ListCustomerSegments__
     * to retrieve the next set of query results. Only present only if the request succeeded and
     * additional results are available.
     * See the [Pagination guide](https://developer.squareup.com/docs/docs/working-with-apis/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, segments, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCustomerSegmentsResponse)) {
            return false;
        }
        ListCustomerSegmentsResponse listCustomerSegmentsResponse = (ListCustomerSegmentsResponse) obj;
        return Objects.equals(errors, listCustomerSegmentsResponse.errors) &&
            Objects.equals(segments, listCustomerSegmentsResponse.segments) &&
            Objects.equals(cursor, listCustomerSegmentsResponse.cursor);
    }

    /**
     * Builds a new {@link ListCustomerSegmentsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerSegmentsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .segments(getSegments())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerSegmentsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CustomerSegment> segments;
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
         * Setter for segments
         * @param segments
         * @return Builder
         */
        public Builder segments(List<CustomerSegment> segments) {
            this.segments = segments;
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
         * Builds a new {@link ListCustomerSegmentsResponse} object using the set fields.
         * @return {@link ListCustomerSegmentsResponse}
         */
        public ListCustomerSegmentsResponse build() {
            ListCustomerSegmentsResponse model = new ListCustomerSegmentsResponse(errors,
                segments,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
