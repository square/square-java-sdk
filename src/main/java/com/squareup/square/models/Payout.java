
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Payout type.
 */
public class Payout {
    private final String id;
    private final String status;
    private final String locationId;
    private final String createdAt;
    private final String updatedAt;
    private final Money amountMoney;
    private final Destination destination;
    private final Integer version;
    private final String type;
    private final List<PayoutFee> payoutFee;
    private final String arrivalDate;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  locationId  String value for locationId.
     * @param  status  String value for status.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  amountMoney  Money value for amountMoney.
     * @param  destination  Destination value for destination.
     * @param  version  Integer value for version.
     * @param  type  String value for type.
     * @param  payoutFee  List of PayoutFee value for payoutFee.
     * @param  arrivalDate  String value for arrivalDate.
     */
    @JsonCreator
    public Payout(
            @JsonProperty("id") String id,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("status") String status,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("destination") Destination destination,
            @JsonProperty("version") Integer version,
            @JsonProperty("type") String type,
            @JsonProperty("payout_fee") List<PayoutFee> payoutFee,
            @JsonProperty("arrival_date") String arrivalDate) {
        this.id = id;
        this.status = status;
        this.locationId = locationId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.amountMoney = amountMoney;
        this.destination = destination;
        this.version = version;
        this.type = type;
        this.payoutFee = payoutFee;
        this.arrivalDate = arrivalDate;
    }

    /**
     * Getter for Id.
     * A unique ID for the payout.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Status.
     * Payout status types
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for LocationId.
     * The ID of the location associated with the payout.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp of when the payout was created and submitted for deposit to the seller's
     * banking destination, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp of when the payout was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for Destination.
     * Information about the destination against which the payout was made.
     * @return Returns the Destination
     */
    @JsonGetter("destination")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Destination getDestination() {
        return destination;
    }

    /**
     * Getter for Version.
     * The version number, which is incremented each time an update is made to this payout record.
     * The version number helps developers receive event notifications or feeds out of order.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for Type.
     * The type of payout: “BATCH” or “SIMPLE”. BATCH payouts include a list of payout entries that
     * can be considered settled. SIMPLE payouts do not have any payout entries associated with them
     * and will show up as one of the payout entries in a future BATCH payout.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for PayoutFee.
     * A list of processing fees and any taxes on the fees assessed by Square for this payout.
     * @return Returns the List of PayoutFee
     */
    @JsonGetter("payout_fee")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<PayoutFee> getPayoutFee() {
        return payoutFee;
    }

    /**
     * Getter for ArrivalDate.
     * The calendar date, in ISO 8601 format (YYYY-MM-DD), when the payout is due to arrive in the
     * seller’s banking destination.
     * @return Returns the String
     */
    @JsonGetter("arrival_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, locationId, createdAt, updatedAt, amountMoney, destination,
                version, type, payoutFee, arrivalDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Payout)) {
            return false;
        }
        Payout other = (Payout) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(status, other.status)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(destination, other.destination)
            && Objects.equals(version, other.version)
            && Objects.equals(type, other.type)
            && Objects.equals(payoutFee, other.payoutFee)
            && Objects.equals(arrivalDate, other.arrivalDate);
    }

    /**
     * Converts this Payout into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Payout [" + "id=" + id + ", locationId=" + locationId + ", status=" + status
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", amountMoney="
                + amountMoney + ", destination=" + destination + ", version=" + version + ", type="
                + type + ", payoutFee=" + payoutFee + ", arrivalDate=" + arrivalDate + "]";
    }

    /**
     * Builds a new {@link Payout.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Payout.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, locationId)
                .status(getStatus())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .amountMoney(getAmountMoney())
                .destination(getDestination())
                .version(getVersion())
                .type(getType())
                .payoutFee(getPayoutFee())
                .arrivalDate(getArrivalDate());
        return builder;
    }

    /**
     * Class to build instances of {@link Payout}.
     */
    public static class Builder {
        private String id;
        private String locationId;
        private String status;
        private String createdAt;
        private String updatedAt;
        private Money amountMoney;
        private Destination destination;
        private Integer version;
        private String type;
        private List<PayoutFee> payoutFee;
        private String arrivalDate;

        /**
         * Initialization constructor.
         * @param  id  String value for id.
         * @param  locationId  String value for locationId.
         */
        public Builder(String id, String locationId) {
            this.id = id;
            this.locationId = locationId;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

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
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for destination.
         * @param  destination  Destination value for destination.
         * @return Builder
         */
        public Builder destination(Destination destination) {
            this.destination = destination;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for payoutFee.
         * @param  payoutFee  List of PayoutFee value for payoutFee.
         * @return Builder
         */
        public Builder payoutFee(List<PayoutFee> payoutFee) {
            this.payoutFee = payoutFee;
            return this;
        }

        /**
         * Setter for arrivalDate.
         * @param  arrivalDate  String value for arrivalDate.
         * @return Builder
         */
        public Builder arrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
            return this;
        }

        /**
         * Builds a new {@link Payout} object using the set fields.
         * @return {@link Payout}
         */
        public Payout build() {
            return new Payout(id, locationId, status, createdAt, updatedAt, amountMoney,
                    destination, version, type, payoutFee, arrivalDate);
        }
    }
}
