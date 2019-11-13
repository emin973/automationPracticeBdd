package com.googledrive.files;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class FilesTestCases extends APIBase{
	
	
	@Test
	//TODO
	public void deleteAllFiles() {
		Response response = getRequest().get("drive/v3/files/");
		System.err.println(response.asString());
		
		
		List<String> fileIds=response.path("files.id");
		
		for(String f:fileIds) {
//			System.out.println(f);
			deleteAFile(f);
		}
		
		System.out.println(fileIds);
	}
	
	@Test
	public void getSingleFile() {
		Response response = getRequest().get("/drive/v3/files/1sKx7d08szupZ0snfcFJqgJ7HWgsGRZEI");
//		Assert.assertEquals(response.path("name"), "fileToTestComment.pdf");
	}
	
	
	@DataProvider(name = "getFilesData")
	public String[][] getTestFiles(){
		return new String[][]{
			{"C:\\Users\\TechCenture\\Desktop\\postman\\google drive demo\\pdfFileMetaData.json","C:\\Users\\TechCenture\\Desktop\\postman\\google drive demo\\myPdfFile.pdf","application/pdf"},
			{"C:\\Users\\TechCenture\\Desktop\\postman\\google drive demo\\textFileMetaData.json","C:\\Users\\TechCenture\\Desktop\\postman\\google drive demo\\myTextFile.txt","plain/text"},
			{"C:\\Users\\TechCenture\\Desktop\\postman\\google drive demo\\pngFileMetaData.json","C:\\Users\\TechCenture\\Desktop\\postman\\google drive demo\\myPngImage.png","image/png"},
			{"C:\\Users\\TechCenture\\Desktop\\postman\\google drive demo\\jpgFileMetaData.json","C:\\Users\\TechCenture\\Desktop\\postman\\google drive demo\\myJpgImage.jpg","image/jpg"}
		};
	}
	
	@Test(dataProvider = "getFilesData")
	public void uploadFileWithMetaData(String metaDataFile, String fileToUpload, String fileMimeType) {
		
		File metaData = new File(metaDataFile);
		File pdfFile = new File(fileToUpload);
		
		String fileName = fileToUpload.split("\\\\")[6];
		
		Response response = getRequest()
				.header("Content-Type", "multipart/form-data")
				.multiPart("",metaData,"application/json")
				.multiPart("", fileToUpload, fileMimeType)
		
				
				
				.post("/upload/drive/v3/files");
		
		System.err.println(response.asString());
		String id = response.path("id");
		String name = response.path("name");;
		String mimeType = response.path("mimeType");
		
		

		Assert.assertEquals(name, fileName);
		 Assert.assertNotNull(id); 
		 Assert.assertEquals(mimeType, fileMimeType);
		 
		//cleanup
//		response=getRequest().delete("drive/v3/files/"+id);
//		System.err.println(response.getStatusCode());
		
	}
	
	@Test(enabled = true)
	public void getAllFiles() {
		//Construct request
		String responseAsString=
		
		getRequest()
		.get("/drive/v3/files")
		
		.body().asString();
		
		System.err.println(responseAsString);
		
	}
	@Test(enabled = false)
	public void getAllFiles_verify_status_code() {
		//Construct request
		
		
		getRequest()
		
		.get("/drive/v3/files")
		
		.then().statusCode(200);
		
		
		
	}
	@Test(enabled = false)
	public void getAllFiles_verify_json_data() {
		//Construct request
		getRequest()
		
		.get("/drive/v3/files")
		
		.then().body("files[0].name", equalTo("My_File--33"));
		
		
		
	}
	
	@Test(enabled = false)
	public void getAllFiles_verify_has_json_data() {
		//Construct request
		getRequest()
		
		.get("/drive/v3/files")
		
		.then().body("files.name", hasItems("My_File--33","my test file--3"));
		
		
		
		
	}
	
	public void getSingleFile(String fileId) {
		String response=getRequest().get("drive/v3/files/"+fileId).body().asString();
		System.err.println("File ID Retrieved:\n"+ response);
	}
	
	@Test(enabled = false)
	public void getAllFiles_get_files_and_then_get_first_file() {
		//Construct request
		String fileId=getRequest().get("/drive/v3/files").body().path("files[0].id");
		String name=getRequest().get("/drive/v3/files").body().path("files[0].name");
		
		System.out.println("Retrieving file: "+name+", id: "+fileId);
		
		getSingleFile(fileId);
		
		
		
		
	}
	@Test(enabled = false)
	public void deleteAFile(String fileId) {
		//Construct request
		int responseStatusCode=
				
				getRequest()
		.delete("/drive/v3/files/"+fileId)
		
		.statusCode();
		
		System.err.println(responseStatusCode);
		
	}
	
	
}