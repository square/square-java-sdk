
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CardPaymentTimeline type.
 */
public class CardPaymentTimeline {
    private final OptionalNullable<String> authorizedAt;
    private final OptionalNullable<String> capturedAt;
    private final OptionalNullable<String> voidedAt;

    /**
     * Initialization constructor.
     * @param  authorizedAt  String value for authorizedAt.
     * @param  capturedAt  String value for capturedAt.
     * @param  voidedAt  String value for voidedAt.
     */
    @JsonCreator
    public CardPaymentTimeline(
            @JsonProperty("authorized_at") String authorizedAt,
            @JsonProperty("captured_at") String capturedAt,
            @JsonProperty("voided_at") String voidedAt) {
        this.authorizedAt = OptionalNullable.of(authorizedAt);
        this.capturedAt = OptionalNullable.of(capturedAt);
        this.voidedAt = OptionalNullable.of(voidedAt);
    }

    /**
     * Internal initialization constructor.
     */
    protected CardPaymentTimeline(OptionalNullable<String> authorizedAt,
            OptionalNullable<String> capturedAt, OptionalNullable<String> voidedAt) {
        this.authorizedAt = authorizedAt;
        this.capturedAt = capturedAt;
        this.voidedAt = voidedAt;
    }

    /**
     * Internal Getter for AuthorizedAt.
     * The timestamp when the payment was authorized, in RFC 3339 format.
     * @return Returns the Internal String
     */
    @JsonGetter("authorized_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAuthorizedAt() {
        return this.authorizedAt;
    }

    /**
     * Getter for AuthorizedAt.
     * The timestamp when the payment was authorized, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAuthorizedAt() {
        return OptionalNullable.getFrom(authorizedAt);
    }

    /**
     * Internal Getter for CapturedAt.
     * The timestamp when the payment was captured, in RFC 3339 format.
     * @return Returns the Internal String
     */
    @JsonGetter("captured_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCapturedAt() {
        return this.capturedAt;
    }

    /**
     * Getter for CapturedAt.
     * The timestamp when the payment was captured, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCapturedAt() {
        return OptionalNullable.getFrom(capturedAt);
    }

    /**
     * Internal Getter for VoidedAt.
     * The timestamp when the payment was voided, in RFC 3339 format.
     * @return Returns the Internal String
     */
    @JsonGetter("voided_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetVoidedAt() {
        return this.voidedAt;
    }

    /**
     * Getter for VoidedAt.
     * The timestamp when the payment was voided, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getVoidedAt() {
        return OptionalNullable.getFrom(voidedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorizedAt, capturedAt, voidedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardPaymentTimeline)) {
            return false;
        }
        CardPaymentTimeline other = (CardPaymentTimeline) obj;
        return Objects.equals(authorizedAt, other.authorizedAt)
            && Objects.equals(capturedAt, other.capturedAt)
            && Objects.equals(voidedAt, other.voidedAt);
    }

    /**
     * Converts this CardPaymentTimeline into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CardPaymentTimeline [" + "authorizedAt=" + authorizedAt + ", capturedAt="
                + capturedAt + ", voidedAt=" + voidedAt + "]";
    }

    /**
     * Builds a new {@link CardPaymentTimeline.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CardPaymentTimeline.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.authorizedAt = internalGetAuthorizedAt();
        builder.capturedAt = internalGetCapturedAt();
        builder.voidedAt = internalGetVoidedAt();
        return builder;
    }

    /**
     * Class to build instances of {@link CardPaymentTimeline}.
     */
    public static class Builder {
        private OptionalNullable<String> authorizedAt;
        private OptionalNullable<String> capturedAt;
        private OptionalNullable<String> voidedAt;



        /**
         * Setter for authorizedAt.
         * @param  authorizedAt  String value for authorizedAt.
         * @return Builder
         */
        public Builder authorizedAt(String authorizedAt) {
            this.authorizedAt = OptionalNullable.of(authorizedAt);
            return this;
        }

        /**
         * UnSetter for authorizedAt.
         * @return Builder
         */
        public Builder unsetAuthorizedAt() {
            authorizedAt = null;
            return this;
        }

        /**
         * Setter for capturedAt.
         * @param  capturedAt  String value for capturedAt.
         * @return Builder
         */
        public Builder capturedAt(String capturedAt) {
            this.capturedAt = OptionalNullable.of(capturedAt);
            return this;
        }

        /**
         * UnSetter for capturedAt.
         * @return Builder
         */
        public Builder unsetCapturedAt() {
            capturedAt = null;
            return this;
        }

        /**
         * Setter for voidedAt.
         * @param  voidedAt  String value for voidedAt.
         * @return Builder
         */
        public Builder voidedAt(String voidedAt) {
            this.voidedAt = OptionalNullable.of(voidedAt);
            return this;
        }

        /**
         * UnSetter for voidedAt.
         * @return Builder
         */
        public Builder unsetVoidedAt() {
            voidedAt = null;
            return this;
        }

        /**
         * Builds a new {@link CardPaymentTimeline} object using the set fields.
         * @return {@link CardPaymentTimeline}
         */
        public CardPaymentTimeline build() {
            return new CardPaymentTimeline(authorizedAt, capturedAt, voidedAt);
        }
    }
}
