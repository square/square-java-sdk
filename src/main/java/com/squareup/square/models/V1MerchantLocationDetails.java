package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1MerchantLocationDetails {

    @JsonCreator
    public V1MerchantLocationDetails(
            @JsonProperty("nickname") String nickname) {
        this.nickname = nickname;
    }

    private final String nickname;

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1MerchantLocationDetails)) {
            return false;
        }
        V1MerchantLocationDetails v1MerchantLocationDetails = (V1MerchantLocationDetails) o;
        return Objects.equals(nickname, v1MerchantLocationDetails.nickname);
    }

    /**
     * Getter for Nickname.
     * The nickname assigned to the single-location account by the parent business. This value appears in the parent business's multi-location dashboard.
     */
    @JsonGetter("nickname")
    public String getNickname() { 
        return this.nickname;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .nickname(getNickname());
            return builder;
    }

    public static class Builder {
        private String nickname;

        public Builder() { }

        public Builder nickname(String value) {
            nickname = value;
            return this;
        }

        public V1MerchantLocationDetails build() {
            return new V1MerchantLocationDetails(nickname);
        }
    }
}
