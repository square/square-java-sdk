package com.squareup.square;

import java.util.Map;
import java.util.HashMap;

import com.squareup.square.api.*;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.OkClient;
import com.squareup.square.http.Headers;

public final class SquareClient implements Configuration {
    private MobileAuthorizationApi mobileAuthorization;
    private OAuthApi oAuth;
    private V1LocationsApi v1Locations;
    private V1EmployeesApi v1Employees;
    private V1TransactionsApi v1Transactions;
    private V1ItemsApi v1Items;
    private ApplePayApi applePay;
    private CashDrawersApi cashDrawers;
    private CatalogApi catalog;
    private CustomersApi customers;
    private EmployeesApi employees;
    private InventoryApi inventory;
    private LaborApi labor;
    private LocationsApi locations;
    private ReportingApi reporting;
    private CheckoutApi checkout;
    private OrdersApi orders;
    private TransactionsApi transactions;
    private MerchantsApi merchants;
    private PaymentsApi payments;
    private RefundsApi refunds;

    public MobileAuthorizationApi getMobileAuthorizationApi() {
        return mobileAuthorization;
    }

    public OAuthApi getOAuthApi() {
        return oAuth;
    }

    public V1LocationsApi getV1LocationsApi() {
        return v1Locations;
    }

    public V1EmployeesApi getV1EmployeesApi() {
        return v1Employees;
    }

    public V1TransactionsApi getV1TransactionsApi() {
        return v1Transactions;
    }

    public V1ItemsApi getV1ItemsApi() {
        return v1Items;
    }

    public ApplePayApi getApplePayApi() {
        return applePay;
    }

    public CashDrawersApi getCashDrawersApi() {
        return cashDrawers;
    }

    public CatalogApi getCatalogApi() {
        return catalog;
    }

    public CustomersApi getCustomersApi() {
        return customers;
    }

    public EmployeesApi getEmployeesApi() {
        return employees;
    }

    public InventoryApi getInventoryApi() {
        return inventory;
    }

    public LaborApi getLaborApi() {
        return labor;
    }

    public LocationsApi getLocationsApi() {
        return locations;
    }

    public ReportingApi getReportingApi() {
        return reporting;
    }

    public CheckoutApi getCheckoutApi() {
        return checkout;
    }

    public OrdersApi getOrdersApi() {
        return orders;
    }

    public TransactionsApi getTransactionsApi() {
        return transactions;
    }

    public MerchantsApi getMerchantsApi() {
        return merchants;
    }

    public PaymentsApi getPaymentsApi() {
        return payments;
    }

    public RefundsApi getRefundsApi() {
        return refunds;
    }

    public static void shutdown() {
        OkClient.shutdown();
    }

    private SquareClient(Environment environment, String accessToken, HttpClient httpClient, long timeout,
            Headers additionalHeaders, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        this.environment = environment;
        this.accessToken = accessToken;
        this.httpClient = httpClient;
        this.timeout = timeout;
        this.additionalHeaders = additionalHeaders;
        this.httpCallback = httpCallback;

        this.authManagers = (authManagers == null) ? new HashMap<>() : new HashMap<>(authManagers);
        if (!this.authManagers.containsKey("default")
                || ((AccessTokenManager) this.authManagers.get("default")).getAccessToken() != accessToken) {
            AuthManager accessTokenManager = new AccessTokenManager(accessToken);
            this.authManagers.put("default", accessTokenManager);
        }

        mobileAuthorization = new MobileAuthorizationApi(this, this.httpClient, this.authManagers, this.httpCallback);
        oAuth = new OAuthApi(this, this.httpClient, this.authManagers, this.httpCallback);
        v1Locations = new V1LocationsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        v1Employees = new V1EmployeesApi(this, this.httpClient, this.authManagers, this.httpCallback);
        v1Transactions = new V1TransactionsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        v1Items = new V1ItemsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        applePay = new ApplePayApi(this, this.httpClient, this.authManagers, this.httpCallback);
        cashDrawers = new CashDrawersApi(this, this.httpClient, this.authManagers, this.httpCallback);
        catalog = new CatalogApi(this, this.httpClient, this.authManagers, this.httpCallback);
        customers = new CustomersApi(this, this.httpClient, this.authManagers, this.httpCallback);
        employees = new EmployeesApi(this, this.httpClient, this.authManagers, this.httpCallback);
        inventory = new InventoryApi(this, this.httpClient, this.authManagers, this.httpCallback);
        labor = new LaborApi(this, this.httpClient, this.authManagers, this.httpCallback);
        locations = new LocationsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        reporting = new ReportingApi(this, this.httpClient, this.authManagers, this.httpCallback);
        checkout = new CheckoutApi(this, this.httpClient, this.authManagers, this.httpCallback);
        orders = new OrdersApi(this, this.httpClient, this.authManagers, this.httpCallback);
        transactions = new TransactionsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        merchants = new MerchantsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        payments = new PaymentsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        refunds = new RefundsApi(this, this.httpClient, this.authManagers, this.httpCallback);
    }

