package com.example.demo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KafkaStreams.State;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

import com.fasterxml.jackson.databind.ObjectMapper;

import scala.reflect.internal.Trees.New;

public class KafkaStreamsStateStore {

	Properties streamsConfiguration = null;

	public KafkaStreamsStateStore() {

	}

	public Properties streamsConfiguration() {
		streamsConfiguration = new Properties();
		streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "group-id");
		streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		return this.streamsConfiguration;
	}

	public Topology topology() {
		final StreamsBuilder streamsBuilder = new StreamsBuilder();
		return streamsBuilder.build();
	}

	public static StreamsBuilder streamsBuilder() {
		final StreamsBuilder streamsBuilder = new StreamsBuilder();
		return streamsBuilder;
	}

	private static final String TOPIC1 = "TOPIC1";
	private static final String stateStore = "stateStore";
	private static int change = 1;

	private ObjectMapper objectMapper = new ObjectMapper()
	public static void builder() {
		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(ConsumerConfig.CLIENT_ID_CONFIG,"group-id");
		
		StreamsBuilder builder = new StreamsBuilder();
		KStream<String, String> textLines = builder.stream(TOPIC1);
		KTable<String, Long> wordCounts = textLines
				.flatMapValues(textLine -> {
					EventInstance eventInstance = ObjectMapperFactory.getInstance().readValue(textLine,EventInstance.class);
					ValueMapper<EventInstance,List<EventInstance>> valueMapper
//					List<EventInstance> mappers = new ArrayList<>();
//					mappers.add(eventInstance);
//					return mappers;
						//	Arrays.asList(textLine.toLowerCase().split("\\W+"));
					
				}).groupBy((key, word) -> {
					change = 1;
					return word;

				}).count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as(stateStore));
	 

		KafkaStreams streams = new KafkaStreams(builder.build(), props);
		streams.start();
 

		ReadOnlyKeyValueStore<String, Long> keyValueStore = streams.store(stateStore,
				QueryableStoreTypes.keyValueStore());

		// Get value by key
		System.out.println("count for hello:" + keyValueStore.get("KeyValue"));

		// Get the values for a range of keys available in this application instance
		KeyValueIterator<String, Long> range = keyValueStore.range("all", "streams");
		if (streams.state() == State.RUNNING && change == 1) {
			while (range.hasNext()) {
				KeyValue<String, Long> next = range.next();
				System.out.println("\ncount for " + next.key + ": " + next.value);
			}

//		// Get the values for all of the keys available in this application instance
		KeyValueIterator<String, Long> rangeAll = keyValueStore.all();
		while (rangeAll.hasNext()) {
			KeyValue<String, Long> next = rangeAll.next();
			System.out.println("\ncount for " + next.key + ": " +next.value);
		}
			change = 0;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		builder();
	}

}
