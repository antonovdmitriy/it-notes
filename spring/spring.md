
- [Simple app](#simple-app)
- [Testing](#testing)

# Simple app

```gradle
plugins {
  id 'org.springframework.boot' version '2.7.3'    
  id 'io.spring.dependency-management' version '1.0.13.RELEASE'                        
  id 'java'                                        
}
 
group = 'com.polarbookshop'                        
version = '0.0.1-SNAPSHOT'                         
sourceCompatibility = '17'                         
 
repositories {                                     
  mavenCentral()
}
 
dependencies {                                     
  implementation 'org.springframework.boot:spring-boot-starter-web'
  testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
 
tasks.named('test') {
  useJUnitPlatform()                               
}
```

```java
package com.polarbookshop.catalogservice;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication                           
public class CatalogServiceApplication {
  public static void main(String[] args) {       
   SpringApplication.run(CatalogServiceApplication.class, args);
  }
}
```

The `@SpringBootApplication `annotation is a shortcut that includes:

- `@Configuration` marks the class as a source of beans definitions.
- `@ComponentScan` enables component scanning to find and register beans in the Spring context automatically.
- `@EnableAutoConfiguration` enables the auto-configuration capabilities offered by Spring Boot.

```java
package com.polarbookshop.catalogservice;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController                    
public class HomeController {
 
  @GetMapping("/")                 
  public String getGreeting() {
    return "Welcome to the book catalog!";
  }
}
```

```java
package com.polarbookshop.catalogservice;
 
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
 
@SpringBootTest                          
class CatalogServiceApplicationTests {
 
  @Test                                  
  void contextLoads() {                  
  }
}
```


# Testing

