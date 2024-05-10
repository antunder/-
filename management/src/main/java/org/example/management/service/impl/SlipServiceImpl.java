package org.example.management.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.SlipMapper;
import org.example.management.service.SlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SlipServiceImpl implements SlipService {
    @Autowired
    private SlipMapper slipMapper;
}
