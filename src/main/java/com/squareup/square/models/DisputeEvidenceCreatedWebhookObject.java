
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DisputeEvidenceCreatedWebhookObject type.
 */
public class DisputeEvidenceCreatedWebhookObject {
    private final Dispute object;

    /**
     * Initialization constructor.
     * @param  object  Dispute value for object.
     */
    @JsonCreator
    public DisputeEvidenceCreatedWebhookObject(
            @JsonProperty("object") Dispute object) {
        this.object = object;
    }

    /**
     * Getter for Object.
     * Represents a dispute a cardholder initiated with their bank.
     * @return Returns the Dispute
     */
    @JsonGetter("object")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Dispute getObject() {
        return object;
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DisputeEvidenceCreatedWebhookObject)) {
            return false;
        }
        DisputeEvidenceCreatedWebhookObject other = (DisputeEvidenceCreatedWebhookObject) obj;
        return Objects.equals(object, other.object);
    }

    /**
     * Converts this DisputeEvidenceCreatedWebhookObject into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DisputeEvidenceCreatedWebhookObject [" + "object=" + object + "]";
    }

    /**
     * Builds a new {@link DisputeEvidenceCreatedWebhookObject.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DisputeEvidenceCreatedWebhookObject.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .object(getObject());
        return builder;
    }

    /**
     * Class to build instances of {@link DisputeEvidenceCreatedWebhookObject}.
     */
    public static class Builder {
        private Dispute object;



        /**
         * Setter for object.
         * @param  object  Dispute value for object.
         * @return Builder
         */
        public Builder object(Dispute object) {
            this.object = object;
            return this;
        }

        /**
         * Builds a new {@link DisputeEvidenceCreatedWebhookObject} object using the set fields.
         * @return {@link DisputeEvidenceCreatedWebhookObject}
         */
        public DisputeEvidenceCreatedWebhookObject build() {
            return new DisputeEvidenceCreatedWebhookObject(object);
        }
    }
}
