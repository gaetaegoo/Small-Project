package useditem.model.dto;

public class Member {
	
	private String id;
	private String name;
	private String phone;
	private String loc;
	private String grade;

	public Member() {}

	public Member(String id, String name, String phone, String loc, String grade) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.loc = loc;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 1)ȸ�� ID: ");
		builder.append(id);
		builder.append("\n 2)�̸�: ");
		builder.append(name);
		builder.append("\n 3)�ڵ��� ��ȣ: ");
		builder.append(phone);
		builder.append("\n 4)�ŷ� ��� ����: ");
		builder.append(loc);
		builder.append("\n 5)ȸ�� ���: ");
		builder.append(grade);
		return builder.toString();
	}

}
