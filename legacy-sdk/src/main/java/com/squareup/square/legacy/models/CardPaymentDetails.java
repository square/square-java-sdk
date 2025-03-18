package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CardPaymentDetails type.
 */
public class CardPaymentDetails {
    private final OptionalNullable<String> status;
    private final Card card;
    private final OptionalNullable<String> entryMethod;
    private final OptionalNullable<String> cvvStatus;
    private final OptionalNullable<String> avsStatus;
    private final OptionalNullable<String> authResultCode;
    private final OptionalNullable<String> applicationIdentifier;
    private final OptionalNullable<String> applicationName;
    private final OptionalNullable<String> applicationCryptogram;
    private final OptionalNullable<String> verificationMethod;
    private final OptionalNullable<String> verificationResults;
    private final OptionalNullable<String> statementDescription;
    private final DeviceDetails deviceDetails;
    private final CardPaymentTimeline cardPaymentTimeline;
    private final OptionalNullable<Boolean> refundRequiresCardPresence;
    private final OptionalNullable<List<Error>> errors;

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     * @param  card  Card value for card.
     * @param  entryMethod  String value for entryMethod.
     * @param  cvvStatus  String value for cvvStatus.
     * @param  avsStatus  String value for avsStatus.
     * @param  authResultCode  String value for authResultCode.
     * @param  applicationIdentifier  String value for applicationIdentifier.
     * @param  applicationName  String value for applicationName.
     * @param  applicationCryptogram  String value for applicationCryptogram.
     * @param  verificationMethod  String value for verificationMethod.
     * @param  verificationResults  String value for verificationResults.
     * @param  statementDescription  String value for statementDescription.
     * @param  deviceDetails  DeviceDetails value for deviceDetails.
     * @param  cardPaymentTimeline  CardPaymentTimeline value for cardPaymentTimeline.
     * @param  refundRequiresCardPresence  Boolean value for refundRequiresCardPresence.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CardPaymentDetails(
            @JsonProperty("status") String status,
            @JsonProperty("card") Card card,
            @JsonProperty("entry_method") String entryMethod,
            @JsonProperty("cvv_status") String cvvStatus,
            @JsonProperty("avs_status") String avsStatus,
            @JsonProperty("auth_result_code") String authResultCode,
            @JsonProperty("application_identifier") String applicationIdentifier,
            @JsonProperty("application_name") String applicationName,
            @JsonProperty("application_cryptogram") String applicationCryptogram,
            @JsonProperty("verification_method") String verificationMethod,
            @JsonProperty("verification_results") String verificationResults,
            @JsonProperty("statement_description") String statementDescription,
            @JsonProperty("device_details") DeviceDetails deviceDetails,
            @JsonProperty("card_payment_timeline") CardPaymentTimeline cardPaymentTimeline,
            @JsonProperty("refund_requires_card_presence") Boolean refundRequiresCardPresence,
            @JsonProperty("errors") List<Error> errors) {
        this.status = OptionalNullable.of(status);
        this.card = card;
        this.entryMethod = OptionalNullable.of(entryMethod);
        this.cvvStatus = OptionalNullable.of(cvvStatus);
        this.avsStatus = OptionalNullable.of(avsStatus);
        this.authResultCode = OptionalNullable.of(authResultCode);
        this.applicationIdentifier = OptionalNullable.of(applicationIdentifier);
        this.applicationName = OptionalNullable.of(applicationName);
        this.applicationCryptogram = OptionalNullable.of(applicationCryptogram);
        this.verificationMethod = OptionalNullable.of(verificationMethod);
        this.verificationResults = OptionalNullable.of(verificationResults);
        this.statementDescription = OptionalNullable.of(statementDescription);
        this.deviceDetails = deviceDetails;
        this.cardPaymentTimeline = cardPaymentTimeline;
        this.refundRequiresCardPresence = OptionalNullable.of(refundRequiresCardPresence);
        this.errors = OptionalNullable.of(errors);
    }

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     * @param  card  Card value for card.
     * @param  entryMethod  String value for entryMethod.
     * @param  cvvStatus  String value for cvvStatus.
     * @param  avsStatus  String value for avsStatus.
     * @param  authResultCode  String value for authResultCode.
     * @param  applicationIdentifier  String value for applicationIdentifier.
     * @param  applicationName  String value for applicationName.
     * @param  applicationCryptogram  String value for applicationCryptogram.
     * @param  verificationMethod  String value for verificationMethod.
     * @param  verificationResults  String value for verificationResults.
     * @param  statementDescription  String value for statementDescription.
     * @param  deviceDetails  DeviceDetails value for deviceDetails.
     * @param  cardPaymentTimeline  CardPaymentTimeline value for cardPaymentTimeline.
     * @param  refundRequiresCardPresence  Boolean value for refundRequiresCardPresence.
     * @param  errors  List of Error value for errors.
     */
    protected CardPaymentDetails(
            OptionalNullable<String> status,
            Card card,
            OptionalNullable<String> entryMethod,
            OptionalNullable<String> cvvStatus,
            OptionalNullable<String> avsStatus,
            OptionalNullable<String> authResultCode,
            OptionalNullable<String> applicationIdentifier,
            OptionalNullable<String> applicationName,
            OptionalNullable<String> applicationCryptogram,
            OptionalNullable<String> verificationMethod,
            OptionalNullable<String> verificationResults,
            OptionalNullable<String> statementDescription,
            DeviceDetails deviceDetails,
            CardPaymentTimeline cardPaymentTimeline,
            OptionalNullable<Boolean> refundRequiresCardPresence,
            OptionalNullable<List<Error>> errors) {
        this.status = status;
        this.card = card;
        this.entryMethod = entryMethod;
        this.cvvStatus = cvvStatus;
        this.avsStatus = avsStatus;
        this.authResultCode = authResultCode;
        this.applicationIdentifier = applicationIdentifier;
        this.applicationName = applicationName;
        this.applicationCryptogram = applicationCryptogram;
        this.verificationMethod = verificationMethod;
        this.verificationResults = verificationResults;
        this.statementDescription = statementDescription;
        this.deviceDetails = deviceDetails;
        this.cardPaymentTimeline = cardPaymentTimeline;
        this.refundRequiresCardPresence = refundRequiresCardPresence;
        this.errors = errors;
    }

