package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RevokeTokenResponse {

    @JsonCreator
    public RevokeTokenResponse(
            @JsonProperty("success") Boolean success) {
        this.success = success;
    }

    private HttpContext httpContext;
    private final Boolean success;

    @Override
    public int hashCode() {
        return Objects.hash(success);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RevokeTokenResponse)) {
            return false;
        }
        RevokeTokenResponse revokeTokenResponse = (RevokeTokenResponse) o;
        return Objects.equals(success, revokeTokenResponse.success);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .success(getSuccess());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private Boolean success;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder success(Boolean value) {
            success = value;
            return this;
        }

        public RevokeTokenResponse build() {
            RevokeTokenResponse model = new RevokeTokenResponse(success);
            model.httpContext = httpContext;
            return model;
        }
    }
}
