package br.com.poc.exception;

public class BackException extends RuntimeException {

    private static final long serialVersionUID = 3892011224682365401L;

    private Throwable erroThrowable;

    public BackException() {
    }

    public BackException(String msg) {
        super(msg);
    }

    public BackException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BackException(Throwable cause) {
        super(cause);
    }

    public Throwable getErroThrowable() {
        return erroThrowable;
    }

    public void setErroThrowable(Throwable erroThrowable) {
        this.erroThrowable = erroThrowable;
    }

}
