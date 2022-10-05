package lst.spring.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Entity
@Table(name = "USER")
@Data
public class User {
	@Id
	@GeneratedValue
	private long seq;
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date regDate = new Date();
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
}
