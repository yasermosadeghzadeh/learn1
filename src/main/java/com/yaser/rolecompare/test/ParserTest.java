package com.yaser.rolecompare.test;

import com.sun.source.doctree.SerialTree;
import com.yaser.rolecompare.parser.RoleFileParser;
import com.yaser.rolecompare.service.RoleComparisonService;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParserTest {
    public static void main(String[] args) throws Exception {
        //gg();
        RoleFileParser parser = new RoleFileParser();
        RoleComparisonService service = new RoleComparisonService();
        Map<String, Set<String>> baseline = parser.parse(Path.of("data/baseline.txt"));
        Map<String, Set<String>> current = parser.parse(Path.of("data/current.txt"));
        System.out.println(baseline);
        System.out.println(current);

        Map<String, Set<String>> result=service.findAddedRoles(baseline,current);
        System.out.println(result);


//        Path path = Path.of("data/baseline.txt");
//        Map<String, Set<String>> result = parser.parse(path);
//        System.out.println(result);


//        List<String> lines = parser.readLines(path);
//        for (String line :lines) {
//            System.out.println(line);
//        }
    }

//    public static void gg() {
//        System.out.println(
//                Path.of("").toAbsolutePath()
//        );
//    }
}

