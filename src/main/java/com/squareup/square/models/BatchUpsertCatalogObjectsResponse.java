
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchUpsertCatalogObjectsResponse type.
 */
public class BatchUpsertCatalogObjectsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<CatalogObject> objects;
    private final String updatedAt;
    private final List<CatalogIdMapping> idMappings;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  objects  List of CatalogObject value for objects.
     * @param  updatedAt  String value for updatedAt.
     * @param  idMappings  List of CatalogIdMapping value for idMappings.
     */
    @JsonCreator
    public BatchUpsertCatalogObjectsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("objects") List<CatalogObject> objects,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("id_mappings") List<CatalogIdMapping> idMappings) {
        this.errors = errors;
        this.objects = objects;
        this.updatedAt = updatedAt;
        this.idMappings = idMappings;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Objects.
     * The created successfully created CatalogObjects.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("objects")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CatalogObject> getObjects() {
        return objects;
    }

    /**
     * Getter for UpdatedAt.
     * The database [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * of this update in RFC 3339 format, e.g., "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for IdMappings.
     * The mapping between client and server IDs for this upsert.
     * @return Returns the List of CatalogIdMapping
     */
    @JsonGetter("id_mappings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CatalogIdMapping> getIdMappings() {
        return idMappings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, objects, updatedAt, idMappings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchUpsertCatalogObjectsResponse)) {
            return false;
        }
        BatchUpsertCatalogObjectsResponse other = (BatchUpsertCatalogObjectsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(objects, other.objects)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(idMappings, other.idMappings);
    }

    /**
     * Converts this BatchUpsertCatalogObjectsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchUpsertCatalogObjectsResponse [" + "errors=" + errors + ", objects=" + objects
                + ", updatedAt=" + updatedAt + ", idMappings=" + idMappings + "]";
    }

    /**
     * Builds a new {@link BatchUpsertCatalogObjectsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchUpsertCatalogObjectsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .objects(getObjects())
                .updatedAt(getUpdatedAt())
                .idMappings(getIdMappings());
        return builder;
    }

    /**
     * Class to build instances of {@link BatchUpsertCatalogObjectsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CatalogObject> objects;
        private String updatedAt;
        private List<CatalogIdMapping> idMappings;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for objects.
         * @param  objects  List of CatalogObject value for objects.
         * @return Builder
         */
        public Builder objects(List<CatalogObject> objects) {
            this.objects = objects;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for idMappings.
         * @param  idMappings  List of CatalogIdMapping value for idMappings.
         * @return Builder
         */
        public Builder idMappings(List<CatalogIdMapping> idMappings) {
            this.idMappings = idMappings;
            return this;
        }

        /**
         * Builds a new {@link BatchUpsertCatalogObjectsResponse} object using the set fields.
         * @return {@link BatchUpsertCatalogObjectsResponse}
         */
        public BatchUpsertCatalogObjectsResponse build() {
            BatchUpsertCatalogObjectsResponse model =
                    new BatchUpsertCatalogObjectsResponse(errors, objects, updatedAt, idMappings);
            model.httpContext = httpContext;
            return model;
        }
    }
}
