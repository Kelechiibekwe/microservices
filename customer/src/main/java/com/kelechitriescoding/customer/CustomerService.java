package com.kelechitriescoding.customer;

import com.kelechitriescoding.clients.fraud.FraudCheckResponse;
import com.kelechitriescoding.clients.fraud.FraudClient;
import com.kelechitriescoding.clients.notification.NotificationClient;
import com.kelechitriescoding.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
//    private final NotificationRequest notificationRequest;
    private final NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        //todo: check if email valid
        //todo: check if email not taken
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        //todo: make it async. i.e add to queue
        String response = notificationClient.sendNotification(
                new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to kelechitriescoding...",
                        customer.getFirstName())
        ));

    }
}
