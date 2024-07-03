package br.com.alura.consultaFIPE.principal;

import br.com.alura.consultaFIPE.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoAPI consumo = new ConsumoAPI();

    public void exibeMenu(){
        var menu = """
                    *** OPÇÕES ***
                    Carro
                    Moto
                    Caminhão
                    
                    Digite uma das opções para consultar:
                """;

        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if(opcao.toLowerCase().contains("carr")){
             endereco = URL_BASE + "carros/marcas";
        } else if(opcao.toLowerCase().contains("mot")){
             endereco = URL_BASE + "motos/marcas";
        } else {
             endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

        var menu_modelos = "Agora, digite o código referente a marca que você deseja ver os modelos:";
        System.out.println(menu_modelos);
        var opcao_modelos = endereco + "/" + leitura.nextLine() + "/modelos";
        var json_modelos = consumo.obterDados(opcao_modelos);
        System.out.println(json_modelos);

        var menu_anos = "Agora, digite o código referente ao ano do modelo:";
        System.out.println(menu_anos);
        var opcao_anos = opcao_modelos + "/" + leitura.nextLine() + "/anos";
        var json_anos = consumo.obterDados(opcao_anos);
        System.out.println(json_anos);

        var menu_final = "Para finalizar, digite o código referente ao ano selecionado:";
        var opcao_final = opcao_anos + "/" + leitura.nextLine();
        var json_final = consumo.obterDados(opcao_final);
        System.out.println(json_final);
    }
}
