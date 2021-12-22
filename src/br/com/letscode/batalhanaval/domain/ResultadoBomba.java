package br.com.letscode.batalhanaval.domain;

public class ResultadoBomba {

    private String mensagem;
    private String resultado;

    public ResultadoBomba(String mensagem, String resultado) {
        this.mensagem = mensagem;
        this.resultado = resultado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getResultado() {
        return resultado;
    }
}
