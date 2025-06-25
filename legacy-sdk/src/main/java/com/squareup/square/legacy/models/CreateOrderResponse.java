package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateOrderResponse type.
 */
public class CreateOrderResponse {
    private HttpContext httpContext;
    private final Order order;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  order  Order value for order.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CreateOrderResponse(@JsonProperty("order") Order order, @JsonProperty("errors") List<Error> errors) {
        this.order = order;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. `Order` objects also include information about
     * any associated tenders, refunds, and returns. All Connect V2 Transactions have all been
     * converted to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Order getOrder() {
        return order;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        if (!(obj instanceof CreateOrderResponse)) {
            return false;
        }
        CreateOrderResponse other = (CreateOrderResponse) obj;
        return Objects.equals(order, other.order) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CreateOrderResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateOrderResponse [" + "order=" + order + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link CreateOrderResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateOrderResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().order(getOrder()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateOrderResponse}.
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
         * Builds a new {@link CreateOrderResponse} object using the set fields.
         * @return {@link CreateOrderResponse}
         */
        public CreateOrderResponse build() {
            CreateOrderResponse model = new CreateOrderResponse(order, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
