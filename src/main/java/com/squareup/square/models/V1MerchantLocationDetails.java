
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1MerchantLocationDetails type.
 */
public class V1MerchantLocationDetails {
    private final String nickname;

    /**
     * Initialization constructor.
     * @param nickname String value for nickname.
     */
    @JsonCreator
    public V1MerchantLocationDetails(
            @JsonProperty("nickname") String nickname) {
        this.nickname = nickname;
    }

    /**
     * Getter for Nickname.
     * The nickname assigned to the single-location account by the parent business. This value
     * appears in the parent business's multi-location dashboard.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1MerchantLocationDetails)) {
            return false;
        }
        V1MerchantLocationDetails other = (V1MerchantLocationDetails) obj;
        return Objects.equals(nickname, other.nickname);
    }

    /**
     * Converts this V1MerchantLocationDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1MerchantLocationDetails [" + "nickname=" + nickname + "]";
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
     * Class to build instances of {@link V1MerchantLocationDetails}.
     */
    public static class Builder {
        private String nickname;



        /**
         * Setter for nickname.
         * @param nickname String value for nickname.
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
