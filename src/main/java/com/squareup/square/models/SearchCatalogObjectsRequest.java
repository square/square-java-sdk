
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchCatalogObjectsRequest type.
 */
public class SearchCatalogObjectsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> objectTypes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean includeDeletedObjects;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean includeRelatedObjects;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String beginTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogQuery query;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  objectTypes  List of String value for objectTypes.
     * @param  includeDeletedObjects  Boolean value for includeDeletedObjects.
     * @param  includeRelatedObjects  Boolean value for includeRelatedObjects.
     * @param  beginTime  String value for beginTime.
     * @param  query  CatalogQuery value for query.
     * @param  limit  Integer value for limit.
     */
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

    /**
     * Getter for Cursor.
     * The pagination cursor returned in the previous response. Leave unset for an initial request.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for ObjectTypes.
     * The desired set of object types to appear in the search results.
     * @return Returns the List of String
     */
    @JsonGetter("object_types")
    public List<String> getObjectTypes() {
        return objectTypes;
    }

    /**
     * Getter for IncludeDeletedObjects.
     * If `true`, deleted objects will be included in the results. Deleted objects will have their
     * `is_deleted` field set to `true`.
     * @return Returns the Boolean
     */
    @JsonGetter("include_deleted_objects")
    public Boolean getIncludeDeletedObjects() {
        return includeDeletedObjects;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the requested
     * object, as follows: If a CatalogItem is returned in the object field of the response, its
     * associated CatalogCategory, CatalogTax objects, CatalogImage objects and CatalogModifierList
     * objects will be included in the `related_objects` field of the response. If a
     * CatalogItemVariation is returned in the object field of the response, its parent CatalogItem
     * will be included in the `related_objects` field of the response.
     * @return Returns the Boolean
     */
    @JsonGetter("include_related_objects")
    public Boolean getIncludeRelatedObjects() {
        return includeRelatedObjects;
    }

    /**
     * Getter for BeginTime.
     * Return objects modified after this
     * [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates), in RFC 3339
     * format, e.g., `2016-09-04T23:59:33.123Z`. The timestamp is exclusive - objects with a
     * timestamp equal to `begin_time` will not be included in the response.
     * @return Returns the String
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * Getter for Query.
     * A query composed of one or more different types of filters to narrow the scope of targeted
     * objects when calling the `SearchCatalogObjects` endpoint. Although a query can have multiple
     * filters, only certain query types can be combined per call to
     * [SearchCatalogObjects](#endpoint-Catalog-SearchCatalogObjects). Any combination of the
     * following types may be used together: - [exact_query](#type-CatalogExactQuery) -
     * [prefix_query](#type-CatalogPrefixQuery) - [range_query](#type-CatalogRangeQuery) -
     * [sorted_attribute_query](#type-CatalogSortedAttribute) - [text_query](#type-CatalogTextQuery)
     * All other query types cannot be combined with any others. When a query filter is based on an
     * attribute, the attribute must be searchable. Searchable attributes are listed as follows,
     * along their parent types that can be searched for with applicable query filters. * Searchable
     * attribute and objects queryable by searchable attributes ** - `name`: `CatalogItem`,
     * `CatalogItemVariation`, `CatalogCategory`, `CatalogTax`, `CatalogDiscount`,
     * `CatalogModifier`, 'CatalogModifierList`, `CatalogItemOption`, `CatalogItemOptionValue` -
     * `description`: `CatalogItem`, `CatalogItemOptionValue` - `abbreviation`: `CatalogItem` -
     * `upc`: `CatalogItemVariation` - `sku`: `CatalogItemVariation` - `caption`: `CatalogImage` -
     * `display_name`: `CatalogItemOption` For example, to search for
     * [CatalogItem](#type-CatalogItem) objects by searchable attributes, you can use the `"name"`,
     * `"description"`, or `"abbreviation"` attribute in an applicable query filter.
     * @return Returns the CatalogQuery
     */
    @JsonGetter("query")
    public CatalogQuery getQuery() {
        return query;
    }

    /**
     * Getter for Limit.
     * A limit on the number of results to be returned in a single page. The limit is advisory - the
     * implementation may return more or fewer results. If the supplied limit is negative, zero, or
     * is higher than the maximum limit of 1,000, it will be ignored.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, objectTypes, includeDeletedObjects, includeRelatedObjects,
                beginTime, query, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCatalogObjectsRequest)) {
            return false;
        }
        SearchCatalogObjectsRequest other = (SearchCatalogObjectsRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(objectTypes, other.objectTypes)
            && Objects.equals(includeDeletedObjects, other.includeDeletedObjects)
            && Objects.equals(includeRelatedObjects, other.includeRelatedObjects)
            && Objects.equals(beginTime, other.beginTime)
            && Objects.equals(query, other.query)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this SearchCatalogObjectsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchCatalogObjectsRequest [" + "cursor=" + cursor + ", objectTypes=" + objectTypes
                + ", includeDeletedObjects=" + includeDeletedObjects + ", includeRelatedObjects="
                + includeRelatedObjects + ", beginTime=" + beginTime + ", query=" + query
                + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link SearchCatalogObjectsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchCatalogObjectsRequest.Builder} object
     */
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

    /**
     * Class to build instances of {@link SearchCatalogObjectsRequest}.
     */
    public static class Builder {
        private String cursor;
        private List<String> objectTypes;
        private Boolean includeDeletedObjects;
        private Boolean includeRelatedObjects;
        private String beginTime;
        private CatalogQuery query;
        private Integer limit;



        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for objectTypes.
         * @param  objectTypes  List of String value for objectTypes.
         * @return Builder
         */
        public Builder objectTypes(List<String> objectTypes) {
            this.objectTypes = objectTypes;
            return this;
        }

        /**
         * Setter for includeDeletedObjects.
         * @param  includeDeletedObjects  Boolean value for includeDeletedObjects.
         * @return Builder
         */
        public Builder includeDeletedObjects(Boolean includeDeletedObjects) {
            this.includeDeletedObjects = includeDeletedObjects;
            return this;
        }

        /**
         * Setter for includeRelatedObjects.
         * @param  includeRelatedObjects  Boolean value for includeRelatedObjects.
         * @return Builder
         */
        public Builder includeRelatedObjects(Boolean includeRelatedObjects) {
            this.includeRelatedObjects = includeRelatedObjects;
            return this;
        }

        /**
         * Setter for beginTime.
         * @param  beginTime  String value for beginTime.
         * @return Builder
         */
        public Builder beginTime(String beginTime) {
            this.beginTime = beginTime;
            return this;
        }

        /**
         * Setter for query.
         * @param  query  CatalogQuery value for query.
         * @return Builder
         */
        public Builder query(CatalogQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds a new {@link SearchCatalogObjectsRequest} object using the set fields.
         * @return {@link SearchCatalogObjectsRequest}
         */
        public SearchCatalogObjectsRequest build() {
            return new SearchCatalogObjectsRequest(cursor, objectTypes, includeDeletedObjects,
                    includeRelatedObjects, beginTime, query, limit);
        }
    }
}
