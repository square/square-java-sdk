package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListTimecardEventsResponse {

    @JsonCreator
    public V1ListTimecardEventsResponse(
            @JsonProperty("items") List<V1TimecardEvent> items) {
        this.items = items;
    }

    private final List<V1TimecardEvent> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListTimecardEventsResponse)) {
            return false;
        }
        V1ListTimecardEventsResponse v1ListTimecardEventsResponse = (V1ListTimecardEventsResponse) o;
        return Objects.equals(items, v1ListTimecardEventsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1TimecardEvent> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1TimecardEvent> items;

        public Builder() { }

        public Builder items(List<V1TimecardEvent> value) {
            items = value;
            return this;
        }

        public V1ListTimecardEventsResponse build() {
            return new V1ListTimecardEventsResponse(items);
        }
    }
}
