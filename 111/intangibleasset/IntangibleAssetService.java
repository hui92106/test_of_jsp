/**
 * @Title: IntangibleAssetService.java
 * @Copyright (C) 2016 龙图软件
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016-1-7  董晖
 */

package gov.mof.fasp2.gcfr.baseset.intangibleasset;

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
 * @ClassName: IntangibleAssetService
 * @Description: Description of this class
 * @author <a href="mailto:donghui@szlongtu.com">董晖</a>于 2016-1-7 下午2:00:01
 */
@PageComponent(serviceid = "gcfr.baseset.intangibleasset.IntangibleAssetService", viewid = "gcfr.baseset.intangibleasset.IntangibleAssetService", jsLib = "/gcfr/baseset/asset/intangibleAssetService.js", jsObjectName = "Ext.lt.gcfr.baseset.intangibleAssetService")
public class IntangibleAssetService extends AbstractPageService {
    /**
     * @param IntangibleAssetBO
     */
    @Resource(name = "gcfr.baseset.intangibleasset.IntangibleAssetBO")
    private IntangibleAssetBO intangibleAssetBO = null;

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
            this.intangibleAssetBO.saveAsset(map);
            msg = "保存成功！";
        } catch (AppException e) {
            msg = "保存失败！";
        }
        returnMap.put("msg", msg);
        returnMap.put("tableData" , this.intangibleAssetBO.getData());
        return returnMap;
    }
    
    public Map<String, Object> getTableData() throws IOException {
    	Map<String, Object> tableData = new HashMap<String, Object>();
    	tableData.put("tableData", this.intangibleAssetBO.getData());
		return tableData;
	}
}
