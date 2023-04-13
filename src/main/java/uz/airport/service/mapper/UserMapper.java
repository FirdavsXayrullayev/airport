package uz.airport.service.mapper;

import org.mapstruct.Mapper;
import uz.airport.dto.UserDto;
import uz.airport.model.User;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements CommonMapper<UserDto, User>{
}
