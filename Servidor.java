/**
 * Clase que representa un Servidor genérico en la nube.
 * Implementa la interfaz {@link Desplegable}.
 * * @author Makenzo, Simeón
 * @see Desplegable
 */
public class Servidor implements Desplegable {
    
    private String ip;
    private int ram;
    private boolean activo;

    /**
     * Constructor por defecto que inicializa un servidor básico.
     */
    public Servidor() {
        this.ip = "127.0.0.1";
        this.ram = 4;
        this.activo = false;
    }

    /**
     * Constructor parametrizado para crear un servidor a medida.
     * * @param ip Dirección IP asignada al servidor.
     * @param ram Cantidad de memoria RAM en Gigabytes (GB).
     */
    public Servidor(String ip, int ram) {
        this.ip = ip;
        this.ram = ram;
        this.activo = false;
    }

    // --- GETTERS Y SETTERS ---

    /** @return La dirección IP actual del servidor. */
    public String getIp() { return ip; }
    /** @param ip Nueva dirección IP a asignar. */
    public void setIp(String ip) { this.ip = ip; }
    /** @return true si el servidor está encendido. */
    public boolean isActivo() { return activo; }

    // --- MÉTODOS REQUERIDOS ---

    /**
     * <b>Función 1 (Parámetros):</b> Escanea un puerto específico del servidor para comprobar su disponibilidad.
     * * @param puerto Número del puerto a escanear (ej. 80, 443).
     * @since 1.5
     */
    public void escanearPuerto(int puerto) {
        System.out.println("Escaneando puerto " + puerto + " en la IP " + this.ip);
    }

    /**
     * <b>Función 2 (Devuelve valor):</b> Calcula el coste mensual estimado del servidor en base a su RAM.
     * * @param precioPorGB El coste en euros de 1 GB de RAM por hora.
     * @return El coste total estimado en euros para un mes (730 horas).
     */
    public double calcularCosteMensual(double precioPorGB) {
        return this.ram * precioPorGB * 730;
    }

    /**
     * <b>Función 3 (Lanza Excepción):</b> Intenta conectar al servidor mediante SSH.
     * * @param usuario Nombre del usuario administrador.
     * @throws IllegalArgumentException Si el usuario es "root" por motivos de seguridad.
     * @throws IllegalStateException Si el servidor está apagado.
     */
    public void conexionSSH(String usuario) throws IllegalArgumentException, IllegalStateException {
        if (!this.activo) {
            throw new IllegalStateException("Error: No se puede conectar. El servidor está APAGADO.");
        }
        if ("root".equalsIgnoreCase(usuario)) {
            throw new IllegalArgumentException("Seguridad denegada: El acceso directo como 'root' está prohibido.");
        }
        System.out.println("Conexión SSH establecida con éxito para el usuario: " + usuario);
    }

    /**
     * Implementación del método de la interfaz {@link Desplegable}.
     */
    @Override
    public boolean desplegar() {
        this.activo = true;
        System.out.println("Servidor desplegado y activo.");
        return true;
    }
}