
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InspeccionTemporal {
    // Atributos
    private String idInspeccion;
    private String fechaInspeccion;
    private String resultado;
    private String observaciones;
    private boolean aprobadoSanitario;

    // Atributo de asociación para conectar con el Formulario (como el ejemplo del profesor)
    private FormularioPackingList formularioPackingList;

    // Getters y Setters con validaciones (Invariantes)
    public String getIdInspeccion() {
        return idInspeccion;
    }

    public void setIdInspeccion(String idInspeccion) {
        if (idInspeccion == null || idInspeccion.trim().isEmpty()) {
            System.out.println("Error: El ID de inspección no puede estar vacío.");
            return;
        }
        this.idInspeccion = idInspeccion;
    }

    public String getFechaInspeccion() {
        return fechaInspeccion;
    }

    public void setFechaInspeccion(String fechaInspeccion) {
        if (fechaInspeccion == null || fechaInspeccion.trim().isEmpty()) {
            System.out.println("Error: La fecha de inspección no puede estar vacía.");
            return;
        }
        this.fechaInspeccion = fechaInspeccion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        if (resultado == null || resultado.trim().isEmpty()) {
            System.out.println("Error: El resultado no puede estar vacío.");
            return;
        }
        this.resultado = resultado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones; // Observaciones pueden estar vacías, no se valida
    }

    public boolean isAprobadoSanitario() {
        return aprobadoSanitario;
    }

    public void setAprobadoSanitario(boolean aprobadoSanitario) {
        this.aprobadoSanitario = aprobadoSanitario;
    }

    // Getters y Setters para el Formulario asociado
    public FormularioPackingList getFormularioPackingList() {
        return formularioPackingList;
    }

    public void setFormularioPackingList(FormularioPackingList formularioPackingList) {
        this.formularioPackingList = formularioPackingList;
    }

    // --- ESCALA DE CALIDAD TEMPORAL ---
    // Cálculo del tiempo transcurrido entre la fecha de producción y 
    // la fecha de exportación para garantizar frescura y estándares sanitarios de destino.
    public String evaluarEscalaCalidad() {
        if (formularioPackingList == null || 
            formularioPackingList.getFechaProduccion() == null || 
            formularioPackingList.getFechaExportacion() == null) {
            return "ERROR: Faltan datos en el formulario asociado.";
        }

        // Convertimos las fechas de String a LocalDate
        LocalDate produccion = LocalDate.parse(formularioPackingList.getFechaProduccion());
        LocalDate exportacion = LocalDate.parse(formularioPackingList.getFechaExportacion());

        // Calculamos los días transcurridos
        long diasTranscurridos = ChronoUnit.DAYS.between(produccion, exportacion);

        // Si la producción es posterior a la exportación
        if (diasTranscurridos < 0) {
            this.aprobadoSanitario = false;
            this.resultado = "Rechazado";
            return "Rechazado: La fecha de producción es posterior a la de exportación.";
        }

        // Aplicando la Escala de Calidad Temporal:
        // - Menor a 1 mes (menos de 30 días): ProductoOK
        // - Entre 1 y 2 meses (entre 30 y 60 días): Producto en Observación
        // - Mayor a 2 meses (más de 60 días): Rechazado
        if (diasTranscurridos < 30) {
            this.aprobadoSanitario = true;
            this.resultado = "ProductoOK";
            return "ProductoOK";
        } else if (diasTranscurridos >= 30 && diasTranscurridos <= 60) {
            this.aprobadoSanitario = true; // O false según criterio estricto, por defecto pasa a observación
            this.resultado = "Producto en Observación";
            return "Producto en Observación";
        } else {
            this.aprobadoSanitario = false;
            this.resultado = "Rechazado";
            return "Rechazado";
        }
    }
}