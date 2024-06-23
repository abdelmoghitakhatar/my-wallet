package com.myapp.floosy.controller;

import com.myapp.floosy.model.Operation;
import com.myapp.floosy.model.Wallet;
import com.myapp.floosy.service.OperationService;
import com.myapp.floosy.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WalletController {

    private final WalletService walletService;
    private final OperationService operationService;

    public WalletController(WalletService walletService, OperationService operationService) {
        this.walletService = walletService;
        this.operationService = operationService;
    }

    @GetMapping("/")
    public String indexPage(Model model){

        Operation operation = new Operation();
        Wallet wallet = walletService.getCurrentState();
        model.addAttribute("wallet", wallet);
        model.addAttribute("op", operation);
        return "index";
    }

    @PostMapping("/")
    public String add(@Valid @ModelAttribute(name = "op") Operation operation, BindingResult result){

        walletService.saveNewWallet(operation);
        return "redirect:/";
    }
}
