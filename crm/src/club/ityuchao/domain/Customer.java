package club.ityuchao.domain;

public class Customer {

	/*`cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '�ͻ����(����)',
  `cust_name` varchar(32) NOT NULL COMMENT '�ͻ�����(��˾����)',
  `cust_user_id` bigint(32) DEFAULT NULL COMMENT '������id',
  `cust_create_id` bigint(32) DEFAULT NULL COMMENT '������id',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '�ͻ���Ϣ��Դ',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '�ͻ�������ҵ',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '�ͻ�����',
  `cust_linkman` varchar(64) DEFAULT NULL COMMENT '��ϵ��',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '�̶��绰',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '�ƶ��绰',
  PRIMARY KEY (`cust_id`)*/
	private Integer cust_id;
	private String cust_name;
	private Integer cust_user_id;
	private Integer cust_create_id;
	
	//private String cust_source;
	//private String cust_industry;
	//private String cust_level;
	
	private BaseDict cust_source;
	private BaseDict cust_industry;
	private BaseDict cust_level;
	
	private String cust_linkman;
	private String cust_phone;
	private String cust_mobile;
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Integer getCust_user_id() {
		return cust_user_id;
	}
	public void setCust_user_id(Integer cust_user_id) {
		this.cust_user_id = cust_user_id;
	}
	public Integer getCust_create_id() {
		return cust_create_id;
	}
	public void setCust_create_id(Integer cust_create_id) {
		this.cust_create_id = cust_create_id;
	}
	public BaseDict getCust_source() {
		return cust_source;
	}
	public void setCust_source(BaseDict cust_source) {
		this.cust_source = cust_source;
	}
	public BaseDict getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(BaseDict cust_industry) {
		this.cust_industry = cust_industry;
	}
	public BaseDict getCust_level() {
		return cust_level;
	}
	public void setCust_level(BaseDict cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	
}
