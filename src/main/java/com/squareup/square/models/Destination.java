
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for Destination type.
 */
public class Destination {
    private final String type;
    private final String id;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  id  String value for id.
     */
    @JsonCreator
    public Destination(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id) {
        this.type = type;
        this.id = id;
    }

    /**
     * Getter for Type.
     * List of possible destinations against which a payout can be made.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for Id.
     * Square issued unique ID (also known as the instrument ID) associated with this destination.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(id, other.id);
    }

    /**
     * Converts this Destination into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Destination [" + "type=" + type + ", id=" + id + "]";
    }

    /**
     * Builds a new {@link Destination.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Destination.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .id(getId());
        return builder;
    }

    /**
     * Class to build instances of {@link Destination}.
     */
    public static class Builder {
        private String type;
        private String id;



        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
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
         * Builds a new {@link Destination} object using the set fields.
         * @return {@link Destination}
         */
        public Destination build() {
            return new Destination(type, id);
        }
    }
}
