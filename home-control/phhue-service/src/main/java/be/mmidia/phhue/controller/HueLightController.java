package be.mmidia.phhue.controller;

import be.mmidia.phhue.model.HueLight;
import be.mmidia.phhue.service.HueLightService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/light")
public class HueLightController {
    @Autowired
    private HueLightService hueLightService;

    @RequestMapping("/lights")
    public Set<HueLight> getLights(@RequestParam final String username) {
        return hueLightService.getPHHueLights();
    }
}
