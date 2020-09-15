package br.com.springContract.springcloudverifierconsumer.messaging;

import br.com.springContract.springcloudverifierconsumer.model.Guest;
import br.com.springContract.springcloudverifierconsumer.service.GuestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GuestConsumer {

    private GuestService guestService;
    private ObjectMapper objectMapper;

    public GuestConsumer(GuestService guestService, ObjectMapper objectMapper) {
        this.guestService = guestService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${cloudkarafka.topic}", groupId = "${cloudkarafka.group-id}")
    public void processMessage(Guest guest) {
        System.out.println("Mensagem consumida do tópico " + guest);
        guestService.getInsertedGuests().add(guest);
    }

}