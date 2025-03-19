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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GiftCardActivityClearBalance.Builder.class)
public final class GiftCardActivityClearBalance {
    private final GiftCardActivityClearBalanceReason reason;

    private final Map<String, Object> additionalProperties;

    private GiftCardActivityClearBalance(
            GiftCardActivityClearBalanceReason reason, Map<String, Object> additionalProperties) {
        this.reason = reason;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The reason the gift card balance was cleared.
     * See <a href="#type-reason">Reason</a> for possible values
     */
    @JsonProperty("reason")
    public GiftCardActivityClearBalanceReason getReason() {
        return reason;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GiftCardActivityClearBalance && equalTo((GiftCardActivityClearBalance) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GiftCardActivityClearBalance other) {
        return reason.equals(other.reason);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.reason);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ReasonStage builder() {
        return new Builder();
    }

    public interface ReasonStage {
        _FinalStage reason(@NotNull GiftCardActivityClearBalanceReason reason);

        Builder from(GiftCardActivityClearBalance other);
    }

    public interface _FinalStage {
        GiftCardActivityClearBalance build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ReasonStage, _FinalStage {
        private GiftCardActivityClearBalanceReason reason;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GiftCardActivityClearBalance other) {
            reason(other.getReason());
            return this;
        }

        /**
         * <p>The reason the gift card balance was cleared.
         * See <a href="#type-reason">Reason</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("reason")
        public _FinalStage reason(@NotNull GiftCardActivityClearBalanceReason reason) {
            this.reason = Objects.requireNonNull(reason, "reason must not be null");
            return this;
        }

        @java.lang.Override
        public GiftCardActivityClearBalance build() {
            return new GiftCardActivityClearBalance(reason, additionalProperties);
        }
    }
}
