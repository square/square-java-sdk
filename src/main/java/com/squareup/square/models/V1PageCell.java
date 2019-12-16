package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1PageCell {

    @JsonCreator
    public V1PageCell(
            @JsonProperty("page_id") String pageId,
            @JsonProperty("row") Integer row,
            @JsonProperty("column") Integer column,
            @JsonProperty("object_type") String objectType,
            @JsonProperty("object_id") String objectId,
            @JsonProperty("placeholder_type") String placeholderType) {
        this.pageId = pageId;
        this.row = row;
        this.column = column;
        this.objectType = objectType;
        this.objectId = objectId;
        this.placeholderType = placeholderType;
    }

    private final String pageId;
    private final Integer row;
    private final Integer column;
    private final String objectType;
    private final String objectId;
    private final String placeholderType;

    @Override
    public int hashCode() {
        return Objects.hash(pageId, row, column, objectType, objectId, placeholderType);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1PageCell)) {
            return false;
        }
        V1PageCell v1PageCell = (V1PageCell) o;
        return Objects.equals(pageId, v1PageCell.pageId) &&
            Objects.equals(row, v1PageCell.row) &&
            Objects.equals(column, v1PageCell.column) &&
            Objects.equals(objectType, v1PageCell.objectType) &&
            Objects.equals(objectId, v1PageCell.objectId) &&
            Objects.equals(placeholderType, v1PageCell.placeholderType);
    }

    /**
     * Getter for PageId.
     * The unique identifier of the page the cell is included on.
     */
    @JsonGetter("page_id")
    public String getPageId() { 
        return this.pageId;
    }

    /**
     * Getter for Row.
     * The row of the cell. Always an integer between 0 and 4, inclusive.
     */
    @JsonGetter("row")
    public Integer getRow() { 
        return this.row;
    }

    /**
     * Getter for Column.
     * The column of the cell. Always an integer between 0 and 4, inclusive.
     */
    @JsonGetter("column")
    public Integer getColumn() { 
        return this.column;
    }

    /**
     * Getter for ObjectType.
     */
    @JsonGetter("object_type")
    public String getObjectType() { 
        return this.objectType;
    }

    /**
     * Getter for ObjectId.
     * The unique identifier of the entity represented in the cell. Not present for cells with an object_type of PLACEHOLDER.
     */
    @JsonGetter("object_id")
    public String getObjectId() { 
        return this.objectId;
    }

    /**
     * Getter for PlaceholderType.
     */
    @JsonGetter("placeholder_type")
    public String getPlaceholderType() { 
        return this.placeholderType;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .pageId(getPageId())
            .row(getRow())
            .column(getColumn())
            .objectType(getObjectType())
            .objectId(getObjectId())
            .placeholderType(getPlaceholderType());
            return builder;
    }

    public static class Builder {
        private String pageId;
        private Integer row;
        private Integer column;
        private String objectType;
        private String objectId;
        private String placeholderType;

        public Builder() { }

        public Builder pageId(String value) {
            pageId = value;
            return this;
        }
        public Builder row(Integer value) {
            row = value;
            return this;
        }
        public Builder column(Integer value) {
            column = value;
            return this;
        }
        public Builder objectType(String value) {
            objectType = value;
            return this;
        }
        public Builder objectId(String value) {
            objectId = value;
            return this;
        }
        public Builder placeholderType(String value) {
            placeholderType = value;
            return this;
        }

        public V1PageCell build() {
            return new V1PageCell(pageId,
                row,
                column,
                objectType,
                objectId,
                placeholderType);
        }
    }
}
