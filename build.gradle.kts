version = "1.0"
group = "ch.peters.daniel"

plugins {
  java
  application
  groovy
  checkstyle
}

application {
  applicationName = "pong"
  mainClassName = "${project.group}.$applicationName.App"
}

checkstyle {
  toolVersion = "8.14"
  configFile = rootProject.file("config/checkstyle/google_checks.xml")
}

dependencies {
  testImplementation("org.codehaus.groovy:groovy-all:2.5.5")
  testImplementation("org.spockframework:spock-core:1.2-groovy-2.5")
  testImplementation("junit:junit:4.12")
}

repositories {
  jcenter()
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_10
  targetCompatibility = JavaVersion.VERSION_1_10
}
