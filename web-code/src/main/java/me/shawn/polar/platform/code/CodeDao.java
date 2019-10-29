package me.shawn.polar.platform.code;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("code-api")
@Repository
@Mapper
interface CodeDao {
    List<Code> getCodesByGroupKeys(List<String> groupKeyList);

    List<Code> getCodesByGroupKey(String groupKey);

    boolean saveCode(Code code);
}
