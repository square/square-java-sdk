package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for FulfillmentFulfillmentEntry type.
 */
public class FulfillmentFulfillmentEntry {
    private final OptionalNullable<String> uid;
    private final String lineItemUid;
    private final String quantity;
    private final OptionalNullable<Map<String, String>> metadata;

    /**
     * Initialization constructor.
     * @param  lineItemUid  String value for lineItemUid.
     * @param  quantity  String value for quantity.
     * @param  uid  String value for uid.
     * @param  metadata  Map of String, value for metadata.
     */
    @JsonCreator
    public FulfillmentFulfillmentEntry(
            @JsonProperty("line_item_uid") String lineItemUid,
            @JsonProperty("quantity") String quantity,
            @JsonProperty("uid") String uid,
            @JsonProperty("metadata") Map<String, String> metadata) {
        this.uid = OptionalNullable.of(uid);
        this.lineItemUid = lineItemUid;
        this.quantity = quantity;
        this.metadata = OptionalNullable.of(metadata);
    }

    /**
     * Initialization constructor.
     * @param  lineItemUid  String value for lineItemUid.
     * @param  quantity  String value for quantity.
     * @param  uid  String value for uid.
     * @param  metadata  Map of String, value for metadata.
     */
    protected FulfillmentFulfillmentEntry(
            String lineItemUid,
            String quantity,
            OptionalNullable<String> uid,
            OptionalNullable<Map<String, String>> metadata) {
        this.uid = uid;
        this.lineItemUid = lineItemUid;
        this.quantity = quantity;
        this.metadata = metadata;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the fulfillment entry only within this order.
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
     * A unique ID that identifies the fulfillment entry only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Getter for LineItemUid.
     * The `uid` from the order line item.
     * @return Returns the String
     */
    @JsonGetter("line_item_uid")
    public String getLineItemUid() {
        return lineItemUid;
    }

    /**
     * Getter for Quantity.
     * The quantity of the line item being fulfilled, formatted as a decimal number. For example,
     * `"3"`. Fulfillments for line items with a `quantity_unit` can have non-integer quantities.
     * For example, `"1.70000"`.
     * @return Returns the String
     */
    @JsonGetter("quantity")
    public String getQuantity() {
        return quantity;
    }

    /**
     * Internal Getter for Metadata.
     * Application-defined data attached to this fulfillment entry. Metadata fields are intended to
     * store descriptive references or associations with an entity in another system or store brief
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
     * Application-defined data attached to this fulfillment entry. Metadata fields are intended to
     * store descriptive references or associations with an entity in another system or store brief
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

    @Override
    public int hashCode() {
        return Objects.hash(uid, lineItemUid, quantity, metadata);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FulfillmentFulfillmentEntry)) {
            return false;
        }
        FulfillmentFulfillmentEntry other = (FulfillmentFulfillmentEntry) obj;
        return Objects.equals(uid, other.uid)
                && Objects.equals(lineItemUid, other.lineItemUid)
                && Objects.equals(quantity, other.quantity)
                && Objects.equals(metadata, other.metadata);
    }

    /**
     * Converts this FulfillmentFulfillmentEntry into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "FulfillmentFulfillmentEntry [" + "lineItemUid=" + lineItemUid + ", quantity=" + quantity + ", uid="
                + uid + ", metadata=" + metadata + "]";
    }

    /**
     * Builds a new {@link FulfillmentFulfillmentEntry.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link FulfillmentFulfillmentEntry.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(lineItemUid, quantity);
        builder.uid = internalGetUid();
        builder.metadata = internalGetMetadata();
        return builder;
    }

    /**
     * Class to build instances of {@link FulfillmentFulfillmentEntry}.
     */
    public static class Builder {
        private String lineItemUid;
        private String quantity;
        private OptionalNullable<String> uid;
        private OptionalNullable<Map<String, String>> metadata;

        /**
         * Initialization constructor.
         * @param  lineItemUid  String value for lineItemUid.
         * @param  quantity  String value for quantity.
         */
        public Builder(String lineItemUid, String quantity) {
            this.lineItemUid = lineItemUid;
            this.quantity = quantity;
        }

        /**
         * Setter for lineItemUid.
         * @param  lineItemUid  String value for lineItemUid.
         * @return Builder
         */
        public Builder lineItemUid(String lineItemUid) {
            this.lineItemUid = lineItemUid;
            return this;
        }

        /**
         * Setter for quantity.
         * @param  quantity  String value for quantity.
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

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
         * Builds a new {@link FulfillmentFulfillmentEntry} object using the set fields.
         * @return {@link FulfillmentFulfillmentEntry}
         */
        public FulfillmentFulfillmentEntry build() {
            return new FulfillmentFulfillmentEntry(lineItemUid, quantity, uid, metadata);
        }
    }
}
