plugins {
    java
    id("org.springframework.boot") version "2.1.4.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

dependencies {
    compile(project(":bluewhale"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-thymeleaf")
    compile("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    named("hello") {
        doLast {
            println(" - I'm an Adelie penguin. I'm cute.")
        }
    }
}
