
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Objects;

/**
 * This is a model class for CreateCardRequest type.
 */
public class CreateCardRequest {
    private final String idempotencyKey;
    private final String sourceId;
    private final String verificationToken;
    private final Card card;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  sourceId  String value for sourceId.
     * @param  card  Card value for card.
     * @param  verificationToken  String value for verificationToken.
     */
    @JsonCreator
    public CreateCardRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("source_id") String sourceId,
            @JsonProperty("card") Card card,
            @JsonProperty("verification_token") String verificationToken) {
        this.idempotencyKey = idempotencyKey;
        this.sourceId = sourceId;
        this.verificationToken = verificationToken;
        this.card = card;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this CreateCard request. Keys can be any valid string and
     * must be unique for every request. Max: 45 characters See [Idempotency
     * keys](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency) for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for SourceId.
     * The ID of the source which represents the card information to be stored. This can be a card
     * nonce or a payment id.
     * @return Returns the String
     */
    @JsonGetter("source_id")
    public String getSourceId() {
        return sourceId;
    }

    /**
     * Getter for VerificationToken.
     * An identifying token generated by
     * [Payments.verifyBuyer()](https://developer.squareup.com/reference/sdks/web/payments/objects/Payments#Payments.verifyBuyer).
     * Verification tokens encapsulate customer device information and 3-D Secure challenge results
     * to indicate that Square has verified the buyer identity. See the [SCA
     * Overview](https://developer.squareup.com/docs/sca-overview).
     * @return Returns the String
     */
    @JsonGetter("verification_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getVerificationToken() {
        return verificationToken;
    }

    /**
     * Getter for Card.
     * Represents the payment details of a card to be used for payments. These details are
     * determined by the payment token generated by Web Payments SDK.
     * @return Returns the Card
     */
    @JsonGetter("card")
    public Card getCard() {
        return card;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, sourceId, verificationToken, card);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCardRequest)) {
            return false;
        }
        CreateCardRequest other = (CreateCardRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(sourceId, other.sourceId)
            && Objects.equals(verificationToken, other.verificationToken)
            && Objects.equals(card, other.card);
    }

    /**
     * Converts this CreateCardRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateCardRequest [" + "idempotencyKey=" + idempotencyKey + ", sourceId=" + sourceId
                + ", card=" + card + ", verificationToken=" + verificationToken + "]";
    }

    /**
     * Builds a new {@link CreateCardRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCardRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, sourceId, card)
                .verificationToken(getVerificationToken());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCardRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String sourceId;
        private Card card;
        private String verificationToken;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  sourceId  String value for sourceId.
         * @param  card  Card value for card.
         */
        public Builder(String idempotencyKey, String sourceId, Card card) {
            this.idempotencyKey = idempotencyKey;
            this.sourceId = sourceId;
            this.card = card;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for sourceId.
         * @param  sourceId  String value for sourceId.
         * @return Builder
         */
        public Builder sourceId(String sourceId) {
            this.sourceId = sourceId;
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
         * Setter for verificationToken.
         * @param  verificationToken  String value for verificationToken.
         * @return Builder
         */
        public Builder verificationToken(String verificationToken) {
            this.verificationToken = verificationToken;
            return this;
        }

        /**
         * Builds a new {@link CreateCardRequest} object using the set fields.
         * @return {@link CreateCardRequest}
         */
        public CreateCardRequest build() {
            return new CreateCardRequest(idempotencyKey, sourceId, card, verificationToken);
        }
    }
}
