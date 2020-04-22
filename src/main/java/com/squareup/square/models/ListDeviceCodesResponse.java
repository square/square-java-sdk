package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListDeviceCodesResponse type.
 */
public class ListDeviceCodesResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param deviceCodes
     * @param cursor
     */
    @JsonCreator
    public ListDeviceCodesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("device_codes") List<DeviceCode> deviceCodes,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.deviceCodes = deviceCodes;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<DeviceCode> deviceCodes;
    private final String cursor;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for DeviceCodes.
     * The queried DeviceCode.
     */
    @JsonGetter("device_codes")
    public List<DeviceCode> getDeviceCodes() {
        return this.deviceCodes;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor to retrieve the next set of results for your
     * original query to the endpoint. This value is present only if the request
     * succeeded and additional results are available.
     * See [Paginating results](#paginatingresults) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, deviceCodes, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListDeviceCodesResponse)) {
            return false;
        }
        ListDeviceCodesResponse listDeviceCodesResponse = (ListDeviceCodesResponse) obj;
        return Objects.equals(errors, listDeviceCodesResponse.errors) &&
            Objects.equals(deviceCodes, listDeviceCodesResponse.deviceCodes) &&
            Objects.equals(cursor, listDeviceCodesResponse.cursor);
    }

    /**
     * Builds a new {@link ListDeviceCodesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDeviceCodesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .deviceCodes(getDeviceCodes())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListDeviceCodesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<DeviceCode> deviceCodes;
        private String cursor;

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
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for deviceCodes
         * @param deviceCodes
         * @return Builder
         */
        public Builder deviceCodes(List<DeviceCode> deviceCodes) {
            this.deviceCodes = deviceCodes;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListDeviceCodesResponse} object using the set fields.
         * @return {@link ListDeviceCodesResponse}
         */
        public ListDeviceCodesResponse build() {
            ListDeviceCodesResponse model = new ListDeviceCodesResponse(errors,
                deviceCodes,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
