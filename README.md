## Note
 - into kafka container : docker exec -it kafka /bin/bash
 - kafka sh file path : /opt/kafka_2.13-2.8.1/bin
 - create topic : kafka-topics.sh --create --topic topic1 --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3
 - check topic : kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test
  