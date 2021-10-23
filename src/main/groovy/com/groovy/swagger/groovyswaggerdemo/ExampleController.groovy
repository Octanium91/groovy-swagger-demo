package com.groovy.swagger.groovyswaggerdemo

import com.groovy.swagger.groovyswaggerdemo.model.UserEntity
import groovy.util.logging.Slf4j
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
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
@Tag(name = "Example controller")
@RestController
class ExampleController {

    @Operation(summary = "Get user by path variable")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Returns user entity",
                    content = [ @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)), ]),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = [ @Content, ])
    ])
    @GetMapping('/user/{name}')
    UserEntity userNameFromPathVariable(@Parameter(description = "You can find only user with name 'Adam'") @PathVariable String name) {
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

    @Operation(summary = "Get user by request param")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Return user entity",
                    content = [ @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) ]),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = [ @Content, ])
    ])
    @GetMapping('/user')
    UserEntity userNameFromRequestParam(@Parameter(description = "You can find only user with name 'Adam'") @RequestParam String name) {
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

    @Operation(summary = "Get users list")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Return users list",
                    content = [@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserEntity.class)))])
    ])
    @GetMapping('/user/list')
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

    @Operation(summary = "Create user")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "User created",
                    content = [@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class))])
    ])
    @PutMapping('/user')
    UserEntity addUser(@RequestBody UserEntity userEntity) {
        log.info("User ${userEntity?.name} is created!")
        userEntity
    }

    @Operation(summary = "Save user")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "User saved",
                    content = [@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class))])
    ])
    @PostMapping('/user')
    UserEntity saveUser(@RequestBody UserEntity userEntity) {
        log.info("User ${userEntity?.name} is created!")
        userEntity
    }

    @Operation(summary = "Delete user")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "User deleted",
                    content = [@Content]),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = [@Content])
    ])
    @DeleteMapping('/user')
    void deleteUserFromRequestParam(@Parameter(description = "You can delete only user with name 'Adam'") @RequestParam String name) {
        if (name.toLowerCase() == "adam") {
            log.info("User with name ${name} is deleted!")
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with name ${name} not found!")
        }
    }

}
