package utilities;

public class Celda {
    Integer numero;
    Boolean numeroPuesto;
    boolean[] posibles;

    public Celda() {
        numeroPuesto = false;
        posibles = new boolean[9];
        posibles[0] = true;
        posibles[1] = true;
        posibles[2] = true;
        posibles[3] = true;
        posibles[4] = true;
        posibles[5] = true;
        posibles[6] = true;
        posibles[7] = true;
        posibles[8] = true;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(Boolean numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

    public boolean[] getPosibles() {
        return posibles;
    }

    public void setPosibles(boolean[] posibles) {
        this.posibles = posibles;
    }
}
