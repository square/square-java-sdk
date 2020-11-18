
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for OnboardAppointmentsResponse type.
 */
public class OnboardAppointmentsResponse {
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     */
    @JsonCreator
    public OnboardAppointmentsResponse(
            @JsonProperty("errors") List<Error> errors) {
        this.errors = errors;
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
        return Objects.hash(errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OnboardAppointmentsResponse)) {
            return false;
        }
        OnboardAppointmentsResponse other = (OnboardAppointmentsResponse) obj;
        return Objects.equals(errors, other.errors);
    }

    /**
     * Converts this OnboardAppointmentsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OnboardAppointmentsResponse [" + "errors=" + errors + "]";
    }

    /**
     * Builds a new {@link OnboardAppointmentsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OnboardAppointmentsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link OnboardAppointmentsResponse}.
     */
    public static class Builder {
        private List<Error> errors;



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
         * Builds a new {@link OnboardAppointmentsResponse} object using the set fields.
         * @return {@link OnboardAppointmentsResponse}
         */
        public OnboardAppointmentsResponse build() {
            return new OnboardAppointmentsResponse(errors);
        }
    }
}
