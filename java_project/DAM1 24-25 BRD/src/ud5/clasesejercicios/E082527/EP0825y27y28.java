package ud5.clasesejercicios.E082527;

public class EP0825y27y28 {

    public class Punto {
        private String name;
        private double x;
        private double y;

        public Punto(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distancia(Punto otroPunto) {
            double distancia = Math.sqrt(Math.pow(otroPunto.getX() - getX(), 2) + Math.pow(otroPunto.getY() - getY(), 2));
            return distancia;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Punto punto = (Punto) obj;
            return x == punto.x && y == punto.y;
        }
    }

    public class Punto3D extends Punto {
        private double z;
        public Punto3D(double x, double y, double z) {
            super(x,y);
            this.z = z;
        }

        public double getZ() {
            return z;
        }

        public void setZ(double z) {
            this.z = z;
        }

        public double distancia(Punto3D otroPunto) {
            double distancia = Math.sqrt(Math.pow(otroPunto.getX() - getX(), 2) + Math.pow(otroPunto.getY() - getY(), 2) + Math.pow(otroPunto.getZ() - getZ(), 2 ));
            return distancia;
        }

        @Override
        public boolean equals(Object obj) {
            if (!super.equals(obj)) return false;
            Punto3D punto3D = (Punto3D) obj;
            return z == punto3D.z;
        }
    }

    public  class Suceso extends Punto3D {
        private int tiempo;
        private String descripcion;

        public Suceso(int x, int y, int z, int tiempo, String descripcion) {
            super(x, y, z);
            this.tiempo = tiempo;
            this.descripcion = descripcion;

        }

        @Override
        public boolean equals(Object obj) {
            if (!super.equals(obj)) return false;
            Suceso suceso = (Suceso) obj;
            return getTiempo() == suceso.getTiempo() && getDescripcion().equals(suceso.getDescripcion());
        }

        public int getTiempo() {
            return tiempo;
        }

        public void setTiempo(int tiempo) {
            this.tiempo = tiempo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }

}
