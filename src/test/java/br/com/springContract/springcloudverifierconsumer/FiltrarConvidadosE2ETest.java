package br.com.springContract.springcloudverifierconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWireMock
@EmbeddedKafka(topics = "${cloudkarafka.topic}")
class FiltrarConvidadosE2ETest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
	this.mockMvc.perform(MockMvcRequestBuilders
			.get("/convidados?idade=130"))
			.andExpect(jsonPath("[0].idade", equalTo(130)));
	}
}
