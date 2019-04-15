plugins {
    java
    id("org.springframework.boot") version "2.1.4.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

dependencies {
    compile(project(":bluewhale"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    compile("org.springframework.boot:spring-boot-starter-data-redis")
    compile("it.ozimov:embedded-redis:0.7.2")
    compile("org.springframework.session:spring-session-data-redis")
    compile("org.springframework.boot:spring-boot-starter-thymeleaf")
    compile("org.springframework.boot:spring-boot-devtools")
    compileOnly("org.projectlombok:lombok:1.18.6")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    named("hello") {
        doLast {
            println(" - I'm an Adelie penguin. I'm cute.")
        }
    }
}
