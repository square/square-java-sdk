
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RetrieveGiftCardFromGANRequest type.
 */
public class RetrieveGiftCardFromGANRequest {
    private final String gan;

    /**
     * Initialization constructor.
     * @param  gan  String value for gan.
     */
    @JsonCreator
    public RetrieveGiftCardFromGANRequest(
            @JsonProperty("gan") String gan) {
        this.gan = gan;
    }

    /**
     * Getter for Gan.
     * The gift card account number (GAN) of the gift card to retrieve. The maximum length of a GAN
     * is 255 digits to account for third-party GANs that have been imported. Square-issued gift
     * cards have 16-digit GANs.
     * @return Returns the String
     */
    @JsonGetter("gan")
    public String getGan() {
        return gan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gan);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveGiftCardFromGANRequest)) {
            return false;
        }
        RetrieveGiftCardFromGANRequest other = (RetrieveGiftCardFromGANRequest) obj;
        return Objects.equals(gan, other.gan);
    }

    /**
     * Converts this RetrieveGiftCardFromGANRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveGiftCardFromGANRequest [" + "gan=" + gan + "]";
    }

    /**
     * Builds a new {@link RetrieveGiftCardFromGANRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveGiftCardFromGANRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(gan);
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveGiftCardFromGANRequest}.
     */
    public static class Builder {
        private String gan;

        /**
         * Initialization constructor.
         * @param  gan  String value for gan.
         */
        public Builder(String gan) {
            this.gan = gan;
        }

        /**
         * Setter for gan.
         * @param  gan  String value for gan.
         * @return Builder
         */
        public Builder gan(String gan) {
            this.gan = gan;
            return this;
        }

        /**
         * Builds a new {@link RetrieveGiftCardFromGANRequest} object using the set fields.
         * @return {@link RetrieveGiftCardFromGANRequest}
         */
        public RetrieveGiftCardFromGANRequest build() {
            return new RetrieveGiftCardFromGANRequest(gan);
        }
    }
}
