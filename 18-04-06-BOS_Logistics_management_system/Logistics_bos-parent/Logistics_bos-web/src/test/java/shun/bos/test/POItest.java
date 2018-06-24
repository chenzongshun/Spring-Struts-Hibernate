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
* @version ����ʱ�䣺2018��4��16�� ����6:47:02 
* ��������pio����excle�ļ�
*/
public class POItest {
	
	@Test
	/**
	 * pio����excle�ļ�
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void PoiTest() throws FileNotFoundException, IOException{
		String projectPath = System.getProperty("user.dir");								// �����Ŀ·��
		String exclePath = projectPath + "\\src\\test\\resources\\�������������.xls"; 			// �����Ŀ��excle�ļ���ȫ·��
		HSSFWorkbook excle = new HSSFWorkbook(new FileInputStream(new File(exclePath)));	// ��װһ��excle�ļ�����
		HSSFSheet sheet = excle.getSheetAt(0); 			// excle�ļ��ײ�������sheet�������������õ�һ��sheet
		for (Row row : sheet) {							// ���ÿһ������
			System.out.println();
			for (Cell cell : row) {						// ���ÿһ���ı�
				System.out.print(cell + "\t\t");		// ��ӡÿһ���ı������� tab
			}
		}
		excle.close();
	}
}
