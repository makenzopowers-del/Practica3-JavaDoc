/**
 * Clase especializada que representa un Servidor Web (ej. Nginx o Apache).
 * Hereda las propiedades de la clase madre {@link Servidor}.
 * * @author Makenzo, Simeón
 * @version 1.1
 * @see Servidor
 */
public class ServidorWeb extends Servidor {

    private String tecnologiaWeb; // Ej: "Nginx", "Apache"

    /**
     * Constructor para el servidor web especializado.
     * * @param ip Dirección IP.
     * @param ram RAM en GB.
     * @param tecnologiaWeb Software de servidor web a utilizar.
     */
    public ServidorWeb(String ip, int ram, String tecnologiaWeb) {
        super(ip, ram);
        this.tecnologiaWeb = tecnologiaWeb;
    }

    // --- NUEVOS MÉTODOS ---

    /**
     * <b>Función Extra 1:</b> Asigna un dominio DNS a este servidor web.
     * * @param dominio Nombre del dominio (ej: www.miweb.com).
     */
    public void asignarDominio(String dominio) {
        System.out.println("Redirigiendo el dominio " + dominio + " hacia la IP " + getIp());
    }

    /**
     * <b>Función Extra 2:</b> Comprueba si el servidor está preparado para servir tráfico HTTPS seguro.
     * * @deprecated Este método está obsoleto. Se recomienda usar una herramienta externa de certificación.
     * @return Siempre devuelve true en este simulador de seguridad.
     */
    @Deprecated
    public boolean comprobarSSL() {
        return true;
    }
}