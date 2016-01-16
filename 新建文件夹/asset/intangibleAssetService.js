if (Ext.lt.gcfr == null) {
	Ext.lt.gcfr = {};
}
if (Ext.lt.gcfr.baseset == null) {
	Ext.lt.gcfr.baseset = {};
}

// 供组件初始化时调用的方法.
Ext.lt.gcfr.baseset.intangibleAssetService = function(config, service) {
	Ext.lt.gcfr.baseset.serviceid = service;
}

// 保存方法.修改新增的数据一起传到后台
Ext.lt.gcfr.baseset.saveasset = function() {
	var isTrue = Ext.lt.gcfr.baseset.check();//对表格数据进行校验
	if(isTrue){
		var newData = Ext.lt.gcfr.baseset.groupAsset();//获取操作过的数据
		if (newData!= null){
			Ext.lt.RCP.call(Ext.lt.gcfr.baseset.serviceid, "saveBtn", [ newData ],
					function(resp) {
				if (resp) {
					Ext.lt.ui.alert(resp.msg);
					uidatatable.setRecordset(resp.tableData);//重置表格数据
					uidatatable.inittempcache();//清除缓存
					uidatatable.reflash();//刷新
				}
			});
		}
	}
}

// 数据分组
Ext.lt.gcfr.baseset.groupAsset = function() {
	var newData = {};
	var insertAsset = {}; // 记录新增操作的科目
	var updateAsset = {}; // 记录修改操作的科目
	var delAsset = {};
	
	insertAsset = uidatatable.getAddData();
	updateAsset = uidatatable.getUpdataData();
	delAsset = uidatatable.getRemoveData();
	
//	for ( var m = 0; m < insertAsset.length; m++) {
//		insertAsset[m].type = '1';//新增添加type属性
//	}
	
	newData.insertAsset = insertAsset;
	newData.updateAsset = updateAsset;
	newData.delAsset = delAsset;
	
	if(insertAsset.length == 0 && updateAsset.length == 0 && delAsset == 0){
		Ext.lt.ui.alert("未进行任何操作！");
		return;
	}
	return newData;
}

// 保存前对列表区数据的校验。
Ext.lt.gcfr.baseset.check = function() {
	var allData = uidatatable.getRecordset().toArray();//列表区所有数据
	
	for(var i = 0 , j = allData.length ; i < j ; i++){
		var codeData =  parseInt(allData[i].code);
		
		if ( null == allData[i].code || '' == allData[i].code ){
			Ext.lt.ui.alert("第"+(i+1)+"行编码为空，请修改！");
			return false;
		}
		if ( null == allData[i].name || '' == allData[i].name ){
			Ext.lt.ui.alert("第"+(i+1)+"行名称为空，请修改！");
			return false;
		}
		if( codeData < 0 || codeData > 99 || isNaN(codeData)){
			Ext.lt.ui.alert("第"+(i+1)+"行编码错误，必须为2位正整数，请修改！");
			return false;
		}
		else{
			for (var m = 0 ; m < i ; m++){
				if ( allData[i].code == allData[m].code ){
					Ext.lt.ui.alert("第"+(i+1)+"行编码与第"+(m+1)+"编码重复，请修改！");
					return false;
				}
				if ( allData[i].name == allData[m].name ){
					Ext.lt.ui.alert("第"+(i+1)+"行名称与第"+(m+1)+"名称重复，请修改！");
					return false;
				}
			}
		}
	}
	return true;
}


// 删除行
Ext.lt.message.hook("delRow", "uidatatable", function(editdatatable) {
	if (editdatatable.getSelected().size() == 0) {
		Ext.lt.ui.alert("请选择要删除的数据!");
		return;
	}
	
	var selected = editdatatable.getSelected();
	
	if (confirm("删除后,请点击保存！")) {
		var selected = uidatatable.getSelected();
		
		uidatatable.removeData(selected);
		uidatatable.reflash();
	}
});

// 添加行
Ext.lt.message.hook("addRow", "uidatatable", function(editdatatable) {
	var ret = {};
	var codeData = eval(uidatatable.getRecordset().toJSON());// 获取所有列表数据
	var len = codeData.length;// 数据长度
	var NewCode = 1;//新增编码从1开始
	var CodeSort =new Array();//编码进行排序
	var CodeIsNotNaN = new Array();//去除值为NaN的编码
	ret.guid = "";
	ret.type = "";
	
	//提取编码，转换成数组
	for(var i=0 ; i < len ; i++){
		CodeSort[i]=parseInt(codeData[i].code);
	}
	
	//去除NaN值
	for(var i=0,j=0; i < CodeSort.length ; i++){
		if(!isNaN(CodeSort[i])){
			CodeIsNotNaN[j]=CodeSort[i];
			j++;
		}
	}
	
	//排序
	CodeIsNotNaN.sort(function(a,b){return a>b?1:-1});
	
	//code赋值
	for(var i=0 ; i <= CodeIsNotNaN.length ; i++){
		var oldCode = CodeIsNotNaN[i];
		if(NewCode >= oldCode){
			NewCode++;
		}else{
			if(NewCode<10){
				ret.code = '0'+NewCode.toString();//个位数补零
			}
			else{
				ret.code = NewCode.toString();
			}
			break;
		}
	}
	
	editdatatable.addData(ret);
	editdatatable.reflash();
});


// 加载完页面后执行的方法.
$(function() {
	Ext.lt.RCP.call(Ext.lt.gcfr.baseset.serviceid, "queryByType", null,
			function(resp) {
		if (resp) {
			uidatatable.setRecordset(resp.tableData);//重置表格数据
			uidatatable.inittempcache();//清除缓存
			uidatatable.reflash();//刷新
		}
	});
});

// 导入
Ext.lt.gcfr.baseset.importasset = function() {
	alert("导入");
}

// 导出
Ext.lt.gcfr.baseset.exportasset = function() {
	alert("导出");
}
