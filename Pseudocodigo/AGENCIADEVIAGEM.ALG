Algoritmo "AgenciadeViagem"
//  
//  
// Descrição   : Um programa para simular um cadastro para uma agência
// de viagens com as seguintes funções: cadastro de cliente e cadastro de destino,
// também uma consulta para cada estrutura de dados.
// Autor(a)    : Isaac Felipe dos Santos Lima
// Data atual  : 03/10/2023
Var
// Seção de Declarações das variáveis 
i, opcao, n: inteiro
  nome: vetor[1..100] de caracter
  cpf: vetor[1..100] de caracter
  destino: vetor[1..100] de caracter

Inicio
      Escreval ("_______Bem Vindo ao Menu da Agencia______________")
   escreval("1-para inserir nome do cliente")
   escreval("2-para visualizar clientes")
   escreval("3-para cadastrar destinos")
   escreval("4-para visualizar destinos")
   escreval("5-para sair")
   escreval("")

  enquanto opcao <> 5 faca
    leia(opcao)
    escolha opcao
      caso 1
        escreva("Informe a quantidade de clientes: ")
        leia(n)
        para i de 1 ate n faca
          escreva("Informe o nome do cliente: ")
          leia(nome[i])
          escreva("Informe o CPF do cliente: ")
          leia(cpf[i])
        fimpara
        limpatela
        escreval("")
        escreval("Clientes Cadastrados!!")
        escreval("")
        escreval("===================")
        escreval("Digite 1 para inserir nome do cliente")
        escreval("2-para visualizar clientes")
        escreval("3-para cadastrar destinos")
        escreval("4-para visualizar destinos")
        escreval("5-para sair")
        escreval("")
        escreval("===================")
      caso 2
        limpatela
        para i de 1 ate n faca
          escreval("Dados do Cliente")
          escreval("Nome: ", nome[i])
          escreval("CPF: ", cpf[i])
          escreval("")
          escreval("===================")
        fimpara
        escreval("Digite 1 para inserir nome do cliente")
        escreval("2-para visualizar clientes")
        escreval("3-para cadastrar destinos")
        escreval("4-para visualizar destinos")
        escreval("5-para sair")
        escreval("")
        escreval("===================")
      caso 3
        escreva("Informe quantidade do destino: ")
        leia(n)
        para i de 1 ate n faca
          escreva("Informe o nome do destino: ")
          leia(destino[i])
        fimpara
        limpatela
        escreval("")
        escreval("Destinos Cadastrados!!")
        escreval("")
        escreval("===================")
        escreval("Digite 1 para inserir nome do cliente")
        escreval("2-para visualizar clientes")
        escreval("3-para cadastrar destinos")
        escreval("4-para visualizar destinos")
        escreval("5-para sair")
        escreval("")
        escreval("===================")
      caso 4
        limpatela
        para i de 1 ate n faca
          escreval("Destinos Cadastrados")
          escreval("Nome do Destino: ", destino[i])
          escreval("")
          escreval("===================")
        fimpara
        escreval("Digite 1 para inserir nome do cliente")
        escreval("2-para visualizar clientes")
        escreval("3-para cadastrar destinos")
        escreval("4-para visualizar destinos")
        escreval("5-para sair")
        escreval("")
        escreval("===================")
      caso 5
        limpatela
        escreva("Encerrando! Obrigado por usar nosso sistema! ")
      outrocaso
        escreval("OPCAO INVALIDA! insira uma opção correta")
        escreval("")
        escreval("Digite 1 para inserir nome do cliente")
        escreval("2-para visualizar clientes")
        escreval("3-para cadastrar destinos")
        escreval("4-para visualizar destinos")
        escreval("5-para sair")
        escreval("")
        escreval("===================")
        
    fimescolha
  fimenquanto

Fimalgoritmo