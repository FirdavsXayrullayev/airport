package uz.airport.service;

import uz.airport.dto.ResponseDto;
import uz.airport.dto.UserDto;

import java.util.List;

public interface UserService {
    ResponseDto<UserDto> getById(Integer id);

    ResponseDto<List<UserDto>> getAllUser();

    ResponseDto<UserDto> addUser(UserDto userDto);

    ResponseDto<UserDto> deleteUserById(Integer id);

    ResponseDto<UserDto> updateUser(UserDto userDto);
}
