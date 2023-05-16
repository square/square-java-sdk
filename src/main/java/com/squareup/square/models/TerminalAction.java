
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for TerminalAction type.
 */
public class TerminalAction {
    private final String id;
    private final OptionalNullable<String> deviceId;
    private final OptionalNullable<String> deadlineDuration;
    private final String status;
    private final String cancelReason;
    private final String createdAt;
    private final String updatedAt;
    private final String appId;
    private final String type;
    private final SaveCardOptions saveCardOptions;
    private final ReceiptOptions receiptOptions;
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
     * @param  receiptOptions  ReceiptOptions value for receiptOptions.
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
            @JsonProperty("receipt_options") ReceiptOptions receiptOptions,
            @JsonProperty("device_metadata") DeviceMetadata deviceMetadata) {
        this.id = id;
        this.deviceId = OptionalNullable.of(deviceId);
        this.deadlineDuration = OptionalNullable.of(deadlineDuration);
        this.status = status;
        this.cancelReason = cancelReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.appId = appId;
        this.type = type;
        this.saveCardOptions = saveCardOptions;
        this.receiptOptions = receiptOptions;
        this.deviceMetadata = deviceMetadata;
    }

    /**
     * Internal initialization constructor.
     */
    protected TerminalAction(String id, OptionalNullable<String> deviceId,
            OptionalNullable<String> deadlineDuration, String status, String cancelReason,
            String createdAt, String updatedAt, String appId, String type,
            SaveCardOptions saveCardOptions, ReceiptOptions receiptOptions,
            DeviceMetadata deviceMetadata) {
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
        this.receiptOptions = receiptOptions;
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
     * Internal Getter for DeviceId.
     * The unique Id of the device intended for this `TerminalAction`. The Id can be retrieved from
     * /v2/devices api.
     * @return Returns the Internal String
     */
    @JsonGetter("device_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for DeviceId.
     * The unique Id of the device intended for this `TerminalAction`. The Id can be retrieved from
     * /v2/devices api.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeviceId() {
        return OptionalNullable.getFrom(deviceId);
    }

    /**
     * Internal Getter for DeadlineDuration.
     * The duration as an RFC 3339 duration, after which the action will be automatically canceled.
     * TerminalActions that are `PENDING` will be automatically `CANCELED` and have a cancellation
     * reason of `TIMED_OUT` Default: 5 minutes from creation Maximum: 5 minutes
     * @return Returns the Internal String
     */
    @JsonGetter("deadline_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeadlineDuration() {
        return this.deadlineDuration;
    }

    /**
     * Getter for DeadlineDuration.
     * The duration as an RFC 3339 duration, after which the action will be automatically canceled.
     * TerminalActions that are `PENDING` will be automatically `CANCELED` and have a cancellation
     * reason of `TIMED_OUT` Default: 5 minutes from creation Maximum: 5 minutes
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeadlineDuration() {
        return OptionalNullable.getFrom(deadlineDuration);
    }

    /**
     * Getter for Status.
     * The status of the `TerminalAction`. Options: `PENDING`, `IN_PROGRESS`, `CANCEL_REQUESTED`,
     * `CANCELED`, `COMPLETED`
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
     * Getter for ReceiptOptions.
     * Describes receipt action fields.
     * @return Returns the ReceiptOptions
     */
    @JsonGetter("receipt_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ReceiptOptions getReceiptOptions() {
        return receiptOptions;
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
                updatedAt, appId, type, saveCardOptions, receiptOptions, deviceMetadata);
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
            && Objects.equals(receiptOptions, other.receiptOptions)
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
                + ", type=" + type + ", saveCardOptions=" + saveCardOptions + ", receiptOptions="
                + receiptOptions + ", deviceMetadata=" + deviceMetadata + "]";
    }

    /**
     * Builds a new {@link TerminalAction.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalAction.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .status(getStatus())
                .cancelReason(getCancelReason())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .appId(getAppId())
                .type(getType())
                .saveCardOptions(getSaveCardOptions())
                .receiptOptions(getReceiptOptions())
                .deviceMetadata(getDeviceMetadata());
        builder.deviceId = internalGetDeviceId();
        builder.deadlineDuration = internalGetDeadlineDuration();
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalAction}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> deviceId;
        private OptionalNullable<String> deadlineDuration;
        private String status;
        private String cancelReason;
        private String createdAt;
        private String updatedAt;
        private String appId;
        private String type;
        private SaveCardOptions saveCardOptions;
        private ReceiptOptions receiptOptions;
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
            this.deviceId = OptionalNullable.of(deviceId);
            return this;
        }

        /**
         * UnSetter for deviceId.
         * @return Builder
         */
        public Builder unsetDeviceId() {
            deviceId = null;
            return this;
        }

        /**
         * Setter for deadlineDuration.
         * @param  deadlineDuration  String value for deadlineDuration.
         * @return Builder
         */
        public Builder deadlineDuration(String deadlineDuration) {
            this.deadlineDuration = OptionalNullable.of(deadlineDuration);
            return this;
        }

        /**
         * UnSetter for deadlineDuration.
         * @return Builder
         */
        public Builder unsetDeadlineDuration() {
            deadlineDuration = null;
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
         * Setter for receiptOptions.
         * @param  receiptOptions  ReceiptOptions value for receiptOptions.
         * @return Builder
         */
        public Builder receiptOptions(ReceiptOptions receiptOptions) {
            this.receiptOptions = receiptOptions;
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
                    createdAt, updatedAt, appId, type, saveCardOptions, receiptOptions,
                    deviceMetadata);
        }
    }
}
