package com.example.demo.httpservice;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class RESTService {

    /**
     *
     * @throws URISyntaxException
     */
    public void get() throws URISyntaxException, IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .headers("key1", "value1", "key2", "value2")
                .GET()
                .build();

        // Java 8
        //HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());

        // Java 11+
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * In our example, we used the default system proxy.
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public void getWithProxy() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .headers("key1", "value1", "key2", "value2")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .proxy(ProxySelector.getDefault())
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

    }

    /**
     * An Authenticator is an object that negotiates credentials (HTTP authentication) for a connection.
     * It provides different authentication schemes (such as basic or digest authentication).
     * In most cases, authentication requires username and password to connect to a server.
     * We can use PasswordAuthentication class, which is just a holder of these values:
     * @throws URISyntaxException
     */
    public void autenticate() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .headers("key1", "value1", "key2", "value2")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "username",
                                "password".toCharArray());
                    }
                }).build()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void sendSyncAsync() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .headers("key1", "value1", "key2", "value2")
                .GET()
                .build();

        /**
         * This call returns an HttpResponse object, and we’re sure that the next instruction from our application flow will be run only when the response is already here.
         *
         * However, it has a lot of drawbacks especially when we are processing large amounts of data.
         */
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        /**
         * So, now we can use sendAsync(...) method — which returns CompletableFeature<HttpResponse> — to process a request asynchronously:
         */
        CompletableFuture<HttpResponse<String>> response2 = HttpClient.newBuilder()
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString());


        /**
         * The new API can also deal with multiple responses, and stream the request and response bodies:
         */
        List<URI> targets = Arrays.asList(
                new URI("https://postman-echo.com/get?foo1=bar1"),
                new URI("https://postman-echo.com/get?foo2=bar2"));
        HttpClient client = HttpClient.newHttpClient();
        List<CompletableFuture<String>> futures = targets.stream()
                .map(target -> client
                        .sendAsync(
                                HttpRequest.newBuilder(target).GET().build(),
                                HttpResponse.BodyHandlers.ofString())
                        .thenApply(resp -> resp.body()))
                .toList();
    }

    /**
     * We can also define an Executor that provides threads to be used by asynchronous calls.
     *
     * This way we can, for example, limit the number of threads used for processing requests:
     */
    public void executorAsync() throws URISyntaxException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .headers("key1", "value1", "key2", "value2")
                .GET()
                .build();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<HttpResponse<String>> response1 = HttpClient.newBuilder()
                .executor(executorService)
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString());

        CompletableFuture<HttpResponse<String>> response2 = HttpClient.newBuilder()
                .executor(executorService)
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * With new API and builder, it’s straightforward to set a CookieHandler for our connection. We can use builder method cookieHandler(CookieHandler cookieHandler) to define client-specific CookieHandler.
     */
    public void cookieHandler() {

        HttpClient client = HttpClient.newHttpClient();

        HttpClient.newBuilder()
                .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_NONE))
                .build();

        CookieStore cookieStore = ((CookieManager) client.cookieHandler().get()).getCookieStore();
    }

    /**
     * We can obtain headers from the response by calling method headers() on a response object
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public void responseHeaders() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .headers("key1", "value1", "key2", "value2")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        HttpHeaders responseHeaders = response.headers();
    }

}
