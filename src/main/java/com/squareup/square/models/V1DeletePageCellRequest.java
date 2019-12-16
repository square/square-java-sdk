package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1DeletePageCellRequest {

    @JsonCreator
    public V1DeletePageCellRequest(
            @JsonProperty("row") String row,
            @JsonProperty("column") String column) {
        this.row = row;
        this.column = column;
    }

    private final String row;
    private final String column;

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1DeletePageCellRequest)) {
            return false;
        }
        V1DeletePageCellRequest v1DeletePageCellRequest = (V1DeletePageCellRequest) o;
        return Objects.equals(row, v1DeletePageCellRequest.row) &&
            Objects.equals(column, v1DeletePageCellRequest.column);
    }

    /**
     * Getter for Row.
     * The row of the cell to clear. Always an integer between 0 and 4, inclusive. Row 0 is the top row.
     */
    @JsonGetter("row")
    public String getRow() { 
        return this.row;
    }

    /**
     * Getter for Column.
     * The column of the cell to clear. Always an integer between 0 and 4, inclusive. Column 0 is the leftmost column.
     */
    @JsonGetter("column")
    public String getColumn() { 
        return this.column;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .row(getRow())
            .column(getColumn());
            return builder;
    }

    public static class Builder {
        private String row;
        private String column;

        public Builder() { }

        public Builder row(String value) {
            row = value;
            return this;
        }
        public Builder column(String value) {
            column = value;
            return this;
        }

        public V1DeletePageCellRequest build() {
            return new V1DeletePageCellRequest(row,
                column);
        }
    }
}
