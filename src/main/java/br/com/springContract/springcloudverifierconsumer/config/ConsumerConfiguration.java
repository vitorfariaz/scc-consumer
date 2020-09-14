package br.com.springContract.springcloudverifierconsumer.config;

//@AllArgsConstructor
//@Configuration
public class ConsumerConfiguration {

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Convidado> listenerConvidadoContainerFactory(KafkaProperties kafkaProperties){
//        return criarListener(kafkaProperties, Convidado.class);
//    }
//
//    private <T> ConcurrentKafkaListenerContainerFactory<String, T> criarListener(KafkaProperties kafkaProperties, Class<T> messageType){
//        JsonDeserializer<T> jsonDeserializer =
//                new JsonDeserializer<T>(messageType, false);
//
//        jsonDeserializer.addTrustedPackages("*");
//
//        DefaultKafkaConsumerFactory<String, T> cf =
//                new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(), new StringDeserializer(), jsonDeserializer);
//
//        ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<>();
//
//        factory.setConsumerFactory(cf);
//
//        return factory;
//    }
}
