package com.jxls.writer.builder.xml;

import ch.qos.logback.core.joran.GenericConfigurator;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.action.ImplicitAction;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.joran.spi.Pattern;
import ch.qos.logback.core.joran.spi.RuleStore;

import java.util.List;
import java.util.Map;

/**
 * @author Leonid Vysochyn
 *         Date: 2/14/12 11:53 AM
 */
public class SimpleConfigurator extends GenericConfigurator {

    final Map<Pattern, Action> ruleMap;
    final List<ImplicitAction> iaList;

    public SimpleConfigurator(Map<Pattern, Action> ruleMap) {
        this(ruleMap, null);
    }

    public SimpleConfigurator(Map<Pattern, Action> ruleMap, List<ImplicitAction> iaList) {
        this.ruleMap = ruleMap;
        this.iaList = iaList;
    }

    @Override
    protected void addInstanceRules(RuleStore rs) {
        for (Pattern pattern : ruleMap.keySet()) {
            Action action = ruleMap.get(pattern);
            rs.addRule(pattern, action);
        }
    }

    @Override
    protected void addImplicitRules(Interpreter interpreter) {
        if(iaList == null) {
            return;
        }
        for (ImplicitAction ia : iaList) {
            interpreter.addImplicitAction(ia);
        }
    }

    public InterpretationContext getInterpretationContext(){
        if( this.interpreter != null ) return this.interpreter.getInterpretationContext();
        else return null;
    }

}
