package co.com.daniel.events;

import co.com.daniel.dtos.PaymentMessage;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ProcessPayment {

    @ConsumeEvent("process-payment")
    public Uni<Void> processPayment(PaymentMessage message) {
        log.info("Processing payment: {} - {}", message.getPaymentId(), message.getAmount());
        return Uni.createFrom().voidItem();
    }
}
