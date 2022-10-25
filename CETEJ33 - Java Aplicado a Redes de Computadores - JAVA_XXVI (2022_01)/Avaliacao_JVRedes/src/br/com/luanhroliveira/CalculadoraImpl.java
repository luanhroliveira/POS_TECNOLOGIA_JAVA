package br.com.luanhroliveira;

public class CalculadoraImpl extends
    java.rmi.server.UnicastRemoteObject implements Calculadora {

    public CalculadoraImpl() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public long add(long a, long b) throws java.rmi.RemoteException {
        return a + b;
    }

    @Override
    public long sub(long a, long b) throws java.rmi.RemoteException {
        return a - b;
    }

    @Override
    public long mul(long a, long b) throws java.rmi.RemoteException {
        return a * b;
    }

    @Override
    public long div(long a, long b) throws java.rmi.RemoteException {
        return a / b;
    }
}