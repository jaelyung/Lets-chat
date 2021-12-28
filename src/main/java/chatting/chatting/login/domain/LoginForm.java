package chatting.chatting.login.domain;

import com.sun.istack.NotNull;

public class LoginForm {

    @NotNull
    private String loginId;

    @NotNull
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
