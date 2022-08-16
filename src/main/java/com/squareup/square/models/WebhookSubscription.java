
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for WebhookSubscription type.
 */
public class WebhookSubscription {
    private final String id;
    private final String name;
    private final Boolean enabled;
    private final List<String> eventTypes;
    private final String notificationUrl;
    private final String apiVersion;
    private final String signatureKey;
    private final String createdAt;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  name  String value for name.
     * @param  enabled  Boolean value for enabled.
     * @param  eventTypes  List of String value for eventTypes.
     * @param  notificationUrl  String value for notificationUrl.
     * @param  apiVersion  String value for apiVersion.
     * @param  signatureKey  String value for signatureKey.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public WebhookSubscription(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("enabled") Boolean enabled,
            @JsonProperty("event_types") List<String> eventTypes,
            @JsonProperty("notification_url") String notificationUrl,
            @JsonProperty("api_version") String apiVersion,
            @JsonProperty("signature_key") String signatureKey,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
        this.eventTypes = eventTypes;
        this.notificationUrl = notificationUrl;
        this.apiVersion = apiVersion;
        this.signatureKey = signatureKey;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for Id.
     * A Square-generated unique ID for the subscription.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Name.
     * The name of this subscription.
     * @return Returns the String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    /**
     * Getter for Enabled.
     * Indicates whether the subscription is enabled (`true`) or not (`false`).
     * @return Returns the Boolean
     */
    @JsonGetter("enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Getter for EventTypes.
     * The event types associated with this subscription.
     * @return Returns the List of String
     */
    @JsonGetter("event_types")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getEventTypes() {
        return eventTypes;
    }

    /**
     * Getter for NotificationUrl.
     * The URL to which webhooks are sent.
     * @return Returns the String
     */
    @JsonGetter("notification_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNotificationUrl() {
        return notificationUrl;
    }

    /**
     * Getter for ApiVersion.
     * The API version of the subscription. This field is optional for `CreateWebhookSubscription`.
     * The value defaults to the API version used by the application.
     * @return Returns the String
     */
    @JsonGetter("api_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Getter for SignatureKey.
     * The Square-generated signature key used to validate the origin of the webhook event.
     * @return Returns the String
     */
    @JsonGetter("signature_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSignatureKey() {
        return signatureKey;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp of when the subscription was created, in RFC 3339 format. For example,
     * "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp of when the subscription was last updated, in RFC 3339 format. For example,
     * "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, enabled, eventTypes, notificationUrl, apiVersion,
                signatureKey, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebhookSubscription)) {
            return false;
        }
        WebhookSubscription other = (WebhookSubscription) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(enabled, other.enabled)
            && Objects.equals(eventTypes, other.eventTypes)
            && Objects.equals(notificationUrl, other.notificationUrl)
            && Objects.equals(apiVersion, other.apiVersion)
            && Objects.equals(signatureKey, other.signatureKey)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this WebhookSubscription into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "WebhookSubscription [" + "id=" + id + ", name=" + name + ", enabled=" + enabled
                + ", eventTypes=" + eventTypes + ", notificationUrl=" + notificationUrl
                + ", apiVersion=" + apiVersion + ", signatureKey=" + signatureKey + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link WebhookSubscription.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link WebhookSubscription.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .name(getName())
                .enabled(getEnabled())
                .eventTypes(getEventTypes())
                .notificationUrl(getNotificationUrl())
                .apiVersion(getApiVersion())
                .signatureKey(getSignatureKey())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link WebhookSubscription}.
     */
    public static class Builder {
        private String id;
        private String name;
        private Boolean enabled;
        private List<String> eventTypes;
        private String notificationUrl;
        private String apiVersion;
        private String signatureKey;
        private String createdAt;
        private String updatedAt;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for enabled.
         * @param  enabled  Boolean value for enabled.
         * @return Builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
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
         * Setter for notificationUrl.
         * @param  notificationUrl  String value for notificationUrl.
         * @return Builder
         */
        public Builder notificationUrl(String notificationUrl) {
            this.notificationUrl = notificationUrl;
            return this;
        }

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
         * Setter for signatureKey.
         * @param  signatureKey  String value for signatureKey.
         * @return Builder
         */
        public Builder signatureKey(String signatureKey) {
            this.signatureKey = signatureKey;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link WebhookSubscription} object using the set fields.
         * @return {@link WebhookSubscription}
         */
        public WebhookSubscription build() {
            return new WebhookSubscription(id, name, enabled, eventTypes, notificationUrl,
                    apiVersion, signatureKey, createdAt, updatedAt);
        }
    }
}
