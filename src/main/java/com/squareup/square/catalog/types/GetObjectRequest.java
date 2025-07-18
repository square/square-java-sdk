/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.catalog.types;

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
@JsonDeserialize(builder = GetObjectRequest.Builder.class)
public final class GetObjectRequest {
    private final String objectId;

    private final Optional<Boolean> includeRelatedObjects;

    private final Optional<Long> catalogVersion;

    private final Optional<Boolean> includeCategoryPathToRoot;

    private final Map<String, Object> additionalProperties;

    private GetObjectRequest(
            String objectId,
            Optional<Boolean> includeRelatedObjects,
            Optional<Long> catalogVersion,
            Optional<Boolean> includeCategoryPathToRoot,
            Map<String, Object> additionalProperties) {
        this.objectId = objectId;
        this.includeRelatedObjects = includeRelatedObjects;
        this.catalogVersion = catalogVersion;
        this.includeCategoryPathToRoot = includeCategoryPathToRoot;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The object ID of any type of catalog objects to be retrieved.
     */
    @JsonProperty("object_id")
    public String getObjectId() {
        return objectId;
    }

    /**
     * @return If <code>true</code>, the response will include additional objects that are related to the
     * requested objects. Related objects are defined as any objects referenced by ID by the results in the <code>objects</code> field
     * of the response. These objects are put in the <code>related_objects</code> field. Setting this to <code>true</code> is
     * helpful when the objects are needed for immediate display to a user.
     * This process only goes one level deep. Objects referenced by the related objects will not be included. For example,
     * <p>if the <code>objects</code> field of the response contains a CatalogItem, its associated
     * CatalogCategory objects, CatalogTax objects, CatalogImage objects and
     * CatalogModifierLists will be returned in the <code>related_objects</code> field of the
     * response. If the <code>objects</code> field of the response contains a CatalogItemVariation,
     * its parent CatalogItem will be returned in the <code>related_objects</code> field of
     * the response.</p>
     * <p>Default value: <code>false</code></p>
     */
    @JsonIgnore
    public Optional<Boolean> getIncludeRelatedObjects() {
        if (includeRelatedObjects == null) {
            return Optional.empty();
        }
        return includeRelatedObjects;
    }

    /**
     * @return Requests objects as of a specific version of the catalog. This allows you to retrieve historical
     * versions of objects. The value to retrieve a specific version of an object can be found
     * in the version field of <a href="entity:CatalogObject">CatalogObject</a>s. If not included, results will
     * be from the current version of the catalog.
     */
    @JsonIgnore
    public Optional<Long> getCatalogVersion() {
        if (catalogVersion == null) {
            return Optional.empty();
        }
        return catalogVersion;
    }

    /**
     * @return Specifies whether or not to include the <code>path_to_root</code> list for each returned category instance. The <code>path_to_root</code> list consists
     * of <code>CategoryPathToRootNode</code> objects and specifies the path that starts with the immediate parent category of the returned category
     * and ends with its root category. If the returned category is a top-level category, the <code>path_to_root</code> list is empty and is not returned
     * in the response payload.
     */
    @JsonIgnore
    public Optional<Boolean> getIncludeCategoryPathToRoot() {
        if (includeCategoryPathToRoot == null) {
            return Optional.empty();
        }
        return includeCategoryPathToRoot;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("include_related_objects")
    private Optional<Boolean> _getIncludeRelatedObjects() {
        return includeRelatedObjects;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("catalog_version")
    private Optional<Long> _getCatalogVersion() {
        return catalogVersion;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("include_category_path_to_root")
    private Optional<Boolean> _getIncludeCategoryPathToRoot() {
        return includeCategoryPathToRoot;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetObjectRequest && equalTo((GetObjectRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetObjectRequest other) {
        return objectId.equals(other.objectId)
                && includeRelatedObjects.equals(other.includeRelatedObjects)
                && catalogVersion.equals(other.catalogVersion)
                && includeCategoryPathToRoot.equals(other.includeCategoryPathToRoot);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.objectId, this.includeRelatedObjects, this.catalogVersion, this.includeCategoryPathToRoot);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ObjectIdStage builder() {
        return new Builder();
    }

    public interface ObjectIdStage {
        /**
         * <p>The object ID of any type of catalog objects to be retrieved.</p>
         */
        _FinalStage objectId(@NotNull String objectId);

        Builder from(GetObjectRequest other);
    }

    public interface _FinalStage {
        GetObjectRequest build();

        /**
         * <p>If <code>true</code>, the response will include additional objects that are related to the
         * requested objects. Related objects are defined as any objects referenced by ID by the results in the <code>objects</code> field
         * of the response. These objects are put in the <code>related_objects</code> field. Setting this to <code>true</code> is
         * helpful when the objects are needed for immediate display to a user.
         * This process only goes one level deep. Objects referenced by the related objects will not be included. For example,</p>
         * <p>if the <code>objects</code> field of the response contains a CatalogItem, its associated
         * CatalogCategory objects, CatalogTax objects, CatalogImage objects and
         * CatalogModifierLists will be returned in the <code>related_objects</code> field of the
         * response. If the <code>objects</code> field of the response contains a CatalogItemVariation,
         * its parent CatalogItem will be returned in the <code>related_objects</code> field of
         * the response.</p>
         * <p>Default value: <code>false</code></p>
         */
        _FinalStage includeRelatedObjects(Optional<Boolean> includeRelatedObjects);

        _FinalStage includeRelatedObjects(Boolean includeRelatedObjects);

        _FinalStage includeRelatedObjects(Nullable<Boolean> includeRelatedObjects);

        /**
         * <p>Requests objects as of a specific version of the catalog. This allows you to retrieve historical
         * versions of objects. The value to retrieve a specific version of an object can be found
         * in the version field of <a href="entity:CatalogObject">CatalogObject</a>s. If not included, results will
         * be from the current version of the catalog.</p>
         */
        _FinalStage catalogVersion(Optional<Long> catalogVersion);

        _FinalStage catalogVersion(Long catalogVersion);

        _FinalStage catalogVersion(Nullable<Long> catalogVersion);

        /**
         * <p>Specifies whether or not to include the <code>path_to_root</code> list for each returned category instance. The <code>path_to_root</code> list consists
         * of <code>CategoryPathToRootNode</code> objects and specifies the path that starts with the immediate parent category of the returned category
         * and ends with its root category. If the returned category is a top-level category, the <code>path_to_root</code> list is empty and is not returned
         * in the response payload.</p>
         */
        _FinalStage includeCategoryPathToRoot(Optional<Boolean> includeCategoryPathToRoot);

        _FinalStage includeCategoryPathToRoot(Boolean includeCategoryPathToRoot);

        _FinalStage includeCategoryPathToRoot(Nullable<Boolean> includeCategoryPathToRoot);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ObjectIdStage, _FinalStage {
        private String objectId;

        private Optional<Boolean> includeCategoryPathToRoot = Optional.empty();

        private Optional<Long> catalogVersion = Optional.empty();

        private Optional<Boolean> includeRelatedObjects = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetObjectRequest other) {
            objectId(other.getObjectId());
            includeRelatedObjects(other.getIncludeRelatedObjects());
            catalogVersion(other.getCatalogVersion());
            includeCategoryPathToRoot(other.getIncludeCategoryPathToRoot());
            return this;
        }

        /**
         * <p>The object ID of any type of catalog objects to be retrieved.</p>
         * <p>The object ID of any type of catalog objects to be retrieved.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("object_id")
        public _FinalStage objectId(@NotNull String objectId) {
            this.objectId = Objects.requireNonNull(objectId, "objectId must not be null");
            return this;
        }

        /**
         * <p>Specifies whether or not to include the <code>path_to_root</code> list for each returned category instance. The <code>path_to_root</code> list consists
         * of <code>CategoryPathToRootNode</code> objects and specifies the path that starts with the immediate parent category of the returned category
         * and ends with its root category. If the returned category is a top-level category, the <code>path_to_root</code> list is empty and is not returned
         * in the response payload.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage includeCategoryPathToRoot(Nullable<Boolean> includeCategoryPathToRoot) {
            if (includeCategoryPathToRoot.isNull()) {
                this.includeCategoryPathToRoot = null;
            } else if (includeCategoryPathToRoot.isEmpty()) {
                this.includeCategoryPathToRoot = Optional.empty();
            } else {
                this.includeCategoryPathToRoot = Optional.of(includeCategoryPathToRoot.get());
            }
            return this;
        }

        /**
         * <p>Specifies whether or not to include the <code>path_to_root</code> list for each returned category instance. The <code>path_to_root</code> list consists
         * of <code>CategoryPathToRootNode</code> objects and specifies the path that starts with the immediate parent category of the returned category
         * and ends with its root category. If the returned category is a top-level category, the <code>path_to_root</code> list is empty and is not returned
         * in the response payload.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage includeCategoryPathToRoot(Boolean includeCategoryPathToRoot) {
            this.includeCategoryPathToRoot = Optional.ofNullable(includeCategoryPathToRoot);
            return this;
        }

        /**
         * <p>Specifies whether or not to include the <code>path_to_root</code> list for each returned category instance. The <code>path_to_root</code> list consists
         * of <code>CategoryPathToRootNode</code> objects and specifies the path that starts with the immediate parent category of the returned category
         * and ends with its root category. If the returned category is a top-level category, the <code>path_to_root</code> list is empty and is not returned
         * in the response payload.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "include_category_path_to_root", nulls = Nulls.SKIP)
        public _FinalStage includeCategoryPathToRoot(Optional<Boolean> includeCategoryPathToRoot) {
            this.includeCategoryPathToRoot = includeCategoryPathToRoot;
            return this;
        }

        /**
         * <p>Requests objects as of a specific version of the catalog. This allows you to retrieve historical
         * versions of objects. The value to retrieve a specific version of an object can be found
         * in the version field of <a href="entity:CatalogObject">CatalogObject</a>s. If not included, results will
         * be from the current version of the catalog.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage catalogVersion(Nullable<Long> catalogVersion) {
            if (catalogVersion.isNull()) {
                this.catalogVersion = null;
            } else if (catalogVersion.isEmpty()) {
                this.catalogVersion = Optional.empty();
            } else {
                this.catalogVersion = Optional.of(catalogVersion.get());
            }
            return this;
        }

        /**
         * <p>Requests objects as of a specific version of the catalog. This allows you to retrieve historical
         * versions of objects. The value to retrieve a specific version of an object can be found
         * in the version field of <a href="entity:CatalogObject">CatalogObject</a>s. If not included, results will
         * be from the current version of the catalog.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage catalogVersion(Long catalogVersion) {
            this.catalogVersion = Optional.ofNullable(catalogVersion);
            return this;
        }

        /**
         * <p>Requests objects as of a specific version of the catalog. This allows you to retrieve historical
         * versions of objects. The value to retrieve a specific version of an object can be found
         * in the version field of <a href="entity:CatalogObject">CatalogObject</a>s. If not included, results will
         * be from the current version of the catalog.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "catalog_version", nulls = Nulls.SKIP)
        public _FinalStage catalogVersion(Optional<Long> catalogVersion) {
            this.catalogVersion = catalogVersion;
            return this;
        }

        /**
         * <p>If <code>true</code>, the response will include additional objects that are related to the
         * requested objects. Related objects are defined as any objects referenced by ID by the results in the <code>objects</code> field
         * of the response. These objects are put in the <code>related_objects</code> field. Setting this to <code>true</code> is
         * helpful when the objects are needed for immediate display to a user.
         * This process only goes one level deep. Objects referenced by the related objects will not be included. For example,</p>
         * <p>if the <code>objects</code> field of the response contains a CatalogItem, its associated
         * CatalogCategory objects, CatalogTax objects, CatalogImage objects and
         * CatalogModifierLists will be returned in the <code>related_objects</code> field of the
         * response. If the <code>objects</code> field of the response contains a CatalogItemVariation,
         * its parent CatalogItem will be returned in the <code>related_objects</code> field of
         * the response.</p>
         * <p>Default value: <code>false</code></p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage includeRelatedObjects(Nullable<Boolean> includeRelatedObjects) {
            if (includeRelatedObjects.isNull()) {
                this.includeRelatedObjects = null;
            } else if (includeRelatedObjects.isEmpty()) {
                this.includeRelatedObjects = Optional.empty();
            } else {
                this.includeRelatedObjects = Optional.of(includeRelatedObjects.get());
            }
            return this;
        }

        /**
         * <p>If <code>true</code>, the response will include additional objects that are related to the
         * requested objects. Related objects are defined as any objects referenced by ID by the results in the <code>objects</code> field
         * of the response. These objects are put in the <code>related_objects</code> field. Setting this to <code>true</code> is
         * helpful when the objects are needed for immediate display to a user.
         * This process only goes one level deep. Objects referenced by the related objects will not be included. For example,</p>
         * <p>if the <code>objects</code> field of the response contains a CatalogItem, its associated
         * CatalogCategory objects, CatalogTax objects, CatalogImage objects and
         * CatalogModifierLists will be returned in the <code>related_objects</code> field of the
         * response. If the <code>objects</code> field of the response contains a CatalogItemVariation,
         * its parent CatalogItem will be returned in the <code>related_objects</code> field of
         * the response.</p>
         * <p>Default value: <code>false</code></p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage includeRelatedObjects(Boolean includeRelatedObjects) {
            this.includeRelatedObjects = Optional.ofNullable(includeRelatedObjects);
            return this;
        }

        /**
         * <p>If <code>true</code>, the response will include additional objects that are related to the
         * requested objects. Related objects are defined as any objects referenced by ID by the results in the <code>objects</code> field
         * of the response. These objects are put in the <code>related_objects</code> field. Setting this to <code>true</code> is
         * helpful when the objects are needed for immediate display to a user.
         * This process only goes one level deep. Objects referenced by the related objects will not be included. For example,</p>
         * <p>if the <code>objects</code> field of the response contains a CatalogItem, its associated
         * CatalogCategory objects, CatalogTax objects, CatalogImage objects and
         * CatalogModifierLists will be returned in the <code>related_objects</code> field of the
         * response. If the <code>objects</code> field of the response contains a CatalogItemVariation,
         * its parent CatalogItem will be returned in the <code>related_objects</code> field of
         * the response.</p>
         * <p>Default value: <code>false</code></p>
         */
        @java.lang.Override
        @JsonSetter(value = "include_related_objects", nulls = Nulls.SKIP)
        public _FinalStage includeRelatedObjects(Optional<Boolean> includeRelatedObjects) {
            this.includeRelatedObjects = includeRelatedObjects;
            return this;
        }

        @java.lang.Override
        public GetObjectRequest build() {
            return new GetObjectRequest(
                    objectId, includeRelatedObjects, catalogVersion, includeCategoryPathToRoot, additionalProperties);
        }
    }
}
