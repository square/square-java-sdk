package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveCardResponse type.
 */
public class RetrieveCardResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Card card;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  card  Card value for card.
     */
    @JsonCreator
    public RetrieveCardResponse(@JsonProperty("errors") List<Error> errors, @JsonProperty("card") Card card) {
        this.errors = errors;
        this.card = card;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
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

    @Override
    public int hashCode() {
        return Objects.hash(errors, card);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCardResponse)) {
            return false;
        }
        RetrieveCardResponse other = (RetrieveCardResponse) obj;
        return Objects.equals(errors, other.errors) && Objects.equals(card, other.card);
    }

    /**
     * Converts this RetrieveCardResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveCardResponse [" + "errors=" + errors + ", card=" + card + "]";
    }

    /**
     * Builds a new {@link RetrieveCardResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCardResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors()).card(getCard());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCardResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Card card;

        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
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
         * Builds a new {@link RetrieveCardResponse} object using the set fields.
         * @return {@link RetrieveCardResponse}
         */
        public RetrieveCardResponse build() {
            RetrieveCardResponse model = new RetrieveCardResponse(errors, card);
            model.httpContext = httpContext;
            return model;
        }
    }
}
