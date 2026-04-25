package co.com.daniel.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@RegisterForReflection
@XmlRootElement(name = "Order")
public class OrderMessage {

    @XmlElement(name = "OrderId" )
    private String orderId;
}