    /**
     * Internal Getter for Status.
     * The card payment's current state. The state can be AUTHORIZED, CAPTURED, VOIDED, or FAILED.
     * @return Returns the Internal String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStatus() {
        return this.status;
    }

    /**
     * Getter for Status.
     * The card payment's current state. The state can be AUTHORIZED, CAPTURED, VOIDED, or FAILED.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStatus() {
        return OptionalNullable.getFrom(status);
    }

    /**
     * Getter for Card.
     * Represents the payment details of a card to be used for payments. These details are
     * determined by the payment token generated by Web Payments SDK.
     * @return Returns the Card
     */
    @JsonGetter("card")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Card getCard() {
        return card;
    }

    /**
     * Internal Getter for EntryMethod.
     * The method used to enter the card's details for the payment. The method can be `KEYED`,
     * `SWIPED`, `EMV`, `ON_FILE`, or `CONTACTLESS`.
     * @return Returns the Internal String
     */
    @JsonGetter("entry_method")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEntryMethod() {
        return this.entryMethod;
    }

    /**
     * Getter for EntryMethod.
     * The method used to enter the card's details for the payment. The method can be `KEYED`,
     * `SWIPED`, `EMV`, `ON_FILE`, or `CONTACTLESS`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEntryMethod() {
        return OptionalNullable.getFrom(entryMethod);
    }

    /**
     * Internal Getter for CvvStatus.
     * The status code returned from the Card Verification Value (CVV) check. The code can be
     * `CVV_ACCEPTED`, `CVV_REJECTED`, or `CVV_NOT_CHECKED`.
     * @return Returns the Internal String
     */
    @JsonGetter("cvv_status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCvvStatus() {
        return this.cvvStatus;
    }

