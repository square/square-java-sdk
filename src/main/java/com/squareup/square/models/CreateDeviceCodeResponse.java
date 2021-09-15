
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
 * This is a model class for CreateDeviceCodeResponse type.
 */
public class CreateDeviceCodeResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final DeviceCode deviceCode;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  deviceCode  DeviceCode value for deviceCode.
     */
    @JsonCreator
    public CreateDeviceCodeResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("device_code") DeviceCode deviceCode) {
        this.errors = errors;
        this.deviceCode = deviceCode;
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
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for DeviceCode.
     * @return Returns the DeviceCode
     */
    @JsonGetter("device_code")
    public DeviceCode getDeviceCode() {
        return deviceCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, deviceCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateDeviceCodeResponse)) {
            return false;
        }
        CreateDeviceCodeResponse other = (CreateDeviceCodeResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(deviceCode, other.deviceCode);
    }

    /**
     * Converts this CreateDeviceCodeResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateDeviceCodeResponse [" + "errors=" + errors + ", deviceCode=" + deviceCode
                + "]";
    }

    /**
     * Builds a new {@link CreateDeviceCodeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateDeviceCodeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .deviceCode(getDeviceCode());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateDeviceCodeResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private DeviceCode deviceCode;



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
         * Setter for deviceCode.
         * @param  deviceCode  DeviceCode value for deviceCode.
         * @return Builder
         */
        public Builder deviceCode(DeviceCode deviceCode) {
            this.deviceCode = deviceCode;
            return this;
        }

        /**
         * Builds a new {@link CreateDeviceCodeResponse} object using the set fields.
         * @return {@link CreateDeviceCodeResponse}
         */
        public CreateDeviceCodeResponse build() {
            CreateDeviceCodeResponse model =
                    new CreateDeviceCodeResponse(errors, deviceCode);
            model.httpContext = httpContext;
            return model;
        }
    }
}
