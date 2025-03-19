package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DestinationDetails type.
 */
public class DestinationDetails {
    private final DestinationDetailsCardRefundDetails cardDetails;
    private final DestinationDetailsCashRefundDetails cashDetails;
    private final DestinationDetailsExternalRefundDetails externalDetails;

    /**
     * Initialization constructor.
     * @param  cardDetails  DestinationDetailsCardRefundDetails value for cardDetails.
     * @param  cashDetails  DestinationDetailsCashRefundDetails value for cashDetails.
     * @param  externalDetails  DestinationDetailsExternalRefundDetails value for externalDetails.
     */
    @JsonCreator
    public DestinationDetails(
            @JsonProperty("card_details") DestinationDetailsCardRefundDetails cardDetails,
            @JsonProperty("cash_details") DestinationDetailsCashRefundDetails cashDetails,
            @JsonProperty("external_details") DestinationDetailsExternalRefundDetails externalDetails) {
        this.cardDetails = cardDetails;
        this.cashDetails = cashDetails;
        this.externalDetails = externalDetails;
    }

    /**
     * Getter for CardDetails.
     * @return Returns the DestinationDetailsCardRefundDetails
     */
    @JsonGetter("card_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DestinationDetailsCardRefundDetails getCardDetails() {
        return cardDetails;
    }

    /**
     * Getter for CashDetails.
     * Stores details about a cash refund. Contains only non-confidential information.
     * @return Returns the DestinationDetailsCashRefundDetails
     */
    @JsonGetter("cash_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DestinationDetailsCashRefundDetails getCashDetails() {
        return cashDetails;
    }

    /**
     * Getter for ExternalDetails.
     * Stores details about an external refund. Contains only non-confidential information.
     * @return Returns the DestinationDetailsExternalRefundDetails
     */
    @JsonGetter("external_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DestinationDetailsExternalRefundDetails getExternalDetails() {
        return externalDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardDetails, cashDetails, externalDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DestinationDetails)) {
            return false;
        }
        DestinationDetails other = (DestinationDetails) obj;
        return Objects.equals(cardDetails, other.cardDetails)
                && Objects.equals(cashDetails, other.cashDetails)
                && Objects.equals(externalDetails, other.externalDetails);
    }

    /**
     * Converts this DestinationDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DestinationDetails [" + "cardDetails=" + cardDetails + ", cashDetails=" + cashDetails
                + ", externalDetails=" + externalDetails + "]";
    }

    /**
     * Builds a new {@link DestinationDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DestinationDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cardDetails(getCardDetails())
                .cashDetails(getCashDetails())
                .externalDetails(getExternalDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link DestinationDetails}.
     */
    public static class Builder {
        private DestinationDetailsCardRefundDetails cardDetails;
        private DestinationDetailsCashRefundDetails cashDetails;
        private DestinationDetailsExternalRefundDetails externalDetails;

        /**
         * Setter for cardDetails.
         * @param  cardDetails  DestinationDetailsCardRefundDetails value for cardDetails.
         * @return Builder
         */
        public Builder cardDetails(DestinationDetailsCardRefundDetails cardDetails) {
            this.cardDetails = cardDetails;
            return this;
        }

        /**
         * Setter for cashDetails.
         * @param  cashDetails  DestinationDetailsCashRefundDetails value for cashDetails.
         * @return Builder
         */
        public Builder cashDetails(DestinationDetailsCashRefundDetails cashDetails) {
            this.cashDetails = cashDetails;
            return this;
        }

        /**
         * Setter for externalDetails.
         * @param  externalDetails  DestinationDetailsExternalRefundDetails value for
         *         externalDetails.
         * @return Builder
         */
        public Builder externalDetails(DestinationDetailsExternalRefundDetails externalDetails) {
            this.externalDetails = externalDetails;
            return this;
        }

        /**
         * Builds a new {@link DestinationDetails} object using the set fields.
         * @return {@link DestinationDetails}
         */
        public DestinationDetails build() {
            return new DestinationDetails(cardDetails, cashDetails, externalDetails);
        }
    }
}
