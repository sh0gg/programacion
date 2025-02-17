package ud5.clasesejercicios.E0710;

import ud5.clasesejercicios.E0710.maquinaria.Locomotora;
import ud5.clasesejercicios.E0710.maquinaria.Tren;
import ud5.clasesejercicios.E0710.personal.JefeEstacion;
import ud5.clasesejercicios.E0710.personal.Maquinista;
import ud5.clasesejercicios.E0710.personal.Mecanico;

import java.time.LocalDate;

public class E0710 {
    public static void main(String[] args) {
        Maquinista maquinista = new Maquinista("María", "55555522X", 40000, "A");

        String especialidad = "MOTOR";

        Mecanico mecanicoPepe = new Mecanico("Pepe", "666666666", Mecanico.Especialidad.FRENOS);
        Mecanico mecanicoJuan = new Mecanico("Juan", "666666666", Mecanico.Especialidad.valueOf(especialidad));
        JefeEstacion jefe = new JefeEstacion("Lola", "897398738Z", LocalDate.of(2005, 01, 10));
        // no hay vagón: Vagon es solo visible por clases vecinas
        Locomotora locomotora = new Locomotora("V1-2323-AS", 3000, 2000, mecanicoPepe);

        /* EJEMPLOS DE INSTANCIACIÓN DE TRENES
        Tren tren2 = new Tren(locomotora, maquinista, 5);

        try {
            Tren tren3 = new Tren(locomotora, maquinista, 50);
        } catch (Exception e) {
            System.out.println("No se puede crear el tren. " + e.getMessage());
        }*/

        Tren tren = new Tren(locomotora, maquinista);
        tren.addVagon(1, 10000, 5000, "MADERA");
        tren.addVagon(2, 20000, 15000, "HIERRO");
        tren.addVagon(3, 8000, 6000, "PASAJEROS");

        System.out.println(tren);
        System.out.println(" ");
        System.out.println(jefe);

        mecanicoPepe.revisar(locomotora);
        mecanicoJuan.revisar(locomotora);
    }


}
