
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivity type.
 */
public class GiftCardActivity {
    private final String id;
    private final String type;
    private final String locationId;
    private final String createdAt;
    private final String giftCardId;
    private final String giftCardGan;
    private final Money giftCardBalanceMoney;
    private final GiftCardActivityLoad loadActivityDetails;
    private final GiftCardActivityActivate activateActivityDetails;
    private final GiftCardActivityRedeem redeemActivityDetails;
    private final GiftCardActivityClearBalance clearBalanceActivityDetails;
    private final GiftCardActivityDeactivate deactivateActivityDetails;
    private final GiftCardActivityAdjustIncrement adjustIncrementActivityDetails;
    private final GiftCardActivityAdjustDecrement adjustDecrementActivityDetails;
    private final GiftCardActivityRefund refundActivityDetails;
    private final GiftCardActivityUnlinkedActivityRefund unlinkedActivityRefundActivityDetails;
    private final GiftCardActivityImport importActivityDetails;
    private final GiftCardActivityBlock blockActivityDetails;
    private final GiftCardActivityUnblock unblockActivityDetails;
    private final GiftCardActivityImportReversal importReversalActivityDetails;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  locationId  String value for locationId.
     * @param  id  String value for id.
     * @param  createdAt  String value for createdAt.
     * @param  giftCardId  String value for giftCardId.
     * @param  giftCardGan  String value for giftCardGan.
     * @param  giftCardBalanceMoney  Money value for giftCardBalanceMoney.
     * @param  loadActivityDetails  GiftCardActivityLoad value for loadActivityDetails.
     * @param  activateActivityDetails  GiftCardActivityActivate value for activateActivityDetails.
     * @param  redeemActivityDetails  GiftCardActivityRedeem value for redeemActivityDetails.
     * @param  clearBalanceActivityDetails  GiftCardActivityClearBalance value for
     *         clearBalanceActivityDetails.
     * @param  deactivateActivityDetails  GiftCardActivityDeactivate value for
     *         deactivateActivityDetails.
     * @param  adjustIncrementActivityDetails  GiftCardActivityAdjustIncrement value for
     *         adjustIncrementActivityDetails.
     * @param  adjustDecrementActivityDetails  GiftCardActivityAdjustDecrement value for
     *         adjustDecrementActivityDetails.
     * @param  refundActivityDetails  GiftCardActivityRefund value for refundActivityDetails.
     * @param  unlinkedActivityRefundActivityDetails  GiftCardActivityUnlinkedActivityRefund value
     *         for unlinkedActivityRefundActivityDetails.
     * @param  importActivityDetails  GiftCardActivityImport value for importActivityDetails.
     * @param  blockActivityDetails  GiftCardActivityBlock value for blockActivityDetails.
     * @param  unblockActivityDetails  GiftCardActivityUnblock value for unblockActivityDetails.
     * @param  importReversalActivityDetails  GiftCardActivityImportReversal value for
     *         importReversalActivityDetails.
     */
    @JsonCreator
    public GiftCardActivity(
            @JsonProperty("type") String type,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("gift_card_id") String giftCardId,
            @JsonProperty("gift_card_gan") String giftCardGan,
            @JsonProperty("gift_card_balance_money") Money giftCardBalanceMoney,
            @JsonProperty("load_activity_details") GiftCardActivityLoad loadActivityDetails,
            @JsonProperty("activate_activity_details") GiftCardActivityActivate activateActivityDetails,
            @JsonProperty("redeem_activity_details") GiftCardActivityRedeem redeemActivityDetails,
            @JsonProperty("clear_balance_activity_details") GiftCardActivityClearBalance clearBalanceActivityDetails,
            @JsonProperty("deactivate_activity_details") GiftCardActivityDeactivate deactivateActivityDetails,
            @JsonProperty("adjust_increment_activity_details") GiftCardActivityAdjustIncrement adjustIncrementActivityDetails,
            @JsonProperty("adjust_decrement_activity_details") GiftCardActivityAdjustDecrement adjustDecrementActivityDetails,
            @JsonProperty("refund_activity_details") GiftCardActivityRefund refundActivityDetails,
            @JsonProperty("unlinked_activity_refund_activity_details") GiftCardActivityUnlinkedActivityRefund unlinkedActivityRefundActivityDetails,
            @JsonProperty("import_activity_details") GiftCardActivityImport importActivityDetails,
            @JsonProperty("block_activity_details") GiftCardActivityBlock blockActivityDetails,
            @JsonProperty("unblock_activity_details") GiftCardActivityUnblock unblockActivityDetails,
            @JsonProperty("import_reversal_activity_details") GiftCardActivityImportReversal importReversalActivityDetails) {
        this.id = id;
        this.type = type;
        this.locationId = locationId;
        this.createdAt = createdAt;
        this.giftCardId = giftCardId;
        this.giftCardGan = giftCardGan;
        this.giftCardBalanceMoney = giftCardBalanceMoney;
        this.loadActivityDetails = loadActivityDetails;
        this.activateActivityDetails = activateActivityDetails;
        this.redeemActivityDetails = redeemActivityDetails;
        this.clearBalanceActivityDetails = clearBalanceActivityDetails;
        this.deactivateActivityDetails = deactivateActivityDetails;
        this.adjustIncrementActivityDetails = adjustIncrementActivityDetails;
        this.adjustDecrementActivityDetails = adjustDecrementActivityDetails;
        this.refundActivityDetails = refundActivityDetails;
        this.unlinkedActivityRefundActivityDetails = unlinkedActivityRefundActivityDetails;
        this.importActivityDetails = importActivityDetails;
        this.blockActivityDetails = blockActivityDetails;
        this.unblockActivityDetails = unblockActivityDetails;
        this.importReversalActivityDetails = importReversalActivityDetails;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the gift card activity.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Type.
     * Indicates the type of [gift card activity]($m/GiftCardActivity).
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for LocationId.
     * The ID of the [business location]($m/Location) where the activity occurred.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the gift card activity was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for GiftCardId.
     * The gift card ID. When creating a gift card activity, `gift_card_id` is not required if
     * `gift_card_gan` is specified.
     * @return Returns the String
     */
    @JsonGetter("gift_card_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getGiftCardId() {
        return giftCardId;
    }

    /**
     * Getter for GiftCardGan.
     * The gift card account number (GAN). When creating a gift card activity, `gift_card_gan` is
     * not required if `gift_card_id` is specified.
     * @return Returns the String
     */
    @JsonGetter("gift_card_gan")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getGiftCardGan() {
        return giftCardGan;
    }

    /**
     * Getter for GiftCardBalanceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("gift_card_balance_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getGiftCardBalanceMoney() {
        return giftCardBalanceMoney;
    }

    /**
     * Getter for LoadActivityDetails.
     * Represents details about a `LOAD` [gift card activity type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityLoad
     */
    @JsonGetter("load_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityLoad getLoadActivityDetails() {
        return loadActivityDetails;
    }

    /**
     * Getter for ActivateActivityDetails.
     * Represents details about an `ACTIVATE` [gift card activity type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityActivate
     */
    @JsonGetter("activate_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityActivate getActivateActivityDetails() {
        return activateActivityDetails;
    }

    /**
     * Getter for RedeemActivityDetails.
     * Represents details about a `REDEEM` [gift card activity type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityRedeem
     */
    @JsonGetter("redeem_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityRedeem getRedeemActivityDetails() {
        return redeemActivityDetails;
    }

    /**
     * Getter for ClearBalanceActivityDetails.
     * Represents details about a `CLEAR_BALANCE` [gift card activity
     * type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityClearBalance
     */
    @JsonGetter("clear_balance_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityClearBalance getClearBalanceActivityDetails() {
        return clearBalanceActivityDetails;
    }

    /**
     * Getter for DeactivateActivityDetails.
     * Represents details about a `DEACTIVATE` [gift card activity type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityDeactivate
     */
    @JsonGetter("deactivate_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityDeactivate getDeactivateActivityDetails() {
        return deactivateActivityDetails;
    }

    /**
     * Getter for AdjustIncrementActivityDetails.
     * Represents details about an `ADJUST_INCREMENT` [gift card activity
     * type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityAdjustIncrement
     */
    @JsonGetter("adjust_increment_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityAdjustIncrement getAdjustIncrementActivityDetails() {
        return adjustIncrementActivityDetails;
    }

    /**
     * Getter for AdjustDecrementActivityDetails.
     * Represents details about an `ADJUST_DECREMENT` [gift card activity
     * type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityAdjustDecrement
     */
    @JsonGetter("adjust_decrement_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityAdjustDecrement getAdjustDecrementActivityDetails() {
        return adjustDecrementActivityDetails;
    }

    /**
     * Getter for RefundActivityDetails.
     * Represents details about a `REFUND` [gift card activity type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityRefund
     */
    @JsonGetter("refund_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityRefund getRefundActivityDetails() {
        return refundActivityDetails;
    }

    /**
     * Getter for UnlinkedActivityRefundActivityDetails.
     * Represents details about an `UNLINKED_ACTIVITY_REFUND` [gift card activity
     * type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityUnlinkedActivityRefund
     */
    @JsonGetter("unlinked_activity_refund_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityUnlinkedActivityRefund getUnlinkedActivityRefundActivityDetails() {
        return unlinkedActivityRefundActivityDetails;
    }

    /**
     * Getter for ImportActivityDetails.
     * Represents details about an `IMPORT` [gift card activity type]($m/GiftCardActivityType). This
     * activity type is used when Square imports a third-party gift card, in which case the
     * `gan_source` of the gift card is set to `OTHER`.
     * @return Returns the GiftCardActivityImport
     */
    @JsonGetter("import_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityImport getImportActivityDetails() {
        return importActivityDetails;
    }

    /**
     * Getter for BlockActivityDetails.
     * Represents details about a `BLOCK` [gift card activity type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityBlock
     */
    @JsonGetter("block_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityBlock getBlockActivityDetails() {
        return blockActivityDetails;
    }

    /**
     * Getter for UnblockActivityDetails.
     * Represents details about an `UNBLOCK` [gift card activity type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityUnblock
     */
    @JsonGetter("unblock_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityUnblock getUnblockActivityDetails() {
        return unblockActivityDetails;
    }

    /**
     * Getter for ImportReversalActivityDetails.
     * Represents details about an `IMPORT_REVERSAL` [gift card activity
     * type]($m/GiftCardActivityType).
     * @return Returns the GiftCardActivityImportReversal
     */
    @JsonGetter("import_reversal_activity_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivityImportReversal getImportReversalActivityDetails() {
        return importReversalActivityDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, locationId, createdAt, giftCardId, giftCardGan,
                giftCardBalanceMoney, loadActivityDetails, activateActivityDetails,
                redeemActivityDetails, clearBalanceActivityDetails, deactivateActivityDetails,
                adjustIncrementActivityDetails, adjustDecrementActivityDetails,
                refundActivityDetails, unlinkedActivityRefundActivityDetails, importActivityDetails,
                blockActivityDetails, unblockActivityDetails, importReversalActivityDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivity)) {
            return false;
        }
        GiftCardActivity other = (GiftCardActivity) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(type, other.type)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(giftCardId, other.giftCardId)
            && Objects.equals(giftCardGan, other.giftCardGan)
            && Objects.equals(giftCardBalanceMoney, other.giftCardBalanceMoney)
            && Objects.equals(loadActivityDetails, other.loadActivityDetails)
            && Objects.equals(activateActivityDetails, other.activateActivityDetails)
            && Objects.equals(redeemActivityDetails, other.redeemActivityDetails)
            && Objects.equals(clearBalanceActivityDetails, other.clearBalanceActivityDetails)
            && Objects.equals(deactivateActivityDetails, other.deactivateActivityDetails)
            && Objects.equals(adjustIncrementActivityDetails,
                    other.adjustIncrementActivityDetails)
            && Objects.equals(adjustDecrementActivityDetails,
                    other.adjustDecrementActivityDetails)
            && Objects.equals(refundActivityDetails, other.refundActivityDetails)
            && Objects.equals(unlinkedActivityRefundActivityDetails,
                    other.unlinkedActivityRefundActivityDetails)
            && Objects.equals(importActivityDetails, other.importActivityDetails)
            && Objects.equals(blockActivityDetails, other.blockActivityDetails)
            && Objects.equals(unblockActivityDetails, other.unblockActivityDetails)
            && Objects.equals(importReversalActivityDetails, other.importReversalActivityDetails);
    }

    /**
     * Converts this GiftCardActivity into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivity [" + "type=" + type + ", locationId=" + locationId + ", id=" + id
                + ", createdAt=" + createdAt + ", giftCardId=" + giftCardId + ", giftCardGan="
                + giftCardGan + ", giftCardBalanceMoney=" + giftCardBalanceMoney
                + ", loadActivityDetails=" + loadActivityDetails + ", activateActivityDetails="
                + activateActivityDetails + ", redeemActivityDetails=" + redeemActivityDetails
                + ", clearBalanceActivityDetails=" + clearBalanceActivityDetails
                + ", deactivateActivityDetails=" + deactivateActivityDetails
                + ", adjustIncrementActivityDetails=" + adjustIncrementActivityDetails
                + ", adjustDecrementActivityDetails=" + adjustDecrementActivityDetails
                + ", refundActivityDetails=" + refundActivityDetails
                + ", unlinkedActivityRefundActivityDetails=" + unlinkedActivityRefundActivityDetails
                + ", importActivityDetails=" + importActivityDetails + ", blockActivityDetails="
                + blockActivityDetails + ", unblockActivityDetails=" + unblockActivityDetails
                + ", importReversalActivityDetails=" + importReversalActivityDetails + "]";
    }

    /**
     * Builds a new {@link GiftCardActivity.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivity.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type, locationId)
                .id(getId())
                .createdAt(getCreatedAt())
                .giftCardId(getGiftCardId())
                .giftCardGan(getGiftCardGan())
                .giftCardBalanceMoney(getGiftCardBalanceMoney())
                .loadActivityDetails(getLoadActivityDetails())
                .activateActivityDetails(getActivateActivityDetails())
                .redeemActivityDetails(getRedeemActivityDetails())
                .clearBalanceActivityDetails(getClearBalanceActivityDetails())
                .deactivateActivityDetails(getDeactivateActivityDetails())
                .adjustIncrementActivityDetails(getAdjustIncrementActivityDetails())
                .adjustDecrementActivityDetails(getAdjustDecrementActivityDetails())
                .refundActivityDetails(getRefundActivityDetails())
                .unlinkedActivityRefundActivityDetails(getUnlinkedActivityRefundActivityDetails())
                .importActivityDetails(getImportActivityDetails())
                .blockActivityDetails(getBlockActivityDetails())
                .unblockActivityDetails(getUnblockActivityDetails())
                .importReversalActivityDetails(getImportReversalActivityDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivity}.
     */
    public static class Builder {
        private String type;
        private String locationId;
        private String id;
        private String createdAt;
        private String giftCardId;
        private String giftCardGan;
        private Money giftCardBalanceMoney;
        private GiftCardActivityLoad loadActivityDetails;
        private GiftCardActivityActivate activateActivityDetails;
        private GiftCardActivityRedeem redeemActivityDetails;
        private GiftCardActivityClearBalance clearBalanceActivityDetails;
        private GiftCardActivityDeactivate deactivateActivityDetails;
        private GiftCardActivityAdjustIncrement adjustIncrementActivityDetails;
        private GiftCardActivityAdjustDecrement adjustDecrementActivityDetails;
        private GiftCardActivityRefund refundActivityDetails;
        private GiftCardActivityUnlinkedActivityRefund unlinkedActivityRefundActivityDetails;
        private GiftCardActivityImport importActivityDetails;
        private GiftCardActivityBlock blockActivityDetails;
        private GiftCardActivityUnblock unblockActivityDetails;
        private GiftCardActivityImportReversal importReversalActivityDetails;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         * @param  locationId  String value for locationId.
         */
        public Builder(String type, String locationId) {
            this.type = type;
            this.locationId = locationId;
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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
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
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for giftCardId.
         * @param  giftCardId  String value for giftCardId.
         * @return Builder
         */
        public Builder giftCardId(String giftCardId) {
            this.giftCardId = giftCardId;
            return this;
        }

        /**
         * Setter for giftCardGan.
         * @param  giftCardGan  String value for giftCardGan.
         * @return Builder
         */
        public Builder giftCardGan(String giftCardGan) {
            this.giftCardGan = giftCardGan;
            return this;
        }

        /**
         * Setter for giftCardBalanceMoney.
         * @param  giftCardBalanceMoney  Money value for giftCardBalanceMoney.
         * @return Builder
         */
        public Builder giftCardBalanceMoney(Money giftCardBalanceMoney) {
            this.giftCardBalanceMoney = giftCardBalanceMoney;
            return this;
        }

        /**
         * Setter for loadActivityDetails.
         * @param  loadActivityDetails  GiftCardActivityLoad value for loadActivityDetails.
         * @return Builder
         */
        public Builder loadActivityDetails(GiftCardActivityLoad loadActivityDetails) {
            this.loadActivityDetails = loadActivityDetails;
            return this;
        }

        /**
         * Setter for activateActivityDetails.
         * @param  activateActivityDetails  GiftCardActivityActivate value for
         *         activateActivityDetails.
         * @return Builder
         */
        public Builder activateActivityDetails(GiftCardActivityActivate activateActivityDetails) {
            this.activateActivityDetails = activateActivityDetails;
            return this;
        }

        /**
         * Setter for redeemActivityDetails.
         * @param  redeemActivityDetails  GiftCardActivityRedeem value for redeemActivityDetails.
         * @return Builder
         */
        public Builder redeemActivityDetails(GiftCardActivityRedeem redeemActivityDetails) {
            this.redeemActivityDetails = redeemActivityDetails;
            return this;
        }

        /**
         * Setter for clearBalanceActivityDetails.
         * @param  clearBalanceActivityDetails  GiftCardActivityClearBalance value for
         *         clearBalanceActivityDetails.
         * @return Builder
         */
        public Builder clearBalanceActivityDetails(
                GiftCardActivityClearBalance clearBalanceActivityDetails) {
            this.clearBalanceActivityDetails = clearBalanceActivityDetails;
            return this;
        }

        /**
         * Setter for deactivateActivityDetails.
         * @param  deactivateActivityDetails  GiftCardActivityDeactivate value for
         *         deactivateActivityDetails.
         * @return Builder
         */
        public Builder deactivateActivityDetails(
                GiftCardActivityDeactivate deactivateActivityDetails) {
            this.deactivateActivityDetails = deactivateActivityDetails;
            return this;
        }

        /**
         * Setter for adjustIncrementActivityDetails.
         * @param  adjustIncrementActivityDetails  GiftCardActivityAdjustIncrement value for
         *         adjustIncrementActivityDetails.
         * @return Builder
         */
        public Builder adjustIncrementActivityDetails(
                GiftCardActivityAdjustIncrement adjustIncrementActivityDetails) {
            this.adjustIncrementActivityDetails = adjustIncrementActivityDetails;
            return this;
        }

        /**
         * Setter for adjustDecrementActivityDetails.
         * @param  adjustDecrementActivityDetails  GiftCardActivityAdjustDecrement value for
         *         adjustDecrementActivityDetails.
         * @return Builder
         */
        public Builder adjustDecrementActivityDetails(
                GiftCardActivityAdjustDecrement adjustDecrementActivityDetails) {
            this.adjustDecrementActivityDetails = adjustDecrementActivityDetails;
            return this;
        }

        /**
         * Setter for refundActivityDetails.
         * @param  refundActivityDetails  GiftCardActivityRefund value for refundActivityDetails.
         * @return Builder
         */
        public Builder refundActivityDetails(GiftCardActivityRefund refundActivityDetails) {
            this.refundActivityDetails = refundActivityDetails;
            return this;
        }

        /**
         * Setter for unlinkedActivityRefundActivityDetails.
         * @param  unlinkedActivityRefundActivityDetails  GiftCardActivityUnlinkedActivityRefund
         *         value for unlinkedActivityRefundActivityDetails.
         * @return Builder
         */
        public Builder unlinkedActivityRefundActivityDetails(
                GiftCardActivityUnlinkedActivityRefund unlinkedActivityRefundActivityDetails) {
            this.unlinkedActivityRefundActivityDetails = unlinkedActivityRefundActivityDetails;
            return this;
        }

        /**
         * Setter for importActivityDetails.
         * @param  importActivityDetails  GiftCardActivityImport value for importActivityDetails.
         * @return Builder
         */
        public Builder importActivityDetails(GiftCardActivityImport importActivityDetails) {
            this.importActivityDetails = importActivityDetails;
            return this;
        }

        /**
         * Setter for blockActivityDetails.
         * @param  blockActivityDetails  GiftCardActivityBlock value for blockActivityDetails.
         * @return Builder
         */
        public Builder blockActivityDetails(GiftCardActivityBlock blockActivityDetails) {
            this.blockActivityDetails = blockActivityDetails;
            return this;
        }

        /**
         * Setter for unblockActivityDetails.
         * @param  unblockActivityDetails  GiftCardActivityUnblock value for unblockActivityDetails.
         * @return Builder
         */
        public Builder unblockActivityDetails(GiftCardActivityUnblock unblockActivityDetails) {
            this.unblockActivityDetails = unblockActivityDetails;
            return this;
        }

        /**
         * Setter for importReversalActivityDetails.
         * @param  importReversalActivityDetails  GiftCardActivityImportReversal value for
         *         importReversalActivityDetails.
         * @return Builder
         */
        public Builder importReversalActivityDetails(
                GiftCardActivityImportReversal importReversalActivityDetails) {
            this.importReversalActivityDetails = importReversalActivityDetails;
            return this;
        }

        /**
         * Builds a new {@link GiftCardActivity} object using the set fields.
         * @return {@link GiftCardActivity}
         */
        public GiftCardActivity build() {
            return new GiftCardActivity(type, locationId, id, createdAt, giftCardId, giftCardGan,
                    giftCardBalanceMoney, loadActivityDetails, activateActivityDetails,
                    redeemActivityDetails, clearBalanceActivityDetails, deactivateActivityDetails,
                    adjustIncrementActivityDetails, adjustDecrementActivityDetails,
                    refundActivityDetails, unlinkedActivityRefundActivityDetails,
                    importActivityDetails, blockActivityDetails, unblockActivityDetails,
                    importReversalActivityDetails);
        }
    }
}
