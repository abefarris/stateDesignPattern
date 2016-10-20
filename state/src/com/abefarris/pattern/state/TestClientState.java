package com.abefarris.pattern.state;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestClientState {

	@Test
	public void testInitialOpen() {
		final StateContext sc = new StateContext();
		sc.setMode("open");
		assertTrue(sc.isStateChanged());
		assertTrue(sc.getCurrentState() instanceof StateOpen);
	}

	@Test
	public void testOpenOpen() {
		final StateContext sc = new StateContext();
		sc.setMode("open");
		sc.setMode("open");
		assertFalse(sc.isStateChanged());
		assertTrue(sc.getCurrentState() instanceof StateOpen);
	}

	@Test
	public void testOpenOPEN() {
		final StateContext sc = new StateContext();
		sc.setMode("open");
		sc.setMode("OPEN");
		assertFalse(sc.isStateChanged());
		assertTrue(sc.getCurrentState() instanceof StateOpen);
	}

	@Test
	public void testOpenBlank() {
		final StateContext sc = new StateContext();
		sc.setMode("open");
		sc.setMode("");
		assertTrue(sc.isStateChanged());
		assertTrue(sc.getCurrentState() instanceof StateOther);
	}

	@Test
	public void testOpenNull() {
		final StateContext sc = new StateContext();
		sc.setMode("open");
		sc.setMode(null);
		assertTrue(sc.isStateChanged());
		assertTrue(sc.getCurrentState() instanceof StateOther);
	}

	@Test
	public void testOpenOther() {
		final StateContext sc = new StateContext();
		sc.setMode("open");
		sc.setMode("other");
		assertTrue(sc.isStateChanged());
		assertTrue(sc.getCurrentState() instanceof StateOther);
	}

	@Test
	public void testOtherOther() {
		final StateContext sc = new StateContext();
		sc.setMode("other");
		sc.setMode("other");
		assertFalse(sc.isStateChanged());
		assertTrue(sc.getCurrentState() instanceof StateOther);
	}

}
