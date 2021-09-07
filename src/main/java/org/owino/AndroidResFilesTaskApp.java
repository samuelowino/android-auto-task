package org.owino;

import org.owino.concept.ContentMover;
import org.owino.concept.ContentsExtractor;
import org.owino.impl.ContentMoverImpl;
import org.owino.impl.ContentsExtractorImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the typical runner
 */
public class AndroidResFilesTaskApp {

    public static void main(String[] args) throws IOException {
        ContentsExtractor contentsExtractor = new ContentsExtractorImpl();
        Map<String, File> sourceFiles = contentsExtractor.getSourcesFiles();
//        List<>sourceFiles.stream().map(contentsExtractor::getFileContents).collect(Collectors.toList());
        List<Map<String, String>> mapList = new ArrayList<>();
        for (Map.Entry<String, File> localeFileEntry : sourceFiles.entrySet()) {
            Map<String, String> contentsMap = contentsExtractor.getFileContents(localeFileEntry.getValue(), localeFileEntry.getKey());
            mapList.add(contentsMap);
        }

        List<Map<String, String>> cleanContentMapList = new ArrayList<>();

        for (Map<String, String> contentsMap : mapList) {
            for (Map.Entry<String, String> stringStringEntry : contentsMap.entrySet()) {
                String cleanedUpContent = contentsExtractor.deleteXmlNamesSpace(stringStringEntry.getValue());
                String evenCleanerContent = contentsExtractor.deleteClosingResourceTagFromContents(cleanedUpContent);
                Map<String, String> cleanContentMap = new HashMap<>();
                cleanContentMap.put(stringStringEntry.getKey(), evenCleanerContent);
                cleanContentMapList.add(cleanContentMap);
            }
        }

        ContentMover mover = new ContentMoverImpl();
        for (Map<String, String> contentsMap : cleanContentMapList) {
            for (Map.Entry<String, String> stringStringEntry : contentsMap.entrySet()) {
                mover.pasteContentsToAndroidStudioSourceDir(sourceFiles.get(stringStringEntry.getKey()), stringStringEntry.getKey(), stringStringEntry.getValue());
            }
        }
    }
}
