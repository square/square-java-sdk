
package com.squareup.square;

import com.squareup.square.api.ApplePayApi;
import com.squareup.square.api.BankAccountsApi;
import com.squareup.square.api.BookingCustomAttributesApi;
import com.squareup.square.api.BookingsApi;
import com.squareup.square.api.CardsApi;
import com.squareup.square.api.CashDrawersApi;
import com.squareup.square.api.CatalogApi;
import com.squareup.square.api.CheckoutApi;
import com.squareup.square.api.CustomerCustomAttributesApi;
import com.squareup.square.api.CustomerGroupsApi;
import com.squareup.square.api.CustomerSegmentsApi;
import com.squareup.square.api.CustomersApi;
import com.squareup.square.api.DefaultApplePayApi;
import com.squareup.square.api.DefaultBankAccountsApi;
import com.squareup.square.api.DefaultBookingCustomAttributesApi;
import com.squareup.square.api.DefaultBookingsApi;
import com.squareup.square.api.DefaultCardsApi;
import com.squareup.square.api.DefaultCashDrawersApi;
import com.squareup.square.api.DefaultCatalogApi;
import com.squareup.square.api.DefaultCheckoutApi;
import com.squareup.square.api.DefaultCustomerCustomAttributesApi;
import com.squareup.square.api.DefaultCustomerGroupsApi;
import com.squareup.square.api.DefaultCustomerSegmentsApi;
import com.squareup.square.api.DefaultCustomersApi;
import com.squareup.square.api.DefaultDevicesApi;
import com.squareup.square.api.DefaultDisputesApi;
import com.squareup.square.api.DefaultEmployeesApi;
import com.squareup.square.api.DefaultGiftCardActivitiesApi;
import com.squareup.square.api.DefaultGiftCardsApi;
import com.squareup.square.api.DefaultInventoryApi;
import com.squareup.square.api.DefaultInvoicesApi;
import com.squareup.square.api.DefaultLaborApi;
import com.squareup.square.api.DefaultLocationCustomAttributesApi;
import com.squareup.square.api.DefaultLocationsApi;
import com.squareup.square.api.DefaultLoyaltyApi;
import com.squareup.square.api.DefaultMerchantCustomAttributesApi;
import com.squareup.square.api.DefaultMerchantsApi;
import com.squareup.square.api.DefaultMobileAuthorizationApi;
import com.squareup.square.api.DefaultOAuthApi;
import com.squareup.square.api.DefaultOrderCustomAttributesApi;
import com.squareup.square.api.DefaultOrdersApi;
import com.squareup.square.api.DefaultPaymentsApi;
import com.squareup.square.api.DefaultPayoutsApi;
import com.squareup.square.api.DefaultRefundsApi;
import com.squareup.square.api.DefaultSitesApi;
import com.squareup.square.api.DefaultSnippetsApi;
import com.squareup.square.api.DefaultSubscriptionsApi;
import com.squareup.square.api.DefaultTeamApi;
import com.squareup.square.api.DefaultTerminalApi;
import com.squareup.square.api.DefaultTransactionsApi;
import com.squareup.square.api.DefaultV1TransactionsApi;
import com.squareup.square.api.DefaultVendorsApi;
import com.squareup.square.api.DefaultWebhookSubscriptionsApi;
import com.squareup.square.api.DevicesApi;
import com.squareup.square.api.DisputesApi;
import com.squareup.square.api.EmployeesApi;
import com.squareup.square.api.GiftCardActivitiesApi;
import com.squareup.square.api.GiftCardsApi;
import com.squareup.square.api.InventoryApi;
import com.squareup.square.api.InvoicesApi;
import com.squareup.square.api.LaborApi;
import com.squareup.square.api.LocationCustomAttributesApi;
import com.squareup.square.api.LocationsApi;
import com.squareup.square.api.LoyaltyApi;
import com.squareup.square.api.MerchantCustomAttributesApi;
import com.squareup.square.api.MerchantsApi;
import com.squareup.square.api.MobileAuthorizationApi;
import com.squareup.square.api.OAuthApi;
import com.squareup.square.api.OrderCustomAttributesApi;
import com.squareup.square.api.OrdersApi;
import com.squareup.square.api.PaymentsApi;
import com.squareup.square.api.PayoutsApi;
import com.squareup.square.api.RefundsApi;
import com.squareup.square.api.SitesApi;
import com.squareup.square.api.SnippetsApi;
import com.squareup.square.api.SubscriptionsApi;
import com.squareup.square.api.TeamApi;
import com.squareup.square.api.TerminalApi;
import com.squareup.square.api.TransactionsApi;
import com.squareup.square.api.V1TransactionsApi;
import com.squareup.square.api.VendorsApi;
import com.squareup.square.api.WebhookSubscriptionsApi;
import com.squareup.square.authentication.BearerAuthManager;
import com.squareup.square.authentication.BearerAuthModel;
import com.squareup.square.http.Headers;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClientConfiguration;
import com.squareup.square.http.client.ReadonlyHttpClientConfiguration;
import io.apimatic.core.GlobalConfiguration;
import io.apimatic.coreinterfaces.authentication.Authentication;
import io.apimatic.coreinterfaces.compatibility.CompatibilityFactory;
import io.apimatic.coreinterfaces.http.HttpClient;
import io.apimatic.okhttpclient.adapter.OkClient;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Gateway class for the library.
 * This class acts as a factory for Apis.
 * It holds the state of the SDK.
 */
