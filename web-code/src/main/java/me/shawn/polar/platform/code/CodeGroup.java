package me.shawn.polar.platform.code;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Alias("codeGroup")
public class CodeGroup {
    private String groupKey;
    private String groupValue;
    private String description;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
