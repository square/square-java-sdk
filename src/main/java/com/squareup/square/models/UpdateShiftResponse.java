
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for UpdateShiftResponse type.
 */
public class UpdateShiftResponse {
    private HttpContext httpContext;
    private final Shift shift;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param shift Shift value for shift.
     * @param errors List of Error value for errors.
     */
    @JsonCreator
    public UpdateShiftResponse(
            @JsonProperty("shift") Shift shift,
            @JsonProperty("errors") List<Error> errors) {
        this.shift = shift;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Shift.
     * A record of the hourly rate, start, and end times for a single work shift for an employee.
     * May include a record of the start and end times for breaks taken during the shift.
     * @return Returns the Shift
     */
    @JsonGetter("shift")
    public Shift getShift() {
        return this.shift;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(shift, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateShiftResponse)) {
            return false;
        }
        UpdateShiftResponse other = (UpdateShiftResponse) obj;
        return Objects.equals(shift, other.shift)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Builds a new {@link UpdateShiftResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateShiftResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .shift(getShift())
            .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateShiftResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Shift shift;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for shift.
         * @param shift Shift value for shift.
         * @return Builder
         */
        public Builder shift(Shift shift) {
            this.shift = shift;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link UpdateShiftResponse} object using the set fields.
         * @return {@link UpdateShiftResponse}
         */
        public UpdateShiftResponse build() {
            UpdateShiftResponse model =
                    new UpdateShiftResponse(shift,
                            errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
