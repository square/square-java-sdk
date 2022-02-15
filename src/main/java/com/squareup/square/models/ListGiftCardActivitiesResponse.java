
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
 * This is a model class for ListGiftCardActivitiesResponse type.
 */
public class ListGiftCardActivitiesResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<GiftCardActivity> giftCardActivities;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  giftCardActivities  List of GiftCardActivity value for giftCardActivities.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListGiftCardActivitiesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("gift_card_activities") List<GiftCardActivity> giftCardActivities,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.giftCardActivities = giftCardActivities;
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
     * Getter for GiftCardActivities.
     * The requested gift card activities or an empty object if none are found.
     * @return Returns the List of GiftCardActivity
     */
    @JsonGetter("gift_card_activities")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<GiftCardActivity> getGiftCardActivities() {
        return giftCardActivities;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can use in a subsequent request
     * to retrieve the next set of activities. If a cursor is not present, this is the final
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
        return Objects.hash(errors, giftCardActivities, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListGiftCardActivitiesResponse)) {
            return false;
        }
        ListGiftCardActivitiesResponse other = (ListGiftCardActivitiesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(giftCardActivities, other.giftCardActivities)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListGiftCardActivitiesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListGiftCardActivitiesResponse [" + "errors=" + errors + ", giftCardActivities="
                + giftCardActivities + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListGiftCardActivitiesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListGiftCardActivitiesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .giftCardActivities(getGiftCardActivities())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListGiftCardActivitiesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<GiftCardActivity> giftCardActivities;
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
         * Setter for giftCardActivities.
         * @param  giftCardActivities  List of GiftCardActivity value for giftCardActivities.
         * @return Builder
         */
        public Builder giftCardActivities(List<GiftCardActivity> giftCardActivities) {
            this.giftCardActivities = giftCardActivities;
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
         * Builds a new {@link ListGiftCardActivitiesResponse} object using the set fields.
         * @return {@link ListGiftCardActivitiesResponse}
         */
        public ListGiftCardActivitiesResponse build() {
            ListGiftCardActivitiesResponse model =
                    new ListGiftCardActivitiesResponse(errors, giftCardActivities, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
