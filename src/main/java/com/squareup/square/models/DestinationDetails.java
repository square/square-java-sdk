
package com.squareup.square.models;

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

    /**
     * Initialization constructor.
     * @param  cardDetails  DestinationDetailsCardRefundDetails value for cardDetails.
     */
    @JsonCreator
    public DestinationDetails(
            @JsonProperty("card_details") DestinationDetailsCardRefundDetails cardDetails) {
        this.cardDetails = cardDetails;
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

    @Override
    public int hashCode() {
        return Objects.hash(cardDetails);
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
        return Objects.equals(cardDetails, other.cardDetails);
    }

    /**
     * Converts this DestinationDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DestinationDetails [" + "cardDetails=" + cardDetails + "]";
    }

    /**
     * Builds a new {@link DestinationDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DestinationDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cardDetails(getCardDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link DestinationDetails}.
     */
    public static class Builder {
        private DestinationDetailsCardRefundDetails cardDetails;



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
         * Builds a new {@link DestinationDetails} object using the set fields.
         * @return {@link DestinationDetails}
         */
        public DestinationDetails build() {
            return new DestinationDetails(cardDetails);
        }
    }
}
