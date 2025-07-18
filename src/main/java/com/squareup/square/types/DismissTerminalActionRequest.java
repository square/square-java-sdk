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
@JsonDeserialize(builder = DismissTerminalActionRequest.Builder.class)
public final class DismissTerminalActionRequest {
    private final String actionId;

    private final Map<String, Object> additionalProperties;

    private DismissTerminalActionRequest(String actionId, Map<String, Object> additionalProperties) {
        this.actionId = actionId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Unique ID for the <code>TerminalAction</code> associated with the action to be dismissed.
     */
    @JsonProperty("action_id")
    public String getActionId() {
        return actionId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DismissTerminalActionRequest && equalTo((DismissTerminalActionRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DismissTerminalActionRequest other) {
        return actionId.equals(other.actionId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.actionId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ActionIdStage builder() {
        return new Builder();
    }

    public interface ActionIdStage {
        /**
         * <p>Unique ID for the <code>TerminalAction</code> associated with the action to be dismissed.</p>
         */
        _FinalStage actionId(@NotNull String actionId);

        Builder from(DismissTerminalActionRequest other);
    }

    public interface _FinalStage {
        DismissTerminalActionRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ActionIdStage, _FinalStage {
        private String actionId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DismissTerminalActionRequest other) {
            actionId(other.getActionId());
            return this;
        }

        /**
         * <p>Unique ID for the <code>TerminalAction</code> associated with the action to be dismissed.</p>
         * <p>Unique ID for the <code>TerminalAction</code> associated with the action to be dismissed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("action_id")
        public _FinalStage actionId(@NotNull String actionId) {
            this.actionId = Objects.requireNonNull(actionId, "actionId must not be null");
            return this;
        }

        @java.lang.Override
        public DismissTerminalActionRequest build() {
            return new DismissTerminalActionRequest(actionId, additionalProperties);
        }
    }
}
