package com.example.rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.sonar.plugins.java.api.JavaCheck;

public final class RulesList {

    private RulesList() {
    }

    public static List<Class<? extends JavaCheck>> getChecks() {
        List<Class<? extends JavaCheck>> checks = new ArrayList<>();
        checks.addAll(getJavaChecks());
        checks.addAll(getJavaTestChecks());
        return Collections.unmodifiableList(checks);
    }

    public static List<Class<? extends JavaCheck>> getJavaChecks() {
        return Collections.unmodifiableList(Arrays.asList(
                MethodCommentCheck.class
        ));
    }

    public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
        return Collections.emptyList();
    }
}
