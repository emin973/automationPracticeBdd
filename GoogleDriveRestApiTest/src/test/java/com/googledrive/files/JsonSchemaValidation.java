package com.googledrive.files;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;

public class JsonSchemaValidation extends APIBase{
	
	private String fileId="1Y3VeMGcHFXfAS19mG9jKOWwXOTrVYeh2";
	
	@Test
	public void verifyFileResponseAginstSchema() {
		Response response = getRequest().get("/drive/v3/files/"+fileId);
		System.out.println(response.asString());
		response.then().assertThat().body(matchesJsonSchema(new File("C:\\Users\\TechCenture\\git\\restassured\\GoogleDriveRestAPITest\\src\\test\\resources\\GoogleDriveJsonSchema.json")));
	}

}