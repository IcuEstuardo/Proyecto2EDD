
package implementacion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the implementacion package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RutasMinimas_QNAME = new QName("http://Implementacion/", "RutasMinimas");
    private final static QName _ReporteGrafo_QNAME = new QName("http://Implementacion/", "ReporteGrafo");
    private final static QName _RutasMinimasResponse_QNAME = new QName("http://Implementacion/", "RutasMinimasResponse");
    private final static QName _ObtenerHistorial_QNAME = new QName("http://Implementacion/", "ObtenerHistorial");
    private final static QName _EliminarArbolResponse_QNAME = new QName("http://Implementacion/", "EliminarArbolResponse");
    private final static QName _FuncionPruebaResponse_QNAME = new QName("http://Implementacion/", "FuncionPruebaResponse");
    private final static QName _GrafoRutaMinima_QNAME = new QName("http://Implementacion/", "GrafoRutaMinima");
    private final static QName _BusquedaUsuario_QNAME = new QName("http://Implementacion/", "BusquedaUsuario");
    private final static QName _GraficarHistoria_QNAME = new QName("http://Implementacion/", "GraficarHistoria");
    private final static QName _EliminacionUsuario_QNAME = new QName("http://Implementacion/", "EliminacionUsuario");
    private final static QName _ReporteUsuario_QNAME = new QName("http://Implementacion/", "ReporteUsuario");
    private final static QName _GrafoRutaMinimaResponse_QNAME = new QName("http://Implementacion/", "GrafoRutaMinimaResponse");
    private final static QName _CrearHistorial_QNAME = new QName("http://Implementacion/", "CrearHistorial");
    private final static QName _ReporteGrafoResponse_QNAME = new QName("http://Implementacion/", "ReporteGrafoResponse");
    private final static QName _BusquedaUsuarioResponse_QNAME = new QName("http://Implementacion/", "BusquedaUsuarioResponse");
    private final static QName _SubirPesos_QNAME = new QName("http://Implementacion/", "SubirPesos");
    private final static QName _SubirPesosResponse_QNAME = new QName("http://Implementacion/", "SubirPesosResponse");
    private final static QName _AgregarTiempoResponse_QNAME = new QName("http://Implementacion/", "AgregarTiempoResponse");
    private final static QName _RegistroUsuario_QNAME = new QName("http://Implementacion/", "RegistroUsuario");
    private final static QName _EliminacionUsuarioResponse_QNAME = new QName("http://Implementacion/", "EliminacionUsuarioResponse");
    private final static QName _ObtenerHistorialResponse_QNAME = new QName("http://Implementacion/", "ObtenerHistorialResponse");
    private final static QName _ModificacionUsuario_QNAME = new QName("http://Implementacion/", "ModificacionUsuario");
    private final static QName _EliminarArbol_QNAME = new QName("http://Implementacion/", "EliminarArbol");
    private final static QName _GraficarEstado_QNAME = new QName("http://Implementacion/", "GraficarEstado");
    private final static QName _GraficarEstadoResponse_QNAME = new QName("http://Implementacion/", "GraficarEstadoResponse");
    private final static QName _ReporteUsuarioResponse_QNAME = new QName("http://Implementacion/", "ReporteUsuarioResponse");
    private final static QName _AgregarTiempo_QNAME = new QName("http://Implementacion/", "AgregarTiempo");
    private final static QName _SubirVertices_QNAME = new QName("http://Implementacion/", "SubirVertices");
    private final static QName _ModificacionUsuarioResponse_QNAME = new QName("http://Implementacion/", "ModificacionUsuarioResponse");
    private final static QName _FuncionPrueba_QNAME = new QName("http://Implementacion/", "FuncionPrueba");
    private final static QName _RegistroUsuarioResponse_QNAME = new QName("http://Implementacion/", "RegistroUsuarioResponse");
    private final static QName _CrearHistorialResponse_QNAME = new QName("http://Implementacion/", "CrearHistorialResponse");
    private final static QName _GraficarHistoriaResponse_QNAME = new QName("http://Implementacion/", "GraficarHistoriaResponse");
    private final static QName _SubirVerticesResponse_QNAME = new QName("http://Implementacion/", "SubirVerticesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: implementacion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GraficarEstado }
     * 
     */
    public GraficarEstado createGraficarEstado() {
        return new GraficarEstado();
    }

    /**
     * Create an instance of {@link GraficarEstadoResponse }
     * 
     */
    public GraficarEstadoResponse createGraficarEstadoResponse() {
        return new GraficarEstadoResponse();
    }

    /**
     * Create an instance of {@link ReporteUsuarioResponse }
     * 
     */
    public ReporteUsuarioResponse createReporteUsuarioResponse() {
        return new ReporteUsuarioResponse();
    }

    /**
     * Create an instance of {@link AgregarTiempo }
     * 
     */
    public AgregarTiempo createAgregarTiempo() {
        return new AgregarTiempo();
    }

    /**
     * Create an instance of {@link SubirVertices }
     * 
     */
    public SubirVertices createSubirVertices() {
        return new SubirVertices();
    }

    /**
     * Create an instance of {@link ModificacionUsuarioResponse }
     * 
     */
    public ModificacionUsuarioResponse createModificacionUsuarioResponse() {
        return new ModificacionUsuarioResponse();
    }

    /**
     * Create an instance of {@link FuncionPrueba }
     * 
     */
    public FuncionPrueba createFuncionPrueba() {
        return new FuncionPrueba();
    }

    /**
     * Create an instance of {@link RegistroUsuarioResponse }
     * 
     */
    public RegistroUsuarioResponse createRegistroUsuarioResponse() {
        return new RegistroUsuarioResponse();
    }

    /**
     * Create an instance of {@link CrearHistorialResponse }
     * 
     */
    public CrearHistorialResponse createCrearHistorialResponse() {
        return new CrearHistorialResponse();
    }

    /**
     * Create an instance of {@link GraficarHistoriaResponse }
     * 
     */
    public GraficarHistoriaResponse createGraficarHistoriaResponse() {
        return new GraficarHistoriaResponse();
    }

    /**
     * Create an instance of {@link SubirVerticesResponse }
     * 
     */
    public SubirVerticesResponse createSubirVerticesResponse() {
        return new SubirVerticesResponse();
    }

    /**
     * Create an instance of {@link AgregarTiempoResponse }
     * 
     */
    public AgregarTiempoResponse createAgregarTiempoResponse() {
        return new AgregarTiempoResponse();
    }

    /**
     * Create an instance of {@link RegistroUsuario }
     * 
     */
    public RegistroUsuario createRegistroUsuario() {
        return new RegistroUsuario();
    }

    /**
     * Create an instance of {@link EliminacionUsuarioResponse }
     * 
     */
    public EliminacionUsuarioResponse createEliminacionUsuarioResponse() {
        return new EliminacionUsuarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerHistorialResponse }
     * 
     */
    public ObtenerHistorialResponse createObtenerHistorialResponse() {
        return new ObtenerHistorialResponse();
    }

    /**
     * Create an instance of {@link ModificacionUsuario }
     * 
     */
    public ModificacionUsuario createModificacionUsuario() {
        return new ModificacionUsuario();
    }

    /**
     * Create an instance of {@link EliminarArbol }
     * 
     */
    public EliminarArbol createEliminarArbol() {
        return new EliminarArbol();
    }

    /**
     * Create an instance of {@link GraficarHistoria }
     * 
     */
    public GraficarHistoria createGraficarHistoria() {
        return new GraficarHistoria();
    }

    /**
     * Create an instance of {@link EliminacionUsuario }
     * 
     */
    public EliminacionUsuario createEliminacionUsuario() {
        return new EliminacionUsuario();
    }

    /**
     * Create an instance of {@link ReporteUsuario }
     * 
     */
    public ReporteUsuario createReporteUsuario() {
        return new ReporteUsuario();
    }

    /**
     * Create an instance of {@link GrafoRutaMinimaResponse }
     * 
     */
    public GrafoRutaMinimaResponse createGrafoRutaMinimaResponse() {
        return new GrafoRutaMinimaResponse();
    }

    /**
     * Create an instance of {@link CrearHistorial }
     * 
     */
    public CrearHistorial createCrearHistorial() {
        return new CrearHistorial();
    }

    /**
     * Create an instance of {@link ReporteGrafoResponse }
     * 
     */
    public ReporteGrafoResponse createReporteGrafoResponse() {
        return new ReporteGrafoResponse();
    }

    /**
     * Create an instance of {@link BusquedaUsuarioResponse }
     * 
     */
    public BusquedaUsuarioResponse createBusquedaUsuarioResponse() {
        return new BusquedaUsuarioResponse();
    }

    /**
     * Create an instance of {@link SubirPesos }
     * 
     */
    public SubirPesos createSubirPesos() {
        return new SubirPesos();
    }

    /**
     * Create an instance of {@link SubirPesosResponse }
     * 
     */
    public SubirPesosResponse createSubirPesosResponse() {
        return new SubirPesosResponse();
    }

    /**
     * Create an instance of {@link RutasMinimas }
     * 
     */
    public RutasMinimas createRutasMinimas() {
        return new RutasMinimas();
    }

    /**
     * Create an instance of {@link ReporteGrafo }
     * 
     */
    public ReporteGrafo createReporteGrafo() {
        return new ReporteGrafo();
    }

    /**
     * Create an instance of {@link RutasMinimasResponse }
     * 
     */
    public RutasMinimasResponse createRutasMinimasResponse() {
        return new RutasMinimasResponse();
    }

    /**
     * Create an instance of {@link ObtenerHistorial }
     * 
     */
    public ObtenerHistorial createObtenerHistorial() {
        return new ObtenerHistorial();
    }

    /**
     * Create an instance of {@link EliminarArbolResponse }
     * 
     */
    public EliminarArbolResponse createEliminarArbolResponse() {
        return new EliminarArbolResponse();
    }

    /**
     * Create an instance of {@link FuncionPruebaResponse }
     * 
     */
    public FuncionPruebaResponse createFuncionPruebaResponse() {
        return new FuncionPruebaResponse();
    }

    /**
     * Create an instance of {@link GrafoRutaMinima }
     * 
     */
    public GrafoRutaMinima createGrafoRutaMinima() {
        return new GrafoRutaMinima();
    }

    /**
     * Create an instance of {@link BusquedaUsuario }
     * 
     */
    public BusquedaUsuario createBusquedaUsuario() {
        return new BusquedaUsuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RutasMinimas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "RutasMinimas")
    public JAXBElement<RutasMinimas> createRutasMinimas(RutasMinimas value) {
        return new JAXBElement<RutasMinimas>(_RutasMinimas_QNAME, RutasMinimas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReporteGrafo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "ReporteGrafo")
    public JAXBElement<ReporteGrafo> createReporteGrafo(ReporteGrafo value) {
        return new JAXBElement<ReporteGrafo>(_ReporteGrafo_QNAME, ReporteGrafo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RutasMinimasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "RutasMinimasResponse")
    public JAXBElement<RutasMinimasResponse> createRutasMinimasResponse(RutasMinimasResponse value) {
        return new JAXBElement<RutasMinimasResponse>(_RutasMinimasResponse_QNAME, RutasMinimasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerHistorial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "ObtenerHistorial")
    public JAXBElement<ObtenerHistorial> createObtenerHistorial(ObtenerHistorial value) {
        return new JAXBElement<ObtenerHistorial>(_ObtenerHistorial_QNAME, ObtenerHistorial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarArbolResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "EliminarArbolResponse")
    public JAXBElement<EliminarArbolResponse> createEliminarArbolResponse(EliminarArbolResponse value) {
        return new JAXBElement<EliminarArbolResponse>(_EliminarArbolResponse_QNAME, EliminarArbolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FuncionPruebaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "FuncionPruebaResponse")
    public JAXBElement<FuncionPruebaResponse> createFuncionPruebaResponse(FuncionPruebaResponse value) {
        return new JAXBElement<FuncionPruebaResponse>(_FuncionPruebaResponse_QNAME, FuncionPruebaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GrafoRutaMinima }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "GrafoRutaMinima")
    public JAXBElement<GrafoRutaMinima> createGrafoRutaMinima(GrafoRutaMinima value) {
        return new JAXBElement<GrafoRutaMinima>(_GrafoRutaMinima_QNAME, GrafoRutaMinima.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "BusquedaUsuario")
    public JAXBElement<BusquedaUsuario> createBusquedaUsuario(BusquedaUsuario value) {
        return new JAXBElement<BusquedaUsuario>(_BusquedaUsuario_QNAME, BusquedaUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GraficarHistoria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "GraficarHistoria")
    public JAXBElement<GraficarHistoria> createGraficarHistoria(GraficarHistoria value) {
        return new JAXBElement<GraficarHistoria>(_GraficarHistoria_QNAME, GraficarHistoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminacionUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "EliminacionUsuario")
    public JAXBElement<EliminacionUsuario> createEliminacionUsuario(EliminacionUsuario value) {
        return new JAXBElement<EliminacionUsuario>(_EliminacionUsuario_QNAME, EliminacionUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReporteUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "ReporteUsuario")
    public JAXBElement<ReporteUsuario> createReporteUsuario(ReporteUsuario value) {
        return new JAXBElement<ReporteUsuario>(_ReporteUsuario_QNAME, ReporteUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GrafoRutaMinimaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "GrafoRutaMinimaResponse")
    public JAXBElement<GrafoRutaMinimaResponse> createGrafoRutaMinimaResponse(GrafoRutaMinimaResponse value) {
        return new JAXBElement<GrafoRutaMinimaResponse>(_GrafoRutaMinimaResponse_QNAME, GrafoRutaMinimaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearHistorial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "CrearHistorial")
    public JAXBElement<CrearHistorial> createCrearHistorial(CrearHistorial value) {
        return new JAXBElement<CrearHistorial>(_CrearHistorial_QNAME, CrearHistorial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReporteGrafoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "ReporteGrafoResponse")
    public JAXBElement<ReporteGrafoResponse> createReporteGrafoResponse(ReporteGrafoResponse value) {
        return new JAXBElement<ReporteGrafoResponse>(_ReporteGrafoResponse_QNAME, ReporteGrafoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "BusquedaUsuarioResponse")
    public JAXBElement<BusquedaUsuarioResponse> createBusquedaUsuarioResponse(BusquedaUsuarioResponse value) {
        return new JAXBElement<BusquedaUsuarioResponse>(_BusquedaUsuarioResponse_QNAME, BusquedaUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubirPesos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "SubirPesos")
    public JAXBElement<SubirPesos> createSubirPesos(SubirPesos value) {
        return new JAXBElement<SubirPesos>(_SubirPesos_QNAME, SubirPesos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubirPesosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "SubirPesosResponse")
    public JAXBElement<SubirPesosResponse> createSubirPesosResponse(SubirPesosResponse value) {
        return new JAXBElement<SubirPesosResponse>(_SubirPesosResponse_QNAME, SubirPesosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarTiempoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "AgregarTiempoResponse")
    public JAXBElement<AgregarTiempoResponse> createAgregarTiempoResponse(AgregarTiempoResponse value) {
        return new JAXBElement<AgregarTiempoResponse>(_AgregarTiempoResponse_QNAME, AgregarTiempoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistroUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "RegistroUsuario")
    public JAXBElement<RegistroUsuario> createRegistroUsuario(RegistroUsuario value) {
        return new JAXBElement<RegistroUsuario>(_RegistroUsuario_QNAME, RegistroUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminacionUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "EliminacionUsuarioResponse")
    public JAXBElement<EliminacionUsuarioResponse> createEliminacionUsuarioResponse(EliminacionUsuarioResponse value) {
        return new JAXBElement<EliminacionUsuarioResponse>(_EliminacionUsuarioResponse_QNAME, EliminacionUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerHistorialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "ObtenerHistorialResponse")
    public JAXBElement<ObtenerHistorialResponse> createObtenerHistorialResponse(ObtenerHistorialResponse value) {
        return new JAXBElement<ObtenerHistorialResponse>(_ObtenerHistorialResponse_QNAME, ObtenerHistorialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificacionUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "ModificacionUsuario")
    public JAXBElement<ModificacionUsuario> createModificacionUsuario(ModificacionUsuario value) {
        return new JAXBElement<ModificacionUsuario>(_ModificacionUsuario_QNAME, ModificacionUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarArbol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "EliminarArbol")
    public JAXBElement<EliminarArbol> createEliminarArbol(EliminarArbol value) {
        return new JAXBElement<EliminarArbol>(_EliminarArbol_QNAME, EliminarArbol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GraficarEstado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "GraficarEstado")
    public JAXBElement<GraficarEstado> createGraficarEstado(GraficarEstado value) {
        return new JAXBElement<GraficarEstado>(_GraficarEstado_QNAME, GraficarEstado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GraficarEstadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "GraficarEstadoResponse")
    public JAXBElement<GraficarEstadoResponse> createGraficarEstadoResponse(GraficarEstadoResponse value) {
        return new JAXBElement<GraficarEstadoResponse>(_GraficarEstadoResponse_QNAME, GraficarEstadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReporteUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "ReporteUsuarioResponse")
    public JAXBElement<ReporteUsuarioResponse> createReporteUsuarioResponse(ReporteUsuarioResponse value) {
        return new JAXBElement<ReporteUsuarioResponse>(_ReporteUsuarioResponse_QNAME, ReporteUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarTiempo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "AgregarTiempo")
    public JAXBElement<AgregarTiempo> createAgregarTiempo(AgregarTiempo value) {
        return new JAXBElement<AgregarTiempo>(_AgregarTiempo_QNAME, AgregarTiempo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubirVertices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "SubirVertices")
    public JAXBElement<SubirVertices> createSubirVertices(SubirVertices value) {
        return new JAXBElement<SubirVertices>(_SubirVertices_QNAME, SubirVertices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificacionUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "ModificacionUsuarioResponse")
    public JAXBElement<ModificacionUsuarioResponse> createModificacionUsuarioResponse(ModificacionUsuarioResponse value) {
        return new JAXBElement<ModificacionUsuarioResponse>(_ModificacionUsuarioResponse_QNAME, ModificacionUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FuncionPrueba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "FuncionPrueba")
    public JAXBElement<FuncionPrueba> createFuncionPrueba(FuncionPrueba value) {
        return new JAXBElement<FuncionPrueba>(_FuncionPrueba_QNAME, FuncionPrueba.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistroUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "RegistroUsuarioResponse")
    public JAXBElement<RegistroUsuarioResponse> createRegistroUsuarioResponse(RegistroUsuarioResponse value) {
        return new JAXBElement<RegistroUsuarioResponse>(_RegistroUsuarioResponse_QNAME, RegistroUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearHistorialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "CrearHistorialResponse")
    public JAXBElement<CrearHistorialResponse> createCrearHistorialResponse(CrearHistorialResponse value) {
        return new JAXBElement<CrearHistorialResponse>(_CrearHistorialResponse_QNAME, CrearHistorialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GraficarHistoriaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "GraficarHistoriaResponse")
    public JAXBElement<GraficarHistoriaResponse> createGraficarHistoriaResponse(GraficarHistoriaResponse value) {
        return new JAXBElement<GraficarHistoriaResponse>(_GraficarHistoriaResponse_QNAME, GraficarHistoriaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubirVerticesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Implementacion/", name = "SubirVerticesResponse")
    public JAXBElement<SubirVerticesResponse> createSubirVerticesResponse(SubirVerticesResponse value) {
        return new JAXBElement<SubirVerticesResponse>(_SubirVerticesResponse_QNAME, SubirVerticesResponse.class, null, value);
    }

}
