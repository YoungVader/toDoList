package ru.chausov.to_do_list.servlet.api;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.chausov.to_do_list.data_base.entity.User;
import ru.chausov.to_do_list.data_base.repository.UserRepository;

import javax.transaction.Transactional;


@Data
@RestController
@RequestMapping("/api/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @Transactional
    @GetMapping("/table")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

//    @Transactional
//    @PostMapping("/add")
//    public User addUser(User user) throws Exception {
////        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
////                getAuthentication().getDetails();
//        return userRepository.save(user);
//    }

    @Transactional
    @PostMapping("/delete")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @PostMapping("/update")
    public User updateUser(@PathVariable(value = "id") Long id, User user) {
        return userRepository.save(user);
    }
}