
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for RenewTokenRequest type.
 */
public class RenewTokenRequest {
    private final OptionalNullable<String> accessToken;

    /**
     * Initialization constructor.
     * @param  accessToken  String value for accessToken.
     */
    @JsonCreator
    public RenewTokenRequest(
            @JsonProperty("access_token") String accessToken) {
        this.accessToken = OptionalNullable.of(accessToken);
    }

    /**
     * Initialization constructor.
     * @param  accessToken  String value for accessToken.
     */

    protected RenewTokenRequest(OptionalNullable<String> accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Internal Getter for AccessToken.
     * The token you want to renew.
     * @return Returns the Internal String
     */
    @JsonGetter("access_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAccessToken() {
        return this.accessToken;
    }

    /**
     * Getter for AccessToken.
     * The token you want to renew.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAccessToken() {
        return OptionalNullable.getFrom(accessToken);
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
        Builder builder = new Builder();
        builder.accessToken = internalGetAccessToken();
        return builder;
    }

    /**
     * Class to build instances of {@link RenewTokenRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> accessToken;



        /**
         * Setter for accessToken.
         * @param  accessToken  String value for accessToken.
         * @return Builder
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = OptionalNullable.of(accessToken);
            return this;
        }

        /**
         * UnSetter for accessToken.
         * @return Builder
         */
        public Builder unsetAccessToken() {
            accessToken = null;
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
