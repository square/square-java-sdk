package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for TenderBankTransferDetails type.
 */
public class TenderBankTransferDetails {

    /**
     * Initialization constructor.
     * @param status
     */
    @JsonCreator
    public TenderBankTransferDetails(
            @JsonProperty("status") String status) {
        this.status = status;
    }

    private final String status;
    /**
     * Getter for Status.
     * Indicates the bank transfer's current status.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof TenderBankTransferDetails)) {
            return false;
        }
        TenderBankTransferDetails tenderBankTransferDetails = (TenderBankTransferDetails) obj;
        return Objects.equals(status, tenderBankTransferDetails.status);
    }

    /**
     * Builds a new {@link TenderBankTransferDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TenderBankTransferDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .status(getStatus());
            return builder;
    }

    /**
     * Class to build instances of {@link TenderBankTransferDetails}
     */
    public static class Builder {
        private String status;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link TenderBankTransferDetails} object using the set fields.
         * @return {@link TenderBankTransferDetails}
         */
        public TenderBankTransferDetails build() {
            return new TenderBankTransferDetails(status);
        }
    }
}
