
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CheckAppointmentsOnboardedResponse type.
 */
public class CheckAppointmentsOnboardedResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean appointmentsOnboarded;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  appointmentsOnboarded  Boolean value for appointmentsOnboarded.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CheckAppointmentsOnboardedResponse(
            @JsonProperty("appointments_onboarded") Boolean appointmentsOnboarded,
            @JsonProperty("errors") List<Error> errors) {
        this.appointmentsOnboarded = appointmentsOnboarded;
        this.errors = errors;
    }

    /**
     * Getter for AppointmentsOnboarded.
     * Indicates whether the seller has enabled the Square Appointments service (`true`) or not
     * (`false`).
     * @return Returns the Boolean
     */
    @JsonGetter("appointments_onboarded")
    public Boolean getAppointmentsOnboarded() {
        return appointmentsOnboarded;
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

    @Override
    public int hashCode() {
        return Objects.hash(appointmentsOnboarded, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckAppointmentsOnboardedResponse)) {
            return false;
        }
        CheckAppointmentsOnboardedResponse other = (CheckAppointmentsOnboardedResponse) obj;
        return Objects.equals(appointmentsOnboarded, other.appointmentsOnboarded)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CheckAppointmentsOnboardedResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckAppointmentsOnboardedResponse [" + "appointmentsOnboarded="
                + appointmentsOnboarded + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link CheckAppointmentsOnboardedResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckAppointmentsOnboardedResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .appointmentsOnboarded(getAppointmentsOnboarded())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link CheckAppointmentsOnboardedResponse}.
     */
    public static class Builder {
        private Boolean appointmentsOnboarded;
        private List<Error> errors;



        /**
         * Setter for appointmentsOnboarded.
         * @param  appointmentsOnboarded  Boolean value for appointmentsOnboarded.
         * @return Builder
         */
        public Builder appointmentsOnboarded(Boolean appointmentsOnboarded) {
            this.appointmentsOnboarded = appointmentsOnboarded;
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
         * Builds a new {@link CheckAppointmentsOnboardedResponse} object using the set fields.
         * @return {@link CheckAppointmentsOnboardedResponse}
         */
        public CheckAppointmentsOnboardedResponse build() {
            return new CheckAppointmentsOnboardedResponse(appointmentsOnboarded, errors);
        }
    }
}
