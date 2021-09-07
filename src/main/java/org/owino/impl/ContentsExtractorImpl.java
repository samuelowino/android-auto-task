package org.owino.impl;

import org.apache.commons.io.IOUtils;
import org.owino.concept.ContentsExtractor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentsExtractorImpl implements ContentsExtractor {

    private static final List<String> languages = Arrays.asList(
            "ha", "pl", "am", "ar", "az", "be", "bg", "bn",
            "bs", "fr", "ga",
            "ca", "cs", "da", "es", "et", "fa", "fi", "gl",
            "it", "iw", "ja", "jv", "ka", "km", "ko", "ky",
            "my", "nb", "ne", "nl", "nn", "no", "pa", "ro",
            "ru", "si", "sk", "sl", "sq", "sr",
            "sv", "sw", "ta", "te", "th", "tr", "vi", "zh", "zu", "kn", "kk",
            "af", "de", "fil", "hi", "hr", "hu", "hy", "id", "in", "lo", "lv",
            "mk", "ml", "mn", "pt", "uk", "ur", "ms", "is", "el", "mr"
    );

    /**
     * Obtain the files contents as text
     *
     * @param sourceResourceFile - File source file
     * @return - String Contents
     */
    @Override
    public Map<String, String> getFileContents(File sourceResourceFile, String language) throws IOException {
        String contents = IOUtils.toString(sourceResourceFile.toURI(), "utf-8");
        HashMap<String, String> mapContents = new HashMap<>();
        mapContents.put(language, contents);
        return mapContents;
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
        return resContents.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "\n");
    }

    /**
     * Delete closing namespace tag
     *
     * @param resContents - String resContents
     * @return - String clean contents
     */
    @Override
    public String deleteClosingResourceTagFromContents(String resContents) {
        return resContents.replace("</resources>", "\n").replace("<resources>", "");
    }

    /**
     * Returns a list of sources file containing source content
     *
     * @return - List of Files
     */
    @Override
    public Map<String, File> getSourcesFiles() {
//        return languages.stream().map(File::new)
//                .collect(Collectors.toList()); //todo left this half way
        Map<String, File> sourceFiles = new HashMap<>();
        for (String language : languages) {
            sourceFiles.put(language, new File(language));
        }
        return sourceFiles;
    }
}
