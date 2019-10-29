package me.shawn.polar.platform.code;

import java.util.List;

public interface CodeService {
    List<Code> getCodesByGroupKeys(List<String> groupKeyList);

    List<Code> getCodesByGroupKeys(String groupKey);

    boolean saveCodesByGroupKey(String groupKey, List<Code> codes);

    boolean saveCodeByGroupKeyAndCodeKey(String groupKey, String codeKey, Code code);

    Boolean saveCodeGroup(CodeGroup codeGroup);

    CodeGroup getCodeGroupByGroupKey(String groupKey);

    List<CodeGroup> getCodeGroupsByQuery(CodeGroup query);
}