public final class SquareClient implements SquareClientInterface {

    /**
     * Private store for controllers.
     */
    private MobileAuthorizationApi mobileAuthorization;
    private OAuthApi oAuth;
    private V1TransactionsApi v1Transactions;
    private ApplePayApi applePay;
    private BankAccountsApi bankAccounts;
    private BookingsApi bookings;
    private BookingCustomAttributesApi bookingCustomAttributes;
    private CardsApi cards;
    private CashDrawersApi cashDrawers;
    private CatalogApi catalog;
    private CustomersApi customers;
    private CustomerCustomAttributesApi customerCustomAttributes;
    private CustomerGroupsApi customerGroups;
    private CustomerSegmentsApi customerSegments;
    private DevicesApi devices;
    private DisputesApi disputes;
    private EmployeesApi employees;
    private GiftCardsApi giftCards;
    private GiftCardActivitiesApi giftCardActivities;
    private InventoryApi inventory;
    private InvoicesApi invoices;
    private LaborApi labor;
    private LocationsApi locations;
    private LocationCustomAttributesApi locationCustomAttributes;
    private CheckoutApi checkout;
    private TransactionsApi transactions;
    private LoyaltyApi loyalty;
    private MerchantsApi merchants;
    private MerchantCustomAttributesApi merchantCustomAttributes;
    private OrdersApi orders;
    private OrderCustomAttributesApi orderCustomAttributes;
    private PaymentsApi payments;
    private PayoutsApi payouts;
    private RefundsApi refunds;
    private SitesApi sites;
    private SnippetsApi snippets;
    private SubscriptionsApi subscriptions;
    private TeamApi team;
    private TerminalApi terminal;
    private VendorsApi vendors;
    private WebhookSubscriptionsApi webhookSubscriptions;

    private static final CompatibilityFactory compatibilityFactory = new CompatibilityFactoryImpl();

    private static String userAgent = "Square-Java-SDK/38.1.0.20240320 ({api-version}) {engine}/{engine-version} ({os-info}) {detail}";

    /**
     * Current API environment.
     */
    private final Environment environment;

    /**
     * Sets the base URL requests are made to. Defaults to `https://connect.squareup.com`
     */
    private final String customUrl;

    /**
     * Square Connect API versions.
     */
    private final String squareVersion;

    /**
     * The HTTP Client instance to use for making HTTP requests.
     */
    private final HttpClient httpClient;

    /**
     * Http Client Configuration instance.
     */
    private final ReadonlyHttpClientConfiguration httpClientConfig;

    /**
     * Additional headers to add to each API request.
     */
    private final Headers additionalHeaders;

    /**
     * Additional detail which can be appended with User-Agent header.
     */
    private final String userAgentDetail;

    /**
     * BearerAuthManager.
     */
    private BearerAuthManager bearerAuthManager;

    /**
     * The instance of BearerAuthModel.
     */
    private BearerAuthModel bearerAuthModel;

