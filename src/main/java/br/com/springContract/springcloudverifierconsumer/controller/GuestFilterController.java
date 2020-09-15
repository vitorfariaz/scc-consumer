package br.com.springContract.springcloudverifierconsumer.controller;

import br.com.springContract.springcloudverifierconsumer.model.Guest;
import br.com.springContract.springcloudverifierconsumer.service.GuestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GuestFilterController {

    private final GuestService service;

    public GuestFilterController(GuestService service) {
        this.service = service;
    }

    @GetMapping("/guests")
    public List<Guest> filterGuests(@RequestParam int age){
    return service
            .findAllGuests()
            .stream()
            .filter(conv -> conv.getAge() == age)
            .collect(Collectors.toList());
    }

}
