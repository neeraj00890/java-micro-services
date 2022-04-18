package com.neeraj.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CustomerRegistrationRequest {
    private  String firstName;
    private  String lastName;
    private  String email;
}
