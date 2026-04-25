package co.com.daniel.events;

import co.com.daniel.dtos.PaymentMessage;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@Slf4j
@ApplicationScoped
public class PaymentEvent {

    @Inject
    EventBus bus;

    @Incoming("payment")
    public Uni<Void> onMessage(Message<PaymentMessage> message) {
        bus.requestAndForget("process-payment", message.getPayload());
        log.info("payment received: {}", message.getPayload().getPaymentId());
        return Uni.createFrom().completionStage(message.ack()).replaceWithVoid();
    }

}
