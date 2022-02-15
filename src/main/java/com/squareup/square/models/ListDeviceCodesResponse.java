
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
 * This is a model class for ListDeviceCodesResponse type.
 */
public class ListDeviceCodesResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<DeviceCode> deviceCodes;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  deviceCodes  List of DeviceCode value for deviceCodes.
     * @param  cursor  String value for cursor.
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
     * Getter for DeviceCodes.
     * The queried DeviceCode.
     * @return Returns the List of DeviceCode
     */
    @JsonGetter("device_codes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<DeviceCode> getDeviceCodes() {
        return deviceCodes;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor to retrieve the next set of results for your original query to the
     * endpoint. This value is present only if the request succeeded and additional results are
     * available. See [Paginating
     * results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, deviceCodes, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDeviceCodesResponse)) {
            return false;
        }
        ListDeviceCodesResponse other = (ListDeviceCodesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(deviceCodes, other.deviceCodes)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListDeviceCodesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDeviceCodesResponse [" + "errors=" + errors + ", deviceCodes=" + deviceCodes
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link ListDeviceCodesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<DeviceCode> deviceCodes;
        private String cursor;



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
         * Setter for deviceCodes.
         * @param  deviceCodes  List of DeviceCode value for deviceCodes.
         * @return Builder
         */
        public Builder deviceCodes(List<DeviceCode> deviceCodes) {
            this.deviceCodes = deviceCodes;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
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
            ListDeviceCodesResponse model =
                    new ListDeviceCodesResponse(errors, deviceCodes, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
