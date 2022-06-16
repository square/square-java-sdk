
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Payment type.
 */
public class Payment {
    private final String id;
    private final String createdAt;
    private final String updatedAt;
    private final Money amountMoney;
    private final Money tipMoney;
    private final Money totalMoney;
    private final Money appFeeMoney;
    private final Money approvedMoney;
    private final List<ProcessingFee> processingFee;
    private final Money refundedMoney;
    private final String status;
    private final String delayDuration;
    private final String delayAction;
    private final String delayedUntil;
    private final String sourceType;
    private final CardPaymentDetails cardDetails;
    private final CashPaymentDetails cashDetails;
    private final BankAccountPaymentDetails bankAccountDetails;
    private final ExternalPaymentDetails externalDetails;
    private final DigitalWalletDetails walletDetails;
    private final BuyNowPayLaterDetails buyNowPayLaterDetails;
    private final String locationId;
    private final String orderId;
    private final String referenceId;
    private final String customerId;
    private final String employeeId;
    private final String teamMemberId;
    private final List<String> refundIds;
    private final RiskEvaluation riskEvaluation;
    private final String buyerEmailAddress;
    private final Address billingAddress;
    private final Address shippingAddress;
    private final String note;
    private final String statementDescriptionIdentifier;
    private final List<String> capabilities;
    private final String receiptNumber;
    private final String receiptUrl;
    private final DeviceDetails deviceDetails;
    private final ApplicationDetails applicationDetails;
    private final String versionToken;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  amountMoney  Money value for amountMoney.
     * @param  tipMoney  Money value for tipMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  approvedMoney  Money value for approvedMoney.
     * @param  processingFee  List of ProcessingFee value for processingFee.
     * @param  refundedMoney  Money value for refundedMoney.
     * @param  status  String value for status.
     * @param  delayDuration  String value for delayDuration.
     * @param  delayAction  String value for delayAction.
     * @param  delayedUntil  String value for delayedUntil.
     * @param  sourceType  String value for sourceType.
     * @param  cardDetails  CardPaymentDetails value for cardDetails.
     * @param  cashDetails  CashPaymentDetails value for cashDetails.
     * @param  bankAccountDetails  BankAccountPaymentDetails value for bankAccountDetails.
     * @param  externalDetails  ExternalPaymentDetails value for externalDetails.
     * @param  walletDetails  DigitalWalletDetails value for walletDetails.
     * @param  buyNowPayLaterDetails  BuyNowPayLaterDetails value for buyNowPayLaterDetails.
     * @param  locationId  String value for locationId.
     * @param  orderId  String value for orderId.
     * @param  referenceId  String value for referenceId.
     * @param  customerId  String value for customerId.
     * @param  employeeId  String value for employeeId.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  refundIds  List of String value for refundIds.
     * @param  riskEvaluation  RiskEvaluation value for riskEvaluation.
     * @param  buyerEmailAddress  String value for buyerEmailAddress.
     * @param  billingAddress  Address value for billingAddress.
     * @param  shippingAddress  Address value for shippingAddress.
     * @param  note  String value for note.
     * @param  statementDescriptionIdentifier  String value for statementDescriptionIdentifier.
     * @param  capabilities  List of String value for capabilities.
     * @param  receiptNumber  String value for receiptNumber.
     * @param  receiptUrl  String value for receiptUrl.
     * @param  deviceDetails  DeviceDetails value for deviceDetails.
     * @param  applicationDetails  ApplicationDetails value for applicationDetails.
     * @param  versionToken  String value for versionToken.
     */
    @JsonCreator
    public Payment(
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("tip_money") Money tipMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("approved_money") Money approvedMoney,
            @JsonProperty("processing_fee") List<ProcessingFee> processingFee,
            @JsonProperty("refunded_money") Money refundedMoney,
            @JsonProperty("status") String status,
            @JsonProperty("delay_duration") String delayDuration,
            @JsonProperty("delay_action") String delayAction,
            @JsonProperty("delayed_until") String delayedUntil,
            @JsonProperty("source_type") String sourceType,
            @JsonProperty("card_details") CardPaymentDetails cardDetails,
            @JsonProperty("cash_details") CashPaymentDetails cashDetails,
            @JsonProperty("bank_account_details") BankAccountPaymentDetails bankAccountDetails,
            @JsonProperty("external_details") ExternalPaymentDetails externalDetails,
            @JsonProperty("wallet_details") DigitalWalletDetails walletDetails,
            @JsonProperty("buy_now_pay_later_details") BuyNowPayLaterDetails buyNowPayLaterDetails,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("refund_ids") List<String> refundIds,
            @JsonProperty("risk_evaluation") RiskEvaluation riskEvaluation,
            @JsonProperty("buyer_email_address") String buyerEmailAddress,
            @JsonProperty("billing_address") Address billingAddress,
            @JsonProperty("shipping_address") Address shippingAddress,
            @JsonProperty("note") String note,
            @JsonProperty("statement_description_identifier") String statementDescriptionIdentifier,
            @JsonProperty("capabilities") List<String> capabilities,
            @JsonProperty("receipt_number") String receiptNumber,
            @JsonProperty("receipt_url") String receiptUrl,
            @JsonProperty("device_details") DeviceDetails deviceDetails,
            @JsonProperty("application_details") ApplicationDetails applicationDetails,
            @JsonProperty("version_token") String versionToken) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.amountMoney = amountMoney;
        this.tipMoney = tipMoney;
        this.totalMoney = totalMoney;
        this.appFeeMoney = appFeeMoney;
        this.approvedMoney = approvedMoney;
        this.processingFee = processingFee;
        this.refundedMoney = refundedMoney;
        this.status = status;
        this.delayDuration = delayDuration;
        this.delayAction = delayAction;
        this.delayedUntil = delayedUntil;
        this.sourceType = sourceType;
        this.cardDetails = cardDetails;
        this.cashDetails = cashDetails;
        this.bankAccountDetails = bankAccountDetails;
        this.externalDetails = externalDetails;
        this.walletDetails = walletDetails;
        this.buyNowPayLaterDetails = buyNowPayLaterDetails;
        this.locationId = locationId;
        this.orderId = orderId;
        this.referenceId = referenceId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.teamMemberId = teamMemberId;
        this.refundIds = refundIds;
        this.riskEvaluation = riskEvaluation;
        this.buyerEmailAddress = buyerEmailAddress;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.note = note;
        this.statementDescriptionIdentifier = statementDescriptionIdentifier;
        this.capabilities = capabilities;
        this.receiptNumber = receiptNumber;
        this.receiptUrl = receiptUrl;
        this.deviceDetails = deviceDetails;
        this.applicationDetails = applicationDetails;
        this.versionToken = versionToken;
    }

    /**
     * Getter for Id.
     * A unique ID for the payment.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp of when the payment was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp of when the payment was last updated, in RFC 3339 format.
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
     * Getter for TipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("tip_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTipMoney() {
        return tipMoney;
    }

    /**
     * Getter for TotalMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTotalMoney() {
        return totalMoney;
    }

    /**
     * Getter for AppFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("app_fee_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAppFeeMoney() {
        return appFeeMoney;
    }

    /**
     * Getter for ApprovedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("approved_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getApprovedMoney() {
        return approvedMoney;
    }

    /**
     * Getter for ProcessingFee.
     * The processing fees and fee adjustments assessed by Square for this payment.
     * @return Returns the List of ProcessingFee
     */
    @JsonGetter("processing_fee")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<ProcessingFee> getProcessingFee() {
        return processingFee;
    }

    /**
     * Getter for RefundedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("refunded_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getRefundedMoney() {
        return refundedMoney;
    }

    /**
     * Getter for Status.
     * Indicates whether the payment is APPROVED, PENDING, COMPLETED, CANCELED, or FAILED.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for DelayDuration.
     * The duration of time after the payment's creation when Square automatically applies the
     * `delay_action` to the payment. This automatic `delay_action` applies only to payments that do
     * not reach a terminal state (COMPLETED, CANCELED, or FAILED) before the `delay_duration` time
     * period. This field is specified as a time duration, in RFC 3339 format. Notes: This feature
     * is only supported for card payments. Default: - Card-present payments: "PT36H" (36 hours)
     * from the creation time. - Card-not-present payments: "P7D" (7 days) from the creation time.
     * @return Returns the String
     */
    @JsonGetter("delay_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDelayDuration() {
        return delayDuration;
    }

    /**
     * Getter for DelayAction.
     * The action to be applied to the payment when the `delay_duration` has elapsed. Current values
     * include `CANCEL` and `COMPLETE`.
     * @return Returns the String
     */
    @JsonGetter("delay_action")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDelayAction() {
        return delayAction;
    }

    /**
     * Getter for DelayedUntil.
     * The read-only timestamp of when the `delay_action` is automatically applied, in RFC 3339
     * format. Note that this field is calculated by summing the payment's `delay_duration` and
     * `created_at` fields. The `created_at` field is generated by Square and might not exactly
     * match the time on your local machine.
     * @return Returns the String
     */
    @JsonGetter("delayed_until")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDelayedUntil() {
        return delayedUntil;
    }

    /**
     * Getter for SourceType.
     * The source type for this payment. Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`,
     * `BUY_NOW_PAY_LATER`, `CASH`, or `EXTERNAL`. For information about these payment source types,
     * see [Take Payments](https://developer.squareup.com/docs/payments-api/take-payments).
     * @return Returns the String
     */
    @JsonGetter("source_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Getter for CardDetails.
     * Reflects the current status of a card payment. Contains only non-confidential information.
     * @return Returns the CardPaymentDetails
     */
    @JsonGetter("card_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CardPaymentDetails getCardDetails() {
        return cardDetails;
    }

    /**
     * Getter for CashDetails.
     * Stores details about a cash payment. Contains only non-confidential information. For more
     * information, see [Take Cash
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments/cash-payments).
     * @return Returns the CashPaymentDetails
     */
    @JsonGetter("cash_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CashPaymentDetails getCashDetails() {
        return cashDetails;
    }

    /**
     * Getter for BankAccountDetails.
     * Additional details about BANK_ACCOUNT type payments.
     * @return Returns the BankAccountPaymentDetails
     */
    @JsonGetter("bank_account_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public BankAccountPaymentDetails getBankAccountDetails() {
        return bankAccountDetails;
    }

    /**
     * Getter for ExternalDetails.
     * Stores details about an external payment. Contains only non-confidential information. For
     * more information, see [Take External
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments/external-payments).
     * @return Returns the ExternalPaymentDetails
     */
    @JsonGetter("external_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ExternalPaymentDetails getExternalDetails() {
        return externalDetails;
    }

    /**
     * Getter for WalletDetails.
     * Additional details about `WALLET` type payments. Contains only non-confidential information.
     * @return Returns the DigitalWalletDetails
     */
    @JsonGetter("wallet_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DigitalWalletDetails getWalletDetails() {
        return walletDetails;
    }

    /**
     * Getter for BuyNowPayLaterDetails.
     * Additional details about a Buy Now Pay Later payment type.
     * @return Returns the BuyNowPayLaterDetails
     */
    @JsonGetter("buy_now_pay_later_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public BuyNowPayLaterDetails getBuyNowPayLaterDetails() {
        return buyNowPayLaterDetails;
    }

    /**
     * Getter for LocationId.
     * The ID of the location associated with the payment.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for OrderId.
     * The ID of the order associated with the payment.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for ReferenceId.
     * An optional ID that associates the payment with an entity in another system.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for CustomerId.
     * The [Customer]($m/Customer) ID of the customer associated with the payment.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for EmployeeId.
     * __Deprecated__: Use `Payment.team_member_id` instead. An optional ID of the employee
     * associated with taking the payment.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Getter for TeamMemberId.
     * An optional ID of the [TeamMember]($m/TeamMember) associated with taking the payment.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Getter for RefundIds.
     * A list of `refund_id`s identifying refunds for the payment.
     * @return Returns the List of String
     */
    @JsonGetter("refund_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getRefundIds() {
        return refundIds;
    }

    /**
     * Getter for RiskEvaluation.
     * Represents fraud risk information for the associated payment. When you take a payment through
     * Square's Payments API (using the `CreatePayment` endpoint), Square evaluates it and assigns a
     * risk level to the payment. Sellers can use this information to determine the course of action
     * (for example, provide the goods/services or refund the payment).
     * @return Returns the RiskEvaluation
     */
    @JsonGetter("risk_evaluation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public RiskEvaluation getRiskEvaluation() {
        return riskEvaluation;
    }

    /**
     * Getter for BuyerEmailAddress.
     * The buyer's email address.
     * @return Returns the String
     */
    @JsonGetter("buyer_email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBuyerEmailAddress() {
        return buyerEmailAddress;
    }

    /**
     * Getter for BillingAddress.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("billing_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("shipping_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Getter for Note.
     * An optional note to include when creating a payment.
     * @return Returns the String
     */
    @JsonGetter("note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNote() {
        return note;
    }

    /**
     * Getter for StatementDescriptionIdentifier.
     * Additional payment information that gets added to the customer's card statement as part of
     * the statement description. Note that the `statement_description_identifier` might get
     * truncated on the statement description to fit the required information including the Square
     * identifier (SQ *) and the name of the seller taking the payment.
     * @return Returns the String
     */
    @JsonGetter("statement_description_identifier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatementDescriptionIdentifier() {
        return statementDescriptionIdentifier;
    }

    /**
     * Getter for Capabilities.
     * Actions that can be performed on this payment: - `EDIT_AMOUNT_UP` - The payment amount can be
     * edited up. - `EDIT_AMOUNT_DOWN` - The payment amount can be edited down. -
     * `EDIT_TIP_AMOUNT_UP` - The tip amount can be edited up. - `EDIT_TIP_AMOUNT_DOWN` - The tip
     * amount can be edited down. - `EDIT_DELAY_ACTION` - The delay_action can be edited.
     * @return Returns the List of String
     */
    @JsonGetter("capabilities")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getCapabilities() {
        return capabilities;
    }

    /**
     * Getter for ReceiptNumber.
     * The payment's receipt number. The field is missing if a payment is canceled.
     * @return Returns the String
     */
    @JsonGetter("receipt_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * Getter for ReceiptUrl.
     * The URL for the payment's receipt. The field is only populated for COMPLETED payments.
     * @return Returns the String
     */
    @JsonGetter("receipt_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReceiptUrl() {
        return receiptUrl;
    }

    /**
     * Getter for DeviceDetails.
     * Details about the device that took the payment.
     * @return Returns the DeviceDetails
     */
    @JsonGetter("device_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceDetails getDeviceDetails() {
        return deviceDetails;
    }

    /**
     * Getter for ApplicationDetails.
     * Details about the application that took the payment.
     * @return Returns the ApplicationDetails
     */
    @JsonGetter("application_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ApplicationDetails getApplicationDetails() {
        return applicationDetails;
    }

    /**
     * Getter for VersionToken.
     * Used for optimistic concurrency. This opaque token identifies a specific version of the
     * `Payment` object.
     * @return Returns the String
     */
    @JsonGetter("version_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getVersionToken() {
        return versionToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, amountMoney, tipMoney, totalMoney,
                appFeeMoney, approvedMoney, processingFee, refundedMoney, status, delayDuration,
                delayAction, delayedUntil, sourceType, cardDetails, cashDetails, bankAccountDetails,
                externalDetails, walletDetails, buyNowPayLaterDetails, locationId, orderId,
                referenceId, customerId, employeeId, teamMemberId, refundIds, riskEvaluation,
                buyerEmailAddress, billingAddress, shippingAddress, note,
                statementDescriptionIdentifier, capabilities, receiptNumber, receiptUrl,
                deviceDetails, applicationDetails, versionToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(tipMoney, other.tipMoney)
            && Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(appFeeMoney, other.appFeeMoney)
            && Objects.equals(approvedMoney, other.approvedMoney)
            && Objects.equals(processingFee, other.processingFee)
            && Objects.equals(refundedMoney, other.refundedMoney)
            && Objects.equals(status, other.status)
            && Objects.equals(delayDuration, other.delayDuration)
            && Objects.equals(delayAction, other.delayAction)
            && Objects.equals(delayedUntil, other.delayedUntil)
            && Objects.equals(sourceType, other.sourceType)
            && Objects.equals(cardDetails, other.cardDetails)
            && Objects.equals(cashDetails, other.cashDetails)
            && Objects.equals(bankAccountDetails, other.bankAccountDetails)
            && Objects.equals(externalDetails, other.externalDetails)
            && Objects.equals(walletDetails, other.walletDetails)
            && Objects.equals(buyNowPayLaterDetails, other.buyNowPayLaterDetails)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(refundIds, other.refundIds)
            && Objects.equals(riskEvaluation, other.riskEvaluation)
            && Objects.equals(buyerEmailAddress, other.buyerEmailAddress)
            && Objects.equals(billingAddress, other.billingAddress)
            && Objects.equals(shippingAddress, other.shippingAddress)
            && Objects.equals(note, other.note)
            && Objects.equals(statementDescriptionIdentifier,
                    other.statementDescriptionIdentifier)
            && Objects.equals(capabilities, other.capabilities)
            && Objects.equals(receiptNumber, other.receiptNumber)
            && Objects.equals(receiptUrl, other.receiptUrl)
            && Objects.equals(deviceDetails, other.deviceDetails)
            && Objects.equals(applicationDetails, other.applicationDetails)
            && Objects.equals(versionToken, other.versionToken);
    }

    /**
     * Converts this Payment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Payment [" + "id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", amountMoney=" + amountMoney + ", tipMoney=" + tipMoney + ", totalMoney="
                + totalMoney + ", appFeeMoney=" + appFeeMoney + ", approvedMoney=" + approvedMoney
                + ", processingFee=" + processingFee + ", refundedMoney=" + refundedMoney
                + ", status=" + status + ", delayDuration=" + delayDuration + ", delayAction="
                + delayAction + ", delayedUntil=" + delayedUntil + ", sourceType=" + sourceType
                + ", cardDetails=" + cardDetails + ", cashDetails=" + cashDetails
                + ", bankAccountDetails=" + bankAccountDetails + ", externalDetails="
                + externalDetails + ", walletDetails=" + walletDetails + ", buyNowPayLaterDetails="
                + buyNowPayLaterDetails + ", locationId=" + locationId + ", orderId=" + orderId
                + ", referenceId=" + referenceId + ", customerId=" + customerId + ", employeeId="
                + employeeId + ", teamMemberId=" + teamMemberId + ", refundIds=" + refundIds
                + ", riskEvaluation=" + riskEvaluation + ", buyerEmailAddress=" + buyerEmailAddress
                + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress
                + ", note=" + note + ", statementDescriptionIdentifier="
                + statementDescriptionIdentifier + ", capabilities=" + capabilities
                + ", receiptNumber=" + receiptNumber + ", receiptUrl=" + receiptUrl
                + ", deviceDetails=" + deviceDetails + ", applicationDetails=" + applicationDetails
                + ", versionToken=" + versionToken + "]";
    }

    /**
     * Builds a new {@link Payment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Payment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .amountMoney(getAmountMoney())
                .tipMoney(getTipMoney())
                .totalMoney(getTotalMoney())
                .appFeeMoney(getAppFeeMoney())
                .approvedMoney(getApprovedMoney())
                .processingFee(getProcessingFee())
                .refundedMoney(getRefundedMoney())
                .status(getStatus())
                .delayDuration(getDelayDuration())
                .delayAction(getDelayAction())
                .delayedUntil(getDelayedUntil())
                .sourceType(getSourceType())
                .cardDetails(getCardDetails())
                .cashDetails(getCashDetails())
                .bankAccountDetails(getBankAccountDetails())
                .externalDetails(getExternalDetails())
                .walletDetails(getWalletDetails())
                .buyNowPayLaterDetails(getBuyNowPayLaterDetails())
                .locationId(getLocationId())
                .orderId(getOrderId())
                .referenceId(getReferenceId())
                .customerId(getCustomerId())
                .employeeId(getEmployeeId())
                .teamMemberId(getTeamMemberId())
                .refundIds(getRefundIds())
                .riskEvaluation(getRiskEvaluation())
                .buyerEmailAddress(getBuyerEmailAddress())
                .billingAddress(getBillingAddress())
                .shippingAddress(getShippingAddress())
                .note(getNote())
                .statementDescriptionIdentifier(getStatementDescriptionIdentifier())
                .capabilities(getCapabilities())
                .receiptNumber(getReceiptNumber())
                .receiptUrl(getReceiptUrl())
                .deviceDetails(getDeviceDetails())
                .applicationDetails(getApplicationDetails())
                .versionToken(getVersionToken());
        return builder;
    }

    /**
     * Class to build instances of {@link Payment}.
     */
    public static class Builder {
        private String id;
        private String createdAt;
        private String updatedAt;
        private Money amountMoney;
        private Money tipMoney;
        private Money totalMoney;
        private Money appFeeMoney;
        private Money approvedMoney;
        private List<ProcessingFee> processingFee;
        private Money refundedMoney;
        private String status;
        private String delayDuration;
        private String delayAction;
        private String delayedUntil;
        private String sourceType;
        private CardPaymentDetails cardDetails;
        private CashPaymentDetails cashDetails;
        private BankAccountPaymentDetails bankAccountDetails;
        private ExternalPaymentDetails externalDetails;
        private DigitalWalletDetails walletDetails;
        private BuyNowPayLaterDetails buyNowPayLaterDetails;
        private String locationId;
        private String orderId;
        private String referenceId;
        private String customerId;
        private String employeeId;
        private String teamMemberId;
        private List<String> refundIds;
        private RiskEvaluation riskEvaluation;
        private String buyerEmailAddress;
        private Address billingAddress;
        private Address shippingAddress;
        private String note;
        private String statementDescriptionIdentifier;
        private List<String> capabilities;
        private String receiptNumber;
        private String receiptUrl;
        private DeviceDetails deviceDetails;
        private ApplicationDetails applicationDetails;
        private String versionToken;



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
         * Setter for tipMoney.
         * @param  tipMoney  Money value for tipMoney.
         * @return Builder
         */
        public Builder tipMoney(Money tipMoney) {
            this.tipMoney = tipMoney;
            return this;
        }

        /**
         * Setter for totalMoney.
         * @param  totalMoney  Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Setter for appFeeMoney.
         * @param  appFeeMoney  Money value for appFeeMoney.
         * @return Builder
         */
        public Builder appFeeMoney(Money appFeeMoney) {
            this.appFeeMoney = appFeeMoney;
            return this;
        }

        /**
         * Setter for approvedMoney.
         * @param  approvedMoney  Money value for approvedMoney.
         * @return Builder
         */
        public Builder approvedMoney(Money approvedMoney) {
            this.approvedMoney = approvedMoney;
            return this;
        }

        /**
         * Setter for processingFee.
         * @param  processingFee  List of ProcessingFee value for processingFee.
         * @return Builder
         */
        public Builder processingFee(List<ProcessingFee> processingFee) {
            this.processingFee = processingFee;
            return this;
        }

        /**
         * Setter for refundedMoney.
         * @param  refundedMoney  Money value for refundedMoney.
         * @return Builder
         */
        public Builder refundedMoney(Money refundedMoney) {
            this.refundedMoney = refundedMoney;
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
         * Setter for delayDuration.
         * @param  delayDuration  String value for delayDuration.
         * @return Builder
         */
        public Builder delayDuration(String delayDuration) {
            this.delayDuration = delayDuration;
            return this;
        }

        /**
         * Setter for delayAction.
         * @param  delayAction  String value for delayAction.
         * @return Builder
         */
        public Builder delayAction(String delayAction) {
            this.delayAction = delayAction;
            return this;
        }

        /**
         * Setter for delayedUntil.
         * @param  delayedUntil  String value for delayedUntil.
         * @return Builder
         */
        public Builder delayedUntil(String delayedUntil) {
            this.delayedUntil = delayedUntil;
            return this;
        }

        /**
         * Setter for sourceType.
         * @param  sourceType  String value for sourceType.
         * @return Builder
         */
        public Builder sourceType(String sourceType) {
            this.sourceType = sourceType;
            return this;
        }

        /**
         * Setter for cardDetails.
         * @param  cardDetails  CardPaymentDetails value for cardDetails.
         * @return Builder
         */
        public Builder cardDetails(CardPaymentDetails cardDetails) {
            this.cardDetails = cardDetails;
            return this;
        }

        /**
         * Setter for cashDetails.
         * @param  cashDetails  CashPaymentDetails value for cashDetails.
         * @return Builder
         */
        public Builder cashDetails(CashPaymentDetails cashDetails) {
            this.cashDetails = cashDetails;
            return this;
        }

        /**
         * Setter for bankAccountDetails.
         * @param  bankAccountDetails  BankAccountPaymentDetails value for bankAccountDetails.
         * @return Builder
         */
        public Builder bankAccountDetails(BankAccountPaymentDetails bankAccountDetails) {
            this.bankAccountDetails = bankAccountDetails;
            return this;
        }

        /**
         * Setter for externalDetails.
         * @param  externalDetails  ExternalPaymentDetails value for externalDetails.
         * @return Builder
         */
        public Builder externalDetails(ExternalPaymentDetails externalDetails) {
            this.externalDetails = externalDetails;
            return this;
        }

        /**
         * Setter for walletDetails.
         * @param  walletDetails  DigitalWalletDetails value for walletDetails.
         * @return Builder
         */
        public Builder walletDetails(DigitalWalletDetails walletDetails) {
            this.walletDetails = walletDetails;
            return this;
        }

        /**
         * Setter for buyNowPayLaterDetails.
         * @param  buyNowPayLaterDetails  BuyNowPayLaterDetails value for buyNowPayLaterDetails.
         * @return Builder
         */
        public Builder buyNowPayLaterDetails(BuyNowPayLaterDetails buyNowPayLaterDetails) {
            this.buyNowPayLaterDetails = buyNowPayLaterDetails;
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
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Setter for employeeId.
         * @param  employeeId  String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Setter for refundIds.
         * @param  refundIds  List of String value for refundIds.
         * @return Builder
         */
        public Builder refundIds(List<String> refundIds) {
            this.refundIds = refundIds;
            return this;
        }

        /**
         * Setter for riskEvaluation.
         * @param  riskEvaluation  RiskEvaluation value for riskEvaluation.
         * @return Builder
         */
        public Builder riskEvaluation(RiskEvaluation riskEvaluation) {
            this.riskEvaluation = riskEvaluation;
            return this;
        }

        /**
         * Setter for buyerEmailAddress.
         * @param  buyerEmailAddress  String value for buyerEmailAddress.
         * @return Builder
         */
        public Builder buyerEmailAddress(String buyerEmailAddress) {
            this.buyerEmailAddress = buyerEmailAddress;
            return this;
        }

        /**
         * Setter for billingAddress.
         * @param  billingAddress  Address value for billingAddress.
         * @return Builder
         */
        public Builder billingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        /**
         * Setter for shippingAddress.
         * @param  shippingAddress  Address value for shippingAddress.
         * @return Builder
         */
        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Setter for statementDescriptionIdentifier.
         * @param  statementDescriptionIdentifier  String value for statementDescriptionIdentifier.
         * @return Builder
         */
        public Builder statementDescriptionIdentifier(String statementDescriptionIdentifier) {
            this.statementDescriptionIdentifier = statementDescriptionIdentifier;
            return this;
        }

        /**
         * Setter for capabilities.
         * @param  capabilities  List of String value for capabilities.
         * @return Builder
         */
        public Builder capabilities(List<String> capabilities) {
            this.capabilities = capabilities;
            return this;
        }

        /**
         * Setter for receiptNumber.
         * @param  receiptNumber  String value for receiptNumber.
         * @return Builder
         */
        public Builder receiptNumber(String receiptNumber) {
            this.receiptNumber = receiptNumber;
            return this;
        }

        /**
         * Setter for receiptUrl.
         * @param  receiptUrl  String value for receiptUrl.
         * @return Builder
         */
        public Builder receiptUrl(String receiptUrl) {
            this.receiptUrl = receiptUrl;
            return this;
        }

        /**
         * Setter for deviceDetails.
         * @param  deviceDetails  DeviceDetails value for deviceDetails.
         * @return Builder
         */
        public Builder deviceDetails(DeviceDetails deviceDetails) {
            this.deviceDetails = deviceDetails;
            return this;
        }

        /**
         * Setter for applicationDetails.
         * @param  applicationDetails  ApplicationDetails value for applicationDetails.
         * @return Builder
         */
        public Builder applicationDetails(ApplicationDetails applicationDetails) {
            this.applicationDetails = applicationDetails;
            return this;
        }

        /**
         * Setter for versionToken.
         * @param  versionToken  String value for versionToken.
         * @return Builder
         */
        public Builder versionToken(String versionToken) {
            this.versionToken = versionToken;
            return this;
        }

        /**
         * Builds a new {@link Payment} object using the set fields.
         * @return {@link Payment}
         */
        public Payment build() {
            return new Payment(id, createdAt, updatedAt, amountMoney, tipMoney, totalMoney,
                    appFeeMoney, approvedMoney, processingFee, refundedMoney, status, delayDuration,
                    delayAction, delayedUntil, sourceType, cardDetails, cashDetails,
                    bankAccountDetails, externalDetails, walletDetails, buyNowPayLaterDetails,
                    locationId, orderId, referenceId, customerId, employeeId, teamMemberId,
                    refundIds, riskEvaluation, buyerEmailAddress, billingAddress, shippingAddress,
                    note, statementDescriptionIdentifier, capabilities, receiptNumber, receiptUrl,
                    deviceDetails, applicationDetails, versionToken);
        }
    }
}
