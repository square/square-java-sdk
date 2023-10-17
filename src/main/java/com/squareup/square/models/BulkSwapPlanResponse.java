
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
 * This is a model class for BulkSwapPlanResponse type.
 */
public class BulkSwapPlanResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Integer affectedSubscriptions;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  affectedSubscriptions  Integer value for affectedSubscriptions.
     */
    @JsonCreator
    public BulkSwapPlanResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("affected_subscriptions") Integer affectedSubscriptions) {
        this.errors = errors;
        this.affectedSubscriptions = affectedSubscriptions;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for AffectedSubscriptions.
     * The number of affected subscriptions.
     * @return Returns the Integer
     */
    @JsonGetter("affected_subscriptions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getAffectedSubscriptions() {
        return affectedSubscriptions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, affectedSubscriptions);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkSwapPlanResponse)) {
            return false;
        }
        BulkSwapPlanResponse other = (BulkSwapPlanResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(affectedSubscriptions, other.affectedSubscriptions);
    }

    /**
     * Converts this BulkSwapPlanResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkSwapPlanResponse [" + "errors=" + errors + ", affectedSubscriptions="
                + affectedSubscriptions + "]";
    }

    /**
     * Builds a new {@link BulkSwapPlanResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkSwapPlanResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .affectedSubscriptions(getAffectedSubscriptions());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkSwapPlanResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Integer affectedSubscriptions;



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
         * Setter for affectedSubscriptions.
         * @param  affectedSubscriptions  Integer value for affectedSubscriptions.
         * @return Builder
         */
        public Builder affectedSubscriptions(Integer affectedSubscriptions) {
            this.affectedSubscriptions = affectedSubscriptions;
            return this;
        }

        /**
         * Builds a new {@link BulkSwapPlanResponse} object using the set fields.
         * @return {@link BulkSwapPlanResponse}
         */
        public BulkSwapPlanResponse build() {
            BulkSwapPlanResponse model =
                    new BulkSwapPlanResponse(errors, affectedSubscriptions);
            model.httpContext = httpContext;
            return model;
        }
    }
}
