package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TenderBankAccountDetails type.
 */
public class TenderBankAccountDetails {
    private final String status;

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     */
    @JsonCreator
    public TenderBankAccountDetails(@JsonProperty("status") String status) {
        this.status = status;
    }

    /**
     * Getter for Status.
     * Indicates the bank account payment's current status.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        if (!(obj instanceof TenderBankAccountDetails)) {
            return false;
        }
        TenderBankAccountDetails other = (TenderBankAccountDetails) obj;
        return Objects.equals(status, other.status);
    }

    /**
     * Converts this TenderBankAccountDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TenderBankAccountDetails [" + "status=" + status + "]";
    }

    /**
     * Builds a new {@link TenderBankAccountDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TenderBankAccountDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link TenderBankAccountDetails}.
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
         * Builds a new {@link TenderBankAccountDetails} object using the set fields.
         * @return {@link TenderBankAccountDetails}
         */
        public TenderBankAccountDetails build() {
            return new TenderBankAccountDetails(status);
        }
    }
}
