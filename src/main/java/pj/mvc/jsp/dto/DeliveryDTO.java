package pj.mvc.jsp.dto;

import java.sql.Date;

public class DeliveryDTO {
	private String delivery_no;
	private String billing_number;
	private String order_no;
	private String deliver_name;
	private String deliver_tel;
	private String zipcode;
	private String current_location;
	private Date delivery_day;
	private String delivery_state;
	
	public DeliveryDTO() {}
	
	public String getDelivery_no() {
		return delivery_no;
	}
	public void setDelivery_no(String delivery_no) {
		this.delivery_no = delivery_no;
	}
	public String getBilling_number() {
		return billing_number;
	}
	public void setBilling_number(String billing_number) {
		this.billing_number = billing_number;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getDeliver_name() {
		return deliver_name;
	}
	public void setDeliver_name(String deliver_name) {
		this.deliver_name = deliver_name;
	}
	public String getDeliver_tel() {
		return deliver_tel;
	}
	public void setDeliver_tel(String deliver_tel) {
		this.deliver_tel = deliver_tel;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCurrent_location() {
		return current_location;
	}
	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}
	public Date getDelivery_day() {
		return delivery_day;
	}
	public void setDelivery_day(Date delivery_day) {
		this.delivery_day = delivery_day;
	}
	public String getDelivery_state() {
		return delivery_state;
	}
	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}

	@Override
	public String toString() {
		return "DeliveryDTO [delivery_no=" + delivery_no + ", billing_number=" + billing_number + ", order_no="
				+ order_no + ", deliver_name=" + deliver_name + ", deliver_tel=" + deliver_tel + ", zipcode=" + zipcode
				+ ", current_location=" + current_location + ", delivery_day=" + delivery_day + ", delivery_state="
				+ delivery_state + "]";
	}
}