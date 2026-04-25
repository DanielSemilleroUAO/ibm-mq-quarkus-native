package co.com.daniel.converters;

import co.com.daniel.dtos.OrderMessage;
import co.com.daniel.dtos.PaymentMessage;
import co.com.daniel.dtos.cbe.AccountBasicInfoPayload;
import co.com.daniel.dtos.cbe.CicsContextInfo;
import co.com.daniel.dtos.cbe.CicsEvent;
import co.com.daniel.dtos.cbe.CicsPayloadData;
import co.com.daniel.dtos.cbe.CommonBaseEvent;
import io.smallrye.reactive.messaging.MessageConverter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Set;

@Slf4j
@ApplicationScoped
public class XmlMessageConverter implements MessageConverter {

    // 1. Registra aquí todos los DTOs XML que quieras soportar
    private static final Set<Class<?>> SUPPORTED_TYPES = Set.of(
            OrderMessage.class,
            PaymentMessage.class,
            CommonBaseEvent.class
    );

    private static final JAXBContext JAXB_CONTEXT;

    static {
        try {
            // 2. Pasa todos los DTOs al contexto JAXB
            JAXB_CONTEXT = JAXBContext.newInstance(
                    OrderMessage.class,
                    PaymentMessage.class,
                    CommonBaseEvent.class,
                    CicsEvent.class,
                    CicsContextInfo.class,
                    CicsPayloadData.class,
                    AccountBasicInfoPayload.class
            );
        } catch (JAXBException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public boolean canConvert(Message<?> in, Type target) {
        // 3. Acepta cualquier tipo registrado en SUPPORTED_TYPES
        return in.getPayload() instanceof String && SUPPORTED_TYPES.contains(target);
    }

    @Override
    public Message<?> convert(Message<?> in, Type target) {
        try {
            Unmarshaller unmarshaller = JAXB_CONTEXT.createUnmarshaller();
            Object dto = unmarshaller.unmarshal(new StringReader((String) in.getPayload()));
            return in.withPayload(dto);
        } catch (JAXBException e) {
            log.error("Error converting XML to {}: {}", target, e.getMessage(), e);
            throw new RuntimeException("Error converting XML message to " + target, e);
        }
    }
}

