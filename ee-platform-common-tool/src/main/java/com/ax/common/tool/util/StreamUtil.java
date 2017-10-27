package com.ax.common.tool.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/10/27.
 */
public class StreamUtil {

    public static <T, D> List<D> mapToList(List<T> list, Function<T, D> function) {
        return list.stream()
                .map(function)
                .collect(Collectors.toList());
    }

}
