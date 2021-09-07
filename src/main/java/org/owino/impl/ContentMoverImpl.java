package org.owino.impl;

import org.apache.commons.io.FileUtils;
import org.owino.concept.ContentMover;

import java.io.File;
import java.io.IOException;

public class ContentMoverImpl implements ContentMover {
    /**
     * Copy past the cleaned up contents to the final android studio resource file directory
     *
     * @param localeKey - String fullyQualifiedFileName e.g D:/projects/pet-project/src/main/res/values-ar/strings.xml
     * @param contents  - String File Contents to be appended to res file
     * @return boolean              - success status, true if successfully
     */
    @Override
    public boolean pasteContentsToAndroidStudioSourceDir(File rootAndroidStudioResSourceDir, String localeKey, String contents) throws IOException {
        File file = new File(rootAndroidStudioResSourceDir.getAbsolutePath() + "\"" + localeKey + "\"" + "strings.xml");
        FileUtils.writeStringToFile(file, contents, true);
        return true;
    }
}
