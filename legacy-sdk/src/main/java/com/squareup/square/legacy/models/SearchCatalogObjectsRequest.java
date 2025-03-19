package com.squareup.square.legacy.models;

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
    private final String cursor;
    private final List<String> objectTypes;
    private final Boolean includeDeletedObjects;
    private final Boolean includeRelatedObjects;
    private final String beginTime;
    private final CatalogQuery query;
    private final Integer limit;
    private final Boolean includeCategoryPathToRoot;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  objectTypes  List of String value for objectTypes.
     * @param  includeDeletedObjects  Boolean value for includeDeletedObjects.
     * @param  includeRelatedObjects  Boolean value for includeRelatedObjects.
     * @param  beginTime  String value for beginTime.
     * @param  query  CatalogQuery value for query.
     * @param  limit  Integer value for limit.
     * @param  includeCategoryPathToRoot  Boolean value for includeCategoryPathToRoot.
     */
    @JsonCreator
    public SearchCatalogObjectsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("object_types") List<String> objectTypes,
            @JsonProperty("include_deleted_objects") Boolean includeDeletedObjects,
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("query") CatalogQuery query,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("include_category_path_to_root") Boolean includeCategoryPathToRoot) {
        this.cursor = cursor;
        this.objectTypes = objectTypes;
        this.includeDeletedObjects = includeDeletedObjects;
        this.includeRelatedObjects = includeRelatedObjects;
        this.beginTime = beginTime;
        this.query = query;
        this.limit = limit;
        this.includeCategoryPathToRoot = includeCategoryPathToRoot;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor returned in the previous response. Leave unset for an initial request.
     * See
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     * for more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for ObjectTypes.
     * The desired set of object types to appear in the search results. If this is unspecified, the
     * operation returns objects of all the top level types at the version of the Square API used to
     * make the request. Object types that are nested onto other object types are not included in
     * the defaults. At the current API version the default object types are: ITEM, CATEGORY, TAX,
     * DISCOUNT, MODIFIER_LIST, PRICING_RULE, PRODUCT_SET, TIME_PERIOD, MEASUREMENT_UNIT,
     * SUBSCRIPTION_PLAN, ITEM_OPTION, CUSTOM_ATTRIBUTE_DEFINITION, QUICK_AMOUNT_SETTINGS. Note that
     * if you wish for the query to return objects belonging to nested types (i.e., COMPONENT,
     * IMAGE, ITEM_OPTION_VAL, ITEM_VARIATION, or MODIFIER), you must explicitly include all the
     * types of interest in this field.
     * @return Returns the List of String
     */
    @JsonGetter("object_types")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIncludeDeletedObjects() {
        return includeDeletedObjects;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the requested
     * objects. Related objects are objects that are referenced by object ID by the objects in the
     * response. This is helpful if the objects are being fetched for immediate display to a user.
     * This process only goes one level deep. Objects referenced by the related objects will not be
     * included. For example: If the `objects` field of the response contains a CatalogItem, its
     * associated CatalogCategory objects, CatalogTax objects, CatalogImage objects and
     * CatalogModifierLists will be returned in the `related_objects` field of the response. If the
     * `objects` field of the response contains a CatalogItemVariation, its parent CatalogItem will
     * be returned in the `related_objects` field of the response. Default value: `false`
     * @return Returns the Boolean
     */
    @JsonGetter("include_related_objects")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * Getter for Query.
     * A query composed of one or more different types of filters to narrow the scope of targeted
     * objects when calling the `SearchCatalogObjects` endpoint. Although a query can have multiple
     * filters, only certain query types can be combined per call to
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects). Any combination of the following
     * types may be used together: - [exact_query]($m/CatalogQueryExact) -
     * [prefix_query]($m/CatalogQueryPrefix) - [range_query]($m/CatalogQueryRange) -
     * [sorted_attribute_query]($m/CatalogQuerySortedAttribute) - [text_query]($m/CatalogQueryText)
     * All other query types cannot be combined with any others. When a query filter is based on an
     * attribute, the attribute must be searchable. Searchable attributes are listed as follows,
     * along their parent types that can be searched for with applicable query filters. Searchable
     * attribute and objects queryable by searchable attributes: - `name`: `CatalogItem`,
     * `CatalogItemVariation`, `CatalogCategory`, `CatalogTax`, `CatalogDiscount`,
     * `CatalogModifier`, `CatalogModifierList`, `CatalogItemOption`, `CatalogItemOptionValue` -
     * `description`: `CatalogItem`, `CatalogItemOptionValue` - `abbreviation`: `CatalogItem` -
     * `upc`: `CatalogItemVariation` - `sku`: `CatalogItemVariation` - `caption`: `CatalogImage` -
     * `display_name`: `CatalogItemOption` For example, to search for [CatalogItem]($m/CatalogItem)
     * objects by searchable attributes, you can use the `"name"`, `"description"`, or
     * `"abbreviation"` attribute in an applicable query filter.
     * @return Returns the CatalogQuery
     */
    @JsonGetter("query")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for IncludeCategoryPathToRoot.
     * Specifies whether or not to include the `path_to_root` list for each returned category
     * instance. The `path_to_root` list consists of `CategoryPathToRootNode` objects and specifies
     * the path that starts with the immediate parent category of the returned category and ends
     * with its root category. If the returned category is a top-level category, the `path_to_root`
     * list is empty and is not returned in the response payload.
     * @return Returns the Boolean
     */
    @JsonGetter("include_category_path_to_root")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIncludeCategoryPathToRoot() {
        return includeCategoryPathToRoot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                cursor,
                objectTypes,
                includeDeletedObjects,
                includeRelatedObjects,
                beginTime,
                query,
                limit,
                includeCategoryPathToRoot);
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
                && Objects.equals(limit, other.limit)
                && Objects.equals(includeCategoryPathToRoot, other.includeCategoryPathToRoot);
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
                + ", limit=" + limit + ", includeCategoryPathToRoot=" + includeCategoryPathToRoot
                + "]";
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
                .limit(getLimit())
                .includeCategoryPathToRoot(getIncludeCategoryPathToRoot());
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
        private Boolean includeCategoryPathToRoot;

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
         * Setter for includeCategoryPathToRoot.
         * @param  includeCategoryPathToRoot  Boolean value for includeCategoryPathToRoot.
         * @return Builder
         */
        public Builder includeCategoryPathToRoot(Boolean includeCategoryPathToRoot) {
            this.includeCategoryPathToRoot = includeCategoryPathToRoot;
            return this;
        }

        /**
         * Builds a new {@link SearchCatalogObjectsRequest} object using the set fields.
         * @return {@link SearchCatalogObjectsRequest}
         */
        public SearchCatalogObjectsRequest build() {
            return new SearchCatalogObjectsRequest(
                    cursor,
                    objectTypes,
                    includeDeletedObjects,
                    includeRelatedObjects,
                    beginTime,
                    query,
                    limit,
                    includeCategoryPathToRoot);
        }
    }
}
