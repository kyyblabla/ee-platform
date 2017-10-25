package com.ax.system.user.vo;

import com.ax.common.vo.TreeNode;
import lombok.Data;

import java.util.List;

/**
 * Created by kyy on 2017/10/24.
 */
@Data
public class MenuTree extends TreeNode {
    private String code;
    private String title;
    private Long parentId;
    private String path;
    private String href;
    private String icon;
    private String orderNum;
    private List<Object> metaData;
}
