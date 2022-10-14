package lst.spring.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User{
	private static final long serialVersionUID = 1L;
	private lst.spring.Entity.User u;
	
	public SecurityUser(lst.spring.Entity.User u) {
		super(u.getId(), u.getPassword(), AuthorityUtils.createAuthorityList(u.getRole().toString()));
		this.u = u;
	}
	public lst.spring.Entity.User getUser() {
		return u;
	}
}
