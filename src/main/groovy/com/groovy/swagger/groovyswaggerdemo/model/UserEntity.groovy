package com.groovy.swagger.groovyswaggerdemo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(["metaClass"])
class UserEntity {

    String name

    int age

}
