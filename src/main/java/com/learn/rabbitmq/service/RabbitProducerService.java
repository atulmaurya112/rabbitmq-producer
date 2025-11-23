package com.learn.rabbitmq.service;

import java.util.List;
import java.util.Map;

import com.learn.rabbitmq.dto.UserDto;

public interface RabbitProducerService {

	void sendString(String routingKey, String value);

	void sendDto(String routingKey, UserDto dto);

	void sendMap(String routingKey, Map<String, Object> map);

	void sendList(String routingKey, List<String> list);

}
