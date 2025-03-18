/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogObjectBase.Builder.class)
public final class CatalogObjectBase implements ICatalogObjectBase {
    private final String id;

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

    private CatalogObjectBase(
            String id,
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
     * @return An identifier to reference this object in the catalog. When a new <code>CatalogObject</code>
     * is inserted, the client should set the id to a temporary identifier starting with
     * a &quot;<code>#</code>&quot; character. Other objects being inserted or updated within the same request
     * may use this identifier to refer to the new object.
     * <p>When the server receives the new object, it will supply a unique identifier that
     * replaces the temporary identifier for all future references.</p>
     */
    @JsonProperty("id")
    @java.lang.Override
    public String getId() {
        return id;
    }

    /**
     * @return Last modification <a href="https://developer.squareup.com/docs/build-basics/working-with-dates">timestamp</a> in RFC 3339 format, e.g., <code>&quot;2016-08-15T23:59:33.123Z&quot;</code>
     * would indicate the UTC time (denoted by <code>Z</code>) of August 15, 2016 at 23:59:33 and 123 milliseconds.
     */
    @JsonProperty("updated_at")
    @java.lang.Override
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The version of the object. When updating an object, the version supplied
     * must match the version in the database, otherwise the write will be rejected as conflicting.
     */
    @JsonProperty("version")
    @java.lang.Override
    public Optional<Long> getVersion() {
        return version;
    }

    /**
     * @return If <code>true</code>, the object has been deleted from the database. Must be <code>false</code> for new objects
     * being inserted. When deleted, the <code>updated_at</code> field will equal the deletion time.
     */
    @JsonProperty("is_deleted")
    @java.lang.Override
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
    @java.lang.Override
    public Optional<Map<String, CatalogCustomAttributeValue>> getCustomAttributeValues() {
        return customAttributeValues;
    }

    /**
     * @return The Connect v1 IDs for this object at each location where it is present, where they
     * differ from the object's Connect V2 ID. The field will only be present for objects that
     * have been created or modified by legacy APIs.
     */
    @JsonProperty("catalog_v1_ids")
    @java.lang.Override
    public Optional<List<CatalogV1Id>> getCatalogV1Ids() {
        return catalogV1Ids;
    }

    /**
     * @return If <code>true</code>, this object is present at all locations (including future locations), except where specified in
     * the <code>absent_at_location_ids</code> field. If <code>false</code>, this object is not present at any locations (including future locations),
     * except where specified in the <code>present_at_location_ids</code> field. If not specified, defaults to <code>true</code>.
     */
    @JsonProperty("present_at_all_locations")
    @java.lang.Override
    public Optional<Boolean> getPresentAtAllLocations() {
        return presentAtAllLocations;
    }

    /**
     * @return A list of locations where the object is present, even if <code>present_at_all_locations</code> is <code>false</code>.
     * This can include locations that are deactivated.
     */
    @JsonProperty("present_at_location_ids")
    @java.lang.Override
    public Optional<List<String>> getPresentAtLocationIds() {
        return presentAtLocationIds;
    }

    /**
     * @return A list of locations where the object is not present, even if <code>present_at_all_locations</code> is <code>true</code>.
     * This can include locations that are deactivated.
     */
    @JsonProperty("absent_at_location_ids")
    @java.lang.Override
    public Optional<List<String>> getAbsentAtLocationIds() {
        return absentAtLocationIds;
    }

    /**
     * @return Identifies the <code>CatalogImage</code> attached to this <code>CatalogObject</code>.
     */
    @JsonProperty("image_id")
    @java.lang.Override
    public Optional<String> getImageId() {
        return imageId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogObjectBase && equalTo((CatalogObjectBase) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogObjectBase other) {
        return id.equals(other.id)
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

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        _FinalStage id(@NotNull String id);

        Builder from(CatalogObjectBase other);
    }

    public interface _FinalStage {
        CatalogObjectBase build();

        _FinalStage updatedAt(Optional<String> updatedAt);

        _FinalStage updatedAt(String updatedAt);

        _FinalStage version(Optional<Long> version);

        _FinalStage version(Long version);

        _FinalStage isDeleted(Optional<Boolean> isDeleted);

        _FinalStage isDeleted(Boolean isDeleted);

        _FinalStage customAttributeValues(Optional<Map<String, CatalogCustomAttributeValue>> customAttributeValues);

        _FinalStage customAttributeValues(Map<String, CatalogCustomAttributeValue> customAttributeValues);

        _FinalStage catalogV1Ids(Optional<List<CatalogV1Id>> catalogV1Ids);

        _FinalStage catalogV1Ids(List<CatalogV1Id> catalogV1Ids);

        _FinalStage presentAtAllLocations(Optional<Boolean> presentAtAllLocations);

        _FinalStage presentAtAllLocations(Boolean presentAtAllLocations);

        _FinalStage presentAtLocationIds(Optional<List<String>> presentAtLocationIds);

        _FinalStage presentAtLocationIds(List<String> presentAtLocationIds);

        _FinalStage absentAtLocationIds(Optional<List<String>> absentAtLocationIds);

        _FinalStage absentAtLocationIds(List<String> absentAtLocationIds);

        _FinalStage imageId(Optional<String> imageId);

        _FinalStage imageId(String imageId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private String id;

        private Optional<String> imageId = Optional.empty();

        private Optional<List<String>> absentAtLocationIds = Optional.empty();

        private Optional<List<String>> presentAtLocationIds = Optional.empty();

        private Optional<Boolean> presentAtAllLocations = Optional.empty();

        private Optional<List<CatalogV1Id>> catalogV1Ids = Optional.empty();

        private Optional<Map<String, CatalogCustomAttributeValue>> customAttributeValues = Optional.empty();

        private Optional<Boolean> isDeleted = Optional.empty();

        private Optional<Long> version = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CatalogObjectBase other) {
            id(other.getId());
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

        /**
         * <p>An identifier to reference this object in the catalog. When a new <code>CatalogObject</code>
         * is inserted, the client should set the id to a temporary identifier starting with
         * a &quot;<code>#</code>&quot; character. Other objects being inserted or updated within the same request
         * may use this identifier to refer to the new object.</p>
         * <p>When the server receives the new object, it will supply a unique identifier that
         * replaces the temporary identifier for all future references.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public _FinalStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>Identifies the <code>CatalogImage</code> attached to this <code>CatalogObject</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage imageId(String imageId) {
            this.imageId = Optional.ofNullable(imageId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "image_id", nulls = Nulls.SKIP)
        public _FinalStage imageId(Optional<String> imageId) {
            this.imageId = imageId;
            return this;
        }

        /**
         * <p>A list of locations where the object is not present, even if <code>present_at_all_locations</code> is <code>true</code>.
         * This can include locations that are deactivated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage absentAtLocationIds(List<String> absentAtLocationIds) {
            this.absentAtLocationIds = Optional.ofNullable(absentAtLocationIds);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "absent_at_location_ids", nulls = Nulls.SKIP)
        public _FinalStage absentAtLocationIds(Optional<List<String>> absentAtLocationIds) {
            this.absentAtLocationIds = absentAtLocationIds;
            return this;
        }

        /**
         * <p>A list of locations where the object is present, even if <code>present_at_all_locations</code> is <code>false</code>.
         * This can include locations that are deactivated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage presentAtLocationIds(List<String> presentAtLocationIds) {
            this.presentAtLocationIds = Optional.ofNullable(presentAtLocationIds);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "present_at_location_ids", nulls = Nulls.SKIP)
        public _FinalStage presentAtLocationIds(Optional<List<String>> presentAtLocationIds) {
            this.presentAtLocationIds = presentAtLocationIds;
            return this;
        }

        /**
         * <p>If <code>true</code>, this object is present at all locations (including future locations), except where specified in
         * the <code>absent_at_location_ids</code> field. If <code>false</code>, this object is not present at any locations (including future locations),
         * except where specified in the <code>present_at_location_ids</code> field. If not specified, defaults to <code>true</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage presentAtAllLocations(Boolean presentAtAllLocations) {
            this.presentAtAllLocations = Optional.ofNullable(presentAtAllLocations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "present_at_all_locations", nulls = Nulls.SKIP)
        public _FinalStage presentAtAllLocations(Optional<Boolean> presentAtAllLocations) {
            this.presentAtAllLocations = presentAtAllLocations;
            return this;
        }

        /**
         * <p>The Connect v1 IDs for this object at each location where it is present, where they
         * differ from the object's Connect V2 ID. The field will only be present for objects that
         * have been created or modified by legacy APIs.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage catalogV1Ids(List<CatalogV1Id> catalogV1Ids) {
            this.catalogV1Ids = Optional.ofNullable(catalogV1Ids);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "catalog_v1_ids", nulls = Nulls.SKIP)
        public _FinalStage catalogV1Ids(Optional<List<CatalogV1Id>> catalogV1Ids) {
            this.catalogV1Ids = catalogV1Ids;
            return this;
        }

        /**
         * <p>A map (key-value pairs) of application-defined custom attribute values. The value of a key-value pair
         * is a <a href="entity:CatalogCustomAttributeValue">CatalogCustomAttributeValue</a> object. The key is the <code>key</code> attribute
         * value defined in the associated <a href="entity:CatalogCustomAttributeDefinition">CatalogCustomAttributeDefinition</a>
         * object defined by the application making the request.</p>
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
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage customAttributeValues(Map<String, CatalogCustomAttributeValue> customAttributeValues) {
            this.customAttributeValues = Optional.ofNullable(customAttributeValues);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "custom_attribute_values", nulls = Nulls.SKIP)
        public _FinalStage customAttributeValues(
                Optional<Map<String, CatalogCustomAttributeValue>> customAttributeValues) {
            this.customAttributeValues = customAttributeValues;
            return this;
        }

        /**
         * <p>If <code>true</code>, the object has been deleted from the database. Must be <code>false</code> for new objects
         * being inserted. When deleted, the <code>updated_at</code> field will equal the deletion time.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage isDeleted(Boolean isDeleted) {
            this.isDeleted = Optional.ofNullable(isDeleted);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "is_deleted", nulls = Nulls.SKIP)
        public _FinalStage isDeleted(Optional<Boolean> isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        /**
         * <p>The version of the object. When updating an object, the version supplied
         * must match the version in the database, otherwise the write will be rejected as conflicting.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage version(Long version) {
            this.version = Optional.ofNullable(version);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public _FinalStage version(Optional<Long> version) {
            this.version = version;
            return this;
        }

        /**
         * <p>Last modification <a href="https://developer.squareup.com/docs/build-basics/working-with-dates">timestamp</a> in RFC 3339 format, e.g., <code>&quot;2016-08-15T23:59:33.123Z&quot;</code>
         * would indicate the UTC time (denoted by <code>Z</code>) of August 15, 2016 at 23:59:33 and 123 milliseconds.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage updatedAt(String updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public _FinalStage updatedAt(Optional<String> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @java.lang.Override
        public CatalogObjectBase build() {
            return new CatalogObjectBase(
                    id,
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
