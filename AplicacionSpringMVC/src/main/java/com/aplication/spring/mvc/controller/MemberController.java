package com.aplication.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class MemberController {
  

    @RequestMapping(method = RequestMethod.GET)
    public String displaySortedMembers(Model model) {
        return "index";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String registerNewMember(@Valid @ModelAttribute("newMember") Member newMember, BindingResult result, Model model) {
//        if (!result.hasErrors()) {
//            try {
//                memberDao.register(newMember);
//                return "redirect:/";
//            } catch (UnexpectedRollbackException e) {
//                model.addAttribute("members", memberDao.findAllOrderedByName());
//                model.addAttribute("error", e.getCause().getCause());
//                return "index";
//            }
//        } else {
//            model.addAttribute("members", memberDao.findAllOrderedByName());
//            return "index";
//        }
//    }
}
