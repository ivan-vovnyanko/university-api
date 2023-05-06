package com.test.universityapi.service;

import com.test.universityapi.model.Lector;
import java.util.List;

public interface LectorService {

    List<Lector> searchLectorsByTemplate(String template);

    Lector create(Lector lector);

}
