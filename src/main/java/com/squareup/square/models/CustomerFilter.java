package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CustomerFilter type.
 */
public class CustomerFilter {

    /**
     * Initialization constructor.
     * @param creationSource
     * @param createdAt
     * @param updatedAt
     * @param groupIds
     */
    @JsonCreator
    public CustomerFilter(
            @JsonProperty("creation_source") CustomerCreationSourceFilter creationSource,
            @JsonProperty("created_at") TimeRange createdAt,
            @JsonProperty("updated_at") TimeRange updatedAt,
            @JsonProperty("group_ids") FilterValue groupIds) {
        this.creationSource = creationSource;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.groupIds = groupIds;
    }

    private final CustomerCreationSourceFilter creationSource;
    private final TimeRange createdAt;
    private final TimeRange updatedAt;
    private final FilterValue groupIds;
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

    /**
     * Getter for GroupIds.
     * A filter to select resources based on an exact field value. For any given
     * value, the value can only be in one property. Depending on the field, either
     * all properties can be set or only a subset will be available.
     * Refer to the documentation of the field.
     */
    @JsonGetter("group_ids")
    public FilterValue getGroupIds() {
        return this.groupIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(creationSource, createdAt, updatedAt, groupIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CustomerFilter)) {
            return false;
        }
        CustomerFilter customerFilter = (CustomerFilter) obj;
        return Objects.equals(creationSource, customerFilter.creationSource) &&
            Objects.equals(createdAt, customerFilter.createdAt) &&
            Objects.equals(updatedAt, customerFilter.updatedAt) &&
            Objects.equals(groupIds, customerFilter.groupIds);
    }

    /**
     * Builds a new {@link CustomerFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .creationSource(getCreationSource())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .groupIds(getGroupIds());
            return builder;
    }

    /**
     * Class to build instances of {@link CustomerFilter}
     */
    public static class Builder {
        private CustomerCreationSourceFilter creationSource;
        private TimeRange createdAt;
        private TimeRange updatedAt;
        private FilterValue groupIds;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for creationSource
         * @param creationSource
         * @return Builder
         */
        public Builder creationSource(CustomerCreationSourceFilter creationSource) {
            this.creationSource = creationSource;
            return this;
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
         * Setter for groupIds
         * @param groupIds
         * @return Builder
         */
        public Builder groupIds(FilterValue groupIds) {
            this.groupIds = groupIds;
            return this;
        }

        /**
         * Builds a new {@link CustomerFilter} object using the set fields.
         * @return {@link CustomerFilter}
         */
        public CustomerFilter build() {
            return new CustomerFilter(creationSource,
                createdAt,
                updatedAt,
                groupIds);
        }
    }
}
