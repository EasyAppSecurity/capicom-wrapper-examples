package by.creepid.capicom.wrapper.example;

import by.creepid.capicom.wrapper.*;

public class Encryption {

    public static void main(String[] args) {
        CapicomEncrypted capicomEncrypted = new CapicomEncrypted();
        capicomEncrypted.setAlgoritmName();
        capicomEncrypted.setContent("test");
        capicomEncrypted.setSecret("test");
        String encrypt = capicomEncrypted.encrypt();
        System.out.println("Encrypted: " + encrypt);

        CapicomEncrypted capicomDecrypted = new CapicomEncrypted();
        capicomDecrypted.setAlgoritmName();
        capicomDecrypted.setSecret("test");
        capicomDecrypted.decrypt(encrypt);
        String decrypt = capicomDecrypted.getContent();
        System.out.println("Decrypted: " + encrypt);
    }

}
