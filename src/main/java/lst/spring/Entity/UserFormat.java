package lst.spring.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //파리미터가 없는 기본 생성자 생성
@Getter
public class UserFormat {

	@NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String id;

	@NotBlank(message = " 닉네임은 필수 입력 값입니다.")
	private String nickname;
	
    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotEmpty(message = " 전화번호는 필수 입력 값입니다.")
    private String phone;
    
    
    @Builder
    public UserFormat(String id, String nickname, String email, String password, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
