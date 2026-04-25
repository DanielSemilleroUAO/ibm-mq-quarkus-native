package co.com.daniel.config;

import io.smallrye.config.ConfigMapping;

import static io.smallrye.config.ConfigMapping.NamingStrategy.VERBATIM;

@ConfigMapping(prefix = "ibm.mq", namingStrategy = VERBATIM)
public interface MqProperties {
    String queueManager();

    String channel();

    String connectionName();

    String applicationName();

    int timeout();
}
