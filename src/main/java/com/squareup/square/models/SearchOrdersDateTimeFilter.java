package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersDateTimeFilter {

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

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updatedAt, closedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersDateTimeFilter)) {
            return false;
        }
        SearchOrdersDateTimeFilter searchOrdersDateTimeFilter = (SearchOrdersDateTimeFilter) o;
        return Objects.equals(createdAt, searchOrdersDateTimeFilter.createdAt) &&
            Objects.equals(updatedAt, searchOrdersDateTimeFilter.updatedAt) &&
            Objects.equals(closedAt, searchOrdersDateTimeFilter.closedAt);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .closedAt(getClosedAt());
            return builder;
    }

    public static class Builder {
        private TimeRange createdAt;
        private TimeRange updatedAt;
        private TimeRange closedAt;

        public Builder() { }

        public Builder createdAt(TimeRange value) {
            createdAt = value;
            return this;
        }
        public Builder updatedAt(TimeRange value) {
            updatedAt = value;
            return this;
        }
        public Builder closedAt(TimeRange value) {
            closedAt = value;
            return this;
        }

        public SearchOrdersDateTimeFilter build() {
            return new SearchOrdersDateTimeFilter(createdAt,
                updatedAt,
                closedAt);
        }
    }
}
