package br.com.thome.hebert.si.config;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Repository
public class CustomTraceRepository implements HttpTraceRepository {
    private static final Logger log = LoggerFactory.getLogger(CustomTraceRepository.class);
    AtomicReference<HttpTrace> lastTrace = new AtomicReference<>();

    @Override
    public List<HttpTrace> findAll() {
        return Collections.singletonList(lastTrace.get());
    }

    @Override
    public void add(HttpTrace trace) {
        if (!"/actuator/health".equals(trace.getRequest().getUri().getPath())) {
            try {
                ObjectMapper om = new ObjectMapper()
                        .registerModule(new JavaTimeModule())
                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                String message = om.writeValueAsString(trace);
                log.info(message);
            } catch (JsonProcessingException e) {
                log.error("Could not write trace, exception message: {}", e.getMessage());
            }
            lastTrace.set(trace);
        }
    }

}