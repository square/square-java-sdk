package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchOrdersDateTimeFilter type.
 */
public class SearchOrdersDateTimeFilter {

    /**
     * Initialization constructor.
     * @param createdAt
     * @param updatedAt
     * @param closedAt
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

    private final TimeRange createdAt;
    private final TimeRange updatedAt;
    private final TimeRange closedAt;
    /**
     * Getter for CreatedAt.
     * Represents a generic time range. The start and end values are
     * represented in RFC-3339 format. Time ranges are customized to be
     * inclusive or exclusive based on the needs of a particular endpoint.
     * Refer to the relevent endpoint-specific documentation to determine
     * how time ranges are handled.
     */
    @JsonGetter("created_at")
    public TimeRange getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * Represents a generic time range. The start and end values are
     * represented in RFC-3339 format. Time ranges are customized to be
     * inclusive or exclusive based on the needs of a particular endpoint.
     * Refer to the relevent endpoint-specific documentation to determine
     * how time ranges are handled.
     */
    @JsonGetter("updated_at")
    public TimeRange getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for ClosedAt.
     * Represents a generic time range. The start and end values are
     * represented in RFC-3339 format. Time ranges are customized to be
     * inclusive or exclusive based on the needs of a particular endpoint.
     * Refer to the relevent endpoint-specific documentation to determine
     * how time ranges are handled.
     */
    @JsonGetter("closed_at")
    public TimeRange getClosedAt() {
        return this.closedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updatedAt, closedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchOrdersDateTimeFilter)) {
            return false;
        }
        SearchOrdersDateTimeFilter searchOrdersDateTimeFilter = (SearchOrdersDateTimeFilter) obj;
        return Objects.equals(createdAt, searchOrdersDateTimeFilter.createdAt) &&
            Objects.equals(updatedAt, searchOrdersDateTimeFilter.updatedAt) &&
            Objects.equals(closedAt, searchOrdersDateTimeFilter.closedAt);
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
     * Class to build instances of {@link SearchOrdersDateTimeFilter}
     */
    public static class Builder {
        private TimeRange createdAt;
        private TimeRange updatedAt;
        private TimeRange closedAt;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(TimeRange createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(TimeRange updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        /**
         * Setter for closedAt
         * @param closedAt
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
            return new SearchOrdersDateTimeFilter(createdAt,
                updatedAt,
                closedAt);
        }
    }
}
