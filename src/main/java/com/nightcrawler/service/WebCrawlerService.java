package com.nightcrawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebCrawlerService {
    private static final Logger logger = LoggerFactory.getLogger(WebCrawlerService.class);
    private final ExecutorService executorService;
    private static final int THREAD_POOL_SIZE = 5;
    private static final int TIMEOUT_MS = 10000;

    public WebCrawlerService() {
        logger.info("Initializing WebCrawlerService");
        this.executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public void startCrawling(List<String> websites) {
        logger.info("Starting to crawl {} websites with {} threads", websites.size(), THREAD_POOL_SIZE);

        for (String website : websites) {
            executorService.submit(() -> crawlWebsite(website));
        }

        // Shutdown the executor service and wait for all tasks to complete
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                logger.warn("Some tasks did not complete within the timeout period");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            logger.error("Crawling was interrupted", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private void crawlWebsite(String url) {
        try {
            logger.info("Crawling website: {}", url);
            Document doc = Jsoup.connect(url)
                    .timeout(TIMEOUT_MS)
                    .get();

            // Extract and process data from the website
            String title = doc.title();
            logger.info("Title: {}", title);
            String description = doc.select("meta[name=description]").attr("content");
            logger.info("Description: {}", description);
            logger.info("Successfully crawled {} - Title: {}", url, title);
            // TODO: Add your data processing logic here
            // For example, you might want to:
            // 1. Extract specific data
            // 2. Store it in a database
            // 3. Process it further
            
        } catch (IOException e) {
            logger.error("Error crawling website {}: {}", url, e.getMessage());
        }
    }
} 