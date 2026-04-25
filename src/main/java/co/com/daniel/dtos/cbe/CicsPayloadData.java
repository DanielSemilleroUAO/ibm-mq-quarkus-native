package co.com.daniel.dtos.cbe;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@RegisterForReflection
@XmlAccessorType(XmlAccessType.FIELD)
public class CicsPayloadData {

    @XmlElement(name = "payload", namespace = "http://www.ibm.com/prod/cics/BasicAccountInfoCreatedOrUpdated")
    private AccountBasicInfoPayload payload;
}

