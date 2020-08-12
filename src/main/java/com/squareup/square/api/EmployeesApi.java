package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ListEmployeesResponse;
import com.squareup.square.models.RetrieveEmployeeResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface EmployeesApi {
    /**
     * ListEmployees
     * @param    locationId    Optional parameter: Filter employees returned to only those that are associated with the specified location.
     * @param    status    Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param    limit    Optional parameter: The number of employees to be returned on each page.
     * @param    cursor    Optional parameter: The token required to retrieve the specified page of results.
     * @return    Returns the ListEmployeesResponse response from the API call
     */
    ListEmployeesResponse listEmployees(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) throws ApiException, IOException;

    /**
     * ListEmployees
     * @param    locationId    Optional parameter: Filter employees returned to only those that are associated with the specified location.
     * @param    status    Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param    limit    Optional parameter: The number of employees to be returned on each page.
     * @param    cursor    Optional parameter: The token required to retrieve the specified page of results.
     * @return    Returns the ListEmployeesResponse response from the API call 
     */
    CompletableFuture<ListEmployeesResponse> listEmployeesAsync(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor);

    /**
     * RetrieveEmployee
     * @param    id    Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     */
    RetrieveEmployeeResponse retrieveEmployee(
            final String id) throws ApiException, IOException;

    /**
     * RetrieveEmployee
     * @param    id    Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call 
     */
    CompletableFuture<RetrieveEmployeeResponse> retrieveEmployeeAsync(
            final String id);

}
