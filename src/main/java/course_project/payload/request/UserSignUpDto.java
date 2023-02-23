package course_project.payload.request;

import lombok.Data;

@Data
public class UserSignUpDto {
    private String phoneNumber;
    private String password;
    private String chatId;
}

