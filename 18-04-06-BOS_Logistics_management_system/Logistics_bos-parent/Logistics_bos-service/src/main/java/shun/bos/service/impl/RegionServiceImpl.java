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
* @version 创建时间：2018年4月16日 下午9:46:19 
*/
@Service
@Transactional
public class RegionServiceImpl implements IRegionService {

	@Autowired
	private IRegionDao regionDao;

	@Override
	public void saveMatch(File uploadXlsFile) throws FileNotFoundException, IOException {
		HSSFWorkbook excle = new HSSFWorkbook(new FileInputStream(uploadXlsFile));	// 准备excle文件
		HSSFSheet sheet = excle.getSheet("sheet1"); 			// 获得sheet
		for (Row row : sheet) {
			if (row.getRowNum() != 0) {							// 0列是标题行，所以不要将标题存入数据库
				String id = row.getCell(0).toString();
				String province = row.getCell(1).toString();
				String city = row.getCell(2).toString();
				String district = row.getCell(3).toString();
				String postcode = row.getCell(4).toString();
//				 * shortcode    简码        varchar(30),
//				 * citycode     城市编码        varchar(30)
//				 * set 			xx集合，目前这几个都没有，所以下面实例化的时候就暂时设置为
				BcRegion region = new BcRegion(id, province, city, district, postcode, null, null, null);
				
				/*使用pinyin4j*/
				// 截取去掉省、市、区这几个字
				province = province.substring(0, province.length() - 1);
				city = city.substring(0, city.length() - 1);
				district = district.substring(0, district.length() - 1);

				// 获得到即将转换成拼音的数据
				String info = province + city + district;

				// 获得区域简码的数组
				String[] regionShortCodeArray = PinYin4jUtils.getHeadByString(info);
				// 拼装区域简码
				StringBuffer regionShortCode = new StringBuffer();
				for (String string : regionShortCodeArray) {
					regionShortCode.append(string);
				}
				
				// 获得城市编码的数组
				String[] chenshiCodeArray = PinYin4jUtils.stringToPinyin(city);
				// 拼装城市编码
				StringBuffer chenshiCode = new StringBuffer();
				for (String string : chenshiCodeArray) {
					chenshiCode.append(string);
				}
				
				// 记得要在实例化之后再set两个码进去
				region.setShortcode(regionShortCode.toString());
				region.setCitycode(chenshiCode.toString());
				
				regionDao.saveOrUpdate(region);					// 保存对象到数据库
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
