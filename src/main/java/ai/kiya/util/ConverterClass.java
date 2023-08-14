package ai.kiya.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Component
@SuppressWarnings({"rawtypes","unchecked"})
public class ConverterClass {

	@Autowired
	ObjectMapper objMapper;

	public <T> T jsonStringToObject(Class<?> classname, String jsonStr) {
		Object object = null;
		Object object2 = null;
		Object returnValue = null;

		try {
			Gson gson = new Gson();

			object2 = (Object) gson.fromJson(jsonStr, classname);

			Field[] fields = classname.getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(EmbeddedId.class)) {

					returnValue = classname.newInstance();

					field.setAccessible(true);
					String retType = field.getType().getSimpleName();
					Class<?> fieldClass = field.getDeclaringClass();
					Class<?> fieldType = field.getType();
					object = (Object) gson.fromJson(jsonStr, fieldType);
					field.set(object2, object);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) object2;
	}

	public <T> T childTable(String Master, Object frontEndClass, Object dbClass) throws JsonProcessingException {
		String frontEndClassString = objMapper.writeValueAsString(frontEndClass);
		JpaRepository jpaRepository = null;
		Object obj = null;
		Object object2 = null;
		Object returnValue = null;
		try {
			Gson gson = new Gson();

			Field[] fields = ((Class<?>) dbClass.getClass()).getDeclaredFields();
			for (Field field : fields) {
//					 if (field.isAnnotationPresent(EmbeddedId.class)) {	    	  
//					    	
//				    	  field.setAccessible(true);
//				    	  
//				    	  Class<?> fieldClass = field.getDeclaringClass();
//				    	  dbClass = (Object) gson.fromJson(frontEndClassString, fieldClass);
//				    	  
//				    	  Class<?> fieldType = field.getType();
//				    	  List<Object> ui = (List<Object>) gson.fromJson(frontEndClassString, fieldType);
//				    	  
//				    	
//				    	   field.set(dbClass, ui);
//				    	   
//				      }
				if (field.isAnnotationPresent(ElementCollection.class)) {
					field.setAccessible(true);
					List<Object> objlist = (List<Object>) field.get(dbClass);
					objlist.clear();
					String retType = field.getType().getSimpleName();
					Class<?> fieldClass = field.getDeclaringClass();
					Class<?> fieldType = field.getType();
					object2 = (Object) gson.fromJson(frontEndClassString, fieldClass);
					List<Object> ui = (List<Object>) field.get(object2);
					field.set(dbClass, ui);
				}
				if (field.isAnnotationPresent((Class<? extends Annotation>) OneToMany.class)) {
					field.setAccessible(true);
					List<Object> objlist = (List<Object>) field.get(dbClass);
					objlist.clear();
					Class<?> fieldClass = field.getDeclaringClass();
					object2 = (Object) gson.fromJson(frontEndClassString, fieldClass);
					List<Object> ui = (List<Object>) field.get(object2);
					field.set(dbClass, ui);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) dbClass;

	}

	public <T> T getJsonToObject(Class<?> classname, String jsonStr) {
		Object object2 = null;

		try {
			Gson gson = new Gson();
			object2 = (Object) gson.fromJson(jsonStr, classname);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (T) object2;

	}
	

}
