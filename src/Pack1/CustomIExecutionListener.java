package Pack1;

import java.util.Date;

import org.testng.IExecutionListener;

public class CustomIExecutionListener implements IExecutionListener{
	long start;
	
	@Override
	public void onExecutionFinish() {		
		//start=System.currentTimeMillis();
		System.out.println("Test execution finished: "+new Date());
		System.out.println("Total time taken for execution: "+(System.currentTimeMillis()-start)+"ms");
	}

	@Override
	public void onExecutionStart() {
		start=System.currentTimeMillis();
		System.out.println("Test execution started: "+new Date());
		
	}

}
