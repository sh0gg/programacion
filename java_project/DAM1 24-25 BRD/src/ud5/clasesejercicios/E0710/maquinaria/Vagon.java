package ud5.clasesejercicios.E0710.maquinaria;

class Vagon {
    int id;
    int cargaMaxima;
    int cargaActual;
    String tipoMercancia;

    public Vagon(int id, int cargaMaxima, int cargaActual, String tipoMercancia) {
        this.id = id;
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
    }

    public Vagon(int id) {
        this.id = id;
        this.cargaMaxima = 10000;
        this.cargaActual = 0;
        this.tipoMercancia = "Variada";
    }

    @Override
    public String toString() {
        return "Vagon " + id +
                " (carga máxima: " + cargaMaxima + " " +
                ", carga actual: " + cargaActual + " " +
                ", mercancia: '" + tipoMercancia + ")";
    }
}
