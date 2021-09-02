
package GestaoDeLoja;

import s_3_FT1603_Streams_II.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marisa Lanca
 */
public class Loja 
{
    public static void main(String[] args)
    {
        //dados
        int numOpcoes = 7;
        ArrayList<Produto> produtos =
                new ArrayList<Produto>();
        int escolha = 0;
        boolean sairPrograma = false;
        
        produtos = leFicheiro("loja.ser", produtos);
        
        do
        {
            numOpcoes = mostraMenu(numOpcoes);
            escolha = obtemEscolha(escolha,numOpcoes);
            sairPrograma = processaEscolha( escolha, produtos, numOpcoes,
                    sairPrograma);
        }
        while(!sairPrograma);
        despedida();        
    }
       
    //funcoes
    static int mostraMenu(int numOpcoes)
    {
        System.out.println();
        System.out.println("+****************************+");
        System.out.println("*     STAND 'SOBRE RODAS'    *");
        System.out.println("+****************************+");
        System.out.println("*                            *");
        System.out.println("+****************************+");
        System.out.println("*                            *");
        System.out.println("* 1 - Inserir Produto        *");
        System.out.println("* 2 - Listar Produtos        *");
        System.out.println("* 3 - Pesquisar Produto      *");
        System.out.println("* 4 - Registar Venda         *");
        System.out.println("* 5 - Registar Reposição     *");
        System.out.println("* 6 - Eliminar Produto       *");
        System.out.println("* 7 - Sair do Programa       *");
        System.out.println("*                            *");        
        System.out.println("+****************************+");  
        return numOpcoes;     
    }
    
