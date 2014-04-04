package com.collaba.management.util;

import java.io.File;
import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.Enumeration;
//import java.util.Hashtable;
import java.util.Properties;

public class ApplicationProperties extends Properties

{
   
	private static final long serialVersionUID = 1L;



private static ApplicationProperties instance = null;



   Properties props =new Properties();


private ApplicationProperties() {}


public static ApplicationProperties getInstance() {


if  (instance == null ) {

	instance =  new  ApplicationProperties();

}

	return instance;

}

    public Properties getPropertyFile(String propertyFile)
        throws Exception
    {
       if (!new File(propertyFile).exists()) {

		System.out.println("Null");
          return null;
        }



        FileInputStream fis = new FileInputStream(propertyFile);

        if (fis != null) {

            props.load(fis);


            fis.close();
        }

        return props;
    }



 public  Object setProperty(String key, String value) {

         return props.put(key,value);


  }


  Properties getProperties() {

	  return props;
  }


 public String getProperty(String key) {

    return (String)props.get(key);

}

public static void main(String[] args)  {

    
                try {
            ApplicationProperties prop = ApplicationProperties.getInstance();
            Properties p = prop.getPropertyFile(".\\properties\\AppConfiguration.properties");
            System.out.println((String)p.get("url") );
            System.out.println(p.get("database"));


                	}

		   catch(Exception ex){}

}


}
