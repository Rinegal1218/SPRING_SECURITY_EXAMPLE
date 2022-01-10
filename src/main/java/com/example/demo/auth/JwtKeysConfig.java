package com.example.demo.auth;

/**
 * This class contains RSA private and public key to sign jwt token.
 * The RSA_PRIVATE_KEY and RSA_PUBLIC_KEY were generated using OpenSSL program. 
 * @author Rinegal1218
 */
public class JwtKeysConfig {
	
	public static final String RSA_PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEowIBAAKCAQEAvxhwY6bLFyxS2ye7A5RG18tJb8mDSLRy12hfFgjI4Abkkwfp\r\n" + 
			"jxfs1g1831obS7oxHXMqGcgEbpg5imxKTgW6JZ7UUoJMWsA65GtnWkB4IqtgO3YV\r\n" + 
			"1DzBcI3gc1PQQu81koz7jbBUpV9FdFmL2s5Iudgrg5z6OfWpX/9pYq8Pe3H09NHk\r\n" + 
			"ruYR+8ZGJlkWPsbSiTTQPeB/+I4cLF4peTqomCJBKcs6JqI97qEY62ujbbbhz5GM\r\n" + 
			"CWKVAfrB+S30vEDpYmH21Y30Y0RGKQQPrPxHBwao6AEYcBEz3KpF0+z4IGElkNmM\r\n" + 
			"zCEp+gLs8VpQRG+Nfxu4d3TyoLlvnEwsV2PSjQIDAQABAoIBAFrMnfp7slxcbzI6\r\n" + 
			"+p2EwvSeX1KCiaLuOvMnYKbznZ71J37Fb7DSSXKcDg2Cnx2oZtX7drGxXInAQvcG\r\n" + 
			"5XeVORHPGkvqJaWpWVJXxlAX+f1fOOaIAW9LPw7gGxoxZO+pAeeUnaKBenbpgfL6\r\n" + 
			"6X0aL2w+zs5GtI79r3Exxz1guRaKB25kjQxa7h52wFBRjE3x+IMkHnu/SmPhLhcc\r\n" + 
			"qIF8CJUDrm6Dlk0xEKzRa4scZ48kR8fbHSfu1a9i4SIs/U+kPQhD57q9nndhT0Ix\r\n" + 
			"jaTcRZHgUJm7H+mMk+N7uJSHCdo6b4VVJplopiY5dCnDaXCb30w42wNbq32Ykm//\r\n" + 
			"NdI/DPECgYEA+mvxpDcYg8JXDp42NqxLyHRx4xisEenfzZdfscU1vQi4QRjIc6OF\r\n" + 
			"oKwBmqzSUJTK7+PHo8/cDMW+wWdFhTGz0UwsnQ0ZjMvB1fUjXhvyHhags1FrIAw/\r\n" + 
			"BSV9wZybhB9d+xP6Kfi6B3Vjp7CkUtrlfGu3XZBLGFrgqTmWX4A34WMCgYEAw1ou\r\n" + 
			"Y2IRJOtLpZGGkl2E4mGbBmax1LosVY0L4yZRlowOyQistkLctLDdcXLJLi+J7Woz\r\n" + 
			"8ut1pkXU8LYYc0B79MP1W+YSZrIdRCR7P6Ms/yi2cDpQ93axOJzvlRVaNqpUFBiJ\r\n" + 
			"6/Z++qwV/n5OP4qTovrs3KCr6tX5yjpyaAozN08CgYEAxh1v5oLQGi09worYSRi2\r\n" + 
			"O7gkAY4bU3C7ZmNDidiDUzH600VQEGxl418xRbVEDgwpIPALmUVwyYoIB+ozzdQs\r\n" + 
			"doDVKsqaVBE/II33lRR2z+cG69aV8Zy+nsuyWeIUBsrqByEe4OWuBwiP9rKAzivv\r\n" + 
			"MiflwVfOkU4UPs0YciV2EBECgYAlgqN1odb459VWrWLRp/NkJKnHyOBMoJLyumqV\r\n" + 
			"6z2vUqVkJK5FMQGAEJX0ur22iJpLZCEle+DTVIVW0yBOwQsMLLRoOP0/iuPjub2Q\r\n" + 
			"spxpQkAFvKzfV4MgA8JdNgRkisAqO6wACwzGxVRT0Zzkxo8itFvW4WMhbITSN/bP\r\n" + 
			"02WSMQKBgBlfmpurV2em5KqIQz+Qyl3jJPaKSbPymuNpoYgbhtxP4akaAB56yNZl\r\n" + 
			"OgzeyihbGtK8Md715+YomdWTAxce4qLdit5tV/6iie7pyBG5VwpUqogcKV6qsyb8\r\n" + 
			"t/L1C+r91kkihSyJFXNgywxjdDheaFxU+W49UP8JqFOP1Ark6QFv\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\r\n" + 
	"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvxhwY6bLFyxS2ye7A5RG\r\n" +
	"18tJb8mDSLRy12hfFgjI4Abkkwfpjxfs1g1831obS7oxHXMqGcgEbpg5imxKTgW6\r\n" + 
	"JZ7UUoJMWsA65GtnWkB4IqtgO3YV1DzBcI3gc1PQQu81koz7jbBUpV9FdFmL2s5I\r\n" + 
	"udgrg5z6OfWpX/9pYq8Pe3H09NHkruYR+8ZGJlkWPsbSiTTQPeB/+I4cLF4peTqo\r\n" + 
	"mCJBKcs6JqI97qEY62ujbbbhz5GMCWKVAfrB+S30vEDpYmH21Y30Y0RGKQQPrPxH\r\n" + 
	"Bwao6AEYcBEz3KpF0+z4IGElkNmMzCEp+gLs8VpQRG+Nfxu4d3TyoLlvnEwsV2PS\r\n" + 
	"jQIDAQAB\r\n" + 
	"-----END PUBLIC KEY-----";

}
