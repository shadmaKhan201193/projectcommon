package ai.kiya.service.base;

import javax.persistence.EntityManager;

public interface NGService<Long, E> {

	public void setEntityManagerOnDao(EntityManager entityManager);

	//public E saveOrUpdate(String loginId, E entity) throws NGException;
}
