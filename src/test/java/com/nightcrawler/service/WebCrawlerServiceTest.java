package com.nightcrawler.service;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WebCrawlerServiceTest {

    @Test
    void testStartCrawling() {
        WebCrawlerService service = new WebCrawlerService();
        List<String> testWebsites = Arrays.asList(
            "https://example.com",
            "https://example.org"
        );

        // Verify that the crawling process starts without throwing exceptions
        assertDoesNotThrow(() -> service.startCrawling(testWebsites));
    }
} 