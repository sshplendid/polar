package me.shawn.polar.platform.code;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//@Profile("code-api")
//@Repository
@Mapper
interface CodeDao {
    List<Code> getCodesByGroupKeys(Map<String, Object> params);

    List<Code> getCodesByGroupKey(String groupKey);

    boolean saveCode(Code code);
}
