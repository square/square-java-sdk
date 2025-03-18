package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse type.
 */
public class BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse {
    private final String locationId;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse(
            @JsonProperty("location_id") String locationId, @JsonProperty("errors") List<Error> errors) {
        this.locationId = locationId;
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
     * Getter for Errors.
     * Errors that occurred while processing the individual LocationCustomAttributeDeleteRequest
     * request
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse)) {
            return false;
        }
        BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse other =
                (BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse) obj;
        return Objects.equals(locationId, other.locationId) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse [" + "locationId="
                + locationId + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().locationId(getLocationId()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse}.
     */
    public static class Builder {
        private String locationId;
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
         * BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse} object
         * using the set fields.
         * @return {@link BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse}
         */
        public BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse build() {
            return new BulkDeleteLocationCustomAttributesResponseLocationCustomAttributeDeleteResponse(
                    locationId, errors);
        }
    }
}
