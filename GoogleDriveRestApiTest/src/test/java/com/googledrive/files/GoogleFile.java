package com.googledrive.files;

public class GoogleFile {
	 private String kind;
	 private String id;
	 private String name;
	 private String mimeType;


	 // Getter Methods 

	 public String getKind() {
	  return kind;
	 }

	 public String getId() {
	  return id;
	 }

	 public String getName() {
	  return name;
	 }

	 public String getMimeType() {
	  return mimeType;
	 }

	 // Setter Methods 

	 public void setKind(String kind) {
	  this.kind = kind;
	 }

	 public void setId(String id) {
	  this.id = id;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setMimeType(String mimeType) {
	  this.mimeType = mimeType;
	 }
	}