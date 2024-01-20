package com.mohamed.easyschool.controller;

import com.mohamed.easyschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean festival,
                                                     @RequestParam(required = false) boolean federal,
                                                      Model theModel) {
        theModel.addAttribute("festival", festival);
        theModel.addAttribute("federal", federal);

        List<Holiday> holidays = Arrays.asList(
                new Holiday("first day", "Eid Adha", Holiday.Type.FESTIVAL),
                new Holiday("first day", "Eid Phiter", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();

        for (Holiday.Type type : types) {
            theModel.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday ->
                            holiday.getType().equals(type)
                    )).collect(Collectors.toList()));
        }
        return "holidays.html";
    }
}
