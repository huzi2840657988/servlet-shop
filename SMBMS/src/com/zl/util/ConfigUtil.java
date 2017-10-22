package com.zl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	
	private Properties pt  = null;

	private static ConfigUtil cfu = null;
	private ConfigUtil(){
		pt = new Properties();

		try {
			
			//InputStream is = new FileInputStream("src/db.properties");
			InputStream is = ConfigUtil.class.getResourceAsStream("/db.properties");
			pt.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//getInstance():
	public synchronized static ConfigUtil getInstance(){
		if(cfu==null){
			cfu = new ConfigUtil();
		}
		return cfu;
	}
	public String getPropertyValue(String key){
		return pt.getProperty(key);
	}
}
