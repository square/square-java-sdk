
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for SearchCatalogObjectsResponse type.
 */
public class SearchCatalogObjectsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final String cursor;
    private final List<CatalogObject> objects;
    private final List<CatalogObject> relatedObjects;
    private final String latestTime;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param cursor String value for cursor.
     * @param objects List of CatalogObject value for objects.
     * @param relatedObjects List of CatalogObject value for relatedObjects.
     * @param latestTime String value for latestTime.
     */
    @JsonCreator
    public SearchCatalogObjectsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("objects") List<CatalogObject> objects,
            @JsonProperty("related_objects") List<CatalogObject> relatedObjects,
            @JsonProperty("latest_time") String latestTime) {
        this.errors = errors;
        this.cursor = cursor;
        this.objects = objects;
        this.relatedObjects = relatedObjects;
        this.latestTime = latestTime;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final
     * response. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Objects.
     * The CatalogObjects returned.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("objects")
    public List<CatalogObject> getObjects() {
        return this.objects;
    }

    /**
     * Getter for RelatedObjects.
     * A list of CatalogObjects referenced by the objects in the `objects` field.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("related_objects")
    public List<CatalogObject> getRelatedObjects() {
        return this.relatedObjects;
    }

    /**
     * Getter for LatestTime.
     * When the associated product catalog was last updated. Will match the value for `end_time` or
     * `cursor` if either field is included in the `SearchCatalog` request.
     * @return Returns the String
     */
    @JsonGetter("latest_time")
    public String getLatestTime() {
        return this.latestTime;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, cursor, objects, relatedObjects, latestTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCatalogObjectsResponse)) {
            return false;
        }
        SearchCatalogObjectsResponse other = (SearchCatalogObjectsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(objects, other.objects)
            && Objects.equals(relatedObjects, other.relatedObjects)
            && Objects.equals(latestTime, other.latestTime);
    }

    /**
     * Builds a new {@link SearchCatalogObjectsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchCatalogObjectsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .cursor(getCursor())
            .objects(getObjects())
            .relatedObjects(getRelatedObjects())
            .latestTime(getLatestTime());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchCatalogObjectsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String cursor;
        private List<CatalogObject> objects;
        private List<CatalogObject> relatedObjects;
        private String latestTime;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for objects.
         * @param objects List of CatalogObject value for objects.
         * @return Builder
         */
        public Builder objects(List<CatalogObject> objects) {
            this.objects = objects;
            return this;
        }

        /**
         * Setter for relatedObjects.
         * @param relatedObjects List of CatalogObject value for relatedObjects.
         * @return Builder
         */
        public Builder relatedObjects(List<CatalogObject> relatedObjects) {
            this.relatedObjects = relatedObjects;
            return this;
        }

        /**
         * Setter for latestTime.
         * @param latestTime String value for latestTime.
         * @return Builder
         */
        public Builder latestTime(String latestTime) {
            this.latestTime = latestTime;
            return this;
        }

        /**
         * Builds a new {@link SearchCatalogObjectsResponse} object using the set fields.
         * @return {@link SearchCatalogObjectsResponse}
         */
        public SearchCatalogObjectsResponse build() {
            SearchCatalogObjectsResponse model =
                    new SearchCatalogObjectsResponse(errors,
                            cursor,
                            objects,
                            relatedObjects,
                            latestTime);
            model.httpContext = httpContext;
            return model;
        }
    }
}
