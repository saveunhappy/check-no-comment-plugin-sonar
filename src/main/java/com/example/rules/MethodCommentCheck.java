package com.example.rules;

import org.sonar.check.Rule;
import org.sonar.check.Priority;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.SyntaxTrivia;
import java.util.Collections;
import java.util.List;

@Rule(
        key = "MethodMustHaveComment",
        name = "Java方法必须包含注释（Blocker级别）",
        description = "所有Java方法必须包含Javadoc注释，否则触发Blocker级别问题。",
        priority = Priority.BLOCKER,
        tags = {"convention"}
)
public class MethodCommentCheck extends IssuableSubscriptionVisitor {

    @Override
    public List<Kind> nodesToVisit() {
        return Collections.singletonList(Kind.METHOD);
    }

    @Override
    public void visitNode(Tree tree) {
        System.out.println("==================");
        System.out.println("======加载插件8=====");
        System.out.println("==================");
        MethodTree methodTree = (MethodTree) tree;

        // 跳过构造函数
        if (isConstructor(methodTree)) {
            return;
        }

        if (!hasJavadocComment(methodTree)) {
            reportIssue(methodTree.simpleName(), "方法必须包含Javadoc注释（Blocker级别）");
        }
    }

    private boolean isConstructor(MethodTree methodTree) {
        // 构造函数没有返回类型
        return methodTree.returnType() == null;
    }

    private boolean hasJavadocComment(MethodTree methodTree) {
        System.out.println("==================");
        System.out.println("======加载插件9=====");
        System.out.println("==================");
        // 检查方法前的注释
        if (methodTree.firstToken() != null && methodTree.firstToken().trivias() != null) {
            for (SyntaxTrivia trivia : methodTree.firstToken().trivias()) {
                if (trivia.comment().startsWith("/**")) {
                    return true;
                }
            }
        }

        return false;
    }
}
