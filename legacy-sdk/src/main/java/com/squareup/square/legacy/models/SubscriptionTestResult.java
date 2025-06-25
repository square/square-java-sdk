package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for SubscriptionTestResult type.
 */
public class SubscriptionTestResult {
    private final String id;
    private final OptionalNullable<Integer> statusCode;
    private final OptionalNullable<String> payload;
    private final String createdAt;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  statusCode  Integer value for statusCode.
     * @param  payload  String value for payload.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public SubscriptionTestResult(
            @JsonProperty("id") String id,
            @JsonProperty("status_code") Integer statusCode,
            @JsonProperty("payload") String payload,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.statusCode = OptionalNullable.of(statusCode);
        this.payload = OptionalNullable.of(payload);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  statusCode  Integer value for statusCode.
     * @param  payload  String value for payload.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    protected SubscriptionTestResult(
            String id,
            OptionalNullable<Integer> statusCode,
            OptionalNullable<String> payload,
            String createdAt,
            String updatedAt) {
        this.id = id;
        this.statusCode = statusCode;
        this.payload = payload;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for Id.
     * A Square-generated unique ID for the subscription test result.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for StatusCode.
     * The status code returned by the subscription notification URL.
     * @return Returns the Internal Integer
     */
    @JsonGetter("status_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetStatusCode() {
        return this.statusCode;
    }

    /**
     * Getter for StatusCode.
     * The status code returned by the subscription notification URL.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getStatusCode() {
        return OptionalNullable.getFrom(statusCode);
    }

    /**
     * Internal Getter for Payload.
     * An object containing the payload of the test event. For example, a `payment.created` event.
     * @return Returns the Internal String
     */
    @JsonGetter("payload")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPayload() {
        return this.payload;
    }

    /**
     * Getter for Payload.
     * An object containing the payload of the test event. For example, a `payment.created` event.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPayload() {
        return OptionalNullable.getFrom(payload);
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
     * The timestamp of when the subscription was updated, in RFC 3339 format. For example,
     * "2016-09-04T23:59:33.123Z". Because a subscription test result is unique, this field is the
     * same as the `created_at` field.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusCode, payload, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionTestResult)) {
            return false;
        }
        SubscriptionTestResult other = (SubscriptionTestResult) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(statusCode, other.statusCode)
                && Objects.equals(payload, other.payload)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this SubscriptionTestResult into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionTestResult [" + "id=" + id + ", statusCode=" + statusCode + ", payload=" + payload
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link SubscriptionTestResult.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionTestResult.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().id(getId()).createdAt(getCreatedAt()).updatedAt(getUpdatedAt());
        builder.statusCode = internalGetStatusCode();
        builder.payload = internalGetPayload();
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionTestResult}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<Integer> statusCode;
        private OptionalNullable<String> payload;
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
         * Setter for statusCode.
         * @param  statusCode  Integer value for statusCode.
         * @return Builder
         */
        public Builder statusCode(Integer statusCode) {
            this.statusCode = OptionalNullable.of(statusCode);
            return this;
        }

        /**
         * UnSetter for statusCode.
         * @return Builder
         */
        public Builder unsetStatusCode() {
            statusCode = null;
            return this;
        }

        /**
         * Setter for payload.
         * @param  payload  String value for payload.
         * @return Builder
         */
        public Builder payload(String payload) {
            this.payload = OptionalNullable.of(payload);
            return this;
        }

        /**
         * UnSetter for payload.
         * @return Builder
         */
        public Builder unsetPayload() {
            payload = null;
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
         * Builds a new {@link SubscriptionTestResult} object using the set fields.
         * @return {@link SubscriptionTestResult}
         */
        public SubscriptionTestResult build() {
            return new SubscriptionTestResult(id, statusCode, payload, createdAt, updatedAt);
        }
    }
}
