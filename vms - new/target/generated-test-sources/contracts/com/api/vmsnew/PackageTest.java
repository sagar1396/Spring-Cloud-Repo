package com.api.vmsnew;

import com.api.vmsnew.VmsApplicationTests;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;

public class PackageTest extends VmsApplicationTests {

	@Test
	public void validate_contractVerifierTest() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json");

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("inputJson","REQ_28382020170712788")
					.post("/getRequirementDetailsApi");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
		// and:
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("{'code':0,'message':'Requirement Details','data':[{'req_prop_id':713,'req_prop_type':'Creator Comments','req_prop_key':'REQ_28382020170712788','req_prop_value':{'taskName':'approveComments','acceptFlag':'Yes','attachment':'null','commentMsg':'approved','reviewFlag':'No','attachments':'null','creatorName':'creator','rejectedFlag':'No','reviewerName':'null','requirementID':'REQ_28382020170712788','attachmentName':'null','reviewAcceptFlag':'Yes'},'created_by':'creator','created_date':'2020-07-28T12:08:13.080Z','updated_by':'creator','updated_date':'2020-07-28T12:12:16.963Z','req_id':'REQ_28382020170712788','req_name':'desc','req_creator':'creator','req_vendor':'vendor','req_status':'INACTIVE','req_instance_id':'02fdfea1-d0cb-11ea-b464-6c4b9099838d','req_defination_id':'vendor_management:1:7fb0256a-cc0e-11ea-bf6e-6c4b9099838d','req_reviewer':null,'req_serial':356,'closure_date':'2020-07-28T12:12:16.963Z','req_parent_instance_id':'02a1fbcd-d0cb-11ea-b464-6c4b9099838d','creator_email':'sringe@nseit.com','publish_remark':null,'publish_date':null,'publish_by':null},{'req_prop_id':710,'req_prop_type':'Vendor Comments','req_prop_key':'REQ_28382020170712788','req_prop_value':{'taskName':'provideComments','acceptFlag':'No','attachment':'','commentMsg':'ok','reviewFlag':'No','creatorName':'vendor','rejectedFlag':'No','requirementID':'REQ_28382020170712788','attachmentName':'','reviewAcceptFlag':'No'},'created_by':'creator','created_date':'2020-07-28T12:08:13.080Z','updated_by':'creator','updated_date':'2020-07-28T12:12:16.963Z','req_id':'REQ_28382020170712788','req_name':'desc','req_creator':'creator','req_vendor':'vendor','req_status':'INACTIVE','req_instance_id':'02fdfea1-d0cb-11ea-b464-6c4b9099838d','req_defination_id':'vendor_management:1:7fb0256a-cc0e-11ea-bf6e-6c4b9099838d','req_reviewer':null,'req_serial':356,'closure_date':'2020-07-28T12:12:16.963Z','req_parent_instance_id':'02a1fbcd-d0cb-11ea-b464-6c4b9099838d','creator_email':'sringe@nseit.com','publish_remark':null,'publish_date':null,'publish_by':null},{'req_prop_id':709,'req_prop_type':'Requirement Creation','req_prop_key':'REQ_28382020170712788','req_prop_value':{'dueDate':'Fri Aug 28 2020 00:00:00 GMT+0530 (India Standard Time)','assignTo':'vendor','priority':'5','taskName':'createRequirement','eventType':'Listing','initiator':'creator','createdDate':'Tue Jul 28 17:38:13 IST 2020','creatorName':'creator','requirementID':'REQ_28382020170712788','documentUpload':'','requirementType':'Marketing','requirementTitle':'reqnew','documentUploadName':'','requirementDetails':['Other'],'requirementDescription':'desc'},'created_by':'creator','created_date':'2020-07-28T12:08:13.080Z','updated_by':'creator','updated_date':'2020-07-28T12:12:16.963Z','req_id':'REQ_28382020170712788','req_name':'desc','req_creator':'creator','req_vendor':'vendor','req_status':'INACTIVE','req_instance_id':'02fdfea1-d0cb-11ea-b464-6c4b9099838d','req_defination_id':'vendor_management:1:7fb0256a-cc0e-11ea-bf6e-6c4b9099838d','req_reviewer':null,'req_serial':356,'closure_date':'2020-07-28T12:12:16.963Z','req_parent_instance_id':'02a1fbcd-d0cb-11ea-b464-6c4b9099838d','creator_email':'sringe@nseit.com','publish_remark':null,'publish_date':null,'publish_by':null}]}");
	}

}
