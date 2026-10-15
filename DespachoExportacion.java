
import java.util.ArrayList;
import java.util.List;

public class DespachoExportacion {
    // Atributos
    private String idContenedor;
    private String temperaturaConfigurada; 
    private List<InspeccionTemporal> listaInspecciones;

    // Constructor
    public DespachoExportacion(String idContenedor) {
        this.idContenedor = idContenedor;
        this.temperaturaConfigurada = "-20°C";
        this.listaInspecciones = new ArrayList<>();
    }

    // Getters y Setters
    public String getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(String idContenedor) {
        if (idContenedor == null || idContenedor.trim().isEmpty()) {
            System.out.println("Error: El ID del contenedor no puede estar vacío.");
            return;
        }
        this.idContenedor = idContenedor;
    }

    public String getTemperaturaConfigurada() {
        return temperaturaConfigurada;
    }

    public void setTemperaturaConfigurada(String temperaturaConfigurada) {
        this.temperaturaConfigurada = temperaturaConfigurada;
    }

    public List<InspeccionTemporal> getListaInspecciones() {
        return listaInspecciones;
    }

    public void setListaInspecciones(List<InspeccionTemporal> listaInspecciones) {
        this.listaInspecciones = listaInspecciones;
    }

    // Método para agregar inspecciones al contenedor
    public void agregarInspeccion(InspeccionTemporal inspeccion) {
        if (inspeccion != null) {
            this.listaInspecciones.add(inspeccion);
        } else {
            System.out.println("Error: No se puede agregar una inspección nula.");
        }
    }

    // --- Cierre de Packing List y Resumen de Despacho ---
    public void generarResumenDespacho() {
        int contadorOK = 0;
        int contadorObservacion = 0;
        int contadorRechazados = 0;
        double totalPallets = 0;

        System.out.println("==========================================");
        System.out.println("   REPORTE FINAL DE DESPACHO - CONTENEDOR ");
        System.out.println("   ID Contenedor: " + idContenedor + " | Temp: " + temperaturaConfigurada);
        System.out.println("==========================================");

        for (InspeccionTemporal insp : listaInspecciones) {
            String resultado = insp.getResultado();
            FormularioPackingList form = insp.getFormularioPackingList();
            
            if (form != null) {
                totalPallets += form.getCantidadPallets();
            }

            if ("ProductoOK".equals(resultado)) {
                contadorOK++;
            } else if ("Producto en Observación".equals(resultado)) {
                contadorObservacion++;
            } else {
                contadorRechazados++;
            }
        }

        System.out.println("Total de Lotes Inspeccionados: " + listaInspecciones.size());
        System.out.println("Total de Pallets Estibados: " + totalPallets);
        System.out.println("------------------------------------------");
        System.out.println(" [✓] Lotes ProductoOK (Aptos directos): " + contadorOK);
        System.out.println(" [!] Lotes en Observación (Aptos zarpe con restricción): " + contadorObservacion);
        System.out.println(" [X] Lotes Rechazados (Fuera de norma): " + contadorRechazados);
        System.out.println("==========================================");
        
        if (contadorRechazados == 0) {
            System.out.println("ESTADO: Contenedor CONSOLIDADO Y LISTO para Zarpe Internacional.");
        } else {
            System.out.println("ESTADO: Contenedor CON ALERTA. Requiere revisión de lotes rechazados.");
        }
    }
}