
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
 * This is a model class for ListCardsResponse type.
 */
public class ListCardsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Card> cards;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  cards  List of Card value for cards.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListCardsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("cards") List<Card> cards,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.cards = cards;
        this.cursor = cursor;
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
     * Getter for Cards.
     * The requested list of `Card`s.
     * @return Returns the List of Card
     */
    @JsonGetter("cards")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, cards, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCardsResponse)) {
            return false;
        }
        ListCardsResponse other = (ListCardsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(cards, other.cards)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListCardsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCardsResponse [" + "errors=" + errors + ", cards=" + cards + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link ListCardsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCardsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .cards(getCards())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCardsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Card> cards;
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
         * Setter for cards.
         * @param  cards  List of Card value for cards.
         * @return Builder
         */
        public Builder cards(List<Card> cards) {
            this.cards = cards;
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
         * Builds a new {@link ListCardsResponse} object using the set fields.
         * @return {@link ListCardsResponse}
         */
        public ListCardsResponse build() {
            ListCardsResponse model =
                    new ListCardsResponse(errors, cards, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
