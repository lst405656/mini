package lst.spring.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString(exclude = "boardList")
@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	@Column(name = "ID")
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, name = "REGDATE")
	private Date regDate = new Date();
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();
}
