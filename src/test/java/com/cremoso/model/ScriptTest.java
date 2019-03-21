package com.cremoso.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.val;

class ScriptTest {

	@Test
	void getCurrent_testWithOneCommand() {
		Script script = new Script();
		val command = new Command("SELECT * FROM DUAL", "First Version");
		script.getCommands().add(command);
		
		assertEquals(command, script.getCurrentCommand());
	}

	@Test
	void getCurrent_testWithMoreThanOne() {
//		Script script = new Script();
//		script.getCommands().add(new Command()));
//		script.getCommands().add(new Command()));
	}
}
