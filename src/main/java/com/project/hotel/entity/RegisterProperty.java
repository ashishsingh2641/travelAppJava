package com.project.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class RegisterProperty {
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String ownerName;
	private String ownerMobileNo;
	private String address1;
	private String address2;
	private String city;
	private String pinCode;
	private String state;
	private String landmark;
	private String imageUrl;
	private String typeOfProperty;
	private boolean sell;
	private boolean rent;
	private double price;
	private String description;
	private boolean semiFurnished;
	private boolean fullFurnished;
	private boolean unFurnished;
	private boolean ac;
	private boolean nonAc;
	private boolean wifi;
	private boolean parking;
	private boolean lift;
	private boolean tv;
	private boolean powerBackUp;
	
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

}
