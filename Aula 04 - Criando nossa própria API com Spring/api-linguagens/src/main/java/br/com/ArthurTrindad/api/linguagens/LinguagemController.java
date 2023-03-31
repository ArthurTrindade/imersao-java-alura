package br.com.ArthurTrindad.api.linguagens;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {
    
    @Autowired()
    private LinguagemRepository repotitory;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        return repotitory.findAll();
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        return repotitory.save(linguagem);
    }
}
