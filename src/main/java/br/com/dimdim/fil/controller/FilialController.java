package br.com.dimdim.fil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;

import br.com.dimdim.fil.repository.FilialRepository;
import br.com.dimdim.fil.repository.EnderecoRepository;
import br.com.dimdim.fil.model.Filial;


@Controller
@RequestMapping({"", "/filiais"})
public class FilialController {

    private final FilialRepository filialRepository;
    private final EnderecoRepository enderecoRepository;

    public FilialController(FilialRepository filialRepository, EnderecoRepository enderecoRepository) {
        this.filialRepository = filialRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping("/filiais")
    public String listar(Model model) {
        model.addAttribute("filiais", filialRepository.findAll());
        return "filial/lista";
    }

    @GetMapping({"/filial/novo", "/filiais/filial/novo"})
    public String novo(Model model) {
        model.addAttribute("filial", new Filial());
        model.addAttribute("enderecos", enderecoRepository.findAll());
        return "filial/form";
    }

    @PostMapping({"/filial/salvar", "/filiais/filial/salvar"})
    public String salvar(@Valid Filial filial, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("enderecos", enderecoRepository.findAll());
            return "filial/form";
        }
        filialRepository.save(filial);
        return "redirect:/filiais";
    }

    @GetMapping({"/filial/editar/{id}", "/filiais/filial/editar/{id}"})
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("filial", filialRepository.findById(id).orElseThrow());
            model.addAttribute("enderecos", enderecoRepository.findAll());
            return "filial/form";
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("erro", "Registro de filial não encontrado.");
            return "redirect:/filiais";
        }
    }

    @PostMapping({"/filial/atualizar/{id}", "/filiais/filial/atualizar/{id}"})
    public String atualizar(@PathVariable Long id, @Valid Filial filial, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("enderecos", enderecoRepository.findAll());
            return "filial/form";
        }
        filial.setId(id);
        filialRepository.save(filial);
        return "redirect:/filiais";
    }

    @GetMapping({"/filial/remover/{id}", "/filiais/filial/remover/{id}"})
    public String remover(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            filialRepository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("erro", "Não é possível remover a filial: ela está vinculada a outros registros.");
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("erro", "Falha ao remover a filial. Tente novamente mais tarde.");
        }
        return "redirect:/filiais";
    }

    @GetMapping({"/filial/detalhes/{id}", "/filiais/filial/detalhes/{id}"})
    public String detalhes(@PathVariable Long id, Model model) {
        model.addAttribute("filial", filialRepository.findById(id).orElseThrow());
        return "filial/detalhes";
    }
}
