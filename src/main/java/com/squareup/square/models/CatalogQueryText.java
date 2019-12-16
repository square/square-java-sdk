package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryText {

    @JsonCreator
    public CatalogQueryText(
            @JsonProperty("keywords") List<String> keywords) {
        this.keywords = keywords;
    }

    private final List<String> keywords;

    @Override
    public int hashCode() {
        return Objects.hash(keywords);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryText)) {
            return false;
        }
        CatalogQueryText catalogQueryText = (CatalogQueryText) o;
        return Objects.equals(keywords, catalogQueryText.keywords);
    }

    /**
     * Getter for Keywords.
     * A list of 1, 2, or 3 search keywords. Keywords with fewer than 3 characters
     * are ignored.
     */
    @JsonGetter("keywords")
    public List<String> getKeywords() { 
        return this.keywords;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(keywords);
            return builder;
    }

    public static class Builder {
        private List<String> keywords;

        public Builder(List<String> keywords) {
            this.keywords = keywords;
        }

        public Builder keywords(List<String> value) {
            keywords = value;
            return this;
        }

        public CatalogQueryText build() {
            return new CatalogQueryText(keywords);
        }
    }
}
