package com.example.rules;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;

import java.util.List;

@SonarLintSide
public class JavaRulesCheckRegistrar implements CheckRegistrar {

    @Override
    public void register(RegistrarContext registrarContext) {
        System.out.println("==================");
        System.out.println("======加载插件6=====");
        System.out.println("==================");
        // 确保这里的仓库名称与插件定义中的一致
        registrarContext.registerClassesForRepository("custom-java-rules",
                RulesList.getJavaChecks(),
                RulesList.getJavaTestChecks());
    }
}
