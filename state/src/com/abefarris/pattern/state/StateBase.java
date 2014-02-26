package com.abefarris.pattern.state;
public class StateBase implements Statelike {
	
	@Override
	public void setMode(final StateContext context, final String mode) {
		
		if (mode != null && mode.toLowerCase().contentEquals("open")){
			context.setState(new StateOpen());
		} else {
			context.setState(new StateOther());
		}
		

	}


}