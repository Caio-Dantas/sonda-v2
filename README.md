# Projeto Sonda V2

## 1. Descrição

Projeto baseado no teste disponível [nesse link](https://gist.github.com/elo7-developer/1a40c96a5d062b69f02c). O aplicativo tenta solucionar o desafio do deslocamento de uma sonda em um determinado planalto.

## 2. Componentes

### 2.1 Torre de Controle

A Torre de Controle é nossa interface de uso, ela é responsável por administrar o planalto, as sondas presentes e suas movimentações. Toda execução relacionada desse passar por ela.

### 2.2 Planalto

Representação do solo do planeta a ser explorado. Conhece as posições ocupadas em seu solo, assim como as sondas que ocupam determinada posição. Isso é feito através de um HashMap que relaciona a posição (chave) com sua respectiva sonda (valor), isso também garante que não teremos duas sondas na mesma posição.

Figura ilustrativa do nosso planalto.

![map-pic](https://i.imgur.com/PnmBycp.png)

### 2.3 Sonda

A sonda possui funcionalidades relacionadas a rotação (mudança de direção) e de movimentação. As funcionalidades de movimentação da sonda se baseiam na posição atual e direção atual, com essas duas informações é possível prever a posição futura, ou seja a posição em que a sonda estará caso se movimente, a posição é achada através de:

```
posicaoFutura = posicaoAtual + deslocamento
```
Onde o deslocamento é definido através de sua direção:
```
deslocamento N = y++
deslocamento O = x++
deslocamento S = y--
deslocamento E = x--
```

### 2.4 Posicao

Classe que representa uma posição no nosso planalto, a classe também possui a funcionalidade de realizar o incremento de uma posição, ou seja:
```
posicaoFutura = (x:1, y:1).add(x:5,y:7)
posicaoFutura == (x:6, y:8) ✅
```
Além disso o método equals foi sobreposto para que tivéssemos o resultado desejado na comparação, onde desejamos comparar dois objetos pelo seu valor e não por sua referência.

### 2.4 Enum's

#### 2.4.1 Direcao

Enum responsável por representar os pontos cardeais para que seja possível determinar a direção da sonda, assim como o deslocamento associado a cada direção, assim como vimos em **2.3 Sonda**. Além disso também definimos quais são os respectivos pontos cadeais a direita e a esquerda (rotacões).

#### 2.4.2 Comando

Enum responsável por representar os possíveis comandos passados para nossa torre de controle, estes são:

```
comando L = Torre de Controle rotacione a sonda atual para esquerda
comando R = Torre de Controle rotacione a sonda atual para direita
comando M = Torre de Controle mova a sonda atual em relação a sua posição e direção atual
```

### 2.5 Utils

#### 2.5.1 Tradutor

Responsável por associar uma entrada do usuário com um comando ou direção correspondente.

#### 2.5.1 Printer

Responsável por tornar o print um método estático


