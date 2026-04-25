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
public class AccountBasicInfoPayload {

    private static final String NS = "http://www.ibm.com/prod/cics/BasicAccountInfoCreatedOrUpdated";

    @XmlElement(name = "Ctl1", namespace = NS)
    private String ctl1;

    @XmlElement(name = "Ctl2", namespace = NS)
    private String ctl2;

    @XmlElement(name = "Ctl3", namespace = NS)
    private String ctl3;

    @XmlElement(name = "Ctl4", namespace = NS)
    private String ctl4;

    @XmlElement(name = "AccountNumber", namespace = NS)
    private String accountNumber;

    @XmlElement(name = "Status", namespace = NS)
    private String status;

    @XmlElement(name = "ProductType", namespace = NS)
    private String productType;

    @XmlElement(name = "FloatAmount", namespace = NS)
    private Double floatAmount;

    @XmlElement(name = "AvailAmount", namespace = NS)
    private Double availAmount;

    @XmlElement(name = "CurrentBalance", namespace = NS)
    private Double currentBalance;
}

