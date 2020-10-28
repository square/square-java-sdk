
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.V1Merchant;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface V1LocationsApi {
    /**
     * Get the general information for a business.
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    V1Merchant retrieveBusiness() throws ApiException, IOException;

    /**
     * Get the general information for a business.
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call
     */
    @Deprecated
    CompletableFuture<V1Merchant> retrieveBusinessAsync();

    /**
     * Provides details for all business locations associated with a Square account, including the
     * Square-assigned object ID for the location.
     * @deprecated
     * 
     * @return    Returns the List of V1Merchant response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    List<V1Merchant> listLocations() throws ApiException, IOException;

    /**
     * Provides details for all business locations associated with a Square account, including the
     * Square-assigned object ID for the location.
     * @deprecated
     * 
     * @return    Returns the List of V1Merchant response from the API call
     */
    @Deprecated
    CompletableFuture<List<V1Merchant>> listLocationsAsync();

}