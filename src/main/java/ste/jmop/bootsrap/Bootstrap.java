package ste.jmop.bootsrap;

import java.io.IOException;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import ste.jmop.defpool.DefPool;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.Trees;

public class Bootstrap {
    public static void bootstrap(String[] files) {
	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
	StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
	Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects(files);
	CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, fileObjects);

	// Here we switch to Sun-specific APIs
	JavacTask javacTask = (JavacTask) task;
	SourcePositions sourcePositions = Trees.instance(javacTask).getSourcePositions();
	Iterable<? extends CompilationUnitTree> parseResult = null;
	try {
	    parseResult = javacTask.parse();
	} catch (IOException e) {

	    // Parsing failed
	    e.printStackTrace();
	    System.exit(0);
	}
	
	for (CompilationUnitTree compilationUnitTree : parseResult) {
	    DefPool.instance().addCompilationUnit(compilationUnitTree); 
	}
    }
}
