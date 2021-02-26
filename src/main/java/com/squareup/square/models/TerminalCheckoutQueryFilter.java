
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalCheckoutQueryFilter type.
 */
public class TerminalCheckoutQueryFilter {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String deviceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TimeRange createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;

    /**
     * Initialization constructor.
     * @param  deviceId  String value for deviceId.
     * @param  createdAt  TimeRange value for createdAt.
     * @param  status  String value for status.
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

    /**
     * Getter for DeviceId.
     * `TerminalCheckout`s associated with a specific device. If no device is specified then all
     * `TerminalCheckout`s for the merchant will be displayed.
     * @return Returns the String
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Getter for CreatedAt.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("created_at")
    public TimeRange getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for Status.
     * Filtered results with the desired status of the `TerminalCheckout` Options: PENDING,
     * IN_PROGRESS, CANCELED, COMPLETED
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, createdAt, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TerminalCheckoutQueryFilter)) {
            return false;
        }
        TerminalCheckoutQueryFilter other = (TerminalCheckoutQueryFilter) obj;
        return Objects.equals(deviceId, other.deviceId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this TerminalCheckoutQueryFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalCheckoutQueryFilter [" + "deviceId=" + deviceId + ", createdAt=" + createdAt
                + ", status=" + status + "]";
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
     * Class to build instances of {@link TerminalCheckoutQueryFilter}.
     */
    public static class Builder {
        private String deviceId;
        private TimeRange createdAt;
        private String status;



        /**
         * Setter for deviceId.
         * @param  deviceId  String value for deviceId.
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  TimeRange value for createdAt.
         * @return Builder
         */
        public Builder createdAt(TimeRange createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
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
            return new TerminalCheckoutQueryFilter(deviceId, createdAt, status);
        }
    }
}
