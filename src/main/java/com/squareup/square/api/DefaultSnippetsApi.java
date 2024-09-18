
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.DeleteSnippetResponse;
import com.squareup.square.models.RetrieveSnippetResponse;
import com.squareup.square.models.UpsertSnippetRequest;
import com.squareup.square.models.UpsertSnippetResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultSnippetsApi extends BaseApi implements SnippetsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultSnippetsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
    public DeleteSnippetResponse deleteSnippet(
            final String siteId) throws ApiException, IOException {
        return prepareDeleteSnippetRequest(siteId).execute();
    }

    /**
     * Removes your snippet from a Square Online site. You can call [ListSites]($e/Sites/ListSites)
     * to get the IDs of the sites that belong to a seller. __Note:__ Square Online APIs are
     * publicly available as part of an early access program. For more information, see [Early
     * access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the DeleteSnippetResponse response from the API call
     */
    public CompletableFuture<DeleteSnippetResponse> deleteSnippetAsync(
            final String siteId) {
        try { 
            return prepareDeleteSnippetRequest(siteId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteSnippet.
     */
    private ApiCall<DeleteSnippetResponse, ApiException> prepareDeleteSnippetRequest(
            final String siteId) throws IOException {
        return new ApiCall.Builder<DeleteSnippetResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/sites/{site_id}/snippet")
                        .templateParam(param -> param.key("site_id").value(siteId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteSnippetResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public RetrieveSnippetResponse retrieveSnippet(
            final String siteId) throws ApiException, IOException {
        return prepareRetrieveSnippetRequest(siteId).execute();
    }

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
    public CompletableFuture<RetrieveSnippetResponse> retrieveSnippetAsync(
            final String siteId) {
        try { 
            return prepareRetrieveSnippetRequest(siteId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveSnippet.
     */
    private ApiCall<RetrieveSnippetResponse, ApiException> prepareRetrieveSnippetRequest(
            final String siteId) throws IOException {
        return new ApiCall.Builder<RetrieveSnippetResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/sites/{site_id}/snippet")
                        .templateParam(param -> param.key("site_id").value(siteId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveSnippetResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpsertSnippetResponse upsertSnippet(
            final String siteId,
            final UpsertSnippetRequest body) throws ApiException, IOException {
        return prepareUpsertSnippetRequest(siteId, body).execute();
    }

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
    public CompletableFuture<UpsertSnippetResponse> upsertSnippetAsync(
            final String siteId,
            final UpsertSnippetRequest body) {
        try { 
            return prepareUpsertSnippetRequest(siteId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for upsertSnippet.
     */
    private ApiCall<UpsertSnippetResponse, ApiException> prepareUpsertSnippetRequest(
            final String siteId,
            final UpsertSnippetRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpsertSnippetResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/sites/{site_id}/snippet")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("site_id").value(siteId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpsertSnippetResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}