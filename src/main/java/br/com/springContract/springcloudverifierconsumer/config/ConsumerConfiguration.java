package br.com.springContract.springcloudverifierconsumer.config;

import br.com.springContract.springcloudverifierconsumer.model.Convidado;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

//@Configuration
//@EnableKafka
public class ConsumerConfiguration {

    //@Bean
    public KafkaListenerContainerFactory kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {

        JsonDeserializer deserializer = new JsonDeserializer(Convidado.class, false);
        deserializer.addTrustedPackages("*");

        DefaultKafkaConsumerFactory<String, Convidado> cf = new DefaultKafkaConsumerFactory(kafkaProperties.buildConsumerProperties(), new StringDeserializer(), deserializer);
        ConcurrentKafkaListenerContainerFactory<String, Convidado> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(cf);

        return factory;
    }

}
