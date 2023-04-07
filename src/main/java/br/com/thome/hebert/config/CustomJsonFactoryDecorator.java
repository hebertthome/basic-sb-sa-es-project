package br.com.thome.hebert.config;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import net.logstash.logback.decorate.JsonFactoryDecorator;

public class CustomJsonFactoryDecorator implements JsonFactoryDecorator {
    private static final DateTimeFormatter FORMATTER = ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public MappingJsonFactory decorate(MappingJsonFactory factory) {
        final ObjectMapper objectMapper = factory.getCodec();
        final JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateSerializer());
        javaTimeModule.addSerializer(Date.class, new DateSerializer());
        objectMapper.registerModule(javaTimeModule);
        return factory;
    }

    public class LocalDateSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.format(FORMATTER));
        }
    }

    public class DateSerializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value));
        }
    }
}