    /**
     * Getter for CvvStatus.
     * The status code returned from the Card Verification Value (CVV) check. The code can be
     * `CVV_ACCEPTED`, `CVV_REJECTED`, or `CVV_NOT_CHECKED`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCvvStatus() {
        return OptionalNullable.getFrom(cvvStatus);
    }

    /**
     * Internal Getter for AvsStatus.
     * The status code returned from the Address Verification System (AVS) check. The code can be
     * `AVS_ACCEPTED`, `AVS_REJECTED`, or `AVS_NOT_CHECKED`.
     * @return Returns the Internal String
     */
    @JsonGetter("avs_status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAvsStatus() {
        return this.avsStatus;
    }

    /**
     * Getter for AvsStatus.
     * The status code returned from the Address Verification System (AVS) check. The code can be
     * `AVS_ACCEPTED`, `AVS_REJECTED`, or `AVS_NOT_CHECKED`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAvsStatus() {
        return OptionalNullable.getFrom(avsStatus);
    }

    /**
     * Internal Getter for AuthResultCode.
     * The status code returned by the card issuer that describes the payment's authorization
     * status.
     * @return Returns the Internal String
     */
    @JsonGetter("auth_result_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAuthResultCode() {
        return this.authResultCode;
    }

    /**
     * Getter for AuthResultCode.
     * The status code returned by the card issuer that describes the payment's authorization
     * status.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAuthResultCode() {
        return OptionalNullable.getFrom(authResultCode);
    }

    /**
     * Internal Getter for ApplicationIdentifier.
     * For EMV payments, the application ID identifies the EMV application used for the payment.
     * @return Returns the Internal String
     */
    @JsonGetter("application_identifier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetApplicationIdentifier() {
        return this.applicationIdentifier;
    }

    /**
     * Getter for ApplicationIdentifier.
     * For EMV payments, the application ID identifies the EMV application used for the payment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getApplicationIdentifier() {
        return OptionalNullable.getFrom(applicationIdentifier);
    }

    /**
     * Internal Getter for ApplicationName.
     * For EMV payments, the human-readable name of the EMV application used for the payment.
     * @return Returns the Internal String
     */
    @JsonGetter("application_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetApplicationName() {
        return this.applicationName;
    }

    /**
     * Getter for ApplicationName.
     * For EMV payments, the human-readable name of the EMV application used for the payment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getApplicationName() {
        return OptionalNullable.getFrom(applicationName);
    }

    /**
     * Internal Getter for ApplicationCryptogram.
     * For EMV payments, the cryptogram generated for the payment.
     * @return Returns the Internal String
     */
    @JsonGetter("application_cryptogram")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetApplicationCryptogram() {
        return this.applicationCryptogram;
    }

    /**
     * Getter for ApplicationCryptogram.
     * For EMV payments, the cryptogram generated for the payment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getApplicationCryptogram() {
        return OptionalNullable.getFrom(applicationCryptogram);
    }

    /**
     * Internal Getter for VerificationMethod.
     * For EMV payments, the method used to verify the cardholder's identity. The method can be
     * `PIN`, `SIGNATURE`, `PIN_AND_SIGNATURE`, `ON_DEVICE`, or `NONE`.
     * @return Returns the Internal String
     */
    @JsonGetter("verification_method")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetVerificationMethod() {
        return this.verificationMethod;
    }

    /**
     * Getter for VerificationMethod.
     * For EMV payments, the method used to verify the cardholder's identity. The method can be
     * `PIN`, `SIGNATURE`, `PIN_AND_SIGNATURE`, `ON_DEVICE`, or `NONE`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getVerificationMethod() {
        return OptionalNullable.getFrom(verificationMethod);
    }

    /**
     * Internal Getter for VerificationResults.
     * For EMV payments, the results of the cardholder verification. The result can be `SUCCESS`,
     * `FAILURE`, or `UNKNOWN`.
     * @return Returns the Internal String
     */
    @JsonGetter("verification_results")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetVerificationResults() {
        return this.verificationResults;
    }

