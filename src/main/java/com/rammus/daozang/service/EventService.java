package com.rammus.daozang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rammus.daozang.domain.Event;
import com.rammus.daozang.mapper.EventMapper;

import jakarta.annotation.Resource;

@Service
public class EventService {
    
    @Resource
    private EventMapper eventMapper;

    public void addEvent(Event event) {
        eventMapper.insert(event);
    }

    public List<Event> listEvents() {
        return eventMapper.selectByExample(null);
    }

    public void updateEvent(Event event) {
        //eventMapper.updateByExample(event);
    }
}
