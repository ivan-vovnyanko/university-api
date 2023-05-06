package com.test.universityapi.controller;

import com.test.universityapi.model.Lector;
import com.test.universityapi.service.LectorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class LectorController {

    private final LectorService lectorService;

    @ShellMethod(key = "Global search by")
    public String globalSearchByTemplate(@ShellOption String template) {
        List<Lector> lectors = lectorService.searchLectorsByTemplate(template);
        StringBuilder answer = new StringBuilder();
        lectors.forEach(l -> answer.append(l.getName()).append(", "));
        return answer.substring(0, answer.length() - 2);
    }

}
