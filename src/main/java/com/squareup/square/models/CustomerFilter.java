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
     * @param emailAddress
     * @param phoneNumber
     * @param referenceId
     * @param groupIds
     */
    @JsonCreator
    public CustomerFilter(
            @JsonProperty("creation_source") CustomerCreationSourceFilter creationSource,
            @JsonProperty("created_at") TimeRange createdAt,
            @JsonProperty("updated_at") TimeRange updatedAt,
            @JsonProperty("email_address") CustomerTextFilter emailAddress,
            @JsonProperty("phone_number") CustomerTextFilter phoneNumber,
            @JsonProperty("reference_id") CustomerTextFilter referenceId,
            @JsonProperty("group_ids") FilterValue groupIds) {
        this.creationSource = creationSource;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.referenceId = referenceId;
        this.groupIds = groupIds;
    }

    private final CustomerCreationSourceFilter creationSource;
    private final TimeRange createdAt;
    private final TimeRange updatedAt;
    private final CustomerTextFilter emailAddress;
    private final CustomerTextFilter phoneNumber;
    private final CustomerTextFilter referenceId;
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
     * Getter for EmailAddress.
     * A filter to select customers based on exact or fuzzy matching of
     * customer attributes against a specified query. Depending on customer attributes, 
     * the filter can be case sensitive. This filter can be either exact or fuzzy. It cannot be both.
     */
    @JsonGetter("email_address")
    public CustomerTextFilter getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Getter for PhoneNumber.
     * A filter to select customers based on exact or fuzzy matching of
     * customer attributes against a specified query. Depending on customer attributes, 
     * the filter can be case sensitive. This filter can be either exact or fuzzy. It cannot be both.
     */
    @JsonGetter("phone_number")
    public CustomerTextFilter getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for ReferenceId.
     * A filter to select customers based on exact or fuzzy matching of
     * customer attributes against a specified query. Depending on customer attributes, 
     * the filter can be case sensitive. This filter can be either exact or fuzzy. It cannot be both.
     */
    @JsonGetter("reference_id")
    public CustomerTextFilter getReferenceId() {
        return this.referenceId;
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
        return Objects.hash(creationSource, createdAt, updatedAt, emailAddress, phoneNumber,
            referenceId, groupIds);
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
            Objects.equals(emailAddress, customerFilter.emailAddress) &&
            Objects.equals(phoneNumber, customerFilter.phoneNumber) &&
            Objects.equals(referenceId, customerFilter.referenceId) &&
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
            .emailAddress(getEmailAddress())
            .phoneNumber(getPhoneNumber())
            .referenceId(getReferenceId())
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
        private CustomerTextFilter emailAddress;
        private CustomerTextFilter phoneNumber;
        private CustomerTextFilter referenceId;
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
         * Setter for emailAddress
         * @param emailAddress
         * @return Builder
         */
        public Builder emailAddress(CustomerTextFilter emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        /**
         * Setter for phoneNumber
         * @param phoneNumber
         * @return Builder
         */
        public Builder phoneNumber(CustomerTextFilter phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        /**
         * Setter for referenceId
         * @param referenceId
         * @return Builder
         */
        public Builder referenceId(CustomerTextFilter referenceId) {
            this.referenceId = referenceId;
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
                emailAddress,
                phoneNumber,
                referenceId,
                groupIds);
        }
    }
}
