/**
 * @Title: FixedAssetPage.java
 * @Copyright (C) 2016 龙图软件
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016-1-7  董晖
 */

package gov.mof.fasp2.gcfr.baseset.fixedasset;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.longtu.framework.annotation.PageComponent;
import com.longtu.framework.annotation.PageConsole;
import com.longtu.framework.annotation.PageTemplate;
import com.longtu.framework.server.AbstractPageService;

/**
 * @ClassName: FixedAssetPage
 * @Description: Description of this class
 * @author <a href="mailto:donghui@szlongtu.com">董晖</a>于 2016-1-7 下午1:52:39
 */

public class FixedAssetPage extends AbstractPageService {
    /**
     * 固定资产.
     * @param request - HttpServletRequest
     * @param response - HttpServletResponse.
     * @param config - Map.
     * @return Map
     * @throws Exception - 异常
     */
    @SuppressWarnings("rawtypes")
    @PageConsole(appid = "gcfr", url = "/gcfr/fixedasset", page = "/gcfr/template/gcfr_default.jsp", config = "{header:[gcfrheader, gcfrmenu, toolbuttonbar],"
            + "main:[uidatatable]}", pageTempltate = @PageTemplate(funcShow = "Ext.lt.gcfr.template"), region = "maindiv", component = {
            @PageComponent(serviceid = "busfwtoolbutton", id = "toolbuttonbar", config = "{querybanner:false,background:false}"),
            @PageComponent(serviceid = "busfwuidatatable", id = "uidatatable", config = "{title:'固定资产类别',checkbox:true,edit:true}"),
            @PageComponent(serviceid = "gcfr.common.component.gcfrheader", id = "gcfrheader"),
            @PageComponent(serviceid = "gcfr.common.component.gcfrmenu", id = "gcfrmenu"),
            @PageComponent(serviceid = "gcfr.baseset.fixedasset.FixedAssetService", id = "gcfr_baseset_fixedasset_FixedAssetService") })
    public Map fixedAsset(HttpServletRequest request, HttpServletResponse response, Map config) throws Exception {
        return config;
    }
}
