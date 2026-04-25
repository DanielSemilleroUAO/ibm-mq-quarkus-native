package co.com.daniel.events;

import co.com.daniel.dtos.OrderMessage;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@Slf4j
@ApplicationScoped
public class OrderEvent {

    @Incoming("order")
    public Uni<Void> onMessage(Message<OrderMessage> message) {
        log.info("order received: {}", message.getPayload().getOrderId());
        return Uni.createFrom().completionStage(message.ack()).replaceWithVoid();
    }

}
