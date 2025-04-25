package com.example.rules;

import org.sonar.api.Plugin;
import org.sonar.api.server.rule.RulesDefinition;

public class JavaRulesPlugin implements Plugin {

    @Override
    public void define(Context context) {
        System.out.println("==================");
        System.out.println("======加载插件7=====");
        System.out.println("==================");
        context.addExtensions(
                JavaRulesDefinition.class,
                JavaRulesCheckRegistrar.class
        );
    }

    public static class JavaRulesDefinition implements RulesDefinition {
        @Override
        public void define(Context context) {
            NewRepository repo = context.createRepository("custom-java-rules", "java")
                    .setName("Custom Java Rules");

            // 从类注解中加载规则定义
            repo.createRule(MethodCommentCheck.class.getAnnotation(org.sonar.check.Rule.class).key())
                    .setName("Java方法必须包含注释（Blocker级别）")
                    .setHtmlDescription("所有Java方法必须包含Javadoc注释，否则触发Blocker级别问题。")
                    .setSeverity("BLOCKER");

            repo.done();
        }
    }
}
