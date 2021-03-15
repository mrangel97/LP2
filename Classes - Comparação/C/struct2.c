#include <stdio.h>

typedef struct {
    float x;
    float y;
    float w;
    float h;
}Rect;

void print (Rect *r){
    printf("O retangulo possui as coordenadas x e y iguais a %.2f e %.2f . E a largura e altura iguais a %.2f e %.2f", r->x, r->y, r->w, r->h);
}

int main(){
    Rect r = {62.4, 191.7, 79.9, 62.5};
    print(&r);
}
