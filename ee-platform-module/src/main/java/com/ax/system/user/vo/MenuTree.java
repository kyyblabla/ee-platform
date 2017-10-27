package com.ax.system.user.vo;

import com.ax.common.vo.TreeNode;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kyy on 2017/10/24.
 */
@Data
public class MenuTree extends TreeNode {
    private String title;
    private String remark;
    private String icon;
    private String href;
    private Integer isHidden;
    private Long createBy;
    private Long modifyBy;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
