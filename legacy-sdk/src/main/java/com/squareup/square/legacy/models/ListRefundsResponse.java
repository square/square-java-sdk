package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListRefundsResponse type.
 */
public class ListRefundsResponse {
    private final List<Error> errors;
    private final List<Refund> refunds;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  refunds  List of Refund value for refunds.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListRefundsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refunds") List<Refund> refunds,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.refunds = refunds;
        this.cursor = cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Refunds.
     * An array of refunds that match your query.
     * @return Returns the List of Refund
     */
    @JsonGetter("refunds")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Refund> getRefunds() {
        return refunds;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor for retrieving the next set of results, if any remain. Provide this value
     * as the `cursor` parameter in a subsequent request to this endpoint. See [Paginating
     * results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, refunds, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListRefundsResponse)) {
            return false;
        }
        ListRefundsResponse other = (ListRefundsResponse) obj;
        return Objects.equals(errors, other.errors)
                && Objects.equals(refunds, other.refunds)
                && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListRefundsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListRefundsResponse [" + "errors=" + errors + ", refunds=" + refunds + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListRefundsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListRefundsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder =
                new Builder().errors(getErrors()).refunds(getRefunds()).cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListRefundsResponse}.
     */
    public static class Builder {
        private List<Error> errors;
        private List<Refund> refunds;
        private String cursor;

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
         * Setter for refunds.
         * @param  refunds  List of Refund value for refunds.
         * @return Builder
         */
        public Builder refunds(List<Refund> refunds) {
            this.refunds = refunds;
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
         * Builds a new {@link ListRefundsResponse} object using the set fields.
         * @return {@link ListRefundsResponse}
         */
        public ListRefundsResponse build() {
            return new ListRefundsResponse(errors, refunds, cursor);
        }
    }
}
