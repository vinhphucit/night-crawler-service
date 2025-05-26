# NightCrawler Service

A multithreaded web crawler service built with Java and Maven.

## Features

- Multithreaded web crawling
- Configurable thread pool size
- Timeout handling
- Logging support
- Error handling

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Building the Project

To build the project, run:

```bash
mvn clean install
```

## Running the Service

To run the service:

```bash
mvn exec:java -Dexec.mainClass="com.nightcrawler.NightCrawlerApplication"
```

## Configuration

The service can be configured by modifying the following constants in `WebCrawlerService.java`:

- `THREAD_POOL_SIZE`: Number of concurrent threads (default: 5)
- `TIMEOUT_MS`: Connection timeout in milliseconds (default: 10000)

## Testing

To run the tests:

```bash
mvn test
```

## Project Structure

```
src/
├── main/java/com/nightcrawler/
│   ├── NightCrawlerApplication.java
│   └── service/
│       └── WebCrawlerService.java
└── test/java/com/nightcrawler/
    └── service/
        └── WebCrawlerServiceTest.java
```

## Extending the Service

To add custom data processing:

1. Modify the `crawlWebsite` method in `WebCrawlerService.java`
2. Add your data extraction and processing logic
3. Implement data storage or further processing as needed

## License

MIT License 