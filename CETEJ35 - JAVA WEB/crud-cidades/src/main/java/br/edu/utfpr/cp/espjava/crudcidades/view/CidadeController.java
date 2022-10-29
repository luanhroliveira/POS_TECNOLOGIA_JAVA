package br.edu.utfpr.cp.espjava.crudcidades.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class CidadeController {

    private Set<Cidade> cidades;

    public CidadeController() {
        this.cidades = new HashSet<>();
    }

    @GetMapping("/")
    public String listar(Model memoria) {

        memoria.addAttribute("listaCidades", this.cidades);

        return "/crud";
    }

    @PostMapping("/criar")
    public String criar(
        @Valid Cidade cidade,
        BindingResult validacao,
        Model memoria
    ) {
        if (validacao.hasErrors()) {
            validacao.getFieldErrors()
                .forEach(
                    fieldError ->
                        memoria.addAttribute(fieldError.getField(), fieldError.getDefaultMessage())
                );

            memoria.addAttribute("nomeInformado", cidade.getNome());
            memoria.addAttribute("estadoInformado", cidade.getEstado());
            memoria.addAttribute("listaCidades", this.cidades);

            return "/crud";
        } else {
            this.cidades.add(cidade);
        }

        return "redirect:/";
    }

    @GetMapping("/excluir")
    public String excluir(
        @RequestParam String nome,
        @RequestParam String estado
    ) {

        this.cidades.removeIf(
            cidade -> cidade.getNome().equals(nome) &&
                cidade.getEstado().equals(estado)
        );

        return "redirect:/";
    }

    @GetMapping("/preparaAlterar")
    public String preparaAlterar(
        @RequestParam String nome,
        @RequestParam String estado,
        Model memoria
    ) {
        var cidadeAtual =
            this.cidades
                .stream()
                .filter(cidade -> cidade.getNome().equals(nome) && cidade.getEstado().equals(estado))
                .findFirst();

        if (cidadeAtual.isPresent()) {
            memoria.addAttribute("cidadeAtual", cidadeAtual.get());
            memoria.addAttribute("listaCidades", this.cidades);
        }

        return "/crud";
    }

    @PostMapping("/alterar")
    public String alterar(
        @RequestParam String nomeAtual,
        @RequestParam String estadoAtual,
        Cidade cidade,
        BindingResult bindingResult,
        Model model
    ) {

        this.cidades
            .removeIf(cidade1 -> cidade1.getNome().equals(nomeAtual) &&
                cidade1.getEstado().equals(estadoAtual));

        this.criar(cidade, bindingResult, model);

        return "redirect:/";
    }
}
