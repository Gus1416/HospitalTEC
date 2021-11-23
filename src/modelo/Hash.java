package modelo;

import java.security.NoSuchAlgorithmException;

/**
 * Clase para la encriptación de las contraseñas de los usuarios.
 * 
 * @author Gustavo
 * @version 05/11/2021
 */
public class Hash {
  
  /**
   * Encripta la conntraseña en Sha1 o MD5 según se requiera.
   * 
   * @param txt la contraseña del usuario sin encriptar
   * @param hashType el tipo de encriptación
   * @return  la contraseña encriptada
   */
  public static String getHash(String txt, String hashType){
    try{
      java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
      byte[] array = md.digest(txt.getBytes());
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.length; i++){
        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException ex){
      System.err.println(ex);
    }
    return null;
  }
  
  /**
   * Invoca la encriptación en MD5.
   * 
   * @param txt la contraseña sin encriptar
   * @return  la contraseña encriptada en MD5
   */
  public static String md5(String txt){
    return Hash.getHash(txt, "MD5");
  }
  
  /**
   * Invoca la encriptación en Sha1.
   * 
   * @param txt la contraseña sin encriptar
   * @return  la contraseña encriptada
   */
  public static String sha1(String txt){
    return Hash.getHash(txt, "SHA1");
  }
}