    /**
     * Getter for VerificationResults.
     * For EMV payments, the results of the cardholder verification. The result can be `SUCCESS`,
     * `FAILURE`, or `UNKNOWN`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getVerificationResults() {
        return OptionalNullable.getFrom(verificationResults);
    }

    /**
     * Internal Getter for StatementDescription.
     * The statement description sent to the card networks. Note: The actual statement description
     * varies and is likely to be truncated and appended with additional information on a per issuer
     * basis.
     * @return Returns the Internal String
     */
    @JsonGetter("statement_description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStatementDescription() {
        return this.statementDescription;
    }

    /**
     * Getter for StatementDescription.
     * The statement description sent to the card networks. Note: The actual statement description
     * varies and is likely to be truncated and appended with additional information on a per issuer
     * basis.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStatementDescription() {
        return OptionalNullable.getFrom(statementDescription);
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
     * Getter for CardPaymentTimeline.
     * The timeline for card payments.
     * @return Returns the CardPaymentTimeline
     */
    @JsonGetter("card_payment_timeline")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CardPaymentTimeline getCardPaymentTimeline() {
        return cardPaymentTimeline;
    }

    /**
     * Internal Getter for RefundRequiresCardPresence.
     * Whether the card must be physically present for the payment to be refunded. If set to `true`,
     * the card must be present.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("refund_requires_card_presence")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetRefundRequiresCardPresence() {
        return this.refundRequiresCardPresence;
    }

    /**
     * Getter for RefundRequiresCardPresence.
     * Whether the card must be physically present for the payment to be refunded. If set to `true`,
     * the card must be present.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getRefundRequiresCardPresence() {
        return OptionalNullable.getFrom(refundRequiresCardPresence);
    }

    /**
     * Internal Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the Internal List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Error>> internalGetErrors() {
        return this.errors;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonIgnore
    public List<Error> getErrors() {
        return OptionalNullable.getFrom(errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                status,
                card,
                entryMethod,
                cvvStatus,
                avsStatus,
                authResultCode,
                applicationIdentifier,
                applicationName,
                applicationCryptogram,
                verificationMethod,
                verificationResults,
                statementDescription,
                deviceDetails,
                cardPaymentTimeline,
                refundRequiresCardPresence,
                errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardPaymentDetails)) {
            return false;
        }
        CardPaymentDetails other = (CardPaymentDetails) obj;
        return Objects.equals(status, other.status)
                && Objects.equals(card, other.card)
                && Objects.equals(entryMethod, other.entryMethod)
                && Objects.equals(cvvStatus, other.cvvStatus)
                && Objects.equals(avsStatus, other.avsStatus)
                && Objects.equals(authResultCode, other.authResultCode)
                && Objects.equals(applicationIdentifier, other.applicationIdentifier)
                && Objects.equals(applicationName, other.applicationName)
                && Objects.equals(applicationCryptogram, other.applicationCryptogram)
                && Objects.equals(verificationMethod, other.verificationMethod)
                && Objects.equals(verificationResults, other.verificationResults)
                && Objects.equals(statementDescription, other.statementDescription)
                && Objects.equals(deviceDetails, other.deviceDetails)
                && Objects.equals(cardPaymentTimeline, other.cardPaymentTimeline)
                && Objects.equals(refundRequiresCardPresence, other.refundRequiresCardPresence)
                && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CardPaymentDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CardPaymentDetails [" + "status=" + status + ", card=" + card + ", entryMethod="
                + entryMethod + ", cvvStatus=" + cvvStatus + ", avsStatus=" + avsStatus
                + ", authResultCode=" + authResultCode + ", applicationIdentifier="
                + applicationIdentifier + ", applicationName=" + applicationName
                + ", applicationCryptogram=" + applicationCryptogram + ", verificationMethod="
                + verificationMethod + ", verificationResults=" + verificationResults
                + ", statementDescription=" + statementDescription + ", deviceDetails="
                + deviceDetails + ", cardPaymentTimeline=" + cardPaymentTimeline
                + ", refundRequiresCardPresence=" + refundRequiresCardPresence + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link CardPaymentDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CardPaymentDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .card(getCard())
                .deviceDetails(getDeviceDetails())
                .cardPaymentTimeline(getCardPaymentTimeline());
        builder.status = internalGetStatus();
        builder.entryMethod = internalGetEntryMethod();
        builder.cvvStatus = internalGetCvvStatus();
        builder.avsStatus = internalGetAvsStatus();
        builder.authResultCode = internalGetAuthResultCode();
        builder.applicationIdentifier = internalGetApplicationIdentifier();
        builder.applicationName = internalGetApplicationName();
        builder.applicationCryptogram = internalGetApplicationCryptogram();
        builder.verificationMethod = internalGetVerificationMethod();
        builder.verificationResults = internalGetVerificationResults();
        builder.statementDescription = internalGetStatementDescription();
        builder.refundRequiresCardPresence = internalGetRefundRequiresCardPresence();
        builder.errors = internalGetErrors();
        return builder;
    }

    /**
     * Class to build instances of {@link CardPaymentDetails}.
     */
    public static class Builder {
        private OptionalNullable<String> status;
        private Card card;
        private OptionalNullable<String> entryMethod;
        private OptionalNullable<String> cvvStatus;
        private OptionalNullable<String> avsStatus;
        private OptionalNullable<String> authResultCode;
        private OptionalNullable<String> applicationIdentifier;
        private OptionalNullable<String> applicationName;
        private OptionalNullable<String> applicationCryptogram;
        private OptionalNullable<String> verificationMethod;
        private OptionalNullable<String> verificationResults;
        private OptionalNullable<String> statementDescription;
        private DeviceDetails deviceDetails;
        private CardPaymentTimeline cardPaymentTimeline;
        private OptionalNullable<Boolean> refundRequiresCardPresence;
        private OptionalNullable<List<Error>> errors;

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = OptionalNullable.of(status);
            return this;
        }

