/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = BulkRetrieveCustomersRequest.Builder.class)
public final class BulkRetrieveCustomersRequest {
    private final List<String> customerIds;

    private final Map<String, Object> additionalProperties;

    private BulkRetrieveCustomersRequest(List<String> customerIds, Map<String, Object> additionalProperties) {
        this.customerIds = customerIds;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The IDs of the <a href="entity:Customer">customer profiles</a> to retrieve.
     */
    @JsonProperty("customer_ids")
    public List<String> getCustomerIds() {
        return customerIds;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkRetrieveCustomersRequest && equalTo((BulkRetrieveCustomersRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BulkRetrieveCustomersRequest other) {
        return customerIds.equals(other.customerIds);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.customerIds);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<String> customerIds = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BulkRetrieveCustomersRequest other) {
            customerIds(other.getCustomerIds());
            return this;
        }

        /**
         * <p>The IDs of the <a href="entity:Customer">customer profiles</a> to retrieve.</p>
         */
        @JsonSetter(value = "customer_ids", nulls = Nulls.SKIP)
        public Builder customerIds(List<String> customerIds) {
            this.customerIds.clear();
            this.customerIds.addAll(customerIds);
            return this;
        }

        public Builder addCustomerIds(String customerIds) {
            this.customerIds.add(customerIds);
            return this;
        }

        public Builder addAllCustomerIds(List<String> customerIds) {
            this.customerIds.addAll(customerIds);
            return this;
        }

        public BulkRetrieveCustomersRequest build() {
            return new BulkRetrieveCustomersRequest(customerIds, additionalProperties);
        }
    }
}
