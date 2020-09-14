package br.com.springContract.springcloudverifierconsumer.messaging;

import br.com.springContract.springcloudverifierconsumer.model.Convidado;
import br.com.springContract.springcloudverifierconsumer.service.ConvidadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConvidadoConsumer {

    private ConvidadoService convidadoService;
    private ObjectMapper objectMapper;

    public ConvidadoConsumer(ConvidadoService convidadoService, ObjectMapper objectMapper) {
        this.convidadoService = convidadoService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${cloudkarafka.topic}", groupId = "test2222")
    public void processMessage(Convidado convidado) {
        System.out.println("Mensagem consumida do tópico " + convidado);
        convidadoService.getConvidadosInseridos().add(convidado);
    }

}