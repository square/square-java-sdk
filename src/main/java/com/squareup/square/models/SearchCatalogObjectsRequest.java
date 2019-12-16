package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchCatalogObjectsRequest {

    @JsonCreator
    public SearchCatalogObjectsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("object_types") List<String> objectTypes,
            @JsonProperty("include_deleted_objects") Boolean includeDeletedObjects,
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("query") CatalogQuery query,
            @JsonProperty("limit") Integer limit) {
        this.cursor = cursor;
        this.objectTypes = objectTypes;
        this.includeDeletedObjects = includeDeletedObjects;
        this.includeRelatedObjects = includeRelatedObjects;
        this.beginTime = beginTime;
        this.query = query;
        this.limit = limit;
    }

    private final String cursor;
    private final List<String> objectTypes;
    private final Boolean includeDeletedObjects;
    private final Boolean includeRelatedObjects;
    private final String beginTime;
    private final CatalogQuery query;
    private final Integer limit;

    @Override
    public int hashCode() {
        return Objects.hash(cursor, objectTypes, includeDeletedObjects, includeRelatedObjects, beginTime, query, limit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchCatalogObjectsRequest)) {
            return false;
        }
        SearchCatalogObjectsRequest searchCatalogObjectsRequest = (SearchCatalogObjectsRequest) o;
        return Objects.equals(cursor, searchCatalogObjectsRequest.cursor) &&
            Objects.equals(objectTypes, searchCatalogObjectsRequest.objectTypes) &&
            Objects.equals(includeDeletedObjects, searchCatalogObjectsRequest.includeDeletedObjects) &&
            Objects.equals(includeRelatedObjects, searchCatalogObjectsRequest.includeRelatedObjects) &&
            Objects.equals(beginTime, searchCatalogObjectsRequest.beginTime) &&
            Objects.equals(query, searchCatalogObjectsRequest.query) &&
            Objects.equals(limit, searchCatalogObjectsRequest.limit);
    }

    /**
     * Getter for Cursor.
     * The pagination cursor returned in the previous response. Leave unset for an initial request.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

    /**
     * Getter for ObjectTypes.
     * The desired set of object types to appear in the search results.
     * The legal values are taken from the CatalogObjectType enum: `"ITEM"`, `"ITEM_VARIATION"`, `"CATEGORY"`,
     * `"DISCOUNT"`, `"TAX"`, `"MODIFIER"`, or `"MODIFIER_LIST"`.
     * See [CatalogObjectType](#type-catalogobjecttype) for possible values
     */
    @JsonGetter("object_types")
    public List<String> getObjectTypes() { 
        return this.objectTypes;
    }

    /**
     * Getter for IncludeDeletedObjects.
     * If `true`, deleted objects will be included in the results. Deleted objects will have their
     * `is_deleted` field set to `true`.
     */
    @JsonGetter("include_deleted_objects")
    public Boolean getIncludeDeletedObjects() { 
        return this.includeDeletedObjects;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the
     * requested object, as follows:
     * If a CatalogItem is returned in the object field of the response,
     * its associated CatalogCategory, CatalogTax objects,
     * CatalogImage objects and CatalogModifierList objects
     * will be included in the `related_objects` field of the response.
     * If a CatalogItemVariation is returned in the object field of the
     * response, its parent CatalogItem will be included in the `related_objects` field of
     * the response.
     */
    @JsonGetter("include_related_objects")
    public Boolean getIncludeRelatedObjects() { 
        return this.includeRelatedObjects;
    }

    /**
     * Getter for BeginTime.
     * Return objects modified after this [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates), in RFC 3339
     * format, e.g., `2016-09-04T23:59:33.123Z`. The timestamp is exclusive - objects with a
     * timestamp equal to `begin_time` will not be included in the response.
     */
    @JsonGetter("begin_time")
    public String getBeginTime() { 
        return this.beginTime;
    }

    /**
     * Getter for Query.
     * A query to be applied to a `SearchCatalogObjectsRequest`.
     * Only one query field may be present.
     * Where an attribute name is required, it should be specified as the name of any field
     * marked "searchable" from the structured data types for the desired result object type(s)
     * (`CatalogItem`, `CatalogItemVariation`, `CatalogCategory`, `CatalogTax`,
     * `CatalogDiscount`, `CatalogModifierList`, `CatalogModifier`).
     * For example, a query that should return Items may specify attribute names from
     * any of the searchable fields of the `CatalogItem` data type, namely
     * `"name"`, `"description"`, and `"abbreviation"`.
     */
    @JsonGetter("query")
    public CatalogQuery getQuery() { 
        return this.query;
    }

    /**
     * Getter for Limit.
     * A limit on the number of results to be returned in a single page. The limit is advisory -
     * the implementation may return more or fewer results. If the supplied limit is negative, zero, or
     * is higher than the maximum limit of 1,000, it will be ignored.
     */
    @JsonGetter("limit")
    public Integer getLimit() { 
        return this.limit;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .objectTypes(getObjectTypes())
            .includeDeletedObjects(getIncludeDeletedObjects())
            .includeRelatedObjects(getIncludeRelatedObjects())
            .beginTime(getBeginTime())
            .query(getQuery())
            .limit(getLimit());
            return builder;
    }

    public static class Builder {
        private String cursor;
        private List<String> objectTypes;
        private Boolean includeDeletedObjects;
        private Boolean includeRelatedObjects;
        private String beginTime;
        private CatalogQuery query;
        private Integer limit;

        public Builder() { }

        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder objectTypes(List<String> value) {
            objectTypes = value;
            return this;
        }
        public Builder includeDeletedObjects(Boolean value) {
            includeDeletedObjects = value;
            return this;
        }
        public Builder includeRelatedObjects(Boolean value) {
            includeRelatedObjects = value;
            return this;
        }
        public Builder beginTime(String value) {
            beginTime = value;
            return this;
        }
        public Builder query(CatalogQuery value) {
            query = value;
            return this;
        }
        public Builder limit(Integer value) {
            limit = value;
            return this;
        }

        public SearchCatalogObjectsRequest build() {
            return new SearchCatalogObjectsRequest(cursor,
                objectTypes,
                includeDeletedObjects,
                includeRelatedObjects,
                beginTime,
                query,
                limit);
        }
    }
}
