
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for LoyaltyAccountMapping type.
 */
public class LoyaltyAccountMapping {
    private final String id;
    private final String type;
    private final String value;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param type String value for type.
     * @param value String value for value.
     * @param id String value for id.
     * @param createdAt String value for createdAt.
     */
    @JsonCreator
    public LoyaltyAccountMapping(
            @JsonProperty("type") String type,
            @JsonProperty("value") String value,
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.createdAt = createdAt;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the mapping.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Type.
     * The type of mapping.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Value.
     * The phone number, in E.164 format. For example, "+14155551111".
     * @return Returns the String
     */
    @JsonGetter("value")
    public String getValue() {
        return this.value;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the mapping was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, type, value, createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyAccountMapping)) {
            return false;
        }
        LoyaltyAccountMapping other = (LoyaltyAccountMapping) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(type, other.type)
            && Objects.equals(value, other.value)
            && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Builds a new {@link LoyaltyAccountMapping.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyAccountMapping.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type,
            value)
            .id(getId())
            .createdAt(getCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyAccountMapping}.
     */
    public static class Builder {
        private String type = "PHONE";
        private String value;
        private String id;
        private String createdAt;

        /**
         * Initialization constructor.
         * @param type String value for type.
         * @param value String value for value.
         */
        public Builder(String type,
                String value) {
            this.type = type;
            this.value = value;
        }

        /**
         * Setter for type.
         * @param type String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for value.
         * @param value String value for value.
         * @return Builder
         */
        public Builder value(String value) {
            this.value = value;
            return this;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Builds a new {@link LoyaltyAccountMapping} object using the set fields.
         * @return {@link LoyaltyAccountMapping}
         */
        public LoyaltyAccountMapping build() {
            return new LoyaltyAccountMapping(type,
                value,
                id,
                createdAt);
        }
    }
}
