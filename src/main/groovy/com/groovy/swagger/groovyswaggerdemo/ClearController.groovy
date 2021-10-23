package com.groovy.swagger.groovyswaggerdemo

import com.groovy.swagger.groovyswaggerdemo.model.UserEntity
import groovy.util.logging.Slf4j
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@Slf4j
@RestController
class ClearController {

    @GetMapping('/clear/user/{name}')
    UserEntity userNameFromPathVariable(@PathVariable String name) {
        log.info("Get user name ${name} from path variable")
        if (name.toLowerCase() == "adam") {
            new UserEntity(
                    name: "Adam",
                    age: 21
            )
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with name ${name} not found!")
        }
    }

    @GetMapping('/clear/user')
    UserEntity userNameFromRequestParam(@RequestParam String name) {
        log.info("Get user name ${name} from request param")
        if (name.toLowerCase() == "adam") {
            new UserEntity(
                    name: "Adam",
                    age: 21
            )
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with name ${name} not found!")
        }
    }

    @GetMapping('/clear/user/list')
    List<UserEntity> userNames() {
        log.info("Get users list")
        [new UserEntity(
                name: "Adam",
                age: 21
        ), new UserEntity(
                name: "Jon",
                age: 25
        )]
    }

    @PutMapping('/clear/user')
    UserEntity addUser(@RequestBody UserEntity userEntity) {
        log.info("User ${userEntity?.name} is created!")
        userEntity
    }

    @PostMapping('/clear/user')
    UserEntity saveUser(@RequestBody UserEntity userEntity) {
        log.info("User ${userEntity?.name} is created!")
        userEntity
    }

    @DeleteMapping('/clear/user')
    void deleteUserFromRequestParam(@RequestParam String name) {
        if (name.toLowerCase() == "adam") {
            log.info("User with name ${name} is deleted!")
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with name ${name} not found!")
        }
    }

}
