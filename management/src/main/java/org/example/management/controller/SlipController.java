package org.example.management.controller;
import lombok.extern.slf4j.Slf4j;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Result;
import org.example.management.pojo.Slip;
import org.example.management.service.SlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/slips")
public class SlipController {
    @Autowired
    private SlipService slipService;

}
