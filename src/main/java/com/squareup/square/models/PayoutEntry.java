
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for PayoutEntry type.
 */
public class PayoutEntry {
    private final String id;
    private final String payoutId;
    private final String effectiveAt;
    private final String type;
    private final Money grossAmountMoney;
    private final Money feeAmountMoney;
    private final Money netAmountMoney;
    private final PaymentBalanceActivityAutomaticSavingsDetail typeAutomaticSavingsDetails;
    private final PaymentBalanceActivityAutomaticSavingsReversedDetail typeAutomaticSavingsReversedDetails;
    private final PaymentBalanceActivityChargeDetail typeChargeDetails;
    private final PaymentBalanceActivityDepositFeeDetail typeDepositFeeDetails;
    private final PaymentBalanceActivityDisputeDetail typeDisputeDetails;
    private final PaymentBalanceActivityFeeDetail typeFeeDetails;
    private final PaymentBalanceActivityFreeProcessingDetail typeFreeProcessingDetails;
    private final PaymentBalanceActivityHoldAdjustmentDetail typeHoldAdjustmentDetails;
    private final PaymentBalanceActivityOpenDisputeDetail typeOpenDisputeDetails;
    private final PaymentBalanceActivityOtherDetail typeOtherDetails;
    private final PaymentBalanceActivityOtherAdjustmentDetail typeOtherAdjustmentDetails;
    private final PaymentBalanceActivityRefundDetail typeRefundDetails;
    private final PaymentBalanceActivityReleaseAdjustmentDetail typeReleaseAdjustmentDetails;
    private final PaymentBalanceActivityReserveHoldDetail typeReserveHoldDetails;
    private final PaymentBalanceActivityReserveReleaseDetail typeReserveReleaseDetails;
    private final PaymentBalanceActivitySquareCapitalPaymentDetail typeSquareCapitalPaymentDetails;
    private final PaymentBalanceActivitySquareCapitalReversedPaymentDetail typeSquareCapitalReversedPaymentDetails;
    private final PaymentBalanceActivityTaxOnFeeDetail typeTaxOnFeeDetails;
    private final PaymentBalanceActivityThirdPartyFeeDetail typeThirdPartyFeeDetails;
    private final PaymentBalanceActivityThirdPartyFeeRefundDetail typeThirdPartyFeeRefundDetails;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  payoutId  String value for payoutId.
     * @param  effectiveAt  String value for effectiveAt.
     * @param  type  String value for type.
     * @param  grossAmountMoney  Money value for grossAmountMoney.
     * @param  feeAmountMoney  Money value for feeAmountMoney.
     * @param  netAmountMoney  Money value for netAmountMoney.
     * @param  typeAutomaticSavingsDetails  PaymentBalanceActivityAutomaticSavingsDetail value for
     *         typeAutomaticSavingsDetails.
     * @param  typeAutomaticSavingsReversedDetails
     *         PaymentBalanceActivityAutomaticSavingsReversedDetail value for
     *         typeAutomaticSavingsReversedDetails.
     * @param  typeChargeDetails  PaymentBalanceActivityChargeDetail value for typeChargeDetails.
     * @param  typeDepositFeeDetails  PaymentBalanceActivityDepositFeeDetail value for
     *         typeDepositFeeDetails.
     * @param  typeDisputeDetails  PaymentBalanceActivityDisputeDetail value for typeDisputeDetails.
     * @param  typeFeeDetails  PaymentBalanceActivityFeeDetail value for typeFeeDetails.
     * @param  typeFreeProcessingDetails  PaymentBalanceActivityFreeProcessingDetail value for
     *         typeFreeProcessingDetails.
     * @param  typeHoldAdjustmentDetails  PaymentBalanceActivityHoldAdjustmentDetail value for
     *         typeHoldAdjustmentDetails.
     * @param  typeOpenDisputeDetails  PaymentBalanceActivityOpenDisputeDetail value for
     *         typeOpenDisputeDetails.
     * @param  typeOtherDetails  PaymentBalanceActivityOtherDetail value for typeOtherDetails.
     * @param  typeOtherAdjustmentDetails  PaymentBalanceActivityOtherAdjustmentDetail value for
     *         typeOtherAdjustmentDetails.
     * @param  typeRefundDetails  PaymentBalanceActivityRefundDetail value for typeRefundDetails.
     * @param  typeReleaseAdjustmentDetails  PaymentBalanceActivityReleaseAdjustmentDetail value for
     *         typeReleaseAdjustmentDetails.
     * @param  typeReserveHoldDetails  PaymentBalanceActivityReserveHoldDetail value for
     *         typeReserveHoldDetails.
     * @param  typeReserveReleaseDetails  PaymentBalanceActivityReserveReleaseDetail value for
     *         typeReserveReleaseDetails.
     * @param  typeSquareCapitalPaymentDetails  PaymentBalanceActivitySquareCapitalPaymentDetail
     *         value for typeSquareCapitalPaymentDetails.
     * @param  typeSquareCapitalReversedPaymentDetails
     *         PaymentBalanceActivitySquareCapitalReversedPaymentDetail value for
     *         typeSquareCapitalReversedPaymentDetails.
     * @param  typeTaxOnFeeDetails  PaymentBalanceActivityTaxOnFeeDetail value for
     *         typeTaxOnFeeDetails.
     * @param  typeThirdPartyFeeDetails  PaymentBalanceActivityThirdPartyFeeDetail value for
     *         typeThirdPartyFeeDetails.
     * @param  typeThirdPartyFeeRefundDetails  PaymentBalanceActivityThirdPartyFeeRefundDetail value
     *         for typeThirdPartyFeeRefundDetails.
     */
    @JsonCreator
    public PayoutEntry(
            @JsonProperty("id") String id,
            @JsonProperty("payout_id") String payoutId,
            @JsonProperty("effective_at") String effectiveAt,
            @JsonProperty("type") String type,
            @JsonProperty("gross_amount_money") Money grossAmountMoney,
            @JsonProperty("fee_amount_money") Money feeAmountMoney,
            @JsonProperty("net_amount_money") Money netAmountMoney,
            @JsonProperty("type_automatic_savings_details") PaymentBalanceActivityAutomaticSavingsDetail typeAutomaticSavingsDetails,
            @JsonProperty("type_automatic_savings_reversed_details") PaymentBalanceActivityAutomaticSavingsReversedDetail typeAutomaticSavingsReversedDetails,
            @JsonProperty("type_charge_details") PaymentBalanceActivityChargeDetail typeChargeDetails,
            @JsonProperty("type_deposit_fee_details") PaymentBalanceActivityDepositFeeDetail typeDepositFeeDetails,
            @JsonProperty("type_dispute_details") PaymentBalanceActivityDisputeDetail typeDisputeDetails,
            @JsonProperty("type_fee_details") PaymentBalanceActivityFeeDetail typeFeeDetails,
            @JsonProperty("type_free_processing_details") PaymentBalanceActivityFreeProcessingDetail typeFreeProcessingDetails,
            @JsonProperty("type_hold_adjustment_details") PaymentBalanceActivityHoldAdjustmentDetail typeHoldAdjustmentDetails,
            @JsonProperty("type_open_dispute_details") PaymentBalanceActivityOpenDisputeDetail typeOpenDisputeDetails,
            @JsonProperty("type_other_details") PaymentBalanceActivityOtherDetail typeOtherDetails,
            @JsonProperty("type_other_adjustment_details") PaymentBalanceActivityOtherAdjustmentDetail typeOtherAdjustmentDetails,
            @JsonProperty("type_refund_details") PaymentBalanceActivityRefundDetail typeRefundDetails,
            @JsonProperty("type_release_adjustment_details") PaymentBalanceActivityReleaseAdjustmentDetail typeReleaseAdjustmentDetails,
            @JsonProperty("type_reserve_hold_details") PaymentBalanceActivityReserveHoldDetail typeReserveHoldDetails,
            @JsonProperty("type_reserve_release_details") PaymentBalanceActivityReserveReleaseDetail typeReserveReleaseDetails,
            @JsonProperty("type_square_capital_payment_details") PaymentBalanceActivitySquareCapitalPaymentDetail typeSquareCapitalPaymentDetails,
            @JsonProperty("type_square_capital_reversed_payment_details") PaymentBalanceActivitySquareCapitalReversedPaymentDetail typeSquareCapitalReversedPaymentDetails,
            @JsonProperty("type_tax_on_fee_details") PaymentBalanceActivityTaxOnFeeDetail typeTaxOnFeeDetails,
            @JsonProperty("type_third_party_fee_details") PaymentBalanceActivityThirdPartyFeeDetail typeThirdPartyFeeDetails,
            @JsonProperty("type_third_party_fee_refund_details") PaymentBalanceActivityThirdPartyFeeRefundDetail typeThirdPartyFeeRefundDetails) {
        this.id = id;
        this.payoutId = payoutId;
        this.effectiveAt = effectiveAt;
        this.type = type;
        this.grossAmountMoney = grossAmountMoney;
        this.feeAmountMoney = feeAmountMoney;
        this.netAmountMoney = netAmountMoney;
        this.typeAutomaticSavingsDetails = typeAutomaticSavingsDetails;
        this.typeAutomaticSavingsReversedDetails = typeAutomaticSavingsReversedDetails;
        this.typeChargeDetails = typeChargeDetails;
        this.typeDepositFeeDetails = typeDepositFeeDetails;
        this.typeDisputeDetails = typeDisputeDetails;
        this.typeFeeDetails = typeFeeDetails;
        this.typeFreeProcessingDetails = typeFreeProcessingDetails;
        this.typeHoldAdjustmentDetails = typeHoldAdjustmentDetails;
        this.typeOpenDisputeDetails = typeOpenDisputeDetails;
        this.typeOtherDetails = typeOtherDetails;
        this.typeOtherAdjustmentDetails = typeOtherAdjustmentDetails;
        this.typeRefundDetails = typeRefundDetails;
        this.typeReleaseAdjustmentDetails = typeReleaseAdjustmentDetails;
        this.typeReserveHoldDetails = typeReserveHoldDetails;
        this.typeReserveReleaseDetails = typeReserveReleaseDetails;
        this.typeSquareCapitalPaymentDetails = typeSquareCapitalPaymentDetails;
        this.typeSquareCapitalReversedPaymentDetails = typeSquareCapitalReversedPaymentDetails;
        this.typeTaxOnFeeDetails = typeTaxOnFeeDetails;
        this.typeThirdPartyFeeDetails = typeThirdPartyFeeDetails;
        this.typeThirdPartyFeeRefundDetails = typeThirdPartyFeeRefundDetails;
    }

