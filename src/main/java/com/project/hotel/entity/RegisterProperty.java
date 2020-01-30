package com.project.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="register_property")
public class RegisterProperty {
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;
	
	@Column(name = "owner_name")
	private String ownerName;
	
	@Column(name = "owner_mobile_no")
	private String ownerMobileNo;
	
	@Column(name="owner_email")
	private String ownerEmail;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pin_code")
	private String pinCode;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "locality")
	private String locality;
	
	@Column(name = "landmark")
	private String landmark;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "type_of_property")
	private String typeOfProperty;
	
	@Column(name = "sell")
	private boolean sell;
	
	@Column(name = "rent")
	private boolean rent;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "semi_furnished")
	private boolean semiFurnished;
	
	@Column(name = "full_furnished")
	private boolean fullFurnished;
	
	@Column(name = "un_furnished")
	private boolean unFurnished;
	
	@Column(name = "ac")
	private boolean ac;
	
	@Column(name = "non_ac")
	private boolean nonAc;
	
	@Column(name = "wifi")
	private boolean wifi;
	
	@Column(name = "parking")
	private boolean parking;
	
	@Column(name = "lift")
	private boolean lift;
	
	@Column(name = "tv")
	private boolean tv;
	
	@Column(name = "power_back_up")
	private boolean powerBackUp;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name="near_by")
	private String nearBy;
	
	@Column(name="build_area")
	private int builtArea;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerMobileNo() {
		return ownerMobileNo;
	}
	public void setOwnerMobileNo(String ownerMobileNo) {
		this.ownerMobileNo = ownerMobileNo;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTypeOfProperty() {
		return typeOfProperty;
	}
	public void setTypeOfProperty(String typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}
	public boolean isSell() {
		return sell;
	}
	public void setSell(boolean sell) {
		this.sell = sell;
	}
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isSemiFurnished() {
		return semiFurnished;
	}
	public void setSemiFurnished(boolean semiFurnished) {
		this.semiFurnished = semiFurnished;
	}
	public boolean isFullFurnished() {
		return fullFurnished;
	}
	public void setFullFurnished(boolean fullFurnished) {
		this.fullFurnished = fullFurnished;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public boolean isNonAc() {
		return nonAc;
	}
	public void setNonAc(boolean nonAc) {
		this.nonAc = nonAc;
	}
	public boolean isUnFurnished() {
		return unFurnished;
	}
	public void setUnFurnished(boolean unFurnished) {
		this.unFurnished = unFurnished;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isLift() {
		return lift;
	}
	public void setLift(boolean lift) {
		this.lift = lift;
	}
	public boolean isTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
	}
	public boolean isPowerBackUp() {
		return powerBackUp;
	}
	public void setPowerBackUp(boolean powerBackUp) {
		this.powerBackUp = powerBackUp;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNearBy() {
		return nearBy;
	}
	public void setNearBy(String nearBy) {
		this.nearBy = nearBy;
	}
	public int getBuiltArea() {
		return builtArea;
	}
	public void setBuiltArea(int builtArea) {
		this.builtArea = builtArea;
	}
	
}
