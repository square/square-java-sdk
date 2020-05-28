package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyAccountMapping type.
 */
public class LoyaltyAccountMapping {

    /**
     * Initialization constructor.
     * @param type
     * @param value
     * @param id
     * @param createdAt
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

    private final String id;
    private final String type;
    private final String value;
    private final String createdAt;
    /**
     * Getter for Id.
     * The Square-assigned ID of the mapping.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Type.
     * The type of mapping.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Value.
     * The phone number, in E.164 format. For example, "+14155551111".
     */
    @JsonGetter("value")
    public String getValue() {
        return this.value;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the mapping was created, in RFC 3339 format.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyAccountMapping)) {
            return false;
        }
        LoyaltyAccountMapping loyaltyAccountMapping = (LoyaltyAccountMapping) obj;
        return Objects.equals(id, loyaltyAccountMapping.id) &&
            Objects.equals(type, loyaltyAccountMapping.type) &&
            Objects.equals(value, loyaltyAccountMapping.value) &&
            Objects.equals(createdAt, loyaltyAccountMapping.createdAt);
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
     * Class to build instances of {@link LoyaltyAccountMapping}
     */
    public static class Builder {
        private String type = "PHONE";
        private String value;
        private String id;
        private String createdAt;

        /**
         * Initialization constructor
         */
        public Builder(String type,
                String value) {
            this.type = type;
            this.value = value;
        }

        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for value
         * @param value
         * @return Builder
         */
        public Builder value(String value) {
            this.value = value;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
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
