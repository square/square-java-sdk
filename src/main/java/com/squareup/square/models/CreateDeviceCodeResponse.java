package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CreateDeviceCodeResponse type.
 */
public class CreateDeviceCodeResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param deviceCode
     */
    @JsonCreator
    public CreateDeviceCodeResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("device_code") DeviceCode deviceCode) {
        this.errors = errors;
        this.deviceCode = deviceCode;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final DeviceCode deviceCode;

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
     * Getter for DeviceCode.
     */
    @JsonGetter("device_code")
    public DeviceCode getDeviceCode() {
        return this.deviceCode;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, deviceCode);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateDeviceCodeResponse)) {
            return false;
        }
        CreateDeviceCodeResponse createDeviceCodeResponse = (CreateDeviceCodeResponse) obj;
        return Objects.equals(errors, createDeviceCodeResponse.errors) &&
            Objects.equals(deviceCode, createDeviceCodeResponse.deviceCode);
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
     * Class to build instances of {@link CreateDeviceCodeResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private DeviceCode deviceCode;

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
         * Setter for deviceCode
         * @param deviceCode
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
            CreateDeviceCodeResponse model = new CreateDeviceCodeResponse(errors,
                deviceCode);
            model.httpContext = httpContext;
            return model;
        }
    }
}
