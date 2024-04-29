plugins {
    groovy
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    //lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    //database
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
    //swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    //spock
    testImplementation("org.spockframework:spock-core:2.4-M1-groovy-4.0")
    //random
    testImplementation("io.github.benas:random-beans:3.9.0")
    //mapstruck
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
