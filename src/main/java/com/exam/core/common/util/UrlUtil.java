package com.exam.core.common.util;

import com.exam.core.common.metadata.PathInfo;

import java.util.Arrays;
import java.util.List;

public class UrlUtil {

    public static List<String> parsePath(String uri) {
        return Arrays.asList(uri.split("/"));
    }

    public static PathInfo parsePathInfo(String uri) {
        int slashCount = StrUtil.countOccurrences(uri, "/");
        if (slashCount < 1 || slashCount > 3) {
//            throw new IllegalArgumentException("无法解析uri到PathInfo对象");
            throw new IllegalArgumentException("Unable to parse uri to PathInfo object");
        }
        PathInfo pathInfo = new PathInfo();
        if (slashCount == 1) {
            pathInfo.setModule("index");
            pathInfo.setController(uri.split("/")[1]);
            pathInfo.setAction("index");
        } else if (slashCount == 2) {
            pathInfo.setModule("index");
            pathInfo.setController(uri.split("/")[1]);
            pathInfo.setAction(uri.split("/")[2]);
        } else {
            pathInfo.setModule(uri.split("/")[1]);
            pathInfo.setController(uri.split("/")[2]);
            pathInfo.setAction(uri.split("/")[3]);
        }
        return pathInfo;
    }

}
