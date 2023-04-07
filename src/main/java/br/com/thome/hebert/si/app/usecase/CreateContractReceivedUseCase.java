package br.com.thome.hebert.si.app.usecase;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thome.hebert.si.app.domain.beans.in.CreateContractReceived;
import br.com.thome.hebert.si.app.domain.beans.out.ContractEvent;
import br.com.thome.hebert.si.app.domain.enums.ContractEventTypeEnum;
import br.com.thome.hebert.si.app.helper.JsonHelper;
import br.com.thome.hebert.si.app.port.in.CreateContractPort;
import br.com.thome.hebert.si.app.port.out.ContractEventCommandPort;

@Service
public class CreateContractReceivedUseCase implements CreateContractPort {

    @Autowired
    private ContractEventCommandPort contractEventCommandPort;

    @Override
    public void execute(CreateContractReceived bean) {

        // @formatter:off
        final ContractEvent contractEvent = new ContractEvent.Builder()
                .id(UUID.randomUUID())
                .contractId(UUID.randomUUID())
                .eventType(ContractEventTypeEnum.CONTRACT_CREATED.name())
                .payload(JsonHelper.writeToString(bean).orElse(null))
                .eventDt(ZonedDateTime.now())
                .build();
         // @formatter:on

        contractEventCommandPort.saveContractEvent(contractEvent);

    }

}
