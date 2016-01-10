package com.gcfr.asset;

import java.util.List;

import com.gcfr.dh.DHModel;

public class DHService {
	DHBO db = new DHBO();
	public void save(List<DHModel>dm) {
		for (DHModel dhModel : dm) {
			db.insert(dhModel);
			db.edit(dhModel);
			db.query();
			db.del(dhModel.getGuid());
		}

	}
}
