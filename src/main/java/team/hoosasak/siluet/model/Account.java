package team.hoosasak.siluet.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
@Entity(name = "account")
@Table
public class Account {

    private enum AccountType {FACEBOOK, KAKAO}

    @Id
    private String token;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(length = 32)
    private String name;

    @Column(length = 32)
    private String imgUrl;

    public Account(String token, AccountType type, String name, String imgUrl) {
        this.token = token;
        this.type = type;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
