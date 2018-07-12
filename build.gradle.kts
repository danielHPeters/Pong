version = "1.0"
group = "ch.peters.daniel"

plugins {
  // Apply the java plugin to add support for Java
  java

  // Apply the application plugin to add support for building an application
  application

  // Apply the groovy plugin to also add support for Groovy (needed for Spock)
  groovy
}

application {
  applicationName= "pong"
  // Define the main class for the application
  mainClassName = "${project.group}.${applicationName}.App"
}

dependencies {
  // This dependency is found on compile classpath of this component and consumers.
  implementation("com.google.guava:guava:23.0")

  // Use the latest Groovy version for Spock testing
  testImplementation("org.codehaus.groovy:groovy-all:2.4.14")

  // Use the awesome Spock testing and specification framework even with Java
  testImplementation("org.spockframework:spock-core:1.0-groovy-2.4")
  testImplementation("junit:junit:4.12")
}

// In this section you declare where to find the dependencies of your project
repositories {
  // Use jcenter for resolving your dependencies.
  // You can declare any Maven/Ivy/file repository here.
  jcenter()
}
