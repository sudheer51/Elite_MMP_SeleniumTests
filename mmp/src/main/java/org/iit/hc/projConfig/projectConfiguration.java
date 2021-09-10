package org.iit.hc.projConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class projectConfiguration {
	
		
		public Properties loadProperties() throws IOException
		{
			Properties pro = new Properties();
			String fpath = "E:\\Selenium Training2\\Elite_MMP_SeleniumTests\\mmp\\config\\config.properties";
					
			InputStream fis = new FileInputStream(fpath);		
		
			pro.load(fis);
			return pro;
		}
		
	}


