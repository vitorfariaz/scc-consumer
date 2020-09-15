package br.com.springContract.springcloudverifierconsumer;

import br.com.springContract.springcloudverifierconsumer.model.Convidado;
import br.com.springContract.springcloudverifierconsumer.service.ConvidadoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@AutoConfigureStubRunner(ids = {"br.com.springContract:spring-cloud-verifier-provider"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@ActiveProfiles("contract")
@EmbeddedKafka(topics = "${cloudkarafka.topic}")
class ConvidadoServiceContractTest {

    @Autowired
    private ConvidadoService convidadoService;

    @Test
    void deveValidarContratoRecursoTodosConvidados()  {
        List<Convidado> convidados = this.convidadoService.buscarTodosConvidados();
        assertEquals(2, convidados.size());
    }

}
