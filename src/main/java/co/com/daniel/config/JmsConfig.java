package co.com.daniel.config;

import com.ibm.msg.client.jakarta.jms.JmsConstants;
import com.ibm.msg.client.jakarta.jms.JmsFactoryFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;

import static com.ibm.msg.client.jakarta.jms.JmsConstants.USER_AUTHENTICATION_MQCSP;
import static com.ibm.msg.client.jakarta.wmq.common.CommonConstants.WMQ_APPLICATIONNAME;
import static com.ibm.msg.client.jakarta.wmq.common.CommonConstants.WMQ_CHANNEL;
import static com.ibm.msg.client.jakarta.wmq.common.CommonConstants.WMQ_CLIENT_RECONNECT_TIMEOUT;
import static com.ibm.msg.client.jakarta.wmq.common.CommonConstants.WMQ_CM_CLIENT;
import static com.ibm.msg.client.jakarta.wmq.common.CommonConstants.WMQ_CONNECTION_MODE;
import static com.ibm.msg.client.jakarta.wmq.common.CommonConstants.WMQ_CONNECTION_NAME_LIST;
import static com.ibm.msg.client.jakarta.wmq.common.CommonConstants.WMQ_QUEUE_MANAGER;


@ApplicationScoped
public class JmsConfig {

    @Inject
    MqProperties config;

    @Produces
    public ConnectionFactory connectionFactory() throws JMSException {
        var result = JmsFactoryFactory.getInstance(JmsConstants.JAKARTA_WMQ_PROVIDER).createConnectionFactory();
        result.setIntProperty(WMQ_CONNECTION_MODE, WMQ_CM_CLIENT);
        result.setStringProperty(WMQ_QUEUE_MANAGER, config.queueManager());
        result.setStringProperty(WMQ_CHANNEL, config.channel());
        result.setStringProperty(WMQ_CONNECTION_NAME_LIST, config.connectionName());
        result.setStringProperty(WMQ_APPLICATIONNAME, config.applicationName());
        result.setIntProperty(WMQ_CLIENT_RECONNECT_TIMEOUT, config.timeout());
        result.setBooleanProperty(USER_AUTHENTICATION_MQCSP, false);
        return result;
    }

}
