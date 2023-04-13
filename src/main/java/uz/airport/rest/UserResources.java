package uz.airport.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.airport.dto.ResponseDto;
import uz.airport.dto.UserDto;
import uz.airport.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserResources {
    private final UserService userService;

    @GetMapping("get-by-id")
    public ResponseDto<UserDto> getById(@RequestParam Integer id){
        return userService.getById(id);
    }
    @GetMapping("get-all-user")
    public ResponseDto<List<UserDto>> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping("add-user")
    public ResponseDto<UserDto> addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }
    @DeleteMapping("delete-user-by-id")
    public ResponseDto<UserDto> deleteUserById(@RequestParam Integer id){
        return userService.deleteUserById(id);
    }
    @PatchMapping("update-user")
    public ResponseDto<UserDto> updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }
}
