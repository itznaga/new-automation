//package runner;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import cucumber.runtime.ClassFinder;
//import cucumber.runtime.RuntimeOptions;
//import cucumber.runtime.io.MultiLoader;
//import cucumber.runtime.io.ResourceLoader;
//import cucumber.runtime.io.ResourceLoaderClassFinder;
//
//public class TestNG {
//
//	private void defaultRun() {
//		List<String> arguments = new ArrayList<String>();
//		arguments.add("--features");
//		arguments.add("./src/test/java/features/ProductPkg.feature");
//
//		String[] gluepackages = {"stepDefinitions"};
//		for (String packages : gluepackages) {
//			arguments.add("--glue");
//			arguments.add(packages);
//		}
//
//		String[] tags = {"@TestScenario1"};
//		for (String tag : tags) {
//			arguments.add("--tags");
//			arguments.add(tag);
//		}
//
//		String[] argv = arguments.toArray(new String[arguments.size()]);
//		try {
//			executetests(argv);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public byte executetests(String[] argv) throws InterruptedException, IOException {
//		RuntimeOptions runtimeOptions = new RuntimeOptions(new ArrayList(Arrays.asList(argv)));
//		ClassLoader cl = Thread.currentThread().getContextClassLoader();
//		ResourceLoader rl = new MultiLoader(cl);
//		ClassFinder clFinder = new ResourceLoaderClassFinder(rl,cl);
//		Runtime runtime = new Runtime(rl,clFinder,cl,runtimeOptions);
//		runtime.run();
//		System.out.println(runtime.exitStatus());
//		return runtime.exitStatus();
//	}
//
//}
