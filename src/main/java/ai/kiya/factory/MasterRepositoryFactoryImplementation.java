package ai.kiya.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MasterRepositoryFactoryImplementation  {
	
	public static   JpaRepository getInstance(String masters) throws Exception {
		
		String cap = masters.substring(0, 1).toLowerCase() + masters.substring(1);
		 ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
		 return(JpaRepository) context.getBean(cap+"Repository");
		 
//		 Object object = context.getBean(cap+"Repository");
//	        System.out.println( "Bean object:" + object);
//	        String[] allBeanNames = context.getBeanDefinitionNames();
//	        for(String beanName : allBeanNames) {
//	        	
//	            System.out.println(beanName);
//	            
//	        }
//			return null;
	
	}

}
