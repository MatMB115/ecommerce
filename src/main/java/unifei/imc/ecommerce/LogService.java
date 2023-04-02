package unifei.imc.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Properties;
import java.util.regex.Pattern;

public class LogService {
    public static void main(String[] args) {
        var logService = new LogService();
        try(var service = new KafkaService(EmailService.class.getSimpleName(),Pattern.compile("ECOMMERCE.*"),
                logService::parse)){
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record) {
            System.out.println("________________________________________-");
            System.out.println("Log " + record.topic());
            System.out.println(record.key());
            System.out.println(record.value());
            System.out.println(record.partition());
            System.out.println(record.offset());
    }
}
