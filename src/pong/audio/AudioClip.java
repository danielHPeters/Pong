package pong.audio;

/**
 * Audio definition class.
 *
 * @author Daniel Peters
 */
public class AudioClip implements Comparable<AudioClip> {

  /**
   * File location.
   */
  private final String location;

  /**
   * Default constructor.
   *
   * @param location file location
   */
  public AudioClip(String location) {
    this.location = location;
  }

  /**
   * Get file location.
   * @return file location
   */
  public String getLocation() {
    return this.location;
  }

  @Override
  public int compareTo(AudioClip o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
