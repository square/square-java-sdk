
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
 * This is a model class for OrderFulfillmentDeliveryDetails type.
 */
public class OrderFulfillmentDeliveryDetails {
    private final OrderFulfillmentRecipient recipient;
    private final String scheduleType;
    private final String placedAt;
    private final OptionalNullable<String> deliverAt;
    private final OptionalNullable<String> prepTimeDuration;
    private final OptionalNullable<String> deliveryWindowDuration;
    private final OptionalNullable<String> note;
    private final OptionalNullable<String> completedAt;
    private final String inProgressAt;
    private final String rejectedAt;
    private final String readyAt;
    private final String deliveredAt;
    private final String canceledAt;
    private final OptionalNullable<String> cancelReason;
    private final OptionalNullable<String> courierPickupAt;
    private final OptionalNullable<String> courierPickupWindowDuration;
    private final OptionalNullable<Boolean> isNoContactDelivery;
    private final OptionalNullable<String> dropoffNotes;
    private final OptionalNullable<String> courierProviderName;
    private final OptionalNullable<String> courierSupportPhoneNumber;
    private final OptionalNullable<String> squareDeliveryId;
    private final OptionalNullable<String> externalDeliveryId;
    private final OptionalNullable<Boolean> managedDelivery;

    /**
     * Initialization constructor.
     * @param  recipient  OrderFulfillmentRecipient value for recipient.
     * @param  scheduleType  String value for scheduleType.
     * @param  placedAt  String value for placedAt.
     * @param  deliverAt  String value for deliverAt.
     * @param  prepTimeDuration  String value for prepTimeDuration.
     * @param  deliveryWindowDuration  String value for deliveryWindowDuration.
     * @param  note  String value for note.
     * @param  completedAt  String value for completedAt.
     * @param  inProgressAt  String value for inProgressAt.
     * @param  rejectedAt  String value for rejectedAt.
     * @param  readyAt  String value for readyAt.
     * @param  deliveredAt  String value for deliveredAt.
     * @param  canceledAt  String value for canceledAt.
     * @param  cancelReason  String value for cancelReason.
     * @param  courierPickupAt  String value for courierPickupAt.
     * @param  courierPickupWindowDuration  String value for courierPickupWindowDuration.
     * @param  isNoContactDelivery  Boolean value for isNoContactDelivery.
     * @param  dropoffNotes  String value for dropoffNotes.
     * @param  courierProviderName  String value for courierProviderName.
     * @param  courierSupportPhoneNumber  String value for courierSupportPhoneNumber.
     * @param  squareDeliveryId  String value for squareDeliveryId.
     * @param  externalDeliveryId  String value for externalDeliveryId.
     * @param  managedDelivery  Boolean value for managedDelivery.
     */
    @JsonCreator
    public OrderFulfillmentDeliveryDetails(
            @JsonProperty("recipient") OrderFulfillmentRecipient recipient,
            @JsonProperty("schedule_type") String scheduleType,
            @JsonProperty("placed_at") String placedAt,
            @JsonProperty("deliver_at") String deliverAt,
            @JsonProperty("prep_time_duration") String prepTimeDuration,
            @JsonProperty("delivery_window_duration") String deliveryWindowDuration,
            @JsonProperty("note") String note,
            @JsonProperty("completed_at") String completedAt,
            @JsonProperty("in_progress_at") String inProgressAt,
            @JsonProperty("rejected_at") String rejectedAt,
            @JsonProperty("ready_at") String readyAt,
            @JsonProperty("delivered_at") String deliveredAt,
            @JsonProperty("canceled_at") String canceledAt,
            @JsonProperty("cancel_reason") String cancelReason,
            @JsonProperty("courier_pickup_at") String courierPickupAt,
            @JsonProperty("courier_pickup_window_duration") String courierPickupWindowDuration,
            @JsonProperty("is_no_contact_delivery") Boolean isNoContactDelivery,
            @JsonProperty("dropoff_notes") String dropoffNotes,
            @JsonProperty("courier_provider_name") String courierProviderName,
            @JsonProperty("courier_support_phone_number") String courierSupportPhoneNumber,
            @JsonProperty("square_delivery_id") String squareDeliveryId,
            @JsonProperty("external_delivery_id") String externalDeliveryId,
            @JsonProperty("managed_delivery") Boolean managedDelivery) {
        this.recipient = recipient;
        this.scheduleType = scheduleType;
        this.placedAt = placedAt;
        this.deliverAt = OptionalNullable.of(deliverAt);
        this.prepTimeDuration = OptionalNullable.of(prepTimeDuration);
        this.deliveryWindowDuration = OptionalNullable.of(deliveryWindowDuration);
        this.note = OptionalNullable.of(note);
        this.completedAt = OptionalNullable.of(completedAt);
        this.inProgressAt = inProgressAt;
        this.rejectedAt = rejectedAt;
        this.readyAt = readyAt;
        this.deliveredAt = deliveredAt;
        this.canceledAt = canceledAt;
        this.cancelReason = OptionalNullable.of(cancelReason);
        this.courierPickupAt = OptionalNullable.of(courierPickupAt);
        this.courierPickupWindowDuration = OptionalNullable.of(courierPickupWindowDuration);
        this.isNoContactDelivery = OptionalNullable.of(isNoContactDelivery);
        this.dropoffNotes = OptionalNullable.of(dropoffNotes);
        this.courierProviderName = OptionalNullable.of(courierProviderName);
        this.courierSupportPhoneNumber = OptionalNullable.of(courierSupportPhoneNumber);
        this.squareDeliveryId = OptionalNullable.of(squareDeliveryId);
        this.externalDeliveryId = OptionalNullable.of(externalDeliveryId);
        this.managedDelivery = OptionalNullable.of(managedDelivery);
    }

