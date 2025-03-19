package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillment type.
 */
public class OrderFulfillment {
    private final OptionalNullable<String> uid;
    private final String type;
    private final String state;
    private final String lineItemApplication;
    private final List<OrderFulfillmentFulfillmentEntry> entries;
    private final OptionalNullable<Map<String, String>> metadata;
    private final OrderFulfillmentPickupDetails pickupDetails;
    private final OrderFulfillmentShipmentDetails shipmentDetails;
    private final OrderFulfillmentDeliveryDetails deliveryDetails;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  type  String value for type.
     * @param  state  String value for state.
     * @param  lineItemApplication  String value for lineItemApplication.
     * @param  entries  List of OrderFulfillmentFulfillmentEntry value for entries.
     * @param  metadata  Map of String, value for metadata.
     * @param  pickupDetails  OrderFulfillmentPickupDetails value for pickupDetails.
     * @param  shipmentDetails  OrderFulfillmentShipmentDetails value for shipmentDetails.
     * @param  deliveryDetails  OrderFulfillmentDeliveryDetails value for deliveryDetails.
     */
    @JsonCreator
    public OrderFulfillment(
            @JsonProperty("uid") String uid,
            @JsonProperty("type") String type,
            @JsonProperty("state") String state,
            @JsonProperty("line_item_application") String lineItemApplication,
            @JsonProperty("entries") List<OrderFulfillmentFulfillmentEntry> entries,
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("pickup_details") OrderFulfillmentPickupDetails pickupDetails,
            @JsonProperty("shipment_details") OrderFulfillmentShipmentDetails shipmentDetails,
            @JsonProperty("delivery_details") OrderFulfillmentDeliveryDetails deliveryDetails) {
        this.uid = OptionalNullable.of(uid);
        this.type = type;
        this.state = state;
        this.lineItemApplication = lineItemApplication;
        this.entries = entries;
        this.metadata = OptionalNullable.of(metadata);
        this.pickupDetails = pickupDetails;
        this.shipmentDetails = shipmentDetails;
        this.deliveryDetails = deliveryDetails;
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  type  String value for type.
     * @param  state  String value for state.
     * @param  lineItemApplication  String value for lineItemApplication.
     * @param  entries  List of OrderFulfillmentFulfillmentEntry value for entries.
     * @param  metadata  Map of String, value for metadata.
     * @param  pickupDetails  OrderFulfillmentPickupDetails value for pickupDetails.
     * @param  shipmentDetails  OrderFulfillmentShipmentDetails value for shipmentDetails.
     * @param  deliveryDetails  OrderFulfillmentDeliveryDetails value for deliveryDetails.
     */
    protected OrderFulfillment(
            OptionalNullable<String> uid,
            String type,
            String state,
            String lineItemApplication,
            List<OrderFulfillmentFulfillmentEntry> entries,
            OptionalNullable<Map<String, String>> metadata,
            OrderFulfillmentPickupDetails pickupDetails,
            OrderFulfillmentShipmentDetails shipmentDetails,
            OrderFulfillmentDeliveryDetails deliveryDetails) {
        this.uid = uid;
        this.type = type;
        this.state = state;
        this.lineItemApplication = lineItemApplication;
        this.entries = entries;
        this.metadata = metadata;
        this.pickupDetails = pickupDetails;
        this.shipmentDetails = shipmentDetails;
        this.deliveryDetails = deliveryDetails;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the fulfillment only within this order.
     * @return Returns the Internal String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUid() {
        return this.uid;
    }

    /**
     * Getter for Uid.
     * A unique ID that identifies the fulfillment only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Getter for Type.
     * The type of fulfillment.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for State.
     * The current state of this fulfillment.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Getter for LineItemApplication.
     * The `line_item_application` describes what order line items this fulfillment applies to. It
     * can be `ALL` or `ENTRY_LIST` with a supplied list of fulfillment entries.
     * @return Returns the String
     */
    @JsonGetter("line_item_application")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLineItemApplication() {
        return lineItemApplication;
    }

    /**
     * Getter for Entries.
     * A list of entries pertaining to the fulfillment of an order. Each entry must reference a
     * valid `uid` for an order line item in the `line_item_uid` field, as well as a `quantity` to
     * fulfill. Multiple entries can reference the same line item `uid`, as long as the total
     * quantity among all fulfillment entries referencing a single line item does not exceed the
     * quantity of the order's line item itself. An order cannot be marked as `COMPLETED` before all
     * fulfillments are `COMPLETED`, `CANCELED`, or `FAILED`. Fulfillments can be created and
     * completed independently before order completion.
     * @return Returns the List of OrderFulfillmentFulfillmentEntry
     */
    @JsonGetter("entries")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<OrderFulfillmentFulfillmentEntry> getEntries() {
        return entries;
    }

    /**
     * Internal Getter for Metadata.
     * Application-defined data attached to this fulfillment. Metadata fields are intended to store
     * descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns
     * it in relevant API calls. Do not use metadata to store any sensitive information (such as
     * personally identifiable information or card details). Keys written by applications must be 60
     * characters or less and must be in the character set `[a-zA-Z0-9_-]`. Entries can also include
     * metadata generated by Square. These keys are prefixed with a namespace, separated from the
     * key with a ':' character. Values have a maximum length of 255 characters. An application can
     * have up to 10 entries per metadata field. Entries written by applications are private and can
     * only be read or modified by the same application. For more information, see
     * [Metadata](https://developer.squareup.com/docs/build-basics/metadata).
     * @return Returns the Internal Map of String, String
     */
    @JsonGetter("metadata")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Map<String, String>> internalGetMetadata() {
        return this.metadata;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this fulfillment. Metadata fields are intended to store
     * descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns
     * it in relevant API calls. Do not use metadata to store any sensitive information (such as
     * personally identifiable information or card details). Keys written by applications must be 60
     * characters or less and must be in the character set `[a-zA-Z0-9_-]`. Entries can also include
     * metadata generated by Square. These keys are prefixed with a namespace, separated from the
     * key with a ':' character. Values have a maximum length of 255 characters. An application can
     * have up to 10 entries per metadata field. Entries written by applications are private and can
     * only be read or modified by the same application. For more information, see
     * [Metadata](https://developer.squareup.com/docs/build-basics/metadata).
     * @return Returns the Map of String, String
     */
    @JsonIgnore
    public Map<String, String> getMetadata() {
        return OptionalNullable.getFrom(metadata);
    }

    /**
     * Getter for PickupDetails.
     * Contains details necessary to fulfill a pickup order.
     * @return Returns the OrderFulfillmentPickupDetails
     */
    @JsonGetter("pickup_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderFulfillmentPickupDetails getPickupDetails() {
        return pickupDetails;
    }

    /**
     * Getter for ShipmentDetails.
     * Contains the details necessary to fulfill a shipment order.
     * @return Returns the OrderFulfillmentShipmentDetails
     */
    @JsonGetter("shipment_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderFulfillmentShipmentDetails getShipmentDetails() {
        return shipmentDetails;
    }

    /**
     * Getter for DeliveryDetails.
     * Describes delivery details of an order fulfillment.
     * @return Returns the OrderFulfillmentDeliveryDetails
     */
    @JsonGetter("delivery_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderFulfillmentDeliveryDetails getDeliveryDetails() {
        return deliveryDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                uid,
                type,
                state,
                lineItemApplication,
                entries,
                metadata,
                pickupDetails,
                shipmentDetails,
                deliveryDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillment)) {
            return false;
        }
        OrderFulfillment other = (OrderFulfillment) obj;
        return Objects.equals(uid, other.uid)
                && Objects.equals(type, other.type)
                && Objects.equals(state, other.state)
                && Objects.equals(lineItemApplication, other.lineItemApplication)
                && Objects.equals(entries, other.entries)
                && Objects.equals(metadata, other.metadata)
                && Objects.equals(pickupDetails, other.pickupDetails)
                && Objects.equals(shipmentDetails, other.shipmentDetails)
                && Objects.equals(deliveryDetails, other.deliveryDetails);
    }

    /**
     * Converts this OrderFulfillment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillment [" + "uid=" + uid + ", type=" + type + ", state=" + state
                + ", lineItemApplication=" + lineItemApplication + ", entries=" + entries
                + ", metadata=" + metadata + ", pickupDetails=" + pickupDetails
                + ", shipmentDetails=" + shipmentDetails + ", deliveryDetails=" + deliveryDetails
                + "]";
    }

    /**
     * Builds a new {@link OrderFulfillment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .state(getState())
                .lineItemApplication(getLineItemApplication())
                .entries(getEntries())
                .pickupDetails(getPickupDetails())
                .shipmentDetails(getShipmentDetails())
                .deliveryDetails(getDeliveryDetails());
        builder.uid = internalGetUid();
        builder.metadata = internalGetMetadata();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillment}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private String type;
        private String state;
        private String lineItemApplication;
        private List<OrderFulfillmentFulfillmentEntry> entries;
        private OptionalNullable<Map<String, String>> metadata;
        private OrderFulfillmentPickupDetails pickupDetails;
        private OrderFulfillmentShipmentDetails shipmentDetails;
        private OrderFulfillmentDeliveryDetails deliveryDetails;

        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = OptionalNullable.of(uid);
            return this;
        }

        /**
         * UnSetter for uid.
         * @return Builder
         */
        public Builder unsetUid() {
            uid = null;
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
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for lineItemApplication.
         * @param  lineItemApplication  String value for lineItemApplication.
         * @return Builder
         */
        public Builder lineItemApplication(String lineItemApplication) {
            this.lineItemApplication = lineItemApplication;
            return this;
        }

        /**
         * Setter for entries.
         * @param  entries  List of OrderFulfillmentFulfillmentEntry value for entries.
         * @return Builder
         */
        public Builder entries(List<OrderFulfillmentFulfillmentEntry> entries) {
            this.entries = entries;
            return this;
        }

        /**
         * Setter for metadata.
         * @param  metadata  Map of String, value for metadata.
         * @return Builder
         */
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = OptionalNullable.of(metadata);
            return this;
        }

        /**
         * UnSetter for metadata.
         * @return Builder
         */
        public Builder unsetMetadata() {
            metadata = null;
            return this;
        }

        /**
         * Setter for pickupDetails.
         * @param  pickupDetails  OrderFulfillmentPickupDetails value for pickupDetails.
         * @return Builder
         */
        public Builder pickupDetails(OrderFulfillmentPickupDetails pickupDetails) {
            this.pickupDetails = pickupDetails;
            return this;
        }

        /**
         * Setter for shipmentDetails.
         * @param  shipmentDetails  OrderFulfillmentShipmentDetails value for shipmentDetails.
         * @return Builder
         */
        public Builder shipmentDetails(OrderFulfillmentShipmentDetails shipmentDetails) {
            this.shipmentDetails = shipmentDetails;
            return this;
        }

        /**
         * Setter for deliveryDetails.
         * @param  deliveryDetails  OrderFulfillmentDeliveryDetails value for deliveryDetails.
         * @return Builder
         */
        public Builder deliveryDetails(OrderFulfillmentDeliveryDetails deliveryDetails) {
            this.deliveryDetails = deliveryDetails;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillment} object using the set fields.
         * @return {@link OrderFulfillment}
         */
        public OrderFulfillment build() {
            return new OrderFulfillment(
                    uid,
                    type,
                    state,
                    lineItemApplication,
                    entries,
                    metadata,
                    pickupDetails,
                    shipmentDetails,
                    deliveryDetails);
        }
    }
}
