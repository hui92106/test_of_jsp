package com.gcfr.dh;
/**
 * 数据库里面的字段
 * @author Administrator
 *
 */
public class DHModel {
	private String guid;
	private Integer code;
	private String name;
	private Integer type;
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "DHModel [guid=" + guid + ", code=" + code + ", name=" + name
				+ ", type=" + type + "]";
	}
}
