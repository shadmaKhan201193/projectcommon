package ai.kiya.factory;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.base.Base;
import ai.kiya.base.Base2;
import ai.kiya.entity.AuthRequestVO;
import ai.kiya.omni.OmniConstants;

@Service
public class CalculatorFactory {
	
	@Autowired
	ObjectMapper objectMapper;

	@Value("${authService.Url}")
	private String Url;

	public void mapBaseObj(Object entity, String mode, String master) throws Exception {

		Date dt = new Date();

		Boolean baseInstance = entity instanceof Base;
		Boolean base2Instance = entity instanceof Base2;

		if (baseInstance) {
			Base base = (Base) entity;
			if (mode == OmniConstants.DELETE) {
				base.setLastModifiedBy("login2");
				base.setLastModifiedDate(dt);
				base.setLastModifiedTime(dt);
				base.setCreatedBy("login");
				base.setCreatedDate(dt);
				base.setCreatedTime(dt);
				base.setDeprecatedBy("login2");
				base.setDeprecatedDate(dt);
				base.setDeprecatedTime(dt);
				base.setAuthStatus("D");
				base.setIsActive(0);
				base.setDeprecated(Boolean.TRUE);
			}
			if (mode == OmniConstants.AUTH_AUTHORIZED) {
				base.setLastModifiedBy("login3");
				base.setLastModifiedDate(dt);
				base.setLastModifiedTime(dt);
				base.setIsActive(1);
				base.setDeprecated(Boolean.FALSE);

//				String responce = objectMapper.writeValueAsString(entity);
//				JsonNode parent = objectMapper.readTree(responce);
//				Integer tenantId = Integer.valueOf(parent.path("tenantId").asText());

				if (StringUtils.isEmpty(base.getAuthChecker1())) {
					base.setAuthChecker1("login1");
					base.setAuthCheckerDate1(dt);
				} else if (!StringUtils.isEmpty(base.getAuthChecker1())
						&& StringUtils.isEmpty(base.getAuthChecker2())) {
					base.setAuthChecker2("login2");
					base.setAuthCheckerDate2(dt);
				} else if (!StringUtils.isEmpty(base.getAuthChecker1()) && !StringUtils.isEmpty(base.getAuthChecker2())
						&& StringUtils.isEmpty(base.getAuthChecker3())) {
					base.setAuthChecker3("login2");
					base.setAuthCheckerDate3(dt);
				}
				AuthRequestVO authRequestVO = new AuthRequestVO();
//				authRequestVO.setTenantId(tenantId);
				authRequestVO.setMaster(master);
				authRequestVO.setAuthChecker1(base.getAuthChecker1());
				authRequestVO.setAuthChecker2(base.getAuthChecker2());
				authRequestVO.setAuthChecker3(base.getAuthChecker3());

				HttpEntity<AuthRequestVO> httpEntity = new HttpEntity<AuthRequestVO>(authRequestVO);
				//ResponseEntity<?> rersponse = restTemplate.exchange(Url, HttpMethod.POST, httpEntity, Boolean.class);
//				if (true) {
					base.setAuthStatus(OmniConstants.AUTH_AUTHORIZED);
//				} else {
//					base.setAuthStatus(OmniConstants.AUTH_PENDING);
//				}

			}
			if (mode == OmniConstants.CREATE || mode == OmniConstants.UPDATE) {

				base.setCreatedBy("login");
				base.setCreatedDate(dt);
				base.setCreatedTime(dt);
				base.setLastModifiedBy("login");
				base.setLastModifiedDate(dt);
				base.setLastModifiedTime(dt);
				base.setAuthStatus(OmniConstants.AUTH_PENDING);
				base.setIsActive(1);
				base.setDeprecated(Boolean.FALSE);
			}
			if (mode == OmniConstants.REJECT) {

				base.setCreatedBy("login");
				base.setCreatedDate(dt);
				base.setCreatedTime(dt);
				base.setLastModifiedBy("login");
				base.setLastModifiedDate(dt);
				base.setLastModifiedTime(dt);
				base.setAuthStatus(OmniConstants.AUTH_REJECTED);
				base.setIsActive(1);
				base.setDeprecated(Boolean.FALSE);
			}
		}

		else if (base2Instance) {
			Base2 base = (Base2) entity;
			if (mode == OmniConstants.DELETE) {
				base.setLastModifiedBy("login2");
				base.setLastModifiedDate(dt);
				base.setLastModifiedTime(dt);
				base.setCreatedBy("login");
				base.setCreatedDate(dt);
				base.setCreatedTime(dt);
				base.setDeprecatedBy("login2");
				base.setDeprecatedDate(dt);
				base.setDeprecatedTime(dt);
			}
			if (mode == OmniConstants.AUTH_AUTHORIZED) {

				base.setCreatedBy("login3");
				base.setCreatedDate(dt);
				base.setCreatedTime(dt);
				base.setLastModifiedBy("login3");
				base.setLastModifiedDate(dt);
				base.setLastModifiedTime(dt);

			}
			if (mode == OmniConstants.CREATE || mode == OmniConstants.UPDATE) {

				base.setCreatedBy("login");
				base.setCreatedDate(dt);
				base.setCreatedTime(dt);
				base.setLastModifiedBy("login");
				base.setLastModifiedDate(dt);
				base.setLastModifiedTime(dt);

			}
		}

	}
}
