
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
 * This is a model class for DeletePaymentLinkResponse type.
 */
public class DeletePaymentLinkResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final String id;
    private final String cancelledOrderId;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  id  String value for id.
     * @param  cancelledOrderId  String value for cancelledOrderId.
     */
    @JsonCreator
    public DeletePaymentLinkResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("id") String id,
            @JsonProperty("cancelled_order_id") String cancelledOrderId) {
        this.errors = errors;
        this.id = id;
        this.cancelledOrderId = cancelledOrderId;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Id.
     * The ID of the link that is deleted.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for CancelledOrderId.
     * The ID of the order that is canceled. When a payment link is deleted, Square updates the the
     * `state` (of the order that the checkout link created) to CANCELED.
     * @return Returns the String
     */
    @JsonGetter("cancelled_order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCancelledOrderId() {
        return cancelledOrderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, id, cancelledOrderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeletePaymentLinkResponse)) {
            return false;
        }
        DeletePaymentLinkResponse other = (DeletePaymentLinkResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(id, other.id)
            && Objects.equals(cancelledOrderId, other.cancelledOrderId);
    }

    /**
     * Converts this DeletePaymentLinkResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeletePaymentLinkResponse [" + "errors=" + errors + ", id=" + id
                + ", cancelledOrderId=" + cancelledOrderId + "]";
    }

    /**
     * Builds a new {@link DeletePaymentLinkResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeletePaymentLinkResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .id(getId())
                .cancelledOrderId(getCancelledOrderId());
        return builder;
    }

    /**
     * Class to build instances of {@link DeletePaymentLinkResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String id;
        private String cancelledOrderId;



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
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for cancelledOrderId.
         * @param  cancelledOrderId  String value for cancelledOrderId.
         * @return Builder
         */
        public Builder cancelledOrderId(String cancelledOrderId) {
            this.cancelledOrderId = cancelledOrderId;
            return this;
        }

        /**
         * Builds a new {@link DeletePaymentLinkResponse} object using the set fields.
         * @return {@link DeletePaymentLinkResponse}
         */
        public DeletePaymentLinkResponse build() {
            DeletePaymentLinkResponse model =
                    new DeletePaymentLinkResponse(errors, id, cancelledOrderId);
            model.httpContext = httpContext;
            return model;
        }
    }
}
