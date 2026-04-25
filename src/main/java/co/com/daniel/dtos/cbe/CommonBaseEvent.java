package co.com.daniel.dtos.cbe;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@RegisterForReflection
@XmlRootElement(name = "CommonBaseEvent", namespace = "http://www.ibm.com/AC/commonbaseevent1_0_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonBaseEvent {

    @XmlAttribute
    private String version;

    @XmlAttribute
    private String creationTime;

    @XmlElement(name = "event", namespace = "http://www.ibm.com/xmlns/prod/cics/events/CBE")
    private CicsEvent event;
}

