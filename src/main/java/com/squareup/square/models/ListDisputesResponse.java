
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
 * This is a model class for ListDisputesResponse type.
 */
public class ListDisputesResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Dispute> disputes;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  disputes  List of Dispute value for disputes.
     * @param  cursor  String value for cursor.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
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

    /**
     * Getter for Disputes.
     * The list of disputes.
     * @return Returns the List of Dispute
     */
    @JsonGetter("disputes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Dispute> getDisputes() {
        return disputes;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, disputes, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDisputesResponse)) {
            return false;
        }
        ListDisputesResponse other = (ListDisputesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(disputes, other.disputes)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListDisputesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDisputesResponse [" + "errors=" + errors + ", disputes=" + disputes
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link ListDisputesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Dispute> disputes;
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
         * Setter for disputes.
         * @param  disputes  List of Dispute value for disputes.
         * @return Builder
         */
        public Builder disputes(List<Dispute> disputes) {
            this.disputes = disputes;
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
         * Builds a new {@link ListDisputesResponse} object using the set fields.
         * @return {@link ListDisputesResponse}
         */
        public ListDisputesResponse build() {
            ListDisputesResponse model =
                    new ListDisputesResponse(errors, disputes, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
