plugins {
    java
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.6")
}

tasks {

    named("hello") {
        doLast {
            println(" - I'm a blue whale.")
        }
    }
}