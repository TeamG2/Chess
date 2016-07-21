package Tests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestFailure;

public class moveCheckFailure extends TestCase {

	public moveCheckFailure(String name) {
		super(name);
	}
	
	public void moveCheckFailure() throws Exception {
	    fail();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
