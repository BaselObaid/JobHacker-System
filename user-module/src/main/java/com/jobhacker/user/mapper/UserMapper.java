package com.jobhacker.user.mapper;

import com.jobhacker.user.dto.UserDto;
import com.jobhacker.user.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDto userDto);

    @Mapping(target = "status", source = "status", defaultValue = "false")
    UserDto userToUserDto(User user);


    List<UserDto> userListToUserDtoList(List<User> users);

}