    /**
     * Getter for Id.
     * A unique ID for the payout entry.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for PayoutId.
     * The ID of the payout entries’ associated payout.
     * @return Returns the String
     */
    @JsonGetter("payout_id")
    public String getPayoutId() {
        return payoutId;
    }

    /**
     * Getter for EffectiveAt.
     * The timestamp of when the payout entry affected the balance, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("effective_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEffectiveAt() {
        return effectiveAt;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for GrossAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("gross_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getGrossAmountMoney() {
        return grossAmountMoney;
    }

    /**
     * Getter for FeeAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("fee_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getFeeAmountMoney() {
        return feeAmountMoney;
    }

    /**
     * Getter for NetAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("net_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getNetAmountMoney() {
        return netAmountMoney;
    }

    /**
     * Getter for TypeAutomaticSavingsDetails.
     * @return Returns the PaymentBalanceActivityAutomaticSavingsDetail
     */
    @JsonGetter("type_automatic_savings_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityAutomaticSavingsDetail getTypeAutomaticSavingsDetails() {
        return typeAutomaticSavingsDetails;
    }

    /**
     * Getter for TypeAutomaticSavingsReversedDetails.
     * @return Returns the PaymentBalanceActivityAutomaticSavingsReversedDetail
     */
    @JsonGetter("type_automatic_savings_reversed_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityAutomaticSavingsReversedDetail getTypeAutomaticSavingsReversedDetails() {
        return typeAutomaticSavingsReversedDetails;
    }

