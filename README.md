## BARALHO PERFEITO – IN-SHUFFLE

Alguns casinos, aplicam no seu software de jogo online uma técnica conhecida como o “baralho perfeito – inShuffle”. Esta técnica consiste, em primeiro lugar, em dividir um baralho de 52 cartas em duas metades de 26 cartas cada. De seguida, mistura-se as metades intercalando as cartas da seguinte forma: Começa-se com a metade superior e vai-se alternando as metades, pegado na carta inferior da metade e colocamo-la em cima de um novo “monte”. Por exemplo, se o nosso baralho original contém as seis cartas 1 2 3 4 5 6, a metade superior é 1 2 3, e a metade inferior é 4 5 6. O 3 na parte inferior da metade superior torna-se a carta inferior no baralho baralhado. Em seguida, colocamos o 6, que está na parte inferior da metade inferior, em cima do monte baralhado. Em seguida, colocamos 2 em cima, depois 5, 1, e finalmente 4. O novo baralho baralhado é então 4 1 5 2 6 3. Observe que a carta que estava no topo do baralho original está agora em segundo lugar no resultado baralhado, e a carta inferior no baralho original está agora em segundo lugar do fundo no baralho baralhado. Este processo de embaralhamento é chamado de “inshuffle” e é alcançado começando pela metade superior quando movemos as cartas para o resultado baralhado. Por outro lado, se começarmos com a metade inferior, obtemos um chamado “out-shuffle”, em que a metade superior original e a metade inferior permanecem nas suas posições no baralho baralhado. Defina uma classe de baralho de cartas para conter as cartas. A classe deve definir métodos para executar o baralho perfeito “in-shuffle” e perfeitos “out-shuffle”. Usando a classe criada, contrua um pequeno main que: 

 1. Partindo de um baralho inicial, obtenha o baralho perfeito
    “in-shuffle” e “out-shuffle”.
 2. Indique quantos “in-shuffles” perfeitos são necessários para
    voltar a obter um baralho de n cartas na sua ordem original.
 3.  Indique quantos “out-shuffles” perfeitos são necessários para
    voltar a obter um baralho de n cartas na sua ordem original?
 4.  Pode mover a metade superior de um baralho, que está na posição 0, para qualquer posição desejada m, realizando uma sequência de
    baralhados e “out-shuffles”, da seguinte forma.
    
    Escreve m em binário. Começando com o 1 mais à esquerda e indo para
    a direita, executa um “in-shuffle” para cada 1 encontrado e um
    “out-shuffle” para cada 0. Por exemplo, se m é 8, temos 1000 para o
    seu equivalente binário. Executaríamos um “in-shuffle” seguido por
    três “out-shuffles” para mover a metade superior original para a
    posição 8, ou seja, por isso é a nona carta do topo do baralho.
    Defina um método para executar este “truque” de cartas.
