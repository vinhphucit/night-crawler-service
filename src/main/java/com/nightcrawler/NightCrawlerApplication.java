package com.nightcrawler;

import com.nightcrawler.service.WebCrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class NightCrawlerApplication {
    private static final Logger logger = LoggerFactory.getLogger(NightCrawlerApplication.class);

    public static void main(String[] args) {
        logger.info("Starting NightCrawler Service...");
        
        // Example list of websites to crawl
        List<String> websites = Arrays.asList(
            "https://example.com",
            "https://example.org",
            "https://example.net"
        );

        // Create and start the web crawler service
        WebCrawlerService crawlerService = new WebCrawlerService();
        crawlerService.startCrawling(websites);
    }
} 