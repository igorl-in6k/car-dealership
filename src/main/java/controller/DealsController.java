package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/deals")
public class DealsController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String getDeals(ModelMap modelMap) {
        modelMap.addAttribute("deals", dealService.getAllDeals());
        return "deals";
    }

}
