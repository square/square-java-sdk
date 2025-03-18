/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CustomerTextFilter.Builder.class)
public final class CustomerTextFilter {
    private final Optional<String> exact;

    private final Optional<String> fuzzy;

    private final Map<String, Object> additionalProperties;

    private CustomerTextFilter(
            Optional<String> exact, Optional<String> fuzzy, Map<String, Object> additionalProperties) {
        this.exact = exact;
        this.fuzzy = fuzzy;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Use the exact filter to select customers whose attributes match exactly the specified query.
     */
    @JsonIgnore
    public Optional<String> getExact() {
        if (exact == null) {
            return Optional.empty();
        }
        return exact;
    }

    /**
     * @return Use the fuzzy filter to select customers whose attributes match the specified query
     * in a fuzzy manner. When the fuzzy option is used, search queries are tokenized, and then
     * each query token must be matched somewhere in the searched attribute. For single token queries,
     * this is effectively the same behavior as a partial match operation.
     */
    @JsonIgnore
    public Optional<String> getFuzzy() {
        if (fuzzy == null) {
            return Optional.empty();
        }
        return fuzzy;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("exact")
    private Optional<String> _getExact() {
        return exact;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("fuzzy")
    private Optional<String> _getFuzzy() {
        return fuzzy;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CustomerTextFilter && equalTo((CustomerTextFilter) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CustomerTextFilter other) {
        return exact.equals(other.exact) && fuzzy.equals(other.fuzzy);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.exact, this.fuzzy);
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
        private Optional<String> exact = Optional.empty();

        private Optional<String> fuzzy = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CustomerTextFilter other) {
            exact(other.getExact());
            fuzzy(other.getFuzzy());
            return this;
        }

        @JsonSetter(value = "exact", nulls = Nulls.SKIP)
        public Builder exact(Optional<String> exact) {
            this.exact = exact;
            return this;
        }

        public Builder exact(String exact) {
            this.exact = Optional.ofNullable(exact);
            return this;
        }

        public Builder exact(Nullable<String> exact) {
            if (exact.isNull()) {
                this.exact = null;
            } else if (exact.isEmpty()) {
                this.exact = Optional.empty();
            } else {
                this.exact = Optional.of(exact.get());
            }
            return this;
        }

        @JsonSetter(value = "fuzzy", nulls = Nulls.SKIP)
        public Builder fuzzy(Optional<String> fuzzy) {
            this.fuzzy = fuzzy;
            return this;
        }

        public Builder fuzzy(String fuzzy) {
            this.fuzzy = Optional.ofNullable(fuzzy);
            return this;
        }

        public Builder fuzzy(Nullable<String> fuzzy) {
            if (fuzzy.isNull()) {
                this.fuzzy = null;
            } else if (fuzzy.isEmpty()) {
                this.fuzzy = Optional.empty();
            } else {
                this.fuzzy = Optional.of(fuzzy.get());
            }
            return this;
        }

        public CustomerTextFilter build() {
            return new CustomerTextFilter(exact, fuzzy, additionalProperties);
        }
    }
}
