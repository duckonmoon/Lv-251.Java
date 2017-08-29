package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dao.RespondDAO;
import com.softserve.edu.lv251.dto.pojos.RespondDTO;
import com.softserve.edu.lv251.entity.Respond;
import com.softserve.edu.lv251.service.RespondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marian Brynetskyi on 23.08.2017.
 */
@Service
public class RespondServiceImpl implements RespondService {

    @Autowired
    private Mapper mapper;
    @Autowired
    private RespondDAO respondDAO;

    @Override
    public List<RespondDTO> getAllRespondsByDoctor(long doctorId) {
        List<RespondDTO> respondDTOS = new LinkedList<>();
        respondDAO.getAllEntities()
                .stream()
                .filter(p->p.getDoctor().getId()==doctorId)
                .forEach(p->respondDTOS.add(mapper.map(p,RespondDTO.class)));
        return respondDTOS;
    }

    @Override
    public List<Respond> getAllRespondsByUser(long userId) {
        return respondDAO.getAllEntities()
                .stream()
                .filter(p->p.getUser().getId()==userId)
                .collect(Collectors.toList());
    }
}
