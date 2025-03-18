/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class DisputeEvidenceType {
    public static final DisputeEvidenceType SERVICE_RECEIVED_DOCUMENTATION =
            new DisputeEvidenceType(Value.SERVICE_RECEIVED_DOCUMENTATION, "SERVICE_RECEIVED_DOCUMENTATION");

    public static final DisputeEvidenceType DUPLICATE_CHARGE_DOCUMENTATION =
            new DisputeEvidenceType(Value.DUPLICATE_CHARGE_DOCUMENTATION, "DUPLICATE_CHARGE_DOCUMENTATION");

    public static final DisputeEvidenceType CARDHOLDER_COMMUNICATION =
            new DisputeEvidenceType(Value.CARDHOLDER_COMMUNICATION, "CARDHOLDER_COMMUNICATION");

    public static final DisputeEvidenceType CARDHOLDER_INFORMATION =
            new DisputeEvidenceType(Value.CARDHOLDER_INFORMATION, "CARDHOLDER_INFORMATION");

    public static final DisputeEvidenceType REBUTTAL_EXPLANATION =
            new DisputeEvidenceType(Value.REBUTTAL_EXPLANATION, "REBUTTAL_EXPLANATION");

    public static final DisputeEvidenceType TRACKING_NUMBER =
            new DisputeEvidenceType(Value.TRACKING_NUMBER, "TRACKING_NUMBER");

    public static final DisputeEvidenceType GENERIC_EVIDENCE =
            new DisputeEvidenceType(Value.GENERIC_EVIDENCE, "GENERIC_EVIDENCE");

    public static final DisputeEvidenceType RELATED_TRANSACTION_DOCUMENTATION =
            new DisputeEvidenceType(Value.RELATED_TRANSACTION_DOCUMENTATION, "RELATED_TRANSACTION_DOCUMENTATION");

    public static final DisputeEvidenceType PRODUCT_OR_SERVICE_DESCRIPTION =
            new DisputeEvidenceType(Value.PRODUCT_OR_SERVICE_DESCRIPTION, "PRODUCT_OR_SERVICE_DESCRIPTION");

    public static final DisputeEvidenceType RECEIPT = new DisputeEvidenceType(Value.RECEIPT, "RECEIPT");

    public static final DisputeEvidenceType AUTHORIZATION_DOCUMENTATION =
            new DisputeEvidenceType(Value.AUTHORIZATION_DOCUMENTATION, "AUTHORIZATION_DOCUMENTATION");

    public static final DisputeEvidenceType PURCHASE_ACKNOWLEDGEMENT =
            new DisputeEvidenceType(Value.PURCHASE_ACKNOWLEDGEMENT, "PURCHASE_ACKNOWLEDGEMENT");

    public static final DisputeEvidenceType ONLINE_OR_APP_ACCESS_LOG =
            new DisputeEvidenceType(Value.ONLINE_OR_APP_ACCESS_LOG, "ONLINE_OR_APP_ACCESS_LOG");

    public static final DisputeEvidenceType PROOF_OF_DELIVERY_DOCUMENTATION =
            new DisputeEvidenceType(Value.PROOF_OF_DELIVERY_DOCUMENTATION, "PROOF_OF_DELIVERY_DOCUMENTATION");

    public static final DisputeEvidenceType CANCELLATION_OR_REFUND_DOCUMENTATION =
            new DisputeEvidenceType(Value.CANCELLATION_OR_REFUND_DOCUMENTATION, "CANCELLATION_OR_REFUND_DOCUMENTATION");

    private final Value value;

    private final String string;

    DisputeEvidenceType(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @java.lang.Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        return (this == other)
                || (other instanceof DisputeEvidenceType && this.string.equals(((DisputeEvidenceType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case SERVICE_RECEIVED_DOCUMENTATION:
                return visitor.visitServiceReceivedDocumentation();
            case DUPLICATE_CHARGE_DOCUMENTATION:
                return visitor.visitDuplicateChargeDocumentation();
            case CARDHOLDER_COMMUNICATION:
                return visitor.visitCardholderCommunication();
            case CARDHOLDER_INFORMATION:
                return visitor.visitCardholderInformation();
            case REBUTTAL_EXPLANATION:
                return visitor.visitRebuttalExplanation();
            case TRACKING_NUMBER:
                return visitor.visitTrackingNumber();
            case GENERIC_EVIDENCE:
                return visitor.visitGenericEvidence();
            case RELATED_TRANSACTION_DOCUMENTATION:
                return visitor.visitRelatedTransactionDocumentation();
            case PRODUCT_OR_SERVICE_DESCRIPTION:
                return visitor.visitProductOrServiceDescription();
            case RECEIPT:
                return visitor.visitReceipt();
            case AUTHORIZATION_DOCUMENTATION:
                return visitor.visitAuthorizationDocumentation();
            case PURCHASE_ACKNOWLEDGEMENT:
                return visitor.visitPurchaseAcknowledgement();
            case ONLINE_OR_APP_ACCESS_LOG:
                return visitor.visitOnlineOrAppAccessLog();
            case PROOF_OF_DELIVERY_DOCUMENTATION:
                return visitor.visitProofOfDeliveryDocumentation();
            case CANCELLATION_OR_REFUND_DOCUMENTATION:
                return visitor.visitCancellationOrRefundDocumentation();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DisputeEvidenceType valueOf(String value) {
        switch (value) {
            case "SERVICE_RECEIVED_DOCUMENTATION":
                return SERVICE_RECEIVED_DOCUMENTATION;
            case "DUPLICATE_CHARGE_DOCUMENTATION":
                return DUPLICATE_CHARGE_DOCUMENTATION;
            case "CARDHOLDER_COMMUNICATION":
                return CARDHOLDER_COMMUNICATION;
            case "CARDHOLDER_INFORMATION":
                return CARDHOLDER_INFORMATION;
            case "REBUTTAL_EXPLANATION":
                return REBUTTAL_EXPLANATION;
            case "TRACKING_NUMBER":
                return TRACKING_NUMBER;
            case "GENERIC_EVIDENCE":
                return GENERIC_EVIDENCE;
            case "RELATED_TRANSACTION_DOCUMENTATION":
                return RELATED_TRANSACTION_DOCUMENTATION;
            case "PRODUCT_OR_SERVICE_DESCRIPTION":
                return PRODUCT_OR_SERVICE_DESCRIPTION;
            case "RECEIPT":
                return RECEIPT;
            case "AUTHORIZATION_DOCUMENTATION":
                return AUTHORIZATION_DOCUMENTATION;
            case "PURCHASE_ACKNOWLEDGEMENT":
                return PURCHASE_ACKNOWLEDGEMENT;
            case "ONLINE_OR_APP_ACCESS_LOG":
                return ONLINE_OR_APP_ACCESS_LOG;
            case "PROOF_OF_DELIVERY_DOCUMENTATION":
                return PROOF_OF_DELIVERY_DOCUMENTATION;
            case "CANCELLATION_OR_REFUND_DOCUMENTATION":
                return CANCELLATION_OR_REFUND_DOCUMENTATION;
            default:
                return new DisputeEvidenceType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        GENERIC_EVIDENCE,

        ONLINE_OR_APP_ACCESS_LOG,

        AUTHORIZATION_DOCUMENTATION,

        CANCELLATION_OR_REFUND_DOCUMENTATION,

        CARDHOLDER_COMMUNICATION,

        CARDHOLDER_INFORMATION,

        PURCHASE_ACKNOWLEDGEMENT,

        DUPLICATE_CHARGE_DOCUMENTATION,

        PRODUCT_OR_SERVICE_DESCRIPTION,

        RECEIPT,

        SERVICE_RECEIVED_DOCUMENTATION,

        PROOF_OF_DELIVERY_DOCUMENTATION,

        RELATED_TRANSACTION_DOCUMENTATION,

        REBUTTAL_EXPLANATION,

        TRACKING_NUMBER,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitGenericEvidence();

        T visitOnlineOrAppAccessLog();

        T visitAuthorizationDocumentation();

        T visitCancellationOrRefundDocumentation();

        T visitCardholderCommunication();

        T visitCardholderInformation();

        T visitPurchaseAcknowledgement();

        T visitDuplicateChargeDocumentation();

        T visitProductOrServiceDescription();

        T visitReceipt();

        T visitServiceReceivedDocumentation();

        T visitProofOfDeliveryDocumentation();

        T visitRelatedTransactionDocumentation();

        T visitRebuttalExplanation();

        T visitTrackingNumber();

        T visitUnknown(String unknownType);
    }
}
