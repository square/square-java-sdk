
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListWebhookEventTypesRequest type.
 */
public class ListWebhookEventTypesRequest {
    private final String apiVersion;

    /**
     * Initialization constructor.
     * @param  apiVersion  String value for apiVersion.
     */
    @JsonCreator
    public ListWebhookEventTypesRequest(
            @JsonProperty("api_version") String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Getter for ApiVersion.
     * The API version for which to list event types. Setting this field overrides the default
     * version used by the application.
     * @return Returns the String
     */
    @JsonGetter("api_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getApiVersion() {
        return apiVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListWebhookEventTypesRequest)) {
            return false;
        }
        ListWebhookEventTypesRequest other = (ListWebhookEventTypesRequest) obj;
        return Objects.equals(apiVersion, other.apiVersion);
    }

    /**
     * Converts this ListWebhookEventTypesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListWebhookEventTypesRequest [" + "apiVersion=" + apiVersion + "]";
    }

    /**
     * Builds a new {@link ListWebhookEventTypesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListWebhookEventTypesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .apiVersion(getApiVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link ListWebhookEventTypesRequest}.
     */
    public static class Builder {
        private String apiVersion;



        /**
         * Setter for apiVersion.
         * @param  apiVersion  String value for apiVersion.
         * @return Builder
         */
        public Builder apiVersion(String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        /**
         * Builds a new {@link ListWebhookEventTypesRequest} object using the set fields.
         * @return {@link ListWebhookEventTypesRequest}
         */
        public ListWebhookEventTypesRequest build() {
            return new ListWebhookEventTypesRequest(apiVersion);
        }
    }
}
