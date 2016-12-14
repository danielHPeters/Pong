package pong.audio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author d.peters
 */
public class DirectoryScanner {

    /**
     * the directory to be scanned
     */
    private final File directory;

    /**
     * List of files in the selected directory
     */
    private final String[] dirContents;

    /**
     * Opens a directory and lists loads all contents into a class array
     *
     * @param dir
     */
    public DirectoryScanner(String dir) {

        this.directory = new File(dir);
        this.dirContents = this.directory.list();

    }

    /**
     * adds the files to an arrayList and returns it
     *
     * @return
     */
    public List<AudioClip> getDirContents() {

        List<AudioClip> files = new ArrayList<>();

        for (String fileName : this.dirContents) {

            if (!fileName.equals("desktop.ini")) {
                files.add(new AudioClip(fileName));
            }

        }

        return files;
    }
}
