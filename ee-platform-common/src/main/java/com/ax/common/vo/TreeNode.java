package com.ax.common.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyy on 2017/10/24.
 */
@Data
public class TreeNode {

    protected Long id;
    protected Long parentId;
    protected Integer orderNum;
    private List<TreeNode> children = new ArrayList<>();

}
