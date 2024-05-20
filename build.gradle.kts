plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/snapshot") } // Spring Snapshot Repository

}

extra["springCloudVersion"] = "2023.0.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")


    //lombok
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")

    //feign client
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.0")

    //database
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    //implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")

    //validation
    implementation("org.springframework.boot:spring-boot-starter-validation")


    //security
    implementation("org.springframework.boot:spring-boot-starter-security:3.2.4")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.2.4")


    //swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("io.swagger:swagger-annotations:1.6.4")

    //spock
    testImplementation("org.spockframework:spock-core:2.4-M1-groovy-4.0")

    //random
    testImplementation("io.github.benas:random-beans:3.9.0")

    //mapstruck
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")

    //test
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}