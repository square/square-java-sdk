
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ClearpayDetails type.
 */
public class ClearpayDetails {
    private final String emailAddress;

    /**
     * Initialization constructor.
     * @param  emailAddress  String value for emailAddress.
     */
    @JsonCreator
    public ClearpayDetails(
            @JsonProperty("email_address") String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Getter for EmailAddress.
     * Email address on the buyer's Clearpay account.
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
        if (!(obj instanceof ClearpayDetails)) {
            return false;
        }
        ClearpayDetails other = (ClearpayDetails) obj;
        return Objects.equals(emailAddress, other.emailAddress);
    }

    /**
     * Converts this ClearpayDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ClearpayDetails [" + "emailAddress=" + emailAddress + "]";
    }

    /**
     * Builds a new {@link ClearpayDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ClearpayDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .emailAddress(getEmailAddress());
        return builder;
    }

    /**
     * Class to build instances of {@link ClearpayDetails}.
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
         * Builds a new {@link ClearpayDetails} object using the set fields.
         * @return {@link ClearpayDetails}
         */
        public ClearpayDetails build() {
            return new ClearpayDetails(emailAddress);
        }
    }
}
