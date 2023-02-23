package course_project.controller;


import course_project.jwt.JwtProvider;
import course_project.payload.request.ConfirmationDTo;
import course_project.payload.request.UserLoginDto;
import course_project.payload.request.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserAuthController {

    private final JwtProvider jwtProvider;

    @PostMapping("register")
    public ResponseEntity<?> signUp(
            @RequestBody UserSignUpDto userSignUpDto
            ){
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(
            @RequestBody UserLoginDto userDto
            ){
        return jwtProvider.authenticateUser(userDto);
    }

    @PostMapping("confirm")
    public ResponseEntity<?> confirm(
            @RequestBody ConfirmationDTo confirmationDTo
            ){
        return jwtProvider.authenticateUser(new UserLoginDto("+998914144594", "parol"));
    }
}
