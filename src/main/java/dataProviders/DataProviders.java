/**
 * 
 */
package dataProviders;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;


import util.XLUtility;

/**
 * @author Jeevan
 *
 */
public class DataProviders {
String path="C:\\Users\\DELL\\git\\Avactisv10\\src\\main\\java\\TestData\\TestData.xlsx";
	XLUtility obj= new XLUtility(path);


	@DataProvider(name = "credentials")
	public Object[][] getCredentials() throws IOException {
		// Totals rows count
		int rows = obj.getRowCount("credentials");
		// Total Columns
		int column = obj.getCellCount("credentials",1);
	

		Object[][] data = new Object[rows][column];

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < column; j++) {
				data[i-1][j] = obj.getCellData("credentials", i, j);
			}
		}
		return data;
	}


	}


