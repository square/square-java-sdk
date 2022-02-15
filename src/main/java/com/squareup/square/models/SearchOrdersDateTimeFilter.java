
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchOrdersDateTimeFilter type.
 */
public class SearchOrdersDateTimeFilter {
    private final TimeRange createdAt;
    private final TimeRange updatedAt;
    private final TimeRange closedAt;

    /**
     * Initialization constructor.
     * @param  createdAt  TimeRange value for createdAt.
     * @param  updatedAt  TimeRange value for updatedAt.
     * @param  closedAt  TimeRange value for closedAt.
     */
    @JsonCreator
    public SearchOrdersDateTimeFilter(
            @JsonProperty("created_at") TimeRange createdAt,
            @JsonProperty("updated_at") TimeRange updatedAt,
            @JsonProperty("closed_at") TimeRange closedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
    }

    /**
     * Getter for CreatedAt.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TimeRange getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TimeRange getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for ClosedAt.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("closed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TimeRange getClosedAt() {
        return closedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updatedAt, closedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrdersDateTimeFilter)) {
            return false;
        }
        SearchOrdersDateTimeFilter other = (SearchOrdersDateTimeFilter) obj;
        return Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(closedAt, other.closedAt);
    }

    /**
     * Converts this SearchOrdersDateTimeFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchOrdersDateTimeFilter [" + "createdAt=" + createdAt + ", updatedAt="
                + updatedAt + ", closedAt=" + closedAt + "]";
    }

    /**
     * Builds a new {@link SearchOrdersDateTimeFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersDateTimeFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .closedAt(getClosedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersDateTimeFilter}.
     */
    public static class Builder {
        private TimeRange createdAt;
        private TimeRange updatedAt;
        private TimeRange closedAt;



        /**
         * Setter for createdAt.
         * @param  createdAt  TimeRange value for createdAt.
         * @return Builder
         */
        public Builder createdAt(TimeRange createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  TimeRange value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(TimeRange updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for closedAt.
         * @param  closedAt  TimeRange value for closedAt.
         * @return Builder
         */
        public Builder closedAt(TimeRange closedAt) {
            this.closedAt = closedAt;
            return this;
        }

        /**
         * Builds a new {@link SearchOrdersDateTimeFilter} object using the set fields.
         * @return {@link SearchOrdersDateTimeFilter}
         */
        public SearchOrdersDateTimeFilter build() {
            return new SearchOrdersDateTimeFilter(createdAt, updatedAt, closedAt);
        }
    }
}
