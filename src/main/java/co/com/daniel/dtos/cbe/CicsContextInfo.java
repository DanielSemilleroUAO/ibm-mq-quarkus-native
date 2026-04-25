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
public class CicsContextInfo {

    private static final String NS = "http://www.ibm.com/xmlns/prod/cics/events/CBE";

    @XmlElement(name = "eventname", namespace = NS)
    private String eventname;

    @XmlElement(name = "timestamp", namespace = NS)
    private String timestamp;

    @XmlElement(name = "bindingname", namespace = NS)
    private String bindingname;

    @XmlElement(name = "capturespecname", namespace = NS)
    private String capturespecname;
}

