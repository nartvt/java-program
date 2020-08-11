package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Kafka_consumer_example {
  private static final String TOPIC = "TOPIC1";

  @Value(value = "${spring.kafka.producer.bootstrap-servers}")
  private static String BOOTSTRAP_SERVERS_CONFIG = "localhost:9092";

  @Value(value = "${spring.kafka.consumer.group-id}")
  private static String CLIENT_ID_CONFIG = "group-id";

  @Value(value = "${spring.kafka.consumer.key-serializer}")
  private static String KEY_SERIALIZER_CLASS_CONFIG = "org.apache.kafka.common.serialization.Deserializer";

  @Value(value = "${spring.kafka.consumer.value-deserializer}")
  private static String VALUE_SERIALIZER_CLASS_CONFIG = "org.apache.kafka.common.serialization.Deserializer";
  private static StreamsConfig streamsConfig = null;

  private static KafkaConsumer createConsumer() {
    Properties streamsProperties = new Properties();
    streamsProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
    streamsProperties.put(ConsumerConfig.GROUP_ID_CONFIG, CLIENT_ID_CONFIG);
    streamsProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KEY_SERIALIZER_CLASS_CONFIG);
    streamsProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VALUE_SERIALIZER_CLASS_CONFIG);
    streamsProperties.put(StreamsConfig.consumerPrefix(ConsumerConfig.METADATA_MAX_AGE_CONFIG), 60000);
    // sets "metadata.max.age.ms" to 1 minute for producer only
    streamsProperties.put(StreamsConfig.producerPrefix(ProducerConfig.METADATA_MAX_AGE_CONFIG), 60000);
    streamsConfig = new StreamsConfig(streamsProperties);
    // Create the consumer using props.
    final KafkaConsumer consumer = new KafkaConsumer(streamsProperties);

    // Subscribe to the topic.
    consumer.subscribe(Collections.singletonList(TOPIC));
    return consumer;
  }

  static void runConsumer() throws InterruptedException, IOException {
    final KafkaConsumer consumer = createConsumer();
    File file = new File("captureLog.txt");
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    final int giveUp = 100;
    int noRecordsCount = 0;

    while (true) {
      final ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);
      System.out.println("Consum Counter: " + consumerRecords.count());
      if (consumerRecords.count() == 0) {
        noRecordsCount++;
        if (noRecordsCount > giveUp) {
          break;
        } else {
          continue;
        }
      }

      consumerRecords.forEach(record -> {
        String content = String.format("Consumer Record:(%d, %s, %d, %d)\n", record.key(), record.value(),
            record.partition(), record.offset());
        try {
          writer.write(content);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        System.out.printf("Consumer Record:(%d, %s, %d, %d)\n", record.key(), record.value(), record.partition(),
            record.offset());
      });

      consumer.commitAsync();
    }
    if (writer != null) {
      writer.close();
    }
    consumer.close();
    System.out.println("DONE");
  }

  public void example() {
    // KStreamBuilder builder = new KStreamBuilder();
    KStream<String, String> kStream = streamsBuilder().stream("TOPIC1",
        Consumed.with(Serdes.String(), Serdes.String()));
    KGroupedStream<String, String> groupedStream = kStream.groupByKey();
    KTable<String, Long> totalCount = groupedStream.count();
    KTable<String, Long> windowedCount = groupedStream.count();
    groupedStream.count();
  }

  public StreamsBuilder streamsBuilder() {
    final StreamsBuilder streamsBuilder = new StreamsBuilder();
    return streamsBuilder;
  }

  public static void main(String[] args) {
    // runProducer(10);
    try {
      try {
        runConsumer();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
