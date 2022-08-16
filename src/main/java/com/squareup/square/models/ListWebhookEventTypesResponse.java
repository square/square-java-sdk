
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
 * This is a model class for ListWebhookEventTypesResponse type.
 */
public class ListWebhookEventTypesResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<String> eventTypes;
    private final List<EventTypeMetadata> metadata;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  eventTypes  List of String value for eventTypes.
     * @param  metadata  List of EventTypeMetadata value for metadata.
     */
    @JsonCreator
    public ListWebhookEventTypesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("event_types") List<String> eventTypes,
            @JsonProperty("metadata") List<EventTypeMetadata> metadata) {
        this.errors = errors;
        this.eventTypes = eventTypes;
        this.metadata = metadata;
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
     * Getter for EventTypes.
     * The list of event types.
     * @return Returns the List of String
     */
    @JsonGetter("event_types")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getEventTypes() {
        return eventTypes;
    }

    /**
     * Getter for Metadata.
     * Contains the metadata of a webhook event type. For more information, see
     * [EventTypeMetadata]($m/EventTypeMetadata).
     * @return Returns the List of EventTypeMetadata
     */
    @JsonGetter("metadata")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<EventTypeMetadata> getMetadata() {
        return metadata;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, eventTypes, metadata);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListWebhookEventTypesResponse)) {
            return false;
        }
        ListWebhookEventTypesResponse other = (ListWebhookEventTypesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(eventTypes, other.eventTypes)
            && Objects.equals(metadata, other.metadata);
    }

    /**
     * Converts this ListWebhookEventTypesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListWebhookEventTypesResponse [" + "errors=" + errors + ", eventTypes=" + eventTypes
                + ", metadata=" + metadata + "]";
    }

    /**
     * Builds a new {@link ListWebhookEventTypesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListWebhookEventTypesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .eventTypes(getEventTypes())
                .metadata(getMetadata());
        return builder;
    }

    /**
     * Class to build instances of {@link ListWebhookEventTypesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<String> eventTypes;
        private List<EventTypeMetadata> metadata;



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
         * Setter for eventTypes.
         * @param  eventTypes  List of String value for eventTypes.
         * @return Builder
         */
        public Builder eventTypes(List<String> eventTypes) {
            this.eventTypes = eventTypes;
            return this;
        }

        /**
         * Setter for metadata.
         * @param  metadata  List of EventTypeMetadata value for metadata.
         * @return Builder
         */
        public Builder metadata(List<EventTypeMetadata> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Builds a new {@link ListWebhookEventTypesResponse} object using the set fields.
         * @return {@link ListWebhookEventTypesResponse}
         */
        public ListWebhookEventTypesResponse build() {
            ListWebhookEventTypesResponse model =
                    new ListWebhookEventTypesResponse(errors, eventTypes, metadata);
            model.httpContext = httpContext;
            return model;
        }
    }
}
