package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveCashDrawerShiftResponse {

    @JsonCreator
    public RetrieveCashDrawerShiftResponse(
            @JsonProperty("cash_drawer_shift") CashDrawerShift cashDrawerShift,
            @JsonProperty("errors") List<Error> errors) {
        this.cashDrawerShift = cashDrawerShift;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final CashDrawerShift cashDrawerShift;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(cashDrawerShift, errors);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveCashDrawerShiftResponse)) {
            return false;
        }
        RetrieveCashDrawerShiftResponse retrieveCashDrawerShiftResponse = (RetrieveCashDrawerShiftResponse) o;
        return Objects.equals(cashDrawerShift, retrieveCashDrawerShiftResponse.cashDrawerShift) &&
            Objects.equals(errors, retrieveCashDrawerShiftResponse.errors);
    }
    

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for CashDrawerShift.
     * This model gives the details of a cash drawer shift.
     * The cash_payment_money, cash_refund_money, cash_paid_in_money,
     * and cash_paid_out_money fields are all computed by summing their respective
     * event types.
     */
    @JsonGetter("cash_drawer_shift")
    public CashDrawerShift getCashDrawerShift() { 
        return this.cashDrawerShift;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cashDrawerShift(getCashDrawerShift())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private CashDrawerShift cashDrawerShift;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder cashDrawerShift(CashDrawerShift value) {
            cashDrawerShift = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public RetrieveCashDrawerShiftResponse build() {
            RetrieveCashDrawerShiftResponse model = new RetrieveCashDrawerShiftResponse(cashDrawerShift,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
