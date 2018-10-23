version = "1.0"
group = "ch.peters.daniel"

plugins {
  java
  application
  groovy
  checkstyle
}

application {
  applicationName= "pong"
  mainClassName = "${project.group}.$applicationName.App"
}

checkstyle {
  toolVersion = "8.14"
  configFile = rootProject.file("config/checkstyle/google_checks.xml")
}

dependencies {
  implementation("com.google.guava:guava:23.0")
  testImplementation("org.codehaus.groovy:groovy-all:2.4.14")
  testImplementation("org.spockframework:spock-core:1.0-groovy-2.4")
  testImplementation("junit:junit:4.12")
}

repositories {
  jcenter()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
}
