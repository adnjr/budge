package spring;

import net.armandoprojects.budgettracker.MainPackageMarker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** @author The Man */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = MainPackageMarker.class)
public class BudgetConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalEntityManagerFactoryBean lemfb = new LocalEntityManagerFactoryBean();
		lemfb.setPersistenceUnitName("budgetPU");
		return lemfb;
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}

	@Bean
	public PlatformTransactionManager declarativeTransactionManager() {
		return new JpaTransactionManager(entityManagerFactoryBean().getObject());
	}

//	@Bean BeanPostProcessor persistenceExceptionTranslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
//	@Bean
//	public Transaction singularTransaction(Jerry initiator, Armando target) {
//		return new SingularTransaction(initiator, target, 20L);
//	}
}
