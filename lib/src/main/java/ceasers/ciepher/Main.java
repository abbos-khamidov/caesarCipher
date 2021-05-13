package ceasers.ciepher;

public class Main {

	public static void main(String[] args) {
		
		String message = "How are you doing today";
		int offset = 12;
		
		CeasersCiepher ceasarsCipher = new CeasersCiepher();
		String cipheredMessage = ceasarsCipher.cipher(message, offset);
		
		System.out.println("Message: " + message);
		System.out.println("Offset: " + offset);
		System.out.println("Ciphered message: " + cipheredMessage);

	}

}
