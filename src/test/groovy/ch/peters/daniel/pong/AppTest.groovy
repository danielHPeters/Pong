package ch.peters.daniel.pong

import spock.lang.Specification

class AppTest extends Specification {
  def "application has a greeting"() {
    setup:
    def app = new App()
  }
}
