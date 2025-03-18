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
 * This is a model class for SearchEventsResponse type.
 */
public class SearchEventsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Event> events;
    private final List<EventMetadata> metadata;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  events  List of Event value for events.
     * @param  metadata  List of EventMetadata value for metadata.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public SearchEventsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("events") List<Event> events,
            @JsonProperty("metadata") List<EventMetadata> metadata,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.events = events;
        this.metadata = metadata;
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
     * Getter for Events.
     * The list of [Event](entity:Event)s returned by the search.
     * @return Returns the List of Event
     */
    @JsonGetter("events")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Getter for Metadata.
     * Contains the metadata of an event. For more information, see [Event](entity:Event).
     * @return Returns the List of EventMetadata
     */
    @JsonGetter("metadata")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<EventMetadata> getMetadata() {
        return metadata;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can use in a subsequent request
     * to fetch the next set of events. If empty, this is the final response. For more information,
     * see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, events, metadata, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchEventsResponse)) {
            return false;
        }
        SearchEventsResponse other = (SearchEventsResponse) obj;
        return Objects.equals(errors, other.errors)
                && Objects.equals(events, other.events)
                && Objects.equals(metadata, other.metadata)
                && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchEventsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchEventsResponse [" + "errors=" + errors + ", events=" + events + ", metadata=" + metadata
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link SearchEventsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchEventsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .events(getEvents())
                .metadata(getMetadata())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchEventsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Event> events;
        private List<EventMetadata> metadata;
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
         * Setter for events.
         * @param  events  List of Event value for events.
         * @return Builder
         */
        public Builder events(List<Event> events) {
            this.events = events;
            return this;
        }

        /**
         * Setter for metadata.
         * @param  metadata  List of EventMetadata value for metadata.
         * @return Builder
         */
        public Builder metadata(List<EventMetadata> metadata) {
            this.metadata = metadata;
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
         * Builds a new {@link SearchEventsResponse} object using the set fields.
         * @return {@link SearchEventsResponse}
         */
        public SearchEventsResponse build() {
            SearchEventsResponse model = new SearchEventsResponse(errors, events, metadata, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
