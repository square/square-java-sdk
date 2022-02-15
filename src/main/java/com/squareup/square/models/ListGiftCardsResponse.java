
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListGiftCardsResponse type.
 */
public class ListGiftCardsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<GiftCard> giftCards;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  giftCards  List of GiftCard value for giftCards.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListGiftCardsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("gift_cards") List<GiftCard> giftCards,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.giftCards = giftCards;
        this.cursor = cursor;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for GiftCards.
     * The requested gift cards or an empty object if none are found.
     * @return Returns the List of GiftCard
     */
    @JsonGetter("gift_cards")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<GiftCard> getGiftCards() {
        return giftCards;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can use in a subsequent request
     * to retrieve the next set of gift cards. If a cursor is not present, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, giftCards, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListGiftCardsResponse)) {
            return false;
        }
        ListGiftCardsResponse other = (ListGiftCardsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(giftCards, other.giftCards)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListGiftCardsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListGiftCardsResponse [" + "errors=" + errors + ", giftCards=" + giftCards
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListGiftCardsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListGiftCardsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .giftCards(getGiftCards())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListGiftCardsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<GiftCard> giftCards;
        private String cursor;



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
         * Setter for giftCards.
         * @param  giftCards  List of GiftCard value for giftCards.
         * @return Builder
         */
        public Builder giftCards(List<GiftCard> giftCards) {
            this.giftCards = giftCards;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListGiftCardsResponse} object using the set fields.
         * @return {@link ListGiftCardsResponse}
         */
        public ListGiftCardsResponse build() {
            ListGiftCardsResponse model =
                    new ListGiftCardsResponse(errors, giftCards, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
