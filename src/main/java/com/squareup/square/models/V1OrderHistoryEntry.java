
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1OrderHistoryEntry type.
 */
public class V1OrderHistoryEntry {
    private final String action;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param action String value for action.
     * @param createdAt String value for createdAt.
     */
    @JsonCreator
    public V1OrderHistoryEntry(
            @JsonProperty("action") String action,
            @JsonProperty("created_at") String createdAt) {
        this.action = action;
        this.createdAt = createdAt;
    }

    /**
     * Getter for Action.
     * @return Returns the String
     */
    @JsonGetter("action")
    public String getAction() {
        return this.action;
    }

    /**
     * Getter for CreatedAt.
     * The time when the action was performed, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1OrderHistoryEntry)) {
            return false;
        }
        V1OrderHistoryEntry other = (V1OrderHistoryEntry) obj;
        return Objects.equals(action, other.action)
            && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Converts this V1OrderHistoryEntry into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1OrderHistoryEntry [" + "action=" + action + ", createdAt=" + createdAt + "]";
    }

    /**
     * Builds a new {@link V1OrderHistoryEntry.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1OrderHistoryEntry.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .action(getAction())
                .createdAt(getCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link V1OrderHistoryEntry}.
     */
    public static class Builder {
        private String action;
        private String createdAt;



        /**
         * Setter for action.
         * @param action String value for action.
         * @return Builder
         */
        public Builder action(String action) {
            this.action = action;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Builds a new {@link V1OrderHistoryEntry} object using the set fields.
         * @return {@link V1OrderHistoryEntry}
         */
        public V1OrderHistoryEntry build() {
            return new V1OrderHistoryEntry(action, createdAt);
        }
    }
}