    /**
     * Getter for TypeChargeDetails.
     * DESCRIPTION OF PaymentBalanceActivityChargeDetail
     * @return Returns the PaymentBalanceActivityChargeDetail
     */
    @JsonGetter("type_charge_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityChargeDetail getTypeChargeDetails() {
        return typeChargeDetails;
    }

    /**
     * Getter for TypeDepositFeeDetails.
     * @return Returns the PaymentBalanceActivityDepositFeeDetail
     */
    @JsonGetter("type_deposit_fee_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityDepositFeeDetail getTypeDepositFeeDetails() {
        return typeDepositFeeDetails;
    }

    /**
     * Getter for TypeDisputeDetails.
     * @return Returns the PaymentBalanceActivityDisputeDetail
     */
    @JsonGetter("type_dispute_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityDisputeDetail getTypeDisputeDetails() {
        return typeDisputeDetails;
    }

    /**
     * Getter for TypeFeeDetails.
     * @return Returns the PaymentBalanceActivityFeeDetail
     */
    @JsonGetter("type_fee_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityFeeDetail getTypeFeeDetails() {
        return typeFeeDetails;
    }

    /**
     * Getter for TypeFreeProcessingDetails.
     * @return Returns the PaymentBalanceActivityFreeProcessingDetail
     */
    @JsonGetter("type_free_processing_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityFreeProcessingDetail getTypeFreeProcessingDetails() {
        return typeFreeProcessingDetails;
    }

    /**
     * Getter for TypeHoldAdjustmentDetails.
     * @return Returns the PaymentBalanceActivityHoldAdjustmentDetail
     */
    @JsonGetter("type_hold_adjustment_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityHoldAdjustmentDetail getTypeHoldAdjustmentDetails() {
        return typeHoldAdjustmentDetails;
    }

    /**
     * Getter for TypeOpenDisputeDetails.
     * @return Returns the PaymentBalanceActivityOpenDisputeDetail
     */
    @JsonGetter("type_open_dispute_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityOpenDisputeDetail getTypeOpenDisputeDetails() {
        return typeOpenDisputeDetails;
    }

    /**
     * Getter for TypeOtherDetails.
     * @return Returns the PaymentBalanceActivityOtherDetail
     */
    @JsonGetter("type_other_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityOtherDetail getTypeOtherDetails() {
        return typeOtherDetails;
    }

    /**
     * Getter for TypeOtherAdjustmentDetails.
     * @return Returns the PaymentBalanceActivityOtherAdjustmentDetail
     */
    @JsonGetter("type_other_adjustment_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityOtherAdjustmentDetail getTypeOtherAdjustmentDetails() {
        return typeOtherAdjustmentDetails;
    }

