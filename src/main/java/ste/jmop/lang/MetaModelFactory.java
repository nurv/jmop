package ste.jmop.lang;


import java.util.ArrayList;
import java.util.List;

import com.sun.source.tree.AnnotationTree;
import com.sun.source.tree.ArrayAccessTree;
import com.sun.source.tree.ArrayTypeTree;
import com.sun.source.tree.AssertTree;
import com.sun.source.tree.AssignmentTree;
import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.BlockTree;
import com.sun.source.tree.BreakTree;
import com.sun.source.tree.CaseTree;
import com.sun.source.tree.CatchTree;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.CompoundAssignmentTree;
import com.sun.source.tree.ConditionalExpressionTree;
import com.sun.source.tree.ContinueTree;
import com.sun.source.tree.DoWhileLoopTree;
import com.sun.source.tree.EmptyStatementTree;
import com.sun.source.tree.EnhancedForLoopTree;
import com.sun.source.tree.ErroneousTree;
import com.sun.source.tree.ExpressionStatementTree;
import com.sun.source.tree.ForLoopTree;
import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.IfTree;
import com.sun.source.tree.ImportTree;
import com.sun.source.tree.InstanceOfTree;
import com.sun.source.tree.LabeledStatementTree;
import com.sun.source.tree.LiteralTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.ModifiersTree;
import com.sun.source.tree.NewArrayTree;
import com.sun.source.tree.NewClassTree;
import com.sun.source.tree.ParameterizedTypeTree;
import com.sun.source.tree.ParenthesizedTree;
import com.sun.source.tree.PrimitiveTypeTree;
import com.sun.source.tree.ReturnTree;
import com.sun.source.tree.SwitchTree;
import com.sun.source.tree.SynchronizedTree;
import com.sun.source.tree.ThrowTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TryTree;
import com.sun.source.tree.TypeCastTree;
import com.sun.source.tree.TypeParameterTree;
import com.sun.source.tree.UnaryTree;
import com.sun.source.tree.VariableTree;
import com.sun.source.tree.WhileLoopTree;
import com.sun.source.tree.WildcardTree;

public class MetaModelFactory {

