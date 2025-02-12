package in.sp.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Marks a class as a JPA entity, mapping it to DB table, allowing ORM for easy DB operations
@Entity
//Specifies th DB table's name for the entity, enabling customization of the table name if it differs from the class name
@Table
public class User {

	//Defines the primary key for the entity, uniquely identifying each record in the  corresponding DB table
	@Id
	//Instructs JPA to auto-generate the primary key using the DB identity column, ensuring unique values
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Maps the entity filed to a specific column in DB, allowing configuration of column properties like name, nullable, and length
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String city;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