    /**
     * Map of authentication Managers.
     */
    private Map<String, Authentication> authentications;

    /**
     * Callback to be called before and after the HTTP call for an endpoint is made.
     */
    private final HttpCallback httpCallback;

    private SquareClient(Environment environment, String customUrl, String squareVersion,
            HttpClient httpClient, ReadonlyHttpClientConfiguration httpClientConfig,
            Headers additionalHeaders, String userAgentDetail, BearerAuthModel bearerAuthModel,
            Map<String, Authentication> authentications, HttpCallback httpCallback) {
        this.environment = environment;
        this.customUrl = customUrl;
        this.squareVersion = squareVersion;
        this.httpClient = httpClient;
        this.httpClientConfig = httpClientConfig;
        this.additionalHeaders = additionalHeaders;
        this.userAgentDetail = userAgentDetail;
        this.httpCallback = httpCallback;
        this.authentications = 
                (authentications == null) ? new HashMap<>() : new HashMap<>(authentications);
        Map<String, String> userAgentConfig = new HashMap<>();
        userAgentConfig.put("{api-version}",
                        squareVersion != null ? squareVersion : "");
        userAgentConfig.put("{detail}",
                userAgentDetail != null? ApiHelper.tryUrlEncode(userAgentDetail, true):  "");

        this.bearerAuthModel = bearerAuthModel;

        if (this.authentications.containsKey("global")) {
            this.bearerAuthManager = (BearerAuthManager) this.authentications.get("global");
        }

        if (!this.authentications.containsKey("global")
                || !getBearerAuthCredentials().equals(bearerAuthModel.getAccessToken())) {
            this.bearerAuthManager = new BearerAuthManager(bearerAuthModel);
            this.authentications.put("global", bearerAuthManager);
        }

        GlobalConfiguration globalConfig = new GlobalConfiguration.Builder()
                .httpClient(httpClient).baseUri(server -> getBaseUri(server))
                .compatibilityFactory(compatibilityFactory)
                .authentication(this.authentications)
                .callback(httpCallback)
                .userAgent(userAgent)
                .userAgentConfig(userAgentConfig)
                .additionalHeaders(additionalHeaders)
                .globalHeader("Square-Version", squareVersion)
                .build();
        mobileAuthorization = new DefaultMobileAuthorizationApi(globalConfig);
        oAuth = new DefaultOAuthApi(globalConfig);
        v1Transactions = new DefaultV1TransactionsApi(globalConfig);
        applePay = new DefaultApplePayApi(globalConfig);
        bankAccounts = new DefaultBankAccountsApi(globalConfig);
        bookings = new DefaultBookingsApi(globalConfig);
        bookingCustomAttributes = new DefaultBookingCustomAttributesApi(globalConfig);
        cards = new DefaultCardsApi(globalConfig);
        cashDrawers = new DefaultCashDrawersApi(globalConfig);
        catalog = new DefaultCatalogApi(globalConfig);
        customers = new DefaultCustomersApi(globalConfig);
        customerCustomAttributes = new DefaultCustomerCustomAttributesApi(globalConfig);
        customerGroups = new DefaultCustomerGroupsApi(globalConfig);
        customerSegments = new DefaultCustomerSegmentsApi(globalConfig);
        devices = new DefaultDevicesApi(globalConfig);
        disputes = new DefaultDisputesApi(globalConfig);
        employees = new DefaultEmployeesApi(globalConfig);
        giftCards = new DefaultGiftCardsApi(globalConfig);
        giftCardActivities = new DefaultGiftCardActivitiesApi(globalConfig);
        inventory = new DefaultInventoryApi(globalConfig);
        invoices = new DefaultInvoicesApi(globalConfig);
        labor = new DefaultLaborApi(globalConfig);
        locations = new DefaultLocationsApi(globalConfig);
        locationCustomAttributes = new DefaultLocationCustomAttributesApi(globalConfig);
        checkout = new DefaultCheckoutApi(globalConfig);
        transactions = new DefaultTransactionsApi(globalConfig);
        loyalty = new DefaultLoyaltyApi(globalConfig);
        merchants = new DefaultMerchantsApi(globalConfig);
        merchantCustomAttributes = new DefaultMerchantCustomAttributesApi(globalConfig);
        orders = new DefaultOrdersApi(globalConfig);
        orderCustomAttributes = new DefaultOrderCustomAttributesApi(globalConfig);
        payments = new DefaultPaymentsApi(globalConfig);
        payouts = new DefaultPayoutsApi(globalConfig);
        refunds = new DefaultRefundsApi(globalConfig);
        sites = new DefaultSitesApi(globalConfig);
        snippets = new DefaultSnippetsApi(globalConfig);
        subscriptions = new DefaultSubscriptionsApi(globalConfig);
        team = new DefaultTeamApi(globalConfig);
        terminal = new DefaultTerminalApi(globalConfig);
        vendors = new DefaultVendorsApi(globalConfig);
        webhookSubscriptions = new DefaultWebhookSubscriptionsApi(globalConfig);
    }

