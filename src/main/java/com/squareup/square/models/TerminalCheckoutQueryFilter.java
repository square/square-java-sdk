package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for TerminalCheckoutQueryFilter type.
 */
public class TerminalCheckoutQueryFilter {

    /**
     * Initialization constructor.
     * @param deviceId
     * @param createdAt
     * @param status
     */
    @JsonCreator
    public TerminalCheckoutQueryFilter(
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("created_at") TimeRange createdAt,
            @JsonProperty("status") String status) {
        this.deviceId = deviceId;
        this.createdAt = createdAt;
        this.status = status;
    }

    private final String deviceId;
    private final TimeRange createdAt;
    private final String status;
    /**
     * Getter for DeviceId.
     * `TerminalCheckout`s associated with a specific device. If no device is specified then all
     * `TerminalCheckout`s for the merchant will be displayed.
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for CreatedAt.
     * Represents a generic time range. The start and end values are
     * represented in RFC 3339 format. Time ranges are customized to be
     * inclusive or exclusive based on the needs of a particular endpoint.
     * Refer to the relevant endpoint-specific documentation to determine
     * how time ranges are handled.
     */
    @JsonGetter("created_at")
    public TimeRange getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for Status.
     * Filtered results with the desired status of the `TerminalCheckout`
     * Options: PENDING, IN\_PROGRESS, CANCELED, COMPLETED
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(deviceId, createdAt, status);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof TerminalCheckoutQueryFilter)) {
            return false;
        }
        TerminalCheckoutQueryFilter terminalCheckoutQueryFilter = (TerminalCheckoutQueryFilter) obj;
        return Objects.equals(deviceId, terminalCheckoutQueryFilter.deviceId) &&
            Objects.equals(createdAt, terminalCheckoutQueryFilter.createdAt) &&
            Objects.equals(status, terminalCheckoutQueryFilter.status);
    }

    /**
     * Builds a new {@link TerminalCheckoutQueryFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalCheckoutQueryFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .deviceId(getDeviceId())
            .createdAt(getCreatedAt())
            .status(getStatus());
            return builder;
    }

    /**
     * Class to build instances of {@link TerminalCheckoutQueryFilter}
     */
    public static class Builder {
        private String deviceId;
        private TimeRange createdAt;
        private String status;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for deviceId
         * @param deviceId
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(TimeRange createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link TerminalCheckoutQueryFilter} object using the set fields.
         * @return {@link TerminalCheckoutQueryFilter}
         */
        public TerminalCheckoutQueryFilter build() {
            return new TerminalCheckoutQueryFilter(deviceId,
                createdAt,
                status);
        }
    }
}
