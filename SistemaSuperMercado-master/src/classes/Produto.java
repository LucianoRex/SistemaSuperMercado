/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.Objects;

/**
 *
 * @author LucianoRex
 */
//@teste
public class Produto {

    String uf = "";
    String cidade = "";
    String bairro = "";
    String rua = "";
    String numero = "";
    String complemento = "";
    String cep = "";

//    Endereco(String uf, String cidade, String bairro, String rua,String numero,String complemento) {
//        this.uf = uf;
//        this.cidade = cidade;
//        this.bairro = bairro;
//        this.rua = rua;
//        this.numero = numero;
//        this.complemento = complemento;
//    }


    public Produto(String uf, String cidade, String bairro, String rua, String numero, String complemento, String cep) {
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep=cep;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    

   

    

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 89 * hash + Objects.hashCode(this.nome);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Endereco other = (Endereco) obj;
//        if (!Objects.equals(this.nome, other.nome)) {
//            return false;
//        }
//        return true;
//    }

}


