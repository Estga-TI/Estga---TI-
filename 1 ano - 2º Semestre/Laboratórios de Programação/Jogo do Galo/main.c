#include <stdio.h>
#include <stdlib.h>
#define ROWS 3
#define COLS 3

void iniciamatriz (int (*matriz) [COLS])
{
    int i, j;
    for(i=0; i<ROWS; i++)
    {
        for(j=0; j<COLS; j++)
        {
            *(*(matriz + i) + j) = -1;
        }
    }
}

void marcaposicao (int (*matriz) [COLS], int jogador, int specificRow, int specificCol)
{
        int i, j;
    for(i=0; i<ROWS; i++)
    {
        for(j=0; j<COLS; j++)
        {
            if(i == specificRow && j == specificCol)
            {
                *(*(matriz + i) + j) = jogador;
            }
        }
    }
}

void obtemCoord (int *coluna, int *linha)
{
    do{
        printf("Insira um numero - linha: ");
        scanf("%d", linha);
    }while(*linha !=0 && *linha !=1 && *linha !=2);

        do{
        printf("Insira um numero - colun a: ");
        scanf("%d", coluna);
    }while(*coluna !=0 && *coluna !=1 && *coluna !=2);
}

void imprimeMatriz (int (*matriz) [COLS])
{
    int i, j;
    for(i=0; i<ROWS; i++)
    {
        for(j=0; j<COLS; j++)
        {
            printf("[%d]", *(*(matriz + i) + j));
        }
        printf("\n");
    }
}

int verificaposicao (int (*matriz) [COLS], int specificRow, int specificCol)
{
    int i, j;
    for(i=0; i<ROWS; i++)
    {
        for(j=0; j<COLS; j++)
        {
            if(i == specificRow && j == specificCol)
            {
                if(*(*(matriz + i) + j) == -1)
                {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
    }
}

int verificavitoria (int (*matriz) [COLS], int jogador)
{
if( *(*matriz + 0) + 0 == jogador && *(*matriz + 0) + 1) == jogador && *(*matriz + 0) + 2) == jogador ){
    return 1;
    } else if (*(*matriz + 1) + 0) == jogador && *(*matriz + 1) + 1) == jogador && *(*matriz + 1) + 2) == jogador) {
    return 1;
    } else if (*(*matriz + 2) + 0) == jogador && *(*matriz + 2) + 1) == jogador && *(*matriz + 2) + 2) == jogador) {
    return 1;
    } else if (*(*matriz + 0) + 0) == jogador && *(*matriz + 1) + 0) == jogador && *(*matriz + 2) + 0) == jogador) {
    return 1;
    } else if (*(*matriz + 0) + 1) == jogador && *(*matriz + 1) + 1) == jogador && *(*matriz + 2) + 1) == jogador) {
    return 1;
    } else if (*(*matriz + 0) + 2) == jogador && *(*matriz + 1) + 2) == jogador && *(*matriz + 2) + 2) == jogador) {
    return 1;
    } else if (*(*matriz + 0) + 0) == jogador && *(*matriz + 1) + 1) == jogador && *(*matriz + 2) + 2) == jogador) {
    return 1;
    } else if (*(*matriz + 0) + 2) == jogador && *(*matriz + 1) + 1) == jogador && *(*matriz + 2) + 0) == jogador) {
    return 1;
    } else {
    return 0;
    }
}

int main()
{
    int i;
    int lin=0;
    int col=0;
    int jogador;
    int matriz[ROWS] [COLS];

    iniciamatriz(matriz);
    imprimeMatriz(matriz);

    for(i=0; i<9; i++)
    {
        printf("Jogador %d pode jogar:\n\n", jogador);

        do {
            obtemCoord(&col, &lin);
        } while (!verificaposicao (matriz, lin, col));

        marcaposicao (matriz, jogador, lin, col);
        imprimeMatriz(matriz);

        if(verificavitoria (matriz, jogador) == 1)
        {
            printf("Parabens, o jogador %d ganhou!", jogador);
        }
        else {
            if(jogador==1)
            {
                jogador=2;
            }
            else {
                jogador=1;
            }
        }
    }
    return 0;
}
