package br.com.springContract.springcloudverifierconsumer;

import br.com.springContract.springcloudverifierconsumer.service.ConvidadoService;
import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.kafka.test.context.EmbeddedKafka;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureStubRunner(ids = "br.com.springContract:spring-cloud-verifier-provider",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@EmbeddedKafka(topics = "${cloudkarafka.topic}", ports = 9305, partitions = 1)
class MensagemConvidadoContractTest {

    @Autowired
    private ConvidadoService convidadoService;

    @Autowired
    private StubTrigger stubTrigger;

    @Test
    void deveReceberMensagem() throws InterruptedException {
        stubTrigger.trigger("publicacao_kafka");

        Awaitility.await().atMost(Duration.FIVE_SECONDS).untilAsserted(() ->
                assertEquals(1, convidadoService.getConvidadosInseridos().size())
        );
    }

}