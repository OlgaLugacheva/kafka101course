package ru.los.kafka.tutorial1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
//java -cp kafka-course-1.0-jar-with-dependencies.jar ru.los.kafka.tutorial1.ProducerDemo
//consumer
// ./kafka-console-consumer.sh --bootstrap-server sandbox-hdp.hortonworks.com:6667 --topic first_topic -
        //-group my-third-application

        //create Producer  properties
        Properties properties = new Properties();
        String bootstrapServers = "sandbox-hdp.hortonworks.com:6667";
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //create the producer

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(
                properties
        );
        //create producer record
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "hello world");
        //send data - async
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
