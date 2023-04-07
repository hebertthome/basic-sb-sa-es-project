package br.com.thome.hebert.si.adapter.controller.to.mapper;

import br.com.thome.hebert.si.adapter.controller.to.CreateContractRequest;
import br.com.thome.hebert.si.app.domain.beans.in.CreateContractReceived;

public class CreateContractRequestMapper {

    private CreateContractRequestMapper() {
    }

    public static CreateContractReceived to(final CreateContractRequest request) {

        return new CreateContractReceived.Builder()
                .productIds(request.getProductIds())
                .additionalInformation(request.getAdditionalInformation())
                .build();
    }

}
