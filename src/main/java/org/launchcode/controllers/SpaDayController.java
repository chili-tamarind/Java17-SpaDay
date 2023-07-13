package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
public class SpaDayController {

    public boolean checkSkinType(String skinType, String facialType) {
        if (skinType.equals("oily")) {
            return facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating");
        }
        else if (skinType.equals("combination")) {
            return facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating") || facialType.equals("Enzyme Peel");
        }
        else if (skinType.equals("dry")) {
            return facialType.equals("Rejuvenating") || facialType.equals("Hydrofacial");
        }
        else {
            return true;
        }
    }

    @GetMapping(value="")
    @ResponseBody
    public String customerForm () {
        String html = "<form action='/menu' method ='post'>" + //<!--BONUS #3 action='/menu' -->
                "Name: <br>" +
                "<input type = 'text' name = 'name'>" +
                "<br>Skin type: <br>" +
                "<select name = 'skintype'>" +
                "<option value = 'oily'>Oily</option>" +
                "<option value = 'combination'>Combination</option>" +
                "<option value = 'normal'>Normal</option>" +
                "<option value = 'dry'>Dry</option>" +
                "</select><br>" +
                "Manicure or Pedicure? <br>" +
                "<select name = 'manipedi'>" +
                "<option value = 'manicure'>Manicure</option>" +
                "<option value = 'pedicure'>Pedicure</option>" +
                "<option value = 'both'> Maniure and Pedicure </option>" +
                "</select><br>" +
                "<input type = 'submit' value = 'Submit'>" +
                "</form>";
        return html;
    }

    @PostMapping(value="/menu") //<!--BONUS #3-->
    public String spaMenu(@RequestParam String name, @RequestParam String skintype, @RequestParam String manipedi, Model model) {

        ArrayList<String> facials = new ArrayList<>();
        facials.add("Microdermabrasion");
        facials.add("Hydrofacial");
        facials.add("Rejuvenating");
        facials.add("Enzyme Peel");

        ArrayList<String> appropriateFacials = new ArrayList<>();
        for (int i = 0; i < facials.size(); i ++) {
            if (checkSkinType(skintype,facials.get(i))) {
                appropriateFacials.add(facials.get(i));
            }
        }

        // Additions to Start Code >> 1
        model.addAttribute("appropriateFacials", appropriateFacials);

        // Additions to Start Code >> 2
        // Add css folder in resources>static, move style.css to the folder

        model.addAttribute("name", name);
        model.addAttribute("skintype", skintype);
        model.addAttribute("manipedi", manipedi);

        // BONUS MISSIONS #1
        ArrayList<String> polishColorChoices = new ArrayList<>();
        polishColorChoices.add("#dc143c");
        polishColorChoices.add("#3cb371");
        polishColorChoices.add("#daa520");
        polishColorChoices.add("#6a5acd");
        polishColorChoices.add("#ff7f50");
        polishColorChoices.add("#ff6347");
        polishColorChoices.add("#00bfff");
        polishColorChoices.add("#da70d6");
        polishColorChoices.add("#4682b4");
        polishColorChoices.add("#c71585");
        model.addAttribute("polishColorChoices", polishColorChoices);

        return "menu";
    }
}