    public static List make (List t, MetaModel parent){
	ArrayList list =  new ArrayList();
	for (Object o : t){
	    list.add(make((Tree) o,parent));
	}
	return list;
    } 
    public static MetaModel make(Tree t,MetaModel parent) {
	if (t instanceof AnnotationTree) {
	    return new Annotation((AnnotationTree) t, parent);
	}
	if (t instanceof ArrayAccessTree) {
	    return new ArrayAccess((ArrayAccessTree) t, parent);
	}
	if (t instanceof ArrayTypeTree) {
	    return new ArrayType((ArrayTypeTree) t, parent);
	}
	if (t instanceof AssertTree) {
	    return new Assert((AssertTree) t, parent);
	}
	if (t instanceof AssignmentTree) {
	    return new Assignment((AssignmentTree) t, parent);
	}
	if (t instanceof BinaryTree) {
	    return new Binary((BinaryTree) t, parent);
	}
	if (t instanceof BlockTree) {
	    return new Block((BlockTree) t, parent);
	}
	if (t instanceof BreakTree) {
	    return new Break((BreakTree) t, parent);
	}
	if (t instanceof CaseTree) {
	    return new Case((CaseTree) t, parent);
	}
	if (t instanceof CatchTree) {
	    return new Catch((CatchTree) t, parent);
	}
	if (t instanceof ClassTree) {
	    return new Class((ClassTree) t, parent);
	}
	if (t instanceof CompilationUnitTree) {
	    return new CompilationUnit((CompilationUnitTree) t, parent);
	}
	if (t instanceof CompoundAssignmentTree) {
	    return new CompoundAssignment((CompoundAssignmentTree) t, parent);
	}
	if (t instanceof ConditionalExpressionTree) {
	    return new ConditionalExpression((ConditionalExpressionTree) t, parent);
	}
	if (t instanceof ContinueTree) {
	    return new Continue((ContinueTree) t, parent);
	}
	if (t instanceof DoWhileLoopTree) {
	    return new DoWhileLoop((DoWhileLoopTree) t, parent);
	}
	if (t instanceof EmptyStatementTree) {
	    return new EmptyStatement((EmptyStatementTree) t, parent);
	}
	if (t instanceof EnhancedForLoopTree) {
	    return new EnhancedForLoop((EnhancedForLoopTree) t, parent);
	}
	if (t instanceof ErroneousTree) {
	    return new Erroneous((ErroneousTree) t, parent);
	}
	if (t instanceof ExpressionStatementTree) {
	    return new ExpressionStatement((ExpressionStatementTree) t, parent);
	}
	if (t instanceof ForLoopTree) {
	    return new ForLoop((ForLoopTree) t, parent);
	}
	if (t instanceof IdentifierTree) {
	    return new Identifier((IdentifierTree) t, parent);
	}
	if (t instanceof IfTree) {
	    return new If((IfTree) t, parent);
	}
	if (t instanceof ImportTree) {
	    return new Import((ImportTree) t, parent);
	}
	if (t instanceof InstanceOfTree) {
	    return new InstanceOf((InstanceOfTree) t, parent);
	}
	if (t instanceof LabeledStatementTree) {
	    return new LabeledStatement((LabeledStatementTree) t, parent);
	}
	if (t instanceof LiteralTree) {
	    return new Literal((LiteralTree) t, parent);
	}
	if (t instanceof MemberSelectTree) {
	    return new MemberSelect((MemberSelectTree) t, parent);
	}
	if (t instanceof MethodInvocationTree) {
	    return new MethodInvocation((MethodInvocationTree) t, parent);
	}
	if (t instanceof MethodTree) {
	    return new Method((MethodTree) t, parent);
	}
	if (t instanceof ModifiersTree) {
	    return new Modifiers((ModifiersTree) t, parent);
	}
	if (t instanceof NewArrayTree) {
	    return new NewArray((NewArrayTree) t, parent);
	}
	if (t instanceof NewClassTree) {
	    return new NewClass((NewClassTree) t, parent);
	}
	if (t instanceof ParameterizedTypeTree) {
	    return new ParameterizedType((ParameterizedTypeTree) t, parent);
	}
	if (t instanceof ParenthesizedTree) {
	    return new Parenthesized((ParenthesizedTree) t, parent);
	}
	if (t instanceof PrimitiveTypeTree) {
	    return new PrimitiveType((PrimitiveTypeTree) t, parent);
	}
	if (t instanceof ReturnTree) {
	    return new Return((ReturnTree) t, parent);
	}
	if (t instanceof SwitchTree) {
	    return new Switch((SwitchTree) t, parent);
	}
	if (t instanceof SynchronizedTree) {
	    return new Synchronized((SynchronizedTree) t, parent);
	}
	if (t instanceof ThrowTree) {
	    return new Throw((ThrowTree) t, parent);
	}
	if (t instanceof TryTree) {
	    return new Try((TryTree) t, parent);
	}
	if (t instanceof TypeCastTree) {
	    return new TypeCast((TypeCastTree) t, parent);
	}
	if (t instanceof TypeParameterTree) {
	    return new TypeParameter((TypeParameterTree) t, parent);
	}
	if (t instanceof UnaryTree) {
	    return new Unary((UnaryTree) t, parent);
	}
	if (t instanceof VariableTree) {
	    return new Variable((VariableTree) t, parent);
	}
	if (t instanceof WhileLoopTree) {
	    return new WhileLoop((WhileLoopTree) t, parent);
	}
	if (t instanceof WildcardTree) {
	    return new Wildcard((WildcardTree) t, parent);
	}
	return null;
    }
}