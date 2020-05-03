package apple.loader;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class MockConceptsLoader implements ConceptsLoader<String> {
    @Override
    public List<String> loadNextBatch(long size) {
        return ImmutableList.of(
                "Indian",
                "Thai",
                "Sushi",
                "Caribbean",
                "Italian",
                "West Indian",
                "Pub",
                "East Asian",
                "BBQ",
                "Chinese",
                "Portuguese",
                "Spanish",
                "French",
                "East European");
    }
}
