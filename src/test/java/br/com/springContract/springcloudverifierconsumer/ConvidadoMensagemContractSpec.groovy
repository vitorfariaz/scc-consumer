package br.com.springContract.springcloudverifierconsumer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.StubTrigger
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import spock.lang.Specification

@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "br.com.springContract:spring-cloud-verifier-provider")
class ConvidadoMensagemContractSpec extends Specification {

    @Autowired
    StubTrigger stubTrigger

    def "Deve receber a mensagem"(){

        given: ""

        when:  ""
            stubTrigger.trigger('publicacao_kafka')

        then:  ""


    }

}
