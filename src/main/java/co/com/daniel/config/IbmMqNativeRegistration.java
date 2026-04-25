package co.com.daniel.config;

import com.ibm.mq.MQJavaComponent;
import com.ibm.mq.jakarta.jms.MQJMSComponent;
import com.ibm.mq.jmqi.local.LocalClient;
import com.ibm.mq.jmqi.local.LocalServer;
import com.ibm.mq.jmqi.remote.api.RemoteFAP;
import com.ibm.msg.client.commonservices.componentmanager.ComponentManager;
import com.ibm.msg.client.commonservices.j2se.J2SEComponent;
import com.ibm.msg.client.jakarta.jms.internal.JMSComponent;
import com.ibm.msg.client.jakarta.jms.internal.JmsFactoryFactoryImpl;
import com.ibm.msg.client.jakarta.wmq.factories.WMQComponent;
import com.ibm.msg.client.jakarta.wmq.factories.WMQFactoryFactory;
import com.ibm.msg.client.jakarta.wmq.factories.admin.WMQJmsFactory;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(
        targets = {
                RemoteFAP.class,
                LocalClient.class,
                LocalServer.class,

                // JMS factory implementations
                JmsFactoryFactoryImpl.class,
                WMQFactoryFactory.class,
                WMQJmsFactory.class,

                // ComponentManager y componentes de IBM MQ (META-INF/compinfo.properties)
                ComponentManager.class,
                J2SEComponent.class,
                MQJavaComponent.class,
                MQJMSComponent.class,
                JMSComponent.class,
                WMQComponent.class
        },
        // Registrar también las clases internas anónimas de RemoteFAP
        classNames = {
                "com.ibm.mq.jmqi.remote.api.RemoteFAP$Connector",
                "com.ibm.mq.jmqi.remote.api.RemoteFAP$CcdtCacheLock",
                "com.ibm.mq.jmqi.remote.api.RemoteFAP$NameListDefinition",
                "com.ibm.mq.jmqi.remote.api.RemoteFAP$NameListLock",
                "com.ibm.mq.jmqi.remote.api.RemoteFAP$ReconnectThreadLock",
                "com.ibm.mq.jmqi.system.JmqiComponent",
                "com.ibm.mq.jmqi.system.JmqiComponentTls"
        }
)
public class IbmMqNativeRegistration {
}

