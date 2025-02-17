package ud5.clasesejercicios.E0710.maquinaria;

import ud5.clasesejercicios.E0710.personal.Mecanico;

public class Locomotora {
    String matricula;
    int potencia;
    int anoFabricacion;
    Mecanico mecanico;

    public Locomotora(String matricula, int potencia, int anoFabricacion, Mecanico mecanico) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.anoFabricacion = anoFabricacion;
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return "Locomotora (" +
                "matricula: " + matricula + ' ' +
                ", CV: " + potencia +
                ", fabricada en el año " + anoFabricacion +
                ", mantenida por " + mecanico +
                '.';
    }

    public String getMatricula() {
        return matricula;
    }
}
