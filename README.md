# ComplexidadeOperacoesFPAA
Exercício de complexidade da matéria de Fundamentos de Projetos e Análise de Algoritmos 

Enunciado:

Estudamos, durante as aulas da disciplina, como a complexidade de tempo (custo de execução) de um
algoritmo pode impactar o tempo para a obtenção de uma solução para um problema computacional.
O cálculo matemático da complexidade do algoritmo dá uma medida segura para compararmos
algoritmos e seus comportamentos.
Neste exercício, vamos comparar, na prática, as operações realizadas por dois algoritmos diferentes
para o mesmo problema: ordenação. Iremos, ainda, tentar perceber que, utilizando dados aleatórios,
a média das execuções tende para a média entre os melhores e piores casos.
A descrição completa das tarefas segue:
PRIMEIRA PARTE
a) Crie um método para gerar um vetor contendo 100.000 valores inteiros aleatórios, sem
repetição.
b) Crie uma cópia do vetor gerado em (a).
c) Utilize o método da bolha para ordenar o vetor original, contando quantas operações de
comparação de troca e quantas operações de comparação foram realizadas.
d) Utilize o método da seleção para ordenar o a cópia (b) do vetor, contando quantas
operações de comparação de troca e quantas operações de comparação foram realizadas.
e) Repita as operações de (a) até (d) 50 vezes e para este conjunto de testes, registre para cada
um dos dois algoritmos:
• Maior, menor e média da quantidade de comparações realizadas;
• Maior, menor e média da quantidade de trocas realizadas;
f) Criar uma tabela e um gráfico comparando os resultados dos dois algoritmos.
g) Analisar criticamente esta tabela, utilizando os conhecimentos que você tem sobre os
algoritmos.
SEGUNDA PARTE
a) Utilize um método similar ao da primeira parte para gerar um vetor contendo 10.000 valores
inteiros, iniciando em 1 e indo até 10.000 na ordem.
b) Sorteie um número entre 1 e 11.000 e faça a busca sequencial por este número no vetor,
registrando em qual posição ele foi encontrado (use a posição 10.001 caso ele não exista).
c) Repita os passos (a) e (b) 1 milhão de vezes.
d) Agrupe os resultados dos contadores de 500 em 500. Explicando: todos os contadores entre
1 e 500 devem ser somados, depois os de 501 a 1000 e assim por diante.
e) Faça um gráfico de barras com os resultados obtidos em (d) e comente o resultado.
Ressaltando: o documento a ser entregue deve iniciar com as especificações do equipamento e
depois, organizadamente e de forma completa, deve apresentar os testes e seus resultados. Tão
importante do quantos os testes são a organização do resultado, sua apresentação e seus
comentários.
