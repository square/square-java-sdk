
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateMobileAuthorizationCodeRequest type.
 */
public class CreateMobileAuthorizationCodeRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public CreateMobileAuthorizationCodeRequest(
            @JsonProperty("location_id") String locationId) {
        this.locationId = locationId;
    }

    /**
     * Getter for LocationId.
     * The Square location ID the authorization code should be tied to.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateMobileAuthorizationCodeRequest)) {
            return false;
        }
        CreateMobileAuthorizationCodeRequest other = (CreateMobileAuthorizationCodeRequest) obj;
        return Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this CreateMobileAuthorizationCodeRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateMobileAuthorizationCodeRequest [" + "locationId=" + locationId + "]";
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
     * Class to build instances of {@link CreateMobileAuthorizationCodeRequest}.
     */
    public static class Builder {
        private String locationId;



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
         * Builds a new {@link CreateMobileAuthorizationCodeRequest} object using the set fields.
         * @return {@link CreateMobileAuthorizationCodeRequest}
         */
        public CreateMobileAuthorizationCodeRequest build() {
            return new CreateMobileAuthorizationCodeRequest(locationId);
        }
    }
}
