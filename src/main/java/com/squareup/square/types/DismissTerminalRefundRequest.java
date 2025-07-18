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
@JsonDeserialize(builder = DismissTerminalRefundRequest.Builder.class)
public final class DismissTerminalRefundRequest {
    private final String terminalRefundId;

    private final Map<String, Object> additionalProperties;

    private DismissTerminalRefundRequest(String terminalRefundId, Map<String, Object> additionalProperties) {
        this.terminalRefundId = terminalRefundId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Unique ID for the <code>TerminalRefund</code> associated with the refund to be dismissed.
     */
    @JsonProperty("terminal_refund_id")
    public String getTerminalRefundId() {
        return terminalRefundId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DismissTerminalRefundRequest && equalTo((DismissTerminalRefundRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DismissTerminalRefundRequest other) {
        return terminalRefundId.equals(other.terminalRefundId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.terminalRefundId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TerminalRefundIdStage builder() {
        return new Builder();
    }

    public interface TerminalRefundIdStage {
        /**
         * <p>Unique ID for the <code>TerminalRefund</code> associated with the refund to be dismissed.</p>
         */
        _FinalStage terminalRefundId(@NotNull String terminalRefundId);

        Builder from(DismissTerminalRefundRequest other);
    }

    public interface _FinalStage {
        DismissTerminalRefundRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TerminalRefundIdStage, _FinalStage {
        private String terminalRefundId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DismissTerminalRefundRequest other) {
            terminalRefundId(other.getTerminalRefundId());
            return this;
        }

        /**
         * <p>Unique ID for the <code>TerminalRefund</code> associated with the refund to be dismissed.</p>
         * <p>Unique ID for the <code>TerminalRefund</code> associated with the refund to be dismissed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("terminal_refund_id")
        public _FinalStage terminalRefundId(@NotNull String terminalRefundId) {
            this.terminalRefundId = Objects.requireNonNull(terminalRefundId, "terminalRefundId must not be null");
            return this;
        }

        @java.lang.Override
        public DismissTerminalRefundRequest build() {
            return new DismissTerminalRefundRequest(terminalRefundId, additionalProperties);
        }
    }
}
