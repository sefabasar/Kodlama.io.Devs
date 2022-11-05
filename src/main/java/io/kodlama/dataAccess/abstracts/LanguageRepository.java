package io.kodlama.dataAccess.abstracts;

import io.kodlama.entities.concretes.Language;
import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();

    Language getId(int id);

    void add(Language language);

    void update(Language language);

    void delete(int id);
}
