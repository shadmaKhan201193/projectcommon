package ai.kiya.factory;

import java.util.Map;

public interface CommonValidator {
	public Object getBySearchDetails(String master,Map<String,String> params) throws Exception;
	

}
