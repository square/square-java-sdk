
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DisputeEvidenceCreatedWebhookData type.
 */
public class DisputeEvidenceCreatedWebhookData {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final DisputeEvidenceCreatedWebhookObject object;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  id  String value for id.
     * @param  object  DisputeEvidenceCreatedWebhookObject value for object.
     */
    @JsonCreator
    public DisputeEvidenceCreatedWebhookData(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("object") DisputeEvidenceCreatedWebhookObject object) {
        this.type = type;
        this.id = id;
        this.object = object;
    }

    /**
     * Getter for Type.
     * Name of the affected dispute's type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for Id.
     * ID of the affected dispute.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Object.
     * @return Returns the DisputeEvidenceCreatedWebhookObject
     */
    @JsonGetter("object")
    public DisputeEvidenceCreatedWebhookObject getObject() {
        return object;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, object);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DisputeEvidenceCreatedWebhookData)) {
            return false;
        }
        DisputeEvidenceCreatedWebhookData other = (DisputeEvidenceCreatedWebhookData) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(id, other.id)
            && Objects.equals(object, other.object);
    }

    /**
     * Converts this DisputeEvidenceCreatedWebhookData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DisputeEvidenceCreatedWebhookData [" + "type=" + type + ", id=" + id + ", object="
                + object + "]";
    }

    /**
     * Builds a new {@link DisputeEvidenceCreatedWebhookData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DisputeEvidenceCreatedWebhookData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .id(getId())
                .object(getObject());
        return builder;
    }

    /**
     * Class to build instances of {@link DisputeEvidenceCreatedWebhookData}.
     */
    public static class Builder {
        private String type;
        private String id;
        private DisputeEvidenceCreatedWebhookObject object;



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
         * Setter for object.
         * @param  object  DisputeEvidenceCreatedWebhookObject value for object.
         * @return Builder
         */
        public Builder object(DisputeEvidenceCreatedWebhookObject object) {
            this.object = object;
            return this;
        }

        /**
         * Builds a new {@link DisputeEvidenceCreatedWebhookData} object using the set fields.
         * @return {@link DisputeEvidenceCreatedWebhookData}
         */
        public DisputeEvidenceCreatedWebhookData build() {
            return new DisputeEvidenceCreatedWebhookData(type, id, object);
        }
    }
}
