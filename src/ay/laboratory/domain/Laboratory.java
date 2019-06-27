package ay.laboratory.domain;

/**
 * @author ZPX
 *
 */
public class Laboratory {
	private String name;
	private String sex;
	private String zy;
	private String bm;
	private String xh;
	private String tel;
	private String jn;
	private String nl;
	private String uid;

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getZy() {
		return this.zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getBm() {
		return this.bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJn() {
		return this.jn;
	}

	public void setJn(String jn) {
		this.jn = jn;
	}

	public String getNl() {
		return this.nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	@Override
	public String toString() {
		return "Laboratory [name=" + name + ", sex=" + sex + ", zy=" + zy + ", bm=" + bm + ", xh=" + xh + ", tel=" + tel
				+ ", jn=" + jn + ", nl=" + nl + ", uid=" + uid + "]";
	}



	
}