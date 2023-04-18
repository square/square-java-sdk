
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest type.
 */
public class BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest {
    private final String locationId;
    private final CustomAttribute customAttribute;
    private final OptionalNullable<String> idempotencyKey;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.locationId = locationId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
    }

    /**
     * Internal initialization constructor.
     */
    protected BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest(
            String locationId, CustomAttribute customAttribute,
            OptionalNullable<String> idempotencyKey) {
        this.locationId = locationId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for LocationId.
     * The ID of the target [location](entity:Location).
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for CustomAttribute.
     * A custom attribute value. Each custom attribute value has a corresponding
     * `CustomAttributeDefinition` object.
     * @return Returns the CustomAttribute
     */
    @JsonGetter("custom_attribute")
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    /**
     * Internal Getter for IdempotencyKey.
     * A unique identifier for this individual upsert request, used to ensure idempotency. For more
     * information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the Internal String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique identifier for this individual upsert request, used to ensure idempotency. For more
     * information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonIgnore
    public String getIdempotencyKey() {
        return OptionalNullable.getFrom(idempotencyKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, customAttribute, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest)) {
            return false;
        }
        BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest other =
                (BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest ["
                + "locationId=" + locationId + ", customAttribute=" + customAttribute
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId, customAttribute);
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest}.
     */
    public static class Builder {
        private String locationId;
        private CustomAttribute customAttribute;
        private OptionalNullable<String> idempotencyKey;

        /**
         * Initialization constructor.
         * @param  locationId  String value for locationId.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         */
        public Builder(String locationId, CustomAttribute customAttribute) {
            this.locationId = locationId;
            this.customAttribute = customAttribute;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for customAttribute.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         * @return Builder
         */
        public Builder customAttribute(CustomAttribute customAttribute) {
            this.customAttribute = customAttribute;
            return this;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = OptionalNullable.of(idempotencyKey);
            return this;
        }

        /**
         * UnSetter for idempotencyKey.
         * @return Builder
         */
        public Builder unsetIdempotencyKey() {
            idempotencyKey = null;
            return this;
        }

        /**
         * Builds a new {@link
         * BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest} object
         * using the set fields.
         * @return {@link BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest}
         */
        public BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest build() {
            return new BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest(
                    locationId, customAttribute, idempotencyKey);
        }
    }
}
