package br.com.intelector.api.config;

import javax.activation.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
		
	private Logger log = LoggerFactory.getLogger(DevConfig.class);
	
	@Bean
    public DataSource getDataSource() {
		DataSource ds = null;
        try {
			log.info("DataSource: dev");
			//InitialContext context = new InitialContext();
            //ds = (DataSource) context.lookup("jdbc/seuLockUp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
	
}
