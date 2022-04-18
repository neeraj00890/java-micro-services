package com.neeraj.customer;

import com.neeraj.clients.FraudClient;
import com.neeraj.clients.NotificationClient;
import com.neeraj.dto.FraudCheckResponse;
import com.neeraj.dto.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = NotificationRequest.builder()
                .toCustomerId(customer.getId())
                .toCustomerName(customer.getFirstName())
                .message(String.format("Hi %s, welcome to Amigoscode...", customer.getFirstName()))
                .build();

        notificationClient.sendNotification(notificationRequest);
//        rabbitMQMessageProducer.publish(
//                notificationRequest,
//                "internal.exchange",
//                "internal.notification.routing-key"
//        );

    }
}
