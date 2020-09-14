package br.com.springContract.springcloudverifierconsumer.messaging;

import br.com.springContract.springcloudverifierconsumer.model.Convidado;
import br.com.springContract.springcloudverifierconsumer.service.ConvidadoService;

public class ConvidadoConsumerStream {

    private ConvidadoService convidadoService;

//    @StreamListener
    public void processMessage(Convidado record) {
        System.out.println("Mensagem consumida do tópico "+ record.toString());
        convidadoService.getConvidadosInseridos().add(record);
    }
}
