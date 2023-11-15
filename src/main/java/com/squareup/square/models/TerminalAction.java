
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
    private final String locationId;
    private final String type;
    private final QrCodeOptions qrCodeOptions;
    private final SaveCardOptions saveCardOptions;
    private final SignatureOptions signatureOptions;
    private final ConfirmationOptions confirmationOptions;
    private final ReceiptOptions receiptOptions;
    private final DataCollectionOptions dataCollectionOptions;
    private final SelectOptions selectOptions;
    private final DeviceMetadata deviceMetadata;
    private final OptionalNullable<Boolean> awaitNextAction;
    private final OptionalNullable<String> awaitNextActionDuration;

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
     * @param  locationId  String value for locationId.
     * @param  type  String value for type.
     * @param  qrCodeOptions  QrCodeOptions value for qrCodeOptions.
     * @param  saveCardOptions  SaveCardOptions value for saveCardOptions.
     * @param  signatureOptions  SignatureOptions value for signatureOptions.
     * @param  confirmationOptions  ConfirmationOptions value for confirmationOptions.
     * @param  receiptOptions  ReceiptOptions value for receiptOptions.
     * @param  dataCollectionOptions  DataCollectionOptions value for dataCollectionOptions.
     * @param  selectOptions  SelectOptions value for selectOptions.
     * @param  deviceMetadata  DeviceMetadata value for deviceMetadata.
     * @param  awaitNextAction  Boolean value for awaitNextAction.
     * @param  awaitNextActionDuration  String value for awaitNextActionDuration.
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
            @JsonProperty("location_id") String locationId,
            @JsonProperty("type") String type,
            @JsonProperty("qr_code_options") QrCodeOptions qrCodeOptions,
            @JsonProperty("save_card_options") SaveCardOptions saveCardOptions,
            @JsonProperty("signature_options") SignatureOptions signatureOptions,
            @JsonProperty("confirmation_options") ConfirmationOptions confirmationOptions,
            @JsonProperty("receipt_options") ReceiptOptions receiptOptions,
            @JsonProperty("data_collection_options") DataCollectionOptions dataCollectionOptions,
            @JsonProperty("select_options") SelectOptions selectOptions,
            @JsonProperty("device_metadata") DeviceMetadata deviceMetadata,
            @JsonProperty("await_next_action") Boolean awaitNextAction,
            @JsonProperty("await_next_action_duration") String awaitNextActionDuration) {
        this.id = id;
        this.deviceId = OptionalNullable.of(deviceId);
        this.deadlineDuration = OptionalNullable.of(deadlineDuration);
        this.status = status;
        this.cancelReason = cancelReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.appId = appId;
        this.locationId = locationId;
        this.type = type;
        this.qrCodeOptions = qrCodeOptions;
        this.saveCardOptions = saveCardOptions;
        this.signatureOptions = signatureOptions;
        this.confirmationOptions = confirmationOptions;
        this.receiptOptions = receiptOptions;
        this.dataCollectionOptions = dataCollectionOptions;
        this.selectOptions = selectOptions;
        this.deviceMetadata = deviceMetadata;
        this.awaitNextAction = OptionalNullable.of(awaitNextAction);
        this.awaitNextActionDuration = OptionalNullable.of(awaitNextActionDuration);
    }

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
     * @param  locationId  String value for locationId.
     * @param  type  String value for type.
     * @param  qrCodeOptions  QrCodeOptions value for qrCodeOptions.
     * @param  saveCardOptions  SaveCardOptions value for saveCardOptions.
     * @param  signatureOptions  SignatureOptions value for signatureOptions.
     * @param  confirmationOptions  ConfirmationOptions value for confirmationOptions.
     * @param  receiptOptions  ReceiptOptions value for receiptOptions.
     * @param  dataCollectionOptions  DataCollectionOptions value for dataCollectionOptions.
     * @param  selectOptions  SelectOptions value for selectOptions.
     * @param  deviceMetadata  DeviceMetadata value for deviceMetadata.
     * @param  awaitNextAction  Boolean value for awaitNextAction.
     * @param  awaitNextActionDuration  String value for awaitNextActionDuration.
     */

    protected TerminalAction(String id, OptionalNullable<String> deviceId,
            OptionalNullable<String> deadlineDuration, String status, String cancelReason,
            String createdAt, String updatedAt, String appId, String locationId, String type,
            QrCodeOptions qrCodeOptions, SaveCardOptions saveCardOptions,
            SignatureOptions signatureOptions, ConfirmationOptions confirmationOptions,
            ReceiptOptions receiptOptions, DataCollectionOptions dataCollectionOptions,
            SelectOptions selectOptions, DeviceMetadata deviceMetadata,
            OptionalNullable<Boolean> awaitNextAction,
            OptionalNullable<String> awaitNextActionDuration) {
        this.id = id;
        this.deviceId = deviceId;
        this.deadlineDuration = deadlineDuration;
        this.status = status;
        this.cancelReason = cancelReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.appId = appId;
        this.locationId = locationId;
        this.type = type;
        this.qrCodeOptions = qrCodeOptions;
        this.saveCardOptions = saveCardOptions;
        this.signatureOptions = signatureOptions;
        this.confirmationOptions = confirmationOptions;
        this.receiptOptions = receiptOptions;
        this.dataCollectionOptions = dataCollectionOptions;
        this.selectOptions = selectOptions;
        this.deviceMetadata = deviceMetadata;
        this.awaitNextAction = awaitNextAction;
        this.awaitNextActionDuration = awaitNextActionDuration;
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
     * Getter for LocationId.
     * The location id the action is attached to, if a link can be made.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
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
     * Getter for QrCodeOptions.
     * Fields to describe the action that displays QR-Codes.
     * @return Returns the QrCodeOptions
     */
    @JsonGetter("qr_code_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public QrCodeOptions getQrCodeOptions() {
        return qrCodeOptions;
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
     * Getter for SignatureOptions.
     * @return Returns the SignatureOptions
     */
    @JsonGetter("signature_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SignatureOptions getSignatureOptions() {
        return signatureOptions;
    }

    /**
     * Getter for ConfirmationOptions.
     * @return Returns the ConfirmationOptions
     */
    @JsonGetter("confirmation_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ConfirmationOptions getConfirmationOptions() {
        return confirmationOptions;
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
     * Getter for DataCollectionOptions.
     * @return Returns the DataCollectionOptions
     */
    @JsonGetter("data_collection_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DataCollectionOptions getDataCollectionOptions() {
        return dataCollectionOptions;
    }

    /**
     * Getter for SelectOptions.
     * @return Returns the SelectOptions
     */
    @JsonGetter("select_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SelectOptions getSelectOptions() {
        return selectOptions;
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

    /**
     * Internal Getter for AwaitNextAction.
     * Indicates the action will be linked to another action and requires a waiting dialog to be
     * displayed instead of returning to the idle screen on completion of the action. Only supported
     * on SIGNATURE, CONFIRMATION, DATA_COLLECTION, and SELECT types.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("await_next_action")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAwaitNextAction() {
        return this.awaitNextAction;
    }

    /**
     * Getter for AwaitNextAction.
     * Indicates the action will be linked to another action and requires a waiting dialog to be
     * displayed instead of returning to the idle screen on completion of the action. Only supported
     * on SIGNATURE, CONFIRMATION, DATA_COLLECTION, and SELECT types.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAwaitNextAction() {
        return OptionalNullable.getFrom(awaitNextAction);
    }

    /**
     * Internal Getter for AwaitNextActionDuration.
     * The timeout duration of the waiting dialog as an RFC 3339 duration, after which the waiting
     * dialog will no longer be displayed and the Terminal will return to the idle screen. Default:
     * 5 minutes from when the waiting dialog is displayed Maximum: 5 minutes
     * @return Returns the Internal String
     */
    @JsonGetter("await_next_action_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAwaitNextActionDuration() {
        return this.awaitNextActionDuration;
    }

    /**
     * Getter for AwaitNextActionDuration.
     * The timeout duration of the waiting dialog as an RFC 3339 duration, after which the waiting
     * dialog will no longer be displayed and the Terminal will return to the idle screen. Default:
     * 5 minutes from when the waiting dialog is displayed Maximum: 5 minutes
     * @return Returns the String
     */
    @JsonIgnore
    public String getAwaitNextActionDuration() {
        return OptionalNullable.getFrom(awaitNextActionDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, deadlineDuration, status, cancelReason, createdAt,
                updatedAt, appId, locationId, type, qrCodeOptions, saveCardOptions,
                signatureOptions, confirmationOptions, receiptOptions, dataCollectionOptions,
                selectOptions, deviceMetadata, awaitNextAction, awaitNextActionDuration);
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
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(type, other.type)
            && Objects.equals(qrCodeOptions, other.qrCodeOptions)
            && Objects.equals(saveCardOptions, other.saveCardOptions)
            && Objects.equals(signatureOptions, other.signatureOptions)
            && Objects.equals(confirmationOptions, other.confirmationOptions)
            && Objects.equals(receiptOptions, other.receiptOptions)
            && Objects.equals(dataCollectionOptions, other.dataCollectionOptions)
            && Objects.equals(selectOptions, other.selectOptions)
            && Objects.equals(deviceMetadata, other.deviceMetadata)
            && Objects.equals(awaitNextAction, other.awaitNextAction)
            && Objects.equals(awaitNextActionDuration, other.awaitNextActionDuration);
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
                + ", locationId=" + locationId + ", type=" + type + ", qrCodeOptions="
                + qrCodeOptions + ", saveCardOptions=" + saveCardOptions + ", signatureOptions="
                + signatureOptions + ", confirmationOptions=" + confirmationOptions
                + ", receiptOptions=" + receiptOptions + ", dataCollectionOptions="
                + dataCollectionOptions + ", selectOptions=" + selectOptions + ", deviceMetadata="
                + deviceMetadata + ", awaitNextAction=" + awaitNextAction
                + ", awaitNextActionDuration=" + awaitNextActionDuration + "]";
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
                .locationId(getLocationId())
                .type(getType())
                .qrCodeOptions(getQrCodeOptions())
                .saveCardOptions(getSaveCardOptions())
                .signatureOptions(getSignatureOptions())
                .confirmationOptions(getConfirmationOptions())
                .receiptOptions(getReceiptOptions())
                .dataCollectionOptions(getDataCollectionOptions())
                .selectOptions(getSelectOptions())
                .deviceMetadata(getDeviceMetadata());
        builder.deviceId = internalGetDeviceId();
        builder.deadlineDuration = internalGetDeadlineDuration();
        builder.awaitNextAction = internalGetAwaitNextAction();
        builder.awaitNextActionDuration = internalGetAwaitNextActionDuration();
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
        private String locationId;
        private String type;
        private QrCodeOptions qrCodeOptions;
        private SaveCardOptions saveCardOptions;
        private SignatureOptions signatureOptions;
        private ConfirmationOptions confirmationOptions;
        private ReceiptOptions receiptOptions;
        private DataCollectionOptions dataCollectionOptions;
        private SelectOptions selectOptions;
        private DeviceMetadata deviceMetadata;
        private OptionalNullable<Boolean> awaitNextAction;
        private OptionalNullable<String> awaitNextActionDuration;



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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
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
         * Setter for qrCodeOptions.
         * @param  qrCodeOptions  QrCodeOptions value for qrCodeOptions.
         * @return Builder
         */
        public Builder qrCodeOptions(QrCodeOptions qrCodeOptions) {
            this.qrCodeOptions = qrCodeOptions;
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
         * Setter for signatureOptions.
         * @param  signatureOptions  SignatureOptions value for signatureOptions.
         * @return Builder
         */
        public Builder signatureOptions(SignatureOptions signatureOptions) {
            this.signatureOptions = signatureOptions;
            return this;
        }

        /**
         * Setter for confirmationOptions.
         * @param  confirmationOptions  ConfirmationOptions value for confirmationOptions.
         * @return Builder
         */
        public Builder confirmationOptions(ConfirmationOptions confirmationOptions) {
            this.confirmationOptions = confirmationOptions;
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
         * Setter for dataCollectionOptions.
         * @param  dataCollectionOptions  DataCollectionOptions value for dataCollectionOptions.
         * @return Builder
         */
        public Builder dataCollectionOptions(DataCollectionOptions dataCollectionOptions) {
            this.dataCollectionOptions = dataCollectionOptions;
            return this;
        }

        /**
         * Setter for selectOptions.
         * @param  selectOptions  SelectOptions value for selectOptions.
         * @return Builder
         */
        public Builder selectOptions(SelectOptions selectOptions) {
            this.selectOptions = selectOptions;
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
         * Setter for awaitNextAction.
         * @param  awaitNextAction  Boolean value for awaitNextAction.
         * @return Builder
         */
        public Builder awaitNextAction(Boolean awaitNextAction) {
            this.awaitNextAction = OptionalNullable.of(awaitNextAction);
            return this;
        }

        /**
         * UnSetter for awaitNextAction.
         * @return Builder
         */
        public Builder unsetAwaitNextAction() {
            awaitNextAction = null;
            return this;
        }

        /**
         * Setter for awaitNextActionDuration.
         * @param  awaitNextActionDuration  String value for awaitNextActionDuration.
         * @return Builder
         */
        public Builder awaitNextActionDuration(String awaitNextActionDuration) {
            this.awaitNextActionDuration = OptionalNullable.of(awaitNextActionDuration);
            return this;
        }

        /**
         * UnSetter for awaitNextActionDuration.
         * @return Builder
         */
        public Builder unsetAwaitNextActionDuration() {
            awaitNextActionDuration = null;
            return this;
        }

        /**
         * Builds a new {@link TerminalAction} object using the set fields.
         * @return {@link TerminalAction}
         */
        public TerminalAction build() {
            return new TerminalAction(id, deviceId, deadlineDuration, status, cancelReason,
                    createdAt, updatedAt, appId, locationId, type, qrCodeOptions, saveCardOptions,
                    signatureOptions, confirmationOptions, receiptOptions, dataCollectionOptions,
                    selectOptions, deviceMetadata, awaitNextAction, awaitNextActionDuration);
        }
    }
}
