package wordedit.entity;

public class ZhiYaBuChongRules {
	int mode;//0-新增；1-替换
	//鉴于
	String buChongDate;//补充协议签署时间,XX年XX月XX日
	String zhiYaDate;//质押协议签署时间
	String zhiYaNo;//质押协议编号
	String clause0;//"鉴于"中引用的协议条款
	
	//第二条
	Boolean hasCunDan;//
	Boolean hasCunKuan;
	Boolean hasDingQi;
	
	int cunDanOrder;
	int cunKuanOrder;
	int DingQiOrder;
	//2.1 存单
	String cunDanClause;
	String cunDanName;
	String cunDanNo;
	String cundanDate;
	String cundanValue;
	
	//2.2 存款
	String cunKuanClause;
	String cunKuanName;
	String cunKuanNo;
	String cunKuanValue;
	
	//2.3 定期存款
	String dingQiNo;
	String dingQiClause;
	
	//3.1
	Boolean hasCunKuan3;
	Boolean hasCunDan3;
	Boolean hasDingQi3;
	
	String cunKuanName311;
	String cunKuanNo311;
	String cunKuanValue311;
	
	String cunDanName312;
	String cunDanNo312;
	String cunDanDate312;
	String cunDanValue312;
	
	String dingQiName313;
	String dingQiNo313;
	String dingQiDate313;
	String dingQiValue313;
	
	//3.4
	Boolean has34;
	
	//第4条
	String clause41;
	String clause42;
	
	//签署页
	String chuzhiren;//出质人名称

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public String getBuChongDate() {
		return buChongDate;
	}

	public void setBuChongDate(String buChongDate) {
		this.buChongDate = buChongDate;
	}

	public String getZhiYaDate() {
		return zhiYaDate;
	}

	public void setZhiYaDate(String zhiYaDate) {
		this.zhiYaDate = zhiYaDate;
	}

	public String getZhiYaNo() {
		return zhiYaNo;
	}

	public void setZhiYaNo(String zhiYaNo) {
		this.zhiYaNo = zhiYaNo;
	}

	public String getClause0() {
		return clause0;
	}

	public void setClause0(String clause0) {
		this.clause0 = clause0;
	}

	public Boolean getHasCunDan() {
		return hasCunDan;
	}

	public void setHasCunDan(Boolean hasCunDan) {
		this.hasCunDan = hasCunDan;
	}

	public Boolean getHasCunKuan() {
		return hasCunKuan;
	}

	public void setHasCunKuan(Boolean hasCunKuan) {
		this.hasCunKuan = hasCunKuan;
	}

	public Boolean getHasDingQi() {
		return hasDingQi;
	}

	public void setHasDingQi(Boolean hasDingQi) {
		this.hasDingQi = hasDingQi;
	}

	public int getCunDanOrder() {
		return cunDanOrder;
	}

	public void setCunDanOrder(int cunDanOrder) {
		this.cunDanOrder = cunDanOrder;
	}

	public int getCunKuanOrder() {
		return cunKuanOrder;
	}

	public void setCunKuanOrder(int cunKuanOrder) {
		this.cunKuanOrder = cunKuanOrder;
	}

	public int getDingQiOrder() {
		return DingQiOrder;
	}

	public void setDingQiOrder(int dingQiOrder) {
		DingQiOrder = dingQiOrder;
	}

	public String getCunDanClause() {
		return cunDanClause;
	}

	public void setCunDanClause(String cunDanClause) {
		this.cunDanClause = cunDanClause;
	}

	public String getCunDanName() {
		return cunDanName;
	}

	public void setCunDanName(String cunDanName) {
		this.cunDanName = cunDanName;
	}

	public String getCunDanNo() {
		return cunDanNo;
	}

	public void setCunDanNo(String cunDanNo) {
		this.cunDanNo = cunDanNo;
	}

	public String getCundanDate() {
		return cundanDate;
	}

	public void setCundanDate(String cundanDate) {
		this.cundanDate = cundanDate;
	}

	public String getCundanValue() {
		return cundanValue;
	}

	public void setCundanValue(String cundanValue) {
		this.cundanValue = cundanValue;
	}

	public String getCunKuanClause() {
		return cunKuanClause;
	}

