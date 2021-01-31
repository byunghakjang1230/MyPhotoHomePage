package com.jbh.util.domain.insta;

import java.util.List;

public class InstaDTO {

	private Pagination pagination;
	private List<Data> data;
	private Meta meta;
	
	public void setPagination(Pagination pagination) { this.pagination = pagination; }
	public void setData(List<Data> data) { this.data = data; }
	public void setMeta(Meta meta) { this.meta = meta; }
	
	public Pagination getPagination() { return this.pagination; }
	public List<Data> getData() { return this.data; }
	public Meta getMeta() { return this.meta; }
	
	public String toString() {
		return "InstaDTO [pagination="+this.pagination+", data="+this.data+", meta="+this.meta+"]";
	}
	
}
