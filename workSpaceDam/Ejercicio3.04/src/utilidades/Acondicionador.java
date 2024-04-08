package utilidades;

public class Acondicionador {
	
	public static String acondicionaElementoHTML(String cadena) {
    // Reemplaza los caracteres especiales para elementos HTML
    return cadena.replaceAll("<", "&lt;")
                 .replaceAll(">", "&gt;")
                 .replaceAll("&", "&amp;");
	}
	
	public static String acondicionaAtributoHTML(String cadena) {
	    // Reemplaza los caracteres especiales para atributos HTML
	    return cadena.replaceAll("\"", "&quot;");
	}
	
	public static String acondicionaContenidoCss(String cadena) {
	    // Escapa las comillas y las llaves para contenido CSS
	    return cadena.replaceAll("'", "\\\\'")
	                 .replaceAll("\"", "\\\\\"")
	                 .replaceAll("\\{", "\\\\{")
	                 .replaceAll("\\}", "\\\\}");
	}
	
	public static String acondicionaUrl(String cadena) {
	    // Verifica si la URL es segura (comienza con "https://" o "http://")
	    if (cadena.startsWith("https://") || cadena.startsWith("http://")) {
	        return cadena;
	    } else {
	        // Si no es segura, devuelve una cadena vacía o realiza otra acción según tus requisitos
	        return "";
	    }
	}
	
	public static String acondicionaLiteralSQL(String cadena) {
	    // Reemplaza las comillas simples para literales SQL
	    return cadena.replaceAll("'", "''");
	}
}
