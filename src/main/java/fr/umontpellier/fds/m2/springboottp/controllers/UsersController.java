package fr.umontpellier.fds.m2.springboottp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.umontpellier.fds.m2.springboottp.models.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import fr.umontpellier.fds.m2.springboottp.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }
    @GetMapping @RequestMapping("{id}")
    public User get(@PathVariable Long id) {
        if(userRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID"+id+"not found");
        }
         return userRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user) {
        System.out.println("Post method executed");
        return  userRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Toujours verifier s'il faut supprimer aussi
        // les enregistrements enfants
        userRepository.deleteById(id);
    }

    // @ExceptionHandler(value = {HttpStatus.class})
    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) {
        // Vérifier si les champs ont ete passes
        // Sinon, retourner une erreur 400 (Bad Payload)
        if(user.getEmail().isEmpty() || user.getFirst_name().isEmpty() || user.getLast_name().isEmpty() || user.getPassword().isEmpty() ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user, existingUser, "user_id");
        return userRepository.saveAndFlush(existingUser);
    }

}