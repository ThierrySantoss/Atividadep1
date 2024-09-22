FuncionarioController

POST http://localhost:8080/consecionaria/funcionario - caminho para adicionar um novo funcionário.
campos:
  "nome" - não pode ser nulo ou “ ”.
  
  "dataNascimento" - não pode ser nulo, ano menor que 1930, diferença entre o ano da dataNascimento e ano Atual não pode ser menor que 14(fiz isso para não contratar uma pessoa menor que 14).
  
  "rg" - apenas números com 9 dígitos.
  
  "habilitacaoFuncionario" - pode ser A, B, C, D, E(pode colocar tb mais de um por exemplo A, B)


GET http://localhost:8080/consecionaria/funcionario - caminho para obter funcionário através do id.
campo:
  “id” - necessário passar o id do funcionário.

GET http://localhost:8080/consecionaria/funcionario/obterFuncionariosMesNaoPenalizacao - caminho para retorno os funcionários que não tem penalização em um determinado mês.
campo:
  “mes” - necessário passar o mês que deseja pesquisar (valor numérico).

GET http://localhost:8080/consecionaria/funcionario/obterFuncionarioPenalizacao - caminho para retornar todos os funcionários com penalização ativa.

PUT http://localhost:8080/consecionaria/funcionario - caminho para atribuir uma penalização ao funcionário.
campos:
  “id” - necessário passar o id do funcionário para identificar.
  
  “penalizacao” - pode ser RestricaoDeConducaoDeVeículo , RestricaoNaAreaDeJogos, PerdaDeAniversarioPremiado, ImpossibilidadeDeConducao.


VeiculoController

POST http://localhost:8080/consecionaria/veiculo - caminho para adicionar um novo carro.
campos:
  "modeloVeiculo" - não pode ser nulo ou “ “.
  
  "marcaDoVeiculo" - não pode ser nulo ou “ “.
  
  "categoriaDoVeiculo" - não pode ser nulo, pode ser MOTO, CARRO_PASSEIO, UTILITARIO, CAMINHAO.
  
  "anoDeFabricacaoDoVeiculo" - não pode ser nulo, deve conter 4 digitos numericos, ano não pode ser no futuro ou menor que 1900.
  
  "tipoCombustivelDoVeiculo" - não pode ser nulo, pode ser ALCOOL, GASOLINA, DIESEL, ELETRICO.
  
  "quantidadePassageirosDoVeiculo" - no minimo 1 e no máximo 50.
  
  "habilitacaoDoVeiculo" - pode ser A, B, C, D, E.
  
  "placaDoVeiculo" - não pode ser nulo ou “ “,  pode ser placas Mercosul (ABC1D23) ou placas Cinzas (ABC1023).
  
  "quilometragemDoVeiculo" não pode ser menor que 0.


GET  http://localhost:8080/consecionaria/veiculo/obterCarroPorAno - caminho para obter todos os veículos comprados em um determinado ano.

GET  http://localhost:8080/consecionaria/veiculo/obterCarroPorModelo - caminho para obter um veículo através de seu modelo.
campo:
  “modelo” - nome do modelo a ser pesquisado.

GET  http://localhost:8080/consecionaria/veiculo/obterCarrosComMaiorKm - caminho para obter os veículos com maior quilometragem.


FuncionarioVeiculoController

POST http://localhost:8080/consecionaria/funcionarioVeiculo - caminho para registrar uma saída do funcionário com um veiculo.
campos:
  “funcionario” - id do funcionario.
  
  “veiculo” - id do veiculo.
  
  Obs: O funcionário tem que ter habilitação necessária e não pode ter penalização ativa.


PUT http://localhost:8080/consecionaria/funcionarioVeiculo - caminho para registrar uma chegada do funcionario com um veiculo.
campos:
  “id” - id do registro de saida.
  
  “quilometragemDoVeiculo” - quilometragem do veículo ao chegar.
  
  Obs: A quilometragem do veículo deve ser maior do que a registrada antes de sua saída.


GET http://localhost:8080/consecionaria/funcionarioVeiculo - caminho para obter um registro de saida/chegada.
campos:
  “id” - id do registro que deseja obter.

GET http://localhost:8080/consecionaria/funcionarioVeiculo/FuncionarioQueMaisSaiu - caminho que mostra o funcionário que mais saiu com veículos.
