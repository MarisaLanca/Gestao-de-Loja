package GestaoDeLoja;

import s_3_FT1603_Streams_II.*;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Marisa Lanca
 */
public class Produto implements Serializable
{
    //Dados
    private int codCarro;
    private String marca;
    private String modelo;    
    private double preco; 
    private int numUnidades;    
    
    //Construtores
    //sem argumentos:
    Produto()
    {
       codCarro = 0;
       marca = "";
       modelo = "";
       preco = 0;
       numUnidades = 0;
    }
    
    //com um argumento
    Produto(int codCar)
    {
       codCarro = codCar;
       marca = "";
       modelo = "";
       preco = 0;  
       numUnidades = 0;
    }
    
    //com dois argumentos
    Produto(int codCar, String marc)
    {
       codCarro = codCar;
       marca = marc;
       modelo = "";
       preco = 0; 
       numUnidades = 0;
    }
    
    //com quatro argumentos
    Produto(int codCar, String marc, String mod, double prc)
    {
       codCarro = codCar;
       marca = marc;
       modelo = mod;
       preco = prc;
       numUnidades = 0;
    }
    
    //com todos os argumentos
    Produto(int codCar, String marc, String mod, double prc,
            int numUni)
    {
        codCarro = codCar;
        marca = marc;
        modelo = "";
        preco = prc;
        numUnidades = numUni;
    }
    
    //Setter
    void setCodCarro(int codCar)
    {
        codCarro = codCar;
    }
    
    void setMarca(String marc)
    {
        marca = marc;
    }
    
    void setModelo(String mod)
    {
        modelo = mod;
    }
    
    void setPreco (double prc)
    {
        preco = prc;
    }
    
    void setNumUnidades(int numUni)
    {
        numUnidades = numUni;
    }
    
    //getters
    int getCodCarro()
    {
        return codCarro;
    }

    String getMarca()
    {
        return marca;
    }
    
    String getModelo()
    {
        return modelo;
    }

    double getPreco()
    {
        return preco;
    }

    int getNumUnidades()
    {
        return numUnidades;
    }
    
    //leitura
    void leCodCarro()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Insira o c??digo do carro: ");
        this.setCodCarro(teclado.nextInt());
        teclado.nextLine();
    }
    
    void leMarca()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Insira a marca do carro: ");
        this.setMarca(teclado.nextLine());        
    } 
    
    void leModelo()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Insira o modelo do carro: ");
        this.setModelo(teclado.nextLine());        
    }
           
    void lePreco()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Insira o pre??o por carro S/IVA: ");
        this.setPreco(teclado.nextDouble());
        teclado.nextLine();
    }
    
    void leNumUnidades()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Insira o n??mero de unidades do carro: ");
        this.setNumUnidades(teclado.nextInt());
        teclado.nextLine();
    }
     
    void leTudoProduto()
    {
        System.out.println("\n" + "Recolha dos dados do carro" + "\n");
        leCodCarro();
        leMarca();   
        leModelo();
        lePreco();
        leNumUnidades();
    }
    
    //escrita de dados
    public void mostraCodCarro()
    {
        System.out.println("C??digo do carro: " + 
                this.getCodCarro());
    }
    
    public void mostraMarca()
    {
        System.out.println("Marca do carro: " + 
                this.getMarca());
    }
    
    public void mostraModelo()
    {
        System.out.println("Modelo do carro: " + 
                this.getModelo());
    }
    
    public void mostraPreco()
    {
        double precoCIVA = 0;
        System.out.println("Pre??o do carro S/IVA: " + 
                this.getPreco() + " euro(s)");
        precoCIVA = precoComIVA(this.getPreco());
        System.out.println("Pre??o do carro C/IVA: " + 
                precoCIVA + " euro(s)");
    }
    
    public void mostraNumUnidades()
    {
        System.out.println("N??mero de unidades do carro: " + 
                this.getNumUnidades());
    }
    
    void mostraTudoProduto()
    {
        System.out.println("\n" + "Dados de um Produto:" );
        mostraCodCarro();
        mostraMarca();
        mostraModelo();
        mostraPreco();
        mostraNumUnidades();
    }
    
    //outras funcoes
    void pausa()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Prima uma tecla para continuar...");
        teclado.nextLine();
    }
     
    public double precoComIVA(double preco)
    {
        double precociva = preco + (preco * 0.23);        
        return (precociva);
    }
}


