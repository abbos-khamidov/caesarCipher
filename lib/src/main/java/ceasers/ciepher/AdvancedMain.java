public class AdvancedMain {
    public static void main(String[] args) {
        AdvancedCaesarCipher cc = new AdvancedCaesarCipher(5);
        System.out.println(cc.encrypt("Hello, my name is Jeff.", 5));
        System.out.println(cc.decrypt("Mjqqt, rd sfrj nx Ojkk.", 5));
        System.out.println(cc.autoDecrypt("Mjqqt, rd sfrj nx Ojkk."));
        System.out.println(cc.encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 8));
        System.out.println(cc.decryptTwoKeys("Xai twp duaodvz gqam EDBCWPB bcm qibzzimo AVY xwhxpbzzn dv gjcm kwxszb?", 21, 8));
        System.out.println(cc.autoDecryptTwoKeys("Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin"));
        // cc.bruteForce("Hello, my name is Jeff.");
    }
}