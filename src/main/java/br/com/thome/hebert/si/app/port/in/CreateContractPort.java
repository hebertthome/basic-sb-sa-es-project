package br.com.thome.hebert.si.app.port.in;

import br.com.thome.hebert.si.app.domain.beans.in.CreateContractReceived;

public interface CreateContractPort {

    public void execute(CreateContractReceived bean);
}
