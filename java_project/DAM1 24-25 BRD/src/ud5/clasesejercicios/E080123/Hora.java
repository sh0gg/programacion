package ud5.clasesejercicios.E080123;

public class Hora {
    protected int hora;
    protected int minuto;

    // Constructor
    public Hora(int hora, int minuto) {
        if (hora >= 0 && hora < 24) {
            this.hora = hora;
        } else {
            this.hora = 0;
        }

        if (minuto >= 0 && minuto < 60) {
            this.minuto = minuto;
        } else {
            this.minuto = 0;
        }
    }

    // Incrementa la hora en un minuto
    public void inc() {
        minuto++;
        if (minuto == 60) {
            minuto = 0;
            hora++;
            if (hora == 24) {
                hora = 0;
            }
        }
    }

    // Asigna un nuevo valor a los minutos si es válido
    public boolean setMinuto(int valor) {
        if (valor >= 0 && valor < 60) {
            this.minuto = valor;
            return true;
        }
        return false;
    }

    // Asigna un nuevo valor a la hora si es válido
    public boolean setHora(int valor) {
        if (valor >= 0 && valor < 24) {
            this.hora = valor;
            return true;
        }
        return false;
    }

    // Representación en String de la hora
    @Override
    public String toString() {
        return String.format("%02d:%02d", hora, minuto);
    }
}
