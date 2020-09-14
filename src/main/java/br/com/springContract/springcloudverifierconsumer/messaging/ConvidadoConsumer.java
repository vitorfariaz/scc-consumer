package br.com.springContract.springcloudverifierconsumer.messaging;

import br.com.springContract.springcloudverifierconsumer.model.Convidado;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvidadoConsumer {

    private List<Convidado> convidadosInseridos;

    @KafkaListener(topics = "${cloudkarafka.topic}")
    public void processMessage(Object record,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) List<java.lang.String> topics,
                               @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        System.out.printf("Mensagem consumida do tópico %s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), record);
//        convidadosInseridos.add(record);
    }

    public List<Convidado> getConvidadosInseridos() {
        return convidadosInseridos;
    }
}