    /**
     * Shutdown the underlying HttpClient instance.
     */
    public static void shutdown() {
        OkClient.shutdown();
    }

    /**
     * Get the instance of MobileAuthorizationApi.
     * @return mobileAuthorization
     */
    public MobileAuthorizationApi getMobileAuthorizationApi() {
        return mobileAuthorization;
    }

    /**
     * Get the instance of OAuthApi.
     * @return oAuth
     */
    public OAuthApi getOAuthApi() {
        return oAuth;
    }

    /**
     * Get the instance of V1TransactionsApi.
     * @return v1Transactions
     */
    public V1TransactionsApi getV1TransactionsApi() {
        return v1Transactions;
    }

    /**
     * Get the instance of ApplePayApi.
     * @return applePay
     */
    public ApplePayApi getApplePayApi() {
        return applePay;
    }

    /**
     * Get the instance of BankAccountsApi.
     * @return bankAccounts
     */
    public BankAccountsApi getBankAccountsApi() {
        return bankAccounts;
    }

    /**
     * Get the instance of BookingsApi.
     * @return bookings
     */
    public BookingsApi getBookingsApi() {
        return bookings;
    }

    /**
     * Get the instance of BookingCustomAttributesApi.
     * @return bookingCustomAttributes
     */
    public BookingCustomAttributesApi getBookingCustomAttributesApi() {
        return bookingCustomAttributes;
    }

    /**
     * Get the instance of CardsApi.
     * @return cards
     */
    public CardsApi getCardsApi() {
        return cards;
    }

    /**
     * Get the instance of CashDrawersApi.
     * @return cashDrawers
     */
    public CashDrawersApi getCashDrawersApi() {
        return cashDrawers;
    }

    /**
     * Get the instance of CatalogApi.
     * @return catalog
     */
    public CatalogApi getCatalogApi() {
        return catalog;
    }

    /**
     * Get the instance of CustomersApi.
     * @return customers
     */
    public CustomersApi getCustomersApi() {
        return customers;
    }

    /**
     * Get the instance of CustomerCustomAttributesApi.
     * @return customerCustomAttributes
     */
    public CustomerCustomAttributesApi getCustomerCustomAttributesApi() {
        return customerCustomAttributes;
    }

    /**
     * Get the instance of CustomerGroupsApi.
     * @return customerGroups
     */
    public CustomerGroupsApi getCustomerGroupsApi() {
        return customerGroups;
    }

    /**
     * Get the instance of CustomerSegmentsApi.
     * @return customerSegments
     */
    public CustomerSegmentsApi getCustomerSegmentsApi() {
        return customerSegments;
    }

    /**
     * Get the instance of DevicesApi.
     * @return devices
     */
    public DevicesApi getDevicesApi() {
        return devices;
    }

    /**
     * Get the instance of DisputesApi.
     * @return disputes
     */
    public DisputesApi getDisputesApi() {
        return disputes;
    }

    /**
     * Get the instance of EmployeesApi.
     * @return employees
     */
    public EmployeesApi getEmployeesApi() {
        return employees;
    }

    /**
     * Get the instance of GiftCardsApi.
     * @return giftCards
     */
    public GiftCardsApi getGiftCardsApi() {
        return giftCards;
    }

    /**
     * Get the instance of GiftCardActivitiesApi.
     * @return giftCardActivities
     */
    public GiftCardActivitiesApi getGiftCardActivitiesApi() {
        return giftCardActivities;
    }

