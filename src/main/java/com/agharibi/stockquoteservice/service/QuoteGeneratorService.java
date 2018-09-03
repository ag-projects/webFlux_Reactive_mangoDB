package com.agharibi.stockquoteservice.service;

import com.agharibi.stockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {

    Flux<Quote> fetchQuoteStream(Duration duration);
}
