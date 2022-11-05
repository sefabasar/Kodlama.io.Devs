package io.kodlama.dataAccess.concretes;

import io.kodlama.dataAccess.abstracts.LanguageRepository;
import io.kodlama.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1, "Java"));
        languages.add(new Language(2, "C#"));
        languages.add(new Language(3, "Python"));
        languages.add(new Language(4, "C++"));
        languages.add(new Language(5, "Kotlin"));
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getId(int id) {
        for (Language language : languages) {
            if (language.getId() == id) {
                return language;
            }
        }
        return null;
    }

    @Override
    public void add(Language language) {
        languages.add(language);
    }

    @Override
    public void update(Language language) {
        for (Language language1 : languages) {
            if (language.getId() == language1.getId()) {
                language1.setName(language.getName());
            }
        }
    }

    @Override
    public void delete(int index) {
        languages.remove(index);
    }

}
