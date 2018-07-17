package be.mmidia.phhue.service.impl;

import be.mmidia.phhue.model.RuleDto;
import be.mmidia.phhue.service.RuleService;
import java.util.List;

public class RuleServiceImpl implements RuleService {

    @Override
    // /api/<username>/rules (GET)
    public List<RuleDto> getAllRules() {
        return null;
    }

    @Override
    // /api/<username>/rules/<id> (GET)
    public RuleDto getRule(long ruleId) {
        return null;
    }

    @Override
    // /api/<username>/rules (POST)
    public void createRule(RuleDto rule) {

    }

    @Override
    // /api/<username>/rules/<id> (PUT)
    public void updateRule(RuleDto rule) {

    }

    @Override
    // /api/<username>/rules/<id> (DELETE)
    public void deleteRule(long ruleId) {

    }
}
