package br.com.fiap.model.dto;

/*
Felipe Ishii 565339
Vitória Rodrigues 565160
Rodrigo Carvalho 565162
Augusto Bonomo 565155
Nathanael Vieira 564990
 */

public class Filme {
    private int codigo;
    private String titulo;
    private String genero;
    private String produtora;

    public Filme () {}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
}