    static int obtemEscolha( int escolha, int numOpcoes)
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Qual a sua escolha (1-" + numOpcoes + ")? ");
        escolha = teclado.nextInt();
        return escolha;   
    }
    
    static boolean processaEscolha( int escolha,
            ArrayList<Produto> produtos,int numOpcoes,
            boolean sairPrograma)
    {
        switch(escolha)
        {
            case 1:
                inserirProduto(produtos);
                guardaFicheiro("loja.ser", produtos);
                break;
            case 2:
                if(produtos.size() > 0)
                {
                    listarProdutos(produtos);
                }
                else
                {
                    System.out.println("Não existem carros!");
                }
                break;
            case 3:
                if(produtos.size() > 0)
                {
                    pesquisarProduto(produtos);
                }
                else
                {
                    System.out.println("Não existem carros!");
                }
                break;
            case 4:
                if(produtos.size() > 0)
                {
                    registarVenda(produtos);
                    guardaFicheiro("loja.ser", produtos);
                }
                else
                {
                    System.out.println("Não existem carros!");
                }
                break;
            case 5:
                if(produtos.size() > 0)
                {
                    registarReposicao(produtos);
                    guardaFicheiro("loja.ser", produtos);
                }
                else
                {
                    System.out.println("Não existem carros!");
                }
                break;
            case 6:
                if(produtos.size() > 0)
                {
                    eliminarProduto(produtos);
                    guardaFicheiro("loja.ser", produtos);
                }
                else
                {
                    System.out.println("Não existem carros!");
                }
                break;
            case 7:
                sairPrograma = sairDoPrograma(sairPrograma);
                break;
            default:
                escolhaInvalida(numOpcoes);
        }
        return sairPrograma;
    }
    
    static void inserirProduto(ArrayList<Produto> produtos)
    {
        System.out.println("\nInserção de carro");
        Produto produto = new Produto();
        produto.leTudoProduto();
        produto.mostraTudoProduto();
        produtos.add(produto);
        System.out.println("Carro inserido com sucesso!");
        pausa();  
    }
    
    static void listarProdutos(ArrayList<Produto> produtos)
    {
        System.out.println("\nListagem dos carros");
        for(int cProduto = 0; cProduto < produtos.size(); cProduto++)
        {
            System.out.println("-> Carro " + (cProduto + 1) + ": ");
            produtos.get(cProduto).mostraTudoProduto();            
        }
        pausa();
    }
    
    static void pesquisarProduto(ArrayList<Produto> produtos)
    {
        //dados
        int escolha = 0;
        boolean queroVoltar = false;
        int numOpcoes = 4;
        char operacao = '\0';
        
        System.out.println("\nPesquisa de carro");
        System.out.println();
        
        do
        {
            mostraSubMenu(numOpcoes);
            escolha = obtemEscolha(escolha,numOpcoes); 
            queroVoltar = processaEscolhaSub(escolha, produtos, numOpcoes, 
                    operacao,queroVoltar);            
        }
        while(!queroVoltar);
    }
    
    static void mostraSubMenu(int numOpcoes)
    {
        System.out.println("+*****************************+");
        System.out.println("*                             *");
        System.out.println("*    Pesquisa de Produto      *");
        System.out.println("*                             *");
        System.out.println("* 1 - Por posição de entrada  *");
        System.out.println("* 2 - Por código de produto   *");
        System.out.println("* 3 - Por marca               *");
        System.out.println("* 4 - Voltar ao menu anterior *");  
        System.out.println("*                             *");        
        System.out.println("+*****************************+");
        System.out.println();
    }
    
    static boolean processaEscolhaSub( int escolha, 
            ArrayList<Produto> produtos, int numOpcoes, 
                    char op, boolean queroVoltar)
    {
        int numProduto = produtos.size()+1;
        
        switch(escolha)
        {
            case 1:
                numProduto = pesquisarProdutoPos(produtos);
                break;
            case 2:
                numProduto = pesquisarProdutoCod(produtos);
                break;
            case 3:
                numProduto = pesquisarProdutoMarca(produtos);
                break;
            case 4:
                queroVoltar = voltarAoMenuAnterior(queroVoltar);
                break;
            default:
                escolhaInvalida(numOpcoes);
        }
        
        if ((op == 'E' || op == 'e') && (numProduto >= 0 && numProduto <
                produtos.size()))
        {
            Scanner teclado = new Scanner(System.in);
            char resposta = '\0';
            System.out.print("Tem a certeza que quer eliminar o carro "
            + (numProduto+1) + "?");
            resposta = teclado.nextLine().charAt(0);
            if (resposta == 'S' || resposta == 's')
            {
                produtos.remove(numProduto);
                System.out.println("O Carro foi eliminado.");
            }
        }
        return queroVoltar;
    }
    
    static int pesquisarProdutoPos(ArrayList<Produto> produtos)
    {
        Scanner teclado = new Scanner(System.in);
        int numProduto = 0;
        
        System.out.println("Pesquisa de Carros por posição");
        do
        {
            System.out.print("Qual é o número do carro que quer consultar"
                    + " (1-" + produtos.size() + ")? ");
            numProduto = teclado.nextInt();
            if (numProduto < 1 || numProduto > produtos.size())
            {
                System.out.println("Número do carro não existe!");
            }
        } while(numProduto < 1 || numProduto > produtos.size());
        
        produtos.get(numProduto-1).mostraTudoProduto();
        pausa();
        return (numProduto-1);
    }
    
    static int pesquisarProdutoCod(ArrayList<Produto> produtos)
    {
        Scanner teclado = new Scanner(System.in);
        int codCarro = 0, numProduto = 0;
        boolean encontrouProduto = false;
        
        System.out.println("\nPesquisa de Carros por código do carro");
        System.out.print("Qual é o código do carro que quer consultar?");
        codCarro = teclado.nextInt();
        
        for (int cProduto = 0; cProduto < produtos.size() && 
                !encontrouProduto; cProduto++)
        {
            if (codCarro == produtos.get(cProduto).getCodCarro())
            {
                encontrouProduto = true;
                produtos.get(cProduto).mostraTudoProduto();
                numProduto = cProduto;                
            }
            System.out.println();
        }
        pausa();
        if(encontrouProduto)
        {
            return (numProduto);
        }
        else
        {
            return (produtos.size()+1);
        }     
    }
    
    static int pesquisarProdutoMarca(ArrayList<Produto> produtos)
    {
        Scanner teclado = new Scanner(System.in);
        String marca = "";
        int numProduto = 0;
        boolean encontrouProduto = false;
        
        System.out.println("Pesquisa de Produtos por Marca");
        System.out.print("Qual é a Marca do carro que quer consultar?");
        marca = teclado.nextLine();
        
        for (int cProduto = 0; cProduto < produtos.size(); cProduto++)
        {
            if(marca.equalsIgnoreCase(produtos.get(cProduto).getMarca()))
            {
                encontrouProduto = true;
                produtos.get(cProduto).mostraTudoProduto();
                numProduto = cProduto; 
            }
            System.out.println();
        }
        pausa();
        if(encontrouProduto)
        {
            return (numProduto);
        }
        else
        {
            return (produtos.size()+1);
        } 
    }
    
    static boolean voltarAoMenuAnterior(boolean queroVoltar)
    {
        Scanner teclado = new Scanner(System.in);
        char resposta = '\0';
        System.out.print("Pretende regressar ao menu anterior(S/N)? ");
        resposta = teclado.nextLine().charAt(0);
        if(resposta == 'S' || resposta == 's')
        {
            queroVoltar = true;
        }
        return queroVoltar;
    }
    
    static void registarVenda(ArrayList<Produto> produtos)
    {
        Scanner teclado = new Scanner(System.in);
        int numProduto = 0, numUnidadesVend = 0;
        
        System.out.println("Registar venda");
        do
        {
            System.out.print("Qual é o número do carro que quer consultar"
                    + " (1-" + produtos.size() + ")? ");
            numProduto = teclado.nextInt();
            teclado.nextLine();
            if (numProduto < 1 || numProduto > produtos.size())
            {
                System.out.println("Número do carro não existe!");
            }
        } while(numProduto < 1 || numProduto > produtos.size());
        
        System.out.println();        
        produtos.get(numProduto-1).mostraTudoProduto();
        System.out.println(); 
        System.out.print("Quantas unidades foram vendidas? ");
        numUnidadesVend = teclado.nextInt();
        if ((produtos.get(numProduto-1).getNumUnidades()- numUnidadesVend) >= 0)
        {
            produtos.get(numProduto-1).setNumUnidades(
                produtos.get(numProduto-1).getNumUnidades()-numUnidadesVend);
            System.out.println();
            produtos.get(numProduto-1).mostraTudoProduto();
            System.out.println("Venda registada com sucesso!");
        }
        else
        {
            System.out.println("Não é possível vender mais unidades que"
                    + "as que existem em Stock!");
            System.out.println("Unidades em stock: " +
                    produtos.get(numProduto-1).getNumUnidades() + "!");
        }   
        pausa();        
    }
    
    static void registarReposicao(ArrayList<Produto> produtos)
    {
        Scanner teclado = new Scanner(System.in);
        int numProduto = 0, numUnidades = 0;
        
        System.out.println("Registar reposição");
        do
        {
            System.out.print("Qual é o número do carro que quer consultar"
                    + " (1-" + produtos.size() + ")? ");
            numProduto = teclado.nextInt();
            teclado.nextLine();
            if (numProduto < 1 || numProduto > produtos.size())
            {
                System.out.println("Número do carro não existe!");
            }
        } while(numProduto < 1 || numProduto > produtos.size());
        
        System.out.println();        
        produtos.get(numProduto-1).mostraTudoProduto();
        System.out.println(); 
        System.out.print("Quantas unidades foram repostas? ");
        numUnidades = teclado.nextInt();
        produtos.get(numProduto-1).setNumUnidades(
                produtos.get(numProduto-1).getNumUnidades()+numUnidades);
        System.out.println();
        produtos.get(numProduto-1).mostraTudoProduto();
        System.out.println("Reposição registada com sucesso!");
        pausa(); 
    }
    
    static void eliminarProduto(ArrayList<Produto> produtos)
    {
        int escolha = 0;
        boolean queroVoltar = false;
        int numOpcoes = 4;
        char operacao = 'E';
        
        System.out.println("\nEliminar produtos");
        System.out.println();
        
        do
        {
            mostraSubMenu(numOpcoes);
            escolha = obtemEscolha(escolha,numOpcoes); 
            queroVoltar = processaEscolhaSub(escolha, produtos, numOpcoes, 
                    operacao,queroVoltar);   
            
        } while(!queroVoltar);        
    }
    
    static boolean sairDoPrograma(boolean queroSair)
    {
        Scanner teclado = new Scanner(System.in);
        char resposta = '\0';
        
        System.out.print("Pretende sair do programa(S/N)? ");
        resposta = teclado.nextLine().charAt(0);
        if(resposta == 'S' || resposta == 's')
        {
            queroSair = true;
        }
        return queroSair;
    }
    
    static void escolhaInvalida(int numOpcoes)
    {
        System.out.println("Escolha inválida!");
        System.out.println("Apenas é possível escolher de 1 a " 
                + numOpcoes + "!");
        pausa();
    }
    
    static void pausa()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nPrima uma tecla para continuar...");
        teclado.nextLine();
    }
    
    static void despedida()
    {
        System.out.println("\nObrigado por usar o programa! Volte Sempre!!");
    }
    
    static void guardaFicheiro(String nomeFicheiro, 
            ArrayList<Produto> produtos)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(produtos);
            oos.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    static ArrayList<Produto> leFicheiro(String nomeFicheiro, 
            ArrayList<Produto> produtos)
    {
        try
        {
            FileInputStream fis = new FileInputStream(nomeFicheiro);
            ObjectInputStream ois = new ObjectInputStream(fis);
            produtos = (ArrayList<Produto>) ois.readObject();
            ois.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return produtos;        
    }    
}
