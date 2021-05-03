#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////
/*Figura Arco*/
typedef struct {
    Figure super;
    int w, h, start, extent, type;
} Arc;

void Arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) na posicao (%d,%d).\nSeu angulo inicial e sua extensao angular em (%d,%d) graus.\nSeu tipo eh %d.\n\n",
           this->w, this->h, sup->x, sup->y, this->start, this->extent, this->type);
}

Arc* arc_new (int x, int y, int w, int h, int start, int extent, int type) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Arc_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->start = start; 
    this->extent = extent; 
    this->type = type;
}

///////////////////////////////////////////////////////////////////////////////
/*Figura Curva Cubica*/
typedef struct {
    Figure super;
    int x2, y2, ctrlx, ctrly, ctrlx2, ctrly2;
} CubicCurve;

void CubicCurve_print (CubicCurve* this) {
    Figure* sup = (Figure*) this;
    printf("Curva cubica na posicao inicial(%d,%d) e na posicao final(%d,%d).\nPosicao do primeiro ponto de controle(%d,%d).\nPosicao do segundo ponto de controle(%d,%d).\n\n",
           sup->x, sup->y, this->x2, this->y2, this->ctrlx, this->ctrly, this->ctrlx2, this->ctrly2);
}

CubicCurve* cubic_new (int x, int y, int x2, int y2, int ctrlx, int ctrly, int ctrlx2, int ctrly2) {
    CubicCurve* this = malloc(sizeof(CubicCurve));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) CubicCurve_print;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
    this->ctrlx = ctrlx; 
    this->ctrly = ctrly; 
    this->ctrlx2 = ctrlx2;
    this->ctrly2 = ctrly2;
}

///////////////////////////////////////////////////////////////////////////////

int main () {
    Figure* figs[8] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) arc_new(210,110,305,130,90,270,3), // se o tipo for 3, será um arco com formato PIE
        (Figure*) cubic_new(20,20,40,40,125,131,100,105),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) arc_new(210,110,305,130,125,210,1), // se o tipo for 1, será um arco com formato CHORD
        (Figure*) cubic_new(20,20,40,40,125,131,100,105)
    };

    ///
    int i;
    for (i=0; i<8; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (i=0; i<8; i++) {
        free(figs[i]);
    }
    return 0;
}
