package com.ax.system.user.vo;

import com.ax.common.vo.TreeNode;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kyy on 2017/10/24.
 */
@Data
public class MenuTree extends TreeNode {

    private String menuCode;
    private String menuTitle;
    private String href;
    private String menuIcon;

}
