package com.exam.core.common.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteMetadata {
    private String title;
    private String description;
    private String keywords;

    /**
     * 统计js代码
     */
    private String statsScript;

    public SiteMetadata(String title, String description, String keywords) {
        this.title = title;
        this.description = description;
        this.keywords = keywords;
    }
}
