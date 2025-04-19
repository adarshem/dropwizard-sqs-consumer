# Dropwizard SQS Consumer Service

This is a Dropwizard-based Java service that consumes messages from an AWS SQS queue and prints them to the console. The service is designed to poll the SQS queue, process the messages, and delete them after successful processing.

## Features
- Polls messages from an AWS SQS queue.
- Prints the message body to the console.
- Deletes messages from the queue after processing.
- Configurable via a YAML configuration file.

## Prerequisites
- Java 11 or higher.
- Maven 3.6 or higher.
- AWS credentials configured (e.g., via `~/.aws/credentials` or environment variables).
- An existing SQS queue in AWS.

## Project Structure
- **`src/main/java/com/adarsh/sqs`**: Contains the main application code.
- **`config.yml`**: Configuration file for the service.
- **`pom.xml`**: Maven configuration file for dependencies and build setup.

## Configuration
The service is configured using a YAML file (`config.yml`). Below is an example configuration:

```yaml
queueUrl: https://sqs.us-west-2.amazonaws.com/your-account-id/your-queue-name
```

- `queueUrl`: The URL of the SQS queue to consume messages from.

## How to Build and Run

### 1. Build the Project
Use Maven to build the project and create a fat JAR file:

```bash
mvn clean package
```

### 2. Run the Service
Run the service using the Dropwizard application runner:

```bash
java -jar target/dropwizard-sqs-consumer-1.0-SNAPSHOT.jar server config.yml
```

### 3. Output
The service will start polling the SQS queue and print received messages to the console. Example output:

```
Polling for messages...
Received message: {"event": "example", "data": "sample data"}
```

## Dependencies
The project uses the following key dependencies:
- **Dropwizard**: For building RESTful services.
- **AWS SDK for Java v2**: For interacting with AWS SQS.
- **Jackson**: For JSON processing.

## Development
### Adding Dependencies
To add new dependencies, update the `pom.xml` file and rebuild the project.

### Testing
Run unit tests using Maven:

```bash
mvn test
```

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.