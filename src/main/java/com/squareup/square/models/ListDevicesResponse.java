
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
 * This is a model class for ListDevicesResponse type.
 */
public class ListDevicesResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Device> devices;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  devices  List of Device value for devices.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListDevicesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("devices") List<Device> devices,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.devices = devices;
        this.cursor = cursor;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Devices.
     * The requested list of `Device` objects.
     * @return Returns the List of Device
     */
    @JsonGetter("devices")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. See
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     * for more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, devices, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDevicesResponse)) {
            return false;
        }
        ListDevicesResponse other = (ListDevicesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(devices, other.devices)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListDevicesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDevicesResponse [" + "errors=" + errors + ", devices=" + devices + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link ListDevicesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDevicesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .devices(getDevices())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListDevicesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Device> devices;
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
         * Setter for devices.
         * @param  devices  List of Device value for devices.
         * @return Builder
         */
        public Builder devices(List<Device> devices) {
            this.devices = devices;
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
         * Builds a new {@link ListDevicesResponse} object using the set fields.
         * @return {@link ListDevicesResponse}
         */
        public ListDevicesResponse build() {
            ListDevicesResponse model =
                    new ListDevicesResponse(errors, devices, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
