package br.com.thome.hebert.si.app.domain.enums;

import java.util.Arrays;

public enum ContractEventTypeEnum {

    // @formatter:off
    
        CONTRACT_CREATED

        ;
	// @formatter:on

    public static ContractEventTypeEnum parse(String name) {
        // @formatter:off
        return Arrays.stream(ContractEventTypeEnum.values())
                    .filter(s -> s.name().equalsIgnoreCase(name))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Type: " + name));
        // @formatter:on
    }

}
