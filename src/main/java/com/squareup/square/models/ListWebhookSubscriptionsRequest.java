
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
 * This is a model class for ListWebhookSubscriptionsRequest type.
 */
public class ListWebhookSubscriptionsRequest {
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Boolean> includeDisabled;
    private final String sortOrder;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  includeDisabled  Boolean value for includeDisabled.
     * @param  sortOrder  String value for sortOrder.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListWebhookSubscriptionsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("include_disabled") Boolean includeDisabled,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("limit") Integer limit) {
        this.cursor = OptionalNullable.of(cursor);
        this.includeDisabled = OptionalNullable.of(includeDisabled);
        this.sortOrder = sortOrder;
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListWebhookSubscriptionsRequest(OptionalNullable<String> cursor,
            OptionalNullable<Boolean> includeDisabled, String sortOrder,
            OptionalNullable<Integer> limit) {
        this.cursor = cursor;
        this.includeDisabled = includeDisabled;
        this.sortOrder = sortOrder;
        this.limit = limit;
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
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
     * the next set of results for your original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for IncludeDisabled.
     * Includes disabled [Subscription](entity:WebhookSubscription)s. By default, all enabled
     * [Subscription](entity:WebhookSubscription)s are returned.
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
     * Includes disabled [Subscription](entity:WebhookSubscription)s. By default, all enabled
     * [Subscription](entity:WebhookSubscription)s are returned.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIncludeDisabled() {
        return OptionalNullable.getFrom(includeDisabled);
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

    /**
     * Internal Getter for Limit.
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. The default value of 100 is also the
     * maximum allowed value. Default: 100
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. The default value of 100 is also the
     * maximum allowed value. Default: 100
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, includeDisabled, sortOrder, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListWebhookSubscriptionsRequest)) {
            return false;
        }
        ListWebhookSubscriptionsRequest other = (ListWebhookSubscriptionsRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(includeDisabled, other.includeDisabled)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListWebhookSubscriptionsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListWebhookSubscriptionsRequest [" + "cursor=" + cursor + ", includeDisabled="
                + includeDisabled + ", sortOrder=" + sortOrder + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListWebhookSubscriptionsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListWebhookSubscriptionsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .sortOrder(getSortOrder());
        builder.cursor = internalGetCursor();
        builder.includeDisabled = internalGetIncludeDisabled();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link ListWebhookSubscriptionsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private OptionalNullable<Boolean> includeDisabled;
        private String sortOrder;
        private OptionalNullable<Integer> limit;



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
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
            return this;
        }

        /**
         * Builds a new {@link ListWebhookSubscriptionsRequest} object using the set fields.
         * @return {@link ListWebhookSubscriptionsRequest}
         */
        public ListWebhookSubscriptionsRequest build() {
            return new ListWebhookSubscriptionsRequest(cursor, includeDisabled, sortOrder, limit);
        }
    }
}
