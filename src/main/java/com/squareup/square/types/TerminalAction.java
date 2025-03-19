/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TerminalAction.Builder.class)
public final class TerminalAction {
    private final Optional<String> id;

    private final Optional<String> deviceId;

    private final Optional<String> deadlineDuration;

    private final Optional<String> status;

    private final Optional<ActionCancelReason> cancelReason;

    private final Optional<String> createdAt;

    private final Optional<String> updatedAt;

    private final Optional<String> appId;

    private final Optional<String> locationId;

    private final Optional<TerminalActionActionType> type;

    private final Optional<QrCodeOptions> qrCodeOptions;

    private final Optional<SaveCardOptions> saveCardOptions;

    private final Optional<SignatureOptions> signatureOptions;

    private final Optional<ConfirmationOptions> confirmationOptions;

    private final Optional<ReceiptOptions> receiptOptions;

    private final Optional<DataCollectionOptions> dataCollectionOptions;

    private final Optional<SelectOptions> selectOptions;

    private final Optional<DeviceMetadata> deviceMetadata;

    private final Optional<Boolean> awaitNextAction;

    private final Optional<String> awaitNextActionDuration;

    private final Map<String, Object> additionalProperties;

    private TerminalAction(
            Optional<String> id,
            Optional<String> deviceId,
            Optional<String> deadlineDuration,
            Optional<String> status,
            Optional<ActionCancelReason> cancelReason,
            Optional<String> createdAt,
            Optional<String> updatedAt,
            Optional<String> appId,
            Optional<String> locationId,
            Optional<TerminalActionActionType> type,
            Optional<QrCodeOptions> qrCodeOptions,
            Optional<SaveCardOptions> saveCardOptions,
            Optional<SignatureOptions> signatureOptions,
            Optional<ConfirmationOptions> confirmationOptions,
            Optional<ReceiptOptions> receiptOptions,
            Optional<DataCollectionOptions> dataCollectionOptions,
            Optional<SelectOptions> selectOptions,
            Optional<DeviceMetadata> deviceMetadata,
            Optional<Boolean> awaitNextAction,
            Optional<String> awaitNextActionDuration,
            Map<String, Object> additionalProperties) {
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
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique ID for this <code>TerminalAction</code>.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The unique Id of the device intended for this <code>TerminalAction</code>.
     * The Id can be retrieved from /v2/devices api.
     */
    @JsonIgnore
    public Optional<String> getDeviceId() {
        if (deviceId == null) {
            return Optional.empty();
        }
        return deviceId;
    }

    /**
     * @return The duration as an RFC 3339 duration, after which the action will be automatically canceled.
     * TerminalActions that are <code>PENDING</code> will be automatically <code>CANCELED</code> and have a cancellation reason
     * of <code>TIMED_OUT</code>
     * <p>Default: 5 minutes from creation</p>
     * <p>Maximum: 5 minutes</p>
     */
    @JsonIgnore
    public Optional<String> getDeadlineDuration() {
        if (deadlineDuration == null) {
            return Optional.empty();
        }
        return deadlineDuration;
    }

    /**
     * @return The status of the <code>TerminalAction</code>.
     * Options: <code>PENDING</code>, <code>IN_PROGRESS</code>, <code>CANCEL_REQUESTED</code>, <code>CANCELED</code>, <code>COMPLETED</code>
     */
    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    /**
     * @return The reason why <code>TerminalAction</code> is canceled. Present if the status is <code>CANCELED</code>.
     * See <a href="#type-actioncancelreason">ActionCancelReason</a> for possible values
     */
    @JsonProperty("cancel_reason")
    public Optional<ActionCancelReason> getCancelReason() {
        return cancelReason;
    }

    /**
     * @return The time when the <code>TerminalAction</code> was created as an RFC 3339 timestamp.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The time when the <code>TerminalAction</code> was last updated as an RFC 3339 timestamp.
     */
    @JsonProperty("updated_at")
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The ID of the application that created the action.
     */
    @JsonProperty("app_id")
    public Optional<String> getAppId() {
        return appId;
    }

    /**
     * @return The location id the action is attached to, if a link can be made.
     */
    @JsonProperty("location_id")
    public Optional<String> getLocationId() {
        return locationId;
    }

    /**
     * @return Represents the type of the action.
     * See <a href="#type-actiontype">ActionType</a> for possible values
     */
    @JsonProperty("type")
    public Optional<TerminalActionActionType> getType() {
        return type;
    }

    /**
     * @return Describes configuration for the QR code action. Requires <code>QR_CODE</code> type.
     */
    @JsonProperty("qr_code_options")
    public Optional<QrCodeOptions> getQrCodeOptions() {
        return qrCodeOptions;
    }

    /**
     * @return Describes configuration for the save-card action. Requires <code>SAVE_CARD</code> type.
     */
    @JsonProperty("save_card_options")
    public Optional<SaveCardOptions> getSaveCardOptions() {
        return saveCardOptions;
    }

    /**
     * @return Describes configuration for the signature capture action. Requires <code>SIGNATURE</code> type.
     */
    @JsonProperty("signature_options")
    public Optional<SignatureOptions> getSignatureOptions() {
        return signatureOptions;
    }

    /**
     * @return Describes configuration for the confirmation action. Requires <code>CONFIRMATION</code> type.
     */
    @JsonProperty("confirmation_options")
    public Optional<ConfirmationOptions> getConfirmationOptions() {
        return confirmationOptions;
    }

    /**
     * @return Describes configuration for the receipt action. Requires <code>RECEIPT</code> type.
     */
    @JsonProperty("receipt_options")
    public Optional<ReceiptOptions> getReceiptOptions() {
        return receiptOptions;
    }

    /**
     * @return Describes configuration for the data collection action. Requires <code>DATA_COLLECTION</code> type.
     */
    @JsonProperty("data_collection_options")
    public Optional<DataCollectionOptions> getDataCollectionOptions() {
        return dataCollectionOptions;
    }

    /**
     * @return Describes configuration for the select action. Requires <code>SELECT</code> type.
     */
    @JsonProperty("select_options")
    public Optional<SelectOptions> getSelectOptions() {
        return selectOptions;
    }

    /**
     * @return Details about the Terminal that received the action request (such as battery level,
     * operating system version, and network connection settings).
     * <p>Only available for <code>PING</code> action type.</p>
     */
    @JsonProperty("device_metadata")
    public Optional<DeviceMetadata> getDeviceMetadata() {
        return deviceMetadata;
    }

    /**
     * @return Indicates the action will be linked to another action and requires a waiting dialog to be
     * displayed instead of returning to the idle screen on completion of the action.
     * <p>Only supported on SIGNATURE, CONFIRMATION, DATA_COLLECTION, and SELECT types.</p>
     */
    @JsonIgnore
    public Optional<Boolean> getAwaitNextAction() {
        if (awaitNextAction == null) {
            return Optional.empty();
        }
        return awaitNextAction;
    }

    /**
     * @return The timeout duration of the waiting dialog as an RFC 3339 duration, after which the
     * waiting dialog will no longer be displayed and the Terminal will return to the idle screen.
     * <p>Default: 5 minutes from when the waiting dialog is displayed</p>
     * <p>Maximum: 5 minutes</p>
     */
    @JsonIgnore
    public Optional<String> getAwaitNextActionDuration() {
        if (awaitNextActionDuration == null) {
            return Optional.empty();
        }
        return awaitNextActionDuration;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("device_id")
    private Optional<String> _getDeviceId() {
        return deviceId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("deadline_duration")
    private Optional<String> _getDeadlineDuration() {
        return deadlineDuration;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("await_next_action")
    private Optional<Boolean> _getAwaitNextAction() {
        return awaitNextAction;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("await_next_action_duration")
    private Optional<String> _getAwaitNextActionDuration() {
        return awaitNextActionDuration;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TerminalAction && equalTo((TerminalAction) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TerminalAction other) {
        return id.equals(other.id)
                && deviceId.equals(other.deviceId)
                && deadlineDuration.equals(other.deadlineDuration)
                && status.equals(other.status)
                && cancelReason.equals(other.cancelReason)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && appId.equals(other.appId)
                && locationId.equals(other.locationId)
                && type.equals(other.type)
                && qrCodeOptions.equals(other.qrCodeOptions)
                && saveCardOptions.equals(other.saveCardOptions)
                && signatureOptions.equals(other.signatureOptions)
                && confirmationOptions.equals(other.confirmationOptions)
                && receiptOptions.equals(other.receiptOptions)
                && dataCollectionOptions.equals(other.dataCollectionOptions)
                && selectOptions.equals(other.selectOptions)
                && deviceMetadata.equals(other.deviceMetadata)
                && awaitNextAction.equals(other.awaitNextAction)
                && awaitNextActionDuration.equals(other.awaitNextActionDuration);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.deviceId,
                this.deadlineDuration,
                this.status,
                this.cancelReason,
                this.createdAt,
                this.updatedAt,
                this.appId,
                this.locationId,
                this.type,
                this.qrCodeOptions,
                this.saveCardOptions,
                this.signatureOptions,
                this.confirmationOptions,
                this.receiptOptions,
                this.dataCollectionOptions,
                this.selectOptions,
                this.deviceMetadata,
                this.awaitNextAction,
                this.awaitNextActionDuration);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> deviceId = Optional.empty();

        private Optional<String> deadlineDuration = Optional.empty();

        private Optional<String> status = Optional.empty();

        private Optional<ActionCancelReason> cancelReason = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        private Optional<String> appId = Optional.empty();

        private Optional<String> locationId = Optional.empty();

        private Optional<TerminalActionActionType> type = Optional.empty();

        private Optional<QrCodeOptions> qrCodeOptions = Optional.empty();

        private Optional<SaveCardOptions> saveCardOptions = Optional.empty();

        private Optional<SignatureOptions> signatureOptions = Optional.empty();

        private Optional<ConfirmationOptions> confirmationOptions = Optional.empty();

        private Optional<ReceiptOptions> receiptOptions = Optional.empty();

        private Optional<DataCollectionOptions> dataCollectionOptions = Optional.empty();

        private Optional<SelectOptions> selectOptions = Optional.empty();

        private Optional<DeviceMetadata> deviceMetadata = Optional.empty();

        private Optional<Boolean> awaitNextAction = Optional.empty();

        private Optional<String> awaitNextActionDuration = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TerminalAction other) {
            id(other.getId());
            deviceId(other.getDeviceId());
            deadlineDuration(other.getDeadlineDuration());
            status(other.getStatus());
            cancelReason(other.getCancelReason());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            appId(other.getAppId());
            locationId(other.getLocationId());
            type(other.getType());
            qrCodeOptions(other.getQrCodeOptions());
            saveCardOptions(other.getSaveCardOptions());
            signatureOptions(other.getSignatureOptions());
            confirmationOptions(other.getConfirmationOptions());
            receiptOptions(other.getReceiptOptions());
            dataCollectionOptions(other.getDataCollectionOptions());
            selectOptions(other.getSelectOptions());
            deviceMetadata(other.getDeviceMetadata());
            awaitNextAction(other.getAwaitNextAction());
            awaitNextActionDuration(other.getAwaitNextActionDuration());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @JsonSetter(value = "device_id", nulls = Nulls.SKIP)
        public Builder deviceId(Optional<String> deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public Builder deviceId(String deviceId) {
            this.deviceId = Optional.ofNullable(deviceId);
            return this;
        }

        public Builder deviceId(Nullable<String> deviceId) {
            if (deviceId.isNull()) {
                this.deviceId = null;
            } else if (deviceId.isEmpty()) {
                this.deviceId = Optional.empty();
            } else {
                this.deviceId = Optional.of(deviceId.get());
            }
            return this;
        }

        @JsonSetter(value = "deadline_duration", nulls = Nulls.SKIP)
        public Builder deadlineDuration(Optional<String> deadlineDuration) {
            this.deadlineDuration = deadlineDuration;
            return this;
        }

        public Builder deadlineDuration(String deadlineDuration) {
            this.deadlineDuration = Optional.ofNullable(deadlineDuration);
            return this;
        }

        public Builder deadlineDuration(Nullable<String> deadlineDuration) {
            if (deadlineDuration.isNull()) {
                this.deadlineDuration = null;
            } else if (deadlineDuration.isEmpty()) {
                this.deadlineDuration = Optional.empty();
            } else {
                this.deadlineDuration = Optional.of(deadlineDuration.get());
            }
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<String> status) {
            this.status = status;
            return this;
        }

        public Builder status(String status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @JsonSetter(value = "cancel_reason", nulls = Nulls.SKIP)
        public Builder cancelReason(Optional<ActionCancelReason> cancelReason) {
            this.cancelReason = cancelReason;
            return this;
        }

        public Builder cancelReason(ActionCancelReason cancelReason) {
            this.cancelReason = Optional.ofNullable(cancelReason);
            return this;
        }

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public Builder updatedAt(Optional<String> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder updatedAt(String updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        @JsonSetter(value = "app_id", nulls = Nulls.SKIP)
        public Builder appId(Optional<String> appId) {
            this.appId = appId;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = Optional.ofNullable(appId);
            return this;
        }

        @JsonSetter(value = "location_id", nulls = Nulls.SKIP)
        public Builder locationId(Optional<String> locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder locationId(String locationId) {
            this.locationId = Optional.ofNullable(locationId);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<TerminalActionActionType> type) {
            this.type = type;
            return this;
        }

        public Builder type(TerminalActionActionType type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        @JsonSetter(value = "qr_code_options", nulls = Nulls.SKIP)
        public Builder qrCodeOptions(Optional<QrCodeOptions> qrCodeOptions) {
            this.qrCodeOptions = qrCodeOptions;
            return this;
        }

        public Builder qrCodeOptions(QrCodeOptions qrCodeOptions) {
            this.qrCodeOptions = Optional.ofNullable(qrCodeOptions);
            return this;
        }

        @JsonSetter(value = "save_card_options", nulls = Nulls.SKIP)
        public Builder saveCardOptions(Optional<SaveCardOptions> saveCardOptions) {
            this.saveCardOptions = saveCardOptions;
            return this;
        }

        public Builder saveCardOptions(SaveCardOptions saveCardOptions) {
            this.saveCardOptions = Optional.ofNullable(saveCardOptions);
            return this;
        }

        @JsonSetter(value = "signature_options", nulls = Nulls.SKIP)
        public Builder signatureOptions(Optional<SignatureOptions> signatureOptions) {
            this.signatureOptions = signatureOptions;
            return this;
        }

        public Builder signatureOptions(SignatureOptions signatureOptions) {
            this.signatureOptions = Optional.ofNullable(signatureOptions);
            return this;
        }

        @JsonSetter(value = "confirmation_options", nulls = Nulls.SKIP)
        public Builder confirmationOptions(Optional<ConfirmationOptions> confirmationOptions) {
            this.confirmationOptions = confirmationOptions;
            return this;
        }

        public Builder confirmationOptions(ConfirmationOptions confirmationOptions) {
            this.confirmationOptions = Optional.ofNullable(confirmationOptions);
            return this;
        }

        @JsonSetter(value = "receipt_options", nulls = Nulls.SKIP)
        public Builder receiptOptions(Optional<ReceiptOptions> receiptOptions) {
            this.receiptOptions = receiptOptions;
            return this;
        }

        public Builder receiptOptions(ReceiptOptions receiptOptions) {
            this.receiptOptions = Optional.ofNullable(receiptOptions);
            return this;
        }

        @JsonSetter(value = "data_collection_options", nulls = Nulls.SKIP)
        public Builder dataCollectionOptions(Optional<DataCollectionOptions> dataCollectionOptions) {
            this.dataCollectionOptions = dataCollectionOptions;
            return this;
        }

        public Builder dataCollectionOptions(DataCollectionOptions dataCollectionOptions) {
            this.dataCollectionOptions = Optional.ofNullable(dataCollectionOptions);
            return this;
        }

        @JsonSetter(value = "select_options", nulls = Nulls.SKIP)
        public Builder selectOptions(Optional<SelectOptions> selectOptions) {
            this.selectOptions = selectOptions;
            return this;
        }

        public Builder selectOptions(SelectOptions selectOptions) {
            this.selectOptions = Optional.ofNullable(selectOptions);
            return this;
        }

        @JsonSetter(value = "device_metadata", nulls = Nulls.SKIP)
        public Builder deviceMetadata(Optional<DeviceMetadata> deviceMetadata) {
            this.deviceMetadata = deviceMetadata;
            return this;
        }

        public Builder deviceMetadata(DeviceMetadata deviceMetadata) {
            this.deviceMetadata = Optional.ofNullable(deviceMetadata);
            return this;
        }

        @JsonSetter(value = "await_next_action", nulls = Nulls.SKIP)
        public Builder awaitNextAction(Optional<Boolean> awaitNextAction) {
            this.awaitNextAction = awaitNextAction;
            return this;
        }

        public Builder awaitNextAction(Boolean awaitNextAction) {
            this.awaitNextAction = Optional.ofNullable(awaitNextAction);
            return this;
        }

        public Builder awaitNextAction(Nullable<Boolean> awaitNextAction) {
            if (awaitNextAction.isNull()) {
                this.awaitNextAction = null;
            } else if (awaitNextAction.isEmpty()) {
                this.awaitNextAction = Optional.empty();
            } else {
                this.awaitNextAction = Optional.of(awaitNextAction.get());
            }
            return this;
        }

        @JsonSetter(value = "await_next_action_duration", nulls = Nulls.SKIP)
        public Builder awaitNextActionDuration(Optional<String> awaitNextActionDuration) {
            this.awaitNextActionDuration = awaitNextActionDuration;
            return this;
        }

        public Builder awaitNextActionDuration(String awaitNextActionDuration) {
            this.awaitNextActionDuration = Optional.ofNullable(awaitNextActionDuration);
            return this;
        }

        public Builder awaitNextActionDuration(Nullable<String> awaitNextActionDuration) {
            if (awaitNextActionDuration.isNull()) {
                this.awaitNextActionDuration = null;
            } else if (awaitNextActionDuration.isEmpty()) {
                this.awaitNextActionDuration = Optional.empty();
            } else {
                this.awaitNextActionDuration = Optional.of(awaitNextActionDuration.get());
            }
            return this;
        }

        public TerminalAction build() {
            return new TerminalAction(
                    id,
                    deviceId,
                    deadlineDuration,
                    status,
                    cancelReason,
                    createdAt,
                    updatedAt,
                    appId,
                    locationId,
                    type,
                    qrCodeOptions,
                    saveCardOptions,
                    signatureOptions,
                    confirmationOptions,
                    receiptOptions,
                    dataCollectionOptions,
                    selectOptions,
                    deviceMetadata,
                    awaitNextAction,
                    awaitNextActionDuration,
                    additionalProperties);
        }
    }
}
