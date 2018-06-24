package shun.bos.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shun.bos.dao.IRegionDao;
import shun.bos.domain.BcRegion;
import shun.bos.service.IRegionService;
import shun.bos.utils.PageBean;
import shun.bos.utils.PinYin4jUtils;

/** 
* @author czs
* @version ����ʱ�䣺2018��4��16�� ����9:46:19 
*/
@Service
@Transactional
public class RegionServiceImpl implements IRegionService {

	@Autowired
	private IRegionDao regionDao;

	@Override
	public void saveMatch(File uploadXlsFile) throws FileNotFoundException, IOException {
		HSSFWorkbook excle = new HSSFWorkbook(new FileInputStream(uploadXlsFile));	// ׼��excle�ļ�
		HSSFSheet sheet = excle.getSheet("sheet1"); 			// ���sheet
		for (Row row : sheet) {
			if (row.getRowNum() != 0) {							// 0���Ǳ����У����Բ�Ҫ������������ݿ�
				String id = row.getCell(0).toString();
				String province = row.getCell(1).toString();
				String city = row.getCell(2).toString();
				String district = row.getCell(3).toString();
				String postcode = row.getCell(4).toString();
//				 * shortcode    ����        varchar(30),
//				 * citycode     ���б���        varchar(30)
//				 * set 			xx���ϣ�Ŀǰ�⼸����û�У���������ʵ������ʱ�����ʱ����Ϊ
				BcRegion region = new BcRegion(id, province, city, district, postcode, null, null, null);
				
				/*ʹ��pinyin4j*/
				// ��ȡȥ��ʡ���С����⼸����
				province = province.substring(0, province.length() - 1);
				city = city.substring(0, city.length() - 1);
				district = district.substring(0, district.length() - 1);

				// ��õ�����ת����ƴ��������
				String info = province + city + district;

				// ���������������
				String[] regionShortCodeArray = PinYin4jUtils.getHeadByString(info);
				// ƴװ�������
				StringBuffer regionShortCode = new StringBuffer();
				for (String string : regionShortCodeArray) {
					regionShortCode.append(string);
				}
				
				// ��ó��б��������
				String[] chenshiCodeArray = PinYin4jUtils.stringToPinyin(city);
				// ƴװ���б���
				StringBuffer chenshiCode = new StringBuffer();
				for (String string : chenshiCodeArray) {
					chenshiCode.append(string);
				}
				
				// �ǵ�Ҫ��ʵ����֮����set�������ȥ
				region.setShortcode(regionShortCode.toString());
				region.setCitycode(chenshiCode.toString());
				
				regionDao.saveOrUpdate(region);					// ����������ݿ�
			}
		}
		excle.close();
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
	}

	@Override
	public List<BcRegion> getListRegionShort() {
		return regionDao.findAll();
	}

	@Override
	public List<BcRegion> getListRegionByQ(String q) {
		return regionDao.getListRegionByQ(q.trim());
	}
}
