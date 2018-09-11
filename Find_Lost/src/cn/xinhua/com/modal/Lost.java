package cn.xinhua.com.modal;

import java.sql.Timestamp;

public class Lost {
	
	private int id;		
	private String thing;	//ʧ��
	private String time;	//ʰ��ʱ��
	private String where;	//ʰ��ص�
	private String phone;	//ʰ����ϵ��ʽ
	private String description;		//��Ʒ����
	private String photo;		//�ϴ�ʧ����Ƭ
	private Timestamp date;		//���ݿ�洢ʱ��
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Lost [id=" + id + ", thing=" + thing + ", time=" + time
				+ ", where=" + where + ", phone=" + phone + ", description="
				+ description + ", photo=" + photo + ", date=" + date + "]";
	}
	
	
}
