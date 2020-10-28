
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1ListTimecardEventsResponse type.
 */
public class V1ListTimecardEventsResponse {
    private final List<V1TimecardEvent> items;

    /**
     * Initialization constructor.
     * @param items List of V1TimecardEvent value for items.
     */
    @JsonCreator
    public V1ListTimecardEventsResponse(
            @JsonProperty("items") List<V1TimecardEvent> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1TimecardEvent
     */
    @JsonGetter("items")
    public List<V1TimecardEvent> getItems() {
        return this.items;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListTimecardEventsResponse)) {
            return false;
        }
        V1ListTimecardEventsResponse other = (V1ListTimecardEventsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Builds a new {@link V1ListTimecardEventsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListTimecardEventsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListTimecardEventsResponse}.
     */
    public static class Builder {
        private List<V1TimecardEvent> items;



        /**
         * Setter for items.
         * @param items List of V1TimecardEvent value for items.
         * @return Builder
         */
        public Builder items(List<V1TimecardEvent> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListTimecardEventsResponse} object using the set fields.
         * @return {@link V1ListTimecardEventsResponse}
         */
        public V1ListTimecardEventsResponse build() {
            return new V1ListTimecardEventsResponse(items);
        }
    }
}