    /**
     * Initialization constructor.
     * @param  recipient  OrderFulfillmentRecipient value for recipient.
     * @param  scheduleType  String value for scheduleType.
     * @param  placedAt  String value for placedAt.
     * @param  deliverAt  String value for deliverAt.
     * @param  prepTimeDuration  String value for prepTimeDuration.
     * @param  deliveryWindowDuration  String value for deliveryWindowDuration.
     * @param  note  String value for note.
     * @param  completedAt  String value for completedAt.
     * @param  inProgressAt  String value for inProgressAt.
     * @param  rejectedAt  String value for rejectedAt.
     * @param  readyAt  String value for readyAt.
     * @param  deliveredAt  String value for deliveredAt.
     * @param  canceledAt  String value for canceledAt.
     * @param  cancelReason  String value for cancelReason.
     * @param  courierPickupAt  String value for courierPickupAt.
     * @param  courierPickupWindowDuration  String value for courierPickupWindowDuration.
     * @param  isNoContactDelivery  Boolean value for isNoContactDelivery.
     * @param  dropoffNotes  String value for dropoffNotes.
     * @param  courierProviderName  String value for courierProviderName.
     * @param  courierSupportPhoneNumber  String value for courierSupportPhoneNumber.
     * @param  squareDeliveryId  String value for squareDeliveryId.
     * @param  externalDeliveryId  String value for externalDeliveryId.
     * @param  managedDelivery  Boolean value for managedDelivery.
     */

    protected OrderFulfillmentDeliveryDetails(OrderFulfillmentRecipient recipient,
            String scheduleType, String placedAt, OptionalNullable<String> deliverAt,
            OptionalNullable<String> prepTimeDuration,
            OptionalNullable<String> deliveryWindowDuration, OptionalNullable<String> note,
            OptionalNullable<String> completedAt, String inProgressAt, String rejectedAt,
            String readyAt, String deliveredAt, String canceledAt,
            OptionalNullable<String> cancelReason, OptionalNullable<String> courierPickupAt,
            OptionalNullable<String> courierPickupWindowDuration,
            OptionalNullable<Boolean> isNoContactDelivery, OptionalNullable<String> dropoffNotes,
            OptionalNullable<String> courierProviderName,
            OptionalNullable<String> courierSupportPhoneNumber,
            OptionalNullable<String> squareDeliveryId, OptionalNullable<String> externalDeliveryId,
            OptionalNullable<Boolean> managedDelivery) {
        this.recipient = recipient;
        this.scheduleType = scheduleType;
        this.placedAt = placedAt;
        this.deliverAt = deliverAt;
        this.prepTimeDuration = prepTimeDuration;
        this.deliveryWindowDuration = deliveryWindowDuration;
        this.note = note;
        this.completedAt = completedAt;
        this.inProgressAt = inProgressAt;
        this.rejectedAt = rejectedAt;
        this.readyAt = readyAt;
        this.deliveredAt = deliveredAt;
        this.canceledAt = canceledAt;
        this.cancelReason = cancelReason;
        this.courierPickupAt = courierPickupAt;
        this.courierPickupWindowDuration = courierPickupWindowDuration;
        this.isNoContactDelivery = isNoContactDelivery;
        this.dropoffNotes = dropoffNotes;
        this.courierProviderName = courierProviderName;
        this.courierSupportPhoneNumber = courierSupportPhoneNumber;
        this.squareDeliveryId = squareDeliveryId;
        this.externalDeliveryId = externalDeliveryId;
        this.managedDelivery = managedDelivery;
    }

