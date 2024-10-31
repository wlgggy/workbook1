package kr.hs.sdh.workbook1.controller;


import kr.hs.sdh.workbook1.entity.Hamburger;
import kr.hs.sdh.workbook1.service.HamburgerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HamburgerRestController {
    private final HamburgerService hamburgerService;

    public HamburgerRestController(final HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping("/lotteria-menus")
    private List<Hamburger> lotteriaMenus(@RequestParam(defaultValue = "") String hamburgerName) {
        List<Hamburger> hamburgers = hamburgerService.getHamburgers();
        List<Hamburger> filterHamburgers = new ArrayList<>();

        for (int i = 0; i < hamburgers.size(); i++) {
            Hamburger hamburger = hamburgers.get(i);

            if (hamburger.getName().contains(hamburgerName)) {
                filterHamburgers.add(hamburger);
            }
        }

        return filterHamburgers;
    }
}
