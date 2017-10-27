package com.ax.common.util;

import com.ax.common.vo.TreeNode;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * Created by kyy on 2017/10/24.
 */
public class TreeNodeUtil<T extends TreeNode> {


    public static <T extends TreeNode> List<T> build(Long rootId, List<T> treeNodes) {
        //排序
        List<T> tree = Lists.newArrayList();
        treeNodes.forEach(treeNode -> {
            if (rootId.equals(treeNode.getParentId())) {
                tree.add(treeNode);
            }
            addChildrenTreeNodes(treeNode, treeNodes);
        });
        sortTree(tree);
        return tree;
    }

    private static <T extends TreeNode> void sortTree(List<T> treeNodes) {
        treeNodes.forEach(t -> {
            t.getChildren().sort(Comparator.comparingLong(TreeNode::getOrderNum));
            //递归
            sortTree(t.getChildren());
        });
        treeNodes.sort(Comparator.comparingLong(TreeNode::getOrderNum));
    }

    private static <T extends TreeNode> void addChildrenTreeNodes(T parentTreeNode, List<T> treeNodes) {
        treeNodes.forEach(treeNode -> {
            if (treeNode.getParentId().equals(parentTreeNode.getId())) {
                if (parentTreeNode.getChildren() == null) {
                    parentTreeNode.setChildren(Lists.newArrayList());
                }
                parentTreeNode.getChildren().add(treeNode);
            }
        });
    }


}