    /**
     * Getter for TypeRefundDetails.
     * @return Returns the PaymentBalanceActivityRefundDetail
     */
    @JsonGetter("type_refund_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityRefundDetail getTypeRefundDetails() {
        return typeRefundDetails;
    }

    /**
     * Getter for TypeReleaseAdjustmentDetails.
     * @return Returns the PaymentBalanceActivityReleaseAdjustmentDetail
     */
    @JsonGetter("type_release_adjustment_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityReleaseAdjustmentDetail getTypeReleaseAdjustmentDetails() {
        return typeReleaseAdjustmentDetails;
    }

    /**
     * Getter for TypeReserveHoldDetails.
     * @return Returns the PaymentBalanceActivityReserveHoldDetail
     */
    @JsonGetter("type_reserve_hold_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityReserveHoldDetail getTypeReserveHoldDetails() {
        return typeReserveHoldDetails;
    }

    /**
     * Getter for TypeReserveReleaseDetails.
     * @return Returns the PaymentBalanceActivityReserveReleaseDetail
     */
    @JsonGetter("type_reserve_release_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityReserveReleaseDetail getTypeReserveReleaseDetails() {
        return typeReserveReleaseDetails;
    }

    /**
     * Getter for TypeSquareCapitalPaymentDetails.
     * @return Returns the PaymentBalanceActivitySquareCapitalPaymentDetail
     */
    @JsonGetter("type_square_capital_payment_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivitySquareCapitalPaymentDetail getTypeSquareCapitalPaymentDetails() {
        return typeSquareCapitalPaymentDetails;
    }

    /**
     * Getter for TypeSquareCapitalReversedPaymentDetails.
     * @return Returns the PaymentBalanceActivitySquareCapitalReversedPaymentDetail
     */
    @JsonGetter("type_square_capital_reversed_payment_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivitySquareCapitalReversedPaymentDetail getTypeSquareCapitalReversedPaymentDetails() {
        return typeSquareCapitalReversedPaymentDetails;
    }

    /**
     * Getter for TypeTaxOnFeeDetails.
     * @return Returns the PaymentBalanceActivityTaxOnFeeDetail
     */
    @JsonGetter("type_tax_on_fee_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityTaxOnFeeDetail getTypeTaxOnFeeDetails() {
        return typeTaxOnFeeDetails;
    }

    /**
     * Getter for TypeThirdPartyFeeDetails.
     * @return Returns the PaymentBalanceActivityThirdPartyFeeDetail
     */
    @JsonGetter("type_third_party_fee_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityThirdPartyFeeDetail getTypeThirdPartyFeeDetails() {
        return typeThirdPartyFeeDetails;
    }

