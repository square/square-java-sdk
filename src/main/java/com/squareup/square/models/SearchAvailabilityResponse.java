
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
 * This is a model class for SearchAvailabilityResponse type.
 */
public class SearchAvailabilityResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Availability> availabilities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  availabilities  List of Availability value for availabilities.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public SearchAvailabilityResponse(
            @JsonProperty("availabilities") List<Availability> availabilities,
            @JsonProperty("errors") List<Error> errors) {
        this.availabilities = availabilities;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Availabilities.
     * List of slots available for booking.
     * @return Returns the List of Availability
     */
    @JsonGetter("availabilities")
    public List<Availability> getAvailabilities() {
        return availabilities;
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
        return Objects.hash(availabilities, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchAvailabilityResponse)) {
            return false;
        }
        SearchAvailabilityResponse other = (SearchAvailabilityResponse) obj;
        return Objects.equals(availabilities, other.availabilities)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this SearchAvailabilityResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchAvailabilityResponse [" + "availabilities=" + availabilities + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link SearchAvailabilityResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchAvailabilityResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .availabilities(getAvailabilities())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchAvailabilityResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Availability> availabilities;
        private List<Error> errors;



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
         * Setter for availabilities.
         * @param  availabilities  List of Availability value for availabilities.
         * @return Builder
         */
        public Builder availabilities(List<Availability> availabilities) {
            this.availabilities = availabilities;
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
         * Builds a new {@link SearchAvailabilityResponse} object using the set fields.
         * @return {@link SearchAvailabilityResponse}
         */
        public SearchAvailabilityResponse build() {
            SearchAvailabilityResponse model =
                    new SearchAvailabilityResponse(availabilities, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
