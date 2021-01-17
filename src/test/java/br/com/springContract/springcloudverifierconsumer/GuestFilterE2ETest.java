package br.com.springContract.springcloudverifierconsumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWireMock
@EmbeddedKafka(topics = "${cloudkarafka.topic}")
@ActiveProfiles("e2e")
class GuestFilterE2ETest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void should_filter_guest_with_one_hundred_thirty_years_old() throws Exception {
	this.mockMvc.perform(MockMvcRequestBuilders
			.get("/guests?age=130"))
			.andExpect(jsonPath("[0].age", equalTo(130)));
	}

	@BeforeEach
	void setUp(){

		stubFor(
				get(urlPathEqualTo("/guests"))
				.willReturn(
						aResponse()
								.withStatus(200)
								.withBody("[{\"name\":\"Vitor\",\"email\":\"vitinho@test.com\",\"phone\":\"700669919\",\"age\":130},{\"name\":\"Vitor2\",\"email\":\"vitinho2@test.com\",\"phone\":\"854495913\",\"age\":11}]")
								.withHeader("Content-Type", "application/json")
				));
	}
}
