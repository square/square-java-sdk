
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
 * This is a model class for InventoryAdjustment type.
 */
public class InventoryAdjustment {
    private final String id;
    private final OptionalNullable<String> referenceId;
    private final String fromState;
    private final String toState;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<String> catalogObjectType;
    private final OptionalNullable<String> quantity;
    private final Money totalPriceMoney;
    private final OptionalNullable<String> occurredAt;
    private final String createdAt;
    private final SourceApplication source;
    private final OptionalNullable<String> employeeId;
    private final OptionalNullable<String> teamMemberId;
    private final String transactionId;
    private final String refundId;
    private final String purchaseOrderId;
    private final String goodsReceiptId;
    private final InventoryAdjustmentGroup adjustmentGroup;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  fromState  String value for fromState.
     * @param  toState  String value for toState.
     * @param  locationId  String value for locationId.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogObjectType  String value for catalogObjectType.
     * @param  quantity  String value for quantity.
     * @param  totalPriceMoney  Money value for totalPriceMoney.
     * @param  occurredAt  String value for occurredAt.
     * @param  createdAt  String value for createdAt.
     * @param  source  SourceApplication value for source.
     * @param  employeeId  String value for employeeId.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  transactionId  String value for transactionId.
     * @param  refundId  String value for refundId.
     * @param  purchaseOrderId  String value for purchaseOrderId.
     * @param  goodsReceiptId  String value for goodsReceiptId.
     * @param  adjustmentGroup  InventoryAdjustmentGroup value for adjustmentGroup.
     */
    @JsonCreator
    public InventoryAdjustment(
            @JsonProperty("id") String id,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("from_state") String fromState,
            @JsonProperty("to_state") String toState,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_object_type") String catalogObjectType,
            @JsonProperty("quantity") String quantity,
            @JsonProperty("total_price_money") Money totalPriceMoney,
            @JsonProperty("occurred_at") String occurredAt,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("source") SourceApplication source,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("transaction_id") String transactionId,
            @JsonProperty("refund_id") String refundId,
            @JsonProperty("purchase_order_id") String purchaseOrderId,
            @JsonProperty("goods_receipt_id") String goodsReceiptId,
            @JsonProperty("adjustment_group") InventoryAdjustmentGroup adjustmentGroup) {
        this.id = id;
        this.referenceId = OptionalNullable.of(referenceId);
        this.fromState = fromState;
        this.toState = toState;
        this.locationId = OptionalNullable.of(locationId);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogObjectType = OptionalNullable.of(catalogObjectType);
        this.quantity = OptionalNullable.of(quantity);
        this.totalPriceMoney = totalPriceMoney;
        this.occurredAt = OptionalNullable.of(occurredAt);
        this.createdAt = createdAt;
        this.source = source;
        this.employeeId = OptionalNullable.of(employeeId);
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.transactionId = transactionId;
        this.refundId = refundId;
        this.purchaseOrderId = purchaseOrderId;
        this.goodsReceiptId = goodsReceiptId;
        this.adjustmentGroup = adjustmentGroup;
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  fromState  String value for fromState.
     * @param  toState  String value for toState.
     * @param  locationId  String value for locationId.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogObjectType  String value for catalogObjectType.
     * @param  quantity  String value for quantity.
     * @param  totalPriceMoney  Money value for totalPriceMoney.
     * @param  occurredAt  String value for occurredAt.
     * @param  createdAt  String value for createdAt.
     * @param  source  SourceApplication value for source.
     * @param  employeeId  String value for employeeId.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  transactionId  String value for transactionId.
     * @param  refundId  String value for refundId.
     * @param  purchaseOrderId  String value for purchaseOrderId.
     * @param  goodsReceiptId  String value for goodsReceiptId.
     * @param  adjustmentGroup  InventoryAdjustmentGroup value for adjustmentGroup.
     */

    protected InventoryAdjustment(String id, OptionalNullable<String> referenceId, String fromState,
            String toState, OptionalNullable<String> locationId,
            OptionalNullable<String> catalogObjectId, OptionalNullable<String> catalogObjectType,
            OptionalNullable<String> quantity, Money totalPriceMoney,
            OptionalNullable<String> occurredAt, String createdAt, SourceApplication source,
            OptionalNullable<String> employeeId, OptionalNullable<String> teamMemberId,
            String transactionId, String refundId, String purchaseOrderId, String goodsReceiptId,
            InventoryAdjustmentGroup adjustmentGroup) {
        this.id = id;
        this.referenceId = referenceId;
        this.fromState = fromState;
        this.toState = toState;
        this.locationId = locationId;
        this.catalogObjectId = catalogObjectId;
        this.catalogObjectType = catalogObjectType;
        this.quantity = quantity;
        this.totalPriceMoney = totalPriceMoney;
        this.occurredAt = occurredAt;
        this.createdAt = createdAt;
        this.source = source;
        this.employeeId = employeeId;
        this.teamMemberId = teamMemberId;
        this.transactionId = transactionId;
        this.refundId = refundId;
        this.purchaseOrderId = purchaseOrderId;
        this.goodsReceiptId = goodsReceiptId;
        this.adjustmentGroup = adjustmentGroup;
    }

    /**
     * Getter for Id.
     * A unique ID generated by Square for the `InventoryAdjustment`.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for ReferenceId.
     * An optional ID provided by the application to tie the `InventoryAdjustment` to an external
     * system.
     * @return Returns the Internal String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for ReferenceId.
     * An optional ID provided by the application to tie the `InventoryAdjustment` to an external
     * system.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
    }

    /**
     * Getter for FromState.
     * Indicates the state of a tracked item quantity in the lifecycle of goods.
     * @return Returns the String
     */
    @JsonGetter("from_state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFromState() {
        return fromState;
    }

    /**
     * Getter for ToState.
     * Indicates the state of a tracked item quantity in the lifecycle of goods.
     * @return Returns the String
     */
    @JsonGetter("to_state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getToState() {
        return toState;
    }

    /**
     * Internal Getter for LocationId.
     * The Square-generated ID of the [Location](entity:Location) where the related quantity of
     * items is being tracked.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The Square-generated ID of the [Location](entity:Location) where the related quantity of
     * items is being tracked.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The Square-generated ID of the [CatalogObject](entity:CatalogObject) being tracked.
     * @return Returns the Internal String
     */
    @JsonGetter("catalog_object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for CatalogObjectId.
     * The Square-generated ID of the [CatalogObject](entity:CatalogObject) being tracked.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogObjectType.
     * The [type](entity:CatalogObjectType) of the [CatalogObject](entity:CatalogObject) being
     * tracked. The Inventory API supports setting and reading the `"catalog_object_type":
     * "ITEM_VARIATION"` field value. In addition, it can also read the `"catalog_object_type":
     * "ITEM"` field value that is set by the Square Restaurants app.
     * @return Returns the Internal String
     */
    @JsonGetter("catalog_object_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCatalogObjectType() {
        return this.catalogObjectType;
    }

    /**
     * Getter for CatalogObjectType.
     * The [type](entity:CatalogObjectType) of the [CatalogObject](entity:CatalogObject) being
     * tracked. The Inventory API supports setting and reading the `"catalog_object_type":
     * "ITEM_VARIATION"` field value. In addition, it can also read the `"catalog_object_type":
     * "ITEM"` field value that is set by the Square Restaurants app.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectType() {
        return OptionalNullable.getFrom(catalogObjectType);
    }

    /**
     * Internal Getter for Quantity.
     * The number of items affected by the adjustment as a decimal string. Can support up to 5
     * digits after the decimal point.
     * @return Returns the Internal String
     */
    @JsonGetter("quantity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetQuantity() {
        return this.quantity;
    }

    /**
     * Getter for Quantity.
     * The number of items affected by the adjustment as a decimal string. Can support up to 5
     * digits after the decimal point.
     * @return Returns the String
     */
    @JsonIgnore
    public String getQuantity() {
        return OptionalNullable.getFrom(quantity);
    }

    /**
     * Getter for TotalPriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_price_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTotalPriceMoney() {
        return totalPriceMoney;
    }

    /**
     * Internal Getter for OccurredAt.
     * A client-generated RFC 3339-formatted timestamp that indicates when the inventory adjustment
     * took place. For inventory adjustment updates, the `occurred_at` timestamp cannot be older
     * than 24 hours or in the future relative to the time of the request.
     * @return Returns the Internal String
     */
    @JsonGetter("occurred_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOccurredAt() {
        return this.occurredAt;
    }

    /**
     * Getter for OccurredAt.
     * A client-generated RFC 3339-formatted timestamp that indicates when the inventory adjustment
     * took place. For inventory adjustment updates, the `occurred_at` timestamp cannot be older
     * than 24 hours or in the future relative to the time of the request.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOccurredAt() {
        return OptionalNullable.getFrom(occurredAt);
    }

    /**
     * Getter for CreatedAt.
     * An RFC 3339-formatted timestamp that indicates when the inventory adjustment is received.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for Source.
     * Represents information about the application used to generate a change.
     * @return Returns the SourceApplication
     */
    @JsonGetter("source")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SourceApplication getSource() {
        return source;
    }

    /**
     * Internal Getter for EmployeeId.
     * The Square-generated ID of the [Employee](entity:Employee) responsible for the inventory
     * adjustment.
     * @return Returns the Internal String
     */
    @JsonGetter("employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for EmployeeId.
     * The Square-generated ID of the [Employee](entity:Employee) responsible for the inventory
     * adjustment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmployeeId() {
        return OptionalNullable.getFrom(employeeId);
    }

    /**
     * Internal Getter for TeamMemberId.
     * The Square-generated ID of the [Team Member](entity:TeamMember) responsible for the inventory
     * adjustment.
     * @return Returns the Internal String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for TeamMemberId.
     * The Square-generated ID of the [Team Member](entity:TeamMember) responsible for the inventory
     * adjustment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Getter for TransactionId.
     * The Square-generated ID of the [Transaction](entity:Transaction) that caused the adjustment.
     * Only relevant for payment-related state transitions.
     * @return Returns the String
     */
    @JsonGetter("transaction_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Getter for RefundId.
     * The Square-generated ID of the [Refund](entity:Refund) that caused the adjustment. Only
     * relevant for refund-related state transitions.
     * @return Returns the String
     */
    @JsonGetter("refund_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRefundId() {
        return refundId;
    }

    /**
     * Getter for PurchaseOrderId.
     * The Square-generated ID of the purchase order that caused the adjustment. Only relevant for
     * state transitions from the Square for Retail app.
     * @return Returns the String
     */
    @JsonGetter("purchase_order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    /**
     * Getter for GoodsReceiptId.
     * The Square-generated ID of the goods receipt that caused the adjustment. Only relevant for
     * state transitions from the Square for Retail app.
     * @return Returns the String
     */
    @JsonGetter("goods_receipt_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getGoodsReceiptId() {
        return goodsReceiptId;
    }

    /**
     * Getter for AdjustmentGroup.
     * @return Returns the InventoryAdjustmentGroup
     */
    @JsonGetter("adjustment_group")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InventoryAdjustmentGroup getAdjustmentGroup() {
        return adjustmentGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceId, fromState, toState, locationId, catalogObjectId,
                catalogObjectType, quantity, totalPriceMoney, occurredAt, createdAt, source,
                employeeId, teamMemberId, transactionId, refundId, purchaseOrderId, goodsReceiptId,
                adjustmentGroup);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InventoryAdjustment)) {
            return false;
        }
        InventoryAdjustment other = (InventoryAdjustment) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(fromState, other.fromState)
            && Objects.equals(toState, other.toState)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(catalogObjectType, other.catalogObjectType)
            && Objects.equals(quantity, other.quantity)
            && Objects.equals(totalPriceMoney, other.totalPriceMoney)
            && Objects.equals(occurredAt, other.occurredAt)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(source, other.source)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(transactionId, other.transactionId)
            && Objects.equals(refundId, other.refundId)
            && Objects.equals(purchaseOrderId, other.purchaseOrderId)
            && Objects.equals(goodsReceiptId, other.goodsReceiptId)
            && Objects.equals(adjustmentGroup, other.adjustmentGroup);
    }

    /**
     * Converts this InventoryAdjustment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InventoryAdjustment [" + "id=" + id + ", referenceId=" + referenceId
                + ", fromState=" + fromState + ", toState=" + toState + ", locationId=" + locationId
                + ", catalogObjectId=" + catalogObjectId + ", catalogObjectType="
                + catalogObjectType + ", quantity=" + quantity + ", totalPriceMoney="
                + totalPriceMoney + ", occurredAt=" + occurredAt + ", createdAt=" + createdAt
                + ", source=" + source + ", employeeId=" + employeeId + ", teamMemberId="
                + teamMemberId + ", transactionId=" + transactionId + ", refundId=" + refundId
                + ", purchaseOrderId=" + purchaseOrderId + ", goodsReceiptId=" + goodsReceiptId
                + ", adjustmentGroup=" + adjustmentGroup + "]";
    }

    /**
     * Builds a new {@link InventoryAdjustment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InventoryAdjustment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .fromState(getFromState())
                .toState(getToState())
                .totalPriceMoney(getTotalPriceMoney())
                .createdAt(getCreatedAt())
                .source(getSource())
                .transactionId(getTransactionId())
                .refundId(getRefundId())
                .purchaseOrderId(getPurchaseOrderId())
                .goodsReceiptId(getGoodsReceiptId())
                .adjustmentGroup(getAdjustmentGroup());
        builder.referenceId = internalGetReferenceId();
        builder.locationId = internalGetLocationId();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogObjectType = internalGetCatalogObjectType();
        builder.quantity = internalGetQuantity();
        builder.occurredAt = internalGetOccurredAt();
        builder.employeeId = internalGetEmployeeId();
        builder.teamMemberId = internalGetTeamMemberId();
        return builder;
    }

    /**
     * Class to build instances of {@link InventoryAdjustment}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> referenceId;
        private String fromState;
        private String toState;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<String> catalogObjectType;
        private OptionalNullable<String> quantity;
        private Money totalPriceMoney;
        private OptionalNullable<String> occurredAt;
        private String createdAt;
        private SourceApplication source;
        private OptionalNullable<String> employeeId;
        private OptionalNullable<String> teamMemberId;
        private String transactionId;
        private String refundId;
        private String purchaseOrderId;
        private String goodsReceiptId;
        private InventoryAdjustmentGroup adjustmentGroup;



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
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = OptionalNullable.of(referenceId);
            return this;
        }

        /**
         * UnSetter for referenceId.
         * @return Builder
         */
        public Builder unsetReferenceId() {
            referenceId = null;
            return this;
        }

        /**
         * Setter for fromState.
         * @param  fromState  String value for fromState.
         * @return Builder
         */
        public Builder fromState(String fromState) {
            this.fromState = fromState;
            return this;
        }

        /**
         * Setter for toState.
         * @param  toState  String value for toState.
         * @return Builder
         */
        public Builder toState(String toState) {
            this.toState = toState;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = OptionalNullable.of(catalogObjectId);
            return this;
        }

        /**
         * UnSetter for catalogObjectId.
         * @return Builder
         */
        public Builder unsetCatalogObjectId() {
            catalogObjectId = null;
            return this;
        }

        /**
         * Setter for catalogObjectType.
         * @param  catalogObjectType  String value for catalogObjectType.
         * @return Builder
         */
        public Builder catalogObjectType(String catalogObjectType) {
            this.catalogObjectType = OptionalNullable.of(catalogObjectType);
            return this;
        }

        /**
         * UnSetter for catalogObjectType.
         * @return Builder
         */
        public Builder unsetCatalogObjectType() {
            catalogObjectType = null;
            return this;
        }

        /**
         * Setter for quantity.
         * @param  quantity  String value for quantity.
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = OptionalNullable.of(quantity);
            return this;
        }

        /**
         * UnSetter for quantity.
         * @return Builder
         */
        public Builder unsetQuantity() {
            quantity = null;
            return this;
        }

        /**
         * Setter for totalPriceMoney.
         * @param  totalPriceMoney  Money value for totalPriceMoney.
         * @return Builder
         */
        public Builder totalPriceMoney(Money totalPriceMoney) {
            this.totalPriceMoney = totalPriceMoney;
            return this;
        }

        /**
         * Setter for occurredAt.
         * @param  occurredAt  String value for occurredAt.
         * @return Builder
         */
        public Builder occurredAt(String occurredAt) {
            this.occurredAt = OptionalNullable.of(occurredAt);
            return this;
        }

        /**
         * UnSetter for occurredAt.
         * @return Builder
         */
        public Builder unsetOccurredAt() {
            occurredAt = null;
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
         * Setter for source.
         * @param  source  SourceApplication value for source.
         * @return Builder
         */
        public Builder source(SourceApplication source) {
            this.source = source;
            return this;
        }

        /**
         * Setter for employeeId.
         * @param  employeeId  String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = OptionalNullable.of(employeeId);
            return this;
        }

        /**
         * UnSetter for employeeId.
         * @return Builder
         */
        public Builder unsetEmployeeId() {
            employeeId = null;
            return this;
        }

        /**
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = OptionalNullable.of(teamMemberId);
            return this;
        }

        /**
         * UnSetter for teamMemberId.
         * @return Builder
         */
        public Builder unsetTeamMemberId() {
            teamMemberId = null;
            return this;
        }

        /**
         * Setter for transactionId.
         * @param  transactionId  String value for transactionId.
         * @return Builder
         */
        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        /**
         * Setter for refundId.
         * @param  refundId  String value for refundId.
         * @return Builder
         */
        public Builder refundId(String refundId) {
            this.refundId = refundId;
            return this;
        }

        /**
         * Setter for purchaseOrderId.
         * @param  purchaseOrderId  String value for purchaseOrderId.
         * @return Builder
         */
        public Builder purchaseOrderId(String purchaseOrderId) {
            this.purchaseOrderId = purchaseOrderId;
            return this;
        }

        /**
         * Setter for goodsReceiptId.
         * @param  goodsReceiptId  String value for goodsReceiptId.
         * @return Builder
         */
        public Builder goodsReceiptId(String goodsReceiptId) {
            this.goodsReceiptId = goodsReceiptId;
            return this;
        }

        /**
         * Setter for adjustmentGroup.
         * @param  adjustmentGroup  InventoryAdjustmentGroup value for adjustmentGroup.
         * @return Builder
         */
        public Builder adjustmentGroup(InventoryAdjustmentGroup adjustmentGroup) {
            this.adjustmentGroup = adjustmentGroup;
            return this;
        }

        /**
         * Builds a new {@link InventoryAdjustment} object using the set fields.
         * @return {@link InventoryAdjustment}
         */
        public InventoryAdjustment build() {
            return new InventoryAdjustment(id, referenceId, fromState, toState, locationId,
                    catalogObjectId, catalogObjectType, quantity, totalPriceMoney, occurredAt,
                    createdAt, source, employeeId, teamMemberId, transactionId, refundId,
                    purchaseOrderId, goodsReceiptId, adjustmentGroup);
        }
    }
}