    /**
     * Getter for Recipient.
     * Information about the fulfillment recipient.
     * @return Returns the OrderFulfillmentRecipient
     */
    @JsonGetter("recipient")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderFulfillmentRecipient getRecipient() {
        return recipient;
    }

    /**
     * Getter for ScheduleType.
     * The schedule type of the delivery fulfillment.
     * @return Returns the String
     */
    @JsonGetter("schedule_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getScheduleType() {
        return scheduleType;
    }

    /**
     * Getter for PlacedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was placed. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z"). Must be in RFC 3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("placed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlacedAt() {
        return placedAt;
    }

    /**
     * Internal Getter for DeliverAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) that
     * represents the start of the delivery period. When the fulfillment `schedule_type` is `ASAP`,
     * the field is automatically set to the current time plus the `prep_time_duration`. Otherwise,
     * the application can set this field while the fulfillment `state` is `PROPOSED`, `RESERVED`,
     * or `PREPARED` (any time before the terminal state such as `COMPLETED`, `CANCELED`, and
     * `FAILED`). The timestamp must be in RFC 3339 format (for example,
     * "2016-09-04T23:59:33.123Z").
     * @return Returns the Internal String
     */
    @JsonGetter("deliver_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeliverAt() {
        return this.deliverAt;
    }

    /**
     * Getter for DeliverAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) that
     * represents the start of the delivery period. When the fulfillment `schedule_type` is `ASAP`,
     * the field is automatically set to the current time plus the `prep_time_duration`. Otherwise,
     * the application can set this field while the fulfillment `state` is `PROPOSED`, `RESERVED`,
     * or `PREPARED` (any time before the terminal state such as `COMPLETED`, `CANCELED`, and
     * `FAILED`). The timestamp must be in RFC 3339 format (for example,
     * "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeliverAt() {
        return OptionalNullable.getFrom(deliverAt);
    }

    /**
     * Internal Getter for PrepTimeDuration.
     * The duration of time it takes to prepare and deliver this fulfillment. The duration must be
     * in RFC 3339 format (for example, "P1W3D").
     * @return Returns the Internal String
     */
    @JsonGetter("prep_time_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPrepTimeDuration() {
        return this.prepTimeDuration;
    }

    /**
     * Getter for PrepTimeDuration.
     * The duration of time it takes to prepare and deliver this fulfillment. The duration must be
     * in RFC 3339 format (for example, "P1W3D").
     * @return Returns the String
     */
    @JsonIgnore
    public String getPrepTimeDuration() {
        return OptionalNullable.getFrom(prepTimeDuration);
    }

    /**
     * Internal Getter for DeliveryWindowDuration.
     * The time period after `deliver_at` in which to deliver the order. Applications can set this
     * field when the fulfillment `state` is `PROPOSED`, `RESERVED`, or `PREPARED` (any time before
     * the terminal state such as `COMPLETED`, `CANCELED`, and `FAILED`). The duration must be in
     * RFC 3339 format (for example, "P1W3D").
     * @return Returns the Internal String
     */
    @JsonGetter("delivery_window_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeliveryWindowDuration() {
        return this.deliveryWindowDuration;
    }

    /**
     * Getter for DeliveryWindowDuration.
     * The time period after `deliver_at` in which to deliver the order. Applications can set this
     * field when the fulfillment `state` is `PROPOSED`, `RESERVED`, or `PREPARED` (any time before
     * the terminal state such as `COMPLETED`, `CANCELED`, and `FAILED`). The duration must be in
     * RFC 3339 format (for example, "P1W3D").
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeliveryWindowDuration() {
        return OptionalNullable.getFrom(deliveryWindowDuration);
    }

    /**
     * Internal Getter for Note.
     * Provides additional instructions about the delivery fulfillment. It is displayed in the
     * Square Point of Sale application and set by the API.
     * @return Returns the Internal String
     */
    @JsonGetter("note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNote() {
        return this.note;
    }

