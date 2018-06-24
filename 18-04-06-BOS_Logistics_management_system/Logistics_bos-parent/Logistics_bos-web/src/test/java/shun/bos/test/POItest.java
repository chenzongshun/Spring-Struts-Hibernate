package shun.bos.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

/**
* @author czs
* @version 创建时间：2018年4月16日 下午6:47:02 
* 用来测试pio解析excle文件
*/
public class POItest {
	
	@Test
	/**
	 * pio解析excle文件
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void PoiTest() throws FileNotFoundException, IOException{
		String projectPath = System.getProperty("user.dir");								// 获得项目路径
		String exclePath = projectPath + "\\src\\test\\resources\\区域导入测试数据.xls"; 			// 获得项目中excle文件的全路径
		HSSFWorkbook excle = new HSSFWorkbook(new FileInputStream(new File(exclePath)));	// 包装一个excle文件对象
		HSSFSheet sheet = excle.getSheetAt(0); 			// excle文件底部不是有sheet吗？这就是用来获得第一个sheet
		for (Row row : sheet) {							// 获得每一行数据
			System.out.println();
			for (Cell cell : row) {						// 获得每一格文本
				System.out.print(cell + "\t\t");		// 打印每一格文本并两个 tab
			}
		}
		excle.close();
	}
}
