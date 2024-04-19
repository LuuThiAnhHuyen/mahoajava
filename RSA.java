package mahoadulieu;
    import java.security.*;
	import java.util.Base64;

import javax.crypto.Cipher;
	
public class RSA {


	    public static void main(String[] args) throws Exception {
	        RSA rsa = new RSA();
	        rsa.run();
	    }

	    public void run() throws Exception {
	        // Khởi tạo cặp khóa RSA
	        KeyPair keyPair = generateKeyPair();

	        // Lấy khóa công khai và khóa bí mật từ cặp khóa
	        PublicKey publicKey = keyPair.getPublic();
	        PrivateKey privateKey = keyPair.getPrivate();

	        // Chuỗi cần mã hóa
	        String plaintext = "Hom Nay Troi Nang";

	        // Mã hóa chuỗi bằng khóa công khai
	        String encryptedText = encrypt(plaintext, publicKey);
	        System.out.println("Encrypted String: " + encryptedText);

	        // Giải mã chuỗi bằng khóa bí mật
	        String decryptedText = decrypt(encryptedText, privateKey);
	        System.out.println("Decrypted String: " + decryptedText);
	    }

	    // Tạo cặp khóa RSA
	    public KeyPair generateKeyPair() throws Exception {
	        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	        keyGen.initialize(2048);
	        return keyGen.generateKeyPair();
	    }

	    // Mã hóa chuỗi bằng khóa công khai
	    public String encrypt(String plaintext, PublicKey publicKey) throws Exception {
	        Cipher encryptCipher = Cipher.getInstance("RSA");
	        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
	        byte[] encryptedBytes = encryptCipher.doFinal(plaintext.getBytes());
	        return Base64.getEncoder().encodeToString(encryptedBytes);
	    }

	    // Giải mã chuỗi bằng khóa bí mật
	    public String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
	        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
	        Cipher decryptCipher = Cipher.getInstance("RSA");
	        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
	        byte[] decryptedBytes = decryptCipher.doFinal(encryptedBytes);
	        return new String(decryptedBytes);
	    }
	}
