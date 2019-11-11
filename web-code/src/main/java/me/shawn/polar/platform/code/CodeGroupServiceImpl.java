package me.shawn.polar.platform.code;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeGroupServiceImpl implements CodeGroupService {
    @Override
    public List<CodeGroup> getCodeGroupsByQuery(CodeGroup query) {
        return null;
    }

    @Override
    public Boolean saveCodeGroup(String groupKey, CodeGroup codeGroup) {
        return null;
    }

    @Override
    public Boolean addNewCodeGroup(CodeGroup codeGroup) {
        return null;
    }

    @Override
    public CodeGroup getCodeGroupByGroupKey(String groupKey) {
        return null;
    }
}
