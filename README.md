# groovy-swagger-demo
<br/>
Simple example use open api with swagger on groovy (java) :)
<br/>
<br/>
<img src="./scr-shot.jpg" width="1690">
<br/>

 ## Demo launch

 - start **GroovySwaggerDemoApplication.groovy** (Java 11)
 - Go to [http://localhost:9666/swagger/ui/](http://localhost:9666/swagger/ui/)

 ## Controllers

 - [**ExampleController.groovy**](https://github.com/Octanium91/groovy-swagger-demo/blob/master/src/main/groovy/com/groovy/swagger/groovyswaggerdemo/ExampleController.groovy) - controller with described documentation
 - [**ClearController.groovy**](https://github.com/Octanium91/groovy-swagger-demo/blob/master/src/main/groovy/com/groovy/swagger/groovyswaggerdemo/ClearController.groovy) - clean controller WITHOUT described documentation

 ## **Fix** swagger ui freez\lag\hang\loop on open request

 - use dependencie [**springdoc-openapi-ui**](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui) verson 1.5.XX or higher
 - add annotation **@JsonIgnoreProperties(["metaClass"])** for yours objects\models\dto *(which are used in controllers)*
<br/>
<img src="./fix-swagger-freez.jpg" width="553">
<br/>
