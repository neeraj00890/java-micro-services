package com.neeraj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@ToString
@Builder
@Getter
public class FraudCheckResponse {
    @JsonProperty("isFraudster")
    private Boolean isFraudster;
    FraudCheckResponse() {
        super();
    }

    FraudCheckResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }


}
