
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateOrderResponse type.
 */
public class UpdateOrderResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Order order;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  order  Order value for order.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public UpdateOrderResponse(
            @JsonProperty("order") Order order,
            @JsonProperty("errors") List<Error> errors) {
        this.order = order;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. Order objects also include information on any
     * associated tenders, refunds, and returns. All Connect V2 Transactions have all been converted
     * to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    public Order getOrder() {
        return order;
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
        return Objects.hash(order, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateOrderResponse)) {
            return false;
        }
        UpdateOrderResponse other = (UpdateOrderResponse) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this UpdateOrderResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateOrderResponse [" + "order=" + order + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link UpdateOrderResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateOrderResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .order(getOrder())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateOrderResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Order order;
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
         * Setter for order.
         * @param  order  Order value for order.
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
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
         * Builds a new {@link UpdateOrderResponse} object using the set fields.
         * @return {@link UpdateOrderResponse}
         */
        public UpdateOrderResponse build() {
            UpdateOrderResponse model =
                    new UpdateOrderResponse(order, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
