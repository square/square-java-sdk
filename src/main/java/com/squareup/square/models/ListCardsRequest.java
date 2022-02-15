
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListCardsRequest type.
 */
public class ListCardsRequest {
    private final String cursor;
    private final String customerId;
    private final Boolean includeDisabled;
    private final String referenceId;
    private final String sortOrder;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  customerId  String value for customerId.
     * @param  includeDisabled  Boolean value for includeDisabled.
     * @param  referenceId  String value for referenceId.
     * @param  sortOrder  String value for sortOrder.
     */
    @JsonCreator
    public ListCardsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("include_disabled") Boolean includeDisabled,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("sort_order") String sortOrder) {
        this.cursor = cursor;
        this.customerId = customerId;
        this.includeDisabled = includeDisabled;
        this.referenceId = referenceId;
        this.sortOrder = sortOrder;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for CustomerId.
     * Limit results to cards associated with the customer supplied. By default, all cards owned by
     * the merchant are returned.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for IncludeDisabled.
     * Includes disabled cards. By default, all enabled cards owned by the merchant are returned.
     * @return Returns the Boolean
     */
    @JsonGetter("include_disabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIncludeDisabled() {
        return includeDisabled;
    }

    /**
     * Getter for ReferenceId.
     * Limit results to cards associated with the reference_id supplied.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, customerId, includeDisabled, referenceId, sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCardsRequest)) {
            return false;
        }
        ListCardsRequest other = (ListCardsRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(includeDisabled, other.includeDisabled)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(sortOrder, other.sortOrder);
    }

    /**
     * Converts this ListCardsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCardsRequest [" + "cursor=" + cursor + ", customerId=" + customerId
                + ", includeDisabled=" + includeDisabled + ", referenceId=" + referenceId
                + ", sortOrder=" + sortOrder + "]";
    }

    /**
     * Builds a new {@link ListCardsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCardsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cursor(getCursor())
                .customerId(getCustomerId())
                .includeDisabled(getIncludeDisabled())
                .referenceId(getReferenceId())
                .sortOrder(getSortOrder());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCardsRequest}.
     */
    public static class Builder {
        private String cursor;
        private String customerId;
        private Boolean includeDisabled;
        private String referenceId;
        private String sortOrder;



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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Setter for includeDisabled.
         * @param  includeDisabled  Boolean value for includeDisabled.
         * @return Builder
         */
        public Builder includeDisabled(Boolean includeDisabled) {
            this.includeDisabled = includeDisabled;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        /**
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Builds a new {@link ListCardsRequest} object using the set fields.
         * @return {@link ListCardsRequest}
         */
        public ListCardsRequest build() {
            return new ListCardsRequest(cursor, customerId, includeDisabled, referenceId,
                    sortOrder);
        }
    }
}
