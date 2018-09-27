package File;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FileHelper {

	 public Map<String, List<List<String>>> readExcel(String fileStr) throws IOException {
		
		 String filepath= FileHelper.class.getClassLoader().getResource(fileStr).getPath();
		 FileInputStream localFileInputStream = null;
		   Map localHashMap = new HashMap();
		    try
		    {
		      localFileInputStream = new FileInputStream(filepath);
		      Workbook localWorkbook = new XSSFWorkbook(localFileInputStream);
		      for (int i = 0; i < localWorkbook.getNumberOfSheets(); i++)
		      {
		        ArrayList localArrayList1 = new ArrayList();
		        Sheet localSheet = (Sheet) localWorkbook.getSheetAt(i);
		       
		        for (int j = 0; j < localSheet.getPhysicalNumberOfRows(); j++)
		        {
		          ArrayList localArrayList2 = new ArrayList();
		          Row localRow = localSheet.getRow(j);
//		          System.out.println(localRow.getPhysicalNumberOfCells());
		          for (int k = 0; k < localRow.getLastCellNum(); k++)
		          {
		            Cell localCell = localRow.getCell(k);
//		            System.out.println(localCell.getStringCellValue());
		            localArrayList2.add(localCell == null ? "" : localCell);
		          }
		          localArrayList1.add(localArrayList2);
		        }
		        localHashMap.put(localSheet.getSheetName(), localArrayList1);
		      }
		      return localHashMap;
		    }
		    finally
		    {
		      try
		      {
		        if (localFileInputStream != null) {
		          localFileInputStream.close();
		        }
		      }
		      catch (Exception localException2) {}
		    }
	    }
	 
	 public void readTxt(String txtstr) throws IOException {
		 String filepath= FileHelper.class.getClassLoader().getResource(txtstr).getPath();
		 FileInputStream localFileInputStream = null;
		 localFileInputStream = new FileInputStream(filepath);
		 BufferedReader bfr= new BufferedReader(new InputStreamReader(localFileInputStream));
		 String line="";
//		 line =bfr.readLine();
		 while((line =bfr.readLine())!=null) {
//			 line +="\n";
			 System.out.println(line);
			 String[] test= line.split("\\|");
			 System.out.println(test.length);
		 }
	 }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileHelper fh =new FileHelper();
//		Map result =fh.readExcel("buildingDetail_1523929909388.xlsx");
//		System.out.println(result);
		fh.readTxt("ACC_20180808.txt");
	}

}
