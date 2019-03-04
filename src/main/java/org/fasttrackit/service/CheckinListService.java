package org.fasttrackit.service;

import org.fasttrackit.dto.CheckinListDTO;
import org.fasttrackit.model.CheckinList;
import org.fasttrackit.repo.CheckinListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



@Service
public class CheckinListService {

    @Autowired
    private CheckinListRepository checkinListRepository;

    @Transactional
    public List<CheckinListDTO> getAllAgendas() {
        List<CheckinListDTO> result = new ArrayList<>();
        Iterator<CheckinList> iterator = checkinListRepository.findAll().iterator();
        while (iterator.hasNext()) {
            CheckinList next = iterator.next();
            result.add(ConvertorUtils.convertToDto(next));
        }
        return result;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }


    @Transactional
    public CheckinListDTO getAgenda(long id) {
        CheckinList one = checkinListRepository.findOne(id);
        if (one == null) {
            throw new IllegalArgumentException("Invalid id");
        }
        CheckinListDTO dto = ConvertorUtils.convertToDto(one);
        return dto;
    }


}
