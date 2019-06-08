package com.example.demo;

import java.time.Instant;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.ValueTransformerWithKey;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

import com.example.demo.KafkaStreamDSL_Example.SimpleValueTransformer;

public class KafkaStreamDSL_Example {
  public static void main(String[] args) {
    final Properties properties = new Properties();
    properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "group-id");
    properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    properties.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

    final String storeName = "localStorage";
    final StreamsBuilder builder = new StreamsBuilder();

    final StoreBuilder<KeyValueStore<String, String>> storeBuilder =
        Stores.keyValueStoreBuilder(Stores.persistentKeyValueStore(storeName),
                                    Serdes.String(),
                                    Serdes.String());
    builder.addStateStore(storeBuilder);

//    builder.<String, String>stream("inputExample")
//           .filter((k,v) -> v.endsWith("FOO"))
//           .transformValues(() -> new SimpleValueTransformer(storeName), storeName)
//           .to("output");

    final Topology topology = builder.build();
    System.out.println(topology.describe());

    final KafkaStreams streams = new KafkaStreams(topology, properties);
    streams.start();
  }


  static class SimpleValueTransformer implements ValueTransformerWithKey<String, String, String> {

    private String storeName;
    private KeyValueStore<String, String> store;

    public SimpleValueTransformer(String storeName) {
      this.storeName = storeName;
    }

    @Override
    public void init(final ProcessorContext context) {
      store = (KeyValueStore) context.getStateStore(storeName);
    }

    @Override
    public String transform(final String key, final String value) {
      String persistedValue = store.get(key);
      final String updatedValue = value + "_" + Instant.now().toString();

      if(persistedValue == null) {
           persistedValue = updatedValue;
      }

      store.put(key, updatedValue);
      return persistedValue;
    }

    @Override
    public void close() {
    }
  }
}
