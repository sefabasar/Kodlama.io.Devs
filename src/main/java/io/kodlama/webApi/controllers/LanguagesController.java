package io.kodlama.webApi.controllers;

import io.kodlama.business.abstracts.LanguageService;
import io.kodlama.entities.concretes.Language;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {
    private final LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/get-all")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/get-id")
    //@Operation(summary = "**Kayıtlı datayı Id'sine göre arattığınızda getirir.**",tags = "Software Languages Application")
    public Language getId(@RequestParam int id) throws Exception {
        return languageService.getId(id);
    }

    @PostMapping("/add-name")
    public String add(@RequestBody Language language) {
        languageService.add(language);
        return "Listeye "+language.getId() + " numaralı, " + language.getName() + " eklenmiştir.";
    }

    @PutMapping("/update-name")
    public String update(@RequestBody Language language){
        this.languageService.update(language);
        return language.getId() + " numaralı dilin adı " + language.getName() + " olarak güncellenmiştir.";
    }

    @DeleteMapping("/delete")
    public String delete (@RequestParam int id){
        languageService.delete(id);
        return id + "numaralı dil silinmiştir.";
    }
}
