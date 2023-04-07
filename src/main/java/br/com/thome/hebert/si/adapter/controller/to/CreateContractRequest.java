package br.com.thome.hebert.si.adapter.controller.to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateContractRequest {

    @JsonProperty(value = "product_ids")
    @NotEmpty
    private List<@NotBlank String> productIds = new ArrayList<>();

    @JsonProperty(value = "additional_information")
    private Map<String, String> additionalInformation = new HashMap<>();

    public CreateContractRequest() {
    }

    private CreateContractRequest(Builder builder) {
        this.productIds = builder.productIds;
        this.additionalInformation = builder.additionalInformation;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public Map<String, String> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<String, String> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public static class Builder {

        private List<String> productIds;
        private Map<String, String> additionalInformation;

        public Builder productIds(List<String> productIds) {
            this.productIds = productIds;
            return this;
        }

        public Builder additionalInformation(Map<String, String> additionalInformation) {
            this.additionalInformation = additionalInformation;
            return this;
        }

        public CreateContractRequest build() {
            return new CreateContractRequest(this);
        }

    }

}
