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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the typical runner
 */
public class AndroidResFilesTaskApp {
    private static final Logger log = Logger.getLogger(ContentMover.class.getSimpleName());

    public static void main(String[] args) throws IOException {

        File androidResDir = null;

        Scanner scanner = new Scanner(System.in);
        String androidStudioResDirPath = scanner.nextLine();
        if (androidStudioResDirPath.isEmpty()) {
            log.log(Level.SEVERE, "Invalid file path entered, exiting...");
            System.exit(0);
        } else {
            androidResDir = new File(androidStudioResDirPath);
        }

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
                String muchCleanerContent = contentsExtractor.replaceDestinationFileContents(evenCleanerContent, "strings", "string");

                Map<String, String> cleanContentMap = new HashMap<>();
                cleanContentMap.put(stringStringEntry.getKey(), muchCleanerContent);
                cleanContentMapList.add(cleanContentMap);
            }
        }

        ContentMover mover = new ContentMoverImpl();
        for (Map<String, String> contentsMap : cleanContentMapList) {
            for (Map.Entry<String, String> stringStringEntry : contentsMap.entrySet()) {
                mover.pasteContentsToAndroidStudioSourceDir(androidResDir, stringStringEntry.getKey(), stringStringEntry.getValue());
                List<String> additionalKeys = mover.checkIfMoveMultipleFoldersBySignatureIfNecessary(stringStringEntry.getKey());
                for (String additionalKey : additionalKeys) {
                    mover.pasteContentsToAndroidStudioSourceDir(androidResDir, additionalKey, stringStringEntry.getValue());
                }
            }
        }
    }
}
