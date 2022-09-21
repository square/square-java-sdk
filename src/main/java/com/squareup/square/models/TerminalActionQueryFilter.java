
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalActionQueryFilter type.
 */
public class TerminalActionQueryFilter {
    private final String deviceId;
    private final TimeRange createdAt;
    private final String status;
    private final String type;

    /**
     * Initialization constructor.
     * @param  deviceId  String value for deviceId.
     * @param  createdAt  TimeRange value for createdAt.
     * @param  status  String value for status.
     * @param  type  String value for type.
     */
    @JsonCreator
    public TerminalActionQueryFilter(
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("created_at") TimeRange createdAt,
            @JsonProperty("status") String status,
            @JsonProperty("type") String type) {
        this.deviceId = deviceId;
        this.createdAt = createdAt;
        this.status = status;
        this.type = type;
    }

    /**
     * Getter for DeviceId.
     * `TerminalAction`s associated with a specific device. If no device is specified then all
     * `TerminalAction`s for the merchant will be displayed.
     * @return Returns the String
     */
    @JsonGetter("device_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TimeRange getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for Status.
     * Filter results with the desired status of the `TerminalAction` Options: `PENDING`,
     * `IN_PROGRESS`, `CANCEL_REQUESTED`, `CANCELED`, `COMPLETED`
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for Type.
     * Describes the type of this unit and indicates which field contains the unit information. This
     * is an ‘open’ enum.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, createdAt, status, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TerminalActionQueryFilter)) {
            return false;
        }
        TerminalActionQueryFilter other = (TerminalActionQueryFilter) obj;
        return Objects.equals(deviceId, other.deviceId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(status, other.status)
            && Objects.equals(type, other.type);
    }

    /**
     * Converts this TerminalActionQueryFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalActionQueryFilter [" + "deviceId=" + deviceId + ", createdAt=" + createdAt
                + ", status=" + status + ", type=" + type + "]";
    }

    /**
     * Builds a new {@link TerminalActionQueryFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalActionQueryFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .deviceId(getDeviceId())
                .createdAt(getCreatedAt())
                .status(getStatus())
                .type(getType());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalActionQueryFilter}.
     */
    public static class Builder {
        private String deviceId;
        private TimeRange createdAt;
        private String status;
        private String type;



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
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds a new {@link TerminalActionQueryFilter} object using the set fields.
         * @return {@link TerminalActionQueryFilter}
         */
        public TerminalActionQueryFilter build() {
            return new TerminalActionQueryFilter(deviceId, createdAt, status, type);
        }
    }
}
