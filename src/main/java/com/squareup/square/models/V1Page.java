package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1Page type.
 */
public class V1Page {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     * @param pageIndex
     * @param cells
     */
    @JsonCreator
    public V1Page(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("page_index") Integer pageIndex,
            @JsonProperty("cells") List<V1PageCell> cells) {
        this.id = id;
        this.name = name;
        this.pageIndex = pageIndex;
        this.cells = cells;
    }

    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final Integer pageIndex;
    private final List<V1PageCell> cells;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The page's unique identifier.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The page's name, if any.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for PageIndex.
     * The page's position in the merchant's list of pages. Always an integer between 0 and 6, inclusive.
     */
    @JsonGetter("page_index")
    public Integer getPageIndex() {
        return this.pageIndex;
    }

    /**
     * Getter for Cells.
     * The cells included on the page.
     */
    @JsonGetter("cells")
    public List<V1PageCell> getCells() {
        return this.cells;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, pageIndex, cells);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Page)) {
            return false;
        }
        V1Page v1Page = (V1Page) obj;
        return Objects.equals(id, v1Page.id) &&
            Objects.equals(name, v1Page.name) &&
            Objects.equals(pageIndex, v1Page.pageIndex) &&
            Objects.equals(cells, v1Page.cells);
    }

    /**
     * Builds a new {@link V1Page.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Page.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .pageIndex(getPageIndex())
            .cells(getCells());
            return builder;
    }

    /**
     * Class to build instances of {@link V1Page}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private Integer pageIndex;
        private List<V1PageCell> cells;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for pageIndex
         * @param pageIndex
         * @return Builder
         */
        public Builder pageIndex(Integer pageIndex) {
            this.pageIndex = pageIndex;
            return this;
        }
        /**
         * Setter for cells
         * @param cells
         * @return Builder
         */
        public Builder cells(List<V1PageCell> cells) {
            this.cells = cells;
            return this;
        }

        /**
         * Builds a new {@link V1Page} object using the set fields.
         * @return {@link V1Page}
         */
        public V1Page build() {
            V1Page model = new V1Page(id,
                name,
                pageIndex,
                cells);
            model.httpContext = httpContext;
            return model;
        }
    }
}
