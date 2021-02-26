
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.Objects;

/**
 * This is a model class for RevokeTokenResponse type.
 */
public class RevokeTokenResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean success;

    /**
     * Initialization constructor.
     * @param  success  Boolean value for success.
     */
    @JsonCreator
    public RevokeTokenResponse(
            @JsonProperty("success") Boolean success) {
        this.success = success;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Success.
     * If the request is successful, this is true.
     * @return Returns the Boolean
     */
    @JsonGetter("success")
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public int hashCode() {
        return Objects.hash(success);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RevokeTokenResponse)) {
            return false;
        }
        RevokeTokenResponse other = (RevokeTokenResponse) obj;
        return Objects.equals(success, other.success);
    }

    /**
     * Converts this RevokeTokenResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RevokeTokenResponse [" + "success=" + success + "]";
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
     * Class to build instances of {@link RevokeTokenResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Boolean success;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for success.
         * @param  success  Boolean value for success.
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
            RevokeTokenResponse model =
                    new RevokeTokenResponse(success);
            model.httpContext = httpContext;
            return model;
        }
    }
}
