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
@JsonDeserialize(builder = GetRefundsRequest.Builder.class)
public final class GetRefundsRequest {
    private final String refundId;

    private final Map<String, Object> additionalProperties;

    private GetRefundsRequest(String refundId, Map<String, Object> additionalProperties) {
        this.refundId = refundId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique ID for the desired <code>PaymentRefund</code>.
     */
    @JsonProperty("refund_id")
    public String getRefundId() {
        return refundId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetRefundsRequest && equalTo((GetRefundsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetRefundsRequest other) {
        return refundId.equals(other.refundId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.refundId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RefundIdStage builder() {
        return new Builder();
    }

    public interface RefundIdStage {
        /**
         * <p>The unique ID for the desired <code>PaymentRefund</code>.</p>
         */
        _FinalStage refundId(@NotNull String refundId);

        Builder from(GetRefundsRequest other);
    }

    public interface _FinalStage {
        GetRefundsRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RefundIdStage, _FinalStage {
        private String refundId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetRefundsRequest other) {
            refundId(other.getRefundId());
            return this;
        }

        /**
         * <p>The unique ID for the desired <code>PaymentRefund</code>.</p>
         * <p>The unique ID for the desired <code>PaymentRefund</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("refund_id")
        public _FinalStage refundId(@NotNull String refundId) {
            this.refundId = Objects.requireNonNull(refundId, "refundId must not be null");
            return this;
        }

        @java.lang.Override
        public GetRefundsRequest build() {
            return new GetRefundsRequest(refundId, additionalProperties);
        }
    }
}
