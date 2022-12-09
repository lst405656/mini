package lst.spring.Entity;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getNickname();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}