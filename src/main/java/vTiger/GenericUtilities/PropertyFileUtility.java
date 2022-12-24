package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//comment
/*comment*/
/**
 * This class contains generic method related to property file
 * @author alwin
 *
 */
public class PropertyFileUtility {
	


	/**
	 * This generic method will read
	 * @param key
	 * @return 
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.PropertyFilePath);
		Properties pObj= new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}

}
