
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListDeviceCodesRequest type.
 */
public class ListDeviceCodesRequest {
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<String> locationId;
    private final String productType;
    private final OptionalNullable<List<String>> status;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  locationId  String value for locationId.
     * @param  productType  String value for productType.
     * @param  status  List of String value for status.
     */
    @JsonCreator
    public ListDeviceCodesRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("product_type") String productType,
            @JsonProperty("status") List<String> status) {
        this.cursor = OptionalNullable.of(cursor);
        this.locationId = OptionalNullable.of(locationId);
        this.productType = productType;
        this.status = OptionalNullable.of(status);
    }

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  locationId  String value for locationId.
     * @param  productType  String value for productType.
     * @param  status  List of String value for status.
     */

    protected ListDeviceCodesRequest(OptionalNullable<String> cursor,
            OptionalNullable<String> locationId, String productType,
            OptionalNullable<List<String>> status) {
        this.cursor = cursor;
        this.locationId = locationId;
        this.productType = productType;
        this.status = status;
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See [Paginating
     * results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See [Paginating
     * results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for LocationId.
     * If specified, only returns DeviceCodes of the specified location. Returns DeviceCodes of all
     * locations if empty.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * If specified, only returns DeviceCodes of the specified location. Returns DeviceCodes of all
     * locations if empty.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Getter for ProductType.
     * @return Returns the String
     */
    @JsonGetter("product_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getProductType() {
        return productType;
    }

    /**
     * Internal Getter for Status.
     * If specified, returns DeviceCodes with the specified statuses. Returns DeviceCodes of status
     * `PAIRED` and `UNPAIRED` if empty. See [DeviceCodeStatus](#type-devicecodestatus) for possible
     * values
     * @return Returns the Internal List of String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetStatus() {
        return this.status;
    }

    /**
     * Getter for Status.
     * If specified, returns DeviceCodes with the specified statuses. Returns DeviceCodes of status
     * `PAIRED` and `UNPAIRED` if empty. See [DeviceCodeStatus](#type-devicecodestatus) for possible
     * values
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getStatus() {
        return OptionalNullable.getFrom(status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, locationId, productType, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDeviceCodesRequest)) {
            return false;
        }
        ListDeviceCodesRequest other = (ListDeviceCodesRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(productType, other.productType)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this ListDeviceCodesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDeviceCodesRequest [" + "cursor=" + cursor + ", locationId=" + locationId
                + ", productType=" + productType + ", status=" + status + "]";
    }

    /**
     * Builds a new {@link ListDeviceCodesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDeviceCodesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .productType(getProductType());
        builder.cursor = internalGetCursor();
        builder.locationId = internalGetLocationId();
        builder.status = internalGetStatus();
        return builder;
    }

    /**
     * Class to build instances of {@link ListDeviceCodesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private OptionalNullable<String> locationId;
        private String productType;
        private OptionalNullable<List<String>> status;



        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for productType.
         * @param  productType  String value for productType.
         * @return Builder
         */
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  List of String value for status.
         * @return Builder
         */
        public Builder status(List<String> status) {
            this.status = OptionalNullable.of(status);
            return this;
        }

        /**
         * UnSetter for status.
         * @return Builder
         */
        public Builder unsetStatus() {
            status = null;
            return this;
        }

        /**
         * Builds a new {@link ListDeviceCodesRequest} object using the set fields.
         * @return {@link ListDeviceCodesRequest}
         */
        public ListDeviceCodesRequest build() {
            return new ListDeviceCodesRequest(cursor, locationId, productType, status);
        }
    }
}
