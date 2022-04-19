
package com.squareup.square;

import com.squareup.square.api.ApplePayApi;
import com.squareup.square.api.BankAccountsApi;
import com.squareup.square.api.BookingsApi;
import com.squareup.square.api.CardsApi;
import com.squareup.square.api.CashDrawersApi;
import com.squareup.square.api.CatalogApi;
import com.squareup.square.api.CheckoutApi;
import com.squareup.square.api.CustomerGroupsApi;
import com.squareup.square.api.CustomerSegmentsApi;
import com.squareup.square.api.CustomersApi;
import com.squareup.square.api.DevicesApi;
import com.squareup.square.api.DisputesApi;
import com.squareup.square.api.EmployeesApi;
import com.squareup.square.api.GiftCardActivitiesApi;
import com.squareup.square.api.GiftCardsApi;
import com.squareup.square.api.InventoryApi;
import com.squareup.square.api.InvoicesApi;
import com.squareup.square.api.LaborApi;
import com.squareup.square.api.LocationsApi;
import com.squareup.square.api.LoyaltyApi;
import com.squareup.square.api.MerchantsApi;
import com.squareup.square.api.MobileAuthorizationApi;
import com.squareup.square.api.OAuthApi;
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
     * Provides access to Orders controller.
     * @return Returns the OrdersApi instance
     */
    OrdersApi getOrdersApi();

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
     * Current SDK Version.
     * @return sdkVersion
     */
    public String getSdkVersion();

}