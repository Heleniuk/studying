package apple;

import apple.indexing.Indexer;
import apple.loader.Preprocessor;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ConceptsFinder {
    private final Preprocessor preprocessor = new Preprocessor();
    private static final Indexer indexer = new Indexer();
    private static final Trie<String> CONCEPTS;

    static {
        CONCEPTS = indexer.performIndexing();
    }

    public List<String> search(String input) {
        String[] inputWords = preprocessor.prepare(input);

        Node<String> start = CONCEPTS.getStart();
        List<String> result = new ArrayList<>();
        Set<String> phrase = new LinkedHashSet<>();

        int wordIndex = 0;
        Node<String> currentConcept = start;

        while (wordIndex < inputWords.length) {
            String currentWordKey = inputWords[wordIndex].toLowerCase();
            Node<String> matchingChild = currentConcept.getChildren().get(currentWordKey);

            if (matchingChild != null) {
                phrase.add(matchingChild.getValue());
                currentConcept = matchingChild;
            } else {
                currentConcept = start;
            }
            wordIndex++;

            if (currentConcept.getChildren().isEmpty()) {
                result.add(String.join(" ", phrase));

                wordIndex = wordIndex - phrase.size() + 1;
                phrase.clear();
                currentConcept = start;
            }
        }
        return result;
    }
}
