package com.learn.rabbitmq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.rabbitmq.config.RabbitConfig;
import com.learn.rabbitmq.dto.UserDto;
import com.learn.rabbitmq.service.RabbitProducerService;

@RestController
public class RabbitProducerController {

	private RabbitProducerService producerService;

	public RabbitProducerController(RabbitProducerService service) {
		this.producerService = service;
	}

	@PostMapping("/string")
	public String sendString(@RequestParam String msg) {
		producerService.sendString(RabbitConfig.STRING_QUEUE, msg);
		return "String sent";
	}

	@PostMapping("/dto")
	public String sendDto(@RequestBody UserDto dto) {
		producerService.sendDto(RabbitConfig.DTO_QUEUE, dto);
		return "DTO sent";
	}

	@PostMapping("/map")
	public String sendMap(@RequestBody Map<String, Object> map) {
		producerService.sendMap(RabbitConfig.MAP_QUEUE, map);
		return "Map sent";
	}

	@PostMapping("/list")
	public String sendList(@RequestBody List<String> list) {
		producerService.sendList(RabbitConfig.LIST_QUEUE, list);
		return "List sent";
	}

}
