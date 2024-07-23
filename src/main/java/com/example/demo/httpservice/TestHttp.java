package com.example.demo.httpservice;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.file.Paths;

public class TestHttp {

    public static void main(String[] args) throws URISyntaxException {

        // 1 way to create
        HttpRequest.newBuilder(new URI("https://postman-echo.com/get"));

        // 2 way to create
        HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"));
    }

    /**
     * We can define the HTTP method that our request will use by calling one of the methods from Builder:
     *
     * @throws URISyntaxException
     */
    public void getRequest() throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .GET()
                .build();
    }

    /**
     * The API fully leverages the HTTP/2 protocol and uses it by default,
     * but we can define which version of the protocol we want to use
     *
     * @throws URISyntaxException
     */
    public void getRequestVersioned() throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
    }

    /**
     * n case we want to add additional headers to our request, we can use the provided builder methods
     *
     * @throws URISyntaxException
     */
    public void getRequestWithHeaders() throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .headers("key1", "value1", "key2", "value2")
                .GET()
                .build();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .header("key1", "value1")
                .header("key2", "value2")
                .GET()
                .build();
    }

    /**
     * We can add a body to a request by using the request builder methods: POST(BodyPublisher body),
     * PUT(BodyPublisher body) and DELETE(
     *
     * @throws URISyntaxException
     */
    public void postRequest() throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
    }

    /**
     * For example, if we want to pass a simple String as a body, we can use StringBodyPublishers.
     *
     * @throws URISyntaxException
     */
    public void pushBody() throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
                .build();
    }

    /**
     * the InputStream has to be passed as a Supplier (to make its creation lazy),
     * so it’s a little bit different than StringBodyPublishers.
     *
     * @throws URISyntaxException
     */
    public void sendStramBody() throws URISyntaxException {
        byte[] sampleData = "Sample request body".getBytes();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers
                        .ofInputStream(() -> new ByteArrayInputStream(sampleData)))
                .build();
    }

    public void fileProcessor() throws URISyntaxException, FileNotFoundException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofFile(
                        Paths.get("src/test/resources/sample.txt")))
                .build();
    }

}
