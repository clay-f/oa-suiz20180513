package com.f.controller;

import com.f.pojo.Employee;
import com.f.pojo.Voucher;
import com.f.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/vouchers")
@Controller
public class VoucherController {
    @Autowired(required = true)
    @Qualifier(value = "voucherServiceImpl")
    private VoucherService voucherService;

    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request) {
        try {
            Employee user = (Employee) request.getSession().getAttribute("currentUser");
            user.getOaPositionId();
            model.addAttribute("voucherList", voucherService.getAllVouchers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/vouchers/index";
    }

    @RequestMapping(value = "/new")
    public ModelAndView newVoucher(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("voucher", new Voucher());
        modelAndView.setViewName("/vouchers/new");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public String create(@ModelAttribute(value = "user") Voucher user, Model model) {
        if (voucherService.saveVoucher(user) > 0) {
            return "redirect:/vouchers/index";
        }
        model.addAttribute("message", "create false");
        return "/vouchers/new";
    }


    @RequestMapping(value = "/{id}")
    public String show(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("voucher", voucherService.getVoucherById(id));
        return "/vouchers/show";
    }

    @RequestMapping(value = "/{id}/edit")
    public String edit(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("voucher", voucherService.getVoucherById(id));
        return "/vouchers/edit";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id, Model model) {
        if (voucherService.deleteVoucherById(id)) {
            return "redirect:/vouchers/index";
        } else {
            model.addAttribute("message", "delete voucher false");
            return "/vouchers/" + id;
        }
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute(value = "user") Voucher voucher) {
        System.out.println("catch voucher put method");
        voucherService.updateVoucher(voucher);
        return "redirect:index";
    }
}
