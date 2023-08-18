plugins {
	java
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.dukan"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_19

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

//	//swagger
//	implementation ("io.springfox:springfox-boot-starter:3.0.0")


	//mapper
	implementation("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
	annotationProcessor("org.mapstruct:mapstruct-jdk8:1.5.3.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.3.0.Final")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
