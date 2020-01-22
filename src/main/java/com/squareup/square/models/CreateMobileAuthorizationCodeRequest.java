package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateMobileAuthorizationCodeRequest type.
 */
public class CreateMobileAuthorizationCodeRequest {

    /**
     * Initialization constructor.
     * @param locationId
     */
    @JsonCreator
    public CreateMobileAuthorizationCodeRequest(
            @JsonProperty("location_id") String locationId) {
        this.locationId = locationId;
    }

    private final String locationId;
    /**
     * Getter for LocationId.
     * The Square location ID the authorization code should be tied to.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateMobileAuthorizationCodeRequest)) {
            return false;
        }
        CreateMobileAuthorizationCodeRequest createMobileAuthorizationCodeRequest = (CreateMobileAuthorizationCodeRequest) obj;
        return Objects.equals(locationId, createMobileAuthorizationCodeRequest.locationId);
    }

    /**
     * Builds a new {@link CreateMobileAuthorizationCodeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateMobileAuthorizationCodeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationId(getLocationId());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateMobileAuthorizationCodeRequest}
     */
    public static class Builder {
        private String locationId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link CreateMobileAuthorizationCodeRequest} object using the set fields.
         * @return {@link CreateMobileAuthorizationCodeRequest}
         */
        public CreateMobileAuthorizationCodeRequest build() {
            return new CreateMobileAuthorizationCodeRequest(locationId);
        }
    }
}
