package ste.jmop.intersect;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.tree.JCTree.JCAnnotation;
import com.sun.tools.javac.tree.JCTree.JCArrayAccess;
import com.sun.tools.javac.tree.JCTree.JCArrayTypeTree;
import com.sun.tools.javac.tree.JCTree.JCAssert;
import com.sun.tools.javac.tree.JCTree.JCAssign;
import com.sun.tools.javac.tree.JCTree.JCAssignOp;
import com.sun.tools.javac.tree.JCTree.JCBinary;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCBreak;
import com.sun.tools.javac.tree.JCTree.JCCase;
import com.sun.tools.javac.tree.JCTree.JCCatch;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree.JCConditional;
import com.sun.tools.javac.tree.JCTree.JCContinue;
import com.sun.tools.javac.tree.JCTree.JCDoWhileLoop;
import com.sun.tools.javac.tree.JCTree.JCEnhancedForLoop;
import com.sun.tools.javac.tree.JCTree.JCErroneous;
import com.sun.tools.javac.tree.JCTree.JCExpressionStatement;
import com.sun.tools.javac.tree.JCTree.JCFieldAccess;
import com.sun.tools.javac.tree.JCTree.JCForLoop;
import com.sun.tools.javac.tree.JCTree.JCIdent;
import com.sun.tools.javac.tree.JCTree.JCIf;
import com.sun.tools.javac.tree.JCTree.JCImport;
import com.sun.tools.javac.tree.JCTree.JCInstanceOf;
import com.sun.tools.javac.tree.JCTree.JCLabeledStatement;
import com.sun.tools.javac.tree.JCTree.JCLiteral;
import com.sun.tools.javac.tree.JCTree.JCMethodDecl;
import com.sun.tools.javac.tree.JCTree.JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree.JCModifiers;
import com.sun.tools.javac.tree.JCTree.JCNewArray;
import com.sun.tools.javac.tree.JCTree.JCNewClass;
import com.sun.tools.javac.tree.JCTree.JCParens;
import com.sun.tools.javac.tree.JCTree.JCPrimitiveTypeTree;
import com.sun.tools.javac.tree.JCTree.JCReturn;
import com.sun.tools.javac.tree.JCTree.JCSkip;
import com.sun.tools.javac.tree.JCTree.JCSwitch;
import com.sun.tools.javac.tree.JCTree.JCSynchronized;
import com.sun.tools.javac.tree.JCTree.JCThrow;
import com.sun.tools.javac.tree.JCTree.JCTry;
import com.sun.tools.javac.tree.JCTree.JCTypeApply;
import com.sun.tools.javac.tree.JCTree.JCTypeCast;
import com.sun.tools.javac.tree.JCTree.JCTypeParameter;
import com.sun.tools.javac.tree.JCTree.JCUnary;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.JCTree.JCWhileLoop;
import com.sun.tools.javac.tree.JCTree.JCWildcard;
import com.sun.tools.javac.tree.JCTree.LetExpr;

public abstract class Modifier extends TreeTranslator{

    public abstract void doSomething(JCTree tree);
    
