package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListDisputeEvidenceRequest type.
 */
public class ListDisputeEvidenceRequest {
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListDisputeEvidenceRequest(@JsonProperty("cursor") String cursor) {
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     */
    protected ListDisputeEvidenceRequest(OptionalNullable<String> cursor) {
        this.cursor = cursor;
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDisputeEvidenceRequest)) {
            return false;
        }
        ListDisputeEvidenceRequest other = (ListDisputeEvidenceRequest) obj;
        return Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListDisputeEvidenceRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDisputeEvidenceRequest [" + "cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListDisputeEvidenceRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDisputeEvidenceRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListDisputeEvidenceRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Builds a new {@link ListDisputeEvidenceRequest} object using the set fields.
         * @return {@link ListDisputeEvidenceRequest}
         */
        public ListDisputeEvidenceRequest build() {
            return new ListDisputeEvidenceRequest(cursor);
        }
    }
}
