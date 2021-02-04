package org.springframework.samples.petclinic.sfg.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.samples.petclinic.sfg.LaurelWordProducer;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = { HearingInterpreterInnerClassTest.TestConfig.class })
class HearingInterpreterInnerClassTest {

	@Autowired
	HearingInterpreter hearingInterpreter;

	static class TestConfig {
		@Bean
		HearingInterpreter hearingInterpreter() {
			return new HearingInterpreter(new LaurelWordProducer());
		}
	}

	@Test
	void testWhatIheard() {
		String word = hearingInterpreter.whatIheard();
		assertEquals("Laurel", word);
	}

}
