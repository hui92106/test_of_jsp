/**
 * @Title: IntangibleAssetBO.java
 * @Copyright (C) 2016 龙图软件
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016-1-7  董晖
 */

package gov.mof.fasp2.gcfr.baseset.intangibleasset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.longtu.framework.daosupport.RecordSet;
import com.longtu.framework.exception.AppException;
import com.longtu.framework.util.JsonUtils;

import gov.mof.fasp2.gcfr.common.GcfrBO;
import gov.mof.fasp2.gcfr.util.SqlUtil;

/**
 * @ClassName: IntangibleAssetBO
 * @Description: Description of this class
 * @author <a href="mailto:donghui@szlongtu.com">董晖</a>于 2016-1-7 下午1:58:48
 */

public class IntangibleAssetBO extends GcfrBO {
	
    /**
     * fixedAssetDao.
     */
    @Resource(name = "gcfr.baseset.intangibleasset.IntangibleAssetDAO")
    private IntangibleAssetDAO intangibleAssetDAO = null;

    /**
     * @throws IOException 
     * 根据type获取所有固定资产数据.
     * @return - 数据
     * @throws
     */
    public RecordSet getData() throws IOException {
    	List<Map<String, Object>> dataList = this.intangibleAssetDAO.queryByType();
    	RecordSet dataRecordSet = JsonUtils.ListToRecordSet(dataList);
    	return dataRecordSet;
    }

    /**
     * 对应保存按钮，数据的新增，修改，删除.
     * @param map - Map<String, Object>
     * @throws AppException - AppException
     * @throws
     */
    @SuppressWarnings("unchecked")
    public void saveAsset(Map<String, Object> map) throws AppException {
       
    	List<Map<String, Object>> insertList = (List<Map<String, Object>>) map.get("insertAsset");
        List<Map<String, Object>> updateList = (List<Map<String, Object>>) map.get("updateAsset");
        List<Map<String, Object>> delList = (List<Map<String, Object>>) map.get("delAsset");
        
        List<Map<String, Object>> updateMap = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> insertMap = new ArrayList<Map<String, Object>>();
        List<String> delMap = new ArrayList<String>();

        if ( null != insertList && insertList.isEmpty()) {
            for (Map<String, Object> map1 : insertList) {
                map1.put("guid", SqlUtil.createGUID());
                map1.put("type", "1");
                insertMap.add(map1);
            }
            this.intangibleAssetDAO.insertFixedAsset(insertMap);
        }
        
        if (null != updateList && updateList.isEmpty()) {
            for (Map<String, Object> map2 : updateList) {
                updateMap.add((Map<String, Object>) map2.get("nowData"));
            }
            this.intangibleAssetDAO.updateFixedAsset(updateMap);
        }
        
        if (null != delList && delList.isEmpty()) {
            for (Map<String, Object> map3 : delList) {
                delMap.add((String) map3.get("guid"));
            }
            this.intangibleAssetDAO.delFixedAsset(delMap);
        }
    }
}
