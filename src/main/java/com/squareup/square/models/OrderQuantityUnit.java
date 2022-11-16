
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderQuantityUnit type.
 */
public class OrderQuantityUnit {
    private final MeasurementUnit measurementUnit;
    private final OptionalNullable<Integer> precision;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;

    /**
     * Initialization constructor.
     * @param  measurementUnit  MeasurementUnit value for measurementUnit.
     * @param  precision  Integer value for precision.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     */
    @JsonCreator
    public OrderQuantityUnit(
            @JsonProperty("measurement_unit") MeasurementUnit measurementUnit,
            @JsonProperty("precision") Integer precision,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_version") Long catalogVersion) {
        this.measurementUnit = measurementUnit;
        this.precision = OptionalNullable.of(precision);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderQuantityUnit(MeasurementUnit measurementUnit,
            OptionalNullable<Integer> precision, OptionalNullable<String> catalogObjectId,
            OptionalNullable<Long> catalogVersion) {
        this.measurementUnit = measurementUnit;
        this.precision = precision;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
    }

    /**
     * Getter for MeasurementUnit.
     * Represents a unit of measurement to use with a quantity, such as ounces or inches. Exactly
     * one of the following fields are required: `custom_unit`, `area_unit`, `length_unit`,
     * `volume_unit`, and `weight_unit`.
     * @return Returns the MeasurementUnit
     */
    @JsonGetter("measurement_unit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * Internal Getter for Precision.
     * For non-integer quantities, represents the number of digits after the decimal point that are
     * recorded for this quantity. For example, a precision of 1 allows quantities such as `"1.0"`
     * and `"1.1"`, but not `"1.01"`. Min: 0. Max: 5.
     * @return Returns the Internal Integer
     */
    @JsonGetter("precision")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetPrecision() {
        return this.precision;
    }

    /**
     * Getter for Precision.
     * For non-integer quantities, represents the number of digits after the decimal point that are
     * recorded for this quantity. For example, a precision of 1 allows quantities such as `"1.0"`
     * and `"1.1"`, but not `"1.01"`. Min: 0. Max: 5.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getPrecision() {
        return OptionalNullable.getFrom(precision);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The catalog object ID referencing the [CatalogMeasurementUnit]($m/CatalogMeasurementUnit).
     * This field is set when this is a catalog-backed measurement unit.
     * @return Returns the Internal String
     */
    @JsonGetter("catalog_object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object ID referencing the [CatalogMeasurementUnit]($m/CatalogMeasurementUnit).
     * This field is set when this is a catalog-backed measurement unit.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The version of the catalog object that this measurement unit references. This field is set
     * when this is a catalog-backed measurement unit.
     * @return Returns the Internal Long
     */
    @JsonGetter("catalog_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetCatalogVersion() {
        return this.catalogVersion;
    }

    /**
     * Getter for CatalogVersion.
     * The version of the catalog object that this measurement unit references. This field is set
     * when this is a catalog-backed measurement unit.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurementUnit, precision, catalogObjectId, catalogVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderQuantityUnit)) {
            return false;
        }
        OrderQuantityUnit other = (OrderQuantityUnit) obj;
        return Objects.equals(measurementUnit, other.measurementUnit)
            && Objects.equals(precision, other.precision)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(catalogVersion, other.catalogVersion);
    }

    /**
     * Converts this OrderQuantityUnit into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderQuantityUnit [" + "measurementUnit=" + measurementUnit + ", precision="
                + precision + ", catalogObjectId=" + catalogObjectId + ", catalogVersion="
                + catalogVersion + "]";
    }

    /**
     * Builds a new {@link OrderQuantityUnit.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderQuantityUnit.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .measurementUnit(getMeasurementUnit());
        builder.precision = internalGetPrecision();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderQuantityUnit}.
     */
    public static class Builder {
        private MeasurementUnit measurementUnit;
        private OptionalNullable<Integer> precision;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;



        /**
         * Setter for measurementUnit.
         * @param  measurementUnit  MeasurementUnit value for measurementUnit.
         * @return Builder
         */
        public Builder measurementUnit(MeasurementUnit measurementUnit) {
            this.measurementUnit = measurementUnit;
            return this;
        }

        /**
         * Setter for precision.
         * @param  precision  Integer value for precision.
         * @return Builder
         */
        public Builder precision(Integer precision) {
            this.precision = OptionalNullable.of(precision);
            return this;
        }

        /**
         * UnSetter for precision.
         * @return Builder
         */
        public Builder unsetPrecision() {
            precision = null;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = OptionalNullable.of(catalogObjectId);
            return this;
        }

        /**
         * UnSetter for catalogObjectId.
         * @return Builder
         */
        public Builder unsetCatalogObjectId() {
            catalogObjectId = null;
            return this;
        }

        /**
         * Setter for catalogVersion.
         * @param  catalogVersion  Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = OptionalNullable.of(catalogVersion);
            return this;
        }

        /**
         * UnSetter for catalogVersion.
         * @return Builder
         */
        public Builder unsetCatalogVersion() {
            catalogVersion = null;
            return this;
        }

        /**
         * Builds a new {@link OrderQuantityUnit} object using the set fields.
         * @return {@link OrderQuantityUnit}
         */
        public OrderQuantityUnit build() {
            return new OrderQuantityUnit(measurementUnit, precision, catalogObjectId,
                    catalogVersion);
        }
    }
}
