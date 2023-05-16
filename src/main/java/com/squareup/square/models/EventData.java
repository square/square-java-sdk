
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.squareup.square.utilities.JsonObject;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for EventData type.
 */
public class EventData {
    private final OptionalNullable<String> type;
    private final String id;
    private final OptionalNullable<Boolean> deleted;
    private final OptionalNullable<JsonObject> object;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  id  String value for id.
     * @param  deleted  Boolean value for deleted.
     * @param  object  JsonObject value for object.
     */
    @JsonCreator
    public EventData(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("deleted") Boolean deleted,
            @JsonProperty("object") JsonObject object) {
        this.type = OptionalNullable.of(type);
        this.id = id;
        this.deleted = OptionalNullable.of(deleted);
        this.object = OptionalNullable.of(object);
    }

    /**
     * Internal initialization constructor.
     */
    protected EventData(OptionalNullable<String> type, String id, OptionalNullable<Boolean> deleted,
            OptionalNullable<JsonObject> object) {
        this.type = type;
        this.id = id;
        this.deleted = deleted;
        this.object = object;
    }

    /**
     * Internal Getter for Type.
     * Name of the affected object’s type.
     * @return Returns the Internal String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetType() {
        return this.type;
    }

    /**
     * Getter for Type.
     * Name of the affected object’s type.
     * @return Returns the String
     */
    @JsonIgnore
    public String getType() {
        return OptionalNullable.getFrom(type);
    }

    /**
     * Getter for Id.
     * ID of the affected object.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for Deleted.
     * Is true if the affected object was deleted. Otherwise absent.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("deleted")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetDeleted() {
        return this.deleted;
    }

    /**
     * Getter for Deleted.
     * Is true if the affected object was deleted. Otherwise absent.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getDeleted() {
        return OptionalNullable.getFrom(deleted);
    }

    /**
     * Internal Getter for Object.
     * An object containing fields and values relevant to the event. Is absent if affected object
     * was deleted.
     * @return Returns the Internal JsonObject
     */
    @JsonGetter("object")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<JsonObject> internalGetObject() {
        return this.object;
    }

    /**
     * Getter for Object.
     * An object containing fields and values relevant to the event. Is absent if affected object
     * was deleted.
     * @return Returns the JsonObject
     */
    @JsonIgnore
    public JsonObject getObject() {
        return OptionalNullable.getFrom(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, deleted, object);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventData)) {
            return false;
        }
        EventData other = (EventData) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(id, other.id)
            && Objects.equals(deleted, other.deleted)
            && Objects.equals(object, other.object);
    }

    /**
     * Converts this EventData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "EventData [" + "type=" + type + ", id=" + id + ", deleted=" + deleted + ", object="
                + object + "]";
    }

    /**
     * Builds a new {@link EventData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link EventData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId());
        builder.type = internalGetType();
        builder.deleted = internalGetDeleted();
        builder.object = internalGetObject();
        return builder;
    }

    /**
     * Class to build instances of {@link EventData}.
     */
    public static class Builder {
        private OptionalNullable<String> type;
        private String id;
        private OptionalNullable<Boolean> deleted;
        private OptionalNullable<JsonObject> object;



        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = OptionalNullable.of(type);
            return this;
        }

        /**
         * UnSetter for type.
         * @return Builder
         */
        public Builder unsetType() {
            type = null;
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
         * Setter for deleted.
         * @param  deleted  Boolean value for deleted.
         * @return Builder
         */
        public Builder deleted(Boolean deleted) {
            this.deleted = OptionalNullable.of(deleted);
            return this;
        }

        /**
         * UnSetter for deleted.
         * @return Builder
         */
        public Builder unsetDeleted() {
            deleted = null;
            return this;
        }

        /**
         * Setter for object.
         * @param  object  JsonObject value for object.
         * @return Builder
         */
        public Builder object(JsonObject object) {
            this.object = OptionalNullable.of(object);
            return this;
        }

        /**
         * UnSetter for object.
         * @return Builder
         */
        public Builder unsetObject() {
            object = null;
            return this;
        }

        /**
         * Builds a new {@link EventData} object using the set fields.
         * @return {@link EventData}
         */
        public EventData build() {
            return new EventData(type, id, deleted, object);
        }
    }
}
