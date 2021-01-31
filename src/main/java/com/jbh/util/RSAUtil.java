package com.jbh.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.jbh.exception.NoPrivateKeyException;

public class RSAUtil {
	
	private static PrivateKey privateKey;
	
	//개인키 반환
	public static void getPrivateKey(HttpSession session) throws NoPrivateKeyException{
		privateKey = (PrivateKey)session.getAttribute("__resPrivateKey__");
		if(privateKey == null)
			throw new NoPrivateKeyException();
	}
	
	//암호화
	public static void setCrypto(Model model, HttpSession session) throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA"); //NoSuchAlgorithmException
		gen.initialize(2048);
		
		KeyPair keyPair = gen.generateKeyPair();
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		if(session.getAttribute("__resPrivateKey__") != null)
			session.removeAttribute("__resPrivateKey__");
		session.setAttribute("__resPrivateKey__", privateKey);
		
		RSAPublicKeySpec publicSpec = (RSAPublicKeySpec)keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class); //InvalidKeySpecException
		
		String publicKeyModulus = publicSpec.getModulus().toString(16);
		String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
		
		model.addAttribute("publicKeyModulus",  publicKeyModulus);
		model.addAttribute("publicKeyExponent", publicKeyExponent);
	}
	
	//암호화. Map객채 반환.
	public static Map<String, String> setCrypto(HttpSession session) throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA"); //NoSuchAlgorithmException
		Map<String, String> map = new HashMap<>();
		gen.initialize(2048);
		
		KeyPair keyPair = gen.generateKeyPair();
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		if(session.getAttribute("__resPrivateKey__") != null)
			session.removeAttribute("__resPrivateKey__");
		session.setAttribute("__resPrivateKey__", privateKey);
		
		RSAPublicKeySpec publicSpec = (RSAPublicKeySpec)keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class); //InvalidKeySpecException
		
		String publicKeyModulus = publicSpec.getModulus().toString(16);
		String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
		
		map.put("publicKeyModulus",  publicKeyModulus);
		map.put("publicKeyExponent", publicKeyExponent);
		return map;
	}
	
	//복호화
	public static String decryptRSA(String secured) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance("RSA");					//NoSuchAlgorithmException
		byte[] encryptedBytes = hexToByteArray(secured);			//NoSuchPaddingException
		cipher.init(Cipher.DECRYPT_MODE, privateKey);				//InvalidKeyException
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);		//IllegalBlockSizeException, BadPaddingException
		return new String(decryptedBytes, "utf-8");					//UnsupportedEncodingException
	}

	private static byte[] hexToByteArray(String hex) {
		if(hex == null || hex.length() % 2 != 0)
			return new byte[] {};
		
		byte[] bytes = new byte[hex.length()/2];
		for(int i = 0 ; i < hex.length() ; i += 2) {
			byte value = (byte)Integer.parseInt(hex.substring(i, i+2), 16);
			bytes[(int)Math.floor(i/2)] = value;
		}
		return bytes;
	}
}
