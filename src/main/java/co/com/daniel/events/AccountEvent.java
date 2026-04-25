package co.com.daniel.events;

import co.com.daniel.dtos.cbe.AccountBasicInfoPayload;
import co.com.daniel.dtos.cbe.CommonBaseEvent;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@Slf4j
@ApplicationScoped
public class AccountEvent {

    @Incoming("account-events")
    public Uni<Void> onAccountEvent(Message<CommonBaseEvent> message) {
        AccountBasicInfoPayload payload = message.getPayload()
                .getEvent()
                .getPayloadData()
                .getPayload();

        log.info("Account: {} | Balance: {} | Status: {}",
                payload.getAccountNumber(),
                payload.getCurrentBalance(),
                payload.getStatus());

        return Uni.createFrom().completionStage(message.ack()).replaceWithVoid();
    }

}
