
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RetrieveGiftCardFromNonceRequest type.
 */
public class RetrieveGiftCardFromNonceRequest {
    private final String nonce;

    /**
     * Initialization constructor.
     * @param  nonce  String value for nonce.
     */
    @JsonCreator
    public RetrieveGiftCardFromNonceRequest(
            @JsonProperty("nonce") String nonce) {
        this.nonce = nonce;
    }

    /**
     * Getter for Nonce.
     * The nonce of the gift card to retrieve.
     * @return Returns the String
     */
    @JsonGetter("nonce")
    public String getNonce() {
        return nonce;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nonce);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveGiftCardFromNonceRequest)) {
            return false;
        }
        RetrieveGiftCardFromNonceRequest other = (RetrieveGiftCardFromNonceRequest) obj;
        return Objects.equals(nonce, other.nonce);
    }

    /**
     * Converts this RetrieveGiftCardFromNonceRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveGiftCardFromNonceRequest [" + "nonce=" + nonce + "]";
    }

    /**
     * Builds a new {@link RetrieveGiftCardFromNonceRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveGiftCardFromNonceRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(nonce);
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveGiftCardFromNonceRequest}.
     */
    public static class Builder {
        private String nonce;

        /**
         * Initialization constructor.
         * @param  nonce  String value for nonce.
         */
        public Builder(String nonce) {
            this.nonce = nonce;
        }

        /**
         * Setter for nonce.
         * @param  nonce  String value for nonce.
         * @return Builder
         */
        public Builder nonce(String nonce) {
            this.nonce = nonce;
            return this;
        }

        /**
         * Builds a new {@link RetrieveGiftCardFromNonceRequest} object using the set fields.
         * @return {@link RetrieveGiftCardFromNonceRequest}
         */
        public RetrieveGiftCardFromNonceRequest build() {
            return new RetrieveGiftCardFromNonceRequest(nonce);
        }
    }
}
