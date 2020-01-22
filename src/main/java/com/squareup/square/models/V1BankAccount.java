package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1BankAccount type.
 */
public class V1BankAccount {

    /**
     * Initialization constructor.
     * @param id
     * @param merchantId
     * @param bankName
     * @param name
     * @param routingNumber
     * @param accountNumberSuffix
     * @param currencyCode
     * @param type
     */
    @JsonCreator
    public V1BankAccount(
            @JsonProperty("id") String id,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("bank_name") String bankName,
            @JsonProperty("name") String name,
            @JsonProperty("routing_number") String routingNumber,
            @JsonProperty("account_number_suffix") String accountNumberSuffix,
            @JsonProperty("currency_code") String currencyCode,
            @JsonProperty("type") String type) {
        this.id = id;
        this.merchantId = merchantId;
        this.bankName = bankName;
        this.name = name;
        this.routingNumber = routingNumber;
        this.accountNumberSuffix = accountNumberSuffix;
        this.currencyCode = currencyCode;
        this.type = type;
    }

    private HttpContext httpContext;
    private final String id;
    private final String merchantId;
    private final String bankName;
    private final String name;
    private final String routingNumber;
    private final String accountNumberSuffix;
    private final String currencyCode;
    private final String type;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The bank account's Square-issued ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for MerchantId.
     * The Square-issued ID of the merchant associated with the bank account.
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() {
        return this.merchantId;
    }

    /**
     * Getter for BankName.
     * The name of the bank that manages the account.
     */
    @JsonGetter("bank_name")
    public String getBankName() {
        return this.bankName;
    }

    /**
     * Getter for Name.
     * The name associated with the bank account.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for RoutingNumber.
     * The bank account's routing number.
     */
    @JsonGetter("routing_number")
    public String getRoutingNumber() {
        return this.routingNumber;
    }

    /**
     * Getter for AccountNumberSuffix.
     * The last few digits of the bank account number.
     */
    @JsonGetter("account_number_suffix")
    public String getAccountNumberSuffix() {
        return this.accountNumberSuffix;
    }

    /**
     * Getter for CurrencyCode.
     * The currency code of the currency associated with the bank account, in ISO 4217 format. For example, the currency code for US dollars is USD.
     */
    @JsonGetter("currency_code")
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /**
     * Getter for Type.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, merchantId, bankName, name, routingNumber, accountNumberSuffix,
            currencyCode, type);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1BankAccount)) {
            return false;
        }
        V1BankAccount v1BankAccount = (V1BankAccount) obj;
        return Objects.equals(id, v1BankAccount.id) &&
            Objects.equals(merchantId, v1BankAccount.merchantId) &&
            Objects.equals(bankName, v1BankAccount.bankName) &&
            Objects.equals(name, v1BankAccount.name) &&
            Objects.equals(routingNumber, v1BankAccount.routingNumber) &&
            Objects.equals(accountNumberSuffix, v1BankAccount.accountNumberSuffix) &&
            Objects.equals(currencyCode, v1BankAccount.currencyCode) &&
            Objects.equals(type, v1BankAccount.type);
    }

    /**
     * Builds a new {@link V1BankAccount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1BankAccount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .merchantId(getMerchantId())
            .bankName(getBankName())
            .name(getName())
            .routingNumber(getRoutingNumber())
            .accountNumberSuffix(getAccountNumberSuffix())
            .currencyCode(getCurrencyCode())
            .type(getType());
            return builder;
    }

    /**
     * Class to build instances of {@link V1BankAccount}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String merchantId;
        private String bankName;
        private String name;
        private String routingNumber;
        private String accountNumberSuffix;
        private String currencyCode;
        private String type;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for merchantId
         * @param merchantId
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }
        /**
         * Setter for bankName
         * @param bankName
         * @return Builder
         */
        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for routingNumber
         * @param routingNumber
         * @return Builder
         */
        public Builder routingNumber(String routingNumber) {
            this.routingNumber = routingNumber;
            return this;
        }
        /**
         * Setter for accountNumberSuffix
         * @param accountNumberSuffix
         * @return Builder
         */
        public Builder accountNumberSuffix(String accountNumberSuffix) {
            this.accountNumberSuffix = accountNumberSuffix;
            return this;
        }
        /**
         * Setter for currencyCode
         * @param currencyCode
         * @return Builder
         */
        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }
        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds a new {@link V1BankAccount} object using the set fields.
         * @return {@link V1BankAccount}
         */
        public V1BankAccount build() {
            V1BankAccount model = new V1BankAccount(id,
                merchantId,
                bankName,
                name,
                routingNumber,
                accountNumberSuffix,
                currencyCode,
                type);
            model.httpContext = httpContext;
            return model;
        }
    }
}
