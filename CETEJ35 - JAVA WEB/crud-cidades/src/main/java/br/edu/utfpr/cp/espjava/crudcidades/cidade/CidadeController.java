package br.edu.utfpr.cp.espjava.crudcidades.cidade;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CidadeController {

    private final CidadeRepository repository;

    public CidadeController(final CidadeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String listar(
        Model memoria,
        Principal usuario,
        HttpSession sessao,
        HttpServletResponse response
    ) {

        response.addCookie(new Cookie("listar", LocalDateTime.now().toString()));

        memoria.addAttribute(
            "listaCidades",
            this.getAllCidades());

        sessao.setAttribute("usuarioAtual", usuario.getName());

        return "/crud";
    }

    private List<Cidade> getAllCidades() {
        return this.repository.findAll().stream()
            .map(cidadeEntity -> new Cidade(cidadeEntity.getNome(), cidadeEntity.getEstado()))
            .collect(Collectors.toList());
    }

    @PostMapping("/criar")
    public String criar(
        @Valid Cidade cidade,
        BindingResult validacao,
        Model memoria,
        HttpServletResponse response
    ) {

        response.addCookie(new Cookie("criar", LocalDateTime.now().toString()));

        if (validacao.hasErrors()) {
            validacao.getFieldErrors()
                .forEach(
                    fieldError ->
                        memoria.addAttribute(fieldError.getField(), fieldError.getDefaultMessage())
                );

            memoria.addAttribute("nomeInformado", cidade.getNome());
            memoria.addAttribute("estadoInformado", cidade.getEstado());
            memoria.addAttribute(
                "listaCidades",
                this.getAllCidades());

            return "/crud";
        } else {
            this.repository.save(cidade.clonar());
        }

        return "redirect:/";
    }

    @GetMapping("/excluir")
    public String excluir(
        @RequestParam String nome,
        @RequestParam String estado,
         HttpServletResponse response
    ) {

        response.addCookie(new Cookie("excluir", LocalDateTime.now().toString()));

        Optional<CidadeEntity> cidade = this.repository.findByNomeAndEstado(nome, estado);

        cidade.ifPresent(this.repository::delete);

        return "redirect:/";
    }

    @GetMapping("/preparaAlterar")
    public String preparaAlterar(
        @RequestParam String nome,
        @RequestParam String estado,
        Model memoria
    ) {
        var cidadeAtual = this.repository.findByNomeAndEstado(nome, estado);

        cidadeAtual.ifPresent(cidadeEntity -> {
            memoria.addAttribute("cidadeAtual", cidadeAtual.get());
            memoria.addAttribute("listaCidades", this.getAllCidades());
        });

        return "/crud";
    }

    @PostMapping("/alterar")
    public String alterar(
        @RequestParam String nomeAtual,
        @RequestParam String estadoAtual,
        Cidade cidade,
         HttpServletResponse response
    ) {

        response.addCookie(new Cookie("alterar", LocalDateTime.now().toString()));

        var cidadeAtual = this.repository.findByNomeAndEstado(nomeAtual, estadoAtual);

        cidadeAtual.ifPresent(cidadeEntity -> {
            cidadeEntity.setNome(cidade.getNome());
            cidadeEntity.setEstado(cidade.getEstado());
            this.repository.saveAndFlush(cidadeEntity);
        });

        return "redirect:/";
    }

    @GetMapping("/mostrar")
    @ResponseBody
    public String mostraCookie(@CookieValue String listar){
        return "Ultimo acesso ao metodo listar(): " + listar;
    }
}
