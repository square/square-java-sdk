/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.merchants.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.types.BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = BulkDeleteMerchantCustomAttributesRequest.Builder.class)
public final class BulkDeleteMerchantCustomAttributesRequest {
    private final Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values;

    private final Map<String, Object> additionalProperties;

    private BulkDeleteMerchantCustomAttributesRequest(
            Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values,
            Map<String, Object> additionalProperties) {
        this.values = values;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The data used to update the <code>CustomAttribute</code> objects.
     * The keys must be unique and are used to map to the corresponding response.
     */
    @JsonProperty("values")
    public Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> getValues() {
        return values;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkDeleteMerchantCustomAttributesRequest
                && equalTo((BulkDeleteMerchantCustomAttributesRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BulkDeleteMerchantCustomAttributesRequest other) {
        return values.equals(other.values);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.values);
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
        private Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values =
                new LinkedHashMap<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BulkDeleteMerchantCustomAttributesRequest other) {
            values(other.getValues());
            return this;
        }

        /**
         * <p>The data used to update the <code>CustomAttribute</code> objects.
         * The keys must be unique and are used to map to the corresponding response.</p>
         */
        @JsonSetter(value = "values", nulls = Nulls.SKIP)
        public Builder values(
                Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values) {
            this.values.clear();
            this.values.putAll(values);
            return this;
        }

        public Builder putAllValues(
                Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values) {
            this.values.putAll(values);
            return this;
        }

        public Builder values(
                String key, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest value) {
            this.values.put(key, value);
            return this;
        }

        public BulkDeleteMerchantCustomAttributesRequest build() {
            return new BulkDeleteMerchantCustomAttributesRequest(values, additionalProperties);
        }
    }
}
