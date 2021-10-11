package br.com.bscpaz.threads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bscpaz.threads.entity.Defendant;
import br.com.bscpaz.threads.repository.DefendantRepository;

@Service
public class DefendantService {
    
    @Autowired
    private DefendantRepository defendantRepository;

    public List<Defendant> getAll() {
        return defendantRepository.getAll();
    }

}
