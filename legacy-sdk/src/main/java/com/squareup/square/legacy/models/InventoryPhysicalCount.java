package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for InventoryPhysicalCount type.
 */
public class InventoryPhysicalCount {
    private final String id;
    private final OptionalNullable<String> referenceId;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<String> catalogObjectType;
    private final String state;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> quantity;
    private final SourceApplication source;
    private final OptionalNullable<String> employeeId;
    private final OptionalNullable<String> teamMemberId;
    private final OptionalNullable<String> occurredAt;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogObjectType  String value for catalogObjectType.
     * @param  state  String value for state.
     * @param  locationId  String value for locationId.
     * @param  quantity  String value for quantity.
     * @param  source  SourceApplication value for source.
     * @param  employeeId  String value for employeeId.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  occurredAt  String value for occurredAt.
     * @param  createdAt  String value for createdAt.
     */
    @JsonCreator
    public InventoryPhysicalCount(
            @JsonProperty("id") String id,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_object_type") String catalogObjectType,
            @JsonProperty("state") String state,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("quantity") String quantity,
            @JsonProperty("source") SourceApplication source,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("occurred_at") String occurredAt,
            @JsonProperty("created_at") String createdAt) {
        this.id = id;
        this.referenceId = OptionalNullable.of(referenceId);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogObjectType = OptionalNullable.of(catalogObjectType);
        this.state = state;
        this.locationId = OptionalNullable.of(locationId);
        this.quantity = OptionalNullable.of(quantity);
        this.source = source;
        this.employeeId = OptionalNullable.of(employeeId);
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.occurredAt = OptionalNullable.of(occurredAt);
        this.createdAt = createdAt;
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogObjectType  String value for catalogObjectType.
     * @param  state  String value for state.
     * @param  locationId  String value for locationId.
     * @param  quantity  String value for quantity.
     * @param  source  SourceApplication value for source.
     * @param  employeeId  String value for employeeId.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  occurredAt  String value for occurredAt.
     * @param  createdAt  String value for createdAt.
     */
    protected InventoryPhysicalCount(
            String id,
            OptionalNullable<String> referenceId,
            OptionalNullable<String> catalogObjectId,
            OptionalNullable<String> catalogObjectType,
            String state,
            OptionalNullable<String> locationId,
            OptionalNullable<String> quantity,
            SourceApplication source,
            OptionalNullable<String> employeeId,
            OptionalNullable<String> teamMemberId,
            OptionalNullable<String> occurredAt,
            String createdAt) {
        this.id = id;
        this.referenceId = referenceId;
        this.catalogObjectId = catalogObjectId;
        this.catalogObjectType = catalogObjectType;
        this.state = state;
        this.locationId = locationId;
        this.quantity = quantity;
        this.source = source;
        this.employeeId = employeeId;
        this.teamMemberId = teamMemberId;
        this.occurredAt = occurredAt;
        this.createdAt = createdAt;
    }

    /**
     * Getter for Id.
     * A unique Square-generated ID for the [InventoryPhysicalCount](entity:InventoryPhysicalCount).
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for ReferenceId.
     * An optional ID provided by the application to tie the
     * [InventoryPhysicalCount](entity:InventoryPhysicalCount) to an external system.
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
     * An optional ID provided by the application to tie the
     * [InventoryPhysicalCount](entity:InventoryPhysicalCount) to an external system.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
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
     * Internal Getter for Quantity.
     * The number of items affected by the physical count as a decimal string. The number can
     * support up to 5 digits after the decimal point.
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
     * The number of items affected by the physical count as a decimal string. The number can
     * support up to 5 digits after the decimal point.
     * @return Returns the String
     */
    @JsonIgnore
    public String getQuantity() {
        return OptionalNullable.getFrom(quantity);
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
     * The Square-generated ID of the [Employee](entity:Employee) responsible for the physical
     * count.
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
     * The Square-generated ID of the [Employee](entity:Employee) responsible for the physical
     * count.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmployeeId() {
        return OptionalNullable.getFrom(employeeId);
    }

    /**
     * Internal Getter for TeamMemberId.
     * The Square-generated ID of the [Team Member](entity:TeamMember) responsible for the physical
     * count.
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
     * The Square-generated ID of the [Team Member](entity:TeamMember) responsible for the physical
     * count.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Internal Getter for OccurredAt.
     * A client-generated RFC 3339-formatted timestamp that indicates when the physical count was
     * examined. For physical count updates, the `occurred_at` timestamp cannot be older than 24
     * hours or in the future relative to the time of the request.
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
     * A client-generated RFC 3339-formatted timestamp that indicates when the physical count was
     * examined. For physical count updates, the `occurred_at` timestamp cannot be older than 24
     * hours or in the future relative to the time of the request.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOccurredAt() {
        return OptionalNullable.getFrom(occurredAt);
    }

    /**
     * Getter for CreatedAt.
     * An RFC 3339-formatted timestamp that indicates when the physical count is received.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                referenceId,
                catalogObjectId,
                catalogObjectType,
                state,
                locationId,
                quantity,
                source,
                employeeId,
                teamMemberId,
                occurredAt,
                createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InventoryPhysicalCount)) {
            return false;
        }
        InventoryPhysicalCount other = (InventoryPhysicalCount) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(referenceId, other.referenceId)
                && Objects.equals(catalogObjectId, other.catalogObjectId)
                && Objects.equals(catalogObjectType, other.catalogObjectType)
                && Objects.equals(state, other.state)
                && Objects.equals(locationId, other.locationId)
                && Objects.equals(quantity, other.quantity)
                && Objects.equals(source, other.source)
                && Objects.equals(employeeId, other.employeeId)
                && Objects.equals(teamMemberId, other.teamMemberId)
                && Objects.equals(occurredAt, other.occurredAt)
                && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Converts this InventoryPhysicalCount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InventoryPhysicalCount [" + "id=" + id + ", referenceId=" + referenceId
                + ", catalogObjectId=" + catalogObjectId + ", catalogObjectType="
                + catalogObjectType + ", state=" + state + ", locationId=" + locationId
                + ", quantity=" + quantity + ", source=" + source + ", employeeId=" + employeeId
                + ", teamMemberId=" + teamMemberId + ", occurredAt=" + occurredAt + ", createdAt="
                + createdAt + "]";
    }

    /**
     * Builds a new {@link InventoryPhysicalCount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InventoryPhysicalCount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder =
                new Builder().id(getId()).state(getState()).source(getSource()).createdAt(getCreatedAt());
        builder.referenceId = internalGetReferenceId();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogObjectType = internalGetCatalogObjectType();
        builder.locationId = internalGetLocationId();
        builder.quantity = internalGetQuantity();
        builder.employeeId = internalGetEmployeeId();
        builder.teamMemberId = internalGetTeamMemberId();
        builder.occurredAt = internalGetOccurredAt();
        return builder;
    }

    /**
     * Class to build instances of {@link InventoryPhysicalCount}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> referenceId;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<String> catalogObjectType;
        private String state;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> quantity;
        private SourceApplication source;
        private OptionalNullable<String> employeeId;
        private OptionalNullable<String> teamMemberId;
        private OptionalNullable<String> occurredAt;
        private String createdAt;

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
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
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
         * Builds a new {@link InventoryPhysicalCount} object using the set fields.
         * @return {@link InventoryPhysicalCount}
         */
        public InventoryPhysicalCount build() {
            return new InventoryPhysicalCount(
                    id,
                    referenceId,
                    catalogObjectId,
                    catalogObjectType,
                    state,
                    locationId,
                    quantity,
                    source,
                    employeeId,
                    teamMemberId,
                    occurredAt,
                    createdAt);
        }
    }
}
