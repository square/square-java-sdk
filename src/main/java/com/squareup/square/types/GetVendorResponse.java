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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetVendorResponse.Builder.class)
public final class GetVendorResponse {
    private final Optional<List<Error>> errors;

    private final Optional<Vendor> vendor;

    private final Map<String, Object> additionalProperties;

    private GetVendorResponse(
            Optional<List<Error>> errors, Optional<Vendor> vendor, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.vendor = vendor;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Errors encountered when the request fails.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The successfully retrieved <a href="entity:Vendor">Vendor</a> object.
     */
    @JsonProperty("vendor")
    public Optional<Vendor> getVendor() {
        return vendor;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetVendorResponse && equalTo((GetVendorResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetVendorResponse other) {
        return errors.equals(other.errors) && vendor.equals(other.vendor);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.vendor);
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
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<Vendor> vendor = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetVendorResponse other) {
            errors(other.getErrors());
            vendor(other.getVendor());
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        @JsonSetter(value = "vendor", nulls = Nulls.SKIP)
        public Builder vendor(Optional<Vendor> vendor) {
            this.vendor = vendor;
            return this;
        }

        public Builder vendor(Vendor vendor) {
            this.vendor = Optional.ofNullable(vendor);
            return this;
        }

        public GetVendorResponse build() {
            return new GetVendorResponse(errors, vendor, additionalProperties);
        }
    }
}
