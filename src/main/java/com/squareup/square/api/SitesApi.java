
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ListSitesResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface SitesApi {
    /**
     * Lists the Square Online sites that belong to a seller. __Note:__ Square Online APIs are
     * publicly available as part of an early access program. For more information, see [Early
     * access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @return    Returns the ListSitesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListSitesResponse listSites() throws ApiException, IOException;

    /**
     * Lists the Square Online sites that belong to a seller. __Note:__ Square Online APIs are
     * publicly available as part of an early access program. For more information, see [Early
     * access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @return    Returns the ListSitesResponse response from the API call
     */
    CompletableFuture<ListSitesResponse> listSitesAsync();

}