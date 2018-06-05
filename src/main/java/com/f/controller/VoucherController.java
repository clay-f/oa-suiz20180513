package com.f.controller;

import com.f.helper.OutputJsonHelper;
import com.f.pojo.Employee;
import com.f.pojo.Voucher;
import com.f.services.VoucherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;
import java.util.Map;

@RequestMapping(value = "/vouchers")
@Controller
public class VoucherController {
    private OutputJsonHelper outputJsonHelper = OutputJsonHelper.getJsonOutputInstance();
    private Logger logger = LogManager.getLogger(VoucherController.class);

    @Autowired(required = true)
    @Qualifier(value = "voucherServiceImpl")
    private VoucherService voucherService;

    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request) {
        Map<String, Object> map = new Hashtable<String, Object>();
        try {
            Employee user = (Employee) request.getSession().getAttribute("currentUser");
            System.out.println(outputJsonHelper.outputJsonVal(user));
            Integer oaPosition = user.getOaPositionId();
            switch (oaPosition) {
                case 1:
                    map.put("userId", user.getId());
                    break;
                case 2:
                    map.put("chargeId", user.getId());
                    break;
                case 3:
                    map.put("managerId", user.getId());
                    break;
                case 4:
                    map.put("financeId", user.getId());
                    break;
            }
            model.addAttribute("voucherList", voucherService.getVoucherByCondition(map));
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
    public String create(@ModelAttribute(value = "user") Voucher user, Model model, HttpServletRequest request) {
        Employee currentUser = (Employee) request.getSession().getAttribute("currentUser");
        user.setEmployeeId(currentUser.getId());
        return "redirect:/vouchers/index";
    }


    @RequestMapping(value = "/{id}")
    public String show(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("voucher", voucherService.get(id));
        return "/vouchers/show";
    }

    @RequestMapping(value = "/{id}/edit")
    public String edit(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("voucher", voucherService.get(id));
        return "/vouchers/edit";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id, Model model) {
        voucherService.delete(id);
        return "redirect:/vouchers/index";

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute(value = "user") Voucher voucher, @SessionAttribute(required = true) Employee currentUser) throws JsonProcessingException {
        Voucher previousVoucher = voucherService.get(voucher.getId());
        switch (currentUser.getOaPositionId()) {
            case 1:
                previousVoucher.getVoucherDetail().setDes(voucher.getVoucherDetail().getDes());
                previousVoucher.setItem(voucher.getItem());
                previousVoucher.setAccount(voucher.getAccount());
                break;
            case 2:
                previousVoucher.getCheckResult().setStateId(voucher.getCheckResult().getStateId());
                break;
            case 3:
                previousVoucher.getCheckResult().setStateId(voucher.getCheckResult().getStateId());
                break;
            case 4:
                previousVoucher.setCheckOutStateId(voucher.getCheckOutStateId());
                break;
        }
        voucherService.update(previousVoucher);
        return "redirect:/vouchers/index";
    }
}
