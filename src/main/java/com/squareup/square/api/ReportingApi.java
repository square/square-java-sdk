package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ListAdditionalRecipientReceivableRefundsResponse;
import com.squareup.square.models.ListAdditionalRecipientReceivablesResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface ReportingApi {
    /**
     * Returns a list of refunded transactions (across all possible originating locations) relating to monies
     * credited to the provided location ID by another Square account using the `additional_recipients` field in a transaction.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list AdditionalRecipientReceivableRefunds for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListAdditionalRecipientReceivableRefundsResponse response from the API call
     */
    @Deprecated    ListAdditionalRecipientReceivableRefundsResponse listAdditionalRecipientReceivableRefunds(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a list of refunded transactions (across all possible originating locations) relating to monies
     * credited to the provided location ID by another Square account using the `additional_recipients` field in a transaction.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list AdditionalRecipientReceivableRefunds for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListAdditionalRecipientReceivableRefundsResponse response from the API call 
     */
    @Deprecated
    CompletableFuture<ListAdditionalRecipientReceivableRefundsResponse> listAdditionalRecipientReceivableRefundsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor);

    /**
     * Returns a list of receivables (across all possible sending locations) representing monies credited
     * to the provided location ID by another Square account using the `additional_recipients` field in a transaction.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list AdditionalRecipientReceivables for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListAdditionalRecipientReceivablesResponse response from the API call
     */
    @Deprecated    ListAdditionalRecipientReceivablesResponse listAdditionalRecipientReceivables(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a list of receivables (across all possible sending locations) representing monies credited
     * to the provided location ID by another Square account using the `additional_recipients` field in a transaction.
     * Max results per [page](#paginatingresults): 50
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list AdditionalRecipientReceivables for.
     * @param    beginTime    Optional parameter: The beginning of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time minus one year.
     * @param    endTime    Optional parameter: The end of the requested reporting period, in RFC 3339 format.  See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.  Default value: The current time.
     * @param    sortOrder    Optional parameter: The order in which results are listed in the response (`ASC` for oldest first, `DESC` for newest first).  Default value: `DESC`
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @return    Returns the ListAdditionalRecipientReceivablesResponse response from the API call 
     */
    @Deprecated
    CompletableFuture<ListAdditionalRecipientReceivablesResponse> listAdditionalRecipientReceivablesAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor);

}