    /**
     * Getter for Note.
     * Provides additional instructions about the delivery fulfillment. It is displayed in the
     * Square Point of Sale application and set by the API.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
    }

    /**
     * Internal Getter for CompletedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicates when the seller completed the fulfillment. This field is automatically set when
     * fulfillment `state` changes to `COMPLETED`. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the Internal String
     */
    @JsonGetter("completed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCompletedAt() {
        return this.completedAt;
    }

    /**
     * Getter for CompletedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicates when the seller completed the fulfillment. This field is automatically set when
     * fulfillment `state` changes to `COMPLETED`. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonIgnore
    public String getCompletedAt() {
        return OptionalNullable.getFrom(completedAt);
    }

    /**
     * Getter for InProgressAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicates when the seller started processing the fulfillment. This field is automatically set
     * when the fulfillment `state` changes to `RESERVED`. The timestamp must be in RFC 3339 format
     * (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("in_progress_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInProgressAt() {
        return inProgressAt;
    }

    /**
     * Getter for RejectedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was rejected. This field is automatically set when the
     * fulfillment `state` changes to `FAILED`. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("rejected_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRejectedAt() {
        return rejectedAt;
    }

    /**
     * Getter for ReadyAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the seller marked the fulfillment as ready for courier pickup. This field is
     * automatically set when the fulfillment `state` changes to PREPARED. The timestamp must be in
     * RFC 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("ready_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReadyAt() {
        return readyAt;
    }

    /**
     * Getter for DeliveredAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was delivered to the recipient. The timestamp must be in RFC
     * 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("delivered_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDeliveredAt() {
        return deliveredAt;
    }

    /**
     * Getter for CanceledAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was canceled. This field is automatically set when the
     * fulfillment `state` changes to `CANCELED`. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("canceled_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCanceledAt() {
        return canceledAt;
    }

    /**
     * Internal Getter for CancelReason.
     * The delivery cancellation reason. Max length: 100 characters.
     * @return Returns the Internal String
     */
    @JsonGetter("cancel_reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCancelReason() {
        return this.cancelReason;
    }

    /**
     * Getter for CancelReason.
     * The delivery cancellation reason. Max length: 100 characters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCancelReason() {
        return OptionalNullable.getFrom(cancelReason);
    }

    /**
     * Internal Getter for CourierPickupAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when an order can be picked up by the courier for delivery. The timestamp must be
     * in RFC 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the Internal String
     */
    @JsonGetter("courier_pickup_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCourierPickupAt() {
        return this.courierPickupAt;
    }

    /**
     * Getter for CourierPickupAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when an order can be picked up by the courier for delivery. The timestamp must be
     * in RFC 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonIgnore
    public String getCourierPickupAt() {
        return OptionalNullable.getFrom(courierPickupAt);
    }

    /**
     * Internal Getter for CourierPickupWindowDuration.
     * The time period after `courier_pickup_at` in which the courier should pick up the order. The
     * duration must be in RFC 3339 format (for example, "P1W3D").
     * @return Returns the Internal String
     */
    @JsonGetter("courier_pickup_window_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCourierPickupWindowDuration() {
        return this.courierPickupWindowDuration;
    }

    /**
     * Getter for CourierPickupWindowDuration.
     * The time period after `courier_pickup_at` in which the courier should pick up the order. The
     * duration must be in RFC 3339 format (for example, "P1W3D").
     * @return Returns the String
     */
    @JsonIgnore
    public String getCourierPickupWindowDuration() {
        return OptionalNullable.getFrom(courierPickupWindowDuration);
    }

    /**
     * Internal Getter for IsNoContactDelivery.
     * Whether the delivery is preferred to be no contact.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_no_contact_delivery")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsNoContactDelivery() {
        return this.isNoContactDelivery;
    }

    /**
     * Getter for IsNoContactDelivery.
     * Whether the delivery is preferred to be no contact.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsNoContactDelivery() {
        return OptionalNullable.getFrom(isNoContactDelivery);
    }

    /**
     * Internal Getter for DropoffNotes.
     * A note to provide additional instructions about how to deliver the order.
     * @return Returns the Internal String
     */
    @JsonGetter("dropoff_notes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDropoffNotes() {
        return this.dropoffNotes;
    }

    /**
     * Getter for DropoffNotes.
     * A note to provide additional instructions about how to deliver the order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDropoffNotes() {
        return OptionalNullable.getFrom(dropoffNotes);
    }

    /**
     * Internal Getter for CourierProviderName.
     * The name of the courier provider.
     * @return Returns the Internal String
     */
    @JsonGetter("courier_provider_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCourierProviderName() {
        return this.courierProviderName;
    }

