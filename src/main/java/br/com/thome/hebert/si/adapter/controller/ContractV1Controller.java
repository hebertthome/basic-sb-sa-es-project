package br.com.thome.hebert.si.adapter.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thome.hebert.si.adapter.controller.to.CreateContractRequest;
import br.com.thome.hebert.si.adapter.controller.to.mapper.CreateContractRequestMapper;
import br.com.thome.hebert.si.app.port.in.CreateContractPort;

@RestController
@RequestMapping(value = "api/v1/contract")
public class ContractV1Controller {

    @Autowired
    private CreateContractPort createContractPort;

    // @formatter:off

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void> creatContract(@Valid @RequestBody CreateContractRequest contractCreationRequestTO,
            @RequestHeader Map<String, String> headerAttributes){

        createContractPort
                .execute(CreateContractRequestMapper.to(contractCreationRequestTO));

        return ResponseEntity.accepted().build();
    }

    // @formatter:on
}
