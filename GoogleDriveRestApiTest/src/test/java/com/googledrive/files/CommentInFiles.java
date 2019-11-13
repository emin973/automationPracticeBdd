package com.googledrive.files;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommentInFiles extends APIBase{
	
	@Test
	public void getCommentFromAFile() {
		Response response= getRequest().queryParam("fields", "*").get("drive/v3/files/1OYmWr1cQoTRE_yCjv1N0wAggGIdegLrF/comments/AAAADvOzsuA");
		System.err.println(response.asString());
	}
	@Test
	public void createAComment() {
		String json = "{\"content\":\"my first comment\"}";
		
		Response response=getRequest()
		.queryParam("fields", "*")
		.contentType(ContentType.JSON)
		.body(json)
		.post("/drive/v3/files/1fslwcmD8JmP0ZvJqf2UxoSgWIvWyk1dQ/comments");
		System.err.println(response.asString());
		Assert.assertEquals(response.path("content"), "my first comment");
		
		deleteAComment("1fslwcmD8JmP0ZvJqf2UxoSgWIvWyk1dQ", response.path("id"));
		
		
	}
	
	public void deleteAComment(String fileId, String commentId) {
		Response response=getRequest().delete("drive/v3/files/"+fileId+"/comments/"+commentId);
		System.err.println(response.asString());
		Assert.assertEquals(response.getStatusCode(), 204);
	}
}