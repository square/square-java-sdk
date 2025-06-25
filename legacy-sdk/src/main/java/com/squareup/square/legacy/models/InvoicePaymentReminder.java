package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for InvoicePaymentReminder type.
 */
public class InvoicePaymentReminder {
    private final String uid;
    private final OptionalNullable<Integer> relativeScheduledDays;
    private final OptionalNullable<String> message;
    private final String status;
    private final String sentAt;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  relativeScheduledDays  Integer value for relativeScheduledDays.
     * @param  message  String value for message.
     * @param  status  String value for status.
     * @param  sentAt  String value for sentAt.
     */
    @JsonCreator
    public InvoicePaymentReminder(
            @JsonProperty("uid") String uid,
            @JsonProperty("relative_scheduled_days") Integer relativeScheduledDays,
            @JsonProperty("message") String message,
            @JsonProperty("status") String status,
            @JsonProperty("sent_at") String sentAt) {
        this.uid = uid;
        this.relativeScheduledDays = OptionalNullable.of(relativeScheduledDays);
        this.message = OptionalNullable.of(message);
        this.status = status;
        this.sentAt = sentAt;
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  relativeScheduledDays  Integer value for relativeScheduledDays.
     * @param  message  String value for message.
     * @param  status  String value for status.
     * @param  sentAt  String value for sentAt.
     */
    protected InvoicePaymentReminder(
            String uid,
            OptionalNullable<Integer> relativeScheduledDays,
            OptionalNullable<String> message,
            String status,
            String sentAt) {
        this.uid = uid;
        this.relativeScheduledDays = relativeScheduledDays;
        this.message = message;
        this.status = status;
        this.sentAt = sentAt;
    }

    /**
     * Getter for Uid.
     * A Square-assigned ID that uniquely identifies the reminder within the
     * `InvoicePaymentRequest`.
     * @return Returns the String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUid() {
        return uid;
    }

    /**
     * Internal Getter for RelativeScheduledDays.
     * The number of days before (a negative number) or after (a positive number) the payment
     * request `due_date` when the reminder is sent. For example, -3 indicates that the reminder
     * should be sent 3 days before the payment request `due_date`.
     * @return Returns the Internal Integer
     */
    @JsonGetter("relative_scheduled_days")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetRelativeScheduledDays() {
        return this.relativeScheduledDays;
    }

    /**
     * Getter for RelativeScheduledDays.
     * The number of days before (a negative number) or after (a positive number) the payment
     * request `due_date` when the reminder is sent. For example, -3 indicates that the reminder
     * should be sent 3 days before the payment request `due_date`.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getRelativeScheduledDays() {
        return OptionalNullable.getFrom(relativeScheduledDays);
    }

    /**
     * Internal Getter for Message.
     * The reminder message.
     * @return Returns the Internal String
     */
    @JsonGetter("message")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMessage() {
        return this.message;
    }

    /**
     * Getter for Message.
     * The reminder message.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMessage() {
        return OptionalNullable.getFrom(message);
    }

    /**
     * Getter for Status.
     * The status of a payment request reminder.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for SentAt.
     * If sent, the timestamp when the reminder was sent, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("sent_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSentAt() {
        return sentAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, relativeScheduledDays, message, status, sentAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvoicePaymentReminder)) {
            return false;
        }
        InvoicePaymentReminder other = (InvoicePaymentReminder) obj;
        return Objects.equals(uid, other.uid)
                && Objects.equals(relativeScheduledDays, other.relativeScheduledDays)
                && Objects.equals(message, other.message)
                && Objects.equals(status, other.status)
                && Objects.equals(sentAt, other.sentAt);
    }

    /**
     * Converts this InvoicePaymentReminder into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoicePaymentReminder [" + "uid=" + uid + ", relativeScheduledDays="
                + relativeScheduledDays + ", message=" + message + ", status=" + status
                + ", sentAt=" + sentAt + "]";
    }

    /**
     * Builds a new {@link InvoicePaymentReminder.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoicePaymentReminder.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().uid(getUid()).status(getStatus()).sentAt(getSentAt());
        builder.relativeScheduledDays = internalGetRelativeScheduledDays();
        builder.message = internalGetMessage();
        return builder;
    }

    /**
     * Class to build instances of {@link InvoicePaymentReminder}.
     */
    public static class Builder {
        private String uid;
        private OptionalNullable<Integer> relativeScheduledDays;
        private OptionalNullable<String> message;
        private String status;
        private String sentAt;

        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for relativeScheduledDays.
         * @param  relativeScheduledDays  Integer value for relativeScheduledDays.
         * @return Builder
         */
        public Builder relativeScheduledDays(Integer relativeScheduledDays) {
            this.relativeScheduledDays = OptionalNullable.of(relativeScheduledDays);
            return this;
        }

        /**
         * UnSetter for relativeScheduledDays.
         * @return Builder
         */
        public Builder unsetRelativeScheduledDays() {
            relativeScheduledDays = null;
            return this;
        }

        /**
         * Setter for message.
         * @param  message  String value for message.
         * @return Builder
         */
        public Builder message(String message) {
            this.message = OptionalNullable.of(message);
            return this;
        }

        /**
         * UnSetter for message.
         * @return Builder
         */
        public Builder unsetMessage() {
            message = null;
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
         * Setter for sentAt.
         * @param  sentAt  String value for sentAt.
         * @return Builder
         */
        public Builder sentAt(String sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        /**
         * Builds a new {@link InvoicePaymentReminder} object using the set fields.
         * @return {@link InvoicePaymentReminder}
         */
        public InvoicePaymentReminder build() {
            return new InvoicePaymentReminder(uid, relativeScheduledDays, message, status, sentAt);
        }
    }
}
