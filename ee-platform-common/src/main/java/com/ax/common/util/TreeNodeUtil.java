package com.ax.common.util;

import com.ax.common.vo.TreeNode;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * Created by kyy on 2017/10/24.
 */
public class TreeNodeUtil {

    public static List<TreeNode> build(Long rootId, List<TreeNode> treeNodes) {
        //排序
        treeNodes.forEach(treeNode -> treeNodes.sort(Comparator.comparingInt(TreeNode::getOrderNum)));
        List<TreeNode> tree = Lists.newArrayList();
        treeNodes.forEach(treeNode -> {
            if (rootId.equals(treeNode.getParentId())) {
                tree.add(treeNode);
            }
            addChildrenTreeNodes(treeNode, treeNodes);
        });
        return tree;
    }

    private static void addChildrenTreeNodes(TreeNode parentTreeNode, List<TreeNode> treeNodes) {
        treeNodes.forEach(treeNode -> {
            if (treeNode.getParentId().equals(treeNode.getId())) {
                if (parentTreeNode.getChildren() == null) {
                    parentTreeNode.setChildren(Lists.newArrayList());
                }
                parentTreeNode.getChildren().add(treeNode);
            }
        });
    }

}
