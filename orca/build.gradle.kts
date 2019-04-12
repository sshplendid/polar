plugins {
    java
    id("org.springframework.boot") version "2.1.4.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

dependencies {
    compile(project(":bluewhale"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    register("checkBoot") {
        println("Boot version of this project '${this.project.name}' is ... ${project.rootProject.ext["bootVersion"]}")
        println("${this}")
        println("${project}")
    }

    named("hello") {
        doLast {
            println(" - I'm an orca, killer whale.")
        }
    }
}