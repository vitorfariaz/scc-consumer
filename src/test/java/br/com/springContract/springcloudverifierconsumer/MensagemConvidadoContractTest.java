package br.com.springContract.springcloudverifierconsumer;

import br.com.springContract.springcloudverifierconsumer.service.ConvidadoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SpringCloudVerifierConsumerApplication.class)
@AutoConfigureStubRunner(ids = "br.com.springContract:spring-cloud-verifier-provider",
                         stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@ActiveProfiles("contract")
@EmbeddedKafka(topics = "${cloudkarafka.topic}")
class MensagemConvidadoContractTest {

    @Autowired
    private ConvidadoService convidadoService;

    @Autowired
    private StubTrigger stubTrigger;

    @Test
    void deveReceberMensagem() throws InterruptedException {
        stubTrigger.trigger("publicacao_kafka");

        Thread.sleep(15000);
        assertEquals(1, convidadoService.getConvidadosInseridos().size());
    }

}