package com.abefarris.pattern.state;
public class StateContext {
	private Statelike currentState;
	private Statelike previousState;
	

	public Statelike getCurrentState() {
		return currentState;
	}

	StateContext() {
		setState(new StateOther());
	}

	void setState(final Statelike newState) {
		previousState = currentState;
		currentState = newState;

	}
	
	public boolean isStateChanged(){
		return !(previousState.getClass().equals(currentState.getClass()));
	}

	public void setMode(final String mode) {
		currentState.setMode(this, mode);
		
	}
}