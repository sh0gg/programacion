package ud5.clasesejercicios.E080123;

public class HoraExacta extends Hora {
    private int segundo;

    // Constructor
    public HoraExacta(int hora, int minuto, int segundo) {
        super(hora, minuto);
        if (segundo >= 0 && segundo < 60) {
            this.segundo = segundo;
        } else {
            this.segundo = 0;
        }
    }

    // Asigna un nuevo valor a los segundos si es válido
    public boolean setSegundo(int valor) {
        if (valor >= 0 && valor < 60) {
            this.segundo = valor;
            return true;
        }
        return false;
    }

    // Incrementa la hora en un segundo
    @Override
    public void inc() {
        segundo++;
        if (segundo == 60) {
            segundo = 0;
            super.inc(); // Llama al método inc() de la clase padre para manejar minutos y horas
        }
    }

    // Compara si dos instancias de HoraExacta son iguales
    public boolean equals(HoraExacta otra) {
        return this.hora == otra.hora && this.minuto == otra.minuto && this.segundo == otra.segundo;
    }

    // Representación en String de la hora exacta
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
}
