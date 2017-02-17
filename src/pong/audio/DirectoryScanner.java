/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