        /**
         * UnSetter for status.
         * @return Builder
         */
        public Builder unsetStatus() {
            status = null;
            return this;
        }

        /**
         * Setter for card.
         * @param  card  Card value for card.
         * @return Builder
         */
        public Builder card(Card card) {
            this.card = card;
            return this;
        }

        /**
         * Setter for entryMethod.
         * @param  entryMethod  String value for entryMethod.
         * @return Builder
         */
        public Builder entryMethod(String entryMethod) {
            this.entryMethod = OptionalNullable.of(entryMethod);
            return this;
        }

        /**
         * UnSetter for entryMethod.
         * @return Builder
         */
        public Builder unsetEntryMethod() {
            entryMethod = null;
            return this;
        }

        /**
         * Setter for cvvStatus.
         * @param  cvvStatus  String value for cvvStatus.
         * @return Builder
         */
        public Builder cvvStatus(String cvvStatus) {
            this.cvvStatus = OptionalNullable.of(cvvStatus);
            return this;
        }

        /**
         * UnSetter for cvvStatus.
         * @return Builder
         */
        public Builder unsetCvvStatus() {
            cvvStatus = null;
            return this;
        }

        /**
         * Setter for avsStatus.
         * @param  avsStatus  String value for avsStatus.
         * @return Builder
         */
        public Builder avsStatus(String avsStatus) {
            this.avsStatus = OptionalNullable.of(avsStatus);
            return this;
        }

        /**
         * UnSetter for avsStatus.
         * @return Builder
         */
        public Builder unsetAvsStatus() {
            avsStatus = null;
            return this;
        }

        /**
         * Setter for authResultCode.
         * @param  authResultCode  String value for authResultCode.
         * @return Builder
         */
        public Builder authResultCode(String authResultCode) {
            this.authResultCode = OptionalNullable.of(authResultCode);
            return this;
        }

        /**
         * UnSetter for authResultCode.
         * @return Builder
         */
        public Builder unsetAuthResultCode() {
            authResultCode = null;
            return this;
        }

        /**
         * Setter for applicationIdentifier.
         * @param  applicationIdentifier  String value for applicationIdentifier.
         * @return Builder
         */
        public Builder applicationIdentifier(String applicationIdentifier) {
            this.applicationIdentifier = OptionalNullable.of(applicationIdentifier);
            return this;
        }