    /**
     * Getter for CourierProviderName.
     * The name of the courier provider.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCourierProviderName() {
        return OptionalNullable.getFrom(courierProviderName);
    }

    /**
     * Internal Getter for CourierSupportPhoneNumber.
     * The support phone number of the courier.
     * @return Returns the Internal String
     */
    @JsonGetter("courier_support_phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCourierSupportPhoneNumber() {
        return this.courierSupportPhoneNumber;
    }

    /**
     * Getter for CourierSupportPhoneNumber.
     * The support phone number of the courier.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCourierSupportPhoneNumber() {
        return OptionalNullable.getFrom(courierSupportPhoneNumber);
    }

    /**
     * Internal Getter for SquareDeliveryId.
     * The identifier for the delivery created by Square.
     * @return Returns the Internal String
     */
    @JsonGetter("square_delivery_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSquareDeliveryId() {
        return this.squareDeliveryId;
    }

    /**
     * Getter for SquareDeliveryId.
     * The identifier for the delivery created by Square.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSquareDeliveryId() {
        return OptionalNullable.getFrom(squareDeliveryId);
    }

    /**
     * Internal Getter for ExternalDeliveryId.
     * The identifier for the delivery created by the third-party courier service.
     * @return Returns the Internal String
     */
    @JsonGetter("external_delivery_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetExternalDeliveryId() {
        return this.externalDeliveryId;
    }

    /**
     * Getter for ExternalDeliveryId.
     * The identifier for the delivery created by the third-party courier service.
     * @return Returns the String
     */
    @JsonIgnore
    public String getExternalDeliveryId() {
        return OptionalNullable.getFrom(externalDeliveryId);
    }

