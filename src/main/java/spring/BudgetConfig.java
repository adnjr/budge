package spring;

import net.armandoprojects.budgettracker.MainPackageMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** @author The Man */
@Configuration
@ComponentScan(basePackageClasses = MainPackageMarker.class)
public class BudgetConfig {

//	@Bean
//	public Transaction singularTransaction(Jerry initiator, Armando target) {
//		return new SingularTransaction(initiator, target, 20L);
//	}
}
