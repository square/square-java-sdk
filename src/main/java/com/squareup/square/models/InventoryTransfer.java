
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
 * This is a model class for InventoryTransfer type.
 */
public class InventoryTransfer {
    private final String id;
    private final OptionalNullable<String> referenceId;
    private final String state;
    private final OptionalNullable<String> fromLocationId;
    private final OptionalNullable<String> toLocationId;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<String> catalogObjectType;
    private final OptionalNullable<String> quantity;
    private final OptionalNullable<String> occurredAt;
    private final String createdAt;
    private final SourceApplication source;
    private final OptionalNullable<String> employeeId;
    private final OptionalNullable<String> teamMemberId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  state  String value for state.
     * @param  fromLocationId  String value for fromLocationId.
     * @param  toLocationId  String value for toLocationId.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogObjectType  String value for catalogObjectType.
     * @param  quantity  String value for quantity.
     * @param  occurredAt  String value for occurredAt.
     * @param  createdAt  String value for createdAt.
     * @param  source  SourceApplication value for source.
     * @param  employeeId  String value for employeeId.
     * @param  teamMemberId  String value for teamMemberId.
     */
    @JsonCreator
    public InventoryTransfer(
            @JsonProperty("id") String id,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("state") String state,
            @JsonProperty("from_location_id") String fromLocationId,
            @JsonProperty("to_location_id") String toLocationId,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_object_type") String catalogObjectType,
            @JsonProperty("quantity") String quantity,
            @JsonProperty("occurred_at") String occurredAt,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("source") SourceApplication source,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("team_member_id") String teamMemberId) {
        this.id = id;
        this.referenceId = OptionalNullable.of(referenceId);
        this.state = state;
        this.fromLocationId = OptionalNullable.of(fromLocationId);
        this.toLocationId = OptionalNullable.of(toLocationId);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogObjectType = OptionalNullable.of(catalogObjectType);
        this.quantity = OptionalNullable.of(quantity);
        this.occurredAt = OptionalNullable.of(occurredAt);
        this.createdAt = createdAt;
        this.source = source;
        this.employeeId = OptionalNullable.of(employeeId);
        this.teamMemberId = OptionalNullable.of(teamMemberId);
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  state  String value for state.
     * @param  fromLocationId  String value for fromLocationId.
     * @param  toLocationId  String value for toLocationId.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogObjectType  String value for catalogObjectType.
     * @param  quantity  String value for quantity.
     * @param  occurredAt  String value for occurredAt.
     * @param  createdAt  String value for createdAt.
     * @param  source  SourceApplication value for source.
     * @param  employeeId  String value for employeeId.
     * @param  teamMemberId  String value for teamMemberId.
     */

    protected InventoryTransfer(String id, OptionalNullable<String> referenceId, String state,
            OptionalNullable<String> fromLocationId, OptionalNullable<String> toLocationId,
            OptionalNullable<String> catalogObjectId, OptionalNullable<String> catalogObjectType,
            OptionalNullable<String> quantity, OptionalNullable<String> occurredAt,
            String createdAt, SourceApplication source, OptionalNullable<String> employeeId,
            OptionalNullable<String> teamMemberId) {
        this.id = id;
        this.referenceId = referenceId;
        this.state = state;
        this.fromLocationId = fromLocationId;
        this.toLocationId = toLocationId;
        this.catalogObjectId = catalogObjectId;
        this.catalogObjectType = catalogObjectType;
        this.quantity = quantity;
        this.occurredAt = occurredAt;
        this.createdAt = createdAt;
        this.source = source;
        this.employeeId = employeeId;
        this.teamMemberId = teamMemberId;
    }

    /**
     * Getter for Id.
     * A unique ID generated by Square for the `InventoryTransfer`.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for ReferenceId.
     * An optional ID provided by the application to tie the `InventoryTransfer` to an external
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
     * An optional ID provided by the application to tie the `InventoryTransfer` to an external
     * system.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
    }

    /**
     * Getter for State.
     * Indicates the state of a tracked item quantity in the lifecycle of goods.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Internal Getter for FromLocationId.
     * The Square-generated ID of the [Location](entity:Location) where the related quantity of
     * items was tracked before the transfer.
     * @return Returns the Internal String
     */
    @JsonGetter("from_location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFromLocationId() {
        return this.fromLocationId;
    }

    /**
     * Getter for FromLocationId.
     * The Square-generated ID of the [Location](entity:Location) where the related quantity of
     * items was tracked before the transfer.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFromLocationId() {
        return OptionalNullable.getFrom(fromLocationId);
    }

    /**
     * Internal Getter for ToLocationId.
     * The Square-generated ID of the [Location](entity:Location) where the related quantity of
     * items was tracked after the transfer.
     * @return Returns the Internal String
     */
    @JsonGetter("to_location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetToLocationId() {
        return this.toLocationId;
    }

    /**
     * Getter for ToLocationId.
     * The Square-generated ID of the [Location](entity:Location) where the related quantity of
     * items was tracked after the transfer.
     * @return Returns the String
     */
    @JsonIgnore
    public String getToLocationId() {
        return OptionalNullable.getFrom(toLocationId);
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
     * The number of items affected by the transfer as a decimal string. Can support up to 5 digits
     * after the decimal point.
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
     * The number of items affected by the transfer as a decimal string. Can support up to 5 digits
     * after the decimal point.
     * @return Returns the String
     */
    @JsonIgnore
    public String getQuantity() {
        return OptionalNullable.getFrom(quantity);
    }

    /**
     * Internal Getter for OccurredAt.
     * A client-generated RFC 3339-formatted timestamp that indicates when the transfer took place.
     * For write actions, the `occurred_at` timestamp cannot be older than 24 hours or in the future
     * relative to the time of the request.
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
     * A client-generated RFC 3339-formatted timestamp that indicates when the transfer took place.
     * For write actions, the `occurred_at` timestamp cannot be older than 24 hours or in the future
     * relative to the time of the request.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOccurredAt() {
        return OptionalNullable.getFrom(occurredAt);
    }

    /**
     * Getter for CreatedAt.
     * An RFC 3339-formatted timestamp that indicates when Square received the transfer request.
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
     * transfer.
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
     * transfer.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmployeeId() {
        return OptionalNullable.getFrom(employeeId);
    }

    /**
     * Internal Getter for TeamMemberId.
     * The Square-generated ID of the [Team Member](entity:TeamMember) responsible for the inventory
     * transfer.
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
     * transfer.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceId, state, fromLocationId, toLocationId, catalogObjectId,
                catalogObjectType, quantity, occurredAt, createdAt, source, employeeId,
                teamMemberId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InventoryTransfer)) {
            return false;
        }
        InventoryTransfer other = (InventoryTransfer) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(state, other.state)
            && Objects.equals(fromLocationId, other.fromLocationId)
            && Objects.equals(toLocationId, other.toLocationId)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(catalogObjectType, other.catalogObjectType)
            && Objects.equals(quantity, other.quantity)
            && Objects.equals(occurredAt, other.occurredAt)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(source, other.source)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(teamMemberId, other.teamMemberId);
    }

    /**
     * Converts this InventoryTransfer into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InventoryTransfer [" + "id=" + id + ", referenceId=" + referenceId + ", state="
                + state + ", fromLocationId=" + fromLocationId + ", toLocationId=" + toLocationId
                + ", catalogObjectId=" + catalogObjectId + ", catalogObjectType="
                + catalogObjectType + ", quantity=" + quantity + ", occurredAt=" + occurredAt
                + ", createdAt=" + createdAt + ", source=" + source + ", employeeId=" + employeeId
                + ", teamMemberId=" + teamMemberId + "]";
    }

    /**
     * Builds a new {@link InventoryTransfer.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InventoryTransfer.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .state(getState())
                .createdAt(getCreatedAt())
                .source(getSource());
        builder.referenceId = internalGetReferenceId();
        builder.fromLocationId = internalGetFromLocationId();
        builder.toLocationId = internalGetToLocationId();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogObjectType = internalGetCatalogObjectType();
        builder.quantity = internalGetQuantity();
        builder.occurredAt = internalGetOccurredAt();
        builder.employeeId = internalGetEmployeeId();
        builder.teamMemberId = internalGetTeamMemberId();
        return builder;
    }

    /**
     * Class to build instances of {@link InventoryTransfer}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> referenceId;
        private String state;
        private OptionalNullable<String> fromLocationId;
        private OptionalNullable<String> toLocationId;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<String> catalogObjectType;
        private OptionalNullable<String> quantity;
        private OptionalNullable<String> occurredAt;
        private String createdAt;
        private SourceApplication source;
        private OptionalNullable<String> employeeId;
        private OptionalNullable<String> teamMemberId;



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
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for fromLocationId.
         * @param  fromLocationId  String value for fromLocationId.
         * @return Builder
         */
        public Builder fromLocationId(String fromLocationId) {
            this.fromLocationId = OptionalNullable.of(fromLocationId);
            return this;
        }

        /**
         * UnSetter for fromLocationId.
         * @return Builder
         */
        public Builder unsetFromLocationId() {
            fromLocationId = null;
            return this;
        }

        /**
         * Setter for toLocationId.
         * @param  toLocationId  String value for toLocationId.
         * @return Builder
         */
        public Builder toLocationId(String toLocationId) {
            this.toLocationId = OptionalNullable.of(toLocationId);
            return this;
        }

        /**
         * UnSetter for toLocationId.
         * @return Builder
         */
        public Builder unsetToLocationId() {
            toLocationId = null;
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
         * Builds a new {@link InventoryTransfer} object using the set fields.
         * @return {@link InventoryTransfer}
         */
        public InventoryTransfer build() {
            return new InventoryTransfer(id, referenceId, state, fromLocationId, toLocationId,
                    catalogObjectId, catalogObjectType, quantity, occurredAt, createdAt, source,
                    employeeId, teamMemberId);
        }
    }
}
