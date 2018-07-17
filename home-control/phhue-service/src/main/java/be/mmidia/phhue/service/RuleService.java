package be.mmidia.phhue.service;

import be.mmidia.phhue.model.RuleDto;
import java.util.List;

public interface RuleService {
    List<RuleDto> getAllRules();

    RuleDto getRule(final long ruleId);

    void createRule(final RuleDto rule);

    void updateRule(final RuleDto rule);

    void deleteRule(final long ruleId);
}