    /**
     * Get the instance of InventoryApi.
     * @return inventory
     */
    public InventoryApi getInventoryApi() {
        return inventory;
    }

    /**
     * Get the instance of InvoicesApi.
     * @return invoices
     */
    public InvoicesApi getInvoicesApi() {
        return invoices;
    }

    /**
     * Get the instance of LaborApi.
     * @return labor
     */
    public LaborApi getLaborApi() {
        return labor;
    }

    /**
     * Get the instance of LocationsApi.
     * @return locations
     */
    public LocationsApi getLocationsApi() {
        return locations;
    }

    /**
     * Get the instance of LocationCustomAttributesApi.
     * @return locationCustomAttributes
     */
    public LocationCustomAttributesApi getLocationCustomAttributesApi() {
        return locationCustomAttributes;
    }

    /**
     * Get the instance of CheckoutApi.
     * @return checkout
     */
    public CheckoutApi getCheckoutApi() {
        return checkout;
    }

    /**
     * Get the instance of TransactionsApi.
     * @return transactions
     */
    public TransactionsApi getTransactionsApi() {
        return transactions;
    }

    /**
     * Get the instance of LoyaltyApi.
     * @return loyalty
     */
    public LoyaltyApi getLoyaltyApi() {
        return loyalty;
    }

    /**
     * Get the instance of MerchantsApi.
     * @return merchants
     */
    public MerchantsApi getMerchantsApi() {
        return merchants;
    }

    /**
     * Get the instance of MerchantCustomAttributesApi.
     * @return merchantCustomAttributes
     */
    public MerchantCustomAttributesApi getMerchantCustomAttributesApi() {
        return merchantCustomAttributes;
    }

    /**
     * Get the instance of OrdersApi.
     * @return orders
     */
    public OrdersApi getOrdersApi() {
        return orders;
    }

    /**
     * Get the instance of OrderCustomAttributesApi.
     * @return orderCustomAttributes
     */
    public OrderCustomAttributesApi getOrderCustomAttributesApi() {
        return orderCustomAttributes;
    }

    /**
     * Get the instance of PaymentsApi.
     * @return payments
     */
    public PaymentsApi getPaymentsApi() {
        return payments;
    }

    /**
     * Get the instance of PayoutsApi.
     * @return payouts
     */
    public PayoutsApi getPayoutsApi() {
        return payouts;
    }

    /**
     * Get the instance of RefundsApi.
     * @return refunds
     */
    public RefundsApi getRefundsApi() {
        return refunds;
    }

    /**
     * Get the instance of SitesApi.
     * @return sites
     */
    public SitesApi getSitesApi() {
        return sites;
    }

    /**
     * Get the instance of SnippetsApi.
     * @return snippets
     */
    public SnippetsApi getSnippetsApi() {
        return snippets;
    }

    /**
     * Get the instance of SubscriptionsApi.
     * @return subscriptions
     */
    public SubscriptionsApi getSubscriptionsApi() {
        return subscriptions;
    }

    /**
     * Get the instance of TeamApi.
     * @return team
     */
    public TeamApi getTeamApi() {
        return team;
    }

    /**
     * Get the instance of TerminalApi.
     * @return terminal
     */
    public TerminalApi getTerminalApi() {
        return terminal;
    }

    /**
     * Get the instance of VendorsApi.
     * @return vendors
     */
    public VendorsApi getVendorsApi() {
        return vendors;
    }

    /**
     * Get the instance of WebhookSubscriptionsApi.
     * @return webhookSubscriptions
     */
    public WebhookSubscriptionsApi getWebhookSubscriptionsApi() {
        return webhookSubscriptions;
    }

    /**
     * Current API environment.
     * @return environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Sets the base URL requests are made to. Defaults to `https://connect.squareup.com`
     * @return customUrl
     */
    public String getCustomUrl() {
        return customUrl;
    }

    /**
     * Square Connect API versions.
     * @return squareVersion
     */
    public String getSquareVersion() {
        return squareVersion;
    }

    /**
     * The HTTP Client instance to use for making HTTP requests.
     * @return httpClient
     */
    private HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Http Client Configuration instance.
     * @return httpClientConfig
     */
    public ReadonlyHttpClientConfiguration getHttpClientConfig() {
        return httpClientConfig;
    }