    /**
     * Internal Getter for ManagedDelivery.
     * The flag to indicate the delivery is managed by a third party (ie DoorDash), which means we
     * may not receive all recipient information for PII purposes.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("managed_delivery")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetManagedDelivery() {
        return this.managedDelivery;
    }

    /**
     * Getter for ManagedDelivery.
     * The flag to indicate the delivery is managed by a third party (ie DoorDash), which means we
     * may not receive all recipient information for PII purposes.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getManagedDelivery() {
        return OptionalNullable.getFrom(managedDelivery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, scheduleType, placedAt, deliverAt, prepTimeDuration,
                deliveryWindowDuration, note, completedAt, inProgressAt, rejectedAt, readyAt,
                deliveredAt, canceledAt, cancelReason, courierPickupAt, courierPickupWindowDuration,
                isNoContactDelivery, dropoffNotes, courierProviderName, courierSupportPhoneNumber,
                squareDeliveryId, externalDeliveryId, managedDelivery);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillmentDeliveryDetails)) {
            return false;
        }
        OrderFulfillmentDeliveryDetails other = (OrderFulfillmentDeliveryDetails) obj;
        return Objects.equals(recipient, other.recipient)
            && Objects.equals(scheduleType, other.scheduleType)
            && Objects.equals(placedAt, other.placedAt)
            && Objects.equals(deliverAt, other.deliverAt)
            && Objects.equals(prepTimeDuration, other.prepTimeDuration)
            && Objects.equals(deliveryWindowDuration, other.deliveryWindowDuration)
            && Objects.equals(note, other.note)
            && Objects.equals(completedAt, other.completedAt)
            && Objects.equals(inProgressAt, other.inProgressAt)
            && Objects.equals(rejectedAt, other.rejectedAt)
            && Objects.equals(readyAt, other.readyAt)
            && Objects.equals(deliveredAt, other.deliveredAt)
            && Objects.equals(canceledAt, other.canceledAt)
            && Objects.equals(cancelReason, other.cancelReason)
            && Objects.equals(courierPickupAt, other.courierPickupAt)
            && Objects.equals(courierPickupWindowDuration, other.courierPickupWindowDuration)
            && Objects.equals(isNoContactDelivery, other.isNoContactDelivery)
            && Objects.equals(dropoffNotes, other.dropoffNotes)
            && Objects.equals(courierProviderName, other.courierProviderName)
            && Objects.equals(courierSupportPhoneNumber, other.courierSupportPhoneNumber)
            && Objects.equals(squareDeliveryId, other.squareDeliveryId)
            && Objects.equals(externalDeliveryId, other.externalDeliveryId)
            && Objects.equals(managedDelivery, other.managedDelivery);
    }

    /**
     * Converts this OrderFulfillmentDeliveryDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillmentDeliveryDetails [" + "recipient=" + recipient + ", scheduleType="
                + scheduleType + ", placedAt=" + placedAt + ", deliverAt=" + deliverAt
                + ", prepTimeDuration=" + prepTimeDuration + ", deliveryWindowDuration="
                + deliveryWindowDuration + ", note=" + note + ", completedAt=" + completedAt
                + ", inProgressAt=" + inProgressAt + ", rejectedAt=" + rejectedAt + ", readyAt="
                + readyAt + ", deliveredAt=" + deliveredAt + ", canceledAt=" + canceledAt
                + ", cancelReason=" + cancelReason + ", courierPickupAt=" + courierPickupAt
                + ", courierPickupWindowDuration=" + courierPickupWindowDuration
                + ", isNoContactDelivery=" + isNoContactDelivery + ", dropoffNotes=" + dropoffNotes
                + ", courierProviderName=" + courierProviderName + ", courierSupportPhoneNumber="
                + courierSupportPhoneNumber + ", squareDeliveryId=" + squareDeliveryId
                + ", externalDeliveryId=" + externalDeliveryId + ", managedDelivery="
                + managedDelivery + "]";
    }

    /**
     * Builds a new {@link OrderFulfillmentDeliveryDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentDeliveryDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .recipient(getRecipient())
                .scheduleType(getScheduleType())
                .placedAt(getPlacedAt())
                .inProgressAt(getInProgressAt())
                .rejectedAt(getRejectedAt())
                .readyAt(getReadyAt())
                .deliveredAt(getDeliveredAt())
                .canceledAt(getCanceledAt());
        builder.deliverAt = internalGetDeliverAt();
        builder.prepTimeDuration = internalGetPrepTimeDuration();
        builder.deliveryWindowDuration = internalGetDeliveryWindowDuration();
        builder.note = internalGetNote();
        builder.completedAt = internalGetCompletedAt();
        builder.cancelReason = internalGetCancelReason();
        builder.courierPickupAt = internalGetCourierPickupAt();
        builder.courierPickupWindowDuration = internalGetCourierPickupWindowDuration();
        builder.isNoContactDelivery = internalGetIsNoContactDelivery();
        builder.dropoffNotes = internalGetDropoffNotes();
        builder.courierProviderName = internalGetCourierProviderName();
        builder.courierSupportPhoneNumber = internalGetCourierSupportPhoneNumber();
        builder.squareDeliveryId = internalGetSquareDeliveryId();
        builder.externalDeliveryId = internalGetExternalDeliveryId();
        builder.managedDelivery = internalGetManagedDelivery();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentDeliveryDetails}.
     */
    public static class Builder {
        private OrderFulfillmentRecipient recipient;
        private String scheduleType;
        private String placedAt;
        private OptionalNullable<String> deliverAt;
        private OptionalNullable<String> prepTimeDuration;
        private OptionalNullable<String> deliveryWindowDuration;
        private OptionalNullable<String> note;
        private OptionalNullable<String> completedAt;
        private String inProgressAt;
        private String rejectedAt;
        private String readyAt;
        private String deliveredAt;
        private String canceledAt;
        private OptionalNullable<String> cancelReason;
        private OptionalNullable<String> courierPickupAt;
        private OptionalNullable<String> courierPickupWindowDuration;
        private OptionalNullable<Boolean> isNoContactDelivery;
        private OptionalNullable<String> dropoffNotes;
        private OptionalNullable<String> courierProviderName;
        private OptionalNullable<String> courierSupportPhoneNumber;
        private OptionalNullable<String> squareDeliveryId;
        private OptionalNullable<String> externalDeliveryId;
        private OptionalNullable<Boolean> managedDelivery;



        /**
         * Setter for recipient.
         * @param  recipient  OrderFulfillmentRecipient value for recipient.
         * @return Builder
         */
        public Builder recipient(OrderFulfillmentRecipient recipient) {
            this.recipient = recipient;
            return this;
        }

        /**
         * Setter for scheduleType.
         * @param  scheduleType  String value for scheduleType.
         * @return Builder
         */
        public Builder scheduleType(String scheduleType) {
            this.scheduleType = scheduleType;
            return this;
        }

        /**
         * Setter for placedAt.
         * @param  placedAt  String value for placedAt.
         * @return Builder
         */
        public Builder placedAt(String placedAt) {
            this.placedAt = placedAt;
            return this;
        }

