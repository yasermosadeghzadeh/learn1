package com.yaser.rolecompare.controller;

import com.yaser.rolecompare.parser.RoleFileParser;
import com.yaser.rolecompare.service.RoleComparisonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleComparisonController {

    private final RoleFileParser parser;
    private final RoleComparisonService service;

    private final Path baselinePath;
    private final Path currentPath;

    public RoleComparisonController(
            RoleFileParser parser,
            RoleComparisonService service,
            @Value("${app.files.baseline}") String baselineFile,
            @Value("${app.files.current}") String currentFile
    ) {
        this.parser = parser;
        this.service = service;

        this.baselinePath = Path.of(baselineFile);
        this.currentPath = Path.of(currentFile);
    }



    @GetMapping("/compare")
    public Map<String, Set<String>> compare() throws Exception {

        Map<String, Set<String>> baseline =
                parser.parse(baselinePath);

        Map<String, Set<String>> current =
                parser.parse(currentPath);

        return service.findAddedRoles(baseline, current);
    }
}