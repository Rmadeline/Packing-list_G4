
public class FormularioPackingList 
{
    // Atributos
    private String codigoFormulario;
    private String fechaExportacion;
    private String fechaProduccion;
    private String codigoLote;
    private int cantidadPallets;
    private String detallePallets;
    private String paisDestino;

    // Getters y Setters con validaciones (Invariantes)
    public String getCodigoFormulario() {
        return codigoFormulario;
    }

    public void setCodigoFormulario(String codigoFormulario) {
        if (codigoFormulario == null || codigoFormulario.trim().isEmpty()) {
            System.out.println("Error: El código de formulario no puede estar vacío.");
            return;
        }
        this.codigoFormulario = codigoFormulario;
    }

    public String getFechaExportacion() {
        return fechaExportacion;
    }

    public void setFechaExportacion(String fechaExportacion) {
        if (fechaExportacion == null || fechaExportacion.trim().isEmpty()) {
            System.out.println("Error: La fecha de exportación no puede estar vacía.");
            return;
        }
        this.fechaExportacion = fechaExportacion;
    }

    public String getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(String fechaProduccion) {
        if (fechaProduccion == null || fechaProduccion.trim().isEmpty()) {
            System.out.println("Error: La fecha de producción no puede estar vacía.");
            return;
        }
        this.fechaProduccion = fechaProduccion;
    }

    public String getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(String codigoLote) {
        if (codigoLote == null || codigoLote.trim().isEmpty()) {
            System.out.println("Error: El código de lote no puede estar vacío.");
            return;
        }
        this.codigoLote = codigoLote;
    }

    public int getCantidadPallets() {
        return cantidadPallets;
    }

    public void setCantidadPallets(int cantidadPallets) {
        if (cantidadPallets <= 0) {
            System.out.println("Error de Invariante: La cantidad de pallets debe ser mayor a 0.");
            return;
        }
        this.cantidadPallets = cantidadPallets;
    }

    public String getDetallePallets() {
        return detallePallets;
    }

    public void setDetallePallets(String detallePallets) {
        if (detallePallets == null || detallePallets.trim().isEmpty()) {
            System.out.println("Error: El detalle de pallets no puede estar vacío.");
            return;
        }
        this.detallePallets = detallePallets;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        if (paisDestino == null || paisDestino.trim().isEmpty()) {
            System.out.println("Error: El país de destino no puede estar vacío.");
            return;
        }
        this.paisDestino = paisDestino;
    }
}