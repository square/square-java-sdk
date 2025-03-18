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
@JsonDeserialize(builder = GetInventoryPhysicalCountResponse.Builder.class)
public final class GetInventoryPhysicalCountResponse {
    private final Optional<List<Error>> errors;

    private final Optional<InventoryPhysicalCount> count;

    private final Map<String, Object> additionalProperties;

    private GetInventoryPhysicalCountResponse(
            Optional<List<Error>> errors,
            Optional<InventoryPhysicalCount> count,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.count = count;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The requested <a href="entity:InventoryPhysicalCount">InventoryPhysicalCount</a>.
     */
    @JsonProperty("count")
    public Optional<InventoryPhysicalCount> getCount() {
        return count;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetInventoryPhysicalCountResponse && equalTo((GetInventoryPhysicalCountResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetInventoryPhysicalCountResponse other) {
        return errors.equals(other.errors) && count.equals(other.count);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.count);
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

        private Optional<InventoryPhysicalCount> count = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetInventoryPhysicalCountResponse other) {
            errors(other.getErrors());
            count(other.getCount());
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

        @JsonSetter(value = "count", nulls = Nulls.SKIP)
        public Builder count(Optional<InventoryPhysicalCount> count) {
            this.count = count;
            return this;
        }

        public Builder count(InventoryPhysicalCount count) {
            this.count = Optional.ofNullable(count);
            return this;
        }

        public GetInventoryPhysicalCountResponse build() {
            return new GetInventoryPhysicalCountResponse(errors, count, additionalProperties);
        }
    }
}
