package org.owino;

import java.io.File;

/**
 * Moves cleaned up content to target android studios resourceFile iteratively
 *
 */
public interface ContentMover {

    /**
     * Copy past the cleaned up contents to the final android studio resource file directory
     *
     * @param fullyQualifiedFileName - String fullyQualifiedFileName e.g D:/projects/pet-project/src/main/res/values-ar/strings.xml
     * @param contents - String File Contents to be appended to res file
     * @return boolean success status - true if successfully
     */
    boolean pasteContentsToAndroidStudioSourceDir(File fullyQualifiedFileName, String contents);
}