    /**
     * Getter for TypeThirdPartyFeeRefundDetails.
     * @return Returns the PaymentBalanceActivityThirdPartyFeeRefundDetail
     */
    @JsonGetter("type_third_party_fee_refund_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentBalanceActivityThirdPartyFeeRefundDetail getTypeThirdPartyFeeRefundDetails() {
        return typeThirdPartyFeeRefundDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payoutId, effectiveAt, type, grossAmountMoney, feeAmountMoney,
                netAmountMoney, typeAutomaticSavingsDetails, typeAutomaticSavingsReversedDetails,
                typeChargeDetails, typeDepositFeeDetails, typeDisputeDetails, typeFeeDetails,
                typeFreeProcessingDetails, typeHoldAdjustmentDetails, typeOpenDisputeDetails,
                typeOtherDetails, typeOtherAdjustmentDetails, typeRefundDetails,
                typeReleaseAdjustmentDetails, typeReserveHoldDetails, typeReserveReleaseDetails,
                typeSquareCapitalPaymentDetails, typeSquareCapitalReversedPaymentDetails,
                typeTaxOnFeeDetails, typeThirdPartyFeeDetails, typeThirdPartyFeeRefundDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayoutEntry)) {
            return false;
        }
        PayoutEntry other = (PayoutEntry) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(payoutId, other.payoutId)
            && Objects.equals(effectiveAt, other.effectiveAt)
            && Objects.equals(type, other.type)
            && Objects.equals(grossAmountMoney, other.grossAmountMoney)
            && Objects.equals(feeAmountMoney, other.feeAmountMoney)
            && Objects.equals(netAmountMoney, other.netAmountMoney)
            && Objects.equals(typeAutomaticSavingsDetails, other.typeAutomaticSavingsDetails)
            && Objects.equals(typeAutomaticSavingsReversedDetails,
                    other.typeAutomaticSavingsReversedDetails)
            && Objects.equals(typeChargeDetails, other.typeChargeDetails)
            && Objects.equals(typeDepositFeeDetails, other.typeDepositFeeDetails)
            && Objects.equals(typeDisputeDetails, other.typeDisputeDetails)
            && Objects.equals(typeFeeDetails, other.typeFeeDetails)
            && Objects.equals(typeFreeProcessingDetails, other.typeFreeProcessingDetails)
            && Objects.equals(typeHoldAdjustmentDetails, other.typeHoldAdjustmentDetails)
            && Objects.equals(typeOpenDisputeDetails, other.typeOpenDisputeDetails)
            && Objects.equals(typeOtherDetails, other.typeOtherDetails)
            && Objects.equals(typeOtherAdjustmentDetails, other.typeOtherAdjustmentDetails)
            && Objects.equals(typeRefundDetails, other.typeRefundDetails)
            && Objects.equals(typeReleaseAdjustmentDetails, other.typeReleaseAdjustmentDetails)
            && Objects.equals(typeReserveHoldDetails, other.typeReserveHoldDetails)
            && Objects.equals(typeReserveReleaseDetails, other.typeReserveReleaseDetails)
            && Objects.equals(typeSquareCapitalPaymentDetails,
                    other.typeSquareCapitalPaymentDetails)
            && Objects.equals(typeSquareCapitalReversedPaymentDetails,
                    other.typeSquareCapitalReversedPaymentDetails)
            && Objects.equals(typeTaxOnFeeDetails, other.typeTaxOnFeeDetails)
            && Objects.equals(typeThirdPartyFeeDetails, other.typeThirdPartyFeeDetails)
            && Objects.equals(typeThirdPartyFeeRefundDetails,
                    other.typeThirdPartyFeeRefundDetails);
    }

    /**
     * Converts this PayoutEntry into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PayoutEntry [" + "id=" + id + ", payoutId=" + payoutId + ", effectiveAt="
                + effectiveAt + ", type=" + type + ", grossAmountMoney=" + grossAmountMoney
                + ", feeAmountMoney=" + feeAmountMoney + ", netAmountMoney=" + netAmountMoney
                + ", typeAutomaticSavingsDetails=" + typeAutomaticSavingsDetails
                + ", typeAutomaticSavingsReversedDetails=" + typeAutomaticSavingsReversedDetails
                + ", typeChargeDetails=" + typeChargeDetails + ", typeDepositFeeDetails="
                + typeDepositFeeDetails + ", typeDisputeDetails=" + typeDisputeDetails
                + ", typeFeeDetails=" + typeFeeDetails + ", typeFreeProcessingDetails="
                + typeFreeProcessingDetails + ", typeHoldAdjustmentDetails="
                + typeHoldAdjustmentDetails + ", typeOpenDisputeDetails=" + typeOpenDisputeDetails
                + ", typeOtherDetails=" + typeOtherDetails + ", typeOtherAdjustmentDetails="
                + typeOtherAdjustmentDetails + ", typeRefundDetails=" + typeRefundDetails
                + ", typeReleaseAdjustmentDetails=" + typeReleaseAdjustmentDetails
                + ", typeReserveHoldDetails=" + typeReserveHoldDetails
                + ", typeReserveReleaseDetails=" + typeReserveReleaseDetails
                + ", typeSquareCapitalPaymentDetails=" + typeSquareCapitalPaymentDetails
                + ", typeSquareCapitalReversedPaymentDetails="
                + typeSquareCapitalReversedPaymentDetails + ", typeTaxOnFeeDetails="
                + typeTaxOnFeeDetails + ", typeThirdPartyFeeDetails=" + typeThirdPartyFeeDetails
                + ", typeThirdPartyFeeRefundDetails=" + typeThirdPartyFeeRefundDetails + "]";
    }

    /**
     * Builds a new {@link PayoutEntry.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PayoutEntry.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, payoutId)
                .effectiveAt(getEffectiveAt())
                .type(getType())
                .grossAmountMoney(getGrossAmountMoney())
                .feeAmountMoney(getFeeAmountMoney())
                .netAmountMoney(getNetAmountMoney())
                .typeAutomaticSavingsDetails(getTypeAutomaticSavingsDetails())
                .typeAutomaticSavingsReversedDetails(getTypeAutomaticSavingsReversedDetails())
                .typeChargeDetails(getTypeChargeDetails())
                .typeDepositFeeDetails(getTypeDepositFeeDetails())
                .typeDisputeDetails(getTypeDisputeDetails())
                .typeFeeDetails(getTypeFeeDetails())
                .typeFreeProcessingDetails(getTypeFreeProcessingDetails())
                .typeHoldAdjustmentDetails(getTypeHoldAdjustmentDetails())
                .typeOpenDisputeDetails(getTypeOpenDisputeDetails())
                .typeOtherDetails(getTypeOtherDetails())
                .typeOtherAdjustmentDetails(getTypeOtherAdjustmentDetails())
                .typeRefundDetails(getTypeRefundDetails())
                .typeReleaseAdjustmentDetails(getTypeReleaseAdjustmentDetails())
                .typeReserveHoldDetails(getTypeReserveHoldDetails())
                .typeReserveReleaseDetails(getTypeReserveReleaseDetails())
                .typeSquareCapitalPaymentDetails(getTypeSquareCapitalPaymentDetails())
                .typeSquareCapitalReversedPaymentDetails(getTypeSquareCapitalReversedPaymentDetails())
                .typeTaxOnFeeDetails(getTypeTaxOnFeeDetails())
                .typeThirdPartyFeeDetails(getTypeThirdPartyFeeDetails())
                .typeThirdPartyFeeRefundDetails(getTypeThirdPartyFeeRefundDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link PayoutEntry}.
     */
    public static class Builder {
        private String id;
        private String payoutId;
        private String effectiveAt;
        private String type;
        private Money grossAmountMoney;
        private Money feeAmountMoney;
        private Money netAmountMoney;
        private PaymentBalanceActivityAutomaticSavingsDetail typeAutomaticSavingsDetails;
        private PaymentBalanceActivityAutomaticSavingsReversedDetail typeAutomaticSavingsReversedDetails;
        private PaymentBalanceActivityChargeDetail typeChargeDetails;
        private PaymentBalanceActivityDepositFeeDetail typeDepositFeeDetails;
        private PaymentBalanceActivityDisputeDetail typeDisputeDetails;
        private PaymentBalanceActivityFeeDetail typeFeeDetails;
        private PaymentBalanceActivityFreeProcessingDetail typeFreeProcessingDetails;
        private PaymentBalanceActivityHoldAdjustmentDetail typeHoldAdjustmentDetails;
        private PaymentBalanceActivityOpenDisputeDetail typeOpenDisputeDetails;
        private PaymentBalanceActivityOtherDetail typeOtherDetails;
        private PaymentBalanceActivityOtherAdjustmentDetail typeOtherAdjustmentDetails;
        private PaymentBalanceActivityRefundDetail typeRefundDetails;
        private PaymentBalanceActivityReleaseAdjustmentDetail typeReleaseAdjustmentDetails;
        private PaymentBalanceActivityReserveHoldDetail typeReserveHoldDetails;
        private PaymentBalanceActivityReserveReleaseDetail typeReserveReleaseDetails;
        private PaymentBalanceActivitySquareCapitalPaymentDetail typeSquareCapitalPaymentDetails;
        private PaymentBalanceActivitySquareCapitalReversedPaymentDetail typeSquareCapitalReversedPaymentDetails;
        private PaymentBalanceActivityTaxOnFeeDetail typeTaxOnFeeDetails;
        private PaymentBalanceActivityThirdPartyFeeDetail typeThirdPartyFeeDetails;
        private PaymentBalanceActivityThirdPartyFeeRefundDetail typeThirdPartyFeeRefundDetails;

        /**
         * Initialization constructor.
         * @param  id  String value for id.
         * @param  payoutId  String value for payoutId.
         */
        public Builder(String id, String payoutId) {
            this.id = id;
            this.payoutId = payoutId;
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
         * Setter for payoutId.
         * @param  payoutId  String value for payoutId.
         * @return Builder
         */
        public Builder payoutId(String payoutId) {
            this.payoutId = payoutId;
            return this;
        }

        /**
         * Setter for effectiveAt.
         * @param  effectiveAt  String value for effectiveAt.
         * @return Builder
         */
        public Builder effectiveAt(String effectiveAt) {
            this.effectiveAt = effectiveAt;
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
         * Setter for grossAmountMoney.
         * @param  grossAmountMoney  Money value for grossAmountMoney.
         * @return Builder
         */
        public Builder grossAmountMoney(Money grossAmountMoney) {
            this.grossAmountMoney = grossAmountMoney;
            return this;
        }

        /**
         * Setter for feeAmountMoney.
         * @param  feeAmountMoney  Money value for feeAmountMoney.
         * @return Builder
         */
        public Builder feeAmountMoney(Money feeAmountMoney) {
            this.feeAmountMoney = feeAmountMoney;
            return this;
        }

        /**
         * Setter for netAmountMoney.
         * @param  netAmountMoney  Money value for netAmountMoney.
         * @return Builder
         */
        public Builder netAmountMoney(Money netAmountMoney) {
            this.netAmountMoney = netAmountMoney;
            return this;
        }

        /**
         * Setter for typeAutomaticSavingsDetails.
         * @param  typeAutomaticSavingsDetails  PaymentBalanceActivityAutomaticSavingsDetail value
         *         for typeAutomaticSavingsDetails.
         * @return Builder
         */
        public Builder typeAutomaticSavingsDetails(
                PaymentBalanceActivityAutomaticSavingsDetail typeAutomaticSavingsDetails) {
            this.typeAutomaticSavingsDetails = typeAutomaticSavingsDetails;
            return this;
        }

        /**
         * Setter for typeAutomaticSavingsReversedDetails.
         * @param  typeAutomaticSavingsReversedDetails
         *         PaymentBalanceActivityAutomaticSavingsReversedDetail value for
         *         typeAutomaticSavingsReversedDetails.
         * @return Builder
         */
        public Builder typeAutomaticSavingsReversedDetails(
                PaymentBalanceActivityAutomaticSavingsReversedDetail typeAutomaticSavingsReversedDetails) {
            this.typeAutomaticSavingsReversedDetails = typeAutomaticSavingsReversedDetails;
            return this;
        }

        /**
         * Setter for typeChargeDetails.
         * @param  typeChargeDetails  PaymentBalanceActivityChargeDetail value for
         *         typeChargeDetails.
         * @return Builder
         */
        public Builder typeChargeDetails(PaymentBalanceActivityChargeDetail typeChargeDetails) {
            this.typeChargeDetails = typeChargeDetails;
            return this;
        }

        /**
         * Setter for typeDepositFeeDetails.
         * @param  typeDepositFeeDetails  PaymentBalanceActivityDepositFeeDetail value for
         *         typeDepositFeeDetails.
         * @return Builder
         */
        public Builder typeDepositFeeDetails(
                PaymentBalanceActivityDepositFeeDetail typeDepositFeeDetails) {
            this.typeDepositFeeDetails = typeDepositFeeDetails;
            return this;
        }

        /**
         * Setter for typeDisputeDetails.
         * @param  typeDisputeDetails  PaymentBalanceActivityDisputeDetail value for
         *         typeDisputeDetails.
         * @return Builder
         */
        public Builder typeDisputeDetails(
                PaymentBalanceActivityDisputeDetail typeDisputeDetails) {
            this.typeDisputeDetails = typeDisputeDetails;
            return this;
        }

        /**
         * Setter for typeFeeDetails.
         * @param  typeFeeDetails  PaymentBalanceActivityFeeDetail value for typeFeeDetails.
         * @return Builder
         */
        public Builder typeFeeDetails(PaymentBalanceActivityFeeDetail typeFeeDetails) {
            this.typeFeeDetails = typeFeeDetails;
            return this;
        }

        /**
         * Setter for typeFreeProcessingDetails.
         * @param  typeFreeProcessingDetails  PaymentBalanceActivityFreeProcessingDetail value for
         *         typeFreeProcessingDetails.
         * @return Builder
         */
        public Builder typeFreeProcessingDetails(
                PaymentBalanceActivityFreeProcessingDetail typeFreeProcessingDetails) {
            this.typeFreeProcessingDetails = typeFreeProcessingDetails;
            return this;
        }

        /**
         * Setter for typeHoldAdjustmentDetails.
         * @param  typeHoldAdjustmentDetails  PaymentBalanceActivityHoldAdjustmentDetail value for
         *         typeHoldAdjustmentDetails.
         * @return Builder
         */
        public Builder typeHoldAdjustmentDetails(
                PaymentBalanceActivityHoldAdjustmentDetail typeHoldAdjustmentDetails) {
            this.typeHoldAdjustmentDetails = typeHoldAdjustmentDetails;
            return this;
        }

        /**
         * Setter for typeOpenDisputeDetails.
         * @param  typeOpenDisputeDetails  PaymentBalanceActivityOpenDisputeDetail value for
         *         typeOpenDisputeDetails.
         * @return Builder
         */
        public Builder typeOpenDisputeDetails(
                PaymentBalanceActivityOpenDisputeDetail typeOpenDisputeDetails) {
            this.typeOpenDisputeDetails = typeOpenDisputeDetails;
            return this;
        }

        /**
         * Setter for typeOtherDetails.
         * @param  typeOtherDetails  PaymentBalanceActivityOtherDetail value for typeOtherDetails.
         * @return Builder
         */
        public Builder typeOtherDetails(PaymentBalanceActivityOtherDetail typeOtherDetails) {
            this.typeOtherDetails = typeOtherDetails;
            return this;
        }

        /**
         * Setter for typeOtherAdjustmentDetails.
         * @param  typeOtherAdjustmentDetails  PaymentBalanceActivityOtherAdjustmentDetail value for
         *         typeOtherAdjustmentDetails.
         * @return Builder
         */
        public Builder typeOtherAdjustmentDetails(
                PaymentBalanceActivityOtherAdjustmentDetail typeOtherAdjustmentDetails) {
            this.typeOtherAdjustmentDetails = typeOtherAdjustmentDetails;
            return this;
        }

        /**
         * Setter for typeRefundDetails.
         * @param  typeRefundDetails  PaymentBalanceActivityRefundDetail value for
         *         typeRefundDetails.
         * @return Builder
         */
        public Builder typeRefundDetails(PaymentBalanceActivityRefundDetail typeRefundDetails) {
            this.typeRefundDetails = typeRefundDetails;
            return this;
        }

        /**
         * Setter for typeReleaseAdjustmentDetails.
         * @param  typeReleaseAdjustmentDetails  PaymentBalanceActivityReleaseAdjustmentDetail value
         *         for typeReleaseAdjustmentDetails.
         * @return Builder
         */
        public Builder typeReleaseAdjustmentDetails(
                PaymentBalanceActivityReleaseAdjustmentDetail typeReleaseAdjustmentDetails) {
            this.typeReleaseAdjustmentDetails = typeReleaseAdjustmentDetails;
            return this;
        }

        /**
         * Setter for typeReserveHoldDetails.
         * @param  typeReserveHoldDetails  PaymentBalanceActivityReserveHoldDetail value for
         *         typeReserveHoldDetails.
         * @return Builder
         */
        public Builder typeReserveHoldDetails(
                PaymentBalanceActivityReserveHoldDetail typeReserveHoldDetails) {
            this.typeReserveHoldDetails = typeReserveHoldDetails;
            return this;
        }

        /**
         * Setter for typeReserveReleaseDetails.
         * @param  typeReserveReleaseDetails  PaymentBalanceActivityReserveReleaseDetail value for
         *         typeReserveReleaseDetails.
         * @return Builder
         */
        public Builder typeReserveReleaseDetails(
                PaymentBalanceActivityReserveReleaseDetail typeReserveReleaseDetails) {
            this.typeReserveReleaseDetails = typeReserveReleaseDetails;
            return this;
        }

        /**
         * Setter for typeSquareCapitalPaymentDetails.
         * @param  typeSquareCapitalPaymentDetails  PaymentBalanceActivitySquareCapitalPaymentDetail
         *         value for typeSquareCapitalPaymentDetails.
         * @return Builder
         */
        public Builder typeSquareCapitalPaymentDetails(
                PaymentBalanceActivitySquareCapitalPaymentDetail typeSquareCapitalPaymentDetails) {
            this.typeSquareCapitalPaymentDetails = typeSquareCapitalPaymentDetails;
            return this;
        }

        /**
         * Setter for typeSquareCapitalReversedPaymentDetails.
         * @param  typeSquareCapitalReversedPaymentDetails
         *         PaymentBalanceActivitySquareCapitalReversedPaymentDetail value for
         *         typeSquareCapitalReversedPaymentDetails.
         * @return Builder
         */
        public Builder typeSquareCapitalReversedPaymentDetails(
                PaymentBalanceActivitySquareCapitalReversedPaymentDetail typeSquareCapitalReversedPaymentDetails) {
            this.typeSquareCapitalReversedPaymentDetails = typeSquareCapitalReversedPaymentDetails;
            return this;
        }

        /**
         * Setter for typeTaxOnFeeDetails.
         * @param  typeTaxOnFeeDetails  PaymentBalanceActivityTaxOnFeeDetail value for
         *         typeTaxOnFeeDetails.
         * @return Builder
         */
        public Builder typeTaxOnFeeDetails(
                PaymentBalanceActivityTaxOnFeeDetail typeTaxOnFeeDetails) {
            this.typeTaxOnFeeDetails = typeTaxOnFeeDetails;
            return this;
        }

        /**
         * Setter for typeThirdPartyFeeDetails.
         * @param  typeThirdPartyFeeDetails  PaymentBalanceActivityThirdPartyFeeDetail value for
         *         typeThirdPartyFeeDetails.
         * @return Builder
         */
        public Builder typeThirdPartyFeeDetails(
                PaymentBalanceActivityThirdPartyFeeDetail typeThirdPartyFeeDetails) {
            this.typeThirdPartyFeeDetails = typeThirdPartyFeeDetails;
            return this;
        }

        /**
         * Setter for typeThirdPartyFeeRefundDetails.
         * @param  typeThirdPartyFeeRefundDetails  PaymentBalanceActivityThirdPartyFeeRefundDetail
         *         value for typeThirdPartyFeeRefundDetails.
         * @return Builder
         */
        public Builder typeThirdPartyFeeRefundDetails(
                PaymentBalanceActivityThirdPartyFeeRefundDetail typeThirdPartyFeeRefundDetails) {
            this.typeThirdPartyFeeRefundDetails = typeThirdPartyFeeRefundDetails;
            return this;
        }

        /**
         * Builds a new {@link PayoutEntry} object using the set fields.
         * @return {@link PayoutEntry}
         */
        public PayoutEntry build() {
            return new PayoutEntry(id, payoutId, effectiveAt, type, grossAmountMoney,
                    feeAmountMoney, netAmountMoney, typeAutomaticSavingsDetails,
                    typeAutomaticSavingsReversedDetails, typeChargeDetails, typeDepositFeeDetails,
                    typeDisputeDetails, typeFeeDetails, typeFreeProcessingDetails,
                    typeHoldAdjustmentDetails, typeOpenDisputeDetails, typeOtherDetails,
                    typeOtherAdjustmentDetails, typeRefundDetails, typeReleaseAdjustmentDetails,
                    typeReserveHoldDetails, typeReserveReleaseDetails,
                    typeSquareCapitalPaymentDetails, typeSquareCapitalReversedPaymentDetails,
                    typeTaxOnFeeDetails, typeThirdPartyFeeDetails, typeThirdPartyFeeRefundDetails);
        }
    }
}
