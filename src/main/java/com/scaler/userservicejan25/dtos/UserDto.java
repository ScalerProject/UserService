package com.scaler.userservicejan25.dtos;

import com.scaler.userservicejan25.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String role;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