    /**
     * Additional headers to add to each API request.
     * @return a copy of additionalHeaders
     */
    public Headers getAdditionalHeaders() {
        return new Headers(additionalHeaders);
    }

    /**
     * Additional detail which can be appended with User-Agent header.
     * @return userAgentDetail
     */
    public String getUserAgentDetail() {
        return userAgentDetail;
    }

    /**
     * The credentials to use with BearerAuth.
     * @return bearerAuthCredentials
     */
    public BearerAuthCredentials getBearerAuthCredentials() {
        return bearerAuthManager;
    }

    /**
     * The auth credential model for BearerAuth.
     * @return the instance of BearerAuthModel
     */
    public BearerAuthModel getBearerAuthModel() {
        return bearerAuthModel;
    }

    /**
     * OAuth 2.0 Access Token.
     * @return accessToken
     */
    public String getAccessToken() {
        return getBearerAuthCredentials().getAccessToken();
    }
    /**
     * Current SDK Version.
     * @return sdkVersion
     */
    public String getSdkVersion() {
        return "38.1.0.20240320";
    }

    /**
     * The timeout to use for making HTTP requests.
     * @deprecated This method will be removed in a future version. Use
     *             {@link #getHttpClientConfig()} instead.
     *
     * @return timeout
     */
    @Deprecated
    public long timeout() {
        return httpClientConfig.getTimeout();
    }

    /**
     * Get base URI by current environment.
     * @param server Server for which to get the base URI
     * @return Processed base URI
     */
    public String getBaseUri(Server server) {
        Map<String, SimpleEntry<Object, Boolean>> parameters = new HashMap<>();
        parameters.put("custom_url",
                new SimpleEntry<Object, Boolean>(this.customUrl, false));
        StringBuilder baseUrl = new StringBuilder(environmentMapper(environment, server));
        ApiHelper.appendUrlWithTemplateParameters(baseUrl, parameters);
        return baseUrl.toString();
    }

    /**
     * Get base URI by current environment.
     * @return Processed base URI
     */
    public String getBaseUri() {
        return getBaseUri(Server.ENUM_DEFAULT);
    }


    /**
     * Get base URI by current environment.
     * 
     * @param server string for which to get the base URI
     * @return Processed base URI
     */
    public String getBaseUri(String server) {
        return getBaseUri(Server.fromString(server));
    }


