package pong.audio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Directory scanner used to load audio clips.
 *
 * @author Daniel Peters
 */
public class DirectoryScanner {
  private final File directory;
  private final String[] dirContents;

  /**
   * Opens a directory and lists loads all contents into a class array.
   *
   * @param dir directory
   */
  public DirectoryScanner(String dir) {
    directory = new File(dir);
    dirContents = directory.list();
  }

  /**
   * Adds the files to an arrayList and returns it.
   *
   * @return list of found audio files.
   */
  public List<AudioClip> getDirContents() {
    List<AudioClip> files = new ArrayList<>();

    for (String fileName : dirContents) {
      if (!fileName.equals("desktop.ini")) {
        files.add(new AudioClip(fileName));
      }
    }
    return files;
  }
}
