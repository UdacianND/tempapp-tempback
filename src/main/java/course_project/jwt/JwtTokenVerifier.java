package course_project.jwt;


import course_project.payload.request.UserLoginDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class JwtTokenVerifier extends OncePerRequestFilter {

    @Value("${jwtSecretKey}")
    private String jwtSecretKey;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authToken = request.getHeader("Authorization");
        if (authToken == null || !authToken.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authToken.replace("Bearer ", "");

        //try {

            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(jwtSecretKey)
                    .parseClaimsJws(token);

            UserLoginDto user = new UserLoginDto("9", "2");
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    new User("user", "parol", List.of(
                            (GrantedAuthority) () -> "ROLE_USER"
                    )),
                    null,
                    List.of(
                            (GrantedAuthority) () -> "ROLE_USER"
                    ));
//
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);

        //}catch(Exception e){
            //response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //}
    }
}