        /**
         * UnSetter for applicationIdentifier.
         * @return Builder
         */
        public Builder unsetApplicationIdentifier() {
            applicationIdentifier = null;
            return this;
        }

        /**
         * Setter for applicationName.
         * @param  applicationName  String value for applicationName.
         * @return Builder
         */
        public Builder applicationName(String applicationName) {
            this.applicationName = OptionalNullable.of(applicationName);
            return this;
        }

        /**
         * UnSetter for applicationName.
         * @return Builder
         */
        public Builder unsetApplicationName() {
            applicationName = null;
            return this;
        }

        /**
         * Setter for applicationCryptogram.
         * @param  applicationCryptogram  String value for applicationCryptogram.
         * @return Builder
         */
        public Builder applicationCryptogram(String applicationCryptogram) {
            this.applicationCryptogram = OptionalNullable.of(applicationCryptogram);
            return this;
        }

        /**
         * UnSetter for applicationCryptogram.
         * @return Builder
         */
        public Builder unsetApplicationCryptogram() {
            applicationCryptogram = null;
            return this;
        }

        /**
         * Setter for verificationMethod.
         * @param  verificationMethod  String value for verificationMethod.
         * @return Builder
         */
        public Builder verificationMethod(String verificationMethod) {
            this.verificationMethod = OptionalNullable.of(verificationMethod);
            return this;
        }

        /**
         * UnSetter for verificationMethod.
         * @return Builder
         */
        public Builder unsetVerificationMethod() {
            verificationMethod = null;
            return this;
        }

        /**
         * Setter for verificationResults.
         * @param  verificationResults  String value for verificationResults.
         * @return Builder
         */
        public Builder verificationResults(String verificationResults) {
            this.verificationResults = OptionalNullable.of(verificationResults);
            return this;
        }

        /**
         * UnSetter for verificationResults.
         * @return Builder
         */
        public Builder unsetVerificationResults() {
            verificationResults = null;
            return this;
        }

        /**
         * Setter for statementDescription.
         * @param  statementDescription  String value for statementDescription.
         * @return Builder
         */
        public Builder statementDescription(String statementDescription) {
            this.statementDescription = OptionalNullable.of(statementDescription);
            return this;
        }

        /**
         * UnSetter for statementDescription.
         * @return Builder
         */
        public Builder unsetStatementDescription() {
            statementDescription = null;
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
         * Setter for cardPaymentTimeline.
         * @param  cardPaymentTimeline  CardPaymentTimeline value for cardPaymentTimeline.
         * @return Builder
         */
        public Builder cardPaymentTimeline(CardPaymentTimeline cardPaymentTimeline) {
            this.cardPaymentTimeline = cardPaymentTimeline;
            return this;
        }

        /**
         * Setter for refundRequiresCardPresence.
         * @param  refundRequiresCardPresence  Boolean value for refundRequiresCardPresence.
         * @return Builder
         */
        public Builder refundRequiresCardPresence(Boolean refundRequiresCardPresence) {
            this.refundRequiresCardPresence = OptionalNullable.of(refundRequiresCardPresence);
            return this;
        }

        /**
         * UnSetter for refundRequiresCardPresence.
         * @return Builder
         */
        public Builder unsetRefundRequiresCardPresence() {
            refundRequiresCardPresence = null;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = OptionalNullable.of(errors);
            return this;
        }

        /**
         * UnSetter for errors.
         * @return Builder
         */
        public Builder unsetErrors() {
            errors = null;
            return this;
        }

        /**
         * Builds a new {@link CardPaymentDetails} object using the set fields.
         * @return {@link CardPaymentDetails}
         */
        public CardPaymentDetails build() {
            return new CardPaymentDetails(
                    status,
                    card,
                    entryMethod,
                    cvvStatus,
                    avsStatus,
                    authResultCode,
                    applicationIdentifier,
                    applicationName,
                    applicationCryptogram,
                    verificationMethod,
                    verificationResults,
                    statementDescription,
                    deviceDetails,
                    cardPaymentTimeline,
                    refundRequiresCardPresence,
                    errors);
        }
    }
}
