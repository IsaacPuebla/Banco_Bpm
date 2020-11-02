package clases;

public class Cuentas {
    private int Hipoteca;
    private int Auto;
    private int salarioAxel;
    private int salarioRoxana;
    private int salarioBetsabe;
    private int salarioMatias;

    public Cuentas(){
        Hipoteca=1000000;
        Auto=500000;
        salarioAxel=750000;
        salarioRoxana=900000;
        salarioBetsabe=1000000;
        salarioMatias=500000;
    }
    public int getHipoteca(){
        return Hipoteca;
    }
    public int getAuto(){
        return Auto;
    }
    public int getSalarioAxel(){
        return salarioAxel;
    }
    public int getSalarioRoxana(){
        return salarioRoxana;
    }
    public int getSalarioBetsabe(){
        return salarioBetsabe;
    }
    public int getSalarioMatias(){
        return salarioMatias;
    }
}

