
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse type.
 */
public class BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse {
    private final String locationId;
    private final CustomAttribute customAttribute;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("errors") List<Error> errors) {
        this.locationId = locationId;
        this.customAttribute = customAttribute;
        this.errors = errors;
    }

    /**
     * Getter for LocationId.
     * The ID of the location associated with the custom attribute.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred while processing the individual request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, customAttribute, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse)) {
            return false;
        }
        BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse other =
                (BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse ["
                + "locationId=" + locationId + ", customAttribute=" + customAttribute + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .locationId(getLocationId())
                .customAttribute(getCustomAttribute())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse}.
     */
    public static class Builder {
        private String locationId;
        private CustomAttribute customAttribute;
        private List<Error> errors;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link
         * BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse} object
         * using the set fields.
         * @return {@link BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse}
         */
        public BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse build() {
            return new BulkUpsertLocationCustomAttributesResponseLocationCustomAttributeUpsertResponse(
                    locationId, customAttribute, errors);
        }
    }
}
