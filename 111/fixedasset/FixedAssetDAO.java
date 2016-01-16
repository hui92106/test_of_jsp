/**
 * @Title: FixedAssetDAO.java
 * @Copyright (C) 2016 龙图软件
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016-1-7  董晖
 */

package gov.mof.fasp2.gcfr.baseset.fixedasset;

import java.util.List;
import java.util.Map;

import com.longtu.framework.exception.AppException;

import gov.mof.fasp2.gcfr.common.GcfrDAO;

/**
 * @ClassName: FixedAssetDAO
 * @Description: Description of this class
 * @author <a href="mailto:donghui@szlongtu.com">董晖</a>于 2016-1-7 下午1:59:34
 */

public class FixedAssetDAO extends GcfrDAO {
    /**
     * ASSETCLASS表格.
     */
    private static final String ASSETCLASS = "GCFR_T_ASSETCLASS";

    /**
     * 批量删除方法.
     * @param guid - guid数组
     * @throws AppException - AppException
     * @throws
     */
    public void delFixedAsset(List<String> guid) throws AppException {
            this.evictAllGUID(guid, ASSETCLASS);
    }

    /**
     * 批量新增方法，增加guid.
     * @param list - list
     * @throws AppException - AppException
     * @throws
     */
    public void insertFixedAsset(List<Map<String, Object>> list) throws AppException {
        this.batchInsertData(list, ASSETCLASS);
    }

    /**
     * 批量修改方法.
     * @param map - map.
     * @throws AppException - AppException
     * @throws
     */
    public void updateFixedAsset(List<Map<String, Object>> map) throws AppException {
        this.updateAll(map, ASSETCLASS);
    }
    /**
     * 查询语句.
     * @return sql
     * @throws
     */
    @SuppressWarnings("unchecked")
	public List<Map<String , Object>> queryByType() {
        String sql = "select lpad(code,'2','0')as code,name,guid,type from " 
        		+ ASSETCLASS + " where type ='1' order by code";
        List<Map<String, Object>> queryList = this.queryForList(sql);
        return queryList;
    }
}