    /**
     * Current API environment
     */
    private final Environment environment;

    /**
     * OAuth 2.0 Access Token
     */
    private final String accessToken;

    /**
     * The HTTP Client instance to use for making HTTP requests.
     */
    private final HttpClient httpClient;

    /**
     * The timeout to use for making HTTP requests.
     */
    private final long timeout;

    /**
     * Additional headers to add to each API request
     */
    private final Headers additionalHeaders;

    /**
     * Map of authentication Managers.
     */
    private Map<String, AuthManager> authManagers;

    /**
     * Callback to be called before and after the HTTP call for an endpoint is made.
     */
    private final HttpCallback httpCallback;

    /**
     * Current API environment
     * @return environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * OAuth 2.0 Access Token
     * @return accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * The HTTP Client instance to use for making HTTP requests.
     * @return httpClient
     */
    private HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * The timeout to use for making HTTP requests.
     * @return timeout
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * Additional headers to add to each API request
     * @return a copy of additionalHeaders
     */
    public Headers getAdditionalHeaders() {
        return new Headers(additionalHeaders);
    }

    /**
     * Current SDK Version
     * @return sdkVersion
     */
    public String getSdkVersion() {
        return "4.0.0.20191217";
    }

    /**
     * Current Square Version
     * @return squareVersion
     */
    public String getSquareVersion() {
        return "2019-12-17";
    }

    /**
     * Get base URI by current environment
     * @param server Server for which to get the base URI
     * @return Processed base URI
     */
    public String getBaseUri(Server server) {
        StringBuilder baseUrl = new StringBuilder(environmentMapper(environment, server));
        Map<String, Object> parameters = new HashMap<String, Object>();
        ApiHelper.appendUrlWithTemplateParameters(baseUrl, parameters, false);
        return baseUrl.toString();
    }

    /**
     * Get base URI by current environment
     * @return Processed base URI
     */
    public String getBaseUri() {
        return getBaseUri(Server.ENUM_DEFAULT);
    }

    /**
     * Base URLs by environment and server aliases
     * @param environment Environment for which to get the base URI
     * @param server Server for which to get the base URI
     * @return base URL
     */
    private static String environmentMapper(Environment environment, Server server) {
        if (environment.equals(Environment.PRODUCTION)) {
            if (server.equals(Server.ENUM_DEFAULT)) {
                return "https://connect.squareup.com";
            }
        }
        if (environment.equals(Environment.SANDBOX)) {
            if (server.equals(Server.ENUM_DEFAULT)) {
                return "https://connect.squareupsandbox.com";
            }
        }
        return "https://connect.squareup.com";
    }

    
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.environment = getEnvironment();
        builder.accessToken = getAccessToken();
        builder.httpClient = getHttpClient();
        builder.timeout = getTimeout();
        builder.additionalHeaders = getAdditionalHeaders();
        builder.authManagers = authManagers;
        builder.httpCallback = httpCallback;
        return builder;
    }

    public static class Builder {
        private Environment environment = Environment.PRODUCTION;
        private String accessToken = "TODO: Replace";
        private HttpClient httpClient;
        private long timeout = 60;
        private Headers additionalHeaders = new Headers();
        private Map<String, AuthManager> authManagers = null;
        private HttpCallback httpCallback = null;

        /**
         * Current API environment
         * @param environment
         */
        public Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }
        /**
         * OAuth 2.0 Access Token
         * @param accessToken
         */
        public Builder accessToken(String accessToken) {
            if (accessToken == null) {
                throw new NullPointerException();
            }
            this.accessToken = accessToken;
            return this;
        }
        /**
         * The timeout to use for making HTTP requests.
         * @param timeout must be greater then 0.
         */
        public Builder timeout(long timeout) {
            if (timeout > 0) {
                this.timeout = timeout;
            }
            return this;
        }
        /**
         * Additional headers to add to each API request
         * @param additionalHeaders
         */
        public Builder additionalHeaders(Headers additionalHeaders) {
            if (additionalHeaders == null) {
                throw new NullPointerException();
            }
            this.additionalHeaders = additionalHeaders;
            return this;
        }
        /**
         * HttpCallback
         * @param httpCallback
         */
        public Builder httpCallback(HttpCallback httpCallback) {
            this.httpCallback = httpCallback;
            return this;
        }

        /**
         * Builds a new SquareClient object using the set fields.
         * @return SquareClient
         */
        public SquareClient build() {
            httpClient = new OkClient(timeout);

            return new SquareClient(environment, accessToken, httpClient, timeout, additionalHeaders, authManagers,
                    httpCallback);
        }

    }
}
