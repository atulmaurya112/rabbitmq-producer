package com.learn.rabbitmq.serviceimpl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.learn.rabbitmq.config.RabbitConfig;
import com.learn.rabbitmq.dto.UserDto;
import com.learn.rabbitmq.service.RabbitProducerService;

@Service
public class RabbitProducerServiceImpl implements RabbitProducerService {

	private static final Logger log = LoggerFactory.getLogger(RabbitProducerServiceImpl.class);
	
	private RabbitTemplate rabbitTemplate;
	
	public RabbitProducerServiceImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void sendString(String routingKey, String value) {
		try {
			rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, routingKey, value);
			log.info("Sent String to routingKey '{}': {}", routingKey, value);
		} catch (Exception e) {
			log.error("Failed to send String to '{}': {}", routingKey, e.getMessage());
		}
	}

	@Override
	public void sendDto(String routingKey, UserDto dto) {
		try {
			rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, routingKey, dto);
			log.info("Sent DTO to routingKey '{}': {}", routingKey, dto);
		} catch (Exception e) {
			log.error("Failed to send DTO to '{}': {}", routingKey, e.getMessage());
		}
	}

	@Override
	public void sendMap(String routingKey, Map<String, Object> map) {
		try {
			rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, routingKey, map);
			log.info("Sent Map to routingKey '{}': {}", routingKey, map);
		} catch (Exception e) {
			log.error("Failed to send Map to '{}': {}", routingKey, e.getMessage());
		}
	}

	@Override
	public void sendList(String routingKey, List<String> list) {
		try {
			rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, routingKey, list);
			log.info("Sent List to routingKey '{}': {}", routingKey, list);
		} catch (Exception e) {
			log.error("Failed to send List to '{}': {}", routingKey, e.getMessage());
		}
	}
	
}