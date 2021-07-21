
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DigitalWalletDetails type.
 */
public class DigitalWalletDetails {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     */
    @JsonCreator
    public DigitalWalletDetails(
            @JsonProperty("status") String status) {
        this.status = status;
    }

    /**
     * Getter for Status.
     * The status of the `WALLET` payment. The status can be `AUTHORIZED`, `CAPTURED`, `VOIDED`, or
     * `FAILED`.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DigitalWalletDetails)) {
            return false;
        }
        DigitalWalletDetails other = (DigitalWalletDetails) obj;
        return Objects.equals(status, other.status);
    }

    /**
     * Converts this DigitalWalletDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DigitalWalletDetails [" + "status=" + status + "]";
    }

    /**
     * Builds a new {@link DigitalWalletDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DigitalWalletDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link DigitalWalletDetails}.
     */
    public static class Builder {
        private String status;



        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link DigitalWalletDetails} object using the set fields.
         * @return {@link DigitalWalletDetails}
         */
        public DigitalWalletDetails build() {
            return new DigitalWalletDetails(status);
        }
    }
}
