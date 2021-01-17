package br.com.springContract.springcloudverifierconsumer.config;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.messaging.Message;

@Configuration
public class RecordMessageConverterConfig {

    @Bean
    @Primary
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter() {
            @Override
            protected Object convertPayload(Message<?> message) {
                String value = (String) super.convertPayload(message);
                if (value.length() > 2 && value.startsWith("\"") && value.endsWith("\"")) {
                    value = value.substring(1, value.length() - 1);

                }
                System.out.println("MESSAGE PUBLISHED BY STUBRUNNER: " + StringEscapeUtils.unescapeJson(value));
                return StringEscapeUtils.unescapeJson(value); //apache commons
            }
        };
    }
}
