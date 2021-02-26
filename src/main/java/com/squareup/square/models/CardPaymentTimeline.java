
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CardPaymentTimeline type.
 */
public class CardPaymentTimeline {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String authorizedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String capturedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String voidedAt;

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
        this.authorizedAt = authorizedAt;
        this.capturedAt = capturedAt;
        this.voidedAt = voidedAt;
    }

    /**
     * Getter for AuthorizedAt.
     * The timestamp when the payment was authorized, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("authorized_at")
    public String getAuthorizedAt() {
        return authorizedAt;
    }

    /**
     * Getter for CapturedAt.
     * The timestamp when the payment was captured, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("captured_at")
    public String getCapturedAt() {
        return capturedAt;
    }

    /**
     * Getter for VoidedAt.
     * The timestamp when the payment was voided, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("voided_at")
    public String getVoidedAt() {
        return voidedAt;
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
        Builder builder = new Builder()
                .authorizedAt(getAuthorizedAt())
                .capturedAt(getCapturedAt())
                .voidedAt(getVoidedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link CardPaymentTimeline}.
     */
    public static class Builder {
        private String authorizedAt;
        private String capturedAt;
        private String voidedAt;



        /**
         * Setter for authorizedAt.
         * @param  authorizedAt  String value for authorizedAt.
         * @return Builder
         */
        public Builder authorizedAt(String authorizedAt) {
            this.authorizedAt = authorizedAt;
            return this;
        }

        /**
         * Setter for capturedAt.
         * @param  capturedAt  String value for capturedAt.
         * @return Builder
         */
        public Builder capturedAt(String capturedAt) {
            this.capturedAt = capturedAt;
            return this;
        }

        /**
         * Setter for voidedAt.
         * @param  voidedAt  String value for voidedAt.
         * @return Builder
         */
        public Builder voidedAt(String voidedAt) {
            this.voidedAt = voidedAt;
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
