    package com.jobhacker.user.controller;

    import com.jobhacker.user.dto.UserDto;
    import com.jobhacker.user.exception.AddingException;
    import com.jobhacker.user.exception.UserNotFoundException;
    import com.jobhacker.user.service.UserService;
    import io.swagger.v3.oas.annotations.Operation;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/users")
    @RequiredArgsConstructor
    public class UserController {

        private final UserService userService;

        @Operation(summary = "get all users")
        @GetMapping("/")
        public ResponseEntity<List<UserDto>> getAllUsers(){
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }

        @Operation(summary = "get user by name")
        @GetMapping("/{username}")
        public ResponseEntity<UserDto> getUserByName(@PathVariable String username) throws UserNotFoundException {
                UserDto user = userService.getUserByName(username);
                return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @Operation(summary = "create new user")
        @PostMapping("/")
        public ResponseEntity<UserDto> addNewUser(@RequestBody @Valid UserDto userDto) throws AddingException {
                UserDto createdUser = userService.createNewUser(userDto);
                return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

        }

        @Operation(summary = "delete user by name")
        @DeleteMapping("/{username}")
        public ResponseEntity<String> deleteUser(@PathVariable String username) throws UserNotFoundException {

                boolean deleted = userService.deleteExistUser(username);
                if (deleted) {
                    return new ResponseEntity<>("User with username " + username + " has been deleted", HttpStatus.NO_CONTENT);
                }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        @Operation(summary = "update the status of the user ")
        @PatchMapping("/{username}")
        public ResponseEntity<UserDto> changeUserStatus(@PathVariable String username, @RequestBody boolean status) throws UserNotFoundException {
            UserDto user = userService.changeUserStatus(username, status);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
