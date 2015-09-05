


public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// create environment with random state of cleaning.
		Environment env = new Environment();
		//EnvironmentView view = new SimpleEnvironmentView();
		//env.addEnvironmentView(view);
		
		Agent a = null;
		a = new Agent();
		// a = new ReflexVacuumAgent();
		// a = new SimpleReflexVacuumAgent();
		// a = new TableDrivenVacuumAgent();
		
		env.addAgent(a);
		//env.step(16);
		//env.notifyViews("Performance=" + env.getPerformanceMeasure(a));
	
		
	}

}



