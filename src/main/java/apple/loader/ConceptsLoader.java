package apple.loader;

import java.util.List;

public interface ConceptsLoader<T> {
    List<T> loadNextBatch(long size);
}
