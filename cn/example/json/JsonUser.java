package cn.example.json;

import java.util.Date;
import java.util.List;

public class JsonUser{

	private String name;
	private String address;
	private Integer age;
	private Date birth;
	private List<String> hobbies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "JsonUser [name=" + name + ", address=" + address + ", age=" + age + ", birth=" + birth + ", hobbies="
				+ hobbies + "]";
	}

}
