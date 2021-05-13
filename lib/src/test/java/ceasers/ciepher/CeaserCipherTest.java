package ceasers.ciepher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CeaserCipherTest {
	
	private  CeasersCiepher ceaserCipher = new  CeasersCiepher();
	
	@Test
	void testCipheredMessageWithOffsetof12() {
//		fail("Not yet implemented");
		assertEquals("tai mdq kag pauzs fapmk", ceaserCipher.cipher("how are you doing today", 12));
	}
	
	@Test
	void testEmptyString() {
		assertEquals("", ceaserCipher.cipher("", 12));
	}
	

}
