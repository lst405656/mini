package lst.spring.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
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
	
	
	@Column
    private String picture;

	 @Builder
    public User(String nickname, String email, String picture, Role role){
        this.nickname = nickname;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }
	 public User update(String name, String picture){
	        this.nickname = name;
	        this.picture = picture;

	        return this;
    }
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();
	
}


