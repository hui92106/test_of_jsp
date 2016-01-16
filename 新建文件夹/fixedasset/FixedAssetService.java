/**
 * @Title: FixedAssetService.java
 * @Copyright (C) 2016 龙图软件
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016-1-7  董晖
 */

package gov.mof.fasp2.gcfr.baseset.fixedasset;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.longtu.framework.annotation.PageComponent;
import com.longtu.framework.exception.AppException;
import com.longtu.framework.server.AbstractPageService;

/**
 * @ClassName: FixedAssetService
 * @Description: Description of this class
 * @author <a href="mailto:donghui@szlongtu.com">董晖</a>于 2016-1-7 下午2:00:01
 */
@PageComponent(serviceid = "gcfr.baseset.fixedasset.FixedAssetService", viewid = "gcfr.baseset.fixedasset.FixedAssetService", jsLib = "/gcfr/baseset/asset/fixedAssetService.js", jsObjectName = "Ext.lt.gcfr.baseset.fixedAssetService")
public class FixedAssetService extends AbstractPageService {
    /**
     * @param FixedAssetBO
     */
    @Resource(name = "gcfr.baseset.fixedasset.FixedAssetBO")
    private FixedAssetBO fixedAssetBO = null;

    /**
     * 加载后数据.
     * <p>Title: loadComponent</p>
     * <p>Description: </p>
     * @param request - HttpServletRequest
     * @param response - HttpServletResponse
     * @param config - Map
     * @return rawtypes
     * @throws Exception - Exception
     * @see com.longtu.framework.component.AbstractComponentService#loadComponent(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.util.Map)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Map loadComponent(HttpServletRequest request, HttpServletResponse response, Map config) throws Exception {

        return config;
    }

    /**
     * @throws IOException -异常
     * 保存方法.
     * @param map - HashMap<String, Object>
     * @return Map<String, Object>
     * @throws AppException - AppException
     * @throws
     */
    public Map<String, Object> saveBtn(HashMap<String, Object> map) throws AppException, IOException {
        String msg = "";
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            this.fixedAssetBO.saveAsset(map);
            msg = "保存成功！";
        } catch (AppException e) {
            msg = "保存失败！";
        }
        returnMap.put("msg", msg);
        returnMap.put("tableData" , this.fixedAssetBO.getData());
        return returnMap;
    }
    
    public Map<String, Object> getTableData() throws IOException {
    	Map<String, Object> tableData = new HashMap<String, Object>();
    	tableData.put("tableData", this.fixedAssetBO.getData());
		return tableData;
	}
}
