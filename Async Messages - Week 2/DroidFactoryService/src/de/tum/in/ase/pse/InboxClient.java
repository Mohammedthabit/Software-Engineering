package de.tum.in.ase.pse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

public final class InboxClient {

    private RestTemplate rest;
    private static final String BASE_URL = "http://localhost:8080/messages/";
    private static final String R_2 = "r2";
    private static final String THREE_PO = "3po";

    private final List<String> messages = new ArrayList<>();


    public InboxClient() {
        this.rest = new RestTemplate();
    }

    // TODO 1: create an http request using the RestTemplate and store the body of the response in the messages attribute
    public void droidReadyR2(String droid) {
        messages.add(createHttpEntity(droid).getBody());
    }
    public void droidReady3PO(String droid) {
        messages.add(createHttpEntity(droid).getBody());
    }

    public void printMessages() {
        this.messages.forEach(System.out::println);
    }
    public List<String> getMessages() {
        return messages;
    }
    private HttpEntity<String> createHttpEntity(String droid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(droid, headers);
    }
}
