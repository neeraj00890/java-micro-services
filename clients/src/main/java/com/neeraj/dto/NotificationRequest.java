package com.neeraj.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NotificationRequest {
    Integer toCustomerId;
    String toCustomerName;
    String message;

    NotificationRequest() {
        super();
    }

    NotificationRequest(Integer toCustomerId,
                        String toCustomerName,
                        String message) {
        this.toCustomerId = toCustomerId;
        this.message = message;
        this.toCustomerName = toCustomerName;
    }
}
