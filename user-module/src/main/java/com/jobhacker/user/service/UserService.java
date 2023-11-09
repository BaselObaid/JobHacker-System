package com.jobhacker.user.service;

import com.jobhacker.user.dto.UserDto;
import com.jobhacker.user.entity.User;
import com.jobhacker.user.exception.AddingException;
import com.jobhacker.user.exception.UserNotFoundException;
import com.jobhacker.user.mapper.UserMapper;
import com.jobhacker.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    // get all users
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = userMapper.userListToUserDtoList(users);
        return userDtoList;
    }

    //get user by name
    public UserDto getUserByName(String username) throws UserNotFoundException {
        User user = findUsername(username);
        if(user != null){
            UserDto userDto = userMapper.userToUserDto(user);
            return userDto;
        }
        throw new UserNotFoundException("this username : " + username + " not exists");
    }

    // add new user
    public UserDto createNewUser(UserDto userDto) throws AddingException {
        User user = findUsername(userDto.getUsername());
        if(user != null){
            throw new AddingException("this username is already exist find another one");
        }
        user = userMapper.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    public boolean deleteExistUser(String username) throws UserNotFoundException {
        User user = findUsername(username);
        if(user == null){
            throw new UserNotFoundException("this username : " + username + " not exists");
        }
        userRepository.delete(user);
        return true;
    }

    public UserDto changeUserStatus(String username, boolean newStatus) throws UserNotFoundException {
        User user = findUsername(username);
        if(user == null){
            throw new UserNotFoundException("this username : " + username + " not exists");
        }
        user.setStatus(newStatus);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    private User findUsername(String userName){
        return userRepository.findByUsername(userName).orElse(null);
    }

}
