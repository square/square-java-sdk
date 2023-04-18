
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListCardsRequest type.
 */
public class ListCardsRequest {
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<String> customerId;
    private final OptionalNullable<Boolean> includeDisabled;
    private final OptionalNullable<String> referenceId;
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
        this.cursor = OptionalNullable.of(cursor);
        this.customerId = OptionalNullable.of(customerId);
        this.includeDisabled = OptionalNullable.of(includeDisabled);
        this.referenceId = OptionalNullable.of(referenceId);
        this.sortOrder = sortOrder;
    }

    /**
     * Internal initialization constructor.
     */
    protected ListCardsRequest(OptionalNullable<String> cursor, OptionalNullable<String> customerId,
            OptionalNullable<Boolean> includeDisabled, OptionalNullable<String> referenceId,
            String sortOrder) {
        this.cursor = cursor;
        this.customerId = customerId;
        this.includeDisabled = includeDisabled;
        this.referenceId = referenceId;
        this.sortOrder = sortOrder;
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     * for more information.
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
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     * for more information.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for CustomerId.
     * Limit results to cards associated with the customer supplied. By default, all cards owned by
     * the merchant are returned.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for CustomerId.
     * Limit results to cards associated with the customer supplied. By default, all cards owned by
     * the merchant are returned.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
    }

    /**
     * Internal Getter for IncludeDisabled.
     * Includes disabled cards. By default, all enabled cards owned by the merchant are returned.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("include_disabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIncludeDisabled() {
        return this.includeDisabled;
    }

    /**
     * Getter for IncludeDisabled.
     * Includes disabled cards. By default, all enabled cards owned by the merchant are returned.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIncludeDisabled() {
        return OptionalNullable.getFrom(includeDisabled);
    }

    /**
     * Internal Getter for ReferenceId.
     * Limit results to cards associated with the reference_id supplied.
     * @return Returns the Internal String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for ReferenceId.
     * Limit results to cards associated with the reference_id supplied.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
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
                .sortOrder(getSortOrder());
        builder.cursor = internalGetCursor();
        builder.customerId = internalGetCustomerId();
        builder.includeDisabled = internalGetIncludeDisabled();
        builder.referenceId = internalGetReferenceId();
        return builder;
    }

    /**
     * Class to build instances of {@link ListCardsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private OptionalNullable<String> customerId;
        private OptionalNullable<Boolean> includeDisabled;
        private OptionalNullable<String> referenceId;
        private String sortOrder;



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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = OptionalNullable.of(customerId);
            return this;
        }

        /**
         * UnSetter for customerId.
         * @return Builder
         */
        public Builder unsetCustomerId() {
            customerId = null;
            return this;
        }

        /**
         * Setter for includeDisabled.
         * @param  includeDisabled  Boolean value for includeDisabled.
         * @return Builder
         */
        public Builder includeDisabled(Boolean includeDisabled) {
            this.includeDisabled = OptionalNullable.of(includeDisabled);
            return this;
        }

        /**
         * UnSetter for includeDisabled.
         * @return Builder
         */
        public Builder unsetIncludeDisabled() {
            includeDisabled = null;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = OptionalNullable.of(referenceId);
            return this;
        }

        /**
         * UnSetter for referenceId.
         * @return Builder
         */
        public Builder unsetReferenceId() {
            referenceId = null;
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
