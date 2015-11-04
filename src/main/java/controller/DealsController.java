package controller;

import core.service.StaffManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/deals")
public class DealsController {

    @Autowired
    private StaffManagementService managerService;

    @RequestMapping(method = RequestMethod.GET)
    public String getDeals(ModelMap modelMap) {
        modelMap.addAttribute("deals", managerService.getAllDeals());
        return "deals";
    }

}
