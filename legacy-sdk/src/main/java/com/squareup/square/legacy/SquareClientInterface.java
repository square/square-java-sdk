package com.squareup.square.legacy;

import com.squareup.square.legacy.api.ApplePayApi;
import com.squareup.square.legacy.api.BankAccountsApi;
import com.squareup.square.legacy.api.BookingCustomAttributesApi;
import com.squareup.square.legacy.api.BookingsApi;
import com.squareup.square.legacy.api.CardsApi;
import com.squareup.square.legacy.api.CashDrawersApi;
import com.squareup.square.legacy.api.CatalogApi;
import com.squareup.square.legacy.api.CheckoutApi;
import com.squareup.square.legacy.api.CustomerCustomAttributesApi;
import com.squareup.square.legacy.api.CustomerGroupsApi;
import com.squareup.square.legacy.api.CustomerSegmentsApi;
import com.squareup.square.legacy.api.CustomersApi;
import com.squareup.square.legacy.api.DevicesApi;
import com.squareup.square.legacy.api.DisputesApi;
import com.squareup.square.legacy.api.EmployeesApi;
import com.squareup.square.legacy.api.EventsApi;
import com.squareup.square.legacy.api.GiftCardActivitiesApi;
import com.squareup.square.legacy.api.GiftCardsApi;
import com.squareup.square.legacy.api.InventoryApi;
import com.squareup.square.legacy.api.InvoicesApi;
import com.squareup.square.legacy.api.LaborApi;
import com.squareup.square.legacy.api.LocationCustomAttributesApi;
import com.squareup.square.legacy.api.LocationsApi;
import com.squareup.square.legacy.api.LoyaltyApi;
import com.squareup.square.legacy.api.MerchantCustomAttributesApi;
import com.squareup.square.legacy.api.MerchantsApi;
import com.squareup.square.legacy.api.MobileAuthorizationApi;
import com.squareup.square.legacy.api.OAuthApi;
import com.squareup.square.legacy.api.OrderCustomAttributesApi;
import com.squareup.square.legacy.api.OrdersApi;
import com.squareup.square.legacy.api.PaymentsApi;
import com.squareup.square.legacy.api.PayoutsApi;
import com.squareup.square.legacy.api.RefundsApi;
import com.squareup.square.legacy.api.SitesApi;
import com.squareup.square.legacy.api.SnippetsApi;
import com.squareup.square.legacy.api.SubscriptionsApi;
import com.squareup.square.legacy.api.TeamApi;
import com.squareup.square.legacy.api.TerminalApi;
import com.squareup.square.legacy.api.TransactionsApi;
import com.squareup.square.legacy.api.V1TransactionsApi;
import com.squareup.square.legacy.api.VendorsApi;
import com.squareup.square.legacy.api.WebhookSubscriptionsApi;

/**
 * Gateway interface for the library.
 * This acts as a factory for Apis.
 * It holds the state of the SDK.
 */
public interface SquareClientInterface extends Configuration {

    /**
     * Provides access to MobileAuthorization controller.
     * @return Returns the MobileAuthorizationApi instance
     */
    MobileAuthorizationApi getMobileAuthorizationApi();

    /**
     * Provides access to OAuth controller.
     * @return Returns the OAuthApi instance
     */
    OAuthApi getOAuthApi();

    /**
     * Provides access to V1Transactions controller.
     * @return Returns the V1TransactionsApi instance
     */
    V1TransactionsApi getV1TransactionsApi();

    /**
     * Provides access to ApplePay controller.
     * @return Returns the ApplePayApi instance
     */
    ApplePayApi getApplePayApi();

    /**
     * Provides access to BankAccounts controller.
     * @return Returns the BankAccountsApi instance
     */
    BankAccountsApi getBankAccountsApi();

    /**
     * Provides access to Bookings controller.
     * @return Returns the BookingsApi instance
     */
    BookingsApi getBookingsApi();

    /**
     * Provides access to BookingCustomAttributes controller.
     * @return Returns the BookingCustomAttributesApi instance
     */
    BookingCustomAttributesApi getBookingCustomAttributesApi();

    /**
     * Provides access to Cards controller.
     * @return Returns the CardsApi instance
     */
    CardsApi getCardsApi();

    /**
     * Provides access to CashDrawers controller.
     * @return Returns the CashDrawersApi instance
     */
    CashDrawersApi getCashDrawersApi();

    /**
     * Provides access to Catalog controller.
     * @return Returns the CatalogApi instance
     */
    CatalogApi getCatalogApi();

    /**
     * Provides access to Customers controller.
     * @return Returns the CustomersApi instance
     */
    CustomersApi getCustomersApi();

    /**
     * Provides access to CustomerCustomAttributes controller.
     * @return Returns the CustomerCustomAttributesApi instance
     */
    CustomerCustomAttributesApi getCustomerCustomAttributesApi();

