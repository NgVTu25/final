package com.example.demo.controller;

import com.example.demo.model.ProductFormula;
import com.example.demo.service.ProductFormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/formulas")
public class ProductFormulaController {

    @Autowired
    private ProductFormulaService productFormulaService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping
    public String viewFormulas(Model model) {
        model.addAttribute("formulas", productFormulaService.getAllProductFormulas());
        return "formulas";
    }

    @GetMapping("/{id}")
    public String viewFormulaDetail(@PathVariable String id, Model model) {
        Optional<ProductFormula> formula = productFormulaService.getProductFormulaById(id);
        if (formula.isPresent()) {
            model.addAttribute("formula", formula.get());
            return "formula-detail";
        } else {
            model.addAttribute("errorMessage", "Product formula not found");
            return "error";
        }
    }

    @GetMapping("/add")
    public String addFormulaForm(Model model) {
        ProductFormula formula = new ProductFormula();
        formula.setExcipients(new ArrayList<>());
        formula.setFormulaVersions(new ArrayList<>());
        model.addAttribute("formula", formula);
        return "formula-add";
    }

    @PostMapping("/add")
    public String addFormula(@ModelAttribute ProductFormula formula, Model model) {
        productFormulaService.saveProductFormula(formula);
        return "redirect:/formulas";
    }

    @GetMapping("/edit/{id}")
    public String editFormulaForm(@PathVariable String id, Model model, Authentication authentication) {
        Optional<ProductFormula> formula = productFormulaService.getProductFormulaById(id);
        if (formula.isPresent()) {
            if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                model.addAttribute("errorMessage", "Admins are not allowed to edit product formulas");
                return "error";
            }
            model.addAttribute("formula", formula.get());
            return "formula-edit";
        } else {
            model.addAttribute("errorMessage", "Product formula not found");
            return "error";
        }
    }

    @PostMapping("/edit")
    public String editFormula(@ModelAttribute("formula") ProductFormula formula, Model model) {
        productFormulaService.saveProductFormula(formula);
        model.addAttribute("successMessage", "Product formula updated successfully");
        return "redirect:/formulas";
    }

    @GetMapping("/delete/{id}")
    public String deleteFormula(@PathVariable String id, Model model) {
        if (productFormulaService.deleteProductFormula(id)) {
            model.addAttribute("successMessage", "Product formula deleted successfully");
        } else {
            model.addAttribute("errorMessage", "Product formula not found");
        }
        return "redirect:/formulas";
    }
}