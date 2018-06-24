package shun.bos.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import shun.bos.domain.BcRegion;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��16�� ����9:45:11 
*/
public interface IRegionService {

	/**
	 * �������excle�ļ�������ӵ����ݿ�
	 * @param uploadXlsFile
	 * @throws 
	 * @throws FileNotFoundException 
	 */
	void saveMatch(File uploadXlsFile) throws FileNotFoundException, IOException;

	/**
	 * ΪeasyUi�����ݱ��׼�����������
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * Ϊsubarea.jspҳ��combox׼���������ݣ����ص�jsonҪ���������id
	 * @return
	 */
	List<BcRegion> getListRegionShort();

	/**
	 * ����������������ͻ�����combox����д���˶������������������ɸѡ��������
	 * @param q
	 * @return
	 */
	List<BcRegion> getListRegionByQ(String q);

}
