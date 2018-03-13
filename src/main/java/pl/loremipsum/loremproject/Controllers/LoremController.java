package pl.loremipsum.loremproject.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.loremipsum.loremproject.Models.LoremGenerator;

import javax.validation.Valid;

@Controller
public class LoremController {

    @GetMapping("/")
    public String generateText(LoremGenerator loremGenerator){
        return "generate";
    }

    @PostMapping("/")
    public String checkProductInfo(@Valid LoremGenerator loremGenerator, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "generate";
        }
        redirectAttributes.addFlashAttribute("text", loremGenerator.generateText());
        return "redirect:/result"; // mapping onto /result
    }
    @GetMapping("/result")
    public String showResults(){
        return "show";
    }

}
