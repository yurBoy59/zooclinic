package com.zooclinic.zooclinic.service.impl;

import com.zooclinic.zooclinic.service.IncidentHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class IncidentKafkaHandler implements IncidentHandler {

    @Value("${spring.kafka.topics.zooclinic}")
    private String topic;

    private final KafkaTemplate<String, String> visitReporter;

    @Override
    public void createReport(String visit) {
        try {
            visitReporter.send(topic, UUID.randomUUID().toString(), visit);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
