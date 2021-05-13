
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.DeleteSnippetResponse;
import com.squareup.square.models.RetrieveSnippetResponse;
import com.squareup.square.models.UpsertSnippetRequest;
import com.squareup.square.models.UpsertSnippetResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface SnippetsApi {
    /**
     * Removes your snippet from a Square Online site. You can call [ListSites]($e/Sites/ListSites)
     * to get the IDs of the sites that belong to a seller. __Note:__ Square Online APIs are
     * publicly available as part of an early access program. For more information, see [Early
     * access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the DeleteSnippetResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteSnippetResponse deleteSnippet(
            final String siteId) throws ApiException, IOException;

    /**
     * Removes your snippet from a Square Online site. You can call [ListSites]($e/Sites/ListSites)
     * to get the IDs of the sites that belong to a seller. __Note:__ Square Online APIs are
     * publicly available as part of an early access program. For more information, see [Early
     * access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the DeleteSnippetResponse response from the API call
     */
    CompletableFuture<DeleteSnippetResponse> deleteSnippetAsync(
            final String siteId);

    /**
     * Retrieves your snippet from a Square Online site. A site can contain snippets from multiple
     * snippet applications, but you can retrieve only the snippet that was added by your
     * application. You can call [ListSites]($e/Sites/ListSites) to get the IDs of the sites that
     * belong to a seller. __Note:__ Square Online APIs are publicly available as part of an early
     * access program. For more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the RetrieveSnippetResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveSnippetResponse retrieveSnippet(
            final String siteId) throws ApiException, IOException;

    /**
     * Retrieves your snippet from a Square Online site. A site can contain snippets from multiple
     * snippet applications, but you can retrieve only the snippet that was added by your
     * application. You can call [ListSites]($e/Sites/ListSites) to get the IDs of the sites that
     * belong to a seller. __Note:__ Square Online APIs are publicly available as part of an early
     * access program. For more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the RetrieveSnippetResponse response from the API call
     */
    CompletableFuture<RetrieveSnippetResponse> retrieveSnippetAsync(
            final String siteId);

    /**
     * Adds a snippet to a Square Online site or updates the existing snippet on the site. The
     * snippet code is appended to the end of the `head` element on every page of the site, except
     * checkout pages. A snippet application can add one snippet to a given site. You can call
     * [ListSites]($e/Sites/ListSites) to get the IDs of the sites that belong to a seller.
     * __Note:__ Square Online APIs are publicly available as part of an early access program. For
     * more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site where you want to add or update the
     *         snippet.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertSnippetResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpsertSnippetResponse upsertSnippet(
            final String siteId,
            final UpsertSnippetRequest body) throws ApiException, IOException;

    /**
     * Adds a snippet to a Square Online site or updates the existing snippet on the site. The
     * snippet code is appended to the end of the `head` element on every page of the site, except
     * checkout pages. A snippet application can add one snippet to a given site. You can call
     * [ListSites]($e/Sites/ListSites) to get the IDs of the sites that belong to a seller.
     * __Note:__ Square Online APIs are publicly available as part of an early access program. For
     * more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site where you want to add or update the
     *         snippet.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertSnippetResponse response from the API call
     */
    CompletableFuture<UpsertSnippetResponse> upsertSnippetAsync(
            final String siteId,
            final UpsertSnippetRequest body);

}