    /**
     * Base URLs by environment and server aliases.
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
        if (environment.equals(Environment.CUSTOM)) {
            if (server.equals(Server.ENUM_DEFAULT)) {
                return "{custom_url}";
            }
        }
        return "https://connect.squareup.com";
    }

    /**
     * Converts this SquareClient into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SquareClient [" + "environment=" + environment + ", customUrl=" + customUrl
                + ", squareVersion=" + squareVersion + ", httpClientConfig=" + httpClientConfig
                + ", additionalHeaders=" + additionalHeaders + ", userAgentDetail="
                + userAgentDetail + ", authentications=" + authentications + "]";
    }

    /**
     * Builds a new {@link SquareClient.Builder} object.
     * Creates the instance with the state of the current client.
     * @return a new {@link SquareClient.Builder} object
     */
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.environment = getEnvironment();
        builder.customUrl = getCustomUrl();
        builder.squareVersion = getSquareVersion();
        builder.httpClient = getHttpClient();
        builder.additionalHeaders = getAdditionalHeaders();
        builder.userAgentDetail = getUserAgentDetail();
        builder.bearerAuthCredentials(getBearerAuthModel()
                .toBuilder().build());
        builder.authentications = authentications;
        builder.httpCallback = httpCallback;
        builder.httpClientConfig(configBldr -> configBldr =
                ((HttpClientConfiguration) httpClientConfig).newBuilder());
        return builder;
    }

    /**
     * Class to build instances of {@link SquareClient}.
     */
    public static class Builder {

        private Environment environment = Environment.PRODUCTION;
        private String customUrl = "https://connect.squareup.com";
        private String squareVersion = "2024-03-20";
        private HttpClient httpClient;
        private Headers additionalHeaders = new Headers();
        private String userAgentDetail = null;
        private BearerAuthModel bearerAuthModel = new BearerAuthModel.Builder("").build();
        private Map<String, Authentication> authentications = null;
        private HttpCallback httpCallback = null;
        private HttpClientConfiguration.Builder httpClientConfigBuilder =
                new HttpClientConfiguration.Builder();


        /**
         * Credentials setter for BearerAuth.
         * @param accessToken String value for accessToken.
         * @deprecated This builder method is deprecated.
         * Use {@link #bearerAuthCredentials(BearerAuthModel) bearerAuthCredentials} instead.
         * @return The current instance of builder.
         */
        @Deprecated
        public Builder accessToken(String accessToken) {
            bearerAuthModel = bearerAuthModel.toBuilder()
                .accessToken(accessToken)
                .build();
            return this;
        }

        /**
         * Credentials setter for BearerAuthCredentials.
         * @param bearerAuthModel The instance of BearerAuthModel.
         * @return The current instance of builder.
         */
        public Builder bearerAuthCredentials(BearerAuthModel bearerAuthModel) {
            this.bearerAuthModel = bearerAuthModel;
            return this;
        }

        /**
         * Current API environment.
         * @param environment The environment for client.
         * @return Builder
         */
        public Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }

        /**
         * Sets the base URL requests are made to. Defaults to `https://connect.squareup.com`
         * @param customUrl The customUrl for client.
         * @return Builder
         */
        public Builder customUrl(String customUrl) {
            this.customUrl = customUrl;
            return this;
        }

        /**
         * Square Connect API versions.
         * @param squareVersion The squareVersion for client.
         * @return Builder
         */
        public Builder squareVersion(String squareVersion) {
            if (squareVersion == null) {
                throw new NullPointerException("squareVersion cannot be null");
            }
            this.squareVersion = squareVersion;
            return this;
        }

        /**
         * Additional headers to add to each API request.
         * @param additionalHeaders The additionalHeaders for client.
         * @return Builder
         */
        public Builder additionalHeaders(Headers additionalHeaders) {
            if (additionalHeaders == null) {
                throw new NullPointerException("additionalHeaders cannot be null");
            }
            this.additionalHeaders = additionalHeaders;
            return this;
        }

        /**
         * Additional detail which can be appended with User-Agent header.
         * @param userAgentDetail The userAgentDetail for client.
         * @return Builder
         */
        public Builder userAgentDetail(String userAgentDetail) {
            if (userAgentDetail != null && userAgentDetail.length() > 128) {
                throw new IllegalArgumentException(
                        "The length of user-agent detail should not exceed 128 characters.");
            }
            this.userAgentDetail = userAgentDetail;
            return this;
        }

        /**
         * The timeout to use for making HTTP requests.
         * @deprecated This method will be removed in a future version. Use
         *             {@link #httpClientConfig(Consumer) httpClientConfig} instead.
         * @param timeout must be greater then 0.
         * @return Builder
         */
        @Deprecated
        public Builder timeout(long timeout) {
            this.httpClientConfigBuilder.timeout(timeout);
            return this;
        }

        /**
         * HttpCallback.
         * @param httpCallback Callback to be called before and after the HTTP call.
         * @return Builder
         */
        public Builder httpCallback(HttpCallback httpCallback) {
            this.httpCallback = httpCallback;
            return this;
        }

        /**
         * Setter for the Builder of httpClientConfiguration, takes in an operation to be performed
         * on the builder instance of HTTP client configuration.
         * 
         * @param action Consumer for the builder of httpClientConfiguration.
         * @return Builder
         */
        public Builder httpClientConfig(Consumer<HttpClientConfiguration.Builder> action) {
            action.accept(httpClientConfigBuilder);
            return this;
        }

        /**
         * Builds a new SquareClient object using the set fields.
         * @return SquareClient
         */
        public SquareClient build() {
            HttpClientConfiguration httpClientConfig = httpClientConfigBuilder.build();
            httpClient = new OkClient(httpClientConfig.getConfiguration(), compatibilityFactory);

            return new SquareClient(environment, customUrl, squareVersion, httpClient,
                    httpClientConfig, additionalHeaders, userAgentDetail, bearerAuthModel,
                    authentications, httpCallback);
        }
    }
}