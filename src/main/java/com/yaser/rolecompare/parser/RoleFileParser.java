package com.yaser.rolecompare.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class RoleFileParser {

    public Map<String, Set<String>> parse(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Map<String, Set<String>> result = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            String userName = parts[0];
            Set<String> roles = result.computeIfAbsent(
                    userName,
                    key -> new HashSet<>()
            );
            for (int i = 1; i < parts.length; i++) {
                roles.add(parts[i]);
            }
        }
        return result;
    }
    //    public List<String> readLines(Path path) throws IOException {
//        return Files.readAllLines(path);
//    }

}
