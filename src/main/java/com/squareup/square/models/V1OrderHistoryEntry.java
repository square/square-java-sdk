package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1OrderHistoryEntry {

    @JsonCreator
    public V1OrderHistoryEntry(
            @JsonProperty("action") String action,
            @JsonProperty("created_at") String createdAt) {
        this.action = action;
        this.createdAt = createdAt;
    }

    private final String action;
    private final String createdAt;

    @Override
    public int hashCode() {
        return Objects.hash(action, createdAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1OrderHistoryEntry)) {
            return false;
        }
        V1OrderHistoryEntry v1OrderHistoryEntry = (V1OrderHistoryEntry) o;
        return Objects.equals(action, v1OrderHistoryEntry.action) &&
            Objects.equals(createdAt, v1OrderHistoryEntry.createdAt);
    }

    /**
     * Getter for Action.
     */
    @JsonGetter("action")
    public String getAction() { 
        return this.action;
    }

    /**
     * Getter for CreatedAt.
     * The time when the action was performed, in ISO 8601 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .action(getAction())
            .createdAt(getCreatedAt());
            return builder;
    }

    public static class Builder {
        private String action;
        private String createdAt;

        public Builder() { }

        public Builder action(String value) {
            action = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }

        public V1OrderHistoryEntry build() {
            return new V1OrderHistoryEntry(action,
                createdAt);
        }
    }
}
