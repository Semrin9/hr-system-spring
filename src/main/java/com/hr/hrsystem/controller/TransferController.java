package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.TransferDto;
import com.hr.hrsystem.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransferController {

    private TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/transfers")
    public String listTransfers(Model model) {
        List<TransferDto> transfers = transferService.findAllTransfers();
        model.addAttribute("transfers", transfers);
        return "transfers-list";
    }

    @GetMapping("/transfers/{id}/delete")
    public String deleteTransfer (@PathVariable("id") Integer id) {
        transferService.delete(id);
        return "redirect:/transfers";
    }
}
