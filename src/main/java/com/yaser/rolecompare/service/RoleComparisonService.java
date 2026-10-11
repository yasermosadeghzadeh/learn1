package com.yaser.rolecompare.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleComparisonService {
    public Map<String, Set<String>> findAddedRoles(
            Map<String, Set<String>> baseline,
            Map<String, Set<String>> current
    ) {
        Map<String, Set<String>> result = new HashMap<>();

        for (String userName : current.keySet()) {
            Set<String> currentRoles = current.get(userName);
            Set<String> baselineRoles = baseline.getOrDefault(
                    userName,
                    Collections.emptySet()
            );
            Set<String> addedRoles = new HashSet<>(currentRoles);
            addedRoles.removeAll(baselineRoles);
            if (!addedRoles.isEmpty()) {
                result.put(userName, addedRoles);
            }
        }
        return result;
    }
}
