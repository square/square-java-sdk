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
@JsonDeserialize(builder = SubscriptionEventInfo.Builder.class)
public final class SubscriptionEventInfo {
    private final Optional<String> detail;

    private final Optional<SubscriptionEventInfoCode> code;

    private final Map<String, Object> additionalProperties;

    private SubscriptionEventInfo(
            Optional<String> detail,
            Optional<SubscriptionEventInfoCode> code,
            Map<String, Object> additionalProperties) {
        this.detail = detail;
        this.code = code;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A human-readable explanation for the event.
     */
    @JsonIgnore
    public Optional<String> getDetail() {
        if (detail == null) {
            return Optional.empty();
        }
        return detail;
    }

    /**
     * @return An info code indicating the subscription event that occurred.
     * See <a href="#type-infocode">InfoCode</a> for possible values
     */
    @JsonProperty("code")
    public Optional<SubscriptionEventInfoCode> getCode() {
        return code;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("detail")
    private Optional<String> _getDetail() {
        return detail;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SubscriptionEventInfo && equalTo((SubscriptionEventInfo) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SubscriptionEventInfo other) {
        return detail.equals(other.detail) && code.equals(other.code);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.detail, this.code);
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
        private Optional<String> detail = Optional.empty();

        private Optional<SubscriptionEventInfoCode> code = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SubscriptionEventInfo other) {
            detail(other.getDetail());
            code(other.getCode());
            return this;
        }

        @JsonSetter(value = "detail", nulls = Nulls.SKIP)
        public Builder detail(Optional<String> detail) {
            this.detail = detail;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = Optional.ofNullable(detail);
            return this;
        }

        public Builder detail(Nullable<String> detail) {
            if (detail.isNull()) {
                this.detail = null;
            } else if (detail.isEmpty()) {
                this.detail = Optional.empty();
            } else {
                this.detail = Optional.of(detail.get());
            }
            return this;
        }

        @JsonSetter(value = "code", nulls = Nulls.SKIP)
        public Builder code(Optional<SubscriptionEventInfoCode> code) {
            this.code = code;
            return this;
        }

        public Builder code(SubscriptionEventInfoCode code) {
            this.code = Optional.ofNullable(code);
            return this;
        }

        public SubscriptionEventInfo build() {
            return new SubscriptionEventInfo(detail, code, additionalProperties);
        }
    }
}
