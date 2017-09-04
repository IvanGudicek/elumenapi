package hr.tvz.gudicek.elumen.elumenapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -6527558983893306703L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "facebook_id")
	private String facebookId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "lastname")
	private String lastName;

}
