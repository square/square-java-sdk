package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CustomerFilter {

    @JsonCreator
    public CustomerFilter(
            @JsonProperty("creation_source") CustomerCreationSourceFilter creationSource,
            @JsonProperty("created_at") TimeRange createdAt,
            @JsonProperty("updated_at") TimeRange updatedAt) {
        this.creationSource = creationSource;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private final CustomerCreationSourceFilter creationSource;
    private final TimeRange createdAt;
    private final TimeRange updatedAt;

    @Override
    public int hashCode() {
        return Objects.hash(creationSource, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerFilter)) {
            return false;
        }
        CustomerFilter customerFilter = (CustomerFilter) o;
        return Objects.equals(creationSource, customerFilter.creationSource) &&
            Objects.equals(createdAt, customerFilter.createdAt) &&
            Objects.equals(updatedAt, customerFilter.updatedAt);
    }

    /**
     * Getter for CreationSource.
     * Creation source filter.
     * If one or more creation sources are set, customer profiles are included in,
     * or excluded from, the result if they match at least one of the filter
     * criteria.
     */
    @JsonGetter("creation_source")
    public CustomerCreationSourceFilter getCreationSource() { 
        return this.creationSource;
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .creationSource(getCreationSource())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    public static class Builder {
        private CustomerCreationSourceFilter creationSource;
        private TimeRange createdAt;
        private TimeRange updatedAt;

        public Builder() { }

        public Builder creationSource(CustomerCreationSourceFilter value) {
            creationSource = value;
            return this;
        }
        public Builder createdAt(TimeRange value) {
            createdAt = value;
            return this;
        }
        public Builder updatedAt(TimeRange value) {
            updatedAt = value;
            return this;
        }

        public CustomerFilter build() {
            return new CustomerFilter(creationSource,
                createdAt,
                updatedAt);
        }
    }
}
