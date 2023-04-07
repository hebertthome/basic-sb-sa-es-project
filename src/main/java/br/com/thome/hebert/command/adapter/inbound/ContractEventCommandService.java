package br.com.thome.hebert.command.adapter.inbound;

import org.springframework.stereotype.Service;

import br.com.thome.hebert.si.app.domain.beans.out.ContractEvent;
import br.com.thome.hebert.si.app.port.out.ContractEventCommandPort;

@Service
public class ContractEventCommandService implements ContractEventCommandPort {

    @Override
    public void saveContractEvent(ContractEvent contractEvent) {

        System.out.println("Hi!");

    }

}
