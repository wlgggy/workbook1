package kr.hs.sdh.workbook1.controller;


import kr.hs.sdh.workbook1.entity.Hamburger;
import kr.hs.sdh.workbook1.service.HamburgerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HamburgerRestController {
    private final HamburgerService hamburgerService;

    public HamburgerRestController(final HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping("/lotteria-menus")
    private List<Hamburger> lotteriaMenus(@RequestParam(required = false) String hamburgerName) {

        List<Hamburger> hamburgers = this.hamburgerService.getHamburgers();

        for (Hamburger hamburger : hamburgers) {
            if (hamburgerName.equals(hamburger.getName())) {
                return hamburgers;
            }
        }

        return hamburgers;
    }
}
