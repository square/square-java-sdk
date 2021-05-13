
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for InventoryPhysicalCount type.
 */
public class InventoryPhysicalCount {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String referenceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String catalogObjectId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String catalogObjectType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String state;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String quantity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final SourceApplication source;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String employeeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String occurredAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
            @JsonProperty("occurred_at") String occurredAt,
            @JsonProperty("created_at") String createdAt) {
        this.id = id;
        this.referenceId = referenceId;
        this.catalogObjectId = catalogObjectId;
        this.catalogObjectType = catalogObjectType;
        this.state = state;
        this.locationId = locationId;
        this.quantity = quantity;
        this.source = source;
        this.employeeId = employeeId;
        this.occurredAt = occurredAt;
        this.createdAt = createdAt;
    }

    /**
     * Getter for Id.
     * A unique Square-generated ID for the [InventoryPhysicalCount]($m/InventoryPhysicalCount).
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for ReferenceId.
     * An optional ID provided by the application to tie the
     * [InventoryPhysicalCount]($m/InventoryPhysicalCount) to an external system.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for CatalogObjectId.
     * The Square-generated ID of the [CatalogObject]($m/CatalogObject) being tracked.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return catalogObjectId;
    }

    /**
     * Getter for CatalogObjectType.
     * The [type]($m/CatalogObjectType) of the [CatalogObject]($m/CatalogObject) being tracked.
     * Tracking is only supported for the `ITEM_VARIATION` type.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_type")
    public String getCatalogObjectType() {
        return catalogObjectType;
    }

    /**
     * Getter for State.
     * Indicates the state of a tracked item quantity in the lifecycle of goods.
     * @return Returns the String
     */
    @JsonGetter("state")
    public String getState() {
        return state;
    }

    /**
     * Getter for LocationId.
     * The Square-generated ID of the [Location]($m/Location) where the related quantity of items is
     * being tracked.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for Quantity.
     * The number of items affected by the physical count as a decimal string. The number can
     * support up to 5 digits after the decimal point.
     * @return Returns the String
     */
    @JsonGetter("quantity")
    public String getQuantity() {
        return quantity;
    }

    /**
     * Getter for Source.
     * Provides information about the application used to generate a change.
     * @return Returns the SourceApplication
     */
    @JsonGetter("source")
    public SourceApplication getSource() {
        return source;
    }

    /**
     * Getter for EmployeeId.
     * The Square-generated ID of the [Employee]($m/Employee) responsible for the physical count.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Getter for OccurredAt.
     * A client-generated RFC 3339-formatted timestamp that indicates when the physical count was
     * examined. For physical count updates, the `occurred_at` timestamp cannot be older than 24
     * hours or in the future relative to the time of the request.
     * @return Returns the String
     */
    @JsonGetter("occurred_at")
    public String getOccurredAt() {
        return occurredAt;
    }

    /**
     * Getter for CreatedAt.
     * An RFC 3339-formatted timestamp that indicates when the physical count is received.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceId, catalogObjectId, catalogObjectType, state, locationId,
                quantity, source, employeeId, occurredAt, createdAt);
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
                + ", occurredAt=" + occurredAt + ", createdAt=" + createdAt + "]";
    }

    /**
     * Builds a new {@link InventoryPhysicalCount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InventoryPhysicalCount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .referenceId(getReferenceId())
                .catalogObjectId(getCatalogObjectId())
                .catalogObjectType(getCatalogObjectType())
                .state(getState())
                .locationId(getLocationId())
                .quantity(getQuantity())
                .source(getSource())
                .employeeId(getEmployeeId())
                .occurredAt(getOccurredAt())
                .createdAt(getCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link InventoryPhysicalCount}.
     */
    public static class Builder {
        private String id;
        private String referenceId;
        private String catalogObjectId;
        private String catalogObjectType;
        private String state;
        private String locationId;
        private String quantity;
        private SourceApplication source;
        private String employeeId;
        private String occurredAt;
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
            this.referenceId = referenceId;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Setter for catalogObjectType.
         * @param  catalogObjectType  String value for catalogObjectType.
         * @return Builder
         */
        public Builder catalogObjectType(String catalogObjectType) {
            this.catalogObjectType = catalogObjectType;
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
            this.locationId = locationId;
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
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for occurredAt.
         * @param  occurredAt  String value for occurredAt.
         * @return Builder
         */
        public Builder occurredAt(String occurredAt) {
            this.occurredAt = occurredAt;
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
            return new InventoryPhysicalCount(id, referenceId, catalogObjectId, catalogObjectType,
                    state, locationId, quantity, source, employeeId, occurredAt, createdAt);
        }
    }
}
