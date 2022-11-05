package io.kodlama.business.concretes;

import io.kodlama.business.abstracts.LanguageService;
import io.kodlama.dataAccess.abstracts.LanguageRepository;
import io.kodlama.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getId(int id) {
        return this.languageRepository.getId(id);
    }

    @Override
    public void add(Language language) {
        if (languageControl(language)) {
            throw new RuntimeException("Aynı veya boş olamaz.");
        }
        languageRepository.add(language);
    }

    @Override
    public void update(Language language) {
        this.languageRepository.update(language);
    }

    @Override
    public void delete(int id) {

        languageRepository.delete(getIndex(id));
    }

    private int getIndex(int id) {

        List<Language> languages = languageRepository.getAll();
        for (Language language1 : languages){
            if(language1.getId() == id){
               return languages.indexOf(language1);
            }
        }
        throw new RuntimeException("Nesne Bulunamadı!");
    }


    public boolean languageControl(Language language) {

        if(language.getName().equals("")){
            return true;
        }

        List<Language> languages = languageRepository.getAll();
        for (Language language1 : languages) {
            if (language1.getName().equals(language.getName()) || language1.getId() == (language.getId())) {
                return true;
            }
        }
        return false;
    }
}
