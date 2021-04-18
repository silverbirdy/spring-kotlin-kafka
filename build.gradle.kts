plugins {
	id("org.springframework.boot") version "2.4.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.31"
	kotlin("plugin.spring") version "1.4.31"
}

group = "com.sample"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

val ktlint by configurations.creating

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.kafka:spring-kafka")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")

	ktlint("com.pinterest:ktlint:0.41.0")
}

tasks {
	compileKotlin {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict", "-Xuse-experimental=kotlin.Experimental")
			jvmTarget = "1.8"
		}
	}
}

val ktlintFormat by tasks.creating(JavaExec::class) {
	description = "Fix Kotlin code style deviations."
	classpath = ktlint
	main = "com.pinterest.ktlint.Main"
	args = listOf("-F", "src/**/*.kt")
}
