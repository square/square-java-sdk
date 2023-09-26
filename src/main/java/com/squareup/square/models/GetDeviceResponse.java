
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
 * This is a model class for GetDeviceResponse type.
 */
public class GetDeviceResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Device device;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  device  Device value for device.
     */
    @JsonCreator
    public GetDeviceResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("device") Device device) {
        this.errors = errors;
        this.device = device;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Device.
     * @return Returns the Device
     */
    @JsonGetter("device")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Device getDevice() {
        return device;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, device);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetDeviceResponse)) {
            return false;
        }
        GetDeviceResponse other = (GetDeviceResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(device, other.device);
    }

    /**
     * Converts this GetDeviceResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GetDeviceResponse [" + "errors=" + errors + ", device=" + device + "]";
    }

    /**
     * Builds a new {@link GetDeviceResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GetDeviceResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .device(getDevice());
        return builder;
    }

    /**
     * Class to build instances of {@link GetDeviceResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Device device;



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
         * Setter for device.
         * @param  device  Device value for device.
         * @return Builder
         */
        public Builder device(Device device) {
            this.device = device;
            return this;
        }

        /**
         * Builds a new {@link GetDeviceResponse} object using the set fields.
         * @return {@link GetDeviceResponse}
         */
        public GetDeviceResponse build() {
            GetDeviceResponse model =
                    new GetDeviceResponse(errors, device);
            model.httpContext = httpContext;
            return model;
        }
    }
}
