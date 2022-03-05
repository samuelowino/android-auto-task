package org.owino.localisation.impl;

import org.owino.localisation.concept.ContentMover;
import org.owino.localisation.concept.ContentsExtractor;
import org.owino.localisation.utils.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ContentMoverImpl implements ContentMover {
    private static final Logger log = Logger.getLogger(ContentMover.class.getSimpleName());

    /**
     * Moves content to other matching folders based on a locale signature e.g
     * ar-xx, ab-xx
     *
     * @param key - String - Root Key
     * @return - List additionally supported keys if any
     */
    @Override
    public List<String> checkIfMoveMultipleFoldersBySignatureIfNecessary(String key) {
        switch (key) {
            case "ar":
                return Arrays.asList("ar-rAE", "ar-rBH", "ar-rDJ", "ar-rDZ", "ar-rEG", "ar-rEH",
                        "ar-rER", "ar-rIL", "ar-rIQ", "ar-rJO", "ar-rKM", "ar-rKW", "ar-rSA", "ar-rSD",
                        "ar-rSO", "ar-rSY", "ar-rTD", "ar-rLB", "ar-rLY", "ar-rMA", "ar-rMR", "ar-rOM",
                        "ar-rPS", "ar-rQA", "ar-rSS", "ar-rTN");
            case "fil":
                return Arrays.asList("b+fil", "fil-rPH");
            case "bg":
                return Collections.singletonList("bg-rBG");
            case "bs":
                return Collections.singletonList("bs-rBA");
            case "cs":
                return Collections.singletonList("cs-rCZ");
            case "de":
                return Arrays.asList("de-rAT", "de-rBE", "de-rCH", "de-rDE", "de-rLI", "de-rLU");
            case "el":
                return Arrays.asList("el-rCY", "el-rGR");
            case "es":
                return Arrays.asList("es-rAR", "es-rBO", "es-rCL", "es-rCO", "es-rCR", "es-rCU", "es-rDO",
                        "es-rEC", "es-rES", "es-rGQ", "es-rGT", "es-rHN", "es-rMX", "es-rNI", "es-rPA", "es-rPE",
                        "es-rPH", "es-rPR", "es-rPY", "es-rSV", "es-rUS", "es-rUY", "es-rVE");
            case "fr":
                return Arrays.asList("fr-rBE", "fr-rBF", "fr-rBI", "fr-rBJ",
                        "fr-rCA", "fr-rCD", "fr-rCF",
                        "fr-rCG", "fr-rCM", "fr-rDZ", "fr-rKM", "fr-rTD");
            case "ga":
                return Collections.singletonList("ga-rIE");
            case "hi":
                return Collections.singletonList("hi-rIN");
            case "hu":
                return Collections.singletonList("hu-rHU");
            case "hy":
                return Collections.singletonList("hy-rAM");
            case "in":
                return Collections.singletonList("in-rID");
            case "is":
                return Collections.singletonList("is-rIS");
            case "it":
                return Arrays.asList("it-rCH", "it-rIT", "it-rSM");
            case "km":
                return Collections.singletonList("km-rKH");
            case "kn":
                return Collections.singletonList("kn-rIN");
            case "ky":
                return Collections.singletonList("ky-rKG");
            case "lo":
                return Collections.singletonList("lo-rLA");
            case "lv":
                return Collections.singletonList("lv-rLV");
            case "mk":
                return Collections.singletonList("mk-rMK");
            case "ml":
                return Collections.singletonList("ml-rIN");
            case "mr":
                return Collections.singletonList("mr-rIN");
            case "nn":
                return Collections.singletonList("nn-rNO");
            case "my":
                return Collections.singletonList("my-rMM");
            case "no":
                return Collections.singletonList("no-rNO");
            case "si":
                return Collections.singletonList("si-rLK");
            case "sk":
                return Collections.singletonList("sk-rSK");
            case "pl":
                return Collections.singletonList("pl-rPL");
            case "te":
                return Collections.singletonList("te-rIN");
            case "sq":
                return Collections.singletonList("sq-rMK");
            case "th":
                return Collections.singletonList("th-rTH");
            case "uk":
                return Collections.singletonList("uk-rUA");
            case "zu":
                return Collections.singletonList("zu-rZA");
            case "vi":
                return Collections.singletonList("vi-rVN");
            case "tr":
                return Arrays.asList("tr-rCY", "tr-rTR");
            case "ur":
                return Arrays.asList("ur-rIN", "ur-rPK");
            case "ms":
                return Arrays.asList("ms-rBN", "ms-rMY", "ms-rSG");
            case "nb":
                return Arrays.asList("nb-rNO", "nb-rSJ");
            case "sr":
                return Arrays.asList("sr-rBA", "sr-rME");
            case "sv":
                return Arrays.asList("sv-rAX", "sv-rFI", "sv-rSE");
            case "sw":
                return Arrays.asList("sw-rKE", "sw-rTZ", "sw-rUG");
            case "ta":
                return Arrays.asList("ta-rIN", "ta-rLK", "ta-rMY", "ta-rSG");
            case "ne":
                return Arrays.asList("ne-rIN", "ne-rNP");
            case "pa":
                return Arrays.asList("pa-rIN", "pa-rPK");
            case "ro":
                return Arrays.asList("ro-rMD", "ro-rRO");
            case "ru":
                return Arrays.asList("ru-rBY", "ru-rKG", "ru-rKZ", "ru-rMD", "ru-rRU", "ru-rUA");
            case "pt":
                return Arrays.asList("pt-rAO", "pt-rBR", "pt-rCV", "pt-rGW", "pt-rMO", "pt-rMZ", "pt-rPT", "pt-rST", "pt-rTL");
            case "nl":
                return Arrays.asList("nl-rAW", "nl-rBE", "nl-rBQ", "nl-rCW", "nl-rNL", "nl-rSR", "nl-rSX");


        }
        return new ArrayList<>();
    }

    /**
     * Copy past the cleaned up contents to the final android studio resource file directory
     *
     * @param localeKey - String fullyQualifiedFileName e.g D:/projects/pet-project/src/main/res/values-ar/strings.xml
     * @param contents  - String File Contents to be appended to res file
     * @return boolean              - success status, true if successfully
     */
    @Override
    public boolean pasteContentsToAndroidStudioSourceDir(File rootAndroidStudioResSourceDir, String localeKey, String contents) throws IOException {
        localeKey = localeKey.replace(".xml", "");
        File file = new File(rootAndroidStudioResSourceDir.getAbsolutePath() + "/values-" + localeKey + "/strings.xml");
        String destinationContents = IOUtils.readExternalFileContents(file);
        ContentsExtractor contentsExtractor = new ContentsExtractorImpl();
        String updatedDestinationContents = contentsExtractor
                .replaceDestinationFileContents(destinationContents, "</resources>", "");
       // System.out.println("contents\n");
       // System.out.println(contents);
        System.out.println("\n\n");
        String finalTextContent = updatedDestinationContents.concat(contents);
        System.out.println("================================================");
        System.out.println("finalTextContent");
        System.out.println("================================================");
        System.out.println(finalTextContent);
        System.out.println("================================================");
        //IOUtils.writeStringToFile(file, updatedDestinationContents);
        IOUtils.writeStringToFile(file, finalTextContent);
        return true;
    }
}
