import org.hibernate.annotations.*;
import jakarta.persistence.*;

@Entity
@Table(name= "usersdata")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name ="username")
	private String name;
	@Column(name ="useremail")
	private String email;
	@Column(name ="userage")
	private int age;
	@Column(name ="usercountry")
	private String country;
	
	public User() {}

    public User(String name, String email, String country, int age) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
        this.age = age;
    }

    public User(int id, String name, String email, String country, int age) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.age = age;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
