package com.moroz.randomquote.service;

import com.moroz.randomquote.model.Quote;
import lombok.Getter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class QuouteService {

    private final RestTemplate restTemplate;

    @Getter
    private final String singleQuoteURL =
            "http://quotesondesign.com/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=1";

    public QuouteService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Quote getSingleQuote() {
        Quote[] singleQuote = restTemplate.getForObject(singleQuoteURL, Quote[].class);
        return Arrays.stream(singleQuote).findFirst().get();
    }
}
