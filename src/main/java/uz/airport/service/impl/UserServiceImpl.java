package uz.airport.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.airport.dto.ResponseDto;
import uz.airport.dto.UserDto;
import uz.airport.model.User;
import uz.airport.repository.UserRepository;
import uz.airport.service.UserService;
import uz.airport.service.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ResponseDto<UserDto> getById(Integer id) {
        return userRepository.findById(id).map(u ->
                        ResponseDto.<UserDto>builder()
                                .code(0)
                                .message("OK")
                                .success(true)
                                .data(userMapper.toDto(u))
                                .build())
                .orElse(
                        ResponseDto.<UserDto>builder()
                                .success(false)
                                .code(-1)
                                .message("Not found")
                                .build());
    }

    @Override
    public ResponseDto<List<UserDto>> getAllUser() {
        return ResponseDto.<List<UserDto>>builder()
                .code(0)
                .message("OK")
                .success(true)
                .data(userRepository.findAll().stream().map(userMapper::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<UserDto> addUser(UserDto userDto) {
        try {
            return ResponseDto.<UserDto>builder()
                    .code(0)
                    .message("OK")
                    .success(true)
                    .data(userMapper.toDto(userRepository.save(userMapper.toEntity(userDto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UserDto>builder()
                    .code(1)
                    .message("Database Error")
                    .data(userDto)
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto<UserDto> deleteUserById(Integer id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseDto.<UserDto>builder()
                    .code(0)
                    .message("OK")
                    .data(userMapper.toDto(user))
                    .success(true)
                    .build();
        }).orElse(
                ResponseDto.<UserDto>builder()
                        .code(-1)
                        .message("Not found")
                        .success(false)
                        .build()
        );
    }

    @Override
    public ResponseDto<UserDto> updateUser(UserDto userDto) {
        if (userDto.getId() == null){
            return ResponseDto.<UserDto>builder()
                    .code(-2)
                    .message("Validation Error")
                    .success(false)
                    .data(userDto)
                    .build();
        }
        Optional<User> optionalUserDto = userRepository.findById(userDto.getId());
        if (optionalUserDto.isEmpty()){
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message("Not found")
                    .success(false)
                    .data(userDto)
                    .build();
        }
        User user = optionalUserDto.get();
        if (userDto.getFirstName() != null){
            user.setFirstName(userDto.getFirstName());
        }
        if (userDto.getLastName() != null){
            user.setLastName(userDto.getLastName());
        }
        if (userDto.getEmail() != null){
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getPhoneNumber() != null){
            user.setPhoneNumber(userDto.getPhoneNumber());
        }
        try {
            userRepository.save(user);

            return ResponseDto.<UserDto>builder()
                    .code(0)
                    .message("OK")
                    .data(userMapper.toDto(user))
                    .success(true)
                    .build();
        }catch (Exception e){
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .data(userDto)
                    .message("Database Error")
                    .success(false)
                    .build();
        }
    }
}
