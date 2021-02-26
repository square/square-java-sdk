
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RenewTokenRequest type.
 */
public class RenewTokenRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String accessToken;

    /**
     * Initialization constructor.
     * @param  accessToken  String value for accessToken.
     */
    @JsonCreator
    public RenewTokenRequest(
            @JsonProperty("access_token") String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Getter for AccessToken.
     * The token you want to renew.
     * @return Returns the String
     */
    @JsonGetter("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RenewTokenRequest)) {
            return false;
        }
        RenewTokenRequest other = (RenewTokenRequest) obj;
        return Objects.equals(accessToken, other.accessToken);
    }

    /**
     * Converts this RenewTokenRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RenewTokenRequest [" + "accessToken=" + accessToken + "]";
    }

    /**
     * Builds a new {@link RenewTokenRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RenewTokenRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .accessToken(getAccessToken());
        return builder;
    }

    /**
     * Class to build instances of {@link RenewTokenRequest}.
     */
    public static class Builder {
        private String accessToken;



        /**
         * Setter for accessToken.
         * @param  accessToken  String value for accessToken.
         * @return Builder
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * Builds a new {@link RenewTokenRequest} object using the set fields.
         * @return {@link RenewTokenRequest}
         */
        public RenewTokenRequest build() {
            return new RenewTokenRequest(accessToken);
        }
    }
}