    /**
     * Provides access to CustomerGroups controller.
     * @return Returns the CustomerGroupsApi instance
     */
    CustomerGroupsApi getCustomerGroupsApi();

    /**
     * Provides access to CustomerSegments controller.
     * @return Returns the CustomerSegmentsApi instance
     */
    CustomerSegmentsApi getCustomerSegmentsApi();

    /**
     * Provides access to Devices controller.
     * @return Returns the DevicesApi instance
     */
    DevicesApi getDevicesApi();

    /**
     * Provides access to Disputes controller.
     * @return Returns the DisputesApi instance
     */
    DisputesApi getDisputesApi();

    /**
     * Provides access to Employees controller.
     * @return Returns the EmployeesApi instance
     */
    EmployeesApi getEmployeesApi();

    /**
     * Provides access to Events controller.
     * @return Returns the EventsApi instance
     */
    EventsApi getEventsApi();

    /**
     * Provides access to GiftCards controller.
     * @return Returns the GiftCardsApi instance
     */
    GiftCardsApi getGiftCardsApi();

    /**
     * Provides access to GiftCardActivities controller.
     * @return Returns the GiftCardActivitiesApi instance
     */
    GiftCardActivitiesApi getGiftCardActivitiesApi();

    /**
     * Provides access to Inventory controller.
     * @return Returns the InventoryApi instance
     */
    InventoryApi getInventoryApi();

    /**
     * Provides access to Invoices controller.
     * @return Returns the InvoicesApi instance
     */
    InvoicesApi getInvoicesApi();

    /**
     * Provides access to Labor controller.
     * @return Returns the LaborApi instance
     */
    LaborApi getLaborApi();

    /**
     * Provides access to Locations controller.
     * @return Returns the LocationsApi instance
     */
    LocationsApi getLocationsApi();

    /**
     * Provides access to LocationCustomAttributes controller.
     * @return Returns the LocationCustomAttributesApi instance
     */
    LocationCustomAttributesApi getLocationCustomAttributesApi();

    /**
     * Provides access to Checkout controller.
     * @return Returns the CheckoutApi instance
     */
    CheckoutApi getCheckoutApi();

    /**
     * Provides access to Transactions controller.
     * @return Returns the TransactionsApi instance
     */
    TransactionsApi getTransactionsApi();

    /**
     * Provides access to Loyalty controller.
     * @return Returns the LoyaltyApi instance
     */
    LoyaltyApi getLoyaltyApi();

    /**
     * Provides access to Merchants controller.
     * @return Returns the MerchantsApi instance
     */
    MerchantsApi getMerchantsApi();

    /**
     * Provides access to MerchantCustomAttributes controller.
     * @return Returns the MerchantCustomAttributesApi instance
     */
    MerchantCustomAttributesApi getMerchantCustomAttributesApi();

    /**
     * Provides access to Orders controller.
     * @return Returns the OrdersApi instance
     */
    OrdersApi getOrdersApi();

    /**
     * Provides access to OrderCustomAttributes controller.
     * @return Returns the OrderCustomAttributesApi instance
     */
    OrderCustomAttributesApi getOrderCustomAttributesApi();

    /**
     * Provides access to Payments controller.
     * @return Returns the PaymentsApi instance
     */
    PaymentsApi getPaymentsApi();

    /**
     * Provides access to Payouts controller.
     * @return Returns the PayoutsApi instance
     */
    PayoutsApi getPayoutsApi();

    /**
     * Provides access to Refunds controller.
     * @return Returns the RefundsApi instance
     */
    RefundsApi getRefundsApi();

    /**
     * Provides access to Sites controller.
     * @return Returns the SitesApi instance
     */
    SitesApi getSitesApi();

    /**
     * Provides access to Snippets controller.
     * @return Returns the SnippetsApi instance
     */
    SnippetsApi getSnippetsApi();

    /**
     * Provides access to Subscriptions controller.
     * @return Returns the SubscriptionsApi instance
     */
    SubscriptionsApi getSubscriptionsApi();

    /**
     * Provides access to Team controller.
     * @return Returns the TeamApi instance
     */
    TeamApi getTeamApi();

    /**
     * Provides access to Terminal controller.
     * @return Returns the TerminalApi instance
     */
    TerminalApi getTerminalApi();

    /**
     * Provides access to Vendors controller.
     * @return Returns the VendorsApi instance
     */
    VendorsApi getVendorsApi();

    /**
     * Provides access to WebhookSubscriptions controller.
     * @return Returns the WebhookSubscriptionsApi instance
     */
    WebhookSubscriptionsApi getWebhookSubscriptionsApi();

    /**
     * Current SDK Version.
     * @return sdkVersion
     */
    public String getSdkVersion();
}
