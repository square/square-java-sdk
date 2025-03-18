package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TenderSquareAccountDetails type.
 */
public class TenderSquareAccountDetails {
    private final String status;

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     */
    @JsonCreator
    public TenderSquareAccountDetails(@JsonProperty("status") String status) {
        this.status = status;
    }

    /**
     * Getter for Status.
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
        if (!(obj instanceof TenderSquareAccountDetails)) {
            return false;
        }
        TenderSquareAccountDetails other = (TenderSquareAccountDetails) obj;
        return Objects.equals(status, other.status);
    }

    /**
     * Converts this TenderSquareAccountDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TenderSquareAccountDetails [" + "status=" + status + "]";
    }

    /**
     * Builds a new {@link TenderSquareAccountDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TenderSquareAccountDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link TenderSquareAccountDetails}.
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
         * Builds a new {@link TenderSquareAccountDetails} object using the set fields.
         * @return {@link TenderSquareAccountDetails}
         */
        public TenderSquareAccountDetails build() {
            return new TenderSquareAccountDetails(status);
        }
    }
}
