public class AdvancedCaesarCipher {
    private String alphabet;

    public AdvancedCaesarCipher(int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
    }

    public String encrypt(String input, int key) {
        char[] charInput = input.toCharArray();
        String encrypted = "";
        for (char ch : charInput) {
            int ASCII = (int) ch;
            ASCII += key;
            if (!Character.isAlphabetic(ch)) {
                encrypted += Character.toString(ch);
                continue;
            } else if (ASCII > 90 && Character.isUpperCase(ch)) {
                ASCII -= 26;
            } else if (ASCII > 122 && Character.isLowerCase(ch)) {
                ASCII -= 26;
            }
            ch = (char) ASCII;
            encrypted += Character.toString(ch);
        }
        return encrypted;
    }

    public String decrypt(String encrypted, int key) {
        char[] charInput = encrypted.toCharArray();
        String decrypted = "";
        for (char ch : charInput) {
            int ASCII = (int) ch;
            ASCII -= key;
            if (!Character.isAlphabetic(ch)) {
                decrypted += Character.toString(ch);
                continue;
            } else if (ASCII < 90 && Character.isUpperCase(ch) && (ASCII + 26) <= 90) {
                ASCII += 26;
            } else if (ASCII < 122 && Character.isLowerCase(ch) && (ASCII + 26) <= 122) {
                ASCII += 26;
            }
            ch = (char) ASCII;
            decrypted += Character.toString(ch);
        }
        return decrypted;
    }

    public char countLetters(String input) {
        int[] alphaCount = new int[26];
        for (char ch : input.toCharArray()) {
            int index = alphabet.indexOf(Character.toLowerCase(ch));
            if (index != -1) {
                alphaCount[index]++;
            }
        }
        int maxIndex = 0;
        int maxValue = 0;
        for (int index = 0; index < alphaCount.length; index++) {
            if (alphaCount[index] > maxValue) {
                maxValue = alphaCount[index];
                maxIndex = index;
            }
        }
        return alphabet.charAt(maxIndex);
    }

    public String autoDecrypt(String encrypted) {
        char mostCommonLetter = countLetters(encrypted);
        int mclIndex = alphabet.indexOf(mostCommonLetter);
        int key = mclIndex - 4;
        if (key < 4) {
            key = 26 - (4 - key);
        }
        return decrypt(encrypted, key);
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        String encryptedTwoKeys = "";
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                char ch = input.charAt(i);
                encryptedTwoKeys += encrypt(Character.toString(ch), key1);
            } else if (i % 2 == 1) {
                char ch = input.charAt(i);
                encryptedTwoKeys += encrypt(Character.toString(ch), key2);
            }
        }
        return encryptedTwoKeys;
    }

    public String decryptTwoKeys(String encrypted, int key1, int key2) {
        String decryptedTwoKeys = "";
        for (int i = 0; i < encrypted.length(); i++) {
            if (i % 2 == 0) {
                char ch = encrypted.charAt(i);
                decryptedTwoKeys += decrypt(Character.toString(ch), key1);
            } else if (i % 2 == 1) {
                char ch = encrypted.charAt(i);
                decryptedTwoKeys += decrypt(Character.toString(ch), key2);
            }
        }
        return decryptedTwoKeys;
    }

    public String autoDecryptTwoKeys(String encryptedWithTwoKeys) {
        char mostCommonLetter = countLetters(encryptedWithTwoKeys);
        int mclIndex = alphabet.indexOf(mostCommonLetter);
        int key1 = mclIndex - 4;
        if (key1 < 4) {
            key1 = 26 - (4 - key1);
        }
        int key2 = mclIndex + 8;
        if (key2 > 25) {
            key2 = key2 - 26 - 4;
        }
        return decryptTwoKeys(encryptedWithTwoKeys, key1, key2);
    }

    public void bruteForce(String encrypted) {
        // brute force the encrypted string
        for (int key1 = 0; key1 < 26; key1++) {
            for (int key2 = 0; key2 < 26; key2++) {
                String decrypted = decryptTwoKeys(encrypted, key1, key2);
                System.out.println(decrypted + " " + key1 + " " + key2);
            }
        }
    }
}