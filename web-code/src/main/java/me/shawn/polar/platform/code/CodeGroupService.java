package me.shawn.polar.platform.code;

import java.util.List;

public interface CodeGroupService {
    List<CodeGroup> getCodeGroupsByQuery(CodeGroup query);

    Boolean saveCodeGroup(String groupKey, CodeGroup codeGroup);

    Boolean addNewCodeGroup(CodeGroup codeGroup);

    CodeGroup getCodeGroupByGroupKey(String groupKey);
}
