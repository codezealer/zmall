package com.codezealer.zmall.auth.visitor;

import com.codezealer.zmall.auth.composite.PriorityNode;
import com.codezealer.zmall.auth.dao.PriorityDAO;
import com.codezealer.zmall.auth.entity.PriorityDO;

import java.util.List;

public class PriorityNodeDeleteVisitor implements PriorityNodeVisitor{

    private PriorityDAO priorityDAO;

    public PriorityNodeDeleteVisitor(PriorityDAO priorityDAO) {
        this.priorityDAO = priorityDAO;
    }

    @Override
    public void visit(PriorityNode node) {
        List<PriorityDO> priorityDOS = priorityDAO.listChildren(node.getId());
        if (priorityDOS != null && priorityDOS.size() > 0) {
            for (PriorityDO priorityDO : priorityDOS) {
                PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
                priorityNode.accept(this);
            }
        }
        priorityDAO.deleteById(node.getId());
    }
}