        /**
         * Setter for deliverAt.
         * @param  deliverAt  String value for deliverAt.
         * @return Builder
         */
        public Builder deliverAt(String deliverAt) {
            this.deliverAt = OptionalNullable.of(deliverAt);
            return this;
        }

        /**
         * UnSetter for deliverAt.
         * @return Builder
         */
        public Builder unsetDeliverAt() {
            deliverAt = null;
            return this;
        }

        /**
         * Setter for prepTimeDuration.
         * @param  prepTimeDuration  String value for prepTimeDuration.
         * @return Builder
         */
        public Builder prepTimeDuration(String prepTimeDuration) {
            this.prepTimeDuration = OptionalNullable.of(prepTimeDuration);
            return this;
        }

        /**
         * UnSetter for prepTimeDuration.
         * @return Builder
         */
        public Builder unsetPrepTimeDuration() {
            prepTimeDuration = null;
            return this;
        }

        /**
         * Setter for deliveryWindowDuration.
         * @param  deliveryWindowDuration  String value for deliveryWindowDuration.
         * @return Builder
         */
        public Builder deliveryWindowDuration(String deliveryWindowDuration) {
            this.deliveryWindowDuration = OptionalNullable.of(deliveryWindowDuration);
            return this;
        }

        /**
         * UnSetter for deliveryWindowDuration.
         * @return Builder
         */
        public Builder unsetDeliveryWindowDuration() {
            deliveryWindowDuration = null;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = OptionalNullable.of(note);
            return this;
        }

        /**
         * UnSetter for note.
         * @return Builder
         */
        public Builder unsetNote() {
            note = null;
            return this;
        }

        /**
         * Setter for completedAt.
         * @param  completedAt  String value for completedAt.
         * @return Builder
         */
        public Builder completedAt(String completedAt) {
            this.completedAt = OptionalNullable.of(completedAt);
            return this;
        }

        /**
         * UnSetter for completedAt.
         * @return Builder
         */
        public Builder unsetCompletedAt() {
            completedAt = null;
            return this;
        }

        /**
         * Setter for inProgressAt.
         * @param  inProgressAt  String value for inProgressAt.
         * @return Builder
         */
        public Builder inProgressAt(String inProgressAt) {
            this.inProgressAt = inProgressAt;
            return this;
        }

        /**
         * Setter for rejectedAt.
         * @param  rejectedAt  String value for rejectedAt.
         * @return Builder
         */
        public Builder rejectedAt(String rejectedAt) {
            this.rejectedAt = rejectedAt;
            return this;
        }

        /**
         * Setter for readyAt.
         * @param  readyAt  String value for readyAt.
         * @return Builder
         */
        public Builder readyAt(String readyAt) {
            this.readyAt = readyAt;
            return this;
        }

        /**
         * Setter for deliveredAt.
         * @param  deliveredAt  String value for deliveredAt.
         * @return Builder
         */
        public Builder deliveredAt(String deliveredAt) {
            this.deliveredAt = deliveredAt;
            return this;
        }

        /**
         * Setter for canceledAt.
         * @param  canceledAt  String value for canceledAt.
         * @return Builder
         */
        public Builder canceledAt(String canceledAt) {
            this.canceledAt = canceledAt;
            return this;
        }

        /**
         * Setter for cancelReason.
         * @param  cancelReason  String value for cancelReason.
         * @return Builder
         */
        public Builder cancelReason(String cancelReason) {
            this.cancelReason = OptionalNullable.of(cancelReason);
            return this;
        }

        /**
         * UnSetter for cancelReason.
         * @return Builder
         */
        public Builder unsetCancelReason() {
            cancelReason = null;
            return this;
        }

        /**
         * Setter for courierPickupAt.
         * @param  courierPickupAt  String value for courierPickupAt.
         * @return Builder
         */
        public Builder courierPickupAt(String courierPickupAt) {
            this.courierPickupAt = OptionalNullable.of(courierPickupAt);
            return this;
        }

        /**
         * UnSetter for courierPickupAt.
         * @return Builder
         */
        public Builder unsetCourierPickupAt() {
            courierPickupAt = null;
            return this;
        }

        /**
         * Setter for courierPickupWindowDuration.
         * @param  courierPickupWindowDuration  String value for courierPickupWindowDuration.
         * @return Builder
         */
        public Builder courierPickupWindowDuration(String courierPickupWindowDuration) {
            this.courierPickupWindowDuration = OptionalNullable.of(courierPickupWindowDuration);
            return this;
        }

