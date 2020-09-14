package br.com.springContract.springcloudverifierconsumer.messaging;

import br.com.springContract.springcloudverifierconsumer.model.Convidado;
import br.com.springContract.springcloudverifierconsumer.service.ConvidadoService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConvidadoConsumer {

    private ConvidadoService convidadoService;

    public ConvidadoConsumer(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @KafkaListener(topics = "${cloudkarafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void processMessage(Convidado record) {
        System.out.println("Mensagem consumida do tópico "+ record.toString());
        convidadoService.getConvidadosInseridos().add(record);
    }

}