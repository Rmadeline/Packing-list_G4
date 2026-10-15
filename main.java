
public class main {
    public static void main(String[] args) {
        //  PASO 1:: Creamos un  objeto de la clase Vendedor
        Vendedor vendedor1 = new Vendedor();
        vendedor1.setIdvendedor("V001");
        vendedor1.setNombre("Juan");
        vendedor1.setEmail("juan@example.com");
        vendedor1.setDepartamento("Ventas");
        vendedor1.setActivo(true);

        // Mostramos los datos del vendedor
        System.out.println("ID del vendedor: " + vendedor1.getIdvendedor());
        System.out.println("Nombre del vendedor: " + vendedor1.getNombre());
        System.out.println("Email del vendedor: " + vendedor1.getEmail());
        System.out.println("Departamento del vendedor: " + vendedor1.getDepartamento());
        System.out.println("Estado del vendedor: " + vendedor1.isActivo());

        //  PASO 2:: Creamos un  objeto de la clase PackingList
        PackingList packingList1 = new PackingList();
        packingList1.setIdPackingList("PL001");
        packingList1.setDescripcion("ATUN\", \"ALBACORA 120 Lb");
        packingList1.setClienteConsignatario("SANTA PRISCILA S.A");
        packingList1.setVendedor("Juan");
        packingList1.setFechaEmision("2026-10-01");
        packingList1.setEstado("Pendiente");
        packingList1.setPuertoEmbarque("Puerto de Guayaquil");
        packingList1.setPaisDestino("Chile");

        // Mostramos los datos de la lista de empaque
        System.out.println("ID de la lista de empaque: " + packingList1.getIdPackingList());
        System.out.println("Descripción: " + packingList1.getDescripcion());
        System.out.println("Cliente consignatario: " + packingList1.getClienteConsignatario());
        System.out.println("Vendedor: " + packingList1.getVendedor());
        System.out.println("Fecha de emisión: " + packingList1.getFechaEmision());
        System.out.println("Estado: " + packingList1.getEstado());
        System.out.println("Puerto de embarque: " + packingList1.getPuertoEmbarque());
        System.out.println("País de destino: " + packingList1.getPaisDestino());

        //  PASO 3:: Creamos un  objeto de la clase FormularioPackingList
        FormularioPackingList formulario1 = new FormularioPackingList();
        formulario1.setCodigoFormulario("FR001");
        formulario1.setFechaExportacion("2026-10-01");
        formulario1.setFechaProduccion("2026-09-01");
        formulario1.setCodigoLote("PL001");
        formulario1.setCantidadPallets(10);
        formulario1.setDetallePallets("Pallets de atún");
        formulario1.setPaisDestino("Chile");

        // Mostramos los datos del formulario de lista de empaque
        System.out.println("Código del formulario: " + formulario1.getCodigoFormulario());
        System.out.println("Fecha de exportación: " + formulario1.getFechaExportacion());
        System.out.println("Fecha de producción: " + formulario1.getFechaProduccion());
        System.out.println("Código del lote: " + formulario1.getCodigoLote());
        System.out.println("Cantidad de pallets: " + formulario1.getCantidadPallets());
        System.out.println("Detalle de pallets: " + formulario1.getDetallePallets());
        System.out.println("País de destino: " + formulario1.getPaisDestino());

        //  PASO 4:: Creamos un  objeto de la clase InspeccionTemporal
        InspeccionTemporal inspeccion1 = new InspeccionTemporal();
        inspeccion1.setResultado("Aprobado");
        inspeccion1.setObservaciones("Sin observaciones adicionales");
        inspeccion1.setAprobadoSanitario(true);
        inspeccion1.setFormularioPackingList(formulario1);
        inspeccion1.evaluarEscalaCalidad();
        // Mostramos los datos 
        System.out.println("Evaluación de escala de calidad: " + inspeccion1.getResultado());
        System.out.println("Aprobado sanitario: " + inspeccion1.isAprobadoSanitario());
        System.out.println("Observaciones: " + inspeccion1.getObservaciones());

        // Mostramos los datos del formulario asociado a la inspección
        FormularioPackingList formularioAsociado = inspeccion1.getFormularioPackingList();
        System.out.println("Datos del formulario asociado:");
        System.out.println("  Código del formulario: " + formularioAsociado.getCodigoFormulario());
        System.out.println("  Fecha de exportación: " + formularioAsociado.getFechaExportacion());
        System.out.println("  Fecha de producción: " + formularioAsociado.getFechaProduccion());
        System.out.println("  Código del lote: " + formularioAsociado.getCodigoLote());
        System.out.println("  Cantidad de pallets: " + formularioAsociado.getCantidadPallets());
        System.out.println("  Detalle de pallets: " + formularioAsociado.getDetallePallets());
        System.out.println("  País de destino: " + formularioAsociado.getPaisDestino());
        // PASO 5:: Creamos un  objeto de la clase DespachoExportacion
        DespachoExportacion despacho1 = new DespachoExportacion("CONT001");
        despacho1.agregarInspeccion(inspeccion1);
        despacho1.generarResumenDespacho();
    }
    

}
