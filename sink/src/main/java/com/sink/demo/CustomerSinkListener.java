package com.sink.demo;

import com.demo.CloudMessage;
import com.demo.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
@RequiredArgsConstructor
public class CustomerSinkListener {

	private final CustomerRepository repository;

	@StreamListener(Sink.INPUT)
	public void save(CloudMessage cloudMessage) {
		if(cloudMessage.getCustomer() == null){
			return;
		}

		log.info("Start sink '{}'", cloudMessage);

		Customer customer = cloudMessage.getCustomer();

		customer.setState("COMPLETED");

		Customer result = repository.save(customer);

		log.info("Result sink '{}'", result);
	}
}
