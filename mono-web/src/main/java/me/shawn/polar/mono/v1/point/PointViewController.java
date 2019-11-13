package me.shawn.polar.mono.v1.point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/points")
public class PointViewController {

    @Autowired
    PointRedisRepository pointRedisRepository;

    @GetMapping("/{id}")
    public String getPointViewById(Model model, @PathVariable String id) {

        Point point = pointRedisRepository.findById(id).orElse(Point.MOCK);
        model.addAttribute("point", point);
        return "point/point";
    }
}
