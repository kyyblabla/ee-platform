package com.ax.common.annotation;

import java.lang.annotation.*;

/**
 * 标识jpa dao接口
 * Created by kyy on 2017/9/12.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JpaDao {

}
