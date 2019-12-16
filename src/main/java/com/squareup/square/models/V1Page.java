package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Page {

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

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pageIndex, cells);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Page)) {
            return false;
        }
        V1Page v1Page = (V1Page) o;
        return Objects.equals(id, v1Page.id) &&
            Objects.equals(name, v1Page.name) &&
            Objects.equals(pageIndex, v1Page.pageIndex) &&
            Objects.equals(cells, v1Page.cells);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .pageIndex(getPageIndex())
            .cells(getCells());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private Integer pageIndex;
        private List<V1PageCell> cells;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder pageIndex(Integer value) {
            pageIndex = value;
            return this;
        }
        public Builder cells(List<V1PageCell> value) {
            cells = value;
            return this;
        }

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
