package in.sp.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Marks a class as JPA entity, indicating it represent a DB table and its instance correspond to rows in  that table;
@Entity
//Specifies the table name in the DB that JPA entity maps to. Default to the entity class name if not provided
@Table
public class User {
	
	//Denote the primary key field of the entity, which uniquely identify each record in the table
		@Id
		//Configures the primary key to be automatically generated	 by the DB, using an identity column to increment values
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//Maps a field to a specific column in the DB table, allowing customization of column name, type and constraints
		@Column
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String phoneno;
	
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
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
}
