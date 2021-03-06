package br.com.springContract.springcloudverifierconsumer;

import br.com.springContract.springcloudverifierconsumer.service.GuestService;
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
@EmbeddedKafka(topics = "${cloudkarafka.topic}")
class GuestMessagingContractTest {

    @Autowired
    private GuestService guestService;

    @Autowired
    private StubTrigger stubTrigger;

    @Test
    void should_receive_message() throws InterruptedException {
        stubTrigger.trigger("publish_kafka");

        Awaitility.await().atMost(Duration.FIVE_SECONDS).untilAsserted(() ->
                assertEquals(1, guestService.getInsertedGuests().size())
        );
    }

}