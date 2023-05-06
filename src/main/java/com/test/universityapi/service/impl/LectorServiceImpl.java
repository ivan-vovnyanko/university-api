package com.test.universityapi.service.impl;

import com.test.universityapi.model.Lector;
import com.test.universityapi.repository.LectorRepository;
import com.test.universityapi.service.LectorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {

    private final LectorRepository lectorRepository;

    @Override
    public List<Lector> searchLectorsByTemplate(String template) {
        return lectorRepository.getLectorsByNameTemplate(template);
    }

    @Override
    public Lector create(Lector lector) {
        return lectorRepository.save(lector);
    }

}
