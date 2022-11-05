package io.kodlama.business.abstracts;

import io.kodlama.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();

    Language getId(int id);

    void add(Language language);

    void update(Language language);

    void delete(int id);
}
