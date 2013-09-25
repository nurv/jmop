package ste.jmop.bootsrap;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import ste.jmop.handlers.CollectKindVisitor;
import ste.jmop.lang.Assignment;
import ste.jmop.lang.Class;
import ste.jmop.lang.MetaModelFactory;
import ste.jmop.lang.Method;
import ste.jmop.lang.MethodInvocation;

import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("*")
public class Processor extends AbstractProcessor {

    private Trees trees;

    @Override
    public void init(ProcessingEnvironment pe) {
	super.init(pe);
	trees = Trees.instance(pe);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {

	for (Element e : roundEnvironment.getRootElements()) {
	    Tree tp = trees.getTree(e);
	    
	    Class cl = (Class) MetaModelFactory.make(tp, null);
	    Method m = cl.getMethods("equals").get(0);
	    
	    CollectKindVisitor<Assignment> collector = new CollectKindVisitor<Assignment>(Assignment.class);
	    m.visit(collector);
	    Assignment a = collector.getCollected().get(0);
	    List<MethodInvocation> invoks  = m.findMethodInvocation("test");
	    
	    for(MethodInvocation invok : invoks){
		System.out.println(invok);		
	    }
	    
	}

	// visitor.collector.dump();
	return false;
    }

}
