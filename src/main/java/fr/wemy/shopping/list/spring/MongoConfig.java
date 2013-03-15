package fr.wemy.shopping.list.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@ComponentScan({ "fr.wemy.shopping.list.persistence" })
@EnableMongoRepositories(basePackages = "fr.wemy.shopping.list.repositories")
@PropertySource({ "classpath:mongo.properties" })
public class MongoConfig extends AbstractMongoConfiguration {

	private Environment env;

	@Autowired
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}

	@Override
	protected String getDatabaseName() {
		return env.getProperty("databaseName");
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Mongo(env.getProperty("host"));
	}
}
