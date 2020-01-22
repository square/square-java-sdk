package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RevokeTokenResponse type.
 */
public class RevokeTokenResponse {

    /**
     * Initialization constructor.
     * @param success
     */
    @JsonCreator
    public RevokeTokenResponse(
            @JsonProperty("success") Boolean success) {
        this.success = success;
    }

    private HttpContext httpContext;
    private final Boolean success;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Success.
     * If the request is successful, this is true.
     */
    @JsonGetter("success")
    public Boolean getSuccess() {
        return this.success;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(success);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RevokeTokenResponse)) {
            return false;
        }
        RevokeTokenResponse revokeTokenResponse = (RevokeTokenResponse) obj;
        return Objects.equals(success, revokeTokenResponse.success);
    }

    /**
     * Builds a new {@link RevokeTokenResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RevokeTokenResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .success(getSuccess());
            return builder;
    }

    /**
     * Class to build instances of {@link RevokeTokenResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private Boolean success;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for success
         * @param success
         * @return Builder
         */
        public Builder success(Boolean success) {
            this.success = success;
            return this;
        }

        /**
         * Builds a new {@link RevokeTokenResponse} object using the set fields.
         * @return {@link RevokeTokenResponse}
         */
        public RevokeTokenResponse build() {
            RevokeTokenResponse model = new RevokeTokenResponse(success);
            model.httpContext = httpContext;
            return model;
        }
    }
}
