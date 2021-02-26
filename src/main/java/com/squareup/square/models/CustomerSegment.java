
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CustomerSegment type.
 */
public class CustomerSegment {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  id  String value for id.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public CustomerSegment(
            @JsonProperty("name") String name,
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for Id.
     * Unique Square-generated ID for the segment.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Name.
     * Name of the segment.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the segment was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the segment was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerSegment)) {
            return false;
        }
        CustomerSegment other = (CustomerSegment) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this CustomerSegment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerSegment [" + "name=" + name + ", id=" + id + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link CustomerSegment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerSegment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name)
                .id(getId())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerSegment}.
     */
    public static class Builder {
        private String name;
        private String id;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor.
         * @param  name  String value for name.
         */
        public Builder(String name) {
            this.name = name;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link CustomerSegment} object using the set fields.
         * @return {@link CustomerSegment}
         */
        public CustomerSegment build() {
            return new CustomerSegment(name, id, createdAt, updatedAt);
        }
    }
}
