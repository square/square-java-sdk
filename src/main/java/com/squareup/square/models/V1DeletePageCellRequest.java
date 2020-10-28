
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1DeletePageCellRequest type.
 */
public class V1DeletePageCellRequest {
    private final String row;
    private final String column;

    /**
     * Initialization constructor.
     * @param row String value for row.
     * @param column String value for column.
     */
    @JsonCreator
    public V1DeletePageCellRequest(
            @JsonProperty("row") String row,
            @JsonProperty("column") String column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter for Row.
     * The row of the cell to clear. Always an integer between 0 and 4, inclusive. Row 0 is the top
     * row.
     * @return Returns the String
     */
    @JsonGetter("row")
    public String getRow() {
        return this.row;
    }

    /**
     * Getter for Column.
     * The column of the cell to clear. Always an integer between 0 and 4, inclusive. Column 0 is
     * the leftmost column.
     * @return Returns the String
     */
    @JsonGetter("column")
    public String getColumn() {
        return this.column;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1DeletePageCellRequest)) {
            return false;
        }
        V1DeletePageCellRequest other = (V1DeletePageCellRequest) obj;
        return Objects.equals(row, other.row)
            && Objects.equals(column, other.column);
    }

    /**
     * Builds a new {@link V1DeletePageCellRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1DeletePageCellRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .row(getRow())
            .column(getColumn());
        return builder;
    }

    /**
     * Class to build instances of {@link V1DeletePageCellRequest}.
     */
    public static class Builder {
        private String row;
        private String column;



        /**
         * Setter for row.
         * @param row String value for row.
         * @return Builder
         */
        public Builder row(String row) {
            this.row = row;
            return this;
        }

        /**
         * Setter for column.
         * @param column String value for column.
         * @return Builder
         */
        public Builder column(String column) {
            this.column = column;
            return this;
        }

        /**
         * Builds a new {@link V1DeletePageCellRequest} object using the set fields.
         * @return {@link V1DeletePageCellRequest}
         */
        public V1DeletePageCellRequest build() {
            return new V1DeletePageCellRequest(row,
                column);
        }
    }
}
