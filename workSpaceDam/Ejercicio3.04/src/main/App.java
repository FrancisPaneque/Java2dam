package main;
import utilidades.*;

public class App {

	public static void main(String[] args) {
	// Ejemplo de uso con datos normales
    String elementoHTML = Acondicionador.acondicionaElementoHTML("<p>Texto normal</p>");
    String atributoHTML = Acondicionador.acondicionaAtributoHTML("valor del atributo");
    String contenidoCss = Acondicionador.acondicionaContenidoCss("color: blue;");
    String url = Acondicionador.acondicionaUrl("https://www.ejemplo.com");
    String literalSQL = Acondicionador.acondicionaLiteralSQL("SELECT * FROM tabla");

    System.out.println("Datos normales:");
    System.out.println("Elemento HTML: " + elementoHTML);
    System.out.println("Atributo HTML: " + atributoHTML);
    System.out.println("Contenido CSS: " + contenidoCss);
    System.out.println("URL: " + url);
    System.out.println("Literal SQL: " + literalSQL);

    // Ejemplo de uso con datos comprometidos (con caracteres prohibidos)
    String elementoHTMLComprometido = Acondicionador.acondicionaElementoHTML("<script>alert('Hola')</script>");
    String atributoHTMLComprometido = Acondicionador.acondicionaAtributoHTML("valor del atributo\" onclick=\"alert('Hola')");
    String contenidoCssComprometido = Acondicionador.acondicionaContenidoCss("color: red;\"}");
    String urlComprometida = Acondicionador.acondicionaUrl("javascript:alert('Hola')");
    String literalSQLComprometido = Acondicionador.acondicionaLiteralSQL("'; DROP TABLE usuarios; --");

    System.out.println("\nDatos comprometidos:");
    System.out.println("Elemento HTML: " + elementoHTMLComprometido);
    System.out.println("Atributo HTML: " + atributoHTMLComprometido);
    System.out.println("Contenido CSS: " + contenidoCssComprometido);
    System.out.println("URL: " + urlComprometida);
    System.out.println("Literal SQL: " + literalSQLComprometido);

	}

}
