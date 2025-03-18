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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogObjectCategory.Builder.class)
public final class CatalogObjectCategory {
    private final Optional<String> id;

    private final Optional<Long> ordinal;

    private final Optional<CatalogCategory> categoryData;

    private final Optional<String> updatedAt;

    private final Optional<Long> version;

    private final Optional<Boolean> isDeleted;

    private final Optional<Map<String, CatalogCustomAttributeValue>> customAttributeValues;

    private final Optional<List<CatalogV1Id>> catalogV1Ids;

    private final Optional<Boolean> presentAtAllLocations;

    private final Optional<List<String>> presentAtLocationIds;

    private final Optional<List<String>> absentAtLocationIds;

    private final Optional<String> imageId;

    private final Map<String, Object> additionalProperties;

    private CatalogObjectCategory(
            Optional<String> id,
            Optional<Long> ordinal,
            Optional<CatalogCategory> categoryData,
            Optional<String> updatedAt,
            Optional<Long> version,
            Optional<Boolean> isDeleted,
            Optional<Map<String, CatalogCustomAttributeValue>> customAttributeValues,
            Optional<List<CatalogV1Id>> catalogV1Ids,
            Optional<Boolean> presentAtAllLocations,
            Optional<List<String>> presentAtLocationIds,
            Optional<List<String>> absentAtLocationIds,
            Optional<String> imageId,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.ordinal = ordinal;
        this.categoryData = categoryData;
        this.updatedAt = updatedAt;
        this.version = version;
        this.isDeleted = isDeleted;
        this.customAttributeValues = customAttributeValues;
        this.catalogV1Ids = catalogV1Ids;
        this.presentAtAllLocations = presentAtAllLocations;
        this.presentAtLocationIds = presentAtLocationIds;
        this.absentAtLocationIds = absentAtLocationIds;
        this.imageId = imageId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the object's category.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The order of the object within the context of the category.
     */
    @JsonIgnore
    public Optional<Long> getOrdinal() {
        if (ordinal == null) {
            return Optional.empty();
        }
        return ordinal;
    }

    /**
     * @return Structured data for a <code>CatalogCategory</code>, set for CatalogObjects of type <code>CATEGORY</code>.
     */
    @JsonProperty("category_data")
    public Optional<CatalogCategory> getCategoryData() {
        return categoryData;
    }

    /**
     * @return Last modification <a href="https://developer.squareup.com/docs/build-basics/working-with-dates">timestamp</a> in RFC 3339 format, e.g., <code>&quot;2016-08-15T23:59:33.123Z&quot;</code>
     * would indicate the UTC time (denoted by <code>Z</code>) of August 15, 2016 at 23:59:33 and 123 milliseconds.
     */
    @JsonProperty("updated_at")
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The version of the object. When updating an object, the version supplied
     * must match the version in the database, otherwise the write will be rejected as conflicting.
     */
    @JsonProperty("version")
    public Optional<Long> getVersion() {
        return version;
    }

    /**
     * @return If <code>true</code>, the object has been deleted from the database. Must be <code>false</code> for new objects
     * being inserted. When deleted, the <code>updated_at</code> field will equal the deletion time.
     */
    @JsonProperty("is_deleted")
    public Optional<Boolean> getIsDeleted() {
        return isDeleted;
    }

    /**
     * @return A map (key-value pairs) of application-defined custom attribute values. The value of a key-value pair
     * is a <a href="entity:CatalogCustomAttributeValue">CatalogCustomAttributeValue</a> object. The key is the <code>key</code> attribute
     * value defined in the associated <a href="entity:CatalogCustomAttributeDefinition">CatalogCustomAttributeDefinition</a>
     * object defined by the application making the request.
     * <p>If the <code>CatalogCustomAttributeDefinition</code> object is
     * defined by another application, the <code>CatalogCustomAttributeDefinition</code>'s key attribute value is prefixed by
     * the defining application ID. For example, if the <code>CatalogCustomAttributeDefinition</code> has a <code>key</code> attribute of
     * <code>&quot;cocoa_brand&quot;</code> and the defining application ID is <code>&quot;abcd1234&quot;</code>, the key in the map is <code>&quot;abcd1234:cocoa_brand&quot;</code>
     * if the application making the request is different from the application defining the custom attribute definition.
     * Otherwise, the key used in the map is simply <code>&quot;cocoa_brand&quot;</code>.</p>
     * <p>Application-defined custom attributes are set at a global (location-independent) level.
     * Custom attribute values are intended to store additional information about a catalog object
     * or associations with an entity in another system. Do not use custom attributes
     * to store any sensitive information (personally identifiable information, card details, etc.).</p>
     */
    @JsonProperty("custom_attribute_values")
    public Optional<Map<String, CatalogCustomAttributeValue>> getCustomAttributeValues() {
        return customAttributeValues;
    }

    /**
     * @return The Connect v1 IDs for this object at each location where it is present, where they
     * differ from the object's Connect V2 ID. The field will only be present for objects that
     * have been created or modified by legacy APIs.
     */
    @JsonProperty("catalog_v1_ids")
    public Optional<List<CatalogV1Id>> getCatalogV1Ids() {
        return catalogV1Ids;
    }

    /**
     * @return If <code>true</code>, this object is present at all locations (including future locations), except where specified in
     * the <code>absent_at_location_ids</code> field. If <code>false</code>, this object is not present at any locations (including future locations),
     * except where specified in the <code>present_at_location_ids</code> field. If not specified, defaults to <code>true</code>.
     */
    @JsonProperty("present_at_all_locations")
    public Optional<Boolean> getPresentAtAllLocations() {
        return presentAtAllLocations;
    }

    /**
     * @return A list of locations where the object is present, even if <code>present_at_all_locations</code> is <code>false</code>.
     * This can include locations that are deactivated.
     */
    @JsonProperty("present_at_location_ids")
    public Optional<List<String>> getPresentAtLocationIds() {
        return presentAtLocationIds;
    }

    /**
     * @return A list of locations where the object is not present, even if <code>present_at_all_locations</code> is <code>true</code>.
     * This can include locations that are deactivated.
     */
    @JsonProperty("absent_at_location_ids")
    public Optional<List<String>> getAbsentAtLocationIds() {
        return absentAtLocationIds;
    }

    /**
     * @return Identifies the <code>CatalogImage</code> attached to this <code>CatalogObject</code>.
     */
    @JsonProperty("image_id")
    public Optional<String> getImageId() {
        return imageId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("ordinal")
    private Optional<Long> _getOrdinal() {
        return ordinal;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogObjectCategory && equalTo((CatalogObjectCategory) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogObjectCategory other) {
        return id.equals(other.id)
                && ordinal.equals(other.ordinal)
                && categoryData.equals(other.categoryData)
                && updatedAt.equals(other.updatedAt)
                && version.equals(other.version)
                && isDeleted.equals(other.isDeleted)
                && customAttributeValues.equals(other.customAttributeValues)
                && catalogV1Ids.equals(other.catalogV1Ids)
                && presentAtAllLocations.equals(other.presentAtAllLocations)
                && presentAtLocationIds.equals(other.presentAtLocationIds)
                && absentAtLocationIds.equals(other.absentAtLocationIds)
                && imageId.equals(other.imageId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.ordinal,
                this.categoryData,
                this.updatedAt,
                this.version,
                this.isDeleted,
                this.customAttributeValues,
                this.catalogV1Ids,
                this.presentAtAllLocations,
                this.presentAtLocationIds,
                this.absentAtLocationIds,
                this.imageId);
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

        private Optional<Long> ordinal = Optional.empty();

        private Optional<CatalogCategory> categoryData = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        private Optional<Long> version = Optional.empty();

        private Optional<Boolean> isDeleted = Optional.empty();

        private Optional<Map<String, CatalogCustomAttributeValue>> customAttributeValues = Optional.empty();

        private Optional<List<CatalogV1Id>> catalogV1Ids = Optional.empty();

        private Optional<Boolean> presentAtAllLocations = Optional.empty();

        private Optional<List<String>> presentAtLocationIds = Optional.empty();

        private Optional<List<String>> absentAtLocationIds = Optional.empty();

        private Optional<String> imageId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogObjectCategory other) {
            id(other.getId());
            ordinal(other.getOrdinal());
            categoryData(other.getCategoryData());
            updatedAt(other.getUpdatedAt());
            version(other.getVersion());
            isDeleted(other.getIsDeleted());
            customAttributeValues(other.getCustomAttributeValues());
            catalogV1Ids(other.getCatalogV1Ids());
            presentAtAllLocations(other.getPresentAtAllLocations());
            presentAtLocationIds(other.getPresentAtLocationIds());
            absentAtLocationIds(other.getAbsentAtLocationIds());
            imageId(other.getImageId());
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

        @JsonSetter(value = "ordinal", nulls = Nulls.SKIP)
        public Builder ordinal(Optional<Long> ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        public Builder ordinal(Long ordinal) {
            this.ordinal = Optional.ofNullable(ordinal);
            return this;
        }

        public Builder ordinal(Nullable<Long> ordinal) {
            if (ordinal.isNull()) {
                this.ordinal = null;
            } else if (ordinal.isEmpty()) {
                this.ordinal = Optional.empty();
            } else {
                this.ordinal = Optional.of(ordinal.get());
            }
            return this;
        }

        @JsonSetter(value = "category_data", nulls = Nulls.SKIP)
        public Builder categoryData(Optional<CatalogCategory> categoryData) {
            this.categoryData = categoryData;
            return this;
        }

        public Builder categoryData(CatalogCategory categoryData) {
            this.categoryData = Optional.ofNullable(categoryData);
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

        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public Builder version(Optional<Long> version) {
            this.version = version;
            return this;
        }

        public Builder version(Long version) {
            this.version = Optional.ofNullable(version);
            return this;
        }

        @JsonSetter(value = "is_deleted", nulls = Nulls.SKIP)
        public Builder isDeleted(Optional<Boolean> isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        public Builder isDeleted(Boolean isDeleted) {
            this.isDeleted = Optional.ofNullable(isDeleted);
            return this;
        }

        @JsonSetter(value = "custom_attribute_values", nulls = Nulls.SKIP)
        public Builder customAttributeValues(Optional<Map<String, CatalogCustomAttributeValue>> customAttributeValues) {
            this.customAttributeValues = customAttributeValues;
            return this;
        }

        public Builder customAttributeValues(Map<String, CatalogCustomAttributeValue> customAttributeValues) {
            this.customAttributeValues = Optional.ofNullable(customAttributeValues);
            return this;
        }

        @JsonSetter(value = "catalog_v1_ids", nulls = Nulls.SKIP)
        public Builder catalogV1Ids(Optional<List<CatalogV1Id>> catalogV1Ids) {
            this.catalogV1Ids = catalogV1Ids;
            return this;
        }

        public Builder catalogV1Ids(List<CatalogV1Id> catalogV1Ids) {
            this.catalogV1Ids = Optional.ofNullable(catalogV1Ids);
            return this;
        }

        @JsonSetter(value = "present_at_all_locations", nulls = Nulls.SKIP)
        public Builder presentAtAllLocations(Optional<Boolean> presentAtAllLocations) {
            this.presentAtAllLocations = presentAtAllLocations;
            return this;
        }

        public Builder presentAtAllLocations(Boolean presentAtAllLocations) {
            this.presentAtAllLocations = Optional.ofNullable(presentAtAllLocations);
            return this;
        }

        @JsonSetter(value = "present_at_location_ids", nulls = Nulls.SKIP)
        public Builder presentAtLocationIds(Optional<List<String>> presentAtLocationIds) {
            this.presentAtLocationIds = presentAtLocationIds;
            return this;
        }

        public Builder presentAtLocationIds(List<String> presentAtLocationIds) {
            this.presentAtLocationIds = Optional.ofNullable(presentAtLocationIds);
            return this;
        }

        @JsonSetter(value = "absent_at_location_ids", nulls = Nulls.SKIP)
        public Builder absentAtLocationIds(Optional<List<String>> absentAtLocationIds) {
            this.absentAtLocationIds = absentAtLocationIds;
            return this;
        }

        public Builder absentAtLocationIds(List<String> absentAtLocationIds) {
            this.absentAtLocationIds = Optional.ofNullable(absentAtLocationIds);
            return this;
        }

        @JsonSetter(value = "image_id", nulls = Nulls.SKIP)
        public Builder imageId(Optional<String> imageId) {
            this.imageId = imageId;
            return this;
        }

        public Builder imageId(String imageId) {
            this.imageId = Optional.ofNullable(imageId);
            return this;
        }

        public CatalogObjectCategory build() {
            return new CatalogObjectCategory(
                    id,
                    ordinal,
                    categoryData,
                    updatedAt,
                    version,
                    isDeleted,
                    customAttributeValues,
                    catalogV1Ids,
                    presentAtAllLocations,
                    presentAtLocationIds,
                    absentAtLocationIds,
                    imageId,
                    additionalProperties);
        }
    }
}