        /**
         * UnSetter for courierPickupWindowDuration.
         * @return Builder
         */
        public Builder unsetCourierPickupWindowDuration() {
            courierPickupWindowDuration = null;
            return this;
        }

        /**
         * Setter for isNoContactDelivery.
         * @param  isNoContactDelivery  Boolean value for isNoContactDelivery.
         * @return Builder
         */
        public Builder isNoContactDelivery(Boolean isNoContactDelivery) {
            this.isNoContactDelivery = OptionalNullable.of(isNoContactDelivery);
            return this;
        }

        /**
         * UnSetter for isNoContactDelivery.
         * @return Builder
         */
        public Builder unsetIsNoContactDelivery() {
            isNoContactDelivery = null;
            return this;
        }

        /**
         * Setter for dropoffNotes.
         * @param  dropoffNotes  String value for dropoffNotes.
         * @return Builder
         */
        public Builder dropoffNotes(String dropoffNotes) {
            this.dropoffNotes = OptionalNullable.of(dropoffNotes);
            return this;
        }

        /**
         * UnSetter for dropoffNotes.
         * @return Builder
         */
        public Builder unsetDropoffNotes() {
            dropoffNotes = null;
            return this;
        }

        /**
         * Setter for courierProviderName.
         * @param  courierProviderName  String value for courierProviderName.
         * @return Builder
         */
        public Builder courierProviderName(String courierProviderName) {
            this.courierProviderName = OptionalNullable.of(courierProviderName);
            return this;
        }

        /**
         * UnSetter for courierProviderName.
         * @return Builder
         */
        public Builder unsetCourierProviderName() {
            courierProviderName = null;
            return this;
        }

        /**
         * Setter for courierSupportPhoneNumber.
         * @param  courierSupportPhoneNumber  String value for courierSupportPhoneNumber.
         * @return Builder
         */
        public Builder courierSupportPhoneNumber(String courierSupportPhoneNumber) {
            this.courierSupportPhoneNumber = OptionalNullable.of(courierSupportPhoneNumber);
            return this;
        }

        /**
         * UnSetter for courierSupportPhoneNumber.
         * @return Builder
         */
        public Builder unsetCourierSupportPhoneNumber() {
            courierSupportPhoneNumber = null;
            return this;
        }

        /**
         * Setter for squareDeliveryId.
         * @param  squareDeliveryId  String value for squareDeliveryId.
         * @return Builder
         */
        public Builder squareDeliveryId(String squareDeliveryId) {
            this.squareDeliveryId = OptionalNullable.of(squareDeliveryId);
            return this;
        }

        /**
         * UnSetter for squareDeliveryId.
         * @return Builder
         */
        public Builder unsetSquareDeliveryId() {
            squareDeliveryId = null;
            return this;
        }

        /**
         * Setter for externalDeliveryId.
         * @param  externalDeliveryId  String value for externalDeliveryId.
         * @return Builder
         */
        public Builder externalDeliveryId(String externalDeliveryId) {
            this.externalDeliveryId = OptionalNullable.of(externalDeliveryId);
            return this;
        }

        /**
         * UnSetter for externalDeliveryId.
         * @return Builder
         */
        public Builder unsetExternalDeliveryId() {
            externalDeliveryId = null;
            return this;
        }

        /**
         * Setter for managedDelivery.
         * @param  managedDelivery  Boolean value for managedDelivery.
         * @return Builder
         */
        public Builder managedDelivery(Boolean managedDelivery) {
            this.managedDelivery = OptionalNullable.of(managedDelivery);
            return this;
        }

        /**
         * UnSetter for managedDelivery.
         * @return Builder
         */
        public Builder unsetManagedDelivery() {
            managedDelivery = null;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentDeliveryDetails} object using the set fields.
         * @return {@link OrderFulfillmentDeliveryDetails}
         */
        public OrderFulfillmentDeliveryDetails build() {
            return new OrderFulfillmentDeliveryDetails(recipient, scheduleType, placedAt, deliverAt,
                    prepTimeDuration, deliveryWindowDuration, note, completedAt, inProgressAt,
                    rejectedAt, readyAt, deliveredAt, canceledAt, cancelReason, courierPickupAt,
                    courierPickupWindowDuration, isNoContactDelivery, dropoffNotes,
                    courierProviderName, courierSupportPhoneNumber, squareDeliveryId,
                    externalDeliveryId, managedDelivery);
        }
    }
}
