package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.base.BaseClass;

public class PropertiesUtility extends BaseClass {

	FileInputStream fis = null;
	//1. Why we need utility --> read property file
	//2. what are inputs --> key
	//3. what are outputs --> value
	
	//User should get a proper error message if he use a invalid key
	public String readProperty(String key) {
			Properties prop = new Properties();
		try {
			log.info("reading property file for key: "+key);
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("property value found");
		if(prop.getProperty(key)!=null)			
			return prop.getProperty(key);	//previously only added this line of code, but in reviews you will get comment that this is not 
											//complete code as null pointer exception will occur, so added if statement
		else 
			return "property value not found for " + key;
	}	//readProperty("jbk"); --> nullPointerException 
	
}
