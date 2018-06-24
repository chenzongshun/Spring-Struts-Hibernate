package bean;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 下午4:08:28
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
