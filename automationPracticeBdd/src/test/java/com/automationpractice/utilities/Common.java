package com.automationpractice.utilities;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * October, 27 2019
 * @author TechCenture
 *
 */
public final class Common {
	
	private static Logger logger = Logger.getLogger(Common.class);
	
	private Common () {}
	
	public static void sleep(int seconds) {
		try {
			int secondsSleep = seconds * 1000;
			Thread.sleep(secondsSleep);
			logger.info("sleep for " + secondsSleep + " seconds");
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void deleteFiles ( String directoryPath ) {
		File file = new File(System.getProperty("user.dir") + directoryPath);
		if ( file.exists() ) {
			for ( File file1 : file.listFiles() ) {
				boolean isFileDeleted = file1.delete();
				if ( isFileDeleted ) System.out.println("File \"" + file1.toPath().getFileName() 
						+ "\" deleted");
				else System.out.println("File \"" + file1.toPath().getFileName()
						+ "\" not deleted");
			}
		}
	}
	
	public static void failTest ( String errorMessage ) {
		throw new RuntimeException(errorMessage);
	}
}