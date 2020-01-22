package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1MerchantLocationDetails type.
 */
public class V1MerchantLocationDetails {

    /**
     * Initialization constructor.
     * @param nickname
     */
    @JsonCreator
    public V1MerchantLocationDetails(
            @JsonProperty("nickname") String nickname) {
        this.nickname = nickname;
    }

    private final String nickname;
    /**
     * Getter for Nickname.
     * The nickname assigned to the single-location account by the parent business. This value appears in the parent business's multi-location dashboard.
     */
    @JsonGetter("nickname")
    public String getNickname() {
        return this.nickname;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1MerchantLocationDetails)) {
            return false;
        }
        V1MerchantLocationDetails v1MerchantLocationDetails = (V1MerchantLocationDetails) obj;
        return Objects.equals(nickname, v1MerchantLocationDetails.nickname);
    }

    /**
     * Builds a new {@link V1MerchantLocationDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1MerchantLocationDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .nickname(getNickname());
            return builder;
    }

    /**
     * Class to build instances of {@link V1MerchantLocationDetails}
     */
    public static class Builder {
        private String nickname;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for nickname
         * @param nickname
         * @return Builder
         */
        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        /**
         * Builds a new {@link V1MerchantLocationDetails} object using the set fields.
         * @return {@link V1MerchantLocationDetails}
         */
        public V1MerchantLocationDetails build() {
            return new V1MerchantLocationDetails(nickname);
        }
    }
}
