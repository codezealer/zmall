package com.codezealer.zmall.auth.visitor;

import com.codezealer.zmall.auth.composite.PriorityNode;
import com.codezealer.zmall.auth.dao.AccountPriorityRelationshipDAO;
import com.codezealer.zmall.auth.dao.PriorityDAO;
import com.codezealer.zmall.auth.dao.RolePriorityRelationshipDAO;
import com.codezealer.zmall.auth.entity.PriorityDO;

import java.util.List;

public class PriorityNodeRelateCheckVisitor implements PriorityNodeVisitor {

    private boolean isRelated = false;

    private PriorityDAO priorityDAO;

    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;

    public PriorityNodeRelateCheckVisitor(PriorityDAO priorityDAO, AccountPriorityRelationshipDAO accountPriorityRelationshipDAO, RolePriorityRelationshipDAO rolePriorityRelationshipDAO) {
        this.priorityDAO = priorityDAO;
        this.accountPriorityRelationshipDAO = accountPriorityRelationshipDAO;
        this.rolePriorityRelationshipDAO = rolePriorityRelationshipDAO;
    }

    @Override
    public void visit(PriorityNode node) {
        List<PriorityDO> priorityDOList = priorityDAO.listChildren(node.getId());
        if (priorityDOList != null && priorityDOList.size() > 0) {
            for (PriorityDO priorityDO : priorityDOList) {
                PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
                priorityNode.accept(this);
            }
        }

        if (relateCheck(node)) {
            this.isRelated = true;
        }
    }

    public Boolean getCheckRelateResult() {
        return this.isRelated;
    }


    private boolean relateCheck(PriorityNode node) {
        int accountRelateCount = this.accountPriorityRelationshipDAO.countAccountRelationShip(node.getId());
        if (accountRelateCount > 0) {
            return true;
        }
        int roleRelateCount = this.rolePriorityRelationshipDAO.countRolePriorityRelationship(node.getId());
        return roleRelateCount > 0 ? true : false;
    }
}
