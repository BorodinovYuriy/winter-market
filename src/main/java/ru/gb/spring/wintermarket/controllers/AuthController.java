package ru.gb.spring.wintermarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.wintermarket.dto.JwtRequestDto;
import ru.gb.spring.wintermarket.dto.JwtResponseDto;
import ru.gb.spring.wintermarket.services.UserService;
import ru.gb.spring.wintermarket.utils.JwtTokenUtil;

@RestController
@RequiredArgsConstructor
public class AuthController {
     private final UserService userService;
     private final JwtTokenUtil jwtTokenUtil;
     private final AuthenticationManager authenticationManager;//спринг-бин аутентификации
     @PostMapping("/auth")
    public ResponseEntity<?>createAuthToken(@RequestBody JwtRequestDto authRequests){
         try{
             //проверяем наличие авторизации
             authenticationManager
                     .authenticate(new UsernamePasswordAuthenticationToken
                             (authRequests.getUsername(), authRequests.getPassword()));

         }catch (BadCredentialsException e){
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
             //...тут будет расшифровка 401
         }
         //проверили, тогда достаем из базы userDetails
         UserDetails userDetails = userService.loadUserByUsername(authRequests.getUsername());
         //По нему собираем токен
         String token = jwtTokenUtil.generateToken(userDetails);
         //клиенту идёт ответ Json с полем token
         return ResponseEntity.ok(new JwtResponseDto(token));
    }
@GetMapping("/secured")//test
    private String helloSecurity(){
         return "HELLo";
}









}
