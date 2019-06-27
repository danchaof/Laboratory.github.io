package ay.laboratory.domain;

import java.util.List;

public class PageBean<T> {
	private int pc;//当前页
	private int tr;//总记录数
	private int ps;//每页显示几条数据
	private int tp;//总页数
	private String url;
	private List<T> beanlist;

	public List<T> getBeanlist() {
		return this.beanlist;
	}

	public void setBeanlist(List<T> beanlist) {
		this.beanlist = beanlist;
	}

	public int getPc() {
		return this.pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getTr() {
		return this.tr;
	}

	public void setTr(int tr) {
		this.tr = tr;
	}

	public int getPs() {
		return this.ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public int getTp() {
		return this.tp;
	}

	public void setTp(int tp) {
		this.tp = tp;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String toString() {
		return "PageBean [pc=" + this.pc + ", tr=" + this.tr + ", ps=" + this.ps + ", tp=" + this.tp + ", url="
				+ this.url + "]";
	}
}