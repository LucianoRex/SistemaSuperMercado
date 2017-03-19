/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author LucianoRex
 */
//@teste
public class Search {

    String colunas[];
    String condicao;
    String sql;

    public void montaCombo(ArrayList<String> nome) {
        for (int i = 0; i < nome.size(); i++) {

        }
    }

    public void campos(ArrayList campos) {
    }

    public void condicao(String condicao) {
        this.condicao = condicao;
    }

    public void sql(String sql) {
        System.out.println(sql);
        this.sql = sql;
    }

    public String montaSQl() {
        System.out.println(this.sql + this.condicao);
        return sql + this.condicao;
    }

    public String[] getColunas() {
        return colunas;
    }
}
