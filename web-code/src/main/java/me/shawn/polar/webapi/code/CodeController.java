package me.shawn.polar.webapi.code;

import me.shawn.polar.platform.code.Code;
import me.shawn.polar.platform.code.CodeGroup;
import me.shawn.polar.platform.code.CodeService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Profile({"code-api"})
@RestController
@RequestMapping("/v1/code")
public class CodeController {

    private CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/codes")
    public List<Code> getCodesByGroupKeys(@RequestParam String groupKeys) {
        List<String> groupKeyList = Arrays.stream(groupKeys.split(",")).map(String::trim).collect(Collectors.toList());
        return codeService.getCodesByGroupKeys(groupKeyList);
    }

    @GetMapping("/groups")
    public List<CodeGroup> getCodeGroupsByQuery(CodeGroup query) {
        return codeService.getCodeGroupsByQuery(query);
    }

    @PostMapping("/groups")
    public Boolean saveCodeGroup(@RequestBody CodeGroup codeGroup) {
        return codeService.saveCodeGroup(codeGroup);
    }

    @GetMapping("/groups/{groupKey}")
    public CodeGroup getCodeGroupByGroupKey(@PathVariable String groupKey) {
        return codeService.getCodeGroupByGroupKey(groupKey);
    }

    @GetMapping("/groups/{groupKey}/codes")
    public List<Code> getCodesByGroupKey(@PathVariable String groupKey) {
        return codeService.getCodesByGroupKeys(groupKey);
    }

    @PostMapping("/groups/{groupKey}/codes")
    public Boolean saveCodesByGroupKey(@PathVariable String groupKey, @RequestBody List<Code> codes) {
        return codeService.saveCodesByGroupKey(groupKey, codes);
    }

    @PostMapping("/groups/{groupKey}/codes/{codeKey}")
    public Boolean saveCodeByGroupKeyAndCodeKey(@PathVariable String groupKey, @PathVariable String codeKey, Code codeModel) {
        return codeService.saveCodeByGroupKeyAndCodeKey(groupKey, codeKey, codeModel);
    }
}
