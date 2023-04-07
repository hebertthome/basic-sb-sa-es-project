package br.com.thome.hebert.si.app.domain.beans.in;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateContractReceived {

    private List<String> productIds = new ArrayList<>();

    private Map<String, String> additionalInformation = new HashMap<>();

    private CreateContractReceived() {
    }

    private CreateContractReceived(Builder builder) {
        this.productIds = builder.productIds;
        this.additionalInformation = builder.additionalInformation;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public Map<String, String> getAdditionalInformation() {
        return additionalInformation;
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

        public CreateContractReceived build() {
            return new CreateContractReceived(this);
        }

    }

}
