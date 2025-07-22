package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "AllData")
	
	public String [][] AllDataProviders()
	{
		String fname = "/home/user/eclipse-workspace/RestAssured/TestData/testdata.xlsx";
		int ttlRowcnt = ReadExceldata.getRowCount(fname, "Sheet1");
		int ttlColcnt = ReadExceldata.getCellCount(fname, "Sheet1");
		String userData[][] = new String[ttlRowcnt-1][ttlColcnt];
		for(int rowno = 1; rowno<ttlRowcnt;rowno++)
		{
			for(int colno = 0; colno<ttlColcnt; colno++)
			{
				userData[rowno-1][colno] = ReadExceldata.getCellValue(fname, "Sheet1", rowno, colno);
			}
		}
		return userData;
	}
		@DataProvider(name = "usernamedata")
		public String [] usernamedata()
		{
			String fname = "/home/user/eclipse-workspace/RestAssured/TestData/testdata.xlsx";
			int ttlRowcnt = ReadExceldata.getRowCount(fname, "Sheet1");
			String userName[] = new String[ttlRowcnt-1];
			for(int rowno = 1; rowno<ttlRowcnt;rowno++)
			{
				userName[rowno-1] = ReadExceldata.getCellValue(fname, "Sheet1", rowno, 1);
			}
		
	
		return userName;
		
	}

}
