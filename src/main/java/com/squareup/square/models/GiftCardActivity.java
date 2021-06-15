
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    private final String type;
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String giftCardId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String giftCardGan;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money giftCardBalanceMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityLoad loadActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityActivate activateActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityRedeem redeemActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityClearBalance clearBalanceActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityDeactivate deactivateActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityAdjustIncrement adjustIncrementActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityAdjustDecrement adjustDecrementActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityRefund refundActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityUnlinkedActivityRefund unlinkedActivityRefundActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityImport importActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityBlock blockActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GiftCardActivityUnblock unblockActivityDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
     * The unique ID of the gift card activity.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for LocationId.
     * The ID of the location at which the activity occurred.
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
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for GiftCardId.
     * The gift card ID. The ID is not required if a GAN is present.
     * @return Returns the String
     */
    @JsonGetter("gift_card_id")
    public String getGiftCardId() {
        return giftCardId;
    }

    /**
     * Getter for GiftCardGan.
     * The gift card GAN. The GAN is not required if `gift_card_id` is present.
     * @return Returns the String
     */
    @JsonGetter("gift_card_gan")
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
    public Money getGiftCardBalanceMoney() {
        return giftCardBalanceMoney;
    }

    /**
     * Getter for LoadActivityDetails.
     * Present only when `GiftCardActivityType` is LOAD.
     * @return Returns the GiftCardActivityLoad
     */
    @JsonGetter("load_activity_details")
    public GiftCardActivityLoad getLoadActivityDetails() {
        return loadActivityDetails;
    }

    /**
     * Getter for ActivateActivityDetails.
     * Describes a gift card activity of the ACTIVATE type.
     * @return Returns the GiftCardActivityActivate
     */
    @JsonGetter("activate_activity_details")
    public GiftCardActivityActivate getActivateActivityDetails() {
        return activateActivityDetails;
    }

    /**
     * Getter for RedeemActivityDetails.
     * Present only when `GiftCardActivityType` is REDEEM.
     * @return Returns the GiftCardActivityRedeem
     */
    @JsonGetter("redeem_activity_details")
    public GiftCardActivityRedeem getRedeemActivityDetails() {
        return redeemActivityDetails;
    }

    /**
     * Getter for ClearBalanceActivityDetails.
     * Describes a gift card activity of the CLEAR_BALANCE type.
     * @return Returns the GiftCardActivityClearBalance
     */
    @JsonGetter("clear_balance_activity_details")
    public GiftCardActivityClearBalance getClearBalanceActivityDetails() {
        return clearBalanceActivityDetails;
    }

    /**
     * Getter for DeactivateActivityDetails.
     * Describes a gift card activity of the DEACTIVATE type.
     * @return Returns the GiftCardActivityDeactivate
     */
    @JsonGetter("deactivate_activity_details")
    public GiftCardActivityDeactivate getDeactivateActivityDetails() {
        return deactivateActivityDetails;
    }

    /**
     * Getter for AdjustIncrementActivityDetails.
     * Describes a gift card activity of the ADJUST_INCREMENT type.
     * @return Returns the GiftCardActivityAdjustIncrement
     */
    @JsonGetter("adjust_increment_activity_details")
    public GiftCardActivityAdjustIncrement getAdjustIncrementActivityDetails() {
        return adjustIncrementActivityDetails;
    }

    /**
     * Getter for AdjustDecrementActivityDetails.
     * Describes a gift card activity of the ADJUST_DECREMENT type.
     * @return Returns the GiftCardActivityAdjustDecrement
     */
    @JsonGetter("adjust_decrement_activity_details")
    public GiftCardActivityAdjustDecrement getAdjustDecrementActivityDetails() {
        return adjustDecrementActivityDetails;
    }

    /**
     * Getter for RefundActivityDetails.
     * Present only when `GiftCardActivityType` is REFUND.
     * @return Returns the GiftCardActivityRefund
     */
    @JsonGetter("refund_activity_details")
    public GiftCardActivityRefund getRefundActivityDetails() {
        return refundActivityDetails;
    }

    /**
     * Getter for UnlinkedActivityRefundActivityDetails.
     * Present only when `GiftCardActivityType` is UNLINKED_ACTIVITY_REFUND.
     * @return Returns the GiftCardActivityUnlinkedActivityRefund
     */
    @JsonGetter("unlinked_activity_refund_activity_details")
    public GiftCardActivityUnlinkedActivityRefund getUnlinkedActivityRefundActivityDetails() {
        return unlinkedActivityRefundActivityDetails;
    }

    /**
     * Getter for ImportActivityDetails.
     * Describes a gift card activity of the IMPORT type and the `GiftCardGANSource` is OTHER (a
     * third-party gift card).
     * @return Returns the GiftCardActivityImport
     */
    @JsonGetter("import_activity_details")
    public GiftCardActivityImport getImportActivityDetails() {
        return importActivityDetails;
    }

    /**
     * Getter for BlockActivityDetails.
     * Describes a gift card activity of the BLOCK type.
     * @return Returns the GiftCardActivityBlock
     */
    @JsonGetter("block_activity_details")
    public GiftCardActivityBlock getBlockActivityDetails() {
        return blockActivityDetails;
    }

    /**
     * Getter for UnblockActivityDetails.
     * Present only when `GiftCardActivityType` is UNBLOCK.
     * @return Returns the GiftCardActivityUnblock
     */
    @JsonGetter("unblock_activity_details")
    public GiftCardActivityUnblock getUnblockActivityDetails() {
        return unblockActivityDetails;
    }

    /**
     * Getter for ImportReversalActivityDetails.
     * Present only when GiftCardActivityType is IMPORT_REVERSAL and GiftCardGANSource is OTHER
     * @return Returns the GiftCardActivityImportReversal
     */
    @JsonGetter("import_reversal_activity_details")
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
