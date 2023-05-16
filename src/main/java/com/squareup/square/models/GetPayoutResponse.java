
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
 * This is a model class for GetPayoutResponse type.
 */
public class GetPayoutResponse {
    private HttpContext httpContext;
    private final Payout payout;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  payout  Payout value for payout.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public GetPayoutResponse(
            @JsonProperty("payout") Payout payout,
            @JsonProperty("errors") List<Error> errors) {
        this.payout = payout;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Payout.
     * An accounting of the amount owed the seller and record of the actual transfer to their
     * external bank account or to the Square balance.
     * @return Returns the Payout
     */
    @JsonGetter("payout")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Payout getPayout() {
        return payout;
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

    @Override
    public int hashCode() {
        return Objects.hash(payout, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetPayoutResponse)) {
            return false;
        }
        GetPayoutResponse other = (GetPayoutResponse) obj;
        return Objects.equals(payout, other.payout)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this GetPayoutResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GetPayoutResponse [" + "payout=" + payout + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link GetPayoutResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GetPayoutResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .payout(getPayout())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link GetPayoutResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Payout payout;
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
         * Setter for payout.
         * @param  payout  Payout value for payout.
         * @return Builder
         */
        public Builder payout(Payout payout) {
            this.payout = payout;
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
         * Builds a new {@link GetPayoutResponse} object using the set fields.
         * @return {@link GetPayoutResponse}
         */
        public GetPayoutResponse build() {
            GetPayoutResponse model =
                    new GetPayoutResponse(payout, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
