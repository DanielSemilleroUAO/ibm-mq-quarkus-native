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
public class CicsEvent {

    @XmlElement(name = "context-info", namespace = "http://www.ibm.com/xmlns/prod/cics/events/CBE")
    private CicsContextInfo contextInfo;

    @XmlElement(name = "payload-data", namespace = "http://www.ibm.com/xmlns/prod/cics/events/CBE")
    private CicsPayloadData payloadData;
}

