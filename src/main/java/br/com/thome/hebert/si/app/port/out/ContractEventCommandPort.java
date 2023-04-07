package br.com.thome.hebert.si.app.port.out;

import br.com.thome.hebert.si.app.domain.beans.out.ContractEvent;

public interface ContractEventCommandPort {

    void saveContractEvent(ContractEvent contractEvent);

}
