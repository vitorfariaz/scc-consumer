package br.com.springContract.springcloudverifierconsumer;

import br.com.springContract.springcloudverifierconsumer.model.Guest;
import br.com.springContract.springcloudverifierconsumer.service.GuestService;
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
class GuestServiceContractTest {

    @Autowired
    private GuestService guestService;

    @Test
    void should_validate_contract_resource_allGuests()  {
        List<Guest> guests = this.guestService.findAllGuests();
        assertEquals(2, guests.size());
    }

}
