package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.entity.SeqFileGen;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({"rawtypes","unchecked"})
public class Sequence implements MasterValidator {
	
	@Autowired
	ObjectMapper objectMapper;
	
	Mapper mapper = new DozerBeanMapper();
	String str = "";

	// SeqKey seqKey=new SeqKey();
	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		SeqFileGen seq = null;
		SeqFileGen seq123 = null;
		try {
			seq = objectMapper.readValue(masterjson.getBytes(), SeqFileGen.class); // object convert

			seq123 = (SeqFileGen) jpaRepository.getClass().getMethod("findByBranchCode", String.class)
					.invoke(jpaRepository, seq.getBranchCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(seq, seq123);
		return seq123;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		SeqFileGen convertedObj = null;
		SeqFileGen sequence = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
																							// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), SeqFileGen.class);
			errors = new BindException(convertedObj, "SeqFileGen");
			sequence = (SeqFileGen) jpaRepository.getClass().getMethod("findByBranchCode", String.class)
					.invoke(jpaRepository, convertedObj.getBranchCode());
			if (null != sequence) {
				errors.addError(new FieldError("SeqFileGen", "branchCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchCode", "branchCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "Sequence";
	}

	@Override
	public Object getById(String master, String seqId) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		SeqFileGen seq123 = null;
		seq123 = (SeqFileGen) jpaRepository.getClass().getMethod("findBySeqId", String.class).invoke(jpaRepository,
				seqId);
		return seq123;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		if (status == null) {
			return jpaRepository.findAll();
		} else {
			return jpaRepository.getClass().getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		}
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<SeqFileGen> seqList = (List<SeqFileGen>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return seqList.size();
	}

	@Override
	public Class getMasterClass() {

		return SeqFileGen.class;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		return null;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		Object masterObj = "";
		SeqFileGen seqObj = null;
		seqObj = objectMapper.readValue(masterjson.getBytes(), SeqFileGen.class);

		return seqObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<SeqFileGen> SeqFileGenList = (List<SeqFileGen>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return SeqFileGenList;
	}

	@Override
	public Object getByAuthActiveTenantIdCountryLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String languageCode) throws Exception {
		return null;
	}

	@Override
	public Object getByAuthActiveTenantCountryStateLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String languageCode) throws Exception {
		return null;
	}

	@Override
	public Object setChildkeyValue(Object obj, String mode) throws Exception {
		return obj;
	}

	@Override
	public Object getByAuthActiveTenantCountryStateCityLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String cityCode, String languageCode)
			throws Exception {
		return null;
	}

	@Override
	public Object getUserByTenantBranchRoleCode(String master, Integer tenantId, Integer branchCode, String roleCode)
			throws Exception {
		return null;
	}

	@Override
	public Object getByIdForAuth(String master, String masterjson) throws Exception {
		SeqFileGen seqFile = null;
		seqFile = objectMapper.readValue(masterjson.getBytes(), SeqFileGen.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		SeqFileGen seqFile2 = (SeqFileGen) jpaRepository.getClass().getMethod("findBySeqId", String.class)
				.invoke(jpaRepository, seqFile.getSeqId());

		return seqFile2;
	}

	
}
