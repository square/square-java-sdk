
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
 * This is a model class for ListCustomerSegmentsResponse type.
 */
public class ListCustomerSegmentsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CustomerSegment> segments;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  segments  List of CustomerSegment value for segments.
     * @param  cursor  String value for cursor.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Segments.
     * The list of customer segments belonging to the associated Square account.
     * @return Returns the List of CustomerSegment
     */
    @JsonGetter("segments")
    public List<CustomerSegment> getSegments() {
        return segments;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor to be used in subsequent calls to `ListCustomerSegments` to retrieve the
     * next set of query results. The cursor is only present if the request succeeded and additional
     * results are available. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, segments, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomerSegmentsResponse)) {
            return false;
        }
        ListCustomerSegmentsResponse other = (ListCustomerSegmentsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(segments, other.segments)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListCustomerSegmentsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerSegmentsResponse [" + "errors=" + errors + ", segments=" + segments
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link ListCustomerSegmentsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CustomerSegment> segments;
        private String cursor;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for segments.
         * @param  segments  List of CustomerSegment value for segments.
         * @return Builder
         */
        public Builder segments(List<CustomerSegment> segments) {
            this.segments = segments;
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
         * Builds a new {@link ListCustomerSegmentsResponse} object using the set fields.
         * @return {@link ListCustomerSegmentsResponse}
         */
        public ListCustomerSegmentsResponse build() {
            ListCustomerSegmentsResponse model =
                    new ListCustomerSegmentsResponse(errors, segments, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
