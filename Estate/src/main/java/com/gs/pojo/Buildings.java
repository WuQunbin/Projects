package com.gs.pojo;import java.util.Date;public class Buildings implements java.io.Serializable {	/**	 * 楼盘表	 */	private static final long serialVersionUID = 1L;	//field	/**编号  **/	private String id;	/**经销商编号  **/	private String agency_id;		/**名称  **/	private String name;	/**区域  **/	private String area;	/**地址  **/	private String address;	/**占地面积 **/	private Double floor_area;	/**建筑面积  **/	private Double building_area;	/**房源类型  **/	private String house_type;	/**建筑类型  **/	private String building_type;	/**经度  **/	private Double longitude;	/**纬度  **/	private Double latitude;	/**楼盘均价  **/	private Double avg_price;	/** 开发公司 **/	private String company;	/**开盘时间  **/	private Date open_date;	/**总套数  **/	private int total_rooms;	/**接待地址  **/	private String reception_address;	/**楼盘售楼电话  **/	private String tel;	/**绿化率  **/	private Double green_ratio;	/**容积率  **/	private Double plot_ratio;	/**物业公司  **/	private String property_company;	/**物业费  **/	private Double property_fee;	/**车位数  **/	private int car_station;	/**交通状况  **/	private String traffic;	/**周边配套  **/	private String equipments;	/**楼盘封面  **/	private String logo;	/**简介  **/	private String intro;	/**创建时间  **/	private Date created_time;	/**状态  **/	private String status;//	//配置楼盘与户型一对多关系//	private  Set<House> houses = new HashSet<House>();//	//	//	public Set<House> getHouses() {//		return houses;//	}//	public void setHouses(Set<House> houses) {//		this.houses = houses;//	}	//method	public String getId() {		return id;	}	public String getAgency_id() {		return agency_id;	}	public void setAgency_id(String agency_id) {		this.agency_id = agency_id;	}	public Double getFloor_area() {		return floor_area;	}	public void setFloor_area(Double floor_area) {		this.floor_area = floor_area;	}	public Double getBuilding_area() {		return building_area;	}	public void setBuilding_area(Double building_area) {		this.building_area = building_area;	}	public String getHouse_type() {		return house_type;	}	public void setHouse_type(String house_type) {		this.house_type = house_type;	}	public String getBuilding_type() {		return building_type;	}	public void setBuilding_type(String building_type) {		this.building_type = building_type;	}	public Double getAvg_price() {		return avg_price;	}	public void setAvg_price(Double avg_price) {		this.avg_price = avg_price;	}	public Date getOpen_date() {		return open_date;	}	public void setOpen_date(Date open_date) {		this.open_date = open_date;	}	public int getTotal_rooms() {		return total_rooms;	}	public void setTotal_rooms(int total_rooms) {		this.total_rooms = total_rooms;	}	public String getReception_address() {		return reception_address;	}	public void setReception_address(String reception_address) {		this.reception_address = reception_address;	}	public Double getGreen_ratio() {		return green_ratio;	}	public void setGreen_ratio(Double green_ratio) {		this.green_ratio = green_ratio;	}	public Double getPlot_ratio() {		return plot_ratio;	}	public void setPlot_ratio(Double plot_ratio) {		this.plot_ratio = plot_ratio;	}	public String getProperty_company() {		return property_company;	}	public void setProperty_company(String property_company) {		this.property_company = property_company;	}	public Double getProperty_fee() {		return property_fee;	}	public void setProperty_fee(Double property_fee) {		this.property_fee = property_fee;	}	public int getCar_station() {		return car_station;	}	public void setCar_station(int car_station) {		this.car_station = car_station;	}	public Date getCreated_time() {		return created_time;	}	public void setCreated_time(Date created_time) {		this.created_time = created_time;	}	public void setId(String id) {		this.id = id;	}	public String getName() {		return name;	}	public void setName(String name) {		this.name = name;	}	public String getArea() {		return area;	}	public void setArea(String area) {		this.area = area;	}	public String getAddress() {		return address;	}	public void setAddress(String address) {		this.address = address;	}	public Double getLongitude() {		return longitude;	}	public void setLongitude(Double longitude) {		this.longitude = longitude;	}	public Double getLatitude() {		return latitude;	}	public void setLatitude(Double latitude) {		this.latitude = latitude;	}	public String getCompany() {		return company;	}	public void setCompany(String company) {		this.company = company;	}	public String getTel() {		return tel;	}	public void setTel(String tel) {		this.tel = tel;	}	public String getTraffic() {		return traffic;	}	public void setTraffic(String traffic) {		this.traffic = traffic;	}	public String getEquipments() {		return equipments;	}	public void setEquipments(String equipments) {		this.equipments = equipments;	}	public String getLogo() {		return logo;	}	public void setLogo(String logo) {		this.logo = logo;	}	public String getIntro() {		return intro;	}	public void setIntro(String intro) {		this.intro = intro;	}	public String getStatus() {		return status;	}	public void setStatus(String status) {		this.status = status;	}}