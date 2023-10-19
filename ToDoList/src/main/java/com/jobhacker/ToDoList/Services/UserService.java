package com.jobhacker.ToDoList.Services;

import com.jobhacker.ToDoList.Model.User;
import com.jobhacker.ToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void insert(User user) {
        User existingUser = userRepository.findByUserName(user.getUserName());

        if (existingUser == null) {
            userRepository.save(user);
        } else {
            throw new AuthenticationException("This username is already in use");
        }
    }


    public User findByUserNameAndPassword(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, password);
        return user;
    }

    public User findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        return user;
    }

    public int findIdByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password).getId();
    }

    public void delete(int userId) {
        userRepository.delete(userRepository.findById(userId).get());
    }

    public void update(User user) {
        User existUser = userRepository.findById(user.getId()).orElse(null);

        if (existUser != null) {
            if (user.getUserName() != null) {
                User checkUserNameExist = userRepository.findByUserName(user.getUserName());
                if(checkUserNameExist == null)
                    existUser.setUserName(user.getUserName());
                else
                    throw new NameException("this user name is already exist");
            }
            existUser.setPassword(user.getPassword());
            userRepository.save(existUser);
        } else {
            throw new AuthenticationException("this user doesn't exist");
        }
    }
}
