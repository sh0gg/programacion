package proyectos.marotierra;

/**
 * Clase que representa un punto geográfico.
 */
public class PuntoGeografico {
    private String nombre;
    private double latitud;
    private double longitud;

    /**
     * Constructor de la clase PuntoGeografico.
     * @param nombre Nombre del punto geográfico.
     * @param latitud
     * @param longitud 
     */
    public PuntoGeografico(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        if (latitud < -90 || latitud > 90) {
            throw new IllegalArgumentException("La latitud debe estar entre -90 y 90");
        }
        this.latitud = latitud;
        if (longitud < -180 || longitud > 180) {
            throw new IllegalArgumentException("La longitud debe estar entre -180 y 180");
        }
        this.longitud = longitud;
    }

    public PuntoGeografico() {
        this.nombre = "";
        this.latitud = 0;
        this.longitud = 0;
    }

    /**
     * Genera un punto geográfico aleatorio.
     * 
     * @return Punto geográfico aleatorio.
     */
    public PuntoGeografico generarAleatorio() {
        PuntoGeografico puntoGeografico = new PuntoGeografico();
        puntoGeografico.nombre = "Aleatorio";
        puntoGeografico.latitud = Math.random() * 180 - 90;
        puntoGeografico.longitud = Math.random() * 360 - 180;
        return puntoGeografico;
    }

    /**
     * Muestra las coordenadas en grados decimales.
     */
    public void mostrarGradosDecimales() {
        System.out.println("Latitud: " + this.latitud);
        System.out.println("Longitud: " + this.longitud);
    }

    /**
     * Muestra las coordenadas en grados, minutos y segundos.
     */
    public void mostrarGradosDMS() {
        int grados = (int) Math.abs(latitud);
        double minutosDecimal = (Math.abs(latitud) - grados) * 60;
        int minutos = (int) minutosDecimal;
        double segundos = (int) ((minutosDecimal - minutos) * 60);
        System.out.println(
                "Latitud: " + grados + "° " + minutos + "' " + segundos + "\" " + ((latitud >= 0) ? "Norte" : "Sur"));

        grados = (int) Math.abs(longitud);
        minutosDecimal = (Math.abs(longitud) - grados) * 60;
        minutos = (int) minutosDecimal;
        segundos = (int) ((minutosDecimal - minutos) * 60);
        System.out.println(
                "Longitud: " + grados + "° " + minutos + "' " + segundos + "\" "
                        + ((longitud >= 0) ? "Este" : "Oeste"));
    }

    @Override
    public String toString() {
        return "PuntoGeografico [nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + "]";
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    /* URLs OSM Y GMAPS */

    public String urlGoogleMaps() {
        return "https://www.google.com/maps/search/?api=1&query=" + this.latitud + "," + this.longitud;
    }

    public String urlOpenStreetMaps() {
        return "https://www.openstreetmap.org/#map=14/" + this.latitud + "/" + this.longitud;
    }

    /* API OSM NOMINATIN */
    public String urlNominatimXml() {
        return "https://nominatim.openstreetmap.org/reverse?format=xml&lat=" + this.latitud + "&lon=" + this.longitud;
    }

    public String urlNominatimJson() {
        return "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + this.latitud + "&lon=" + this.longitud;
    }

    /* API OSM OSRM */

    /**
     * Genera la URL de la API OSRM para calcular la ruta entre dos puntos.
     * 
     * @param puntoGeograficoDestino Punto de destino.
     * @return URL de la API OSRM.
     */
    public String urlOsrmJson(PuntoGeografico puntoGeograficoDestino) {
        return "http://router.project-osrm.org/route/v1/driving/" + this.longitud + "," + this.latitud + ";"
                + puntoGeograficoDestino.longitud + "," + puntoGeograficoDestino.latitud
                + "?overview=false&geometries=geojson";
    }

    /**
     * Genera la URL de la API OSRM para calcular la ruta entre varios puntos.
     * 
     * @param puntoGeograficoOrigen  Punto de origen.
     * @param puntoGeograficoDestino Punto de destino.
     * @param puntosIntermedios      Puntos intermedios.
     * @return URL de la API OSRM.
     */
    public static String urlOsrmJson(PuntoGeografico puntoGeograficoOrigen, PuntoGeografico puntoGeograficoDestino,
            PuntoGeografico... puntosIntermedios) {
        String url = "http://router.project-osrm.org/route/v1/driving/" + puntoGeograficoOrigen.longitud + ","
                + puntoGeograficoOrigen.latitud;
        for (PuntoGeografico puntoGeografico : puntosIntermedios) {
            url += ";" + puntoGeografico.longitud + "," + puntoGeografico.latitud;
        }
        url += ";" + puntoGeograficoDestino.longitud + "," + puntoGeograficoDestino.latitud
                + "?overview=false&geometries=geojson";
        return url;
    }

    /**
     * Comprueba si el punto geográfico está en el mar.
     * 
     * @return true si está en el mar, false si está en tierra.
     */
    public boolean esMar() {
        boolean esMar = true;
        String url = this.urlNominatimJson();
        String json = Util.leerUrl(url);
        if (json.contains("country")) {
            esMar = false;
        }
        return esMar;
    }

    /**
     * Obtiene el país en el que se encuentra el punto geográfico.
     * 
     * @return Nombre del país.
     */
    public String getCountry() {
        String url = this.urlNominatimJson();
        String json = Util.leerUrl(url);
        String country = null;
        int index = json.indexOf("\"country\":");
        if (index != -1) {
            int index2 = json.indexOf("\"", index + 11);
            country = json.substring(index + 11, index2);
        }
        return country;
    }

}
