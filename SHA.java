package mahoadulieu;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
	    public static String encryptString(String input) {
	        try {
	            // Tạo một đối tượng MessageDigest với thuật toán SHA-256
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            
	            // Mã hóa chuỗi đầu vào thành dạng mảng byte
	            byte[] encodedhash = digest.digest(input.getBytes());
	            
	            // Chuyển đổi mảng byte thành dạng hex string
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : encodedhash) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            // Xử lý ngoại lệ nếu thuật toán không tồn tại
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public static void main(String[] args) {
	        String input = "Hom Nay Troi Nang";
	        String encryptedString = encryptString(input);
	        System.out.println("Input: " + input);
	        System.out.println("Encrypted String (SHA-256): " + encryptedString);
	    }
	}


