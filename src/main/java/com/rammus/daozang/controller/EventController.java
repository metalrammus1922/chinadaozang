package com.rammus.daozang.controller;

import com.rammus.daozang.resp.CommonResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rammus.daozang.domain.Event;
import com.rammus.daozang.service.EventService;

import jakarta.annotation.Resource;

import java.util.List;

@RestController
public class EventController {
    @Resource
    private EventService eventService;
    
    @PostMapping("/add")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

    @GetMapping("/list")
    public CommonResp ebooklist(Event event){
        CommonResp<List<Event>> resp=new CommonResp<>();
        List<Event> list=eventService.listEvents();
        resp.setContent(list);
        return  resp;
    }
}
