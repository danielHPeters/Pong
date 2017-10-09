package pong.audio;

/**
 * Audio definition class.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class AudioClip implements Comparable<AudioClip> {
  private final String location;

  /**
   * Default constructor.
   *
   * @param location file location
   */
  public AudioClip(String location) {
    this.location = location;
  }

  public String getLocation() {
    return this.location;
  }

  @Override
  public int compareTo(AudioClip o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
