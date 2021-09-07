package org.owino;

import java.io.File;

/**
 * Extract and process
 * the contents of resources files for copying to android studio project
 *
 */
public interface ContentsExtractor {

    /**
     * Obtain the files contents as text
     *
     * @param sourceResourceFile - File source file
     * @return - String Contents
     */
    String getFileContents(File sourceResourceFile);

    /**
     * Delete the xml namespace if exists since android studio res files
     * will surely have this available.
     *
     * @param resContents - String resContents
     * @return - String clean contents
     */
    String deleteXmlNamesSpace(String resContents);

    /**
     * Delete closing namespace tag
     *
     * @param resContents - String resContents
     * @return - String clean contents
     */
    String deleteClosingResourceTagFromContents(String resContents);
}
