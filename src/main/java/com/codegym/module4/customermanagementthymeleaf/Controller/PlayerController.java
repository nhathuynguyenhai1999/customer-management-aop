package com.codegym.module4.customermanagementthymeleaf.Controller;

import com.codegym.module4.customermanagementthymeleaf.Exception.DuplicateEmailException;
import com.codegym.module4.customermanagementthymeleaf.Model.Player;
import com.codegym.module4.customermanagementthymeleaf.Model.Positions;
import com.codegym.module4.customermanagementthymeleaf.Service.iml.IPlayerService;
import com.codegym.module4.customermanagementthymeleaf.Service.iml.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class PlayerController {

    @Autowired
    private IPlayerService customerService;

    @Autowired
    private IPositionService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Positions> listProvinces() {
        return provinceService.findAll();
    }

    /*
    @GetMapping
    public ModelAndView listCustomer(@RequestParam(defaultValue = "0") int page,Pageable pageable) {
        pageable = PageRequest.of(page, 4);
        Page<Player> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

     */

    @GetMapping
    public ModelAndView listCustomers(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        try {
            Pageable pageable = PageRequest.of(page,4);
            Page<Player> customersPlayer = customerService.findAll(pageable);
            modelAndView.addObject("customers",customersPlayer);
        } catch (Exception e){
            modelAndView.addObject("error","An error occurred while retrieving the list of players.");
        }
        return modelAndView;
    }


    /*
    @GetMapping
    public ModelAndView showListCustomer() {
        try {
            ModelAndView modelAndView = new ModelAndView("/customer/list");
            List<Player> playerList = customerService.findAll1();
            modelAndView.addObject("customers", playerList);
            return modelAndView;
        } catch (Exception e){
            return new ModelAndView("redirect:/customers");
        }
    }

     */
    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/customer/info");
            Player customer = customerService.findOne(id);
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }

    @GetMapping("/search")
    public ModelAndView listCustomersSearch(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Player> customers;
        if(search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(pageable, search.get());
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Player());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Player customer,
                         RedirectAttributes redirectAttributes) throws DuplicateEmailException {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create new customer successfully");
        return "redirect:/customers";
    }

    @PostMapping("/save")
    public String save(Player customer) throws DuplicateEmailException {
        customerService.save(customer);
        return "redirect:/customers";
    }



    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Player> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/update");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    /*
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("customer") Player customer,
                         RedirectAttributes redirect) throws DuplicateEmailException {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Update customer successfully");
        return "redirect:/customers";
    }

     */

    @PostMapping("/update/{id}")
    public ModelAndView updateForm(@Valid @ModelAttribute("customer") Player customer,
                                   BindingResult bindingResult, RedirectAttributes redirect) throws DuplicateEmailException {
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/customer/update");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        customerService.save(customer);
        redirect.addFlashAttribute("message","Update players successfully...");
        return new ModelAndView("redirect:/customers");
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Delete customer successfully");
        return "redirect:/customers";
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/inputs-not-acceptable");
    }
}