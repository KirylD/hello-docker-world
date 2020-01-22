package by.samsolutions.controller;

import by.samsolutions.entity.HttpRequest;
import by.samsolutions.repository.HttpRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@RestController
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final HttpRequestRepository httpRequestRepository;

    public MainController(HttpRequestRepository httpRequestRepository) {
        this.httpRequestRepository = httpRequestRepository;
    }

    @GetMapping("")
    public String helloWorld() throws UnknownHostException {
        logger.info("helloWorld requested.");
        return "Hello from " + InetAddress.getLocalHost().getHostName();
    }

    // get http method to simplify testing
    @GetMapping(path = {"/request"})
    public HttpRequest logRequest() {
        Date requestDate = new Date(System.currentTimeMillis());
        logger.info("Request has been made at {}.", requestDate);

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setRequestDate(requestDate);

        HttpRequest savedHttpRequest = httpRequestRepository.save(httpRequest);
        logger.info("Saved entity is {}.", savedHttpRequest);

        return savedHttpRequest;
    }

    @GetMapping(path = "/all")
    public Iterable<HttpRequest> getAllHttpRequests() {
        Iterable<HttpRequest> all = httpRequestRepository.findAll();
        logger.info("Retrieved all 'HttpRequest {}.", all);
        return all;
    }

}
