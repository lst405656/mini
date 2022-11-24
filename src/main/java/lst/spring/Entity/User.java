package lst.spring.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString(exclude = "boardList")
@Entity
@Table(name = "USER")
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "ID")
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	@CreationTimestamp
	@Column(updatable = false, name = "REGDATE")
	private LocalDateTime regDate;
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	private String familyCode;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();
	
}
