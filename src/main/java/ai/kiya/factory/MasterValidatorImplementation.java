package ai.kiya.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@PropertySource("classpath:validator.properties")
//@ConfigurationProperties(prefix = "mastercombo")
public class MasterValidatorImplementation {

	@Autowired
	private List<MasterValidator> masterValidatorsList;

	private Map<String, String> propmap = new HashMap<String, String>();

	public Map<String, String> getPropmap() {
		return propmap;
	}
	public void setPropmap(Map<String, String> propmap) {
		this.propmap = propmap;
	}
	
	private static final Map<String, MasterValidator> handler = new HashMap<String, MasterValidator>();

	@PostConstruct
	private void initMap() {
		masterValidatorsList.stream().forEach(masters -> handler.put(masters.getMasterType(), masters));
//		for (Map.Entry<String, String> entry : propmap.entrySet()) {
//			if (null!=entry.getValue()) {
//				
//				MasterValiList.stream().forEach(masters -> handler.put(entry.getValue(),masters));
//				//MasterValiList.stream().forEach(masters -> handler.put(masters.getMasterType(), masters));
//				
//			}
//
//	}
	}
	public static MasterValidator createInstance(String masters) {
		
//		  if (null != handler.get(masters) ) {
//				return handler.get(masters);
//
//		        
//		    }
//		  else {
//			 System.out.println("hiiiii");
//			   new IllegalArgumentException("Invalid masters");
//		  }
		
		
		return Optional.ofNullable(handler.get(masters))
				.orElseThrow(() -> new IllegalArgumentException("Invalid masters"));
		
		
	}

	

}
