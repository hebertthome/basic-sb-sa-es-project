package br.com.thome.hebert.si.app.domain.beans.out;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ContractEvent {

    private UUID id;

    private UUID contractId;

    private String eventType;

    private String payload;

    private ZonedDateTime eventDt;

    private ContractEvent() {
    }

    private ContractEvent(Builder builder) {
        this.id = builder.id;
        this.contractId = builder.contractId;
        this.eventType = builder.eventType;
        this.payload = builder.payload;
        this.eventDt = builder.eventDt;
    }

    public UUID getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public UUID getContractId() {
        return contractId;
    }

    public String getPayload() {
        return payload;
    }

    public ZonedDateTime getEventDt() {
        return eventDt;
    }

    public static class Builder {

        private UUID id;

        private UUID contractId;

        private String eventType;

        private String payload;

        private ZonedDateTime eventDt;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder contractId(UUID contractId) {
            this.contractId = contractId;
            return this;
        }

        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder payload(String payload) {
            this.payload = payload;
            return this;
        }

        public Builder eventDt(ZonedDateTime eventDt) {
            this.eventDt = eventDt;
            return this;
        }

        public ContractEvent build() {
            return new ContractEvent(this);
        }

    }

}
