package bean;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��21�� ����4:08:28
 */
public class User {
	
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
}
