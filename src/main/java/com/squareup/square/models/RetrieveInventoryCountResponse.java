
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
 * This is a model class for RetrieveInventoryCountResponse type.
 */
public class RetrieveInventoryCountResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<InventoryCount> counts;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  counts  List of InventoryCount value for counts.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public RetrieveInventoryCountResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("counts") List<InventoryCount> counts,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.counts = counts;
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
     * Getter for Counts.
     * The current calculated inventory counts for the requested object and locations.
     * @return Returns the List of InventoryCount
     */
    @JsonGetter("counts")
    public List<InventoryCount> getCounts() {
        return counts;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final
     * response. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, counts, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveInventoryCountResponse)) {
            return false;
        }
        RetrieveInventoryCountResponse other = (RetrieveInventoryCountResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(counts, other.counts)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this RetrieveInventoryCountResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveInventoryCountResponse [" + "errors=" + errors + ", counts=" + counts
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link RetrieveInventoryCountResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveInventoryCountResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .counts(getCounts())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveInventoryCountResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryCount> counts;
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
         * Setter for counts.
         * @param  counts  List of InventoryCount value for counts.
         * @return Builder
         */
        public Builder counts(List<InventoryCount> counts) {
            this.counts = counts;
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
         * Builds a new {@link RetrieveInventoryCountResponse} object using the set fields.
         * @return {@link RetrieveInventoryCountResponse}
         */
        public RetrieveInventoryCountResponse build() {
            RetrieveInventoryCountResponse model =
                    new RetrieveInventoryCountResponse(errors, counts, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
