
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ListEmployeesResponse;
import com.squareup.square.models.RetrieveEmployeeResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface EmployeesApi {
    /**
     * ListEmployees.
     * @deprecated
     * 
     * @param  locationId  Optional parameter: Example:
     * @param  status  Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param  limit  Optional parameter: The number of employees to be returned on each page.
     * @param  cursor  Optional parameter: The token required to retrieve the specified page of
     *         results.
     * @return    Returns the ListEmployeesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    ListEmployeesResponse listEmployees(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) throws ApiException, IOException;

    /**
     * ListEmployees.
     * @deprecated
     * 
     * @param  locationId  Optional parameter: Example:
     * @param  status  Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param  limit  Optional parameter: The number of employees to be returned on each page.
     * @param  cursor  Optional parameter: The token required to retrieve the specified page of
     *         results.
     * @return    Returns the ListEmployeesResponse response from the API call
     */
    @Deprecated
    CompletableFuture<ListEmployeesResponse> listEmployeesAsync(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor);

    /**
     * RetrieveEmployee.
     * @deprecated
     * 
     * @param  id  Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    RetrieveEmployeeResponse retrieveEmployee(
            final String id) throws ApiException, IOException;

    /**
     * RetrieveEmployee.
     * @deprecated
     * 
     * @param  id  Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     */
    @Deprecated
    CompletableFuture<RetrieveEmployeeResponse> retrieveEmployeeAsync(
            final String id);

}