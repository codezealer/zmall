package com.codezealer.zmall.auth.visitor;

import com.codezealer.zmall.auth.composite.PriorityNode;

public interface PriorityNodeVisitor {

    void visit(PriorityNode priorityNode);

}
