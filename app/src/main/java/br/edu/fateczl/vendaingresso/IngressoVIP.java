package br.edu.fateczl.vendaingresso;

/*
 *@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043
 */

public class IngressoVIP extends Ingresso {
    private String funcaoComprador;

    public IngressoVIP(String codigoIdentificador, float valor, String funcaoComprador) {
        super(codigoIdentificador, valor);
        this.funcaoComprador = funcaoComprador;
    }

    @Override
    public float valorFinal(float taxaConveniencia) {
        float valorPadrao = super.valorFinal(taxaConveniencia);
        return valorPadrao * 1.18f; // -> Acrescenta 18% ao valor do ingresso VIP
    }

    public String getFuncaoComprador() {
        return funcaoComprador;
    }
}

