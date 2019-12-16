package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class RenewTokenRequest {

    @JsonCreator
    public RenewTokenRequest(
            @JsonProperty("access_token") String accessToken) {
        this.accessToken = accessToken;
    }

    private final String accessToken;

    @Override
    public int hashCode() {
        return Objects.hash(accessToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RenewTokenRequest)) {
            return false;
        }
        RenewTokenRequest renewTokenRequest = (RenewTokenRequest) o;
        return Objects.equals(accessToken, renewTokenRequest.accessToken);
    }

    /**
     * Getter for AccessToken.
     * The token you want to renew.
     */
    @JsonGetter("access_token")
    public String getAccessToken() { 
        return this.accessToken;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .accessToken(getAccessToken());
            return builder;
    }

    public static class Builder {
        private String accessToken;

        public Builder() { }

        public Builder accessToken(String value) {
            accessToken = value;
            return this;
        }

        public RenewTokenRequest build() {
            return new RenewTokenRequest(accessToken);
        }
    }
}