    @Override
    public void visitAnnotation(JCAnnotation arg0) {
        // TODO Auto-generated method stub
        super.visitAnnotation(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitApply(JCMethodInvocation arg0) {
        // TODO Auto-generated method stub
        super.visitApply(arg0);
        doSomething(arg0);
    }
    @Override
    public void visitAssert(JCAssert arg0) {
        // TODO Auto-generated method stub
        super.visitAssert(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitAssign(JCAssign arg0) {
        // TODO Auto-generated method stub
        super.visitAssign(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitAssignop(JCAssignOp arg0) {
        // TODO Auto-generated method stub
        super.visitAssignop(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitBinary(JCBinary arg0) {
        // TODO Auto-generated method stub
        super.visitBinary(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitBlock(JCBlock arg0) {
        // TODO Auto-generated method stub
        super.visitBlock(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitBreak(JCBreak arg0) {
        // TODO Auto-generated method stub
        super.visitBreak(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitCase(JCCase arg0) {
        // TODO Auto-generated method stub
        super.visitCase(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitCatch(JCCatch arg0) {
        // TODO Auto-generated method stub
        super.visitCatch(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitClassDef(JCClassDecl arg0) {
        // TODO Auto-generated method stub
        super.visitClassDef(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitConditional(JCConditional arg0) {
        // TODO Auto-generated method stub
        super.visitConditional(arg0);
        doSomething(arg0);
    }
    
    
    @Override
    public void visitContinue(JCContinue arg0) {
        // TODO Auto-generated method stub
        super.visitContinue(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitDoLoop(JCDoWhileLoop arg0) {
        // TODO Auto-generated method stub
        super.visitDoLoop(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitErroneous(JCErroneous arg0) {
        // TODO Auto-generated method stub
        super.visitErroneous(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitExec(JCExpressionStatement arg0) {
        // TODO Auto-generated method stub
        super.visitExec(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitForeachLoop(JCEnhancedForLoop arg0) {
        // TODO Auto-generated method stub
        super.visitForeachLoop(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitForLoop(JCForLoop arg0) {
        // TODO Auto-generated method stub
        super.visitForLoop(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitIdent(JCIdent arg0) {
        // TODO Auto-generated method stub
        super.visitIdent(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitIf(JCIf arg0) {
        // TODO Auto-generated method stub
        super.visitIf(arg0);
        doSomething(arg0);
    } 
    
    @Override
    public void visitImport(JCImport arg0) {
        // TODO Auto-generated method stub
        super.visitImport(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitIndexed(JCArrayAccess arg0) {
        // TODO Auto-generated method stub
        super.visitIndexed(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitLabelled(JCLabeledStatement arg0) {
        // TODO Auto-generated method stub
        super.visitLabelled(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitLetExpr(LetExpr arg0) {
        // TODO Auto-generated method stub
        super.visitLetExpr(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitLiteral(JCLiteral arg0) {
        // TODO Auto-generated method stub
        super.visitLiteral(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitMethodDef(JCMethodDecl arg0) {
        // TODO Auto-generated method stub
        super.visitMethodDef(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitModifiers(JCModifiers arg0) {
        // TODO Auto-generated method stub
        super.visitModifiers(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitNewArray(JCNewArray arg0) {
        // TODO Auto-generated method stub
        super.visitNewArray(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitNewClass(JCNewClass arg0) {
        // TODO Auto-generated method stub
        super.visitNewClass(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitParens(JCParens arg0) {
        // TODO Auto-generated method stub
        super.visitParens(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitReturn(JCReturn arg0) {
        // TODO Auto-generated method stub
        super.visitReturn(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitSelect(JCFieldAccess arg0) {
        // TODO Auto-generated method stub
        super.visitSelect(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitSkip(JCSkip arg0) {
        // TODO Auto-generated method stub
        super.visitSkip(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitSwitch(JCSwitch arg0) {
        // TODO Auto-generated method stub
        super.visitSwitch(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitSynchronized(JCSynchronized arg0) {
        // TODO Auto-generated method stub
        super.visitSynchronized(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitThrow(JCThrow arg0) {
        // TODO Auto-generated method stub
        super.visitThrow(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTopLevel(JCCompilationUnit arg0) {
        // TODO Auto-generated method stub
        super.visitTopLevel(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTree(JCTree arg0) {
        // TODO Auto-generated method stub
        super.visitTree(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTry(JCTry arg0) {
        // TODO Auto-generated method stub
        super.visitTry(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTypeApply(JCTypeApply arg0) {
        // TODO Auto-generated method stub
        super.visitTypeApply(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTypeArray(JCArrayTypeTree arg0) {
        // TODO Auto-generated method stub
        super.visitTypeArray(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTypeCast(JCTypeCast arg0) {
        // TODO Auto-generated method stub
        super.visitTypeCast(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTypeIdent(JCPrimitiveTypeTree arg0) {
        // TODO Auto-generated method stub
        super.visitTypeIdent(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTypeParameter(JCTypeParameter arg0) {
        // TODO Auto-generated method stub
        super.visitTypeParameter(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitTypeTest(JCInstanceOf arg0) {
        // TODO Auto-generated method stub
        super.visitTypeTest(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitUnary(JCUnary arg0) {
        // TODO Auto-generated method stub
        super.visitUnary(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitVarDef(JCVariableDecl arg0) {
        // TODO Auto-generated method stub
        super.visitVarDef(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitWhileLoop(JCWhileLoop arg0) {
        // TODO Auto-generated method stub
        super.visitWhileLoop(arg0);
        doSomething(arg0);
    }
    
    @Override
    public void visitWildcard(JCWildcard arg0) {
        // TODO Auto-generated method stub
        super.visitWildcard(arg0);
        doSomething(arg0);
    }
}
