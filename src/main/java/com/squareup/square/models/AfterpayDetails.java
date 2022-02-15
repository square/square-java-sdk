
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for AfterpayDetails type.
 */
public class AfterpayDetails {
    private final String emailAddress;

    /**
     * Initialization constructor.
     * @param  emailAddress  String value for emailAddress.
     */
    @JsonCreator
    public AfterpayDetails(
            @JsonProperty("email_address") String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Getter for EmailAddress.
     * Email address on the buyer's Afterpay account.
     * @return Returns the String
     */
    @JsonGetter("email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AfterpayDetails)) {
            return false;
        }
        AfterpayDetails other = (AfterpayDetails) obj;
        return Objects.equals(emailAddress, other.emailAddress);
    }

    /**
     * Converts this AfterpayDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AfterpayDetails [" + "emailAddress=" + emailAddress + "]";
    }

    /**
     * Builds a new {@link AfterpayDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AfterpayDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .emailAddress(getEmailAddress());
        return builder;
    }

    /**
     * Class to build instances of {@link AfterpayDetails}.
     */
    public static class Builder {
        private String emailAddress;



        /**
         * Setter for emailAddress.
         * @param  emailAddress  String value for emailAddress.
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * Builds a new {@link AfterpayDetails} object using the set fields.
         * @return {@link AfterpayDetails}
         */
        public AfterpayDetails build() {
            return new AfterpayDetails(emailAddress);
        }
    }
}
