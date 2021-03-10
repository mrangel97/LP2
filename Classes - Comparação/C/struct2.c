#include <stdio.h>

typedef struct {
    char canto[20];
    char traco[20];
}Rect;

void print (Rect *r){
    printf("Retangulo possui o canto %s e seu estilo de contorno eh a %s\n", r->canto, r->traco);
}

int main(){
    Rect r = {"arredondado", "opcao 3"};
    print(&r);
}
