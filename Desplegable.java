/**
 * Interfaz que define las operaciones esenciales para cualquier recurso
 * que pueda ser desplegado en un entorno de producción.
 * * @author Makenzo, Simeón
 * @version 1.0
 * @since 2026
 */
public interface Desplegable {
    
    /**
     * Inicia el proceso de despliegue del componente.
     * @return true si el despliegue fue exitoso, false en caso contrario.
     */
    boolean desplegar();
}