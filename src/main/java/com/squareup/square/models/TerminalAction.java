
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalAction type.
 */
public class TerminalAction {
    private final String id;
    private final String deviceId;
    private final String deadlineDuration;
    private final String status;
    private final String cancelReason;
    private final String createdAt;
    private final String updatedAt;
    private final String appId;
    private final String type;
    private final SaveCardOptions saveCardOptions;
    private final DeviceMetadata deviceMetadata;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  deviceId  String value for deviceId.
     * @param  deadlineDuration  String value for deadlineDuration.
     * @param  status  String value for status.
     * @param  cancelReason  String value for cancelReason.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  appId  String value for appId.
     * @param  type  String value for type.
     * @param  saveCardOptions  SaveCardOptions value for saveCardOptions.
     * @param  deviceMetadata  DeviceMetadata value for deviceMetadata.
     */
    @JsonCreator
    public TerminalAction(
            @JsonProperty("id") String id,
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("deadline_duration") String deadlineDuration,
            @JsonProperty("status") String status,
            @JsonProperty("cancel_reason") String cancelReason,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("app_id") String appId,
            @JsonProperty("type") String type,
            @JsonProperty("save_card_options") SaveCardOptions saveCardOptions,
            @JsonProperty("device_metadata") DeviceMetadata deviceMetadata) {
        this.id = id;
        this.deviceId = deviceId;
        this.deadlineDuration = deadlineDuration;
        this.status = status;
        this.cancelReason = cancelReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.appId = appId;
        this.type = type;
        this.saveCardOptions = saveCardOptions;
        this.deviceMetadata = deviceMetadata;
    }

    /**
     * Getter for Id.
     * A unique ID for this `TerminalAction`.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for DeviceId.
     * The unique Id of the device intended for this `TerminalAction`. The Id can be retrieved from
     * /v2/devices api.
     * @return Returns the String
     */
    @JsonGetter("device_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Getter for DeadlineDuration.
     * The duration as an RFC 3339 duration, after which the action will be automatically canceled.
     * TerminalActions that are `PENDING` will be automatically `CANCELED` and have a cancellation
     * reason of `TIMED_OUT` Default: 5 minutes from creation Maximum: 5 minutes
     * @return Returns the String
     */
    @JsonGetter("deadline_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDeadlineDuration() {
        return deadlineDuration;
    }

    /**
     * Getter for Status.
     * The status of the `TerminalAction`. Options: `PENDING`, `IN_PROGRESS`, `CANCELED`,
     * `COMPLETED`
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for CancelReason.
     * @return Returns the String
     */
    @JsonGetter("cancel_reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * Getter for CreatedAt.
     * The time when the `TerminalAction` was created as an RFC 3339 timestamp.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the `TerminalAction` was last updated as an RFC 3339 timestamp.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for AppId.
     * The ID of the application that created the action.
     * @return Returns the String
     */
    @JsonGetter("app_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAppId() {
        return appId;
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

    /**
     * Getter for SaveCardOptions.
     * Describes save-card action fields.
     * @return Returns the SaveCardOptions
     */
    @JsonGetter("save_card_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SaveCardOptions getSaveCardOptions() {
        return saveCardOptions;
    }

    /**
     * Getter for DeviceMetadata.
     * @return Returns the DeviceMetadata
     */
    @JsonGetter("device_metadata")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceMetadata getDeviceMetadata() {
        return deviceMetadata;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, deadlineDuration, status, cancelReason, createdAt,
                updatedAt, appId, type, saveCardOptions, deviceMetadata);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TerminalAction)) {
            return false;
        }
        TerminalAction other = (TerminalAction) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(deviceId, other.deviceId)
            && Objects.equals(deadlineDuration, other.deadlineDuration)
            && Objects.equals(status, other.status)
            && Objects.equals(cancelReason, other.cancelReason)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(appId, other.appId)
            && Objects.equals(type, other.type)
            && Objects.equals(saveCardOptions, other.saveCardOptions)
            && Objects.equals(deviceMetadata, other.deviceMetadata);
    }

    /**
     * Converts this TerminalAction into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalAction [" + "id=" + id + ", deviceId=" + deviceId + ", deadlineDuration="
                + deadlineDuration + ", status=" + status + ", cancelReason=" + cancelReason
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", appId=" + appId
                + ", type=" + type + ", saveCardOptions=" + saveCardOptions + ", deviceMetadata="
                + deviceMetadata + "]";
    }

    /**
     * Builds a new {@link TerminalAction.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalAction.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .deviceId(getDeviceId())
                .deadlineDuration(getDeadlineDuration())
                .status(getStatus())
                .cancelReason(getCancelReason())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .appId(getAppId())
                .type(getType())
                .saveCardOptions(getSaveCardOptions())
                .deviceMetadata(getDeviceMetadata());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalAction}.
     */
    public static class Builder {
        private String id;
        private String deviceId;
        private String deadlineDuration;
        private String status;
        private String cancelReason;
        private String createdAt;
        private String updatedAt;
        private String appId;
        private String type;
        private SaveCardOptions saveCardOptions;
        private DeviceMetadata deviceMetadata;



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
         * Setter for deviceId.
         * @param  deviceId  String value for deviceId.
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        /**
         * Setter for deadlineDuration.
         * @param  deadlineDuration  String value for deadlineDuration.
         * @return Builder
         */
        public Builder deadlineDuration(String deadlineDuration) {
            this.deadlineDuration = deadlineDuration;
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
         * Setter for cancelReason.
         * @param  cancelReason  String value for cancelReason.
         * @return Builder
         */
        public Builder cancelReason(String cancelReason) {
            this.cancelReason = cancelReason;
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
         * Setter for appId.
         * @param  appId  String value for appId.
         * @return Builder
         */
        public Builder appId(String appId) {
            this.appId = appId;
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
         * Setter for saveCardOptions.
         * @param  saveCardOptions  SaveCardOptions value for saveCardOptions.
         * @return Builder
         */
        public Builder saveCardOptions(SaveCardOptions saveCardOptions) {
            this.saveCardOptions = saveCardOptions;
            return this;
        }

        /**
         * Setter for deviceMetadata.
         * @param  deviceMetadata  DeviceMetadata value for deviceMetadata.
         * @return Builder
         */
        public Builder deviceMetadata(DeviceMetadata deviceMetadata) {
            this.deviceMetadata = deviceMetadata;
            return this;
        }

        /**
         * Builds a new {@link TerminalAction} object using the set fields.
         * @return {@link TerminalAction}
         */
        public TerminalAction build() {
            return new TerminalAction(id, deviceId, deadlineDuration, status, cancelReason,
                    createdAt, updatedAt, appId, type, saveCardOptions, deviceMetadata);
        }
    }
}
