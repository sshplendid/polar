package me.shawn.polar.platform.code;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Profile("code-api")
@Service
public class CodeServiceImpl implements CodeService {

    private CodeDao codeDao;

    public CodeServiceImpl(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    @Override
    public List<Code> getCodesByGroupKeys(List<String> groupKeys) {
        Map<String, Object> param = new HashMap<>();
        param.put("groupKeys", groupKeys);
        return codeDao.getCodesByGroupKeys(param);
    }

    @Override
    public List<Code> getCodesByGroupKeys(String groupKey) {
        return codeDao.getCodesByGroupKey(groupKey);
    }

    @Override
    public boolean saveCodesByGroupKey(String groupKey, List<Code> codes) {
        long count = codes.stream().map(code -> {
            code.setGroupKey(groupKey);
            return codeDao.saveCode(code);
        }).filter(result -> result).count();

        return count == codes.size();
    }

    @Override
    public boolean saveCodeByGroupKeyAndCodeKey(String groupKey, String codeKey, Code code) {
        code.setGroupKey(groupKey);
        code.setCodeKey(codeKey);
        return codeDao.saveCode(code);
    }

    @Override
    public Boolean saveCodeGroup(CodeGroup codeGroup) {
        return null;
    }

    @Override
    public CodeGroup getCodeGroupByGroupKey(String groupKey) {
        return null;
    }

    @Override
    public List<CodeGroup> getCodeGroupsByQuery(CodeGroup query) {
        return null;
    }
}
