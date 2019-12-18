package com.transform.demo;

import com.demo.CloudMessage;
import com.demo.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@Slf4j
@EnableBinding(Processor.class)
public class CustomerProcessorConfiguration {

	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public CloudMessage convertToPojo(CloudMessage payload) {
		log.info("Start transform '{}'", payload);
		return payload;
	}
}