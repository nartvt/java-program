package com.example.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Kafka_producer_example {

  
 
  private static final String TOPIC="TOPIC1";

  @Value(value = "${spring.kafka.producer.bootstrap-servers}")
  private static String BOOTSTRAP_SERVERS_CONFIG = "localhost:9092";

  @Value(value = "${spring.kafka.producer.group-id}")
  private static String CLIENT_ID_CONFIG = "group-id";

  @Value(value = "${spring.kafka.producer.key-serializer}")
  private static String KEY_SERIALIZER_CLASS_CONFIG = "org.apache.kafka.common.serialization.StringSerializer";

  @Value(value = "${spring.kafka.producer.value-deserializer}")
  private static String VALUE_SERIALIZER_CLASS_CONFIG = "org.apache.kafka.common.serialization.StringSerializer";

  private static KafkaProducer createProducer() {
    Properties props = new Properties();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
    props.put(ProducerConfig.CLIENT_ID_CONFIG, CLIENT_ID_CONFIG);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KEY_SERIALIZER_CLASS_CONFIG);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VALUE_SERIALIZER_CLASS_CONFIG);
    KafkaProducer kafkaProducer = new KafkaProducer(props);
    return kafkaProducer;
  }

  static void runProducer(final int sendMessageCount) throws Exception {
    final KafkaProducer producer = createProducer();
    long time = System.currentTimeMillis();

    try {
      for (long index = time; index < time + sendMessageCount; index++) {
        final ProducerRecord record = new ProducerRecord(TOPIC, "KeyValue", "hello");

        RecordMetadata metadata = (RecordMetadata) producer.send(record).get();
        long elapsedTime = System.currentTimeMillis() - time;
        System.out.printf("sent record(key=%s value=%s) " + "meta(partition=%d, offset=%d) time=%d\n", record.key(),
            record.value(), metadata.partition(), metadata.offset(), elapsedTime);
        Thread.sleep(1000);
      }
    } finally {
      producer.flush();
      producer.close();
    }
  }


  public static void main(String[] args) {

     try {
		runProducer(1000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//    try {
//      runConsumer();
//    } catch (InterruptedException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }

  }
}
