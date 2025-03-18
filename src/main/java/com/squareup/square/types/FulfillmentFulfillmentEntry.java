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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = FulfillmentFulfillmentEntry.Builder.class)
public final class FulfillmentFulfillmentEntry {
    private final Optional<String> uid;

    private final String lineItemUid;

    private final String quantity;

    private final Optional<Map<String, Optional<String>>> metadata;

    private final Map<String, Object> additionalProperties;

    private FulfillmentFulfillmentEntry(
            Optional<String> uid,
            String lineItemUid,
            String quantity,
            Optional<Map<String, Optional<String>>> metadata,
            Map<String, Object> additionalProperties) {
        this.uid = uid;
        this.lineItemUid = lineItemUid;
        this.quantity = quantity;
        this.metadata = metadata;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique ID that identifies the fulfillment entry only within this order.
     */
    @JsonIgnore
    public Optional<String> getUid() {
        if (uid == null) {
            return Optional.empty();
        }
        return uid;
    }

    /**
     * @return The <code>uid</code> from the order line item.
     */
    @JsonProperty("line_item_uid")
    public String getLineItemUid() {
        return lineItemUid;
    }

    /**
     * @return The quantity of the line item being fulfilled, formatted as a decimal number.
     * For example, <code>&quot;3&quot;</code>.
     * <p>Fulfillments for line items with a <code>quantity_unit</code> can have non-integer quantities.
     * For example, <code>&quot;1.70000&quot;</code>.</p>
     */
    @JsonProperty("quantity")
    public String getQuantity() {
        return quantity;
    }

    /**
     * @return Application-defined data attached to this fulfillment entry. Metadata fields are intended
     * to store descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns it
     * in relevant API calls. Do not use metadata to store any sensitive information (such as personally
     * identifiable information or card details).
     * <p>Keys written by applications must be 60 characters or less and must be in the character set
     * <code>[a-zA-Z0-9_-]</code>. Entries can also include metadata generated by Square. These keys are prefixed
     * with a namespace, separated from the key with a ':' character.</p>
     * <p>Values have a maximum length of 255 characters.</p>
     * <p>An application can have up to 10 entries per metadata field.</p>
     * <p>Entries written by applications are private and can only be read or modified by the same
     * application.</p>
     * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/metadata">Metadata</a>.</p>
     */
    @JsonIgnore
    public Optional<Map<String, Optional<String>>> getMetadata() {
        if (metadata == null) {
            return Optional.empty();
        }
        return metadata;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("uid")
    private Optional<String> _getUid() {
        return uid;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("metadata")
    private Optional<Map<String, Optional<String>>> _getMetadata() {
        return metadata;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FulfillmentFulfillmentEntry && equalTo((FulfillmentFulfillmentEntry) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FulfillmentFulfillmentEntry other) {
        return uid.equals(other.uid)
                && lineItemUid.equals(other.lineItemUid)
                && quantity.equals(other.quantity)
                && metadata.equals(other.metadata);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.uid, this.lineItemUid, this.quantity, this.metadata);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LineItemUidStage builder() {
        return new Builder();
    }

    public interface LineItemUidStage {
        QuantityStage lineItemUid(@NotNull String lineItemUid);

        Builder from(FulfillmentFulfillmentEntry other);
    }

    public interface QuantityStage {
        _FinalStage quantity(@NotNull String quantity);
    }

    public interface _FinalStage {
        FulfillmentFulfillmentEntry build();

        _FinalStage uid(Optional<String> uid);

        _FinalStage uid(String uid);

        _FinalStage uid(Nullable<String> uid);

        _FinalStage metadata(Optional<Map<String, Optional<String>>> metadata);

        _FinalStage metadata(Map<String, Optional<String>> metadata);

        _FinalStage metadata(Nullable<Map<String, Optional<String>>> metadata);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LineItemUidStage, QuantityStage, _FinalStage {
        private String lineItemUid;

        private String quantity;

        private Optional<Map<String, Optional<String>>> metadata = Optional.empty();

        private Optional<String> uid = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(FulfillmentFulfillmentEntry other) {
            uid(other.getUid());
            lineItemUid(other.getLineItemUid());
            quantity(other.getQuantity());
            metadata(other.getMetadata());
            return this;
        }

        /**
         * <p>The <code>uid</code> from the order line item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("line_item_uid")
        public QuantityStage lineItemUid(@NotNull String lineItemUid) {
            this.lineItemUid = Objects.requireNonNull(lineItemUid, "lineItemUid must not be null");
            return this;
        }

        /**
         * <p>The quantity of the line item being fulfilled, formatted as a decimal number.
         * For example, <code>&quot;3&quot;</code>.</p>
         * <p>Fulfillments for line items with a <code>quantity_unit</code> can have non-integer quantities.
         * For example, <code>&quot;1.70000&quot;</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("quantity")
        public _FinalStage quantity(@NotNull String quantity) {
            this.quantity = Objects.requireNonNull(quantity, "quantity must not be null");
            return this;
        }

        /**
         * <p>Application-defined data attached to this fulfillment entry. Metadata fields are intended
         * to store descriptive references or associations with an entity in another system or store brief
         * information about the object. Square does not process this field; it only stores and returns it
         * in relevant API calls. Do not use metadata to store any sensitive information (such as personally
         * identifiable information or card details).</p>
         * <p>Keys written by applications must be 60 characters or less and must be in the character set
         * <code>[a-zA-Z0-9_-]</code>. Entries can also include metadata generated by Square. These keys are prefixed
         * with a namespace, separated from the key with a ':' character.</p>
         * <p>Values have a maximum length of 255 characters.</p>
         * <p>An application can have up to 10 entries per metadata field.</p>
         * <p>Entries written by applications are private and can only be read or modified by the same
         * application.</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/metadata">Metadata</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage metadata(Nullable<Map<String, Optional<String>>> metadata) {
            if (metadata.isNull()) {
                this.metadata = null;
            } else if (metadata.isEmpty()) {
                this.metadata = Optional.empty();
            } else {
                this.metadata = Optional.of(metadata.get());
            }
            return this;
        }

        /**
         * <p>Application-defined data attached to this fulfillment entry. Metadata fields are intended
         * to store descriptive references or associations with an entity in another system or store brief
         * information about the object. Square does not process this field; it only stores and returns it
         * in relevant API calls. Do not use metadata to store any sensitive information (such as personally
         * identifiable information or card details).</p>
         * <p>Keys written by applications must be 60 characters or less and must be in the character set
         * <code>[a-zA-Z0-9_-]</code>. Entries can also include metadata generated by Square. These keys are prefixed
         * with a namespace, separated from the key with a ':' character.</p>
         * <p>Values have a maximum length of 255 characters.</p>
         * <p>An application can have up to 10 entries per metadata field.</p>
         * <p>Entries written by applications are private and can only be read or modified by the same
         * application.</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/metadata">Metadata</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage metadata(Map<String, Optional<String>> metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public _FinalStage metadata(Optional<Map<String, Optional<String>>> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * <p>A unique ID that identifies the fulfillment entry only within this order.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage uid(Nullable<String> uid) {
            if (uid.isNull()) {
                this.uid = null;
            } else if (uid.isEmpty()) {
                this.uid = Optional.empty();
            } else {
                this.uid = Optional.of(uid.get());
            }
            return this;
        }

        /**
         * <p>A unique ID that identifies the fulfillment entry only within this order.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage uid(String uid) {
            this.uid = Optional.ofNullable(uid);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "uid", nulls = Nulls.SKIP)
        public _FinalStage uid(Optional<String> uid) {
            this.uid = uid;
            return this;
        }

        @java.lang.Override
        public FulfillmentFulfillmentEntry build() {
            return new FulfillmentFulfillmentEntry(uid, lineItemUid, quantity, metadata, additionalProperties);
        }
    }
}
