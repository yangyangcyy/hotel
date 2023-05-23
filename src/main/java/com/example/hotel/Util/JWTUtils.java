package com.example.hotel.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {
	//	7天过期
	private static long expire = 604800;
	//	32位秘钥
	private static String secret = "abcdfghiabcdfghiabcdfghiabcdfghi";
	
	public static String generateToken (Integer empId) {
		Date now = new Date ();
		Date expiration = new Date (now.getTime () + 1000 * expire);
		return Jwts.builder ()
				.setHeaderParam ("type" , "JWT")
				.setSubject (empId + "").setIssuedAt (now)
				.setExpiration (expiration)
				.signWith (SignatureAlgorithm.HS512 , secret)
				.compact ();
	}
	
	public static Claims getClaimsByToken (String token) {
		return Jwts.parser ()
				.setSigningKey (secret)
				.parseClaimsJws (token)
				.getBody ();
	}
}