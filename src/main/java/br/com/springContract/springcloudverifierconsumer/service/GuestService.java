package br.com.springContract.springcloudverifierconsumer.service;

import br.com.springContract.springcloudverifierconsumer.model.Guest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {

    private final RestTemplate restTemplate;
    private final String guestListUrlApi;
    private final String allGuestsPathResource = "/guests";
    private List<Guest> insertedGuests = new ArrayList<>();

    public GuestService(RestTemplate restTemplate, @Value("${api.guests.url}") String guestListUrlApi) {
        this.restTemplate = restTemplate;
        this.guestListUrlApi = guestListUrlApi;
    }

    public List<Guest> findAllGuests(){
        String url = guestListUrlApi + allGuestsPathResource;
        return restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Guest>>(){})
                .getBody();
    }

    public List<Guest> getInsertedGuests() {
        return insertedGuests;
    }
}