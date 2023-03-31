package br.com.ArthurTrindad.api.linguagens;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LinguagemController {
    
    @Autowired()
    private LinguagemRepository repotitory;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        return repotitory.findAll();
    }

    @GetMapping("/linguagens/{id}")
    public Linguagem obterLinguagemPorId(@PathVariable String id) {
        return repotitory.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        return repotitory.save(linguagem);
    }

    @PutMapping("/linguagens/{id}")
    public Linguagem atualizarLinguagemPorId(@PathVariable String id,  @RequestBody Linguagem linguagem) {

        if (!repotitory.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        linguagem.setId(id);
        Linguagem linguagemSalva = repotitory.save(linguagem);
        return linguagemSalva;
    }

    @DeleteMapping("linguagens/{id}")
    public void deletarLiguagem(@PathVariable String id) {
        repotitory.deleteById(id);
    }
}