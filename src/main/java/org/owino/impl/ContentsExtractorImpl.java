package org.owino.impl;

import org.owino.ContentsExtractor;

import java.io.File;

public class ContentsExtractorImpl implements ContentsExtractor {
    /**
     * Obtain the files contents as text
     *
     * @param sourceResourceFile - File source file
     * @return - String Contents
     */
    @Override
    public String getFileContents(File sourceResourceFile) {
        return null;
    }

    /**
     * Delete the xml namespace if exists since android studio res files
     * will surely have this available.
     *
     * @param resContents - String resContents
     * @return - String clean contents
     */
    @Override
    public String deleteXmlNamesSpace(String resContents) {
        return null;
    }

    /**
     * Delete closing namespace tag
     *
     * @param resContents - String resContents
     * @return - String clean contents
     */
    @Override
    public String deleteClosingResourceTagFromContents(String resContents) {
        return null;
    }
}