	public void setCunKuanClause(String cunKuanClause) {
		this.cunKuanClause = cunKuanClause;
	}

	public String getCunKuanName() {
		return cunKuanName;
	}

	public void setCunKuanName(String cunKuanName) {
		this.cunKuanName = cunKuanName;
	}

	public String getCunKuanNo() {
		return cunKuanNo;
	}

	public void setCunKuanNo(String cunKuanNo) {
		this.cunKuanNo = cunKuanNo;
	}

	public String getCunKuanValue() {
		return cunKuanValue;
	}

	public void setCunKuanValue(String cunKuanValue) {
		this.cunKuanValue = cunKuanValue;
	}

	public String getDingQiNo() {
		return dingQiNo;
	}

	public void setDingQiNo(String dingQiNo) {
		this.dingQiNo = dingQiNo;
	}

	public String getDingQiClause() {
		return dingQiClause;
	}

	public void setDingQiClause(String dingQiClause) {
		this.dingQiClause = dingQiClause;
	}

	public Boolean getHasCunKuan3() {
		return hasCunKuan3;
	}

	public void setHasCunKuan3(Boolean hasCunKuan3) {
		this.hasCunKuan3 = hasCunKuan3;
	}

	public Boolean getHasCunDan3() {
		return hasCunDan3;
	}

	public void setHasCunDan3(Boolean hasCunDan3) {
		this.hasCunDan3 = hasCunDan3;
	}

	public Boolean getHasDingQi3() {
		return hasDingQi3;
	}

	public void setHasDingQi3(Boolean hasDingQi3) {
		this.hasDingQi3 = hasDingQi3;
	}

	public String getCunKuanName311() {
		return cunKuanName311;
	}

	public void setCunKuanName311(String cunKuanName311) {
		this.cunKuanName311 = cunKuanName311;
	}

	public String getCunKuanNo311() {
		return cunKuanNo311;
	}

	public void setCunKuanNo311(String cunKuanNo311) {
		this.cunKuanNo311 = cunKuanNo311;
	}

	public String getCunKuanValue311() {
		return cunKuanValue311;
	}

	public void setCunKuanValue311(String cunKuanValue311) {
		this.cunKuanValue311 = cunKuanValue311;
	}

	public String getCunDanName312() {
		return cunDanName312;
	}

	public void setCunDanName312(String cunDanName312) {
		this.cunDanName312 = cunDanName312;
	}

	public String getCunDanNo312() {
		return cunDanNo312;
	}

	public void setCunDanNo312(String cunDanNo312) {
		this.cunDanNo312 = cunDanNo312;
	}

	public String getCunDanDate312() {
		return cunDanDate312;
	}

	public void setCunDanDate312(String cunDanDate312) {
		this.cunDanDate312 = cunDanDate312;
	}

	public String getCunDanValue312() {
		return cunDanValue312;
	}

	public void setCunDanValue312(String cunDanValue312) {
		this.cunDanValue312 = cunDanValue312;
	}

	public String getDingQiName313() {
		return dingQiName313;
	}

	public void setDingQiName313(String dingQiName313) {
		this.dingQiName313 = dingQiName313;
	}

	public String getDingQiNo313() {
		return dingQiNo313;
	}

	public void setDingQiNo313(String dingQiNo313) {
		this.dingQiNo313 = dingQiNo313;
	}

	public String getDingQiDate313() {
		return dingQiDate313;
	}

	public void setDingQiDate313(String dingQiDate313) {
		this.dingQiDate313 = dingQiDate313;
	}

	public String getDingQiValue313() {
		return dingQiValue313;
	}

	public void setDingQiValue313(String dingQiValue313) {
		this.dingQiValue313 = dingQiValue313;
	}

	public Boolean getHas34() {
		return has34;
	}

	public void setHas34(Boolean has34) {
		this.has34 = has34;
	}

	public String getClause41() {
		return clause41;
	}

	public void setClause41(String clause41) {
		this.clause41 = clause41;
	}

	public String getClause42() {
		return clause42;
	}

	public void setClause42(String clause42) {
		this.clause42 = clause42;
	}

	public String getChuzhiren() {
		return chuzhiren;
	}

	public void setChuzhiren(String chuzhiren) {
		this.chuzhiren = chuzhiren;
	}

}
