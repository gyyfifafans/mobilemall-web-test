package module;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class dealExcelPOI {
	private POIFSFileSystem fs ;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell cell = null;
	//init
	
	public Map<Integer,ArrayList<String>> readExcel(InputStream is) throws IOException{
		//Map<Integer,String> content =new HashMap<Integer,String>();
		Map<Integer,ArrayList<String>> content = new HashMap<Integer,ArrayList<String>>();//
		//List 是接口
		ArrayList<String> childData = new ArrayList<String>();
	
		String str= "";
		String str1 = "";
		try{
		wb = new HSSFWorkbook(new POIFSFileSystem(is));
		} catch(IOException e){
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		//需要行的对象，去获取列数
		row = sheet.getRow(0);
		//printTest(rowNum);
		int colNum = row.getPhysicalNumberOfCells();
		//printTest(sheet.getSheetName());
		//printTest(colNum);
	

		
		
		//---------------------
		// 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 0; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
                // str += getStringCellValue(row.getCell((short) j)).trim() +
                // "-";
                //str += getCellFormatValue(row.getCell((short) j)).trim() + "    ";
                str1 = getCellFormatValue(row.getCell((short) j)).trim();
                childData.add(str1);
                j++;
                
            }
            content.put(i, childData);
            
        }
        return content;
    }
	
	public void printTest(Object a){
		System.out.println(a);
	}
	
	Map<Integer,HashMap<String,String>> list = new HashMap<>();
	//---------------------
	private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
                System.out.println(cell.getColumnIndex());
            }
        } else {
            cellvalue = "";
            
        }
        return cellvalue;

    }
	



	public static void main (String[]args) throws IOException{
		File f = new File("F:/android_shop_testcase1_3.xls");
		if (f.exists()) System.out.println("exist");
		InputStream in = new FileInputStream(new File("F:/android_shop_testcase1_3.xls"));
		dealExcelPOI deal =new dealExcelPOI();
		Map<Integer,ArrayList<String>> s = deal.readExcel(in);
		//ArrayList<String> str = new ArrayList<String>();
		
 
		//--------------------- 
		for (Map.Entry<Integer, ArrayList<String>> entry : s.entrySet()) {
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    
		    //System.out.println((entry.getValue()).getClass().toString());
			for (int i=0;i<(entry.getValue()).size();i++){
				System.out.print(entry.getKey()+(entry.getValue()).get(i));
			}
			

		}
		//for(String tmp:str){
		//	System.out.println(num+tmp);
			
		//}
		
		
		
	}

}
