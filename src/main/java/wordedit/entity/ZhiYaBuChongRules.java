package wordedit.entity;

import java.util.Date;

public class ZhiYaBuChongRules {
	int mode;//0-新增；1-替换
	//鉴于
	String date1;//补充协议签署时间
	String date2;//质押协议签署时间
	
	String head_no;//质押协议编号
	String head_clause;//"鉴于"中引用的协议条款
	
	//第二条
	Boolean hasCunDan;//
	Boolean hasCunKuan;
	Boolean hasDingQi;
	
	int cunDanOrder;
	int cunKuanOrder;
	int DingQiOrder;
	//2.1 存单
//	String cunDanClause;
//	String cunDanName;
//	String cunDanNo;
//	String cundanDate;
//	String cundanValue;
	String clause21;
	
	//2.2 存款
//	String cunKuanClause;
//	String cunKuanName;
//	String cunKuanNo;
//	String cunKuanValue;
	String clause22;
	
	//2.3 定期存款
//	String dingQiNo;
//	String dingQiClause;
//	String no23;
	String clause23;
	
	//3.1
	String no_31;
	
	Boolean hasCunKuan3;
	Boolean hasCunDan3;
	Boolean hasDingQi3;
	
	String cunkuanren;
	String currency;
	String value;
	
	String beginDate31;//存款期限起
	String endDate31;	//存款期限止
	
//	String cunKuanName311;
	String cunKuanNo311;
//	String cunKuanValue311;
//	
//	String cunDanName312;
	String cunDanNo312;
//	String cunDanDate312;s
//	String cunDanValue312;
//	
//	String dingQiName313;
	String dingQiNo313;
//	String dingQiDate313;
//	String dingQiValue313;
	
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

	public String getCunKuanNo311() {
		return cunKuanNo311;
	}

	public void setCunKuanNo311(String cunKuanNo311) {
		this.cunKuanNo311 = cunKuanNo311;
	}

	public String getCunDanNo312() {
		return cunDanNo312;
	}

	public void setCunDanNo312(String cunDanNo312) {
		this.cunDanNo312 = cunDanNo312;
	}

	public String getDingQiNo313() {
		return dingQiNo313;
	}

	public void setDingQiNo313(String dingQiNo313) {
		this.dingQiNo313 = dingQiNo313;
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



	public String getHead_no() {
		return head_no;
	}

	public void setHead_no(String head_no) {
		this.head_no = head_no;
	}

	public String getHead_clause() {
		return head_clause;
	}

	public void setHead_clause(String head_clause) {
		this.head_clause = head_clause;
	}

	public String getNo_31() {
		return no_31;
	}

	public void setNo_31(String no_31) {
		this.no_31 = no_31;
	}

	public String getCunkuanren() {
		return cunkuanren;
	}

	public void setCunkuanren(String cunkuanren) {
		this.cunkuanren = cunkuanren;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getBeginDate31() {
		return beginDate31;
	}

	public void setBeginDate31(String beginDate31) {
		this.beginDate31 = beginDate31;
	}

	public String getEndDate31() {
		return endDate31;
	}

	public void setEndDate31(String endDate31) {
		this.endDate31 = endDate31;
	}

	public String getClause21() {
		return clause21;
	}

	public void setClause21(String clause21) {
		this.clause21 = clause21;
	}

	public String getClause22() {
		return clause22;
	}

	public void setClause22(String clause22) {
		this.clause22 = clause22;
	}

	public String getClause23() {
		return clause23;
	}

	public void setClause23(String clause23) {
		this.clause23 = clause23;
	}